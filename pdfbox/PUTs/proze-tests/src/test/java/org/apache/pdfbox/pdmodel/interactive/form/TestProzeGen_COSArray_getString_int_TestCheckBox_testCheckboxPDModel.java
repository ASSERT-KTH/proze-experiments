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
 * This will test the functionality of checkboxes in PDFBox.
 */
// public class TestCheckBox extends TestCase
public class TestProzeGen_COSArray_getString_int_TestCheckBox_testCheckboxPDModel {
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
     * This will test the checkbox PDModel.
     *
     * @throws IOException
     * 		If there is an error creating the field.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(checkBox.getExportValues());
            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(optItem.size(), 2);
            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
            assertEquals(retrievedOptions.size(), 2);
            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_1(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_2(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_3(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_4(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_5(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_6(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_7(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_8(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCheckboxPDModel_9(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDCheckBox checkBox = new PDCheckBox(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(checkBox.getExportValues());
//            assertNotNull(checkBox.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            checkBox.setExportValues(options);
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), 2);
//            assertEquals(options.get(0), optItem.getString(param0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = checkBox.getExportValues();
//            assertEquals(retrievedOptions.size(), 2);
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            checkBox.setExportValues(null);
//            assertNull(checkBox.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertTrue(checkBox.getExportValues().isEmpty());
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1)
        );
    }
}