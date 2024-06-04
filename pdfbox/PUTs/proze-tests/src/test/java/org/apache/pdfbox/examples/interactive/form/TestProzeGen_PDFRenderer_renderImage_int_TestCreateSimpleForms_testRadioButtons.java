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
package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test of some the form examples.
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testRadioButtons {
    public TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testRadioButtons() {
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        assertEquals(3, radioButton1.getWidgets().size());
        assertEquals("c", radioButton1.getValue());
        assertEquals(1, radioButton1.getSelectedExportValues().size());
        assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        assertEquals(3, radioButton1.getExportValues().size());
        assertEquals("a", radioButton1.getExportValues().get(0));
        assertEquals("b", radioButton1.getExportValues().get(1));
        assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        assertEquals("b", radioButton2.getValue());
        assertEquals(1, radioButton2.getSelectedExportValues().size());
        assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    private org.apache.pdfbox.pdmodel.font.PDFont getFontFromWidgetResources(org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox, String fontResourceName) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = widget.getAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream appearanceStream = normalAppearance.getAppearanceStream();
        org.apache.pdfbox.pdmodel.PDResources resources = appearanceStream.getResources();
        return resources.getFont(org.apache.pdfbox.cos.COSName.getPDFName(fontResourceName));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_1(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_2(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_3(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_4(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_5(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_6(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_7(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_8(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_9(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_10(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_11(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_12(int param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue("b");
        doc1.save("target/RadioButtonsSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        // assertEquals("b", radioButton2.getValue());
        // assertEquals(1, radioButton2.getSelectedExportValues().size());
        // assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}