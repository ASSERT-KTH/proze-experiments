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
 * An example of creating an AcroForm and a form field from scratch, with two widgets for one field:
 * This means that the same field is visible on two separate pages, but can be on different
 * positions and different size and colors. Changing the value on one page will also change it on
 * the other page.
 *
 * The form field is created with properties similar to creating a form with default settings in
 * Adobe Acrobat.
 */
public final class CreateMultiWidgetsForm {
    private CreateMultiWidgetsForm() {
    }

    public static void main(String[] args) throws java.io.IOException {
        // Create a new document with 2 empty pages.
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page1 = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page1);
        org.apache.pdfbox.pdmodel.PDPage page2 = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page2);
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
        // add the field to the AcroForm
        acroForm.getFields().add(textBox);
        // Specify 1st annotation associated with the field
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget1 = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle(50, 750, 250, 50);
        widget1.setRectangle(rect);
        widget1.setPage(page1);
        widget1.setParent(textBox);
        // Specify 2nd annotation associated with the field
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget2 = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
        org.apache.pdfbox.pdmodel.common.PDRectangle rect2 = new org.apache.pdfbox.pdmodel.common.PDRectangle(200, 650, 100, 50);
        widget2.setRectangle(rect2);
        widget2.setPage(page2);
        widget2.setParent(textBox);
        // set green border and yellow background for 1st widget
        // if you prefer defaults, delete this code block
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary fieldAppearance1 = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        fieldAppearance1.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 0, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        fieldAppearance1.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        widget1.setAppearanceCharacteristics(fieldAppearance1);
        // set red border and green background for 2nd widget
        // if you prefer defaults, delete this code block
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary fieldAppearance2 = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        fieldAppearance2.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 0, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        fieldAppearance2.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 0, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        widget2.setAppearanceCharacteristics(fieldAppearance2);
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
        widgets.add(widget1);
        widgets.add(widget2);
        textBox.setWidgets(widgets);
        // make sure the annotations are visible on screen and paper
        widget1.setPrinted(true);
        widget2.setPrinted(true);
        // Add the annotations to the pages
        page1.getAnnotations().add(widget1);
        page2.getAnnotations().add(widget2);
        // set the field value
        textBox.setValue("Sample field");
        document.save("target/MultiWidgetsForm.pdf");
        document.close();
    }
}