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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This will test the form fields in PDFBox.
 *
 * @author Ben Litchfield
 */
// public class TestFields extends TestCase
public class TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testWidgetMissingRect {
    // private static Logger log = Logger.getLogger(TestFDF.class);
    private static final String PATH_OF_PDF = "src/test/resources/org/apache/pdfbox/pdmodel/interactive/form/AcroFormsBasicFields.pdf";

    /**
     * Constructor.
     *
     * @param name
     * 		The name of the test to run.
     */
    // public TestFields( String name )
    // {
    // super( name );
    // }
    /**
     * This will get the suite of test that this class holds.
     *
     * @return All of the tests that this class holds.
     */
    // public static Test suite()
    // {
    // return new TestSuite( TestFields.class );
    // }
    /**
     * infamous main method.
     *
     * @param args
     * 		The command line arguments.
     */
//    public static void main(String[] args) {
//        String[] arg = new String[]{ TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testWidgetMissingRect.class.getName() };
//        junit.textui.TestRunner.main(arg);
//    }

    /**
     * This will test the handling of a widget with a missing (required) /Rect entry.
     *
     * @throws IOException
     * 		If there is an error loading the form or the field.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testWidgetMissingRect(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testWidgetMissingRect.PATH_OF_PDF));
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
            PDTextField textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textField.getWidgets().get(0);
            // initially there is an Appearance Entry in the form
            assertNotNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
            widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.RECT);
            textField.setValue(param0);
            // There shall be no appearance entry if there is no /Rect to
            // behave as Adobe Acrobat does
            assertNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testWidgetMissingRect_1(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testWidgetMissingRect.PATH_OF_PDF));
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
            PDTextField textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textField.getWidgets().get(0);
            // initially there is an Appearance Entry in the form
            assertNotNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
            widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.RECT);
            textField.setValue(param0);
            // There shall be no appearance entry if there is no /Rect to
            // behave as Adobe Acrobat does
//            assertNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testWidgetMissingRect_2(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testWidgetMissingRect.PATH_OF_PDF));
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
            PDTextField textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textField.getWidgets().get(0);
            // initially there is an Appearance Entry in the form
//            assertNotNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
            widget.getCOSObject().removeItem(org.apache.pdfbox.cos.COSName.RECT);
            textField.setValue(param0);
            // There shall be no appearance entry if there is no /Rect to
            // behave as Adobe Acrobat does
            assertNull(widget.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.AP));
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
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