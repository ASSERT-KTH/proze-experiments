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
public class TestProzeGen_PDDocument_save_java_lang_String_TestCreateSimpleForms_testRadioButtons {
    public TestProzeGen_PDDocument_save_java_lang_String_TestCreateSimpleForms_testRadioButtons() {
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton) (acroForm2.getField("MyRadioButton")));
        assertEquals("b", radioButton2.getValue());
        assertEquals(1, radioButton2.getSelectedExportValues().size());
        assertEquals("b", radioButton2.getSelectedExportValues().get(0));
        assertEquals(3, radioButton2.getExportValues().size());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtons_1(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_2(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_3(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_4(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_5(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_6(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_7(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_8(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_9(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_10(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_11(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
    public void testRadioButtons_12(String param0) throws java.io.IOException {
        CreateRadioButtons.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(0);
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
        doc1.save(param0);
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/RadioButtonsSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0);
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
        org.junit.jupiter.params.provider.Arguments.of("./000752-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1031.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1065.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1100.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxJoinFieldsMerge-TextFieldsOnly-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxLegacyMerge-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation-same-name-off.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation-same-name.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/overlay1.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/text-doc.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/text-with-form-overlay.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/clone/clone-dst.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/clone/clone-src.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/multitiff.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletiff.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletifffrombi.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletifffromchessbi.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/JpegMultiMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/MergerOpenActionTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged3.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeIndirectObjectTest.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeSingleDirectObjectTest.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeSingleIndirectObjectTest.pdf"),
                org.junit.jupiter.params.provider.Arguments.of("target/CheckBoxSample-modified.pdf"),
                org.junit.jupiter.params.provider.Arguments.of("target/RadioButtonsSample-modified.pdf")
        );
    }
}