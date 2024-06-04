/* Copyright 2017 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.examples.signature;
import java.io.IOException;
import java.security.cert.CertificateException;
import org.apache.pdfbox.examples.signature.cert.CertificateVerificationException;
/**
 * Utility class for the signature / timestamp examples.
 *
 * @author Tilman Hausherr
 */
public class SigUtils {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(SigUtils.class);

    private SigUtils() {
    }

    /**
     * Get the access permissions granted for this document in the DocMDP transform parameters
     * dictionary. Details are described in the table "Entries in the DocMDP transform parameters
     * dictionary" in the PDF specification.
     *
     * @param doc
     * 		document.
     * @return the permission value. 0 means no DocMDP transform parameters dictionary exists. Other
    return values are 1, 2 or 3. 2 is also returned if the DocMDP transform parameters dictionary
    is found but did not contain a /P entry, or if the value is outside the valid range.
     */
    public static int getMDPPermission(org.apache.pdfbox.pdmodel.PDDocument doc) {
        org.apache.pdfbox.cos.COSBase base = doc.getDocumentCatalog().getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.PERMS);
        if (base instanceof org.apache.pdfbox.cos.COSDictionary) {
            org.apache.pdfbox.cos.COSDictionary permsDict = ((org.apache.pdfbox.cos.COSDictionary) (base));
            base = permsDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DOCMDP);
            if (base instanceof org.apache.pdfbox.cos.COSDictionary) {
                org.apache.pdfbox.cos.COSDictionary signatureDict = ((org.apache.pdfbox.cos.COSDictionary) (base));
                base = signatureDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.REFERENCE);
                if (base instanceof org.apache.pdfbox.cos.COSArray) {
                    org.apache.pdfbox.cos.COSArray refArray = ((org.apache.pdfbox.cos.COSArray) (base));
                    for (int i = 0; i < refArray.size(); ++i) {
                        base = refArray.getObject(i);
                        if (base instanceof org.apache.pdfbox.cos.COSDictionary) {
                            org.apache.pdfbox.cos.COSDictionary sigRefDict = ((org.apache.pdfbox.cos.COSDictionary) (base));
                            if (org.apache.pdfbox.cos.COSName.DOCMDP.equals(sigRefDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.TRANSFORM_METHOD))) {
                                base = sigRefDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.TRANSFORM_PARAMS);
                                if (base instanceof org.apache.pdfbox.cos.COSDictionary) {
                                    org.apache.pdfbox.cos.COSDictionary transformDict = ((org.apache.pdfbox.cos.COSDictionary) (base));
                                    int accessPermissions = transformDict.getInt(org.apache.pdfbox.cos.COSName.P, 2);
                                    if ((accessPermissions < 1) || (accessPermissions > 3)) {
                                        accessPermissions = 2;
                                    }
                                    return accessPermissions;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Set the "modification detection and prevention" permissions granted for this document in the
     * DocMDP transform parameters dictionary. Details are described in the table "Entries in the
     * DocMDP transform parameters dictionary" in the PDF specification.
     *
     * @param doc
     * 		The document.
     * @param signature
     * 		The signature object.
     * @param accessPermissions
     * 		The permission value (1, 2 or 3).
     * @throws IOException
     * 		if a signature exists.
     */
    public static void setMDPPermission(org.apache.pdfbox.pdmodel.PDDocument doc, org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature signature, int accessPermissions) throws IOException {
        for (org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature sig : doc.getSignatureDictionaries()) {
            // "Approval signatures shall follow the certification signature if one is present"
            // thus we don't care about timestamp signatures
            if (org.apache.pdfbox.cos.COSName.DOC_TIME_STAMP.equals(sig.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE))) {
                continue;
            }
            if (sig.getCOSObject().containsKey(org.apache.pdfbox.cos.COSName.CONTENTS)) {
                throw new IOException("DocMDP transform method not allowed if an approval signature exists");
            }
        }
        org.apache.pdfbox.cos.COSDictionary sigDict = signature.getCOSObject();
        // DocMDP specific stuff
        org.apache.pdfbox.cos.COSDictionary transformParameters = new org.apache.pdfbox.cos.COSDictionary();
        transformParameters.setItem(org.apache.pdfbox.cos.COSName.TYPE, org.apache.pdfbox.cos.COSName.TRANSFORM_PARAMS);
        transformParameters.setInt(org.apache.pdfbox.cos.COSName.P, accessPermissions);
        transformParameters.setName(org.apache.pdfbox.cos.COSName.V, "1.2");
        transformParameters.setNeedToBeUpdated(true);
        org.apache.pdfbox.cos.COSDictionary referenceDict = new org.apache.pdfbox.cos.COSDictionary();
        referenceDict.setItem(org.apache.pdfbox.cos.COSName.TYPE, org.apache.pdfbox.cos.COSName.SIG_REF);
        referenceDict.setItem(org.apache.pdfbox.cos.COSName.TRANSFORM_METHOD, org.apache.pdfbox.cos.COSName.DOCMDP);
        referenceDict.setItem(org.apache.pdfbox.cos.COSName.DIGEST_METHOD, org.apache.pdfbox.cos.COSName.getPDFName("SHA1"));
        referenceDict.setItem(org.apache.pdfbox.cos.COSName.TRANSFORM_PARAMS, transformParameters);
        referenceDict.setNeedToBeUpdated(true);
        org.apache.pdfbox.cos.COSArray referenceArray = new org.apache.pdfbox.cos.COSArray();
        referenceArray.add(referenceDict);
        sigDict.setItem(org.apache.pdfbox.cos.COSName.REFERENCE, referenceArray);
        referenceArray.setNeedToBeUpdated(true);
        // Catalog
        org.apache.pdfbox.cos.COSDictionary catalogDict = doc.getDocumentCatalog().getCOSObject();
        org.apache.pdfbox.cos.COSDictionary permsDict = new org.apache.pdfbox.cos.COSDictionary();
        catalogDict.setItem(org.apache.pdfbox.cos.COSName.PERMS, permsDict);
        permsDict.setItem(org.apache.pdfbox.cos.COSName.DOCMDP, signature);
        catalogDict.setNeedToBeUpdated(true);
        permsDict.setNeedToBeUpdated(true);
    }

    /**
     * Log if the certificate is not valid for signature usage. Doing this
     * anyway results in Adobe Reader failing to validate the PDF.
     *
     * @param x509Certificate
     * @throws java.security.cert.CertificateParsingException
     */
    public static void checkCertificateUsage(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateParsingException {
        // Check whether signer certificate is "valid for usage"
        // https://stackoverflow.com/a/52765021/535646
        // https://www.adobe.com/devnet-docs/acrobatetk/tools/DigSig/changes.html#id1
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (((keyUsage != null) && (!keyUsage[0])) && (!keyUsage[1])) {
            // (unclear what "signTransaction" is)
            // https://tools.ietf.org/html/rfc5280#section-4.2.1.3
            SigUtils.LOG.error("Certificate key usage does not include " + "digitalSignature nor nonRepudiation");
        }
        java.util.List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        if ((((((extendedKeyUsage != null) && (!extendedKeyUsage.contains(org.bouncycastle.asn1.x509.KeyPurposeId.id_kp_emailProtection.toString()))) && (!extendedKeyUsage.contains(org.bouncycastle.asn1.x509.KeyPurposeId.id_kp_codeSigning.toString()))) && (!extendedKeyUsage.contains(org.bouncycastle.asn1.x509.KeyPurposeId.anyExtendedKeyUsage.toString()))) && (!extendedKeyUsage.contains("1.2.840.113583.1.1.5"))) && // not mentioned in Adobe document, but tolerated in practice
        (!extendedKeyUsage.contains("1.3.6.1.4.1.311.10.3.12"))) {
            SigUtils.LOG.error(("Certificate extended key usage does not include " + "emailProtection, nor codeSigning, nor anyExtendedKeyUsage, ") + "nor 'Adobe Authentic Documents Trust'");
        }
    }

    /**
     * Log if the certificate is not valid for timestamping.
     *
     * @param x509Certificate
     * @throws java.security.cert.CertificateParsingException
     */
    public static void checkTimeStampCertificateUsage(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateParsingException {
        java.util.List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        // https://tools.ietf.org/html/rfc5280#section-4.2.1.12
        if ((extendedKeyUsage != null) && (!extendedKeyUsage.contains(org.bouncycastle.asn1.x509.KeyPurposeId.id_kp_timeStamping.toString()))) {
            SigUtils.LOG.error("Certificate extended key usage does not include timeStamping");
        }
    }

    /**
     * Log if the certificate is not valid for responding.
     *
     * @param x509Certificate
     * @throws java.security.cert.CertificateParsingException
     */
    public static void checkResponderCertificateUsage(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateParsingException {
        java.util.List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        // https://tools.ietf.org/html/rfc5280#section-4.2.1.12
        if ((extendedKeyUsage != null) && (!extendedKeyUsage.contains(org.bouncycastle.asn1.x509.KeyPurposeId.id_kp_OCSPSigning.toString()))) {
            SigUtils.LOG.error("Certificate extended key usage does not include OCSP responding");
        }
    }

    /**
     * Gets the last relevant signature in the document, i.e. the one with the highest offset.
     *
     * @param document
     * 		to get its last signature
     * @return last signature or null when none found
     * @throws IOException
     */
    public static org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature getLastRelevantSignature(org.apache.pdfbox.pdmodel.PDDocument document) throws IOException {
        java.util.SortedMap<Integer, org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature> sortedMap = new java.util.TreeMap<Integer, org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature>();
        for (org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature signature : document.getSignatureDictionaries()) {
            int sigOffset = signature.getByteRange()[1];
            sortedMap.put(sigOffset, signature);
        }
        if (sortedMap.size() > 0) {
            org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature lastSignature = sortedMap.get(sortedMap.lastKey());
            org.apache.pdfbox.cos.COSBase type = lastSignature.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE);
            if (((type == null) || org.apache.pdfbox.cos.COSName.SIG.equals(type)) || org.apache.pdfbox.cos.COSName.DOC_TIME_STAMP.equals(type)) {
                return lastSignature;
            }
        }
        return null;
    }

    public static org.bouncycastle.tsp.TimeStampToken extractTimeStampTokenFromSignerInformation(org.bouncycastle.cms.SignerInformation signerInformation) throws org.bouncycastle.cms.CMSException, IOException, org.bouncycastle.tsp.TSPException {
        if (signerInformation.getUnsignedAttributes() == null) {
            return null;
        }
        org.bouncycastle.asn1.cms.AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        // https://stackoverflow.com/questions/1647759/how-to-validate-if-a-signed-jar-contains-a-timestamp
        org.bouncycastle.asn1.cms.Attribute attribute = unsignedAttributes.get(org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
        if (attribute == null) {
            return null;
        }
        org.bouncycastle.asn1.ASN1Object obj = ((org.bouncycastle.asn1.ASN1Object) (attribute.getAttrValues().getObjectAt(0)));
        org.bouncycastle.cms.CMSSignedData signedTSTData = new org.bouncycastle.cms.CMSSignedData(obj.getEncoded());
        return new org.bouncycastle.tsp.TimeStampToken(signedTSTData);
    }

    public static void validateTimestampToken(org.bouncycastle.tsp.TimeStampToken timeStampToken) throws IOException, CertificateException, org.bouncycastle.tsp.TSPException, org.bouncycastle.operator.OperatorCreationException {
        // https://stackoverflow.com/questions/42114742/
        // TimeStampToken.getSID() is untyped
        @SuppressWarnings("unchecked")
        java.util.Collection<org.bouncycastle.cert.X509CertificateHolder> tstMatches = timeStampToken.getCertificates().getMatches(((org.bouncycastle.util.Selector<org.bouncycastle.cert.X509CertificateHolder>) (timeStampToken.getSID())));
        org.bouncycastle.cert.X509CertificateHolder certificateHolder = tstMatches.iterator().next();
        org.bouncycastle.cms.SignerInformationVerifier siv = new org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder().setProvider(org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider()).build(certificateHolder);
        timeStampToken.validate(siv);
    }

    /**
     * Verify the certificate chain up to the root, including OCSP or CRL. However this does not
     * test whether the root certificate is in a trusted list.<br><br>
     * Please post bad PDF files that succeed and good PDF files that fail in
     * <a href="https://issues.apache.org/jira/browse/PDFBOX-3017">PDFBOX-3017</a>.
     *
     * @param certificatesStore
     * @param certFromSignedData
     * @param signDate
     * @throws CertificateVerificationException
     * @throws CertificateException
     */
    public static void verifyCertificateChain(org.bouncycastle.util.Store<org.bouncycastle.cert.X509CertificateHolder> certificatesStore, java.security.cert.X509Certificate certFromSignedData, java.util.Date signDate) throws org.apache.pdfbox.examples.signature.cert.CertificateVerificationException, CertificateException {
        java.util.Collection<org.bouncycastle.cert.X509CertificateHolder> certificateHolders = certificatesStore.getMatches(null);
        java.util.Set<java.security.cert.X509Certificate> additionalCerts = new java.util.HashSet<java.security.cert.X509Certificate>();
        org.bouncycastle.cert.jcajce.JcaX509CertificateConverter certificateConverter = new org.bouncycastle.cert.jcajce.JcaX509CertificateConverter();
        for (org.bouncycastle.cert.X509CertificateHolder certHolder : certificateHolders) {
            java.security.cert.X509Certificate certificate = certificateConverter.getCertificate(certHolder);
            if (!certificate.equals(certFromSignedData)) {
                additionalCerts.add(certificate);
            }
        }
        org.apache.pdfbox.examples.signature.cert.CertificateVerifier.verifyCertificate(certFromSignedData, additionalCerts, true, signDate);
        // TODO check whether the root certificate is in our trusted list.
        // For the EU, get a list here:
        // https://ec.europa.eu/digital-single-market/en/eu-trusted-lists-trust-service-providers
        // ( getRootCertificates() is not helpful because these are SSL certificates)
    }
}