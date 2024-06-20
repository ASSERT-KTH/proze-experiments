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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests for symmetric key encryption.
 *
 * IMPORTANT! When making changes in the encryption / decryption methods, do
 * also check whether the six generated encrypted files (to be found in
 * pdfbox/target/test-output/crypto and named *encrypted.pdf) can be opened with
 * Adobe Reader by providing the owner password and the user password.
 *
 * @author Ralf Hauser
 * @author Tilman Hausherr
 */
// public class TestSymmetricKeyEncryption extends TestCase
public class TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions {
    /**
     * Logger instance.
     */
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.class);

    private static final java.io.File testResultsDir = new java.io.File("target/test-output/crypto");

    private static org.apache.pdfbox.pdmodel.encryption.AccessPermission permission;

    static final String USERPASSWORD = "1234567890abcdefghijk1234567890abcdefghijk";

    static final String OWNERPASSWORD = "abcdefghijk1234567890abcdefghijk1234567890";

    /**
     * {@inheritDoc }
     */
    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.testResultsDir.mkdirs();
        if (javax.crypto.Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {
            // we need strong encryption for these tests
            fail("JCE unlimited strength jurisdiction policy files are not installed");
        }
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanAssembleDocument(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanExtractContent(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanExtractForAccessibility(true);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanFillInForm(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanModify(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanModifyAnnotations(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanPrint(true);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setCanPrintDegraded(false);
        TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.permission.setReadOnly();
    }

    /**
     * Test that permissions work as intended: the user psw ("user") is enough
     * to open the PDF with possibly restricted rights, the owner psw ("owner")
     * gives full permissions. The 3 files of this test were created by Maruan
     * Sahyoun, NOT with PDFBox, but with Adobe Acrobat to ensure "the gold
     * standard". The restricted permissions prevent printing and text
     * extraction. In the 128 and 256 bit encrypted files, AssembleDocument,
     * ExtractForAccessibility and PrintDegraded are also disabled.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPermissions(boolean param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.AccessPermission fullAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        org.apache.pdfbox.pdmodel.encryption.AccessPermission restrAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        restrAP.setCanPrint(false);
        restrAP.setCanExtractContent(false);
        restrAP.setCanModify(param0);
        byte[] inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-40bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        restrAP.setCanAssembleDocument(false);
        restrAP.setCanExtractForAccessibility(false);
        restrAP.setCanPrintDegraded(false);
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-128bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-256bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
    }

    private void checkPerms(byte[] inputFileAsByteArray, String password, org.apache.pdfbox.pdmodel.encryption.AccessPermission expectedPermissions) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(inputFileAsByteArray, password);
        org.apache.pdfbox.pdmodel.encryption.AccessPermission currentAccessPermission = doc.getCurrentAccessPermission();
        // check permissions
        assertEquals(expectedPermissions.isOwnerPermission(), currentAccessPermission.isOwnerPermission());
        if (!expectedPermissions.isOwnerPermission()) {
            assertEquals(true, currentAccessPermission.isReadOnly());
        }
        assertEquals(expectedPermissions.canAssembleDocument(), currentAccessPermission.canAssembleDocument());
        assertEquals(expectedPermissions.canExtractContent(), currentAccessPermission.canExtractContent());
        assertEquals(expectedPermissions.canExtractForAccessibility(), currentAccessPermission.canExtractForAccessibility());
        assertEquals(expectedPermissions.canFillInForm(), currentAccessPermission.canFillInForm());
        assertEquals(expectedPermissions.canModify(), currentAccessPermission.canModify());
        assertEquals(expectedPermissions.canModifyAnnotations(), currentAccessPermission.canModifyAnnotations());
        assertEquals(expectedPermissions.canPrint(), currentAccessPermission.canPrint());
        assertEquals(expectedPermissions.canPrintDegraded(), currentAccessPermission.canPrintDegraded());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        doc.close();
    }

    private byte[] getFileResourceAsByteArray(String testFileName) throws java.io.IOException {
        return org.apache.pdfbox.io.IOUtils.toByteArray(TestProzeGen_AccessPermission_setCanModify_boolean_TestSymmetricKeyEncryption_testPermissions.class.getResourceAsStream(testFileName));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPermissions_1(boolean param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.AccessPermission fullAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        org.apache.pdfbox.pdmodel.encryption.AccessPermission restrAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        restrAP.setCanPrint(false);
        restrAP.setCanExtractContent(false);
        restrAP.setCanModify(param0);
        byte[] inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-40bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        restrAP.setCanAssembleDocument(false);
        restrAP.setCanExtractForAccessibility(false);
        restrAP.setCanPrintDegraded(false);
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-128bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-256bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPermissions_2(boolean param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.AccessPermission fullAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        org.apache.pdfbox.pdmodel.encryption.AccessPermission restrAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        restrAP.setCanPrint(false);
        restrAP.setCanExtractContent(false);
        restrAP.setCanModify(param0);
        byte[] inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-40bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        restrAP.setCanAssembleDocument(false);
        restrAP.setCanExtractForAccessibility(false);
        restrAP.setCanPrintDegraded(false);
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-128bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-256bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPermissions_3(boolean param0) throws Exception {
        org.apache.pdfbox.pdmodel.encryption.AccessPermission fullAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        org.apache.pdfbox.pdmodel.encryption.AccessPermission restrAP = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        restrAP.setCanPrint(false);
        restrAP.setCanExtractContent(false);
        restrAP.setCanModify(param0);
        byte[] inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-40bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        restrAP.setCanAssembleDocument(false);
        restrAP.setCanExtractForAccessibility(false);
        restrAP.setCanPrintDegraded(false);
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-128bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
//            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
        inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-256bit.pdf");
        checkPerms(inputFileAsByteArray, "owner", fullAP);
        checkPerms(inputFileAsByteArray, "user", restrAP);
        try {
            checkPerms(inputFileAsByteArray, "", null);
            fail("wrong password not detected");
        } catch (java.io.IOException ex) {
            assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(false),
        org.junit.jupiter.params.provider.Arguments.of(true)
        );
    }
}