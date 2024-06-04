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
/**
 * Copied from Apache CXF 2.4.9, initial version:
 * https://svn.apache.org/repos/asf/cxf/tags/cxf-2.4.9/distribution/src/main/release/samples/sts_issue_operation/src/main/java/demo/sts/provider/cert/
 */
public final class CRLVerifier {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(CRLVerifier.class);

    private CRLVerifier() {
    }

    /**
     * Extracts the CRL distribution points from the certificate (if available)
     * and checks the certificate revocation status against the CRLs coming from
     * the distribution points. Supports HTTP, HTTPS, FTP and LDAP based URLs.
     *
     * @param cert
     * 		the certificate to be checked for revocation
     * @param signDate
     * 		the date when the signing took place
     * @param additionalCerts
     * 		set of trusted root CA certificates that will be
     * 		used as "trust anchors" and intermediate CA certificates that will be
     * 		used as part of the certification chain.
     * @throws CertificateVerificationException
     * 		if the certificate could not be verified
     * @throws RevokedCertificateException
     * 		if the certificate is revoked
     */
    public static void verifyCertificateCRLs(java.security.cert.X509Certificate cert, java.util.Date signDate, java.util.Set<java.security.cert.X509Certificate> additionalCerts) throws CertificateVerificationException, RevokedCertificateException {
        try {
            java.util.Date now = java.util.Calendar.getInstance().getTime();
            Exception firstException = null;
            java.util.List<String> crlDistributionPointsURLs = CRLVerifier.getCrlDistributionPoints(cert);
            for (String crlDistributionPointsURL : crlDistributionPointsURLs) {
                CRLVerifier.LOG.info("Checking distribution point URL: " + crlDistributionPointsURL);
                java.security.cert.X509CRL crl;
                try {
                    crl = CRLVerifier.downloadCRL(crlDistributionPointsURL);
                } catch (Exception ex) {
                    // e.g. LDAP behind corporate proxy
                    CRLVerifier.LOG.warn(("Caught " + ex.getClass().getSimpleName()) + " downloading CRL, will try next distribution point if available");
                    if (firstException == null) {
                        firstException = ex;
                    }
                    continue;
                }
                java.util.Set<java.security.cert.X509Certificate> mergedCertSet = CertificateVerifier.downloadExtraCertificates(crl);
                mergedCertSet.addAll(additionalCerts);
                // Verify CRL, see wikipedia:
                // "To validate a specific CRL prior to relying on it,
                // the certificate of its corresponding CA is needed"
                java.security.cert.X509Certificate crlIssuerCert = null;
                for (java.security.cert.X509Certificate possibleCert : mergedCertSet) {
                    try {
                        cert.verify(possibleCert.getPublicKey(), org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider().getName());
                        crlIssuerCert = possibleCert;
                        break;
                    } catch (java.security.GeneralSecurityException ex) {
                        // not the issuer
                    }
                }
                if (crlIssuerCert == null) {
                    throw new CertificateVerificationException(((("Certificate for " + crl.getIssuerX500Principal()) + "not found in certificate chain, so the CRL at ") + crlDistributionPointsURL) + " could not be verified");
                }
                crl.verify(crlIssuerCert.getPublicKey(), org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider().getName());
                // TODO these should be exceptions, but for that we need a test case where
                // a PDF has a broken OCSP and a working CRL
                if (crl.getThisUpdate().after(now)) {
                    CRLVerifier.LOG.error("CRL not yet valid, thisUpdate is " + crl.getThisUpdate());
                }
                if (crl.getNextUpdate().before(now)) {
                    CRLVerifier.LOG.error("CRL no longer valid, nextUpdate is " + crl.getNextUpdate());
                }
                if (!crl.getIssuerX500Principal().equals(cert.getIssuerX500Principal())) {
                    CRLVerifier.LOG.info("CRL issuer certificate is not identical to cert issuer, check needed");
                    CertificateVerifier.verifyCertificate(crlIssuerCert, mergedCertSet, true, now);
                    CRLVerifier.LOG.info("CRL issuer certificate checked successfully");
                } else {
                    CRLVerifier.LOG.info("CRL issuer certificate is identical to cert issuer, no extra check needed");
                }
                CRLVerifier.checkRevocation(crl, cert, signDate, crlDistributionPointsURL);
                // https://tools.ietf.org/html/rfc5280#section-4.2.1.13
                // If the DistributionPointName contains multiple values,
                // each name describes a different mechanism to obtain the same
                // CRL.  For example, the same CRL could be available for
                // retrieval through both LDAP and HTTP.
                // 
                // => thus no need to check several protocols
                return;
            }
            if (firstException != null) {
                throw firstException;
            }
        } catch (CertificateVerificationException ex) {
            throw ex;
        } catch (RevokedCertificateException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new CertificateVerificationException("Cannot verify CRL for certificate: " + cert.getSubjectX500Principal(), ex);
        }
    }

    /**
     * Check whether the certificate was revoked at signing time.
     *
     * @param crl
     * 		certificate revocation list
     * @param cert
     * 		certificate to be checked
     * @param signDate
     * 		date the certificate was used for signing
     * @param crlDistributionPointsURL
     * 		URL for log message or exception text
     * @throws RevokedCertificateException
     * 		if the certificate was revoked at signing time
     */
    public static void checkRevocation(java.security.cert.X509CRL crl, java.security.cert.X509Certificate cert, java.util.Date signDate, String crlDistributionPointsURL) throws RevokedCertificateException {
        java.security.cert.X509CRLEntry revokedCRLEntry = crl.getRevokedCertificate(cert);
        if ((revokedCRLEntry != null) && (revokedCRLEntry.getRevocationDate().compareTo(signDate) <= 0)) {
            throw new RevokedCertificateException((("The certificate was revoked by CRL " + crlDistributionPointsURL) + " on ") + revokedCRLEntry.getRevocationDate(), revokedCRLEntry.getRevocationDate());
        } else if (revokedCRLEntry != null) {
            CRLVerifier.LOG.info((("The certificate was revoked after signing by CRL " + crlDistributionPointsURL) + " on ") + revokedCRLEntry.getRevocationDate());
        } else {
            CRLVerifier.LOG.info("The certificate was not revoked by CRL " + crlDistributionPointsURL);
        }
    }

    /**
     * Downloads CRL from given URL. Supports http, https, ftp and ldap based URLs.
     */
    private static java.security.cert.X509CRL downloadCRL(String crlURL) throws java.io.IOException, java.security.cert.CertificateException, java.security.cert.CRLException, CertificateVerificationException, javax.naming.NamingException {
        if ((crlURL.startsWith("http://") || crlURL.startsWith("https://")) || crlURL.startsWith("ftp://")) {
            return CRLVerifier.downloadCRLFromWeb(crlURL);
        } else if (crlURL.startsWith("ldap://")) {
            return CRLVerifier.downloadCRLFromLDAP(crlURL);
        } else {
            throw new CertificateVerificationException(("Can not download CRL from certificate " + "distribution point: ") + crlURL);
        }
    }

    /**
     * Downloads a CRL from given LDAP url, e.g.
     * ldap://ldap.infonotary.com/dc=identity-ca,dc=infonotary,dc=com
     */
    private static java.security.cert.X509CRL downloadCRLFromLDAP(String ldapURL) throws java.security.cert.CertificateException, javax.naming.NamingException, java.security.cert.CRLException, CertificateVerificationException {
        @SuppressWarnings({ "squid:S1149" })
        java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
        env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(javax.naming.Context.PROVIDER_URL, ldapURL);
        // https://docs.oracle.com/javase/jndi/tutorial/ldap/connect/create.html
        // don't wait forever behind corporate proxy
        env.put("com.sun.jndi.ldap.connect.timeout", "1000");
        javax.naming.directory.DirContext ctx = new javax.naming.directory.InitialDirContext(env);
        javax.naming.directory.Attributes avals = ctx.getAttributes("");
        javax.naming.directory.Attribute aval = avals.get("certificateRevocationList;binary");
        byte[] val = ((byte[]) (aval.get()));
        if ((val == null) || (val.length == 0)) {
            throw new CertificateVerificationException("Can not download CRL from: " + ldapURL);
        } else {
            java.io.InputStream inStream = new java.io.ByteArrayInputStream(val);
            java.security.cert.CertificateFactory cf = java.security.cert.CertificateFactory.getInstance("X.509");
            return ((java.security.cert.X509CRL) (cf.generateCRL(inStream)));
        }
    }

    /**
     * Downloads a CRL from given HTTP/HTTPS/FTP URL, e.g.
     * http://crl.infonotary.com/crl/identity-ca.crl
     */
    public static java.security.cert.X509CRL downloadCRLFromWeb(String crlURL) throws java.io.IOException, java.security.cert.CertificateException, java.security.cert.CRLException {
        java.io.InputStream crlStream = new java.net.URL(crlURL).openStream();
        try {
            return ((java.security.cert.X509CRL) (java.security.cert.CertificateFactory.getInstance("X.509").generateCRL(crlStream)));
        } finally {
            crlStream.close();
        }
    }

    /**
     * Extracts all CRL distribution point URLs from the "CRL Distribution
     * Point" extension in a X.509 certificate. If CRL distribution point
     * extension is unavailable, returns an empty list.
     *
     * @param cert
     * @return List of CRL distribution point URLs.
     * @throws java.io.IOException
     */
    public static java.util.List<String> getCrlDistributionPoints(java.security.cert.X509Certificate cert) throws java.io.IOException {
        byte[] crldpExt = cert.getExtensionValue(org.bouncycastle.asn1.x509.Extension.cRLDistributionPoints.getId());
        if (crldpExt == null) {
            return new java.util.ArrayList<String>();
        }
        org.bouncycastle.asn1.ASN1InputStream oAsnInStream = new org.bouncycastle.asn1.ASN1InputStream(crldpExt);
        org.bouncycastle.asn1.ASN1Primitive derObjCrlDP = oAsnInStream.readObject();
        oAsnInStream.close();
        if (!(derObjCrlDP instanceof org.bouncycastle.asn1.ASN1OctetString)) {
            CRLVerifier.LOG.warn((("CRL distribution points for certificate subject " + cert.getSubjectX500Principal().getName()) + " should be an octet string, but is ") + derObjCrlDP);
            return new java.util.ArrayList<String>();
        }
        org.bouncycastle.asn1.ASN1OctetString dosCrlDP = ((org.bouncycastle.asn1.ASN1OctetString) (derObjCrlDP));
        byte[] crldpExtOctets = dosCrlDP.getOctets();
        org.bouncycastle.asn1.ASN1InputStream oAsnInStream2 = new org.bouncycastle.asn1.ASN1InputStream(crldpExtOctets);
        org.bouncycastle.asn1.ASN1Primitive derObj2 = oAsnInStream2.readObject();
        oAsnInStream2.close();
        org.bouncycastle.asn1.x509.CRLDistPoint distPoint = org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(derObj2);
        java.util.List<String> crlUrls = new java.util.ArrayList<String>();
        for (org.bouncycastle.asn1.x509.DistributionPoint dp : distPoint.getDistributionPoints()) {
            org.bouncycastle.asn1.x509.DistributionPointName dpn = dp.getDistributionPoint();
            // Look for URIs in fullName
            if ((dpn != null) && (dpn.getType() == org.bouncycastle.asn1.x509.DistributionPointName.FULL_NAME)) {
                // Look for an URI
                for (org.bouncycastle.asn1.x509.GeneralName genName : org.bouncycastle.asn1.x509.GeneralNames.getInstance(dpn.getName()).getNames()) {
                    if (genName.getTagNo() == org.bouncycastle.asn1.x509.GeneralName.uniformResourceIdentifier) {
                        String url = org.bouncycastle.asn1.DERIA5String.getInstance(genName.getName()).getString();
                        crlUrls.add(url);
                    }
                }
            }
        }
        return crlUrls;
    }
}