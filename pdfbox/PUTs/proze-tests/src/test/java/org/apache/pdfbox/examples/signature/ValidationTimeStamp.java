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
package org.apache.pdfbox.examples.signature;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
/**
 * This class wraps the TSAClient and the work that has to be done with it. Like Adding Signed
 * TimeStamps to a signature, or creating a CMS timestamp attribute (with a signed timestamp)
 *
 * @author Others
 * @author Alexis Suter
 */
public class ValidationTimeStamp {
    private org.apache.pdfbox.examples.signature.TSAClient tsaClient;

    /**
     *
     * @param tsaUrl
     * 		The url where TS-Request will be done.
     * @throws NoSuchAlgorithmException
     * @throws MalformedURLException
     */
    public ValidationTimeStamp(String tsaUrl) throws NoSuchAlgorithmException, MalformedURLException {
        if (tsaUrl != null) {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            this.tsaClient = new org.apache.pdfbox.examples.signature.TSAClient(new java.net.URL(tsaUrl), null, null, digest);
        }
    }

    /**
     * Creates a signed timestamp token by the given input stream.
     *
     * @param content
     * 		InputStream of the content to sign
     * @return the byte[] of the timestamp token
     * @throws IOException
     */
    public byte[] getTimeStampToken(java.io.InputStream content) throws IOException {
        org.bouncycastle.tsp.TimeStampToken timeStampToken = tsaClient.getTimeStampToken(org.apache.pdfbox.io.IOUtils.toByteArray(content));
        return timeStampToken.getEncoded();
    }

    /**
     * Extend cms signed data with TimeStamp first or to all signers
     *
     * @param signedData
     * 		Generated CMS signed data
     * @return CMSSignedData Extended CMS signed data
     * @throws IOException
     */
    public org.bouncycastle.cms.CMSSignedData addSignedTimeStamp(org.bouncycastle.cms.CMSSignedData signedData) throws IOException {
        org.bouncycastle.cms.SignerInformationStore signerStore = signedData.getSignerInfos();
        java.util.List<org.bouncycastle.cms.SignerInformation> newSigners = new java.util.ArrayList<org.bouncycastle.cms.SignerInformation>();
        for (org.bouncycastle.cms.SignerInformation signer : signerStore.getSigners()) {
            // This adds a timestamp to every signer (into his unsigned attributes) in the signature.
            newSigners.add(signTimeStamp(signer));
        }
        // Because new SignerInformation is created, new SignerInfoStore has to be created
        // and also be replaced in signedData. Which creates a new signedData object.
        return org.bouncycastle.cms.CMSSignedData.replaceSigners(signedData, new org.bouncycastle.cms.SignerInformationStore(newSigners));
    }

    /**
     * Extend CMS Signer Information with the TimeStampToken into the unsigned Attributes.
     *
     * @param signer
     * 		information about signer
     * @return information about SignerInformation
     * @throws IOException
     */
    private org.bouncycastle.cms.SignerInformation signTimeStamp(org.bouncycastle.cms.SignerInformation signer) throws IOException {
        org.bouncycastle.asn1.cms.AttributeTable unsignedAttributes = signer.getUnsignedAttributes();
        org.bouncycastle.asn1.ASN1EncodableVector vector = new org.bouncycastle.asn1.ASN1EncodableVector();
        if (unsignedAttributes != null) {
            vector = unsignedAttributes.toASN1EncodableVector();
        }
        org.bouncycastle.tsp.TimeStampToken timeStampToken = tsaClient.getTimeStampToken(signer.getSignature());
        byte[] token = timeStampToken.getEncoded();
        org.bouncycastle.asn1.ASN1ObjectIdentifier oid = org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.id_aa_signatureTimeStampToken;
        org.bouncycastle.asn1.ASN1Encodable signatureTimeStamp = new org.bouncycastle.asn1.cms.Attribute(oid, new org.bouncycastle.asn1.DERSet(org.bouncycastle.asn1.ASN1Primitive.fromByteArray(token)));
        vector.add(signatureTimeStamp);
        org.bouncycastle.asn1.cms.Attributes signedAttributes = new org.bouncycastle.asn1.cms.Attributes(vector);
        // There is no other way changing the unsigned attributes of the signer information.
        // result is never null, new SignerInformation always returned,
        // see source code of replaceUnsignedAttributes
        return org.bouncycastle.cms.SignerInformation.replaceUnsignedAttributes(signer, new org.bouncycastle.asn1.cms.AttributeTable(signedAttributes));
    }
}