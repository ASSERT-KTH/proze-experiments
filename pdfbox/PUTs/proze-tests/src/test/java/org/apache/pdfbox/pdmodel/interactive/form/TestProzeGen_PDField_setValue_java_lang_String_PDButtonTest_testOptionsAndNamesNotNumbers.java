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

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the PDButton class.
 */
public class TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers {
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
        acrobatDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.IN_DIR, TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.NAME_OF_PDF));
        acrobatAcroForm = acrobatDocument.getDocumentCatalog().getAcroForm();
    }

    /**
     * PDFBOX-3682
     *
     * Test a radio button with options.
     * Special handling for a radio button with /Opt and the On state not being named
     * after the index.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOptionsAndNamesNotNumbers(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.TARGET_PDF_DIR, "PDFBOX-3682.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton").setValue(param0);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton")));
            radioButton.setValue("c");
            // test that the old behavior is now invalid
            assertNotEquals("2", radioButton.getValueAsString(),
                    "This shall no longer be 2");
            assertNotEquals( "2", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
                    "This shall no longer be 2");
            // test for the correct behavior
            assertEquals("c", radioButton.getValueAsString(),
                    "This shall be c");
            assertEquals("c", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
                    "This shall be c");
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

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOptionsAndNamesNotNumbers_1(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.TARGET_PDF_DIR, "PDFBOX-3682.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton").setValue(param0);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton")));
            radioButton.setValue("c");
            // test that the old behavior is now invalid
            assertNotEquals("2", radioButton.getValueAsString(),
                    "This shall no longer be 2");
//            assertNotEquals("This shall no longer be 2", "2", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS));
            // test for the correct behavior
//            assertEquals("c", radioButton.getValueAsString(),
//                    "This shall be c");
//            assertEquals("c", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
//                    "This shall be c");
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

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOptionsAndNamesNotNumbers_2(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.TARGET_PDF_DIR, "PDFBOX-3682.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton").setValue(param0);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton")));
            radioButton.setValue("c");
            // test that the old behavior is now invalid
//            assertNotEquals("2", radioButton.getValueAsString(),
//                    "This shall no longer be 2");
            assertNotEquals("2", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
                    "This shall no longer be 2");
            // test for the correct behavior
//            assertEquals("c", radioButton.getValueAsString(),
//                    "This shall be c");
//            assertEquals("c", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
//                    "This shall be c");
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

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOptionsAndNamesNotNumbers_3(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.TARGET_PDF_DIR, "PDFBOX-3682.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton").setValue(param0);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton")));
            radioButton.setValue("c");
            // test that the old behavior is now invalid
//            assertNotEquals("2", radioButton.getValueAsString(),
//                    "This shall no longer be 2");
//            assertNotEquals("2", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
//                    "This shall no longer be 2");
            // test for the correct behavior
            assertEquals("c", radioButton.getValueAsString(),
                    "This shall be c");
//            assertEquals("c", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
//                    "This shall be c");
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

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOptionsAndNamesNotNumbers_4(String param0) {
        java.io.File file;
        org.apache.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            file = new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_PDButtonTest_testOptionsAndNamesNotNumbers.TARGET_PDF_DIR, "PDFBOX-3682.pdf");
            pdfDocument = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton").setValue(param0);
            PDRadioButton radioButton = ((PDRadioButton) (pdfDocument.getDocumentCatalog().getAcroForm().getField("RadioButton")));
            radioButton.setValue("c");
            // test that the old behavior is now invalid
//            assertNotEquals("2", radioButton.getValueAsString(),
//                    "This shall no longer be 2");
//            assertNotEquals("2", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
//                    "This shall no longer be 2");
            // test for the correct behavior
//            assertEquals("c", radioButton.getValueAsString(),
//                    "This shall be c");
            assertEquals("c", radioButton.getWidgets().get(2).getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.AS),
                    "This shall be c");
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
                org.junit.jupiter.params.provider.Arguments.of("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"),
                org.junit.jupiter.params.provider.Arguments.of("CR\rCR"),
                org.junit.jupiter.params.provider.Arguments.of("CRLF\r\nCRLF"),
                org.junit.jupiter.params.provider.Arguments.of("Checking"),
                org.junit.jupiter.params.provider.Arguments.of("LFLF"),
                org.junit.jupiter.params.provider.Arguments.of("LFCR\n\rLFCR"),
                org.junit.jupiter.params.provider.Arguments.of("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam"),
                org.junit.jupiter.params.provider.Arguments.of("Multiline - Fixed"),
                org.junit.jupiter.params.provider.Arguments.of("Multiline - auto"),
                org.junit.jupiter.params.provider.Arguments.of("Off"),
                org.junit.jupiter.params.provider.Arguments.of("Option1"),
                org.junit.jupiter.params.provider.Arguments.of("Option3"),
                org.junit.jupiter.params.provider.Arguments.of("RadioButton01"),
                org.junit.jupiter.params.provider.Arguments.of("RadioButton02"),
                org.junit.jupiter.params.provider.Arguments.of("SPACE SPACE"),
                org.junit.jupiter.params.provider.Arguments.of("Singleline - Fixed"),
                org.junit.jupiter.params.provider.Arguments.of("Singleline - auto"),
                org.junit.jupiter.params.provider.Arguments.of("TAB	TAB"),
                org.junit.jupiter.params.provider.Arguments.of("Test1"),
                org.junit.jupiter.params.provider.Arguments.of("Test2"),
                org.junit.jupiter.params.provider.Arguments.of("Value01"),
                org.junit.jupiter.params.provider.Arguments.of("Value02"),
                org.junit.jupiter.params.provider.Arguments.of("Yes"),
                org.junit.jupiter.params.provider.Arguments.of("c"),
                org.junit.jupiter.params.provider.Arguments.of("different layout"),
                org.junit.jupiter.params.provider.Arguments.of("export01"),
                org.junit.jupiter.params.provider.Arguments.of("export03"),
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
                org.junit.jupiter.params.provider.Arguments.of("New Value 1"),
                org.junit.jupiter.params.provider.Arguments.of("New Value 2")
        );
    }

}