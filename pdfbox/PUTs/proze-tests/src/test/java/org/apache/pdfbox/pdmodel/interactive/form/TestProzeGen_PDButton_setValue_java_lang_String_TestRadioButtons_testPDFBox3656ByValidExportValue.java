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
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This will test the functionality of Radio Buttons in PDFBox.
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_TestRadioButtons_testPDFBox3656ByValidExportValue {
    /**
     * PDFBOX-3656 Set by value
     *
     * There are 6 radio buttons where 3 share the same common values but they are not set in unison
     * Setting by the first export value shall only select the first radio button
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByValidExportValue(String param0) throws IOException {
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
            // set the field to a valid export value
            field.setValue(param0);
            assertEquals("Checking", field.getValue(),
                    "setting by the export value should also return that");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByValidExportValue_1(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            // check defaults
            assertFalse(field.isRadiosInUnison(),
                    "the radio buttons can be selected individually although having the same ON value");
//            assertEquals("Off", field.getValue(),
//                    "initially no option shall be selected");
            // set the field to a valid export value
            field.setValue(param0);
//            assertEquals("Checking", field.getValue(),
//                    "setting by the export value should also return that");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByValidExportValue_2(String param0) throws IOException {
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
            // set the field to a valid export value
            field.setValue(param0);
//            assertEquals("Checking", field.getValue(),
//                    "setting by the export value should also return that");
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(testPdf);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3656ByValidExportValue_3(String param0) throws IOException {
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
            // set the field to a valid export value
            field.setValue(param0);
            assertEquals("Checking", field.getValue(),
                    "setting by the export value should also return that");
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