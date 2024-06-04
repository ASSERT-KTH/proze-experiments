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

/**
 * Test handling some special characters when setting a fields value.
 *
 * Compare the results of setting the values using PDFBox with setting the values
 * via Acrobat using JavaScript and manual input.
 *
 * The JavaScript used for acrobat is
 *
 * <pre>
 * {@code this.getField("acrobat-nul").value = "NUL\0NUL";
 * this.getField("acrobat-tab").value = "TAB\tTAB";
 * this.getField("acrobat-space").value = "SPACE SPACE";
 * this.getField("acrobat-cr").value = "CR\rCR";
 * this.getField("acrobat-lf").value = "LF\nLF";
 * this.getField("acrobat-crlf").value = "CRLF\r\nCRLF";
 * this.getField("acrobat-lfcr").value = "LFCR\n\rLFCR";
 * this.getField("acrobat-linebreak").value = "linebreak\u2028linebreak";
 * this.getField("acrobat-paragraphbreak").value = "paragraphbreak\u2029paragraphbreak";}
 * </pre>
 *
 * @see <a href="https://issues.apache.org/jira/browse/PDFBOX-3461">https://issues.apache.org/jira/browse/PDFBOX-3461</a>
 */
public class TestProzeGen_PDField_setValue_java_lang_String_ControlCharacterTest_characterLF {
    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    private static final String NAME_OF_PDF = "ControlCharacters.pdf";

    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws java.io.IOException {
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDField_setValue_java_lang_String_ControlCharacterTest_characterLF.IN_DIR, TestProzeGen_PDField_setValue_java_lang_String_ControlCharacterTest_characterLF.NAME_OF_PDF));
        acroForm = document.getDocumentCatalog().getAcroForm();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void characterLF(String param0) throws java.io.IOException {
        PDField field = acroForm.getField("pdfbox-lf");
        field.setValue(param0);
        java.util.List<String> pdfboxValues = getStringsFromStream(field);
        java.util.List<String> acrobatValues = getStringsFromStream(acroForm.getField("acrobat-lf"));
        assertEquals(pdfboxValues, acrobatValues);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws java.io.IOException {
        document.close();
    }

    private java.util.List<String> getStringsFromStream(PDField field) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = field.getWidgets().get(0);
        org.apache.pdfbox.pdfparser.PDFStreamParser parser = new org.apache.pdfbox.pdfparser.PDFStreamParser(widget.getNormalAppearanceStream());
        Object token = parser.parseNextToken();
        java.util.List<String> stringValues = new java.util.ArrayList<String>();
        while (token != null) {
            if (token instanceof org.apache.pdfbox.cos.COSString) {
                // TODO: improve the string output to better match
                // trimming as Acrobat adds spaces to strings
                // where we don't
                stringValues.add(((org.apache.pdfbox.cos.COSString) (token)).getString().trim());
            }
            token = parser.parseNextToken();
        } 
        return stringValues;
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