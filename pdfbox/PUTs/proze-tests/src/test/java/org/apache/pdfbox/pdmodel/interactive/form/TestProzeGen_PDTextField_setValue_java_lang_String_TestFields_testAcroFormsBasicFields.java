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
 * This will test the form fields in PDFBox.
 *
 * @author Ben Litchfield
 */
// public class TestFields extends TestCase
public class TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields {
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
//        String[] arg = new String[]{ TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.class.getName() };
//        junit.textui.TestRunner.main(arg);
//    }

    /**
     * This will test some form fields functionality based with
     * a sample form.
     *
     * @throws IOException
     * 		If there is an error creating the field.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
            assertNotNull(textField);
            assertEquals(textField.getDefaultValue(), "DefaultValue");
            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
            assertNotNull(textField);
            assertEquals(textField.getDefaultValue(), "DefaultValue");
            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
            assertEquals(textField.getValue(), "DefaultValue");
            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
            assertNotNull(textField);
            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_1(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_2(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_3(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_4(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_5(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_6(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_7(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_8(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_9(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_10(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_11(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_12(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_13(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_14(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_15(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_16(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_17(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_18(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_19(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
//            assertEquals(textField.getValue().length(), 145396);
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAcroFormsBasicFields_20(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDTextField_setValue_java_lang_String_TestFields_testAcroFormsBasicFields.PATH_OF_PDF));
            // get and assert that there is a form
            PDAcroForm form = doc.getDocumentCatalog().getAcroForm();
//            assertNotNull(form);
            // assert that there is no value, set the field value and
            // ensure it has been set
            PDTextField textField = ((PDTextField) (form.getField("TextField")));
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
//            assertEquals(textField.getValue(), "field value");
            // assert when setting to null the key has also been removed
//            assertNotNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            textField.setValue(param0);
//            assertNull(textField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V));
            // get the TextField with a DV entry
            textField = ((PDTextField) (form.getField("TextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
            // get a rich text field with a  DV entry
            textField = ((PDTextField) (form.getField("RichTextField-DefaultValue")));
//            assertNotNull(textField);
//            assertEquals(textField.getDefaultValue(), "DefaultValue");
//            assertEquals(textField.getDefaultValue(), ((org.apache.pdfbox.cos.COSString) (textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DV))).getString());
//            assertEquals(textField.getValue(), "DefaultValue");
//            assertEquals(textField.getDefaultAppearance(), "/Helv 12 Tf 0 g");
//            assertEquals(textField.getDefaultStyleString(), "font: Helvetica,sans-serif 12.0pt; text-align:left; color:#000000 ");
            // do not test for the full content as this is a rather long xml string
//            assertEquals(textField.getRichTextValue().length(), 338);
            // get a rich text field with a text stream for the value
            textField = ((PDTextField) (form.getField("LongRichTextField")));
//            assertNotNull(textField);
//            assertEquals(textField.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.V).getClass().getName(), "org.apache.pdfbox.cos.COSStream");
            assertEquals(textField.getValue().length(), 145396);
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