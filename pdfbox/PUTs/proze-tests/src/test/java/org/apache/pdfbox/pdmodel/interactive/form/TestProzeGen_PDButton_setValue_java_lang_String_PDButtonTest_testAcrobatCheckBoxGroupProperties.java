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
public class TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatCheckBoxGroupProperties {
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
        acrobatDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatCheckBoxGroupProperties.IN_DIR, TestProzeGen_PDButton_setValue_java_lang_String_PDButtonTest_testAcrobatCheckBoxGroupProperties.NAME_OF_PDF));
        acrobatAcroForm = acrobatDocument.getDocumentCatalog().getAcroForm();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        assertEquals("Off", checkbox.getValue());
        assertEquals(false, checkbox.isChecked());
        checkbox.check();
        assertEquals(checkbox.getValue(), checkbox.getOnValue());
        assertEquals(true, checkbox.isChecked());
        assertEquals(3, checkbox.getOnValues().size());
        assertTrue(checkbox.getOnValues().contains("Option1"));
        assertTrue(checkbox.getOnValues().contains("Option2"));
        assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        assertEquals("Option1", checkbox.getValue());
        assertEquals("Option1", checkbox.getValueAsString());
        assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        assertEquals("Option3", checkbox.getValue());
        assertEquals("Option3", checkbox.getValueAsString());
        assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws java.io.IOException {
        document.close();
        acrobatDocument.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_1(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_2(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_3(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_4(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_5(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_6(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_7(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_8(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_9(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_10(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_11(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_12(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
//        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_13(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_14(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_15(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_16(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_17(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_18(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
//        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_19(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcrobatCheckBoxGroupProperties_20(String param0) throws java.io.IOException {
        PDCheckBox checkbox = ((PDCheckBox) (acrobatAcroForm.getField("CheckboxGroup")));
        // assertEquals("Off", checkbox.getValue());
        // assertEquals(false, checkbox.isChecked());
        checkbox.check();
        // assertEquals(checkbox.getValue(), checkbox.getOnValue());
        // assertEquals(true, checkbox.isChecked());
        // assertEquals(3, checkbox.getOnValues().size());
        // assertTrue(checkbox.getOnValues().contains("Option1"));
        // assertTrue(checkbox.getOnValues().contains("Option2"));
        // assertTrue(checkbox.getOnValues().contains("Option3"));
        checkbox.setValue(param0);
        // assertEquals("Option1", checkbox.getValue());
        // assertEquals("Option1", checkbox.getValueAsString());
        // assertEquals("Option1", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(2).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(3).getAppearanceState().getName());
        checkbox.setValue(param0);
        // assertEquals("Option3", checkbox.getValue());
        // assertEquals("Option3", checkbox.getValueAsString());
        // assertEquals("Off", checkbox.getWidgets().get(0).getAppearanceState().getName());
        // assertEquals("Off", checkbox.getWidgets().get(1).getAppearanceState().getName());
        // assertEquals("Option3", checkbox.getWidgets().get(2).getAppearanceState().getName());
        assertEquals("Option3", checkbox.getWidgets().get(3).getAppearanceState().getName());
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