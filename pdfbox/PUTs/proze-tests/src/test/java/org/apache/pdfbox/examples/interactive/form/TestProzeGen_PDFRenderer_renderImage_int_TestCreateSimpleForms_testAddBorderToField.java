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
package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test of some the form examples.
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testAddBorderToField {
    public TestProzeGen_PDFRenderer_renderImage_int_TestCreateSimpleForms_testAddBorderToField() {
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    private org.apache.pdfbox.pdmodel.font.PDFont getFontFromWidgetResources(org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox, String fontResourceName) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = widget.getAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream appearanceStream = normalAppearance.getAppearanceStream();
        org.apache.pdfbox.pdmodel.PDResources resources = appearanceStream.getResources();
        return resources.getFont(org.apache.pdfbox.cos.COSName.getPDFName(fontResourceName));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_1(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_2(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_3(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_4(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_5(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddBorderToField_6(int param0) throws java.io.IOException {
        CreateSimpleForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/SimpleForm.pdf"));
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour = appearanceCharacteristics.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColour = appearanceCharacteristics.getBackground();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColour.getColorSpace());
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColour.getComponents(), 0);
        doc.close();
        AddBorderToField.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/AddBorderToField.pdf"));
        new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm2 = doc2.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox2 = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm2.getField("SampleField")));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = textBox2.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = widget2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc2.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}