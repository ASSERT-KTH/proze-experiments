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

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for CreateSignature. Each test case will run twice: once with SignatureInterface
 * and once using external signature creation scenario.
 */
public class TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign {
    private static java.security.cert.CertificateFactory certificateFactory = null;

    private static java.security.KeyStore keyStore = null;

    private static final String inDir = "src/test/resources/org/apache/pdfbox/examples/signature/";

    private static final String outDir = "target/test-output/";

    private static final String keystorePath = TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.inDir + "keystore.p12";

    private static final String jpegPath = TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.inDir + "stamp.jpg";

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
        TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
        // load the keystore
        TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore = java.security.KeyStore.getInstance("PKCS12");
        TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.load(new java.io.FileInputStream(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keystorePath), TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        new java.io.File("target/test-output").mkdirs();
        TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificate = TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.getCertificateChain(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore.aliases().nextElement())[0];
        TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.tsa = System.getProperty("org.apache.pdfbox.examples.pdmodel.tsa");
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
            assertArrayEquals(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.certificate.getEncoded(), certificateHolder.getEncoded());
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
        // assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
    @NullSource
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
        org.apache.pdfbox.examples.signature.CreateSignature signing = new org.apache.pdfbox.examples.signature.CreateSignature(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.keyStore, TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.password.toCharArray());
        signing.setExternalSigning(externallySign);
        final String fileNameSigned = getOutputFileName("SimpleForm_signed{0}.pdf");
        final String fileNameResaved1 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved1.pdf");
        final String fileNameResaved2 = getOutputFileName("SimpleForm_signed{0}_incrementallyresaved2.pdf");
        signing.signDetached(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir + fileNameSigned));
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned), false);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        oldImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved1));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        // assertEquals("New Value 1", field.getValueAsString());
        actualImage1 = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        // assertEquals(expectedImage1.getWidth(), actualImage1.getWidth());
        // assertEquals(expectedImage1.getHeight(), actualImage1.getHeight());
        // assertEquals(expectedImage1.getType(), actualImage1.getType());
        expectedData = ((java.awt.image.DataBufferInt) (expectedImage1.getRaster().getDataBuffer()));
        actualData = ((java.awt.image.DataBufferInt) (actualImage1.getRaster().getDataBuffer()));
//        assertArrayEquals(expectedData.getData(), actualData.getData());
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameSigned));
        fileOutputStream = new java.io.FileOutputStream(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
        field.setValue(param0);
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
        checkSignature(new java.io.File("target/SimpleForm.pdf"), new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2), false);
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_TestCreateSignature_testSaveIncrementalAfterSign.outDir, fileNameResaved2));
        field = doc.getDocumentCatalog().getAcroForm().getField("SampleField");
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
        org.junit.jupiter.params.provider.Arguments.of("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"),
        org.junit.jupiter.params.provider.Arguments.of("CR\rCR"),
        org.junit.jupiter.params.provider.Arguments.of("CRLF\r\nCRLF"),
        org.junit.jupiter.params.provider.Arguments.of("Checking"),
        org.junit.jupiter.params.provider.Arguments.of("LFLF"),
        org.junit.jupiter.params.provider.Arguments.of("LFCR\n\rLFCR"),
        org.junit.jupiter.params.provider.Arguments.of("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline - Fixed"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline - auto"),
        org.junit.jupiter.params.provider.Arguments.of("Off"),
        org.junit.jupiter.params.provider.Arguments.of("Option1"),
        org.junit.jupiter.params.provider.Arguments.of("Option3"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton01"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton02"),
        org.junit.jupiter.params.provider.Arguments.of("SPACE SPACE"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline - Fixed"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline - auto"),
        org.junit.jupiter.params.provider.Arguments.of("TAB	TAB"),
        org.junit.jupiter.params.provider.Arguments.of("Test1"),
        org.junit.jupiter.params.provider.Arguments.of("Test2"),
        org.junit.jupiter.params.provider.Arguments.of("Value01"),
        org.junit.jupiter.params.provider.Arguments.of("Value02"),
        org.junit.jupiter.params.provider.Arguments.of("Yes"),
        org.junit.jupiter.params.provider.Arguments.of("c"),
        org.junit.jupiter.params.provider.Arguments.of("different layout"),
        org.junit.jupiter.params.provider.Arguments.of("export01"),
        org.junit.jupiter.params.provider.Arguments.of("export03"),
        org.junit.jupiter.params.provider.Arguments.of("field value"),
        org.junit.jupiter.params.provider.Arguments.of("linebreak linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("paragraphbreak paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation0Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation180Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation270Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation90Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation0Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation180Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation270Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation90Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("same layout"),
        org.junit.jupiter.params.provider.Arguments.of("sdfASDF1234äöü"),
        org.junit.jupiter.params.provider.Arguments.of("single annotation"),
        org.junit.jupiter.params.provider.Arguments.of("New Value 1"),
        org.junit.jupiter.params.provider.Arguments.of("New Value 2")
        );
    }
}