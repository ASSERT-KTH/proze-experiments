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
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
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
public class TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453 {
    /**
     * Logger instance.
     */
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.class);

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
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.testResultsDir.mkdirs();
        if (javax.crypto.Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {
            // we need strong encryption for these tests
            fail("JCE unlimited strength jurisdiction policy files are not installed");
        }
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission = new org.apache.pdfbox.pdmodel.encryption.AccessPermission();
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanAssembleDocument(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanExtractContent(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanExtractForAccessibility(true);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanFillInForm(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanModify(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanModifyAnnotations(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanPrint(true);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setCanPrintDegraded(false);
        org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.permission.setReadOnly();
    }

    /**
     * PDFBOX-4453: verify that identical encrypted strings are really decrypted each.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4453(int param0) throws IOException {
        final int TESTCOUNT = 1000;
        java.io.File file = new java.io.File(org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.testResultsDir, "PDFBOX-4453.pdf");
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        for (int i = 0; i < TESTCOUNT; ++i) {
            // strings must be in different dictionaries so that the actual
            // encryption key changes
            org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
            doc.getPage(0).getCOSObject().setItem(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i), dict);
            // need two different keys so that there are both encrypted and decrypted COSStrings
            // with value "0"
            dict.setString("key1", "3");
            dict.setString("key2", "0");
        }
        org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy spp = new org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy("12345", "", new org.apache.pdfbox.pdmodel.encryption.AccessPermission());
        spp.setEncryptionKeyLength(param0);
        spp.setPreferAES(false);
        doc.protect(spp);
        doc.save(file);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        assertTrue(doc.isEncrypted());
        for (int i = 0; i < TESTCOUNT; ++i) {
            org.apache.pdfbox.cos.COSDictionary dict = doc.getPage(0).getCOSObject().getCOSDictionary(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i));
            assertEquals("3", dict.getString("key1"));
            assertEquals("0", dict.getString("key2"));
        }
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4453_1(int param0) throws IOException {
        final int TESTCOUNT = 1000;
        java.io.File file = new java.io.File(org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.testResultsDir, "PDFBOX-4453.pdf");
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        for (int i = 0; i < TESTCOUNT; ++i) {
            // strings must be in different dictionaries so that the actual
            // encryption key changes
            org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
            doc.getPage(0).getCOSObject().setItem(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i), dict);
            // need two different keys so that there are both encrypted and decrypted COSStrings
            // with value "0"
            dict.setString("key1", "3");
            dict.setString("key2", "0");
        }
        org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy spp = new org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy("12345", "", new org.apache.pdfbox.pdmodel.encryption.AccessPermission());
        spp.setEncryptionKeyLength(param0);
        spp.setPreferAES(false);
        doc.protect(spp);
        doc.save(file);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        assertTrue(doc.isEncrypted());
        for (int i = 0; i < TESTCOUNT; ++i) {
            org.apache.pdfbox.cos.COSDictionary dict = doc.getPage(0).getCOSObject().getCOSDictionary(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i));
//            assertEquals("3", dict.getString("key1"));
//            assertEquals("0", dict.getString("key2"));
        };
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4453_2(int param0) throws IOException {
        final int TESTCOUNT = 1000;
        java.io.File file = new java.io.File(org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.testResultsDir, "PDFBOX-4453.pdf");
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        for (int i = 0; i < TESTCOUNT; ++i) {
            // strings must be in different dictionaries so that the actual
            // encryption key changes
            org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
            doc.getPage(0).getCOSObject().setItem(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i), dict);
            // need two different keys so that there are both encrypted and decrypted COSStrings
            // with value "0"
            dict.setString("key1", "3");
            dict.setString("key2", "0");
        }
        org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy spp = new org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy("12345", "", new org.apache.pdfbox.pdmodel.encryption.AccessPermission());
        spp.setEncryptionKeyLength(param0);
        spp.setPreferAES(false);
        doc.protect(spp);
        doc.save(file);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        // assertTrue(doc.isEncrypted());
        for (int i = 0; i < TESTCOUNT; ++i) {
            org.apache.pdfbox.cos.COSDictionary dict = doc.getPage(0).getCOSObject().getCOSDictionary(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i));
            assertEquals("3", dict.getString("key1"));
//            assertEquals("0", dict.getString("key2"));
        }
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4453_3(int param0) throws IOException {
        final int TESTCOUNT = 1000;
        java.io.File file = new java.io.File(org.apache.pdfbox.encryption.TestProzeGen_ProtectionPolicy_setEncryptionKeyLength_int_TestSymmetricKeyEncryption_testPDFBox4453.testResultsDir, "PDFBOX-4453.pdf");
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        for (int i = 0; i < TESTCOUNT; ++i) {
            // strings must be in different dictionaries so that the actual
            // encryption key changes
            org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
            doc.getPage(0).getCOSObject().setItem(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i), dict);
            // need two different keys so that there are both encrypted and decrypted COSStrings
            // with value "0"
            dict.setString("key1", "3");
            dict.setString("key2", "0");
        }
        org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy spp = new org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy("12345", "", new org.apache.pdfbox.pdmodel.encryption.AccessPermission());
        spp.setEncryptionKeyLength(param0);
        spp.setPreferAES(false);
        doc.protect(spp);
        doc.save(file);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        // assertTrue(doc.isEncrypted());
        for (int i = 0; i < TESTCOUNT; ++i) {
            org.apache.pdfbox.cos.COSDictionary dict = doc.getPage(0).getCOSObject().getCOSDictionary(org.apache.pdfbox.cos.COSName.getPDFName("_Test-" + i));
//            assertEquals("3", dict.getString("key1"));
            assertEquals("0", dict.getString("key2"));
        }
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(128),
        org.junit.jupiter.params.provider.Arguments.of(256),
        org.junit.jupiter.params.provider.Arguments.of(40)
        );
    }
}