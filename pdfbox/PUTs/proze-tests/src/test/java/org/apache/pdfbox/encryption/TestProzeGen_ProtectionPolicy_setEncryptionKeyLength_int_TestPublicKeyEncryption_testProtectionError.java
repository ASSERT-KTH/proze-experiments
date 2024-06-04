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
package org.apache.pdfbox.encryption;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for public key encryption. These tests are not perfect - to be sure, encrypt a file by
 * using a certificate exported from your digital id in Adobe Reader, and then open that file with
 * Adobe Reader. Do this with every key length.
 *
 * @author Ben Litchfield
 */
public class TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestPublicKeyEncryption_testProtectionError {
    private final java.io.File testResultsDir = new java.io.File("target/test-output/crypto");

    private org.apache.pdfbox.pdmodel.encryption.AccessPermission permission1;

    private org.apache.pdfbox.pdmodel.encryption.AccessPermission permission2;

    private org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient recipient1;

    private org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient recipient2;

    private String keyStore1;

    private String keyStore2;

    private String password1;

    private String password2;

    /**
     * Simple test document that gets encrypted by the test cases.
     */
    private org.apache.pdfbox.pdmodel.PDDocument document;

    private String text;

    private String producer;

    public int keyLength;

    /**
     * Values for keyLength test parameter.
     *
     * @return  */
    public static java.util.Collection keyLengths() {
        return java.util.Arrays.asList(40, 128, 256);
    }

    public TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestPublicKeyEncryption_testProtectionError() {
        testResultsDir.mkdirs();
    }

    /**
     * {@inheritDoc }
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        if (javax.crypto.Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {
            // we need strong encryption for these tests
            fail("JCE unlimited strength jurisdiction policy files are not installed");
        }
        permission1 = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        permission1.setCanAssembleDocument(false);
        permission1.setCanExtractContent(false);
        permission1.setCanExtractForAccessibility(true);
        permission1.setCanFillInForm(false);
        permission1.setCanModify(false);
        permission1.setCanModifyAnnotations(false);
        permission1.setCanPrint(false);
        permission1.setCanPrintDegraded(false);
        permission2 = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        permission2.setCanAssembleDocument(false);
        permission2.setCanExtractContent(false);
        permission2.setCanExtractForAccessibility(true);
        permission2.setCanFillInForm(false);
        permission2.setCanModify(false);
        permission2.setCanModifyAnnotations(false);
        permission2.setCanPrint(true);// it is true now !

        permission2.setCanPrintDegraded(false);
        recipient1 = getRecipient("test1.der", permission1);
        recipient2 = getRecipient("test2.der", permission2);
        password1 = "test1";
        password2 = "test2";
        keyStore1 = "test1.pfx";
        keyStore2 = "test2.pfx";
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(this.getClass().getResource("test.pdf").toURI()));
        text = new org.apache.pdfbox.text.PDFTextStripper().getText(document);
        producer = document.getDocumentInformation().getProducer();
        document.setVersion(1.7F);
    }

    /**
     * {@inheritDoc }
     */
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        document.close();
    }

    /**
     * Protect a document with certificate 1 and try to open it with
     * certificate 2 and catch the exception.
     *
     * @throws Exception
     * 		If there is an unexpected error during the test.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProtectionError(int param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy policy = new org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        policy.setEncryptionKeyLength(param0);
        document.protect(policy);
        org.apache.pdfbox.pdmodel.PDDocument encryptedDoc = null;
        try {
            java.io.File file = save("testProtectionError");
            encryptedDoc = reload(file, password2, getKeyStore(keyStore2));
            assertTrue(encryptedDoc.isEncrypted());
            fail("No exception when using an incorrect decryption key");
        } catch (java.io.IOException ex) {
            String msg = ex.getMessage();
            assertTrue(msg.contains("serial-#: rid 2 vs. cert 3"),
                    "not the expected exception: " + msg);
        } finally {
            if (encryptedDoc != null) {
                encryptedDoc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProtectionError_1(int param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy policy = new org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        policy.setEncryptionKeyLength(param0);
        document.protect(policy);
        org.apache.pdfbox.pdmodel.PDDocument encryptedDoc = null;
        try {
            java.io.File file = save("testProtectionError");
            encryptedDoc = reload(file, password2, getKeyStore(keyStore2));
            assertTrue(encryptedDoc.isEncrypted());
            fail("No exception when using an incorrect decryption key");
        } catch (java.io.IOException ex) {
            String msg = ex.getMessage();
//            assertTrue(msg.contains("serial-#: rid 2 vs. cert 3"),
//                    "not the expected exception: " + msg);
        } finally {
            if (encryptedDoc != null) {
                encryptedDoc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProtectionError_2(int param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy policy = new org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        policy.setEncryptionKeyLength(param0);
        document.protect(policy);
        org.apache.pdfbox.pdmodel.PDDocument encryptedDoc = null;
        try {
            java.io.File file = save("testProtectionError");
            encryptedDoc = reload(file, password2, getKeyStore(keyStore2));
//            assertTrue(encryptedDoc.isEncrypted());
            fail("No exception when using an incorrect decryption key");
        } catch (java.io.IOException ex) {
            String msg = ex.getMessage();
            assertTrue(msg.contains("serial-#: rid 2 vs. cert 3"),
                    "not the expected exception: " + msg);
        } finally {
            if (encryptedDoc != null) {
                encryptedDoc.close();
            }
        }
    }

    /**
     * Reloads the given document from a file and check some contents.
     *
     * @param file
     * 		input file
     * @param decryptionPassword
     * 		password to be used to decrypt the doc
     * @param keyStore
     * 		password to be used to decrypt the doc
     * @return reloaded document
     * @throws Exception
     * 		if
     */
    private org.apache.pdfbox.pdmodel.PDDocument reload(java.io.File file, String decryptionPassword, java.io.InputStream keyStore) throws java.io.IOException, java.security.NoSuchAlgorithmException {
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(file, decryptionPassword, keyStore, null, org.apache.pdfbox.io.MemoryUsageSetting.setupMainMemoryOnly());
        assertEquals(text, new org.apache.pdfbox.text.PDFTextStripper().getText(doc2),
                "Extracted text is different");
        assertEquals(producer, doc2.getDocumentInformation().getProducer(),
                "Producer is different");
        return doc2;
    }

    /**
     * Returns a recipient specification with the given access permissions
     * and an X.509 certificate read from the given classpath resource.
     *
     * @param certificate
     * 		X.509 certificate resource, relative to this class
     * @param permission
     * 		access permissions
     * @return recipient specification
     * @throws Exception
     * 		if the certificate could not be read
     */
    private org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient getRecipient(String certificate, org.apache.pdfbox.pdmodel.encryption.AccessPermission permission) throws Exception {
        java.io.InputStream input = TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestPublicKeyEncryption_testProtectionError.class.getResourceAsStream(certificate);
        try {
            java.security.cert.CertificateFactory factory = java.security.cert.CertificateFactory.getInstance("X.509");
            org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient recipient = new org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient();
            recipient.setPermission(permission);
            recipient.setX509(((java.security.cert.X509Certificate) (factory.generateCertificate(input))));
            return recipient;
        } finally {
            input.close();
        }
    }

    private java.io.InputStream getKeyStore(String name) {
        return TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestPublicKeyEncryption_testProtectionError.class.getResourceAsStream(name);
    }

    private java.io.File save(String name) throws java.io.IOException {
        java.io.File file = new java.io.File(testResultsDir, ((name + "-") + keyLength) + "bit.pdf");
        document.save(file);
        return file;
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(128),
        org.junit.jupiter.params.provider.Arguments.of(256),
        org.junit.jupiter.params.provider.Arguments.of(40)
        );
    }
}