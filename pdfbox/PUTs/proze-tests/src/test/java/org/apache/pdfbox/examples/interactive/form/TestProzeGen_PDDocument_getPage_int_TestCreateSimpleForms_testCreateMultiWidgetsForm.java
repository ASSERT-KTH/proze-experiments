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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of some the form examples.
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDDocument_getPage_int_TestCreateSimpleForms_testCreateMultiWidgetsForm {
    public TestProzeGen_PDDocument_getPage_int_TestCreateSimpleForms_testCreateMultiWidgetsForm() {
    }

    /**
     * Test of CreateSimpleFormWithEmbeddedFont
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        assertEquals(page1, doc.getPage(param0));
        assertEquals(page2, doc.getPage(param0));
        assertEquals(page1.getAnnotations().get(0), w1);
        assertEquals(page2.getAnnotations().get(0), w2);
        assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
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
    public void testCreateMultiWidgetsForm_1(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_2(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_3(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_4(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_5(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        assertEquals(page1, doc.getPage(param0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_6(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        assertEquals(page2, doc.getPage(param0));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_7(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_8(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_9(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_10(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_11(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_12(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_13(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_14(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_15(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_16(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateMultiWidgetsForm_17(int param0) throws java.io.IOException {
        CreateMultiWidgetsForm.main(null);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File("target/MultiWidgetsForm.pdf"));
        // assertEquals(2, doc.getNumberOfPages());
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0);
        new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(1);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = ((org.apache.pdfbox.pdmodel.interactive.form.PDTextField) (acroForm.getField("SampleField")));
        // assertEquals("Sample field", textBox.getValue());
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = textBox.getWidgets();
        // assertEquals(2, widgets.size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w1 = widgets.get(0);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget w2 = widgets.get(1);
        org.apache.pdfbox.pdmodel.PDPage page1 = w1.getPage();
        org.apache.pdfbox.pdmodel.PDPage page2 = w2.getPage();
        // assertNotEquals(page1.getCOSObject(), page2.getCOSObject());
        // assertEquals(page1, doc.getPage(0));
        // assertEquals(page2, doc.getPage(1));
        // assertEquals(page1.getAnnotations().get(0), w1);
        // assertEquals(page2.getAnnotations().get(0), w2);
        // assertNotEquals(w1, w2);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics1 = w1.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics2 = w2.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor1 = appearanceCharacteristics1.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor2 = appearanceCharacteristics2.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour1 = appearanceCharacteristics1.getBorderColour();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColour2 = appearanceCharacteristics2.getBorderColour();
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, backgroundColor2.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour1.getColorSpace());
        // assertEquals(org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE, borderColour2.getColorSpace());
        // assertArrayEquals(new float[]{ 1, 1, 0 }, backgroundColor1.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, backgroundColor2.getComponents(), 0);
        // assertArrayEquals(new float[]{ 0, 1, 0 }, borderColour1.getComponents(), 0);
        assertArrayEquals(new float[]{ 1, 0, 0 }, borderColour2.getComponents(), 0);
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(9)
        );
    }
}