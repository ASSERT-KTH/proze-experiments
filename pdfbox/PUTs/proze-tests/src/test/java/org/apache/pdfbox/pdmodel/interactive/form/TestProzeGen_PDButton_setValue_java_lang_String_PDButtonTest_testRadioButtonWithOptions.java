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
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test for the PDButton class.
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testRadioButtonWithOptions {
    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    private static final String NAME_OF_PDF = "AcroFormsBasicFields.pdf";

    private static final java.io.File TARGET_PDF_DIR = new java.io.File("target/pdfs");

    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    private org.apache.pdfbox.pdmodel.PDDocument acrobatDocument;

    private PDAcroForm acrobatAcroForm;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws IOException {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
        acrobatDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testRadioButtonWithOptions.IN_DIR, TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testRadioButtonWithOptions.NAME_OF_PDF));
        acrobatAcroForm = acrobatDocument.getDocumentCatalog().getAcroForm();
    }

    /**
     * PDFBOX-3656
     *
     * Test a radio button with options.
     * This was causing an ArrayIndexOutOfBoundsException when trying to set to "Off", as this
     * wasn't treated to be a valid option.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonWithOptions(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testRadioButtonWithOptions.TARGET_PDF_DIR, "PDFBOX-3656.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("Checking/Savings")));
            radioButton.setValue(param0);
            for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget : radioButton.getWidgets()) {
                assertEquals(org.apache.pdfbox.cos.COSName.Off, widget.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.AS),
                        "The widget should be set to Off");
            }
        } catch (IOException e) {
            fail("Unexpected IOException " + e.getMessage());
        } finally {
            if (pdfDocument != null) {
                try {
                    pdfDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws IOException {
        document.close();
        acrobatDocument.close();
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