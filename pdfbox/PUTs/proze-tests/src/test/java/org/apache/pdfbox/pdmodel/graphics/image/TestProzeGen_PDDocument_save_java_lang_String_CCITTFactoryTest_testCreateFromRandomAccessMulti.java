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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for CCITTFactory
 *
 * @author Tilman Hausherr
 */
// public class CCITTFactoryTest extends TestCase
public class TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output/graphics");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti.testResultsDir.mkdirs();
    }

    /**
     * Tests CCITTFactory#createFromRandomAccess(PDDocument document,
     * RandomAccess reader) with a multi page TIFF
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateFromRandomAccessMulti(String param0) throws java.io.IOException {
        String tiffPath = "src/test/resources/org/apache/pdfbox/pdmodel/graphics/image/ccittg4multi.tif";
        javax.imageio.stream.ImageInputStream is = javax.imageio.ImageIO.createImageInputStream(new java.io.File(tiffPath));
        javax.imageio.ImageReader imageReader = javax.imageio.ImageIO.getImageReaders(is).next();
        imageReader.setInput(is);
        int countTiffImages = imageReader.getNumImages(true);
        assertTrue(countTiffImages > 1);
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        int pdfPageNum = 0;
        while (true) {
            PDImageXObject ximage = CCITTFactory.createFromFile(document, new java.io.File(tiffPath), pdfPageNum);
            if (ximage == null) {
                break;
            }
            java.awt.image.BufferedImage bim = imageReader.read(pdfPageNum);
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.validate(ximage, 1, bim.getWidth(), bim.getHeight(), "tiff", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.checkIdent(bim, ximage.getOpaqueImage());
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
            float fX = ximage.getWidth() / page.getMediaBox().getWidth();
            float fY = ximage.getHeight() / page.getMediaBox().getHeight();
            float factor = Math.max(fX, fY);
            document.addPage(page);
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
            contentStream.drawImage(ximage, 0, 0, ximage.getWidth() / factor, ximage.getHeight() / factor);
            contentStream.close();
            ++pdfPageNum;
        } 
        assertEquals(countTiffImages, pdfPageNum);
        document.save(param0);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti.testResultsDir, "multitiff.pdf"), ((String) (null)));
        assertEquals(countTiffImages, document.getNumberOfPages());
        document.close();
        imageReader.dispose();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateFromRandomAccessMulti_1(String param0) throws java.io.IOException {
        String tiffPath = "src/test/resources/org/apache/pdfbox/pdmodel/graphics/image/ccittg4multi.tif";
        javax.imageio.stream.ImageInputStream is = javax.imageio.ImageIO.createImageInputStream(new java.io.File(tiffPath));
        javax.imageio.ImageReader imageReader = javax.imageio.ImageIO.getImageReaders(is).next();
        imageReader.setInput(is);
        int countTiffImages = imageReader.getNumImages(true);
        assertTrue(countTiffImages > 1);
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        int pdfPageNum = 0;
        while (true) {
            PDImageXObject ximage = CCITTFactory.createFromFile(document, new java.io.File(tiffPath), pdfPageNum);
            if (ximage == null) {
                break;
            }
            java.awt.image.BufferedImage bim = imageReader.read(pdfPageNum);
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.validate(ximage, 1, bim.getWidth(), bim.getHeight(), "tiff", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.checkIdent(bim, ximage.getOpaqueImage());
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
            float fX = ximage.getWidth() / page.getMediaBox().getWidth();
            float fY = ximage.getHeight() / page.getMediaBox().getHeight();
            float factor = Math.max(fX, fY);
            document.addPage(page);
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
            contentStream.drawImage(ximage, 0, 0, ximage.getWidth() / factor, ximage.getHeight() / factor);
            contentStream.close();
            ++pdfPageNum;
        } 
        // org.junit.Assert.assertEquals(countTiffImages, pdfPageNum);
        document.save(param0);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti.testResultsDir, "multitiff.pdf"), ((String) (null)));
        // org.junit.Assert.assertEquals(countTiffImages, document.getNumberOfPages());
        document.close();
        imageReader.dispose();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateFromRandomAccessMulti_2(String param0) throws java.io.IOException {
        String tiffPath = "src/test/resources/org/apache/pdfbox/pdmodel/graphics/image/ccittg4multi.tif";
        javax.imageio.stream.ImageInputStream is = javax.imageio.ImageIO.createImageInputStream(new java.io.File(tiffPath));
        javax.imageio.ImageReader imageReader = javax.imageio.ImageIO.getImageReaders(is).next();
        imageReader.setInput(is);
        int countTiffImages = imageReader.getNumImages(true);
        // org.junit.Assert.assertTrue(countTiffImages > 1);
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        int pdfPageNum = 0;
        while (true) {
            PDImageXObject ximage = CCITTFactory.createFromFile(document, new java.io.File(tiffPath), pdfPageNum);
            if (ximage == null) {
                break;
            }
            java.awt.image.BufferedImage bim = imageReader.read(pdfPageNum);
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.validate(ximage, 1, bim.getWidth(), bim.getHeight(), "tiff", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.checkIdent(bim, ximage.getOpaqueImage());
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
            float fX = ximage.getWidth() / page.getMediaBox().getWidth();
            float fY = ximage.getHeight() / page.getMediaBox().getHeight();
            float factor = Math.max(fX, fY);
            document.addPage(page);
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
            contentStream.drawImage(ximage, 0, 0, ximage.getWidth() / factor, ximage.getHeight() / factor);
            contentStream.close();
            ++pdfPageNum;
        } 
        assertEquals(countTiffImages, pdfPageNum);
        document.save(param0);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti.testResultsDir, "multitiff.pdf"), ((String) (null)));
        // org.junit.Assert.assertEquals(countTiffImages, document.getNumberOfPages());
        document.close();
        imageReader.dispose();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateFromRandomAccessMulti_3(String param0) throws java.io.IOException {
        String tiffPath = "src/test/resources/org/apache/pdfbox/pdmodel/graphics/image/ccittg4multi.tif";
        javax.imageio.stream.ImageInputStream is = javax.imageio.ImageIO.createImageInputStream(new java.io.File(tiffPath));
        javax.imageio.ImageReader imageReader = javax.imageio.ImageIO.getImageReaders(is).next();
        imageReader.setInput(is);
        int countTiffImages = imageReader.getNumImages(true);
        // org.junit.Assert.assertTrue(countTiffImages > 1);
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        int pdfPageNum = 0;
        while (true) {
            PDImageXObject ximage = CCITTFactory.createFromFile(document, new java.io.File(tiffPath), pdfPageNum);
            if (ximage == null) {
                break;
            }
            java.awt.image.BufferedImage bim = imageReader.read(pdfPageNum);
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.validate(ximage, 1, bim.getWidth(), bim.getHeight(), "tiff", org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray.INSTANCE.getName());
            org.apache.pdfbox.pdmodel.graphics.image.ValidateXImage.checkIdent(bim, ximage.getOpaqueImage());
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
            float fX = ximage.getWidth() / page.getMediaBox().getWidth();
            float fY = ximage.getHeight() / page.getMediaBox().getHeight();
            float factor = Math.max(fX, fY);
            document.addPage(page);
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, false);
            contentStream.drawImage(ximage, 0, 0, ximage.getWidth() / factor, ximage.getHeight() / factor);
            contentStream.close();
            ++pdfPageNum;
        } 
        // org.junit.Assert.assertEquals(countTiffImages, pdfPageNum);
        document.save(param0);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_CCITTFactoryTest_testCreateFromRandomAccessMulti.testResultsDir, "multitiff.pdf"), ((String) (null)));
        assertEquals(countTiffImages, document.getNumberOfPages());
        document.close();
        imageReader.dispose();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("./000752-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000752-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000810-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-decoded.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-from-txt.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-locked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-overlaid.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-unlocked.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1031.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1065.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1100.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxJoinFieldsMerge-TextFieldsOnly-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxLegacyMerge-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation-same-name-off.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation-same-name.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/ocg-generation.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/overlay1.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/text-doc.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/text-with-form-overlay.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/clone/clone-dst.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/clone/clone-src.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/multitiff.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletiff.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletifffrombi.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/graphics/singletifffromchessbi.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/JpegMultiMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/MergerOpenActionTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged3.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeIndirectObjectTest.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeSingleDirectObjectTest.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/pdmodel/common/removeSingleIndirectObjectTest.pdf"),
                org.junit.jupiter.params.provider.Arguments.of("target/CheckBoxSample-modified.pdf"),
                org.junit.jupiter.params.provider.Arguments.of("target/RadioButtonsSample-modified.pdf")
        );
    }
}