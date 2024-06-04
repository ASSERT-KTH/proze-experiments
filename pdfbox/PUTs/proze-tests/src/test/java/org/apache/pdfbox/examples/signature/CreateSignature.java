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
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
/**
 * An example for signing a PDF with bouncy castle.
 * A keystore can be created with the java keytool, for example:
 *
 * {@code keytool -genkeypair -storepass 123456 -storetype pkcs12 -alias test -validity 365
 *        -v -keyalg RSA -keystore keystore.p12}
 *
 * @author Thomas Chojecki
 * @author Vakhtang Koroghlishvili
 * @author John Hewson
 */
public class CreateSignature extends org.apache.pdfbox.examples.signature.CreateSignatureBase {
    /**
     * Initialize the signature creator with a keystore and certificate password.
     *
     * @param keystore
     * 		the pkcs12 keystore containing the signing certificate
     * @param pin
     * 		the password for recovering the key
     * @throws KeyStoreException
     * 		if the keystore has not been initialized (loaded)
     * @throws NoSuchAlgorithmException
     * 		if the algorithm for recovering the key cannot be found
     * @throws UnrecoverableKeyException
     * 		if the given password is wrong
     * @throws CertificateException
     * 		if the certificate is not valid as signing time
     * @throws IOException
     * 		if no certificate could be found
     */
    public CreateSignature(java.security.KeyStore keystore, char[] pin) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, IOException {
        super(keystore, pin);
    }

    /**
     * Signs the given PDF file. Alters the original file on disk.
     *
     * @param file
     * 		the PDF file to sign
     * @throws IOException
     * 		if the file could not be read or written
     */
    public void signDetached(java.io.File file) throws IOException {
        signDetached(file, file, null);
    }

    /**
     * Signs the given PDF file.
     *
     * @param inFile
     * 		input PDF file
     * @param outFile
     * 		output PDF file
     * @throws IOException
     * 		if the input file could not be read
     */
    public void signDetached(java.io.File inFile, java.io.File outFile) throws IOException {
        signDetached(inFile, outFile, null);
    }

    /**
     * Signs the given PDF file.
     *
     * @param inFile
     * 		input PDF file
     * @param outFile
     * 		output PDF file
     * @param tsaUrl
     * 		optional TSA url
     * @throws IOException
     * 		if the input file could not be read
     */
    public void signDetached(java.io.File inFile, java.io.File outFile, String tsaUrl) throws IOException {
        if ((inFile == null) || (!inFile.exists())) {
            throw new java.io.FileNotFoundException("Document for signing does not exist");
        }
        setTsaUrl(tsaUrl);
        java.io.FileOutputStream fos = new java.io.FileOutputStream(outFile);
        // sign
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(inFile);
            signDetached(doc, fos);
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            org.apache.pdfbox.io.IOUtils.closeQuietly(fos);
        }
    }

    public void signDetached(org.apache.pdfbox.pdmodel.PDDocument document, java.io.OutputStream output) throws IOException {
        int accessPermissions = org.apache.pdfbox.examples.signature.SigUtils.getMDPPermission(document);
        if (accessPermissions == 1) {
            throw new IllegalStateException("No changes to the document are permitted due to DocMDP transform parameters dictionary");
        }
        // create signature dictionary
        org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature signature = new org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature();
        signature.setFilter(org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature.FILTER_ADOBE_PPKLITE);
        signature.setSubFilter(org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
        signature.setName("Example User");
        signature.setLocation("Los Angeles, CA");
        signature.setReason("Testing");
        // TODO extract the above details from the signing certificate? Reason as a parameter?
        // the signing date, needed for valid signature
        signature.setSignDate(java.util.Calendar.getInstance());
        // Optional: certify
        if (accessPermissions == 0) {
            org.apache.pdfbox.examples.signature.SigUtils.setMDPPermission(document, signature, 2);
        }
        if (isExternalSigning()) {
            document.addSignature(signature);
            org.apache.pdfbox.pdmodel.interactive.digitalsignature.ExternalSigningSupport externalSigning = document.saveIncrementalForExternalSigning(output);
            // invoke external signature service
            byte[] cmsSignature = sign(externalSigning.getContent());
            // set signature bytes received from the service
            externalSigning.setSignature(cmsSignature);
        } else {
            org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions signatureOptions = new org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions();
            // Size can vary, but should be enough for purpose.
            signatureOptions.setPreferredSignatureSize(org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions.DEFAULT_SIGNATURE_SIZE * 2);
            // register signature dictionary and sign interface
            document.addSignature(signature, this, signatureOptions);
            // write incremental (only for signing purpose)
            document.saveIncremental(output);
        }
    }

    public static void main(String[] args) throws IOException, java.security.GeneralSecurityException {
        if (args.length < 3) {
            CreateSignature.usage();
            System.exit(1);
        }
        String tsaUrl = null;
        boolean externalSig = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-tsa")) {
                i++;
                if (i >= args.length) {
                    CreateSignature.usage();
                    System.exit(1);
                }
                tsaUrl = args[i];
            }
            if (args[i].equals("-e")) {
                externalSig = true;
            }
        }
        // load the keystore
        java.security.KeyStore keystore = java.security.KeyStore.getInstance("PKCS12");
        char[] password = args[1].toCharArray();// TODO use Java 6 java.io.Console.readPassword

        keystore.load(new java.io.FileInputStream(args[0]), password);
        // TODO alias command line argument
        // sign PDF
        CreateSignature signing = new CreateSignature(keystore, password);
        signing.setExternalSigning(externalSig);
        java.io.File inFile = new java.io.File(args[2]);
        String name = inFile.getName();
        String substring = name.substring(0, name.lastIndexOf('.'));
        java.io.File outFile = new java.io.File(inFile.getParent(), substring + "_signed.pdf");
        signing.signDetached(inFile, outFile, tsaUrl);
    }

    private static void usage() {
        System.err.println((((((("usage: java " + CreateSignature.class.getName()) + " ") + "<pkcs12_keystore> <password> <pdf_to_sign>\n") + "") + "options:\n") + "  -tsa <url>    sign timestamp using the given TSA server\n") + "  -e            sign using external signature creation scenario");
    }
}