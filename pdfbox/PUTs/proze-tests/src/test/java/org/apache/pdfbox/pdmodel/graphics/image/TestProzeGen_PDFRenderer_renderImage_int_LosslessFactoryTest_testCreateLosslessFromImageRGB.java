/* Copyright 2014 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit tests for LosslessFactory
 *
 * @author Tilman Hausherr
 */
// public class LosslessFactoryTest extends TestCase
public class TestProzeGen_PDFRenderer_renderImage_int_LosslessFactoryTest_testCreateLosslessFromImageRGB {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output/graphics");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDFRenderer_renderImage_int_LosslessFactoryTest_testCreateLosslessFromImageRGB.testResultsDir.mkdirs();
    }

    /**
     * Tests RGB LosslessFactoryTest#createFromImage(PDDocument document,
     * BufferedImage image)
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateLosslessFromImageRGB(int param0) throws java.io.IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        java.awt.image.BufferedImage image = javax.imageio.ImageIO.read(this.getClass().getResourceAsStream("png.png"));
        PDImageXObject ximage1 = LosslessFactory.createFromImage(document, image);
        ValidateXImage.validate(ximage1, 8, image.getWidth(), image.getHeight(), "png", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.INSTANCE.getName());
        ValidateXImage.checkIdent(image, ximage1.getImage());
        // Create a grayscale image
        java.awt.image.BufferedImage grayImage = new java.awt.image.BufferedImage(image.getWidth(), image.getHeight(), java.awt.image.BufferedImage.TYPE_BYTE_GRAY);
        java.awt.Graphics g = grayImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        PDImageXObject ximage2 = LosslessFactory.createFromImage(document, grayImage);
        ValidateXImage.validate(ximage2, 8, grayImage.getWidth(), grayImage.getHeight(), "png", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
        ValidateXImage.checkIdent(grayImage, ximage2.getImage());
        // Create a bitonal image
        java.awt.image.BufferedImage bitonalImage = new java.awt.image.BufferedImage(image.getWidth(), image.getHeight(), java.awt.image.BufferedImage.TYPE_BYTE_BINARY);
        // avoid multiple of 8 to test padding
        assertNotEquals(0, bitonalImage.getWidth() % 8);
        g = bitonalImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        PDImageXObject ximage3 = LosslessFactory.createFromImage(document, bitonalImage);
        ValidateXImage.validate(ximage3, 1, bitonalImage.getWidth(), bitonalImage.getHeight(), "png", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
        ValidateXImage.checkIdent(bitonalImage, ximage3.getImage());
        // This part isn't really needed because this test doesn't break
        // if the mask has the wrong colorspace (PDFBOX-2057), but it is still useful
        // if something goes wrong in the future and we want to have a PDF to open.
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(ximage1, 200, 300, ximage1.getWidth() / 2, ximage1.getHeight() / 2);
        contentStream.drawImage(ximage2, 200, 450, ximage2.getWidth() / 2, ximage2.getHeight() / 2);
        contentStream.drawImage(ximage3, 200, 600, ximage3.getWidth() / 2, ximage3.getHeight() / 2);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDFRenderer_renderImage_int_LosslessFactoryTest_testCreateLosslessFromImageRGB.testResultsDir, "misc.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }


    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}