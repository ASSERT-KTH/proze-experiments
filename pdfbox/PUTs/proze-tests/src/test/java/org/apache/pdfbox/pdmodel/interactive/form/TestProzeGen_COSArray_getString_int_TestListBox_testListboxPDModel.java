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
 * This will test the functionality of choice fields in PDFBox.
 */
// public class TestListBox extends TestCase
public class TestProzeGen_COSArray_getString_int_TestListBox_testListboxPDModel {
    /**
     * Constructor.
     *
     * @param name
     * 		The name of the test to run.
     */
    // public TestListBox( String name )
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
    // return new TestSuite( TestListBox.class );
    // }
    /**
     * infamous main method.
     *
     * @param args
     * 		The command line arguments.
     */

    /**
     * This will test the list box PDModel.
     *
     * @throws IOException
     * 		If there is an error creating the field.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(choice.getOptions());
            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
            assertEquals(exportValues, choice.getOptionsDisplayValues());
            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(optItem.size(), exportValues.size());
            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
            assertEquals(retrievedOptions.size(), exportValues.size());
            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
            assertNotNull(valueItems);
            assertEquals(valueItems.size(), exportValues.size());
            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
            assertNotNull(indexItems);
            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
            assertEquals(displayValues, choice.getOptionsDisplayValues());
            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_1(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_2(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_3(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_4(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_5(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_6(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_7(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_8(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_9(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_10(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_11(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_12(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_13(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_14(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_15(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_16(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_17(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_18(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_19(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_20(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_21(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_22(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_23(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_24(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_25(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_26(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_27(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_28(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
//                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListboxPDModel_29(int param0) throws IOException {
        /* Set up two data lists which will be used for the tests */
        // export values
        java.util.List<String> exportValues = new java.util.ArrayList<String>();
        exportValues.add("export01");
        exportValues.add("export02");
        exportValues.add("export03");
        // display values, not sorted on purpose as this
        // will be used to test the sort option of the list box
        java.util.List<String> displayValues = new java.util.ArrayList<String>();
        displayValues.add("display02");
        displayValues.add("display01");
        displayValues.add("display03");
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDListBox choice = new PDListBox(form);
            // appearance construction is not implemented, so turn on NeedAppearances
            form.setNeedAppearances(true);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(choice.getOptions());
//            assertNotNull(choice.getValue());
            /* Tests for setting the export values */
            // setting/getting option values - the dictionaries Opt entry
            choice.setOptions(exportValues);
//            assertEquals(exportValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            // Test bug 1 of PDFBOX-4252 when top index is not null
            choice.setTopIndex(1);
            choice.setValue(exportValues.get(2));
//            assertEquals(exportValues.get(2), choice.getValue().get(0));
            choice.setTopIndex(null);// reset

            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
//            assertNotNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(optItem.size(), exportValues.size());
//            assertEquals(exportValues.get(0), optItem.getString(param0));
            // assert that the option values can be retrieved correctly
            java.util.List<String> retrievedOptions = choice.getOptions();
//            assertEquals(retrievedOptions.size(), exportValues.size());
//            assertEquals(retrievedOptions, exportValues);
            /* Tests for setting the field values */
            // assert that the field value can be set
            choice.setValue("export01");
//            assertEquals(choice.getValue().get(0), "export01");
            // ensure that the choice field doesn't allow multiple selections
            choice.setMultiSelect(false);
            // without multiselect setting multiple items shall fail
            try {
                choice.setValue(exportValues);
                fail("Missing IllegalArgumentException");
            } catch (IllegalArgumentException e) {
//                assertEquals("The list box does not allow multiple selections.", e.getMessage());
            }
            // ensure that the choice field does allow multiple selections
            choice.setMultiSelect(true);
            // now this call must succeed
            choice.setValue(exportValues);
            // assert that the option values have been correctly set
            org.apache.pdfbox.cos.COSArray valueItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.V)));
//            assertNotNull(valueItems);
//            assertEquals(valueItems.size(), exportValues.size());
//            assertEquals(exportValues.get(0), valueItems.getString(param0));
            // assert that the index values have been correctly set
            org.apache.pdfbox.cos.COSArray indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNotNull(indexItems);
//            assertEquals(indexItems.size(), exportValues.size());
            // setting a single value shall remove the indices
            choice.setValue("export01");
            indexItems = ((org.apache.pdfbox.cos.COSArray) (choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.I)));
//            assertNull(indexItems);
            // assert that the Opt entry is removed
            choice.setOptions(null);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
            /* Test for setting export and display values */
            // setting display and export value
            choice.setOptions(exportValues, displayValues);
//            assertEquals(displayValues, choice.getOptionsDisplayValues());
//            assertEquals(exportValues, choice.getOptionsExportValues());
            /* Testing the sort option */
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display02");
            choice.setSort(true);
            choice.setOptions(exportValues, displayValues);
//            assertEquals(choice.getOptionsDisplayValues().get(0), "display01");
            /* Setting options with an empty list */
            // assert that the Opt entry is removed
            choice.setOptions(null, displayValues);
//            assertNull(choice.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty list shall be returned
//            assertEquals(choice.getOptions(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsDisplayValues(), java.util.Collections.<String>emptyList());
//            assertEquals(choice.getOptionsExportValues(), java.util.Collections.<String>emptyList());
            // test that an IllegalArgumentException is thrown when export and display
            // value lists have different sizes
            exportValues.remove(1);
            try {
                choice.setOptions(exportValues, displayValues);
                fail("Missing exception");
            } catch (IllegalArgumentException e) {
                assertEquals("The number of entries for exportValue and displayValue shall be the same.", e.getMessage());
            }
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