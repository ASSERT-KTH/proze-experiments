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
package org.apache.pdfbox.examples.pdmodel;
import java.io.IOException;
/**
 * This is an example on how to add a rubber stamp annotation with an image to pages of a PDF
 * document. To add a normal image, use the AddImageToPDF.java example.
 */
public class RubberStampWithImage {
    private static final String SAVE_GRAPHICS_STATE = "q\n";

    private static final String RESTORE_GRAPHICS_STATE = "Q\n";

    private static final String CONCATENATE_MATRIX = "cm\n";

    private static final String XOBJECT_DO = "Do\n";

    private static final String SPACE = " ";

    private static final java.text.NumberFormat FORMATDECIMAL = java.text.NumberFormat.getNumberInstance(java.util.Locale.US);

    /**
     * Add a rubber stamp with an jpg image to every page of the given document.
     *
     * @param args
     * 		the command line arguments
     * @throws IOException
     * 		an exception is thrown if something went wrong
     */
    public void doIt(String[] args) throws IOException {
        if (args.length != 3) {
            usage();
        } else {
            org.apache.pdfbox.pdmodel.PDDocument document = null;
            try {
                document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(args[0]));
                if (document.isEncrypted()) {
                    throw new IOException("Encrypted documents are not supported for this example");
                }
                for (int i = 0; i < document.getNumberOfPages(); i++) {
                    org.apache.pdfbox.pdmodel.PDPage page = document.getPage(i);
                    java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = page.getAnnotations();
                    org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp rubberStamp = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp();
                    rubberStamp.setName(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp.NAME_TOP_SECRET);
                    rubberStamp.setRectangle(new org.apache.pdfbox.pdmodel.common.PDRectangle(200, 100));
                    rubberStamp.setContents("A top secret note");
                    // create a PDXObjectImage with the given image file
                    // if you already have the image in a BufferedImage,
                    // call LosslessFactory.createFromImage() instead
                    org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject ximage = org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject.createFromFile(args[2], document);
                    // define and set the target rectangle
                    float lowerLeftX = 250;
                    float lowerLeftY = 550;
                    float formWidth = 150;
                    float formHeight = 25;
                    float imgWidth = 50;
                    float imgHeight = 25;
                    org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle();
                    rect.setLowerLeftX(lowerLeftX);
                    rect.setLowerLeftY(lowerLeftY);
                    rect.setUpperRightX(lowerLeftX + formWidth);
                    rect.setUpperRightY(lowerLeftY + formHeight);
                    // Create a PDFormXObject
                    org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = new org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject(document);
                    form.setResources(new org.apache.pdfbox.pdmodel.PDResources());
                    form.setBBox(rect);
                    form.setFormType(1);
                    // adjust the image to the target rectangle and add it to the stream
                    java.io.OutputStream os = form.getStream().createOutputStream();
                    drawXObject(ximage, form.getResources(), os, lowerLeftX, lowerLeftY, imgWidth, imgHeight);
                    os.close();
                    org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream myDic = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream(form.getCOSObject());
                    org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary(new org.apache.pdfbox.cos.COSDictionary());
                    appearance.setNormalAppearance(myDic);
                    rubberStamp.setAppearance(appearance);
                    rubberStamp.setRectangle(rect);
                    // add the new RubberStamp to the document
                    annotations.add(rubberStamp);
                }
                document.save(args[1]);
            } finally {
                if (document != null) {
                    document.close();
                }
            }
        }
    }

    private void drawXObject(org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject xobject, org.apache.pdfbox.pdmodel.PDResources resources, java.io.OutputStream os, float x, float y, float width, float height) throws IOException {
        // This is similar to PDPageContentStream.drawXObject()
        org.apache.pdfbox.cos.COSName xObjectId = resources.add(xobject);
        appendRawCommands(os, RubberStampWithImage.SAVE_GRAPHICS_STATE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(width));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(0));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(0));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(height));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(x));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.FORMATDECIMAL.format(y));
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.CONCATENATE_MATRIX);
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, "/");
        appendRawCommands(os, xObjectId.getName());
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.XOBJECT_DO);
        appendRawCommands(os, RubberStampWithImage.SPACE);
        appendRawCommands(os, RubberStampWithImage.RESTORE_GRAPHICS_STATE);
    }

    private void appendRawCommands(java.io.OutputStream os, String commands) throws IOException {
        os.write(commands.getBytes("ISO-8859-1"));
    }

    /**
     * This creates an instance of RubberStampWithImage.
     *
     * @param args
     * 		The command line arguments.
     * @throws IOException
     * 		If there is an error parsing the document.
     */
    public static void main(String[] args) throws IOException {
        RubberStampWithImage rubberStamp = new RubberStampWithImage();
        rubberStamp.doIt(args);
    }

    /**
     * This will print the usage for this example.
     */
    private void usage() {
        System.err.println(("Usage: java " + getClass().getName()) + " <input-pdf> <output-pdf> <image-filename>");
    }
}