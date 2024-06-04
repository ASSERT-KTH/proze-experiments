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

import static org.junit.jupiter.api.Assertions.*;

/**
 * This will test the functionality of Radio Buttons in PDFBox.
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_TestRadioButtons_testPDFBox3656ByInvalidExportValue {
    /**
     * PDFBOX-3656 Set by invalid export value
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
            assertFalse(field.isRadiosInUnison(),
                    "the radio buttons can be selected individually although having the same ON value");
            assertEquals("Off", field.getValue(),
                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
            }
            assertEquals("Off", field.getValue(),
                    "no option shall be selected");
            assertTrue(field.getSelectedExportValues().isEmpty(),
                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue_1(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
//            assertFalse(field.isRadiosInUnison(),
//                    "the radio buttons can be selected individually although having the same ON value");
//            assertEquals("Off", field.getValue(),
//                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
            }
//            assertEquals("Off", field.getValue(),
//                    "no option shall be selected");
//            assertTrue(field.getSelectedExportValues().isEmpty(),
//                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue_2(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
//            assertFalse(field.isRadiosInUnison(),
//                    "the radio buttons can be selected individually although having the same ON value");
            assertEquals("Off", field.getValue(),
                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
//                assertTrue(actualMessage.contains(expectedMessage));
            }
//            assertEquals("Off", field.getValue(),
//                    "no option shall be selected");
//            assertTrue(field.getSelectedExportValues().isEmpty(),
//                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue_3(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
//            assertFalse(field.isRadiosInUnison(),
//                    "the radio buttons can be selected individually although having the same ON value");
//            assertEquals("Off", field.getValue(),
//                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
            }
//            assertEquals("Off", field.getValue(),
//                    "no option shall be selected");
//            assertTrue(field.getSelectedExportValues().isEmpty(),
//                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue_4(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
//            assertFalse(field.isRadiosInUnison(),
//                    "the radio buttons can be selected individually although having the same ON value");
//            assertEquals("Off", field.getValue(),
//                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
//                assertTrue(actualMessage.contains(expectedMessage));
            }
            assertEquals("Off", field.getValue(),
                    "no option shall be selected");
//            assertTrue(field.getSelectedExportValues().isEmpty(),
//                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByInvalidExportValue_5(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
//            assertFalse(field.isRadiosInUnison(),
//                    "the radio buttons can be selected individually although having the same ON value");
//            assertEquals("Off", field.getValue(),
//                    "initially no option shall be selected");
            try {
                field.setValue(param0);
                fail("Expected an IndexOutOfBoundsException to be thrown");
            } catch (Exception ex) {
                // compare the messages
                String expectedMessage = "value 'Invalid' is not a valid option for the field Checking/Savings, valid values are: [Checking, Savings] and Off";
                String actualMessage = ex.getMessage();
//                assertTrue(actualMessage.contains(expectedMessage));
            }
//            assertEquals("Off", field.getValue(),
//                    "no option shall be selected");
            assertTrue(field.getSelectedExportValues().isEmpty(),
                    "no export values are selected");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
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