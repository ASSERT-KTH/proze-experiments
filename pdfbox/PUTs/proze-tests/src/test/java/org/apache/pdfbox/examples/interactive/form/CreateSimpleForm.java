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
 * An example of creating an AcroForm and a form field from scratch.
 *
 * The form field is created with properties similar to creating
 * a form with default settings in Adobe Acrobat.
 */
public final class CreateSimpleForm {
    private CreateSimpleForm() {
    }

    public static void main(String[] args) throws java.io.IOException {
        // Create a new document with an empty page.
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        // Adobe Acrobat uses Helvetica as a default font and
        // stores that under the name '/Helv' in the resources dictionary
        org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
        org.apache.pdfbox.pdmodel.PDResources resources = new org.apache.pdfbox.pdmodel.PDResources();
        resources.put(org.apache.pdfbox.cos.COSName.getPDFName("Helv"), font);
        // Add a new AcroForm and add that to the document
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = new org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
        // Add and set the resources and default appearance at the form level
        acroForm.setDefaultResources(resources);
        // Acrobat sets the font size on the form level to be
        // auto sized as default. This is done by setting the font size to '0'
        String defaultAppearanceString = "/Helv 0 Tf 0 g";
        acroForm.setDefaultAppearance(defaultAppearanceString);
        // Add a form field to the form.
        org.apache.pdfbox.pdmodel.interactive.form.PDTextField textBox = new org.apache.pdfbox.pdmodel.interactive.form.PDTextField(acroForm);
        textBox.setPartialName("SampleField");
        // Acrobat sets the font size to 12 as default
        // This is done by setting the font size to '12' on the
        // field level.
        // The text color is set to blue in this example.
        // To use black, replace "0 0 1 rg" with "0 0 0 rg" or "0 g".
        defaultAppearanceString = "/Helv 12 Tf 0 0 1 rg";
        textBox.setDefaultAppearance(defaultAppearanceString);
        // add the field to the acroform
        acroForm.getFields().add(textBox);
        // Specify the widget annotation associated with the field
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle(50, 750, 200, 50);
        widget.setRectangle(rect);
        widget.setPage(page);
        // set green border and yellow background
        // if you prefer defaults, delete this code block
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary fieldAppearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        fieldAppearance.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 0, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        fieldAppearance.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        widget.setAppearanceCharacteristics(fieldAppearance);
        // make sure the widget annotation is visible on screen and paper
        widget.setPrinted(true);
        // Add the widget annotation to the page
        page.getAnnotations().add(widget);
        // set the alignment ("quadding")
        textBox.setQ(org.apache.pdfbox.pdmodel.interactive.form.PDVariableText.QUADDING_CENTERED);
        // set the field value
        textBox.setValue("Sample field content");
        // put some text near the field
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        cs.beginText();
        cs.setFont(org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA, 15);
        cs.newLineAtOffset(50, 810);
        cs.showText("Field:");
        cs.endText();
        cs.close();
        document.save("target/SimpleForm.pdf");
        document.close();
    }
}