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

/**
 * This will test the functionality of Radio Buttons in PDFBox.
 */
public class TestProzeGen_PDButton_setValue_java_lang_String_TestRadioButtons_testPDFBox4617IndexForSetByOption {
    /**
     * PDFBOX-4617 Enable getting selected index for value being set by option
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4617IndexForSetByOption(String param0) throws IOException {
        String sourceUrl = "https://issues.apache.org/jira/secure/attachment/12848122/SF1199AEG%20%28Complete%29.pdf";
        org.apache.pdfbox.pdmodel.PDDocument testPdf = null;
        try {
            testPdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.net.URL(sourceUrl).openStream());
            PDAcroForm acroForm = testPdf.getDocumentCatalog().getAcroForm();
            PDRadioButton field = ((PDRadioButton) (acroForm.getField("Checking/Savings")));
            field.setValue(param0);
            assertEquals(0, field.getSelectedIndex(),
                    "the index shall be equal with the first entry of Checking which is 0");
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