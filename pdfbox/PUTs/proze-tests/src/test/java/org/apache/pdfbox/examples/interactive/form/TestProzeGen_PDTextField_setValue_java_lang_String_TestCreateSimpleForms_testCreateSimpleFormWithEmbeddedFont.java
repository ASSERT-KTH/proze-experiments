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

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test of some the form examples.
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDTextField_setValue_java_lang_String_TestCreateSimpleForms_testCreateSimpleFormWithEmbeddedFont {
    public TestProzeGen_PDTextField_setValue_java_lang_String_TestCreateSimpleForms_testCreateSimpleFormWithEmbeddedFont() {
    }

    /**
     * Test of CreateSimpleFormWithEmbeddedFont
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateSimpleFormWithEmbeddedFont(String param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue(param0);
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
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateSimpleFormWithEmbeddedFont_1(String param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue(param0);
        org.apache.pdfbox.pdmodel.font.PDFont font = getFontFromWidgetResources(textBox, "F1");
        // assertEquals("LiberationSans", font.getName());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateSimpleFormWithEmbeddedFont_2(String param0) throws java.io.IOException {
        CreateSimpleFormWithEmbeddedFont.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleFormWithEmbeddedFont.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field İ", textBox.getValue());
        textBox.setValue(param0);
        org.apache.pdfbox.pdmodel.font.PDFont font = getFontFromWidgetResources(textBox, "F1");
        assertEquals("LiberationSans", font.getName());
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"),
        org.junit.jupiter.params.provider.Arguments.of("CR\rCR"),
        org.junit.jupiter.params.provider.Arguments.of("CRLF\r\nCRLF"),
        org.junit.jupiter.params.provider.Arguments.of("LFLF"),
        org.junit.jupiter.params.provider.Arguments.of("LFCR\n\rLFCR"),
        org.junit.jupiter.params.provider.Arguments.of("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline - Fixed"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline - auto"),
        org.junit.jupiter.params.provider.Arguments.of("SPACE SPACE"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline - Fixed"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline - auto"),
        org.junit.jupiter.params.provider.Arguments.of("TAB	TAB"),
        org.junit.jupiter.params.provider.Arguments.of("Test1"),
        org.junit.jupiter.params.provider.Arguments.of("Test2"),
        org.junit.jupiter.params.provider.Arguments.of("different layout"),
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
        org.junit.jupiter.params.provider.Arguments.of("Łódź")
        );
    }
}