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
package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test merging different PDFs with AcroForms.
 */
public class TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge {
    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/multipdf");

    private static final java.io.File OUT_DIR = new java.io.File("target/test-output/merge/");

    private static final java.io.File TARGET_PDF_DIR = new java.io.File("target/pdfs");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR.mkdirs();
    }

    /* Test LegacyMode merge */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLegacyModeMerge(String param0) throws java.io.IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.File toBeMerged = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "AcroFormForMerge.pdf");
        java.io.File pdfOutput = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf");
        merger.setDestinationFileName(pdfOutput.getAbsolutePath());
        merger.addSource(toBeMerged);
        merger.addSource(toBeMerged);
        merger.mergeDocuments(null);
        merger.setAcroFormMergeMode(PDFMergerUtility.AcroFormMergeMode.PDFBOX_LEGACY_MODE);
        org.apache.pdfbox.pdmodel.PDDocument compliantDocument = null;
        org.apache.pdfbox.pdmodel.PDDocument toBeCompared = null;
        try {
            compliantDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            toBeCompared = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm compliantAcroForm = compliantDocument.getDocumentCatalog().getAcroForm();
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm toBeComparedAcroForm = toBeCompared.getDocumentCatalog().getAcroForm();
            assertEquals(compliantAcroForm.getFields().size(), toBeComparedAcroForm.getFields().size(),
                    "There shall be the same number of root fields");
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField : compliantAcroForm.getFieldTree()) {
                assertNotNull(toBeComparedAcroForm.getField(param0),
                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField = toBeComparedAcroForm.getField(param0);
                compareFieldProperties(compliantField, toBeComparedField);
            }
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField : toBeComparedAcroForm.getFieldTree()) {
                assertNotNull(compliantAcroForm.getField(param0),
                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField = compliantAcroForm.getField(param0);
                compareFieldProperties(toBeComparedField, compliantField);
            }
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(compliantDocument);
            org.apache.pdfbox.io.IOUtils.closeQuietly(toBeCompared);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLegacyModeMerge_1(String param0) throws java.io.IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.File toBeMerged = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "AcroFormForMerge.pdf");
        java.io.File pdfOutput = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf");
        merger.setDestinationFileName(pdfOutput.getAbsolutePath());
        merger.addSource(toBeMerged);
        merger.addSource(toBeMerged);
        merger.mergeDocuments(null);
        merger.setAcroFormMergeMode(PDFMergerUtility.AcroFormMergeMode.PDFBOX_LEGACY_MODE);
        org.apache.pdfbox.pdmodel.PDDocument compliantDocument = null;
        org.apache.pdfbox.pdmodel.PDDocument toBeCompared = null;
        try {
            compliantDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            toBeCompared = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm compliantAcroForm = compliantDocument.getDocumentCatalog().getAcroForm();
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm toBeComparedAcroForm = toBeCompared.getDocumentCatalog().getAcroForm();
            assertEquals(compliantAcroForm.getFields().size(), toBeComparedAcroForm.getFields().size(),
                    "There shall be the same number of root fields");
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField : compliantAcroForm.getFieldTree()) {
//                assertNotNull(toBeComparedAcroForm.getField(param0),
//                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField = toBeComparedAcroForm.getField(param0);
                compareFieldProperties(compliantField, toBeComparedField);
            }
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField : toBeComparedAcroForm.getFieldTree()) {
//                assertNotNull(compliantAcroForm.getField(param0),
//                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField = compliantAcroForm.getField(param0);
                compareFieldProperties(toBeComparedField, compliantField);
            }
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(compliantDocument);
            org.apache.pdfbox.io.IOUtils.closeQuietly(toBeCompared);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLegacyModeMerge_2(String param0) throws java.io.IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.File toBeMerged = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "AcroFormForMerge.pdf");
        java.io.File pdfOutput = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf");
        merger.setDestinationFileName(pdfOutput.getAbsolutePath());
        merger.addSource(toBeMerged);
        merger.addSource(toBeMerged);
        merger.mergeDocuments(null);
        merger.setAcroFormMergeMode(PDFMergerUtility.AcroFormMergeMode.PDFBOX_LEGACY_MODE);
        org.apache.pdfbox.pdmodel.PDDocument compliantDocument = null;
        org.apache.pdfbox.pdmodel.PDDocument toBeCompared = null;
        try {
            compliantDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            toBeCompared = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm compliantAcroForm = compliantDocument.getDocumentCatalog().getAcroForm();
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm toBeComparedAcroForm = toBeCompared.getDocumentCatalog().getAcroForm();
//            assertEquals(compliantAcroForm.getFields().size(), toBeComparedAcroForm.getFields().size(),
//                    "There shall be the same number of root fields");
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField : compliantAcroForm.getFieldTree()) {
                assertNotNull(toBeComparedAcroForm.getField(param0),
                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField = toBeComparedAcroForm.getField(param0);
                compareFieldProperties(compliantField, toBeComparedField);
            }
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField : toBeComparedAcroForm.getFieldTree()) {
//                assertNotNull(compliantAcroForm.getField(param0),
//                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField = compliantAcroForm.getField(param0);
                compareFieldProperties(toBeComparedField, compliantField);
            }
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(compliantDocument);
            org.apache.pdfbox.io.IOUtils.closeQuietly(toBeCompared);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLegacyModeMerge_3(String param0) throws java.io.IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.File toBeMerged = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "AcroFormForMerge.pdf");
        java.io.File pdfOutput = new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf");
        merger.setDestinationFileName(pdfOutput.getAbsolutePath());
        merger.addSource(toBeMerged);
        merger.addSource(toBeMerged);
        merger.mergeDocuments(null);
        merger.setAcroFormMergeMode(PDFMergerUtility.AcroFormMergeMode.PDFBOX_LEGACY_MODE);
        org.apache.pdfbox.pdmodel.PDDocument compliantDocument = null;
        org.apache.pdfbox.pdmodel.PDDocument toBeCompared = null;
        try {
            compliantDocument = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.IN_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            toBeCompared = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDAcroForm_getField_java_lang_String_MergeAcroFormsTest_testLegacyModeMerge.OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm compliantAcroForm = compliantDocument.getDocumentCatalog().getAcroForm();
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm toBeComparedAcroForm = toBeCompared.getDocumentCatalog().getAcroForm();
//            assertEquals(compliantAcroForm.getFields().size(), toBeComparedAcroForm.getFields().size(),
//                    "There shall be the same number of root fields");
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField : compliantAcroForm.getFieldTree()) {
//                assertNotNull(toBeComparedAcroForm.getField(param0),
//                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField = toBeComparedAcroForm.getField(param0);
                compareFieldProperties(compliantField, toBeComparedField);
            }
            for (org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComparedField : toBeComparedAcroForm.getFieldTree()) {
                assertNotNull(compliantAcroForm.getField(param0),
                        "There shall be a field with the same FQN");
                org.apache.pdfbox.pdmodel.interactive.form.PDField compliantField = compliantAcroForm.getField(param0);
                compareFieldProperties(toBeComparedField, compliantField);
            }
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(compliantDocument);
            org.apache.pdfbox.io.IOUtils.closeQuietly(toBeCompared);
        }
    }

    private void compareFieldProperties(org.apache.pdfbox.pdmodel.interactive.form.PDField sourceField, org.apache.pdfbox.pdmodel.interactive.form.PDField toBeComapredField) {
        // List of keys for comparison
        // Don't include too complex properties such as AP as this will fail the test because
        // of a stack overflow when
        final String[] keys = new String[]{ "FT", "T", "TU", "TM", "Ff", "V", "DV", "Opts", "TI", "I", "Rect", "DA" };
        org.apache.pdfbox.cos.COSDictionary sourceFieldCos = sourceField.getCOSObject();
        org.apache.pdfbox.cos.COSDictionary toBeComparedCos = toBeComapredField.getCOSObject();
        for (String key : keys) {
            org.apache.pdfbox.cos.COSBase sourceBase = sourceFieldCos.getDictionaryObject(key);
            org.apache.pdfbox.cos.COSBase toBeComparedBase = toBeComparedCos.getDictionaryObject(key);
            if (sourceBase != null) {
                assertEquals( sourceBase.toString(), toBeComparedBase.toString(),
                        "The content of the field properties shall be the same");
            } else {
                assertNull(toBeComparedBase,
                        "If the source property is null the compared property shall be null too");
            }
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.BEITRAGSZAHLUNGSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.EINTRITTSALTER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.RISIKO"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.RISIKOOPTION"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERBUNDENE_LEBEN"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERLAUF"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSBEGINN"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("ANGEBOT.VERSSUMME"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Medium-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Small_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignLeft-Border_Wide_Clipped-Filled"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Medium_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignMiddle-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Medium"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Small"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide_Clipped"),
        org.junit.jupiter.params.provider.Arguments.of("AlignRight-Border_Wide_Outside"),
        org.junit.jupiter.params.provider.Arguments.of("BEITRAGSZAHLUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BEITRAGSZAHLUNG.ART"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.NUMMER"),
        org.junit.jupiter.params.provider.Arguments.of("BETREUER.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("BU"),
        org.junit.jupiter.params.provider.Arguments.of("BU.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("BU.JHRLRENTE"),
        org.junit.jupiter.params.provider.Arguments.of("BU.KARENZZEIT"),
        org.junit.jupiter.params.provider.Arguments.of("BU.LEISTUNGSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("BU.VERSDAUER"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.BEITRAGSBEFREIUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.DD"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.PFLEGE"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.PFLEGE_WERT"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.RENTENDYNAMIK"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.VERZICHT"),
        org.junit.jupiter.params.provider.Arguments.of("BUZ.OPTION.ZUZAHLUNG"),
        org.junit.jupiter.params.provider.Arguments.of("BUZEUZ"),
        org.junit.jupiter.params.provider.Arguments.of("BUZEUZ.WAHL"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode1"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode2"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode3"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode4"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode5"),
        org.junit.jupiter.params.provider.Arguments.of("Barcode6"),
        org.junit.jupiter.params.provider.Arguments.of("Checkbox"),
        org.junit.jupiter.params.provider.Arguments.of("Checkbox-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("CheckboxGroup"),
        org.junit.jupiter.params.provider.Arguments.of("Checking/Savings"),
        org.junit.jupiter.params.provider.Arguments.of("Country"),
        org.junit.jupiter.params.provider.Arguments.of("Customer"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Country"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Gender"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("Customer.Name"),
        org.junit.jupiter.params.provider.Arguments.of("DM"),
        org.junit.jupiter.params.provider.Arguments.of("DM.VN"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK.PROZENT"),
        org.junit.jupiter.params.provider.Arguments.of("DYNAMIK.WAS"),
        org.junit.jupiter.params.provider.Arguments.of("Date you are available"),
        org.junit.jupiter.params.provider.Arguments.of("EMP"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.MEHRERE"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.MEHRERE.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("EMP.TOD.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.1.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.2.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART1"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART2"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART3"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ART4"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.3.ZIFFER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.ERGAENZENDE_ANGABEN"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.EXTRABLAETTER"),
        org.junit.jupiter.params.provider.Arguments.of("ERKRANKUNGEN.FOLGE_ANGABEN"),
        org.junit.jupiter.params.provider.Arguments.of("Email address"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.01.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.02.12"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.03"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04.GEWICHT"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.04.GROESSE"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.05"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.06"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.A"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.B"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.C"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.D"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.E"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.F"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.G"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.H"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.07.I"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.08.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.A"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.B"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.C"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.D"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E_LI"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.10.E_RE"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.11"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.12.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.13"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.14"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15.01"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.15.02"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.16"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.17"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.18"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.19"),
        org.junit.jupiter.params.provider.Arguments.of("FRAGEN.9"),
        org.junit.jupiter.params.provider.Arguments.of("Field1"),
        org.junit.jupiter.params.provider.Arguments.of("Field2"),
        org.junit.jupiter.params.provider.Arguments.of("First name"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG.BRUTTO"),
        org.junit.jupiter.params.provider.Arguments.of("GESAMTBEITRAG.NETTO"),
        org.junit.jupiter.params.provider.Arguments.of("Gender"),
        org.junit.jupiter.params.provider.Arguments.of("GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("ID"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBLAND"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBLAND.VP"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.GEBORT.VP"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.AMT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.DAT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.GUELTIG"),
        org.junit.jupiter.params.provider.Arguments.of("ID.PA.NR"),
        org.junit.jupiter.params.provider.Arguments.of("ID.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("ID.STAATSANGEHOERIGKEIT.VP"),
        org.junit.jupiter.params.provider.Arguments.of("JAWS user"),
        org.junit.jupiter.params.provider.Arguments.of("LAND"),
        org.junit.jupiter.params.provider.Arguments.of("Last Name"),
        org.junit.jupiter.params.provider.Arguments.of("LongRichTextField"),
        org.junit.jupiter.params.provider.Arguments.of("MANDANT"),
        org.junit.jupiter.params.provider.Arguments.of("Multiline"),
        org.junit.jupiter.params.provider.Arguments.of("MultilineAutoscale"),
        org.junit.jupiter.params.provider.Arguments.of("MultipeAnnotations-SameLayout"),
        org.junit.jupiter.params.provider.Arguments.of("MultipleAnnotations-DifferentLayout"),
        org.junit.jupiter.params.provider.Arguments.of("Name"),
        org.junit.jupiter.params.provider.Arguments.of("QR"),
        org.junit.jupiter.params.provider.Arguments.of("QR.TRIGGER"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButtonGroup"),
        org.junit.jupiter.params.provider.Arguments.of("RichTextField-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT.2"),
        org.junit.jupiter.params.provider.Arguments.of("SCHWEIGEPFLICHT.2.1"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.ANDERER"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.BANK"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.IBAN"),
        org.junit.jupiter.params.provider.Arguments.of("SEPA.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("SignatureField"),
        org.junit.jupiter.params.provider.Arguments.of("SingleAnnotation"),
        org.junit.jupiter.params.provider.Arguments.of("Singleline"),
        org.junit.jupiter.params.provider.Arguments.of("SinglelineAutoscale"),
        org.junit.jupiter.params.provider.Arguments.of("Speichern"),
        org.junit.jupiter.params.provider.Arguments.of("TARIF"),
        org.junit.jupiter.params.provider.Arguments.of("TARIFGENERATION"),
        org.junit.jupiter.params.provider.Arguments.of("Telephone"),
        org.junit.jupiter.params.provider.Arguments.of("Testfeld"),
        org.junit.jupiter.params.provider.Arguments.of("Testfeld2"),
        org.junit.jupiter.params.provider.Arguments.of("Text2"),
        org.junit.jupiter.params.provider.Arguments.of("TextField"),
        org.junit.jupiter.params.provider.Arguments.of("TextField-DefaultValue"),
        org.junit.jupiter.params.provider.Arguments.of("UNT"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.1"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.1.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.2"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.2.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.3"),
        org.junit.jupiter.params.provider.Arguments.of("UNT.3.ORT_DATUM"),
        org.junit.jupiter.params.provider.Arguments.of("UZV"),
        org.junit.jupiter.params.provider.Arguments.of("UZV.PROZENT"),
        org.junit.jupiter.params.provider.Arguments.of("UZV.WAS"),
        org.junit.jupiter.params.provider.Arguments.of("VN"),
        org.junit.jupiter.params.provider.Arguments.of("VN.ANREDE"),
        org.junit.jupiter.params.provider.Arguments.of("VN.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBDATUM"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.GEBURTSNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VN.LAND"),
        org.junit.jupiter.params.provider.Arguments.of("VN.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("VN.ORT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.PLZ"),
        org.junit.jupiter.params.provider.Arguments.of("VN.PLZ.0"),
        org.junit.jupiter.params.provider.Arguments.of("VN.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("VN.STRASSE"),
        org.junit.jupiter.params.provider.Arguments.of("VN.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("VN.TITEL"),
        org.junit.jupiter.params.provider.Arguments.of("VN.VORNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP"),
        org.junit.jupiter.params.provider.Arguments.of("VP.ANREDE"),
        org.junit.jupiter.params.provider.Arguments.of("VP.BERUF"),
        org.junit.jupiter.params.provider.Arguments.of("VP.FAMILIENSTAND"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBDATUM"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBORT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.GEBURTSNAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP.LAND"),
        org.junit.jupiter.params.provider.Arguments.of("VP.NAME"),
        org.junit.jupiter.params.provider.Arguments.of("VP.ORT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.PLZ"),
        org.junit.jupiter.params.provider.Arguments.of("VP.PLZ.0"),
        org.junit.jupiter.params.provider.Arguments.of("VP.STAATSANGEHOERIGKEIT"),
        org.junit.jupiter.params.provider.Arguments.of("VP.STRASSE"),
        org.junit.jupiter.params.provider.Arguments.of("VP.TELEFON"),
        org.junit.jupiter.params.provider.Arguments.of("VP.TITEL"),
        org.junit.jupiter.params.provider.Arguments.of("VP.VORNAME"),
        org.junit.jupiter.params.provider.Arguments.of("WI"),
        org.junit.jupiter.params.provider.Arguments.of("WI.ANSCHRIFT"),
        org.junit.jupiter.params.provider.Arguments.of("WI.AS"),
        org.junit.jupiter.params.provider.Arguments.of("WI.BEZIEHUNG"),
        org.junit.jupiter.params.provider.Arguments.of("WI.GRUND"),
        org.junit.jupiter.params.provider.Arguments.of("WI.PERSON"),
        org.junit.jupiter.params.provider.Arguments.of("ZIP code"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-cr"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-crlf"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-lf"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-lfcr"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("acrobat-space"),
        org.junit.jupiter.params.provider.Arguments.of("drucken"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName1"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName2"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName3"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName4"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Country"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Gender"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.GenderFemale"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.GenderMale"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName5.Name"),
        org.junit.jupiter.params.provider.Arguments.of("dummyFieldName6"),
        org.junit.jupiter.params.provider.Arguments.of("filled"),
        org.junit.jupiter.params.provider.Arguments.of("foo"),
        org.junit.jupiter.params.provider.Arguments.of("form1[0]"),
        org.junit.jupiter.params.provider.Arguments.of("hilfe"),
        org.junit.jupiter.params.provider.Arguments.of("insert"),
        org.junit.jupiter.params.provider.Arguments.of("insert.datum"),
        org.junit.jupiter.params.provider.Arguments.of("insert.nummer"),
        org.junit.jupiter.params.provider.Arguments.of("insert.uhr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-cr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-crlf"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-lf"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-lfcr"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-nul"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-space"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox-tab"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("reset"),
        org.junit.jupiter.params.provider.Arguments.of("weiter"),
        org.junit.jupiter.params.provider.Arguments.of("zurueck"),
                org.junit.jupiter.params.provider.Arguments.of("SampleField"),
                org.junit.jupiter.params.provider.Arguments.of("MyCheckBox"),
                org.junit.jupiter.params.provider.Arguments.of("MyRadioButton")
        );
    }
}