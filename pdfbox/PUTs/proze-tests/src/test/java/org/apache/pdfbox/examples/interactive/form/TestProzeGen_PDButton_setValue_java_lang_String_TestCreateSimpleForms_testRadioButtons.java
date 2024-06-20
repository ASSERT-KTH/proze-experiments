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

import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
import org.apache.pdfbox.rendering.PDFRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test of some the form examples.
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_TestCreateSimpleForms_testRadioButtons {
    public TestProzeGen_PDButton_setValue_java_lang_String_TestCreateSimpleForms_testRadioButtons() {
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        new PDFRenderer(doc1).renderImage(0);
        PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        PDRadioButton radioButton1 = ((PDRadioButton) (acroForm1.getField("MyRadioButton")));
        // assertEquals(3, radioButton1.getWidgets().size());
        // assertEquals("c", radioButton1.getValue());
        // assertEquals(1, radioButton1.getSelectedExportValues().size());
        // assertEquals("c", radioButton1.getSelectedExportValues().get(0));
        // assertEquals(3, radioButton1.getExportValues().size());
        // assertEquals("a", radioButton1.getExportValues().get(0));
        // assertEquals("b", radioButton1.getExportValues().get(1));
        // assertEquals("c", radioButton1.getExportValues().get(2));
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        radioButton1.setValue(param0);
        doc1.save("target/RadioButtonsSample-modified.pdf");
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
        org.junit.jupiter.params.provider.Arguments.of("Checking"),
        org.junit.jupiter.params.provider.Arguments.of("Off"),
        org.junit.jupiter.params.provider.Arguments.of("Option1"),
        org.junit.jupiter.params.provider.Arguments.of("Option3"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton01"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton02"),
        org.junit.jupiter.params.provider.Arguments.of("Value01"),
        org.junit.jupiter.params.provider.Arguments.of("Value02"),
        org.junit.jupiter.params.provider.Arguments.of("Yes"),
        org.junit.jupiter.params.provider.Arguments.of("c"),
        org.junit.jupiter.params.provider.Arguments.of("b"),
        org.junit.jupiter.params.provider.Arguments.of("Invalid")
        );
    }
}