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
 * Example to create radio buttons.
 *
 * @author Tilman Hausherr
 */
public class CreateRadioButtons {
    private CreateRadioButtons() {
    }

    public static void main(String[] args) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = new org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm(document);
        // if you want to see what Adobe does, activate this, open with Adobe
        // save the file, and then open it with PDFDebugger
        // acroForm.setNeedAppearances(true)
        document.getDocumentCatalog().setAcroForm(acroForm);
        java.util.List<String> options = java.util.Arrays.asList("a", "b", "c");
        org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton radioButton = new org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton(acroForm);
        radioButton.setPartialName("MyRadioButton");
        radioButton.setExportValues(options);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        appearanceCharacteristics.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 0, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        appearanceCharacteristics.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 0, 1, 0.3F }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        // no caption => round
        // with caption => see checkbox example
        java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget> widgets = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget>();
        for (int i = 0; i < options.size(); i++) {
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget();
            widget.setRectangle(new org.apache.pdfbox.pdmodel.common.PDRectangle(30, (org.apache.pdfbox.pdmodel.common.PDRectangle.A4.getHeight() - 40) - (i * 35), 30, 30));
            widget.setAppearanceCharacteristics(appearanceCharacteristics);
            org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary borderStyleDictionary = new org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary();
            borderStyleDictionary.setWidth(2);
            borderStyleDictionary.setStyle(org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary.STYLE_SOLID);
            widget.setBorderStyle(borderStyleDictionary);
            widget.setPage(page);
            org.apache.pdfbox.cos.COSDictionary apNDict = new org.apache.pdfbox.cos.COSDictionary();
            apNDict.setItem(org.apache.pdfbox.cos.COSName.Off, CreateRadioButtons.createAppearanceStream(document, widget, false));
            apNDict.setItem(options.get(i), CreateRadioButtons.createAppearanceStream(document, widget, true));
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry appearanceNEntry = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry(apNDict);
            appearance.setNormalAppearance(appearanceNEntry);
            widget.setAppearance(appearance);
            widget.setAppearanceState("Off");// don't forget this, or button will be invisible

            widgets.add(widget);
            page.getAnnotations().add(widget);
        }
        radioButton.setWidgets(widgets);
        acroForm.getFields().add(radioButton);
        // Set the texts
        org.apache.pdfbox.pdmodel.PDPageContentStream contents = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        for (int i = 0; i < options.size(); i++) {
            contents.beginText();
            contents.setFont(org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA, 15);
            contents.newLineAtOffset(70, (org.apache.pdfbox.pdmodel.common.PDRectangle.A4.getHeight() - 30) - (i * 35));
            contents.showText(options.get(i));
            contents.endText();
        }
        contents.close();
        radioButton.setValue("c");
        document.save("target/RadioButtonsSample.pdf");
        document.close();
    }

    private static org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream createAppearanceStream(final org.apache.pdfbox.pdmodel.PDDocument document, org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget, boolean on) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = widget.getRectangle();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream onAP = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(document);
        onAP.setBBox(new org.apache.pdfbox.pdmodel.common.PDRectangle(rect.getWidth(), rect.getHeight()));
        org.apache.pdfbox.pdmodel.PDPageContentStream onAPCS = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, onAP);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor = appearanceCharacteristics.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColor = appearanceCharacteristics.getBorderColour();
        float lineWidth = CreateRadioButtons.getLineWidth(widget);
        onAPCS.setLineWidth(lineWidth);// border style (dash) ignored

        onAPCS.setNonStrokingColor(backgroundColor);
        float radius = Math.min(rect.getWidth() / 2, rect.getHeight() / 2);
        CreateRadioButtons.drawCircle(onAPCS, rect.getWidth() / 2, rect.getHeight() / 2, radius);
        onAPCS.fill();
        onAPCS.setStrokingColor(borderColor);
        CreateRadioButtons.drawCircle(onAPCS, rect.getWidth() / 2, rect.getHeight() / 2, radius - (lineWidth / 2));
        onAPCS.stroke();
        if (on) {
            onAPCS.setNonStrokingColor(0.0F);
            CreateRadioButtons.drawCircle(onAPCS, rect.getWidth() / 2, rect.getHeight() / 2, (radius - lineWidth) / 2);
            onAPCS.fill();
        }
        onAPCS.close();
        return onAP;
    }

    static float getLineWidth(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget) {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary bs = widget.getBorderStyle();
        if (bs != null) {
            return bs.getWidth();
        }
        return 1;
    }

    static void drawCircle(org.apache.pdfbox.pdmodel.PDPageContentStream cs, float x, float y, float r) throws java.io.IOException {
        // http://stackoverflow.com/a/2007782/535646
        float magic = r * 0.551784F;
        cs.moveTo(x, y + r);
        cs.curveTo(x + magic, y + r, x + r, y + magic, x + r, y);
        cs.curveTo(x + r, y - magic, x + magic, y - r, x, y - r);
        cs.curveTo(x - magic, y - r, x - r, y - magic, x - r, y);
        cs.curveTo(x - r, y + magic, x - magic, y + r, x, y + r);
        cs.closePath();
    }
}