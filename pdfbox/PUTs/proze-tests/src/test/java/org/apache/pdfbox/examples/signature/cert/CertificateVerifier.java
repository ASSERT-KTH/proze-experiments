/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pdfbox.examples.signature.cert;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.bouncycastle.cert.ocsp.OCSPException;
/**
 * Copied from Apache CXF 2.4.9, initial version:
 * https://svn.apache.org/repos/asf/cxf/tags/cxf-2.4.9/distribution/src/main/release/samples/sts_issue_operation/src/main/java/demo/sts/provider/cert/
 */
public final class CertificateVerifier {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(CertificateVerifier.class);

    private CertificateVerifier() {
    }

    /**
     * Attempts to build a certification chain for given certificate and to
     * verify it. Relies on a set of root CA certificates and intermediate
     * certificates that will be used for building the certification chain. The
     * verification process assumes that all self-signed certificates in the set
     * are trusted root CA certificates and all other certificates in the set
     * are intermediate certificates.
     *
     * @param cert
     * 		- certificate for validation
     * @param additionalCerts
     * 		- set of trusted root CA certificates that will be
     * 		used as "trust anchors" and intermediate CA certificates that will be
     * 		used as part of the certification chain. All self-signed certificates are
     * 		considered to be trusted root CA certificates. All the rest are
     * 		considered to be intermediate CA certificates.
     * @param verifySelfSignedCert
     * 		true if a self-signed certificate is accepted, false if not.
     * @param signDate
     * 		the date when the signing took place
     * @return the certification chain (if verification is successful)
     * @throws CertificateVerificationException
     * 		- if the certification is not
     * 		successful (e.g. certification path cannot be built or some certificate
     * 		in the chain is expired or CRL checks are failed)
     */
    public static java.security.cert.PKIXCertPathBuilderResult verifyCertificate(java.security.cert.X509Certificate cert, java.util.Set<java.security.cert.X509Certificate> additionalCerts, boolean verifySelfSignedCert, java.util.Date signDate) throws CertificateVerificationException {
        try {
            // Check for self-signed certificate
            if ((!verifySelfSignedCert) && CertificateVerifier.isSelfSigned(cert)) {
                throw new CertificateVerificationException("The certificate is self-signed.");
            }
            java.util.Set<java.security.cert.X509Certificate> certSet = new java.util.HashSet<java.security.cert.X509Certificate>(additionalCerts);
            // Download extra certificates. However, each downloaded certificate can lead to
            // more extra certificates, e.g. with the file from PDFBOX-4091, which has
            // an incomplete chain.
            // You can skip this block if you know that the certificate chain is complete
            java.util.Set<java.security.cert.X509Certificate> certsToTrySet = new java.util.HashSet<java.security.cert.X509Certificate>();
            certsToTrySet.add(cert);
            certsToTrySet.addAll(additionalCerts);
            int downloadSize = 0;
            while (!certsToTrySet.isEmpty()) {
                java.util.Set<java.security.cert.X509Certificate> nextCertsToTrySet = new java.util.HashSet<java.security.cert.X509Certificate>();
                for (java.security.cert.X509Certificate tryCert : certsToTrySet) {
                    java.util.Set<java.security.cert.X509Certificate> downloadedExtraCertificatesSet = CertificateVerifier.downloadExtraCertificates(tryCert);
                    for (java.security.cert.X509Certificate downloadedCertificate : downloadedExtraCertificatesSet) {
                        if (!certSet.contains(downloadedCertificate)) {
                            nextCertsToTrySet.add(downloadedCertificate);
                            certSet.add(downloadedCertificate);
                            downloadSize++;
                        }
                    }
                }
                certsToTrySet = nextCertsToTrySet;
            } 
            if (downloadSize > 0) {
                CertificateVerifier.LOG.info(("CA issuers: " + downloadSize) + " downloaded certificate(s) are new");
            }
            // Prepare a set of trust anchors (set of root CA certificates)
            // and a set of intermediate certificates
            java.util.Set<java.security.cert.X509Certificate> intermediateCerts = new java.util.HashSet<java.security.cert.X509Certificate>();
            java.util.Set<java.security.cert.TrustAnchor> trustAnchors = new java.util.HashSet<java.security.cert.TrustAnchor>();
            for (java.security.cert.X509Certificate additionalCert : certSet) {
                if (CertificateVerifier.isSelfSigned(additionalCert)) {
                    trustAnchors.add(new java.security.cert.TrustAnchor(additionalCert, null));
                } else {
                    intermediateCerts.add(additionalCert);
                }
            }
            if (trustAnchors.isEmpty()) {
                throw new CertificateVerificationException("No root certificate in the chain");
            }
            // Attempt to build the certification chain and verify it
            java.security.cert.PKIXCertPathBuilderResult verifiedCertChain = CertificateVerifier.verifyCertificate(cert, trustAnchors, intermediateCerts, signDate);
            CertificateVerifier.LOG.info("Certification chain verified successfully up to this root: " + verifiedCertChain.getTrustAnchor().getTrustedCert().getSubjectX500Principal());
            CertificateVerifier.checkRevocations(cert, certSet, signDate);
            return verifiedCertChain;
        } catch (java.security.cert.CertPathBuilderException certPathEx) {
            throw new CertificateVerificationException("Error building certification path: " + cert.getSubjectX500Principal(), certPathEx);
        } catch (CertificateVerificationException cvex) {
            throw cvex;
        } catch (Exception ex) {
            throw new CertificateVerificationException("Error verifying the certificate: " + cert.getSubjectX500Principal(), ex);
        }
    }

    private static void checkRevocations(java.security.cert.X509Certificate cert, java.util.Set<java.security.cert.X509Certificate> additionalCerts, java.util.Date signDate) throws IOException, CertificateVerificationException, OCSPException, org.apache.pdfbox.examples.signature.cert.RevokedCertificateException, GeneralSecurityException {
        if (CertificateVerifier.isSelfSigned(cert)) {
            // root, we're done
            return;
        }
        for (java.security.cert.X509Certificate additionalCert : additionalCerts) {
            try {
                cert.verify(additionalCert.getPublicKey(), org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider().getName());
                CertificateVerifier.checkRevocationsWithIssuer(cert, additionalCert, additionalCerts, signDate);
                // there can be several issuers
            } catch (GeneralSecurityException ex) {
                // not the issuer
            }
        }
    }

    private static void checkRevocationsWithIssuer(java.security.cert.X509Certificate cert, java.security.cert.X509Certificate issuerCert, java.util.Set<java.security.cert.X509Certificate> additionalCerts, java.util.Date signDate) throws CertificateVerificationException, IOException, org.apache.pdfbox.examples.signature.cert.RevokedCertificateException, GeneralSecurityException, OCSPException {
        // Try checking the certificate through OCSP (faster than CRL)
        String ocspURL = CertificateVerifier.extractOCSPURL(cert);
        if (ocspURL != null) {
            org.apache.pdfbox.examples.signature.cert.OcspHelper ocspHelper = new org.apache.pdfbox.examples.signature.cert.OcspHelper(cert, signDate, issuerCert, additionalCerts, ocspURL);
            try {
                CertificateVerifier.verifyOCSP(ocspHelper, additionalCerts);
            } catch (IOException ex) {
                // happens with 021496.pdf because OCSP responder no longer exists
                CertificateVerifier.LOG.warn("IOException trying OCSP, will try CRL", ex);
                CertificateVerifier.LOG.warn("Certificate# to check: " + cert.getSerialNumber().toString(16));
                org.apache.pdfbox.examples.signature.cert.CRLVerifier.verifyCertificateCRLs(cert, signDate, additionalCerts);
            } catch (OCSPException ex) {
                // happens with QV_RCA1_RCA3_CPCPS_V4_11.pdf
                CertificateVerifier.LOG.warn("OCSPException trying OCSP, will try CRL", ex);
                CertificateVerifier.LOG.warn("Certificate# to check: " + cert.getSerialNumber().toString(16));
                org.apache.pdfbox.examples.signature.cert.CRLVerifier.verifyCertificateCRLs(cert, signDate, additionalCerts);
            }
        } else {
            CertificateVerifier.LOG.info("OCSP not available, will try CRL");
            // Check whether the certificate is revoked by the CRL
            // given in its CRL distribution point extension
            org.apache.pdfbox.examples.signature.cert.CRLVerifier.verifyCertificateCRLs(cert, signDate, additionalCerts);
        }
        // now check the issuer
        CertificateVerifier.checkRevocations(issuerCert, additionalCerts, signDate);
    }

    /**
     * Checks whether given X.509 certificate is self-signed.
     *
     * @param cert
     * 		The X.509 certificate to check.
     * @return true if the certificate is self-signed, false if not.
     * @throws GeneralSecurityException
     */
    public static boolean isSelfSigned(java.security.cert.X509Certificate cert) throws GeneralSecurityException {
        try {
            // Try to verify certificate signature with its own public key
            java.security.PublicKey key = cert.getPublicKey();
            cert.verify(key, org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider().getName());
            return true;
        } catch (java.security.SignatureException ex) {
            // Invalid signature --> not self-signed
            CertificateVerifier.LOG.debug("Couldn't get signature information - returning false", ex);
            return false;
        } catch (java.security.InvalidKeyException ex) {
            // Invalid signature --> not self-signed
            CertificateVerifier.LOG.debug("Couldn't get signature information - returning false", ex);
            return false;
        } catch (IOException ex) {
            // Invalid signature --> not self-signed
            CertificateVerifier.LOG.debug("Couldn't get signature information - returning false", ex);
            return false;
        }
    }

    /**
     * Download extra certificates from the URI mentioned in id-ad-caIssuers in the "authority
     * information access" extension. The method is lenient, i.e. catches all exceptions.
     *
     * @param ext
     * 		an X509 object that can have extensions.
     * @return a certificate set, never null.
     */
    public static java.util.Set<java.security.cert.X509Certificate> downloadExtraCertificates(java.security.cert.X509Extension ext) {
        // https://tools.ietf.org/html/rfc2459#section-4.2.2.1
        // https://tools.ietf.org/html/rfc3280#section-4.2.2.1
        // https://tools.ietf.org/html/rfc4325
        java.util.Set<java.security.cert.X509Certificate> resultSet = new java.util.HashSet<java.security.cert.X509Certificate>();
        byte[] authorityExtensionValue = ext.getExtensionValue(org.bouncycastle.asn1.x509.Extension.authorityInfoAccess.getId());
        if (authorityExtensionValue == null) {
            return resultSet;
        }
        org.bouncycastle.asn1.ASN1Primitive asn1Prim;
        try {
            asn1Prim = org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils.parseExtensionValue(authorityExtensionValue);
        } catch (IOException ex) {
            CertificateVerifier.LOG.warn(ex.getMessage(), ex);
            return resultSet;
        }
        if (!(asn1Prim instanceof org.bouncycastle.asn1.ASN1Sequence)) {
            CertificateVerifier.LOG.warn("ASN1Sequence expected, got " + asn1Prim.getClass().getSimpleName());
            return resultSet;
        }
        org.bouncycastle.asn1.ASN1Sequence asn1Seq = ((org.bouncycastle.asn1.ASN1Sequence) (asn1Prim));
        java.util.Enumeration<?> objects = asn1Seq.getObjects();
        while (objects.hasMoreElements()) {
            // AccessDescription
            org.bouncycastle.asn1.ASN1Sequence obj = ((org.bouncycastle.asn1.ASN1Sequence) (objects.nextElement()));
            org.bouncycastle.asn1.ASN1Encodable oid = obj.getObjectAt(0);
            if (!org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id_ad_caIssuers.equals(oid)) {
                continue;
            }
            org.bouncycastle.asn1.ASN1TaggedObject location = ((org.bouncycastle.asn1.ASN1TaggedObject) (obj.getObjectAt(1)));
            org.bouncycastle.asn1.ASN1OctetString uri = ((org.bouncycastle.asn1.ASN1OctetString) (location.getObject()));
            String urlString = new String(uri.getOctets());
            java.io.InputStream in = null;
            try {
                CertificateVerifier.LOG.info("CA issuers URL: " + urlString);
                in = new java.net.URL(urlString).openStream();
                java.security.cert.CertificateFactory certFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                java.util.Collection<? extends java.security.cert.Certificate> altCerts = certFactory.generateCertificates(in);
                for (java.security.cert.Certificate altCert : altCerts) {
                    resultSet.add(((java.security.cert.X509Certificate) (altCert)));
                }
                CertificateVerifier.LOG.info(("CA issuers URL: " + altCerts.size()) + " certificate(s) downloaded");
            } catch (IOException ex) {
                CertificateVerifier.LOG.warn((urlString + " failure: ") + ex.getMessage(), ex);
            } catch (java.security.cert.CertificateException ex) {
                CertificateVerifier.LOG.warn(ex.getMessage(), ex);
            } finally {
                org.apache.pdfbox.io.IOUtils.closeQuietly(in);
            }
        } 
        CertificateVerifier.LOG.info(("CA issuers: Downloaded " + resultSet.size()) + " certificate(s) total");
        return resultSet;
    }

    /**
     * Attempts to build a certification chain for given certificate and to
     * verify it. Relies on a set of root CA certificates (trust anchors) and a
     * set of intermediate certificates (to be used as part of the chain).
     *
     * @param cert
     * 		- certificate for validation
     * @param trustAnchors
     * 		- set of trust anchors
     * @param intermediateCerts
     * 		- set of intermediate certificates
     * @param signDate
     * 		the date when the signing took place
     * @return the certification chain (if verification is successful)
     * @throws GeneralSecurityException
     * 		- if the verification is not successful
     * 		(e.g. certification path cannot be built or some certificate in the chain
     * 		is expired)
     */
    private static java.security.cert.PKIXCertPathBuilderResult verifyCertificate(java.security.cert.X509Certificate cert, java.util.Set<java.security.cert.TrustAnchor> trustAnchors, java.util.Set<java.security.cert.X509Certificate> intermediateCerts, java.util.Date signDate) throws GeneralSecurityException {
        // Create the selector that specifies the starting certificate
        java.security.cert.X509CertSelector selector = new java.security.cert.X509CertSelector();
        selector.setCertificate(cert);
        // Configure the PKIX certificate builder algorithm parameters
        java.security.cert.PKIXBuilderParameters pkixParams = new java.security.cert.PKIXBuilderParameters(trustAnchors, selector);
        // Disable CRL checks (this is done manually as additional step)
        pkixParams.setRevocationEnabled(false);
        // not doing this brings
        // "SunCertPathBuilderException: unable to find valid certification path to requested target"
        // (when using -Djava.security.debug=certpath: "critical policy qualifiers present in certificate")
        // for files like 021496.pdf that have the "Adobe CDS Certificate Policy" 1.2.840.113583.1.2.1
        // CDS = "Certified Document Services"
        // https://www.adobe.com/misc/pdfs/Adobe_CDS_CP.pdf
        pkixParams.setPolicyQualifiersRejected(false);
        // However, maybe there is still work to do:
        // "If the policyQualifiersRejected flag is set to false, it is up to the application
        // to validate all policy qualifiers in this manner in order to be PKIX compliant."
        pkixParams.setDate(signDate);
        // Specify a list of intermediate certificates
        java.security.cert.CertStore intermediateCertStore = java.security.cert.CertStore.getInstance("Collection", new java.security.cert.CollectionCertStoreParameters(intermediateCerts));
        pkixParams.addCertStore(intermediateCertStore);
        // Build and verify the certification chain
        // If this doesn't work although it should, it can be debugged
        // by starting java with -Djava.security.debug=certpath
        // see also
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/troubleshooting-security.html
        java.security.cert.CertPathBuilder builder = java.security.cert.CertPathBuilder.getInstance("PKIX");
        return ((java.security.cert.PKIXCertPathBuilderResult) (builder.build(pkixParams)));
    }

    /**
     * Extract the OCSP URL from an X.509 certificate if available.
     *
     * @param cert
     * 		X.509 certificate
     * @return the URL of the OCSP validation service
     * @throws IOException
     */
    private static String extractOCSPURL(java.security.cert.X509Certificate cert) throws IOException {
        byte[] authorityExtensionValue = cert.getExtensionValue(org.bouncycastle.asn1.x509.Extension.authorityInfoAccess.getId());
        if (authorityExtensionValue != null) {
            // copied from CertInformationHelper.getAuthorityInfoExtensionValue()
            // DRY refactor should be done some day
            org.bouncycastle.asn1.ASN1Sequence asn1Seq = ((org.bouncycastle.asn1.ASN1Sequence) (org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils.parseExtensionValue(authorityExtensionValue)));
            java.util.Enumeration<?> objects = asn1Seq.getObjects();
            while (objects.hasMoreElements()) {
                // AccessDescription
                org.bouncycastle.asn1.ASN1Sequence obj = ((org.bouncycastle.asn1.ASN1Sequence) (objects.nextElement()));
                org.bouncycastle.asn1.ASN1Encodable oid = obj.getObjectAt(0);
                // accessLocation
                org.bouncycastle.asn1.ASN1TaggedObject location = ((org.bouncycastle.asn1.ASN1TaggedObject) (obj.getObjectAt(1)));
                if (org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id_ad_ocsp.equals(oid) && (location.getTagNo() == org.bouncycastle.asn1.x509.GeneralName.uniformResourceIdentifier)) {
                    org.bouncycastle.asn1.ASN1OctetString url = ((org.bouncycastle.asn1.ASN1OctetString) (location.getObject()));
                    String ocspURL = new String(url.getOctets());
                    CertificateVerifier.LOG.info("OCSP URL: " + ocspURL);
                    return ocspURL;
                }
            } 
        }
        return null;
    }

    /**
     * Verify whether the certificate has been revoked at signing date, and verify whether the
     * certificate of the responder has been revoked now.
     *
     * @param ocspHelper
     * 		the OCSP helper.
     * @param additionalCerts
     * @throws RevokedCertificateException
     * @throws IOException
     * @throws OCSPException
     * @throws CertificateVerificationException
     */
    private static void verifyOCSP(org.apache.pdfbox.examples.signature.cert.OcspHelper ocspHelper, java.util.Set<java.security.cert.X509Certificate> additionalCerts) throws org.apache.pdfbox.examples.signature.cert.RevokedCertificateException, IOException, OCSPException, CertificateVerificationException {
        java.util.Date now = java.util.Calendar.getInstance().getTime();
        org.bouncycastle.cert.ocsp.OCSPResp ocspResponse;
        ocspResponse = ocspHelper.getResponseOcsp();
        if (ocspResponse.getStatus() != org.bouncycastle.cert.ocsp.OCSPResp.SUCCESSFUL) {
            throw new CertificateVerificationException("OCSP check not successful, status: " + ocspResponse.getStatus());
        }
        CertificateVerifier.LOG.info("OCSP check successful");
        org.bouncycastle.cert.ocsp.BasicOCSPResp basicResponse = ((org.bouncycastle.cert.ocsp.BasicOCSPResp) (ocspResponse.getResponseObject()));
        java.security.cert.X509Certificate ocspResponderCertificate = ocspHelper.getOcspResponderCertificate();
        if (ocspResponderCertificate.getExtensionValue(org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_nocheck.getId()) != null) {
            // https://tools.ietf.org/html/rfc6960#section-4.2.2.2.1
            // A CA may specify that an OCSP client can trust a responder for the
            // lifetime of the responder's certificate.  The CA does so by
            // including the extension id-pkix-ocsp-nocheck.
            CertificateVerifier.LOG.info("Revocation check of OCSP responder certificate skipped (id-pkix-ocsp-nocheck is set)");
            return;
        }
        if (ocspHelper.getCertificateToCheck().equals(ocspResponderCertificate)) {
            CertificateVerifier.LOG.info("OCSP responder certificate is identical to certificate to check");
            return;
        }
        CertificateVerifier.LOG.info("Check of OCSP responder certificate");
        java.util.Set<java.security.cert.X509Certificate> additionalCerts2 = new java.util.HashSet<java.security.cert.X509Certificate>(additionalCerts);
        org.bouncycastle.cert.jcajce.JcaX509CertificateConverter certificateConverter = new org.bouncycastle.cert.jcajce.JcaX509CertificateConverter();
        for (org.bouncycastle.cert.X509CertificateHolder certHolder : basicResponse.getCerts()) {
            try {
                java.security.cert.X509Certificate cert = certificateConverter.getCertificate(certHolder);
                if (!ocspResponderCertificate.equals(cert)) {
                    additionalCerts2.add(cert);
                }
            } catch (java.security.cert.CertificateException ex) {
                // unlikely to happen because the certificate existed as an object
                CertificateVerifier.LOG.error(ex, ex);
            }
        }
        CertificateVerifier.verifyCertificate(ocspResponderCertificate, additionalCerts2, true, now);
        CertificateVerifier.LOG.info("Check of OCSP responder certificate done");
    }
}