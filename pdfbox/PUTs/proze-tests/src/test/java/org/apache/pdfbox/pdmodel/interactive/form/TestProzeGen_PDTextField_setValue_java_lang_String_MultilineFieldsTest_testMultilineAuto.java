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

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    private static final String NAME_OF_PDF = "MultilineFields.pdf";

    private static final String TEST_VALUE = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " + "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam";

    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws java.io.IOException {
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.NAME_OF_PDF));
        acroForm = document.getDocumentCatalog().getAcroForm();
        TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.OUT_DIR.mkdirs();
    }

    // Test for PDFBOX-3812
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMultilineAuto(String param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, "PDFBOX3812-acrobat-multiline-auto.pdf"));
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDTextField fieldMultiline = ((PDTextField) (acroForm.getField("Multiline")));
        float fontSizeMultiline = getFontSizeFromAppearanceStream(fieldMultiline);
        PDTextField fieldSingleline = ((PDTextField) (acroForm.getField("Singleline")));
        float fontSizeSingleline = getFontSizeFromAppearanceStream(fieldSingleline);
        PDTextField fieldMultilineAutoscale = ((PDTextField) (acroForm.getField("MultilineAutoscale")));
        float fontSizeMultilineAutoscale = getFontSizeFromAppearanceStream(fieldMultilineAutoscale);
        PDTextField fieldSinglelineAutoscale = ((PDTextField) (acroForm.getField("SinglelineAutoscale")));
        float fontSizeSinglelineAutoscale = getFontSizeFromAppearanceStream(fieldSinglelineAutoscale);
        fieldMultiline.setValue(param0);
        fieldSingleline.setValue(param0);
        fieldMultilineAutoscale.setValue(param0);
        fieldSinglelineAutoscale.setValue(param0);
        assertEquals(fontSizeMultiline, getFontSizeFromAppearanceStream(fieldMultiline), 0.001F);
        assertEquals(fontSizeSingleline, getFontSizeFromAppearanceStream(fieldSingleline), 0.001F);
        assertEquals(fontSizeMultilineAutoscale, getFontSizeFromAppearanceStream(fieldMultilineAutoscale), 0.001F);
        assertEquals(fontSizeSinglelineAutoscale, getFontSizeFromAppearanceStream(fieldSinglelineAutoscale), 0.025F);
    }

    private float getFontSizeFromAppearanceStream(PDField field) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = field.getWidgets().get(0);
        org.apache.pdfbox.pdfparser.PDFStreamParser parser = new org.apache.pdfbox.pdfparser.PDFStreamParser(widget.getNormalAppearanceStream());
        Object token = parser.parseNextToken();
        while (token != null) {
            if ((token instanceof org.apache.pdfbox.cos.COSName) && ((org.apache.pdfbox.cos.COSName) (token)).getName().equals("Helv")) {
                token = parser.parseNextToken();
                if ((token != null) && (token instanceof org.apache.pdfbox.cos.COSNumber)) {
                    return ((org.apache.pdfbox.cos.COSNumber) (token)).floatValue();
                }
            }
            token = parser.parseNextToken();
        } 
        return 0;
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws java.io.IOException {
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMultilineAuto_1(String param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, "PDFBOX3812-acrobat-multiline-auto.pdf"));
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDTextField fieldMultiline = ((PDTextField) (acroForm.getField("Multiline")));
        float fontSizeMultiline = getFontSizeFromAppearanceStream(fieldMultiline);
        PDTextField fieldSingleline = ((PDTextField) (acroForm.getField("Singleline")));
        float fontSizeSingleline = getFontSizeFromAppearanceStream(fieldSingleline);
        PDTextField fieldMultilineAutoscale = ((PDTextField) (acroForm.getField("MultilineAutoscale")));
        float fontSizeMultilineAutoscale = getFontSizeFromAppearanceStream(fieldMultilineAutoscale);
        PDTextField fieldSinglelineAutoscale = ((PDTextField) (acroForm.getField("SinglelineAutoscale")));
        float fontSizeSinglelineAutoscale = getFontSizeFromAppearanceStream(fieldSinglelineAutoscale);
        fieldMultiline.setValue(param0);
        fieldSingleline.setValue(param0);
        fieldMultilineAutoscale.setValue(param0);
        fieldSinglelineAutoscale.setValue(param0);
        assertEquals(fontSizeMultiline, getFontSizeFromAppearanceStream(fieldMultiline), 0.001F);
        // assertEquals(fontSizeSingleline, getFontSizeFromAppearanceStream(fieldSingleline), 0.001F);
        // assertEquals(fontSizeMultilineAutoscale, getFontSizeFromAppearanceStream(fieldMultilineAutoscale), 0.001F);
        // assertEquals(fontSizeSinglelineAutoscale, getFontSizeFromAppearanceStream(fieldSinglelineAutoscale), 0.025F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMultilineAuto_2(String param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, "PDFBOX3812-acrobat-multiline-auto.pdf"));
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDTextField fieldMultiline = ((PDTextField) (acroForm.getField("Multiline")));
        float fontSizeMultiline = getFontSizeFromAppearanceStream(fieldMultiline);
        PDTextField fieldSingleline = ((PDTextField) (acroForm.getField("Singleline")));
        float fontSizeSingleline = getFontSizeFromAppearanceStream(fieldSingleline);
        PDTextField fieldMultilineAutoscale = ((PDTextField) (acroForm.getField("MultilineAutoscale")));
        float fontSizeMultilineAutoscale = getFontSizeFromAppearanceStream(fieldMultilineAutoscale);
        PDTextField fieldSinglelineAutoscale = ((PDTextField) (acroForm.getField("SinglelineAutoscale")));
        float fontSizeSinglelineAutoscale = getFontSizeFromAppearanceStream(fieldSinglelineAutoscale);
        fieldMultiline.setValue(param0);
        fieldSingleline.setValue(param0);
        fieldMultilineAutoscale.setValue(param0);
        fieldSinglelineAutoscale.setValue(param0);
        // assertEquals(fontSizeMultiline, getFontSizeFromAppearanceStream(fieldMultiline), 0.001F);
        assertEquals(fontSizeSingleline, getFontSizeFromAppearanceStream(fieldSingleline), 0.001F);
        // assertEquals(fontSizeMultilineAutoscale, getFontSizeFromAppearanceStream(fieldMultilineAutoscale), 0.001F);
        // assertEquals(fontSizeSinglelineAutoscale, getFontSizeFromAppearanceStream(fieldSinglelineAutoscale), 0.025F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMultilineAuto_3(String param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, "PDFBOX3812-acrobat-multiline-auto.pdf"));
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDTextField fieldMultiline = ((PDTextField) (acroForm.getField("Multiline")));
        float fontSizeMultiline = getFontSizeFromAppearanceStream(fieldMultiline);
        PDTextField fieldSingleline = ((PDTextField) (acroForm.getField("Singleline")));
        float fontSizeSingleline = getFontSizeFromAppearanceStream(fieldSingleline);
        PDTextField fieldMultilineAutoscale = ((PDTextField) (acroForm.getField("MultilineAutoscale")));
        float fontSizeMultilineAutoscale = getFontSizeFromAppearanceStream(fieldMultilineAutoscale);
        PDTextField fieldSinglelineAutoscale = ((PDTextField) (acroForm.getField("SinglelineAutoscale")));
        float fontSizeSinglelineAutoscale = getFontSizeFromAppearanceStream(fieldSinglelineAutoscale);
        fieldMultiline.setValue(param0);
        fieldSingleline.setValue(param0);
        fieldMultilineAutoscale.setValue(param0);
        fieldSinglelineAutoscale.setValue(param0);
        // assertEquals(fontSizeMultiline, getFontSizeFromAppearanceStream(fieldMultiline), 0.001F);
        // assertEquals(fontSizeSingleline, getFontSizeFromAppearanceStream(fieldSingleline), 0.001F);
        assertEquals(fontSizeMultilineAutoscale, getFontSizeFromAppearanceStream(fieldMultilineAutoscale), 0.001F);
        // assertEquals(fontSizeSinglelineAutoscale, getFontSizeFromAppearanceStream(fieldSinglelineAutoscale), 0.025F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMultilineAuto_4(String param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_MultilineFieldsTest_testMultilineAuto.IN_DIR, "PDFBOX3812-acrobat-multiline-auto.pdf"));
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDTextField fieldMultiline = ((PDTextField) (acroForm.getField("Multiline")));
        float fontSizeMultiline = getFontSizeFromAppearanceStream(fieldMultiline);
        PDTextField fieldSingleline = ((PDTextField) (acroForm.getField("Singleline")));
        float fontSizeSingleline = getFontSizeFromAppearanceStream(fieldSingleline);
        PDTextField fieldMultilineAutoscale = ((PDTextField) (acroForm.getField("MultilineAutoscale")));
        float fontSizeMultilineAutoscale = getFontSizeFromAppearanceStream(fieldMultilineAutoscale);
        PDTextField fieldSinglelineAutoscale = ((PDTextField) (acroForm.getField("SinglelineAutoscale")));
        float fontSizeSinglelineAutoscale = getFontSizeFromAppearanceStream(fieldSinglelineAutoscale);
        fieldMultiline.setValue(param0);
        fieldSingleline.setValue(param0);
        fieldMultilineAutoscale.setValue(param0);
        fieldSinglelineAutoscale.setValue(param0);
        // assertEquals(fontSizeMultiline, getFontSizeFromAppearanceStream(fieldMultiline), 0.001F);
        // assertEquals(fontSizeSingleline, getFontSizeFromAppearanceStream(fieldSingleline), 0.001F);
        // assertEquals(fontSizeMultilineAutoscale, getFontSizeFromAppearanceStream(fieldMultilineAutoscale), 0.001F);
        assertEquals(fontSizeSinglelineAutoscale, getFontSizeFromAppearanceStream(fieldSinglelineAutoscale), 0.025F);
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