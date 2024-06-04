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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for RubberStampWithImage
 */
public class TestProzeGen_PDFRenderer_renderImage_int_TestRubberStampWithImage_test {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void test(int param0) throws java.io.IOException {
        String documentFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/document.pdf";
        String stampFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/stamp.jpg";
        String outFile = "target/test-output/TestRubberStampWithImage.pdf";
        new java.io.File("target/test-output").mkdirs();
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(documentFile));
        java.awt.image.BufferedImage bim1 = new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        doc1.close();
        String[] args = new String[]{ documentFile, outFile, stampFile };
        RubberStampWithImage rubberStamp = new RubberStampWithImage();
        rubberStamp.doIt(args);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(outFile));
        java.awt.image.BufferedImage bim2 = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        assertFalse(compareImages(bim1, bim2));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp rubberStampAnnotation = ((org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp) (doc2.getPage(0).getAnnotations().get(0)));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = rubberStampAnnotation.getAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream appearanceStream = normalAppearance.getAppearanceStream();
        org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject ximage = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) (appearanceStream.getResources().getXObject(org.apache.pdfbox.cos.COSName.getPDFName("Im1"))));
        java.awt.image.BufferedImage actualStampImage = ximage.getImage();
        java.awt.image.BufferedImage expectedStampImage = javax.imageio.ImageIO.read(new java.io.File(stampFile));
        assertTrue(compareImages(expectedStampImage, actualStampImage));
        doc2.close();
    }

    private boolean compareImages(java.awt.image.BufferedImage bim1, java.awt.image.BufferedImage bim2) {
        if (bim1.getWidth() != bim2.getWidth()) {
            return false;
        }
        if (bim1.getHeight() != bim2.getHeight()) {
            return false;
        }
        for (int x = 0; x < bim1.getWidth(); ++x) {
            for (int y = 0; y < bim1.getHeight(); ++y) {
                if (bim1.getRGB(x, y) != bim2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void test_1(int param0) throws java.io.IOException {
        String documentFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/document.pdf";
        String stampFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/stamp.jpg";
        String outFile = "target/test-output/TestRubberStampWithImage.pdf";
        new java.io.File("target/test-output").mkdirs();
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(documentFile));
        java.awt.image.BufferedImage bim1 = new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        doc1.close();
        String[] args = new String[]{ documentFile, outFile, stampFile };
        RubberStampWithImage rubberStamp = new RubberStampWithImage();
        rubberStamp.doIt(args);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(outFile));
        java.awt.image.BufferedImage bim2 = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        assertFalse(compareImages(bim1, bim2));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp rubberStampAnnotation = ((org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp) (doc2.getPage(0).getAnnotations().get(0)));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = rubberStampAnnotation.getAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream appearanceStream = normalAppearance.getAppearanceStream();
        org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject ximage = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) (appearanceStream.getResources().getXObject(org.apache.pdfbox.cos.COSName.getPDFName("Im1"))));
        java.awt.image.BufferedImage actualStampImage = ximage.getImage();
        java.awt.image.BufferedImage expectedStampImage = javax.imageio.ImageIO.read(new java.io.File(stampFile));
        // assertTrue(compareImages(expectedStampImage, actualStampImage));
        doc2.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void test_2(int param0) throws java.io.IOException {
        String documentFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/document.pdf";
        String stampFile = "src/test/resources/org/apache/pdfbox/examples/pdmodel/stamp.jpg";
        String outFile = "target/test-output/TestRubberStampWithImage.pdf";
        new java.io.File("target/test-output").mkdirs();
        org.apache.pdfbox.pdmodel.PDDocument doc1 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(documentFile));
        java.awt.image.BufferedImage bim1 = new org.apache.pdfbox.rendering.PDFRenderer(doc1).renderImage(param0);
        doc1.close();
        String[] args = new String[]{ documentFile, outFile, stampFile };
        RubberStampWithImage rubberStamp = new RubberStampWithImage();
        rubberStamp.doIt(args);
        org.apache.pdfbox.pdmodel.PDDocument doc2 = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(outFile));
        java.awt.image.BufferedImage bim2 = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(param0);
        // assertFalse(compareImages(bim1, bim2));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp rubberStampAnnotation = ((org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp) (doc2.getPage(0).getAnnotations().get(0)));
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary appearance = rubberStampAnnotation.getAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream appearanceStream = normalAppearance.getAppearanceStream();
        org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject ximage = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) (appearanceStream.getResources().getXObject(org.apache.pdfbox.cos.COSName.getPDFName("Im1"))));
        java.awt.image.BufferedImage actualStampImage = ximage.getImage();
        java.awt.image.BufferedImage expectedStampImage = javax.imageio.ImageIO.read(new java.io.File(stampFile));
        assertTrue(compareImages(expectedStampImage, actualStampImage));
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