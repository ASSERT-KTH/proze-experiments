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
/**
 * An example of creating an AcroForm and a form field from scratch with a font fully embedded to
 * allow non-WinAnsiEncoding input.
 *
 * The form field is created with properties similar to creating a form with default settings in
 * Adobe Acrobat.
 */
public class CreateSimpleFormWithEmbeddedFont {
    private CreateSimpleFormWithEmbeddedFont() {
    }

    public static void main(String[] args) throws java.io.IOException {
        // Create a new document with an empty page.
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        doc.addPage(page);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = new org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm(doc);
        doc.getDocumentCatalog().setAcroForm(acroForm);
        // Note that the font is fully embedded. If you use a different font, make sure that
        // its license allows full embedding.
        org.apache.pdfbox.pdmodel.font.PDFont formFont = org.apache.pdfbox.pdmodel.font.PDType0Font.load(doc, CreateSimpleFormWithEmbeddedFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), false);
        // Add and set the resources and default appearance at the form level
        final org.apache.pdfbox.pdmodel.PDResources resources = new org.apache.pdfbox.pdmodel.PDResources();
        acroForm.setDefaultResources(resources);
        final String fontName = resources.add(formFont).getName();
        // Acrobat sets the font size on the form level to be
        // auto sized as default. This is done by setting the font size to '0'
        acroForm.setDefaultResources(resources);
        String defaultAppearanceString = ("/" + fontName) + " 0 Tf 0 g";
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = new org.apache.pdfbox.pdmodel.interactive.form.PDTextField(acroForm);
        textBox.setPartialName("SampleField");
        textBox.setDefaultAppearance(defaultAppearanceString);
        acroForm.getFields().add(textBox);
        // Specify the widget annotation associated with the field
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle(50, 700, 200, 50);
        widget.setRectangle(rect);
        widget.setPage(page);
        page.getAnnotations().add(widget);
        // set green border and yellow background
        // if you prefer defaults, delete this code block
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary fieldAppearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        fieldAppearance.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 0, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        fieldAppearance.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        widget.setAppearanceCharacteristics(fieldAppearance);
        // set the field value. Note that the last character is a turkish capital I with a dot,
        // which is not part of WinAnsiEncoding
        textBox.setValue("Sample field İ");
        // put some text near the field
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        cs.beginText();
        cs.setFont(org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA, 15);
        cs.newLineAtOffset(50, 760);
        cs.showText("Field:");
        cs.endText();
        cs.close();
        doc.save("target/SimpleFormWithEmbeddedFont.pdf");
        doc.close();
    }
}