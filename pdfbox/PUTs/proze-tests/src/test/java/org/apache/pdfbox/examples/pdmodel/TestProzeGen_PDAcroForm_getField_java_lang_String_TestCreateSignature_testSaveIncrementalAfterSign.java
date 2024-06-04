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
package org.apache.pdfbox.examples.pdmodel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for CreateSignature. Each test case will run twice: once with SignatureInterface
 * and once using external signature creation scenario.
 */
public class TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign {
    private static java.security.cert.CertificateFactory certificateFactory = null;

    private static java.security.KeyStore keyStore = null;

    private static final String inDir = "src/test/resources/org/apache/pdfbox/examples/signature/";

    private static final String outDir = "target/test-output/";

    private static final String keystorePath = TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.inDir + "keystore.p12";

    private static final String jpegPath = TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.inDir + "stamp.jpg";

    private static final String password = "123456";

    private static java.security.cert.Certificate certificate;

    private static String tsa;

    public boolean externallySign;

    /**
     * Values for {@link #externallySign} test parameter to specify if signing should be conducted
     * using externally signing scenario ({@code true}) or SignatureInterface ({@code false}).
     */
    public static java.util.Collection signingTypes() {
        return java.util.Arrays.asList(false, true);
    }

    @org.junit.jupiter.api.BeforeAll
    public static void init() throws Exception {
        java.security.Security.addProvider(org.apache.pdfbox.pdmodel.encryption.SecurityProvider.getProvider());
        TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
        // load the keystore
        TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore = java.security.KeyStore.getInstance("PKCS12");
        TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.load(new java.io.FileInputStream(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keystorePath), TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        new java.io.File("target/test-output").mkdirs();
        TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificate = TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.getCertificateChain(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.aliases().nextElement())[0];
        TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.tsa = System.getProperty("org.apache.pdfbox.examples.pdmodel.tsa");
    }

    private String getOutputFileName(String filePattern) {
        return java.text.MessageFormat.format(filePattern, externallySign ? "_ext" : "");
    }

    // This check fails with a file created with the code before PDFBOX-3011 was solved.
    private void checkSignature(java.io.File origFile, java.io.File signedFile, boolean checkTimeStamp) throws java.io.IOException, org.bouncycastle.cms.CMSException, org.bouncycastle.operator.OperatorCreationException, java.security.GeneralSecurityException, org.bouncycastle.tsp.TSPException, org.apache.pdfbox.examples.signature.cert.CertificateVerificationException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(origFile);
        // get string representation of pages COSObject
        String origPageKey = document.getDocumentCatalog().getCOSObject().getItem(org.apache.pdfbox.cos.COSName.PAGES).toString();
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(signedFile);
        // PDFBOX-4261: check that object number stays the same
        assertEquals(origPageKey, document.getDocumentCatalog().getCOSObject().getItem(org.apache.pdfbox.cos.COSName.PAGES).toString());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature> signatureDictionaries = document.getSignatureDictionaries();
        if (signatureDictionaries.isEmpty()) {
            fail("no signature found");
        }
        for (org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature sig : document.getSignatureDictionaries()) {
            byte[] contents = sig.getContents();
            byte[] buf = sig.getSignedContent(new java.io.FileInputStream(signedFile));
            // verify that getSignedContent() brings the same content
            // regardless whether from an InputStream or from a byte array
            java.io.FileInputStream fis2 = new java.io.FileInputStream(signedFile);
            byte[] buf2 = sig.getSignedContent(org.apache.pdfbox.io.IOUtils.toByteArray(fis2));
            assertArrayEquals(buf, buf2);
            fis2.close();
            // verify that all getContents() methods returns the same content
            java.io.FileInputStream fis3 = new java.io.FileInputStream(signedFile);
            byte[] contents2 = sig.getContents(org.apache.pdfbox.io.IOUtils.toByteArray(fis3));
            assertArrayEquals(contents, contents2);
            fis3.close();
            byte[] contents3 = sig.getContents(new java.io.FileInputStream(signedFile));
            assertArrayEquals(contents, contents3);
            // inspiration:
            // http://stackoverflow.com/a/26702631/535646
            // http://stackoverflow.com/a/9261365/535646
            org.bouncycastle.cms.CMSSignedData signedData = new org.bouncycastle.cms.CMSSignedData(new org.bouncycastle.cms.CMSProcessableByteArray(buf), contents);
            org.bouncycastle.util.Store certificatesStore = signedData.getCertificates();
            java.util.Collection<org.bouncycastle.cms.SignerInformation> signers = signedData.getSignerInfos().getSigners();
            org.bouncycastle.cms.SignerInformation signerInformation = signers.iterator().next();
            java.util.Collection matches = certificatesStore.getMatches(((org.bouncycastle.util.Selector<org.bouncycastle.cert.X509CertificateHolder>) (signerInformation.getSID())));
            org.bouncycastle.cert.X509CertificateHolder certificateHolder = ((org.bouncycastle.cert.X509CertificateHolder) (matches.iterator().next()));
            assertArrayEquals(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificate.getEncoded(), certificateHolder.getEncoded());
            // CMSVerifierCertificateNotValidException means that the keystore wasn't valid at signing time
            if (!signerInformation.verify(new org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder().build(certificateHolder))) {
                fail("Signature verification failed");
            }
            org.bouncycastle.tsp.TimeStampToken timeStampToken = org.apache.pdfbox.examples.signature.SigUtils.extractTimeStampTokenFromSignerInformation(signerInformation);
            if (checkTimeStamp) {
                assertNotNull(timeStampToken);
                org.apache.pdfbox.examples.signature.SigUtils.validateTimestampToken(timeStampToken);
                org.bouncycastle.tsp.TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                // compare the hash of the signed content with the hash in the timestamp
                byte[] tsMessageImprintDigest = timeStampInfo.getMessageImprintDigest();
                String hashAlgorithm = timeStampInfo.getMessageImprintAlgOID().getId();
                byte[] sigMessageImprintDigest = java.security.MessageDigest.getInstance(hashAlgorithm).digest(signerInformation.getSignature());
                assertArrayEquals(sigMessageImprintDigest, tsMessageImprintDigest,
                        "timestamp signature verification failed");
                org.bouncycastle.util.Store<org.bouncycastle.cert.X509CertificateHolder> tsCertStore = timeStampToken.getCertificates();
                // get the certificate from the timeStampToken
                // TimeStampToken.getSID() is untyped
                @SuppressWarnings("unchecked")
                java.util.Collection<org.bouncycastle.cert.X509CertificateHolder> tsCertStoreMatches = tsCertStore.getMatches(timeStampToken.getSID());
                org.bouncycastle.cert.X509CertificateHolder certHolderFromTimeStamp = tsCertStoreMatches.iterator().next();
                java.security.cert.X509Certificate certFromTimeStamp = new org.bouncycastle.cert.jcajce.JcaX509CertificateConverter().getCertificate(certHolderFromTimeStamp);
                org.apache.pdfbox.examples.signature.SigUtils.checkTimeStampCertificateUsage(certFromTimeStamp);
                org.apache.pdfbox.examples.signature.SigUtils.verifyCertificateChain(tsCertStore, certFromTimeStamp, timeStampInfo.getGenTime());
            } else {
                assertNull(timeStampToken);
            }
        }
        document.close();
    }
    
    /**
     * Create a simple form PDF, sign it, reload it, change a field value, incrementally save it.
     * This should not break the signature, and the value and its display must have changed as
     * expected. Do this both for the old and new incremental save methods.
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        assertEquals(expectedData.getData().length, actualData.getData().length);
        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        assertEquals(expectedData.getData().length, actualData.getData().length);
        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_1(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_2(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_3(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_4(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_5(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_6(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
//        assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_7(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
//        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_8(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_9(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_10(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_11(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_12(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
//        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_13(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_14(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_15(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_16(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
//        assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_17(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
//        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_18(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_19(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_20(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_21(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSaveIncrementalAfterSign_22(String param0) throws Exception {
        java.awt.image.BufferedImage oldImage;
        java.awt.image.BufferedImage expectedImage1;
        java.awt.image.BufferedImage actualImage1;
        java.awt.image.BufferedImage expectedImage2;
        java.awt.image.BufferedImage actualImage2;
        java.awt.image.DataBufferInt expectedData;
        java.awt.image.DataBufferInt actualData;
        org.apache.pdfbox.pdmodel.interactive.form.PDField field;
        java.io.FileOutputStream fileOutputStream;
        org.apache.pdfbox.examples.interactive.form.CreateSimpleForm.main(new String[0]);
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 1");
        java.util.Collection<org.apache.pdfbox.cos.COSName> fonts = ((java.util.Collection<org.apache.pdfbox.cos.COSName>) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getAppearanceStream().getResources().getFontNames()));
        // assertTrue(fonts.contains(org.apache.pdfbox.cos.COSName.HELV));
        // assertEquals(1, fonts.size());
        expectedImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage1.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage1.getHeight());
        // assertEquals(oldImage.getType(), expectedImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        doc.getDocumentCatalog().getCOSObject().setNeedToBeUpdated(true);
        doc.getDocumentCatalog().getAcroForm().getCOSObject().setNeedToBeUpdated(true);
        field.getCOSObject().setNeedToBeUpdated(true);
        field.getWidgets().get(0).getAppearance().getCOSObject().setNeedToBeUpdated(true);
        ((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())).setNeedToBeUpdated(true);
        doc.saveIncremental(fileOutputStream);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
//        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        field.setValue("New Value 2");
        expectedImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(oldImage.getWidth(), expectedImage2.getWidth());
        // assertEquals(oldImage.getHeight(), expectedImage2.getHeight());
        // assertEquals(oldImage.getType(), expectedImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (oldImage.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        // assertEquals(expectedData.getData().length, actualData.getData().length);
        // assertFalse(java.util.Arrays.equals(expectedData.getData(), actualData.getData()));
        java.util.Set<org.apache.pdfbox.cos.COSDictionary> objectsToWrite = new java.util.HashSet<org.apache.pdfbox.cos.COSDictionary>();
        objectsToWrite.add(field.getCOSObject());
        objectsToWrite.add(field.getWidgets().get(0).getAppearance().getCOSObject());
        objectsToWrite.add(((org.apache.pdfbox.cos.COSDictionary) (field.getWidgets().get(0).getAppearance().getNormalAppearance().getCOSObject())));
        doc.saveIncremental(fileOutputStream, objectsToWrite);
        doc.close();
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField(param0);
        // assertEquals("New Value 2", field.getValueAsString());
        actualImage2 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage2.getWidth(), actualImage2.getWidth());
        // assertEquals(expectedImage2.getHeight(), actualImage2.getHeight());
        // assertEquals(expectedImage2.getType(), actualImage2.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage2.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage2.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.BEITRAGSZAHLUNGSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.EINTRITTSALTER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.RISIKO"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.RISIKOOPTION"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERBUNDENE_LEBEN"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERLAUF"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSBEGINN"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSSUMME"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Medium-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide_Clipped-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Medium_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("BEITRAGSZAHLUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BEITRAGSZAHLUNG.ART"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.NUMMER"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("BU"),
        org.junit.jupiter.params.provider.Arguments.of("BU.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("BU.JHRLRENTE"),
        org.junit.jupiter.params.provider.Arguments.of("BU.KARENZZEIT"),
        org.junit.jupiter.params.provider.Arguments.of("BU.LEISTUNGSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("BU.VERSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.BEITRAGSBEFREIUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.DD"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.PFLEGE"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.PFLEGE_WERT"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.RENTENDYNAMIK"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.VERZICHT"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.ZUZAHLUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BUZEUZ"),
        org.junit.jupiter.params.provider.Arguments.of("BUZEUZ.WAHL"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode1"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode2"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode3"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode4"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode5"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode6"),
        org.junit.jupiter.params.provider.Arguments.of("Checkbox"),
        org.junit.jupiter.params.provider.Arguments.of("Checkbox-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("CheckboxGroup"),
        org.junit.jupiter.params.provider.Arguments.of("Checking/Savings"),
        org.junit.jupiter.params.provider.Arguments.of("Country"),
        org.junit.jupiter.params.provider.Arguments.of("Customer"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Country"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Gender"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Name"),
        org.junit.jupiter.params.provider.Arguments.of("DM"),
        org.junit.jupiter.params.provider.Arguments.of("DM.VN"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK.PROZENT"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK.WAS"),
        org.junit.jupiter.params.provider.Arguments.of("Date you are available"),
        org.junit.jupiter.params.provider.Arguments.of("EMP"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.MEHRERE"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.MEHRERE.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.ERGAENZENDE_ANGABEN"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.EXTRABLAETTER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.FOLGE_ANGABEN"),
        org.junit.jupiter.params.provider.Arguments.of("Email address"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.12"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.03"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04.GEWICHT"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04.GROESSE"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.05"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.06"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.A"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.B"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.C"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.D"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.E"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.F"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.G"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.H"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.I"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.A"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.B"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.C"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.D"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E_LI"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E_RE"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.11"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.13"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.14"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.16"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.17"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.18"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.19"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.9"),
        org.junit.jupiter.params.provider.Arguments.of("Field1"),
        org.junit.jupiter.params.provider.Arguments.of("Field2"),
        org.junit.jupiter.params.provider.Arguments.of("First name"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG.BRUTTO"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG.NETTO"),
        org.junit.jupiter.params.provider.Arguments.of("Gender"),
        org.junit.jupiter.params.provider.Arguments.of("GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("ID"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBLAND"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBLAND.VP"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBORT.VP"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.AMT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.DAT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.GUELTIG"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.NR"),
        org.junit.jupiter.params.provider.Arguments.of("ID.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.STAATSANGEHOERIGKEIT.VP"),
        org.junit.jupiter.params.provider.Arguments.of("JAWS user"),
        org.junit.jupiter.params.provider.Arguments.of("LAND"),
        org.junit.jupiter.params.provider.Arguments.of("Last Name"),
        org.junit.jupiter.params.provider.Arguments.of("LongRichTextField"),
        org.junit.jupiter.params.provider.Arguments.of("MANDANT"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline"),
        org.junit.jupiter.params.provider.Arguments.of("MultilineAutoscale"),
        org.junit.jupiter.params.provider.Arguments.of("MultipeAnnotations-SameLayout"),
        org.junit.jupiter.params.provider.Arguments.of("MultipleAnnotations-DifferentLayout"),
        org.junit.jupiter.params.provider.Arguments.of("Name"),
        org.junit.jupiter.params.provider.Arguments.of("QR"),
        org.junit.jupiter.params.provider.Arguments.of("QR.TRIGGER"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButtonGroup"),
        org.junit.jupiter.params.provider.Arguments.of("RichTextField-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT.2"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT.2.1"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.ANDERER"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.BANK"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.IBAN"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("SignatureField"),
        org.junit.jupiter.params.provider.Arguments.of("SingleAnnotation"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline"),
        org.junit.jupiter.params.provider.Arguments.of("SinglelineAutoscale"),
        org.junit.jupiter.params.provider.Arguments.of("Speichern"),
        org.junit.jupiter.params.provider.Arguments.of("TARIF"),
        org.junit.jupiter.params.provider.Arguments.of("TARIFGENERATION"),
        org.junit.jupiter.params.provider.Arguments.of("Telephone"),
        org.junit.jupiter.params.provider.Arguments.of("Testfeld"),
        org.junit.jupiter.params.provider.Arguments.of("Testfeld2"),
        org.junit.jupiter.params.provider.Arguments.of("Text2"),
        org.junit.jupiter.params.provider.Arguments.of("TextField"),
        org.junit.jupiter.params.provider.Arguments.of("TextField-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("UNT"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.1"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.1.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.2"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.2.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.3"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.3.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UZV"),
        org.junit.jupiter.params.provider.Arguments.of("UZV.PROZENT"),
        org.junit.jupiter.params.provider.Arguments.of("UZV.WAS"),
        org.junit.jupiter.params.provider.Arguments.of("VN"),
        org.junit.jupiter.params.provider.Arguments.of("VN.ANREDE"),
        org.junit.jupiter.params.provider.Arguments.of("VN.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBDATUM"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBURTSNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VN.LAND"),
        org.junit.jupiter.params.provider.Arguments.of("VN.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("VN.ORT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.PLZ"),
        org.junit.jupiter.params.provider.Arguments.of("VN.PLZ.0"),
        org.junit.jupiter.params.provider.Arguments.of("VN.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.STRASSE"),
        org.junit.jupiter.params.provider.Arguments.of("VN.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("VN.TITEL"),
        org.junit.jupiter.params.provider.Arguments.of("VN.VORNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP"),
        org.junit.jupiter.params.provider.Arguments.of("VP.ANREDE"),
        org.junit.jupiter.params.provider.Arguments.of("VP.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("VP.FAMILIENSTAND"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBDATUM"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBURTSNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP.LAND"),
        org.junit.jupiter.params.provider.Arguments.of("VP.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP.ORT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.PLZ"),
        org.junit.jupiter.params.provider.Arguments.of("VP.PLZ.0"),
        org.junit.jupiter.params.provider.Arguments.of("VP.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.STRASSE"),
        org.junit.jupiter.params.provider.Arguments.of("VP.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("VP.TITEL"),
        org.junit.jupiter.params.provider.Arguments.of("VP.VORNAME"),
        org.junit.jupiter.params.provider.Arguments.of("WI"),
        org.junit.jupiter.params.provider.Arguments.of("WI.ANSCHRIFT"),
        org.junit.jupiter.params.provider.Arguments.of("WI.AS"),
        org.junit.jupiter.params.provider.Arguments.of("WI.BEZIEHUNG"),
        org.junit.jupiter.params.provider.Arguments.of("WI.GRUND"),
        org.junit.jupiter.params.provider.Arguments.of("WI.PERSON"),
        org.junit.jupiter.params.provider.Arguments.of("ZIP code"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-cr"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-crlf"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-lf"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-lfcr"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-space"),
        org.junit.jupiter.params.provider.Arguments.of("drucken"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName1"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName2"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName3"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName4"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Country"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Gender"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Name"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName6"),
        org.junit.jupiter.params.provider.Arguments.of("filled"),
        org.junit.jupiter.params.provider.Arguments.of("foo"),
        org.junit.jupiter.params.provider.Arguments.of("form1[0]"),
        org.junit.jupiter.params.provider.Arguments.of("hilfe"),
        org.junit.jupiter.params.provider.Arguments.of("insert"),
        org.junit.jupiter.params.provider.Arguments.of("insert.datum"),
        org.junit.jupiter.params.provider.Arguments.of("insert.nummer"),
        org.junit.jupiter.params.provider.Arguments.of("insert.uhr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-cr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-crlf"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-lf"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-lfcr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-nul"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-space"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-tab"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("reset"),
        org.junit.jupiter.params.provider.Arguments.of("weiter"),
        org.junit.jupiter.params.provider.Arguments.of("zurueck"),
                org.junit.jupiter.params.provider.Arguments.of("SampleField"),
                org.junit.jupiter.params.provider.Arguments.of("MyCheckBox"),
                org.junit.jupiter.params.provider.Arguments.of("MyRadioButton")
        );
    }
}