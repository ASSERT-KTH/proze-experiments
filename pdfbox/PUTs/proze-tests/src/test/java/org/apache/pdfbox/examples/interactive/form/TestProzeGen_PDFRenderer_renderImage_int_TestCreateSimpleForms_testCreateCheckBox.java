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
public class TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testCreateCheckBox {
    public TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testCreateCheckBox() {
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateCheckBox(int param0) throws java.io.IOException {
        CreateCheckBox.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm1.getField("MyCheckBox")));
        assertEquals("Yes", checkbox1.getOnValue());
        assertEquals("Off", checkbox1.getValue());
        checkbox1.check();
        assertEquals("Yes", checkbox1.getValue());
        doc1.save("target/CheckBoxSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm2.getField("MyCheckBox")));
        assertEquals("Yes", checkbox2.getValue());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateCheckBox_1(int param0) throws java.io.IOException {
        CreateCheckBox.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm1.getField("MyCheckBox")));
        assertEquals("Yes", checkbox1.getOnValue());
        // assertEquals("Off", checkbox1.getValue());
        checkbox1.check();
        // assertEquals("Yes", checkbox1.getValue());
        doc1.save("target/CheckBoxSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm2.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox2.getValue());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateCheckBox_2(int param0) throws java.io.IOException {
        CreateCheckBox.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm1.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox1.getOnValue());
        assertEquals("Off", checkbox1.getValue());
        checkbox1.check();
        // assertEquals("Yes", checkbox1.getValue());
        doc1.save("target/CheckBoxSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm2.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox2.getValue());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateCheckBox_3(int param0) throws java.io.IOException {
        CreateCheckBox.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm1.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox1.getOnValue());
        // assertEquals("Off", checkbox1.getValue());
        checkbox1.check();
        assertEquals("Yes", checkbox1.getValue());
        doc1.save("target/CheckBoxSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm2.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox2.getValue());
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateCheckBox_4(int param0) throws java.io.IOException {
        CreateCheckBox.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm1 = doc1.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox1 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm1.getField("MyCheckBox")));
        // assertEquals("Yes", checkbox1.getOnValue());
        // assertEquals("Off", checkbox1.getValue());
        checkbox1.check();
        // assertEquals("Yes", checkbox1.getValue());
        doc1.save("target/CheckBoxSample-modified.pdf");
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/CheckBoxSample-modified.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox) (acroForm2.getField("MyCheckBox")));
        assertEquals("Yes", checkbox2.getValue());
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