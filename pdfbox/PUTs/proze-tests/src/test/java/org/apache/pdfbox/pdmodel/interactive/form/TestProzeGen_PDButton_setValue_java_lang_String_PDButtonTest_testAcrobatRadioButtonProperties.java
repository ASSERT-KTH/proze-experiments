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

/**
 * Test for the PDButton class.
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatRadioButtonProperties {
    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    private static final String NAME_OF_PDF = "AcroFormsBasicFields.pdf";

    private static final java.io.File TARGET_PDF_DIR = new java.io.File("target/pdfs");

    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    private org.apache.pdfbox.pdmodel.PDDocument acrobatDocument;

    private PDAcroForm acrobatAcroForm;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws java.io.IOException {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
        acrobatDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatRadioButtonProperties.IN_DIR, TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatRadioButtonProperties.NAME_OF_PDF));
        acrobatAcroForm = acrobatDocument.getDocumentCatalog().getAcroForm();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        assertEquals("RadioButton01", radioButton.getValue());
        assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        assertEquals("RadioButton02", radioButton.getValue());
        assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws java.io.IOException {
        document.close();
        acrobatDocument.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_1(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        assertEquals("RadioButton01", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        // assertEquals("RadioButton02", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_2(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        // assertEquals("RadioButton01", radioButton.getValue());
        assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        // assertEquals("RadioButton02", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_3(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        // assertEquals("RadioButton01", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        // assertEquals("RadioButton02", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_4(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        // assertEquals("RadioButton01", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        assertEquals("RadioButton02", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_5(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        // assertEquals("RadioButton01", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        // assertEquals("RadioButton02", radioButton.getValue());
        assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatRadioButtonProperties_6(String param0) throws java.io.IOException {
        PDRadioButton radioButton = ((PDRadioButton) (acrobatAcroForm.getField("RadioButtonGroup")));
        radioButton.setValue(param0);
        // assertEquals("RadioButton01", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton01"), radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        radioButton.setValue(param0);
        // assertEquals("RadioButton02", radioButton.getValue());
        // assertEquals(org.apache.pdfbox.cos.COSName.Off, radioButton.getWidgets().get(0).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
        assertEquals(org.apache.pdfbox.cos.COSName.getPDFName("RadioButton02"), radioButton.getWidgets().get(1).getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AS));
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