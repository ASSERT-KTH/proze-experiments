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
public class TestProzeGen_PDButton_setValue_java_lang_String_TestRadioButtons_testRadioButtonPDModel {
    /**
     * This will test the radio button PDModel.
     *
     * @throws IOException
     * 		If there is an error creating the field.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(radioButton.getDefaultValue());
            assertNotNull(radioButton.getSelectedExportValues());
            assertNotNull(radioButton.getExportValues());
            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
            assertEquals("Value01", radioButton.getValue());
            assertEquals(1, radioButton.getSelectedExportValues().size());
            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
            assertEquals("Value02", radioButton.getValue());
            assertEquals(1, radioButton.getSelectedExportValues().size());
            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
            assertEquals("Off", radioButton.getValue());
            assertEquals(0, radioButton.getSelectedExportValues().size());
            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(2, optItem.size());
            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
            assertEquals(2, retrievedOptions.size());
            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_1(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_2(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_3(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_4(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_5(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_6(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_7(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_8(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_9(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_10(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_11(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_12(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_13(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_14(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_15(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_16(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_17(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_18(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_19(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_20(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_21(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_22(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_23(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_24(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
//            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testRadioButtonPDModel_25(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = null;
        try {
            doc = new org.apache.pdfbox.pdmodel.PDDocument();
            PDAcroForm form = new PDAcroForm(doc);
            PDRadioButton radioButton = new PDRadioButton(form);
            // test that there are no nulls returned for an empty field
            // only specific methods are tested here
//            assertNotNull(radioButton.getDefaultValue());
//            assertNotNull(radioButton.getSelectedExportValues());
//            assertNotNull(radioButton.getExportValues());
//            assertNotNull(radioButton.getValue());
            // Test setting/getting option values - the dictionaries Opt entry
            java.util.List<String> options = new java.util.ArrayList<String>();
            options.add("Value01");
            options.add("Value02");
            radioButton.setExportValues(options);
            // Test getSelectedExportValues()
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
            for (int i = 0; i < options.size(); i++) {
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
                org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
                apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                apNDict.setItem(options.get(i), new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(doc));
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
                org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
                appearance.setNormalAppearance(appearanceNEntry);
                widget.setAppearance(appearance);
                widget.setAppearanceState("Off");
                widgets.add(widget);
            }
            radioButton.setWidgets(widgets);
            radioButton.setValue(param0);
//            assertEquals("Value01", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value01", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Value01", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Value02", radioButton.getValue());
//            assertEquals(1, radioButton.getSelectedExportValues().size());
//            assertEquals("Value02", radioButton.getSelectedExportValues().get(0));
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Value02", widgets.get(1).getAppearanceState().getName());
            radioButton.setValue(param0);
//            assertEquals("Off", radioButton.getValue());
//            assertEquals(0, radioButton.getSelectedExportValues().size());
//            assertEquals("Off", widgets.get(0).getAppearanceState().getName());
//            assertEquals("Off", widgets.get(1).getAppearanceState().getName());
            org.apache.pdfbox.cos.COSArray optItem = ((org.apache.pdfbox.cos.COSArray) (radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT)));
            // assert that the values have been correctly set
//            assertNotNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
//            assertEquals(2, optItem.size());
//            assertEquals(options.get(0), optItem.getString(0));
            // assert that the values can be retrieved correctly
            java.util.List<String> retrievedOptions = radioButton.getExportValues();
//            assertEquals(2, retrievedOptions.size());
//            assertEquals(retrievedOptions, options);
            // assert that the Opt entry is removed
            radioButton.setExportValues(null);
//            assertNull(radioButton.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.OPT));
            // if there is no Opt entry an empty List shall be returned
            assertEquals(radioButton.getExportValues(), new java.util.ArrayList<String>());
        } finally {
            {
                org.apache.pdfbox.io.IOUtils.closeQuietly(doc);
            }
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