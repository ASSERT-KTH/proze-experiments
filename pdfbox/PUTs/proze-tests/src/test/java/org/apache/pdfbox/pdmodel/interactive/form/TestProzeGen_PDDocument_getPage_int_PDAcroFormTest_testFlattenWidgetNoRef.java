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
package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for the PDButton class.
 */
public class TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef {
    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
    }

    /* Same as above but remove the page reference from the widget annotation
    before doing the flatten() to ensure that the widgets page reference is properly looked up
    (PDFBOX-3301)
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testFlattenWidgetNoRef(int param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR, "AlignmentTests.pdf"));
        PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
        for (PDField field : acroForm.getFieldTree()) {
            for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget : field.getWidgets()) {
                widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.P);
            }
        }
        testPdf.getDocumentCatalog().getAcroForm().flatten();
        assertEquals(36, testPdf.getPage(param0).getAnnotations().size());
        assertTrue(testPdf.getDocumentCatalog().getAcroForm().getFields().isEmpty());
        java.io.File file = new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR, "AlignmentTests-flattened-noRef.pdf");
        testPdf.save(file);
        org.apache.pdfbox.rendering.TestPDFToImage testPDFToImage = new org.apache.pdfbox.rendering.TestPDFToImage(org.apache.pdfbox.rendering.TestPDFToImage.class.getName());
        if (!testPDFToImage.doTestFile(file, TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR.getAbsolutePath(), TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR.getAbsolutePath())) {
            // don't fail, rendering is different on different systems, result must be viewed manually
            System.out.println(((("Rendering of " + file) + " failed or is not identical to expected rendering in ") + TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR) + " directory");
        }
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws java.io.IOException {
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testFlattenWidgetNoRef_1(int param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR, "AlignmentTests.pdf"));
        PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
        for (PDField field : acroForm.getFieldTree()) {
            for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget : field.getWidgets()) {
                widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.P);
            }
        }
        testPdf.getDocumentCatalog().getAcroForm().flatten();
        assertEquals(36, testPdf.getPage(param0).getAnnotations().size());
        // assertTrue(testPdf.getDocumentCatalog().getAcroForm().getFields().isEmpty());
        java.io.File file = new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR, "AlignmentTests-flattened-noRef.pdf");
        testPdf.save(file);
        org.apache.pdfbox.rendering.TestPDFToImage testPDFToImage = new org.apache.pdfbox.rendering.TestPDFToImage(org.apache.pdfbox.rendering.TestPDFToImage.class.getName());
        if (!testPDFToImage.doTestFile(file, TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR.getAbsolutePath(), TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR.getAbsolutePath())) {
            // don't fail, rendering is different on different systems, result must be viewed manually
            System.out.println(((("Rendering of " + file) + " failed or is not identical to expected rendering in ") + TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR) + " directory");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testFlattenWidgetNoRef_2(int param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR, "AlignmentTests.pdf"));
        PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
        for (PDField field : acroForm.getFieldTree()) {
            for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget : field.getWidgets()) {
                widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.P);
            }
        }
        testPdf.getDocumentCatalog().getAcroForm().flatten();
        // assertEquals(36, testPdf.getPage(0).getAnnotations().size());
        assertTrue(testPdf.getDocumentCatalog().getAcroForm().getFields().isEmpty());
        java.io.File file = new java.io.File(TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR, "AlignmentTests-flattened-noRef.pdf");
        testPdf.save(file);
        org.apache.pdfbox.rendering.TestPDFToImage testPDFToImage = new org.apache.pdfbox.rendering.TestPDFToImage(org.apache.pdfbox.rendering.TestPDFToImage.class.getName());
        if (!testPDFToImage.doTestFile(file, TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR.getAbsolutePath(), TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.OUT_DIR.getAbsolutePath())) {
            // don't fail, rendering is different on different systems, result must be viewed manually
            System.out.println(((("Rendering of " + file) + " failed or is not identical to expected rendering in ") + TestProzeGen_PDDocument_getPage_int_PDAcroFormTest_testFlattenWidgetNoRef.IN_DIR) + " directory");
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(9)
        );
    }
}