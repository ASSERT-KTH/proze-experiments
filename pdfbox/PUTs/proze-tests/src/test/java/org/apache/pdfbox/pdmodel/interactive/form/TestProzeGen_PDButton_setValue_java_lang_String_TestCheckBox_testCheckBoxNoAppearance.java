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
 * This will test the functionality of checkboxes in PDFBox.
 */
// public class TestCheckBox extends TestCase
public class TestProzeGen_PDButton_setValue_java_lang_String_TestCheckBox_testCheckBoxNoAppearance {
    /**
     * Constructor.
     *
     * @param name
     * 		The name of the test to run.
     */
    // public TestCheckBox( String name )
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
    // return new TestSuite( TestCheckBox.class );
    // }
    /**
     * infamous main method.
     *
     * @param args
     * 		The command line arguments.
     */

    /**
     * PDFBOX-4366: Create and test a checkbox with no /AP. The created file works with Adobe Reader!
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckBoxNoAppearance(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        PDAcroForm acroForm = new PDAcroForm(doc);
        acroForm.setNeedAppearances(true);// need this or it won't appear on Adobe Reader

        doc.getDocumentCatalog().setAcroForm(acroForm);
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        PDCheckBox checkBox = new PDCheckBox(acroForm);
        checkBox.setPartialName("checkbox");
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = checkBox.getWidgets().get(0);
        widget.setRectangle(new org.apache.pdfbox.pdmodel.common.PDRectangle(50, 600, 100, 100));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary bs = new org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary();
        bs.setStyle(org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary.STYLE_SOLID);
        bs.setWidth(1);
        org.apache.pdfbox.cos.COSDictionary acd = new org.apache.pdfbox.cos.COSDictionary();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary ac = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(acd);
        ac.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        ac.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 0, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        ac.setNormalCaption("4");// 4 is checkmark, 8 is cross

        widget.setAppearanceCharacteristics(ac);
        widget.setBorderStyle(bs);
        checkBox.setValue(param0);
        fields.add(checkBox);
        page.getAnnotations().add(widget);
        acroForm.setFields(fields);
        assertEquals("Off", checkBox.getValue());
        doc.close();
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