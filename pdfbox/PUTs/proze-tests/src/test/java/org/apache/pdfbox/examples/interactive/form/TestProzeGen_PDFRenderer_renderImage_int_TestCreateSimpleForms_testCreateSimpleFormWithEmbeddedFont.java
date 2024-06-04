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
public class TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testCreateSimpleFormWithEmbeddedFont {
    public TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testCreateSimpleFormWithEmbeddedFont() {
    }

    /**
     * Test of CreateSimpleFormWithEmbeddedFont
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateSimpleFormWithEmbeddedFont(int param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue("Łódź");
        org.apache.pdfbox.pdmodel.font.PDFont font = getFontFromWidgetResources(textBox, "F1");
        assertEquals("LiberationSans", font.getName());
        doc.close();
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
    public void testCreateSimpleFormWithEmbeddedFont_1(int param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue("Łódź");
        org.apache.pdfbox.pdmodel.font.PDFont font = getFontFromWidgetResources(textBox, "F1");
        // assertEquals("LiberationSans", font.getName());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateSimpleFormWithEmbeddedFont_2(int param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue("Łódź");
        org.apache.pdfbox.pdmodel.font.PDFont font = getFontFromWidgetResources(textBox, "F1");
        assertEquals("LiberationSans", font.getName());
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}