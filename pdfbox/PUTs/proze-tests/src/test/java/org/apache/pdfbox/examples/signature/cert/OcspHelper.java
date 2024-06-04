/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.examples.signature.cert;
import java.io.IOException;
import org.bouncycastle.cert.ocsp.OCSPException;
/**
 * Helper Class for OCSP-Operations with bouncy castle.
 *
 * @author Alexis Suter
 */
public class OcspHelper {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(OcspHelper.class);

    private final java.security.cert.X509Certificate issuerCertificate;

    private final java.util.Date signDate;

    private final java.security.cert.X509Certificate certificateToCheck;

    private final java.util.Set<java.security.cert.X509Certificate> additionalCerts;

    private final String ocspUrl;

    private org.bouncycastle.asn1.DEROctetString encodedNonce;

    private java.security.cert.X509Certificate ocspResponderCertificate;

    private final org.bouncycastle.cert.jcajce.JcaX509CertificateConverter certificateConverter = new org.bouncycastle.cert.jcajce.JcaX509CertificateConverter();

    // SecureRandom.getInstanceStrong() would be better, but sometimes blocks on Linux
    private static final java.util.Random RANDOM = new java.security.SecureRandom();

    /**
     *
     * @param checkCertificate
     * 		Certificate to be OCSP-checked
     * @param signDate
     * 		the date when the signing took place
     * @param issuerCertificate
     * 		Certificate of the issuer
     * @param additionalCerts
     * 		Set of trusted root CA certificates that will be used as "trust
     * 		anchors" and intermediate CA certificates that will be used as part of the certification
     * 		chain. All self-signed certificates are considered to be trusted root CA certificates. All
     * 		the rest are considered to be intermediate CA certificates.
     * @param ocspUrl
     * 		where to fetch for OCSP
     */
    public OcspHelper(java.security.cert.X509Certificate checkCertificate, java.util.Date signDate, java.security.cert.X509Certificate issuerCertificate, java.util.Set<java.security.cert.X509Certificate> additionalCerts, String ocspUrl) {
        this.certificateToCheck = checkCertificate;
        this.signDate = signDate;
        this.issuerCertificate = issuerCertificate;
        this.additionalCerts = additionalCerts;
        this.ocspUrl = ocspUrl;
    }

    /**
     * Get the certificate to be OCSP-checked.
     *
     * @return The certificate to be OCSP-checked.
     */
    java.security.cert.X509Certificate getCertificateToCheck() {
        return certificateToCheck;
    }

    /**
     * Performs and verifies the OCSP-Request
     *
     * @return the OCSPResp, when the request was successful, else a corresponding exception will be
    thrown. Never returns null.
     * @throws IOException
     * @throws OCSPException
     * @throws RevokedCertificateException
     */
    public org.bouncycastle.cert.ocsp.OCSPResp getResponseOcsp() throws IOException, OCSPException, RevokedCertificateException {
        org.bouncycastle.cert.ocsp.OCSPResp ocspResponse = performRequest();
        verifyOcspResponse(ocspResponse);
        return ocspResponse;
    }

    /**
     * Get responder certificate. This is available after {@link #getResponseOcsp()} has been
     * called. This method should be used instead of {@code basicResponse.getCerts()[0]}
     *
     * @return The certificate of the responder.
     */
    public java.security.cert.X509Certificate getOcspResponderCertificate() {
        return ocspResponderCertificate;
    }

    /**
     * Verifies the status and the response itself (including nonce), but not the signature.
     *
     * @param ocspResponse
     * 		to be verified
     * @throws OCSPException
     * @throws RevokedCertificateException
     * @throws IOException
     * 		if the default security provider can't be instantiated
     */
    private void verifyOcspResponse(org.bouncycastle.cert.ocsp.OCSPResp ocspResponse) throws OCSPException, RevokedCertificateException, IOException {
        verifyRespStatus(ocspResponse);
        org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse = ((org.bouncycastle.cert.ocsp.BasicOCSPResp) (ocspResponse.getResponseObject()));
        if (basicResponse != null) {
            org.bouncycastle.asn1.ocsp.ResponderID responderID = basicResponse.getResponderId().toASN1Primitive();
            // https://tools.ietf.org/html/rfc6960#section-4.2.2.3
            // The basic response type contains:
            // (...)
            // either the name of the responder or a hash of the responder's
            // public key as the ResponderID
            // (...)
            // The responder MAY include certificates in the certs field of
            // BasicOCSPResponse that help the OCSP client verify the responder's
            // signature.
            org.bouncycastle.asn1.x500.X500Name name = responderID.getName();
            if (name != null) {
                findResponderCertificateByName(basicResponse, name);
            } else {
                byte[] keyHash = responderID.getKeyHash();
                if (keyHash != null) {
                    findResponderCertificateByKeyHash(basicResponse, keyHash);
                } else {
                    throw new OCSPException("OCSP: basic response must provide name or key hash");
                }
            }
            if (ocspResponderCertificate == null) {
                throw new OCSPException(("OCSP: certificate for responder " + name) + " not found");
            }
            try {
                org.apache.pdfbox.examples.signature.SigUtils.checkResponderCertificateUsage(ocspResponderCertificate);
            } catch (java.security.cert.CertificateParsingException ex) {
                // unlikely to happen because the certificate existed as an object
                OcspHelper.LOG.error(ex, ex);
            }
            checkOcspSignature(ocspResponderCertificate, basicResponse);
            boolean nonceChecked = checkNonce(basicResponse);
            org.bouncycastle.cert.ocsp.SingleResp[] responses = basicResponse.getResponses();
            if (responses.length != 1) {
                throw new OCSPException(("OCSP: Received " + responses.length) + " responses instead of 1!");
            }
            org.bouncycastle.cert.ocsp.SingleResp resp = responses[0];
            Object status = resp.getCertStatus();
            if (!nonceChecked) {
                // https://tools.ietf.org/html/rfc5019
                // fall back to validating the OCSPResponse based on time
                checkOcspResponseFresh(resp);
            }
            if (status instanceof org.bouncycastle.cert.ocsp.RevokedStatus) {
                org.bouncycastle.cert.ocsp.RevokedStatus revokedStatus = ((org.bouncycastle.cert.ocsp.RevokedStatus) (status));
                if (revokedStatus.getRevocationTime().compareTo(signDate) <= 0) {
                    throw new RevokedCertificateException("OCSP: Certificate is revoked since " + revokedStatus.getRevocationTime(), revokedStatus.getRevocationTime());
                }
                OcspHelper.LOG.info((("The certificate was revoked after signing by OCSP " + ocspUrl) + " on ") + revokedStatus.getRevocationTime());
            } else if (status != org.bouncycastle.cert.ocsp.CertificateStatus.GOOD) {
                throw new OCSPException("OCSP: Status of Cert is unknown");
            }
        }
    }

    private byte[] getKeyHashFromCertHolder(org.bouncycastle.cert.X509CertificateHolder certHolder) throws IOException {
        // https://tools.ietf.org/html/rfc2560#section-4.2.1
        // KeyHash ::= OCTET STRING -- SHA-1 hash of responder's public key
        // -- (i.e., the SHA-1 hash of the value of the
        // -- BIT STRING subjectPublicKey [excluding
        // -- the tag, length, and number of unused
        // -- bits] in the responder's certificate)
        // code below inspired by org.bouncycastle.cert.ocsp.CertificateID.createCertID()
        // tested with SO52757037-Signed3-OCSP-with-KeyHash.pdf
        org.bouncycastle.asn1.x509.SubjectPublicKeyInfo info = certHolder.getSubjectPublicKeyInfo();
        try {
            return java.security.MessageDigest.getInstance("SHA-1").digest(info.getPublicKeyData().getBytes());
        } catch (java.security.NoSuchAlgorithmException ex) {
            // should not happen
            OcspHelper.LOG.error("SHA-1 Algorithm not found", ex);
            return new byte[0];
        }
    }

    private void findResponderCertificateByKeyHash(org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse, byte[] keyHash) throws IOException {
        org.bouncycastle.cert.X509CertificateHolder[] certHolders = basicResponse.getCerts();
        for (org.bouncycastle.cert.X509CertificateHolder certHolder : certHolders) {
            byte[] digest = getKeyHashFromCertHolder(certHolder);
            if (java.util.Arrays.equals(keyHash, digest)) {
                try {
                    ocspResponderCertificate = certificateConverter.getCertificate(certHolder);
                    return;
                } catch (java.security.cert.CertificateException ex) {
                    // unlikely to happen because the certificate existed as an object
                    OcspHelper.LOG.error(ex, ex);
                }
                break;
            }
        }
        // DO NOT use the certificate found in additionalCerts first. One file had a
        // responder certificate in the PDF itself with SHA1withRSA algorithm, but
        // the responder delivered a different (newer, more secure) certificate
        // with SHA256withRSA (tried with QV_RCA1_RCA3_CPCPS_V4_11.pdf)
        // https://www.quovadisglobal.com/~/media/Files/Repository/QV_RCA1_RCA3_CPCPS_V4_11.ashx
        for (java.security.cert.X509Certificate cert : additionalCerts) {
            try {
                byte[] digest = getKeyHashFromCertHolder(new org.bouncycastle.cert.X509CertificateHolder(cert.getEncoded()));
                if (java.util.Arrays.equals(keyHash, digest)) {
                    ocspResponderCertificate = cert;
                    return;
                }
            } catch (java.security.cert.CertificateEncodingException ex) {
                // unlikely to happen because the certificate existed as an object
                OcspHelper.LOG.error(ex, ex);
            }
        }
    }

    private void findResponderCertificateByName(org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse, org.bouncycastle.asn1.x500.X500Name name) {
        org.bouncycastle.cert.X509CertificateHolder[] certHolders = basicResponse.getCerts();
        for (org.bouncycastle.cert.X509CertificateHolder certHolder : certHolders) {
            if (name.equals(certHolder.getSubject())) {
                try {
                    ocspResponderCertificate = certificateConverter.getCertificate(certHolder);
                    return;
                } catch (java.security.cert.CertificateException ex) {
                    // unlikely to happen because the certificate existed as an object
                    OcspHelper.LOG.error(ex, ex);
                }
            }
        }
        // DO NOT use the certificate found in additionalCerts first. One file had a
        // responder certificate in the PDF itself with SHA1withRSA algorithm, but
        // the responder delivered a different (newer, more secure) certificate
        // with SHA256withRSA (tried with QV_RCA1_RCA3_CPCPS_V4_11.pdf)
        // https://www.quovadisglobal.com/~/media/Files/Repository/QV_RCA1_RCA3_CPCPS_V4_11.ashx
        for (java.security.cert.X509Certificate cert : additionalCerts) {
            org.bouncycastle.asn1.x500.X500Name certSubjectName = new org.bouncycastle.asn1.x500.X500Name(cert.getSubjectX500Principal().getName());
            if (certSubjectName.equals(name)) {
                ocspResponderCertificate = cert;
                return;
            }
        }
    }

    private void checkOcspResponseFresh(org.bouncycastle.cert.ocsp.SingleResp resp) throws OCSPException {
        // https://tools.ietf.org/html/rfc5019
        // Clients MUST check for the existence of the nextUpdate field and MUST
        // ensure the current time, expressed in GMT time as described in
        // Section 2.2.4, falls between the thisUpdate and nextUpdate times.  If
        // the nextUpdate field is absent, the client MUST reject the response.
        java.util.Date curDate = java.util.Calendar.getInstance().getTime();
        java.util.Date thisUpdate = resp.getThisUpdate();
        if (thisUpdate == null) {
            throw new OCSPException("OCSP: thisUpdate field is missing in response (RFC 5019 2.2.4.)");
        }
        java.util.Date nextUpdate = resp.getNextUpdate();
        if (nextUpdate == null) {
            throw new OCSPException("OCSP: nextUpdate field is missing in response (RFC 5019 2.2.4.)");
        }
        if (curDate.compareTo(thisUpdate) < 0) {
            OcspHelper.LOG.error((curDate + " < ") + thisUpdate);
            throw new OCSPException("OCSP: current date < thisUpdate field (RFC 5019 2.2.4.)");
        }
        if (curDate.compareTo(nextUpdate) > 0) {
            OcspHelper.LOG.error((curDate + " > ") + nextUpdate);
            throw new OCSPException("OCSP: current date > nextUpdate field (RFC 5019 2.2.4.)");
        }
        OcspHelper.LOG.info("OCSP response is fresh");
    }

    /**
     * Checks whether the OCSP response is signed by the given certificate.
     *
     * @param certificate
     * 		the certificate to check the signature
     * @param basicResponse
     * 		OCSP response containing the signature
     * @throws OCSPException
     * 		when the signature is invalid or could not be checked
     * @throws IOException
     * 		if the default security provider can't be instantiated
     */
    private void checkOcspSignature(java.security.cert.X509Certificate certificate, org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse) throws OCSPException, IOException {
        try {
            org.bouncycastle.operator.ContentVerifierProvider verifier = new org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder().setProvider(org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider()).build(certificate);
            if (!basicResponse.isSignatureValid(verifier)) {
                throw new OCSPException("OCSP-Signature is not valid!");
            }
        } catch (org.bouncycastle.operator.OperatorCreationException e) {
            throw new OCSPException("Error checking Ocsp-Signature", e);
        }
    }

    /**
     * Checks if the nonce in the response matches.
     *
     * @param basicResponse
     * 		Response to be checked
     * @return true if the nonce is present and matches, false if nonce is missing.
     * @throws OCSPException
     * 		if the nonce is different
     */
    private boolean checkNonce(org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse) throws OCSPException {
        org.bouncycastle.asn1.x509.Extension nonceExt = basicResponse.getExtension(org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_nonce);
        if (nonceExt != null) {
            org.bouncycastle.asn1.DEROctetString responseNonceString = ((org.bouncycastle.asn1.DEROctetString) (nonceExt.getExtnValue()));
            if (!responseNonceString.equals(encodedNonce)) {
                throw new OCSPException("Different nonce found in response!");
            } else {
                OcspHelper.LOG.info("Nonce is good");
                return true;
            }
        }
        // https://tools.ietf.org/html/rfc5019
        // Clients that opt to include a nonce in the
        // request SHOULD NOT reject a corresponding OCSPResponse solely on the
        // basis of the nonexistent expected nonce, but MUST fall back to
        // validating the OCSPResponse based on time.
        return false;
    }

    /**
     * Performs the OCSP-Request, with given data.
     *
     * @return the OCSPResp, that has been fetched from the ocspUrl
     * @throws IOException
     * @throws OCSPException
     */
    private org.bouncycastle.cert.ocsp.OCSPResp performRequest() throws IOException, OCSPException {
        org.bouncycastle.cert.ocsp.OCSPReq request = generateOCSPRequest();
        java.net.URL url = new java.net.URL(ocspUrl);
        java.net.HttpURLConnection httpConnection = ((java.net.HttpURLConnection) (url.openConnection()));
        try {
            httpConnection.setRequestProperty("Content-Type", "application/ocsp-request");
            httpConnection.setRequestProperty("Accept", "application/ocsp-response");
            httpConnection.setDoOutput(true);
            java.io.OutputStream out = httpConnection.getOutputStream();
            try {
                out.write(request.getEncoded());
            } finally {
                org.apache.pdfbox.io.IOUtils.closeQuietly(out);
            }
            if (httpConnection.getResponseCode() != 200) {
                throw new IOException("OCSP: Could not access url, ResponseCode: " + httpConnection.getResponseCode());
            }
            // Get response
            java.io.InputStream in = ((java.io.InputStream) (httpConnection.getContent()));
            try {
                return new org.bouncycastle.cert.ocsp.OCSPResp(in);
            } finally {
                org.apache.pdfbox.io.IOUtils.closeQuietly(in);
            }
        } finally {
            httpConnection.disconnect();
        }
    }

    /**
     * Helper method to verify response status.
     *
     * @param resp
     * 		OCSP response
     * @throws OCSPException
     * 		if the response status is not ok
     */
    public void verifyRespStatus(org.bouncycastle.cert.ocsp.OCSPResp resp) throws OCSPException {
        String statusInfo = "";
        if (resp != null) {
            int status = resp.getStatus();
            switch (status) {
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.INTERNAL_ERROR :
                    statusInfo = "INTERNAL_ERROR";
                    OcspHelper.LOG.error("An internal error occurred in the OCSP Server!");
                    break;
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.MALFORMED_REQUEST :
                    // This happened when the "critical" flag was used for extensions
                    // on a responder known by the committer of this comment.
                    statusInfo = "MALFORMED_REQUEST";
                    OcspHelper.LOG.error("Your request did not fit the RFC 2560 syntax!");
                    break;
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.SIG_REQUIRED :
                    statusInfo = "SIG_REQUIRED";
                    OcspHelper.LOG.error("Your request was not signed!");
                    break;
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.TRY_LATER :
                    statusInfo = "TRY_LATER";
                    OcspHelper.LOG.error("The server was too busy to answer you!");
                    break;
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.UNAUTHORIZED :
                    statusInfo = "UNAUTHORIZED";
                    OcspHelper.LOG.error("The server could not authenticate you!");
                    break;
                case org.bouncycastle.asn1.ocsp.OCSPResponseStatus.SUCCESSFUL :
                    break;
                default :
                    statusInfo = "UNKNOWN";
                    OcspHelper.LOG.error("Unknown OCSPResponse status code! " + status);
            }
        }
        if ((resp == null) || (resp.getStatus() != org.bouncycastle.asn1.ocsp.OCSPResponseStatus.SUCCESSFUL)) {
            throw new OCSPException("OCSP response unsuccessful, status: " + statusInfo);
        }
    }

    /**
     * Generates an OCSP request and generates the <code>CertificateID</code>.
     *
     * @return OCSP request, ready to fetch data
     * @throws OCSPException
     * @throws IOException
     */
    private org.bouncycastle.cert.ocsp.OCSPReq generateOCSPRequest() throws OCSPException, IOException {
        java.security.Security.addProvider(org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider());
        // Generate the ID for the certificate we are looking for
        org.bouncycastle.cert.ocsp.CertificateID certId;
        try {
            certId = new org.bouncycastle.cert.ocsp.CertificateID(new SHA1DigestCalculator(), new org.bouncycastle.cert.jcajce.JcaX509CertificateHolder(issuerCertificate), certificateToCheck.getSerialNumber());
        } catch (java.security.cert.CertificateEncodingException e) {
            throw new IOException("Error creating CertificateID with the Certificate encoding", e);
        }
        // https://tools.ietf.org/html/rfc2560#section-4.1.2
        // Support for any specific extension is OPTIONAL. The critical flag
        // SHOULD NOT be set for any of them.
        org.bouncycastle.asn1.x509.Extension responseExtension = new org.bouncycastle.asn1.x509.Extension(org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_response, false, new org.bouncycastle.asn1.DLSequence(org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_basic).getEncoded());
        encodedNonce = new org.bouncycastle.asn1.DEROctetString(new org.bouncycastle.asn1.DEROctetString(create16BytesNonce()));
        org.bouncycastle.asn1.x509.Extension nonceExtension = new org.bouncycastle.asn1.x509.Extension(org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_nonce, false, encodedNonce);
        org.bouncycastle.cert.ocsp.OCSPReqBuilder builder = new org.bouncycastle.cert.ocsp.OCSPReqBuilder();
        builder.setRequestExtensions(new org.bouncycastle.asn1.x509.Extensions(new org.bouncycastle.asn1.x509.Extension[]{ responseExtension, nonceExtension }));
        builder.addRequest(certId);
        return builder.build();
    }

    private byte[] create16BytesNonce() {
        byte[] nonce = new byte[16];
        OcspHelper.RANDOM.nextBytes(nonce);
        return nonce;
    }

    /**
     * Class to create SHA-1 Digest, used for creation of CertificateID.
     */
    private static class SHA1DigestCalculator implements org.bouncycastle.operator.DigestCalculator {
        private final java.io.ByteArrayOutputStream bOut = new java.io.ByteArrayOutputStream();

        @Override
        public org.bouncycastle.asn1.x509.AlgorithmIdentifier getAlgorithmIdentifier() {
            return new org.bouncycastle.asn1.x509.AlgorithmIdentifier(org.bouncycastle.asn1.oiw.OIWObjectIdentifiers.idSHA1);
        }

        @Override
        public java.io.OutputStream getOutputStream() {
            return bOut;
        }

        @Override
        public byte[] getDigest() {
            byte[] bytes = bOut.toByteArray();
            bOut.reset();
            try {
                java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
                return md.digest(bytes);
            } catch (java.security.NoSuchAlgorithmException ex) {
                // should not happen
                OcspHelper.LOG.error("SHA-1 Algorithm not found", ex);
                return new byte[0];
            }
        }
    }
}