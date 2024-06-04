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
 * Example to create a checkbox.
 *
 * @author Tilman Hausherr
 */
public class CreateCheckBox {
    private CreateCheckBox() {
    }

    public static void main(String[] args) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm acroForm = new org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
        // if you want to see what Adobe does, activate this, open with Adobe
        // save the file, and then open it with PDFDebugger
        // acroForm.setNeedAppearances(true)
        float x = 50;
        float y = page.getMediaBox().getHeight() - 50;
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle(x, y, 20, 20);
        org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox checkbox = new org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox(acroForm);
        checkbox.setPartialName("MyCheckBox");
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = checkbox.getWidgets().get(0);
        widget.setPage(page);
        widget.setRectangle(rect);
        widget.setPrinted(true);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary(new org.apache.pdfbox.cos.COSDictionary());
        appearanceCharacteristics.setBorderColour(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 0, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        appearanceCharacteristics.setBackground(new org.apache.pdfbox.pdmodel.graphics.color.PDColor(new float[]{ 1, 1, 0 }, org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE));
        // 8 = cross; 4 = checkmark; H = star; u = diamond; n = square, l = dot
        appearanceCharacteristics.setNormalCaption("4");
        widget.setAppearanceCharacteristics(appearanceCharacteristics);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary borderStyleDictionary = new org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary();
        borderStyleDictionary.setWidth(1);
        borderStyleDictionary.setStyle(org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary.STYLE_SOLID);
        widget.setBorderStyle(borderStyleDictionary);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary ap = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary();
        widget.setAppearance(ap);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = ap.getNormalAppearance();
        org.apache.pdfbox.cos.COSDictionary normalAppearanceDict = ((org.apache.pdfbox.cos.COSDictionary) (normalAppearance.getCOSObject()));
        normalAppearanceDict.setItem(org.apache.pdfbox.cos.COSName.Off, CreateCheckBox.createAppearanceStream(document, widget, false));
        normalAppearanceDict.setItem(org.apache.pdfbox.cos.COSName.YES, CreateCheckBox.createAppearanceStream(document, widget, true));
        // If we ever decide to implement a /D (down) appearance, just
        // replace the background colors c with c * 0.75
        page.getAnnotations().add(checkbox.getWidgets().get(0));
        acroForm.getFields().add(checkbox);
        // always call check() or unCheck(), or the box will remain invisible.
        checkbox.unCheck();
        document.save("target/CheckBoxSample.pdf");
        document.close();
    }

    private static org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream createAppearanceStream(final org.apache.pdfbox.pdmodel.PDDocument document, org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget, boolean on) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = widget.getRectangle();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary appearanceCharacteristics;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream yesAP = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(document);
        yesAP.setBBox(new org.apache.pdfbox.pdmodel.common.PDRectangle(rect.getWidth(), rect.getHeight()));
        yesAP.setResources(new org.apache.pdfbox.pdmodel.PDResources());
        org.apache.pdfbox.pdmodel.PDPageContentStream yesAPCS = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, yesAP);
        appearanceCharacteristics = widget.getAppearanceCharacteristics();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor backgroundColor = appearanceCharacteristics.getBackground();
        org.apache.pdfbox.pdmodel.graphics.color.PDColor borderColor = appearanceCharacteristics.getBorderColour();
        float lineWidth = CreateCheckBox.getLineWidth(widget);
        yesAPCS.setLineWidth(lineWidth);// border style (dash) ignored

        yesAPCS.setNonStrokingColor(backgroundColor);
        yesAPCS.addRect(0, 0, rect.getWidth(), rect.getHeight());
        yesAPCS.fill();
        yesAPCS.setStrokingColor(borderColor);
        yesAPCS.addRect(lineWidth / 2, lineWidth / 2, rect.getWidth() - lineWidth, rect.getHeight() - lineWidth);
        yesAPCS.stroke();
        if (!on) {
            yesAPCS.close();
            return yesAP;
        }
        yesAPCS.addRect(lineWidth, lineWidth, rect.getWidth() - (lineWidth * 2), rect.getHeight() - (lineWidth * 2));
        yesAPCS.clip();
        String normalCaption = appearanceCharacteristics.getNormalCaption();
        if (normalCaption == null) {
            normalCaption = "4";// Adobe behaviour

        }
        if ("8".equals(normalCaption)) {
            // Adobe paints a cross instead of using the Zapf Dingbats cross symbol
            yesAPCS.setStrokingColor(0.0F);
            yesAPCS.moveTo(lineWidth * 2, rect.getHeight() - (lineWidth * 2));
            yesAPCS.lineTo(rect.getWidth() - (lineWidth * 2), lineWidth * 2);
            yesAPCS.moveTo(rect.getWidth() - (lineWidth * 2), rect.getHeight() - (lineWidth * 2));
            yesAPCS.lineTo(lineWidth * 2, lineWidth * 2);
            yesAPCS.stroke();
        } else {
            java.awt.geom.Rectangle2D bounds = new java.awt.geom.Rectangle2D.Float();
            String unicode = null;
            // ZapfDingbats font may be missing or substituted, let's use AFM resources instead.
            org.apache.fontbox.afm.AFMParser parser = new org.apache.fontbox.afm.AFMParser(org.apache.pdfbox.pdmodel.font.PDType1Font.class.getResourceAsStream("/org/apache/pdfbox/resources/afm/ZapfDingbats.afm"));
            org.apache.fontbox.afm.FontMetrics metric = parser.parse();
            for (org.apache.fontbox.afm.CharMetric cm : metric.getCharMetrics()) {
                // The caption is not unicode, but the Zapf Dingbats code in the PDF.
                // Assume that only the first character is used.
                if (normalCaption.codePointAt(0) == cm.getCharacterCode()) {
                    org.apache.fontbox.util.BoundingBox bb = cm.getBoundingBox();
                    bounds = new java.awt.geom.Rectangle2D.Float(bb.getLowerLeftX(), bb.getLowerLeftY(), bb.getWidth(), bb.getHeight());
                    unicode = org.apache.pdfbox.pdmodel.font.PDType1Font.ZAPF_DINGBATS.getGlyphList().toUnicode(cm.getName());
                    break;
                }
            }
            if (bounds.isEmpty()) {
                throw new java.io.IOException("Bounds rectangle for chosen glyph is empty");
            }
            float size = ((float) (Math.min(bounds.getWidth(), bounds.getHeight()))) / 1000;
            // assume that checkmark has square size
            // the calculations approximate what Adobe is doing, i.e. put the glyph in the middle
            float fontSize = ((rect.getWidth() - (lineWidth * 2)) / size) * 0.6666F;
            float xOffset = ((float) (rect.getWidth() - ((bounds.getWidth() / 1000) * fontSize))) / 2;
            xOffset -= (bounds.getX() / 1000) * fontSize;
            float yOffset = ((float) (rect.getHeight() - ((bounds.getHeight() / 1000) * fontSize))) / 2;
            yOffset -= (bounds.getY() / 1000) * fontSize;
            yesAPCS.setNonStrokingColor(0.0F);
            yesAPCS.beginText();
            yesAPCS.setFont(org.apache.pdfbox.pdmodel.font.PDType1Font.ZAPF_DINGBATS, fontSize);
            yesAPCS.newLineAtOffset(xOffset, yOffset);
            yesAPCS.showText(unicode);
            yesAPCS.endText();
        }
        yesAPCS.close();
        return yesAP;
    }

    static float getLineWidth(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget) {
        org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary bs = widget.getBorderStyle();
        if (bs != null) {
            return bs.getWidth();
        }
        return 1;
    }
}