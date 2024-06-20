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

import static org.junit.jupiter.api.Assertions.*; /**
 * Unit tests for PDInlineImage
 *
 * @author Tilman Hausherr
 */
// public class PDInlineImageTest extends TestCase
public class TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output/graphics");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir.mkdirs();
    }

    /**
     * Tests PDInlineImage#PDInlineImage(COSDictionary parameters, byte[] data,
     * Map<String, PDColorSpace> colorSpaces)
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        assertTrue(inlineImage1.isStencil());
        assertEquals(width, inlineImage1.getWidth());
        assertEquals(height, inlineImage1.getHeight());
        assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        assertEquals(width, stencilImage.getWidth());
        assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        assertEquals(width, stencilImage2.getWidth());
        assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        assertEquals(width, image1.getWidth());
        assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        assertEquals(width, image2.getWidth());
        assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        assertNotNull(bim1);
        assertEquals(width, bim1.getWidth());
        assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        assertNotNull(bim2);
        assertEquals(width, bim2.getWidth());
        assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        }
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        }
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_1(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_2(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_3(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_4(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_5(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_6(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_7(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_8(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_9(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_10(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_11(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_12(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_13(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
//        assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_14(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_15(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_16(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_17(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
//        assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_18(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_19(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_20(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_21(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        }
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        };
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_22(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        }
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_23(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        }
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
        document.save(pdfFile);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile, ((String) (null)));
        new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testInlineImage_24(int param0) throws java.io.IOException {
        org.apache.pdfbox.cos.COSDictionary dict = new org.apache.pdfbox.cos.COSDictionary();
        dict.setBoolean(org.apache.pdfbox.cos.COSName.IM, true);
        int width = 31;
        int height = 27;
        dict.setInt(org.apache.pdfbox.cos.COSName.W, width);
        dict.setInt(org.apache.pdfbox.cos.COSName.H, height);
        dict.setInt(org.apache.pdfbox.cos.COSName.BPC, 1);
        int rowbytes = width / 8;
        if ((rowbytes * 8) < width) {
            // PDF spec:
            // If the number of data bits per row is not a multiple of 8,
            // the end of the row is padded with extra bits to fill out the last byte.
            ++rowbytes;
        }
        int datalen = rowbytes * height;
        byte[] data = new byte[datalen];
        for (int i = 0; i < datalen; ++i) {
            data[i] = (((i / 4) % 2) == 0) ? ((byte) (Integer.parseInt("10101010", 2))) : 0;
        }
        PDInlineImage inlineImage1 = new PDInlineImage(dict, data, null);
        // assertTrue(inlineImage1.isStencil());
        // assertEquals(width, inlineImage1.getWidth());
        // assertEquals(height, inlineImage1.getHeight());
        // assertEquals(1, inlineImage1.getBitsPerComponent());
        org.apache.pdfbox.cos.COSDictionary dict2 = new org.apache.pdfbox.cos.COSDictionary();
        dict2.addAll(dict);
        org.apache.pdfbox.cos.COSArray decodeArray = new org.apache.pdfbox.cos.COSArray();
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ONE);
        decodeArray.add(org.apache.pdfbox.cos.COSInteger.ZERO);
        dict2.setItem(org.apache.pdfbox.cos.COSName.DECODE, decodeArray);
        PDInlineImage inlineImage2 = new PDInlineImage(dict2, data, null);
        java.awt.Paint paint = new java.awt.Color(0, 0, 0);
        java.awt.image.BufferedImage stencilImage = inlineImage1.getStencilImage(paint);
        // assertEquals(width, stencilImage.getWidth());
        // assertEquals(height, stencilImage.getHeight());
        java.awt.image.BufferedImage stencilImage2 = inlineImage2.getStencilImage(paint);
        // assertEquals(width, stencilImage2.getWidth());
        // assertEquals(height, stencilImage2.getHeight());
        java.awt.image.BufferedImage image1 = inlineImage1.getImage();
        // assertEquals(width, image1.getWidth());
        // assertEquals(height, image1.getHeight());
        java.awt.image.BufferedImage image2 = inlineImage2.getImage();
        // assertEquals(width, image2.getWidth());
        // assertEquals(height, image2.getHeight());
        boolean writeOk = javax.imageio.ImageIO.write(image1, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim1 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid1.png"));
        // assertNotNull(bim1);
        // assertEquals(width, bim1.getWidth());
        // assertEquals(height, bim1.getHeight());
        writeOk = javax.imageio.ImageIO.write(image2, "png", new java.io.FileOutputStream(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png")));
        // assertTrue(writeOk);
        java.awt.image.BufferedImage bim2 = javax.imageio.ImageIO.read(new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir + "/inline-grid2.png"));
        // assertNotNull(bim2);
        // assertEquals(width, bim2.getWidth());
        // assertEquals(height, bim2.getHeight());
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0xffffff, bim1.getRGB(x, y) & 0xffffff);
                } else {
//                    assertEquals(0, bim1.getRGB(x, y) & 0xffffff);
                }
            }
        };
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (((x % 2) == 0) && ((y % 2) == 0)) {
//                    assertEquals(0, bim2.getRGB(x, y) & 0xffffff);
                } else {
                    assertEquals(0xffffff, bim2.getRGB(x, y) & 0xffffff);
                }
            }
        }
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
        contentStream.drawImage(inlineImage1, 150, 400);
        contentStream.drawImage(inlineImage1, 150, 500, inlineImage1.getWidth() * 2, inlineImage1.getHeight() * 2);
        contentStream.drawImage(inlineImage1, 150, 600, inlineImage1.getWidth() * 4, inlineImage1.getHeight() * 4);
        contentStream.drawImage(inlineImage2, 350, 400);
        contentStream.drawImage(inlineImage2, 350, 500, inlineImage2.getWidth() * 2, inlineImage2.getHeight() * 2);
        contentStream.drawImage(inlineImage2, 350, 600, inlineImage2.getWidth() * 4, inlineImage2.getHeight() * 4);
        contentStream.close();
        java.io.File pdfFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.image.TestProzeGen_PDFRenderer_renderImage_int_PDInlineImageTest_testInlineImage.testResultsDir, "inline.pdf");
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