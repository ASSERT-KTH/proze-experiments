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
package org.apache.pdfbox.pdmodel.font;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
/**
 *
 * @author adam
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115 {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR.mkdirs();
    }

    /**
     * PDFBOX-4115: Test ability to create PDF with german umlaut glyphs with a type 1 font.
     * Test for everything that went wrong before this was fixed.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115(int param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
        String text = "äöüÄÖÜ";
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDType1Font font = new PDType1Font(doc, new java.io.FileInputStream(fontFile), org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE);
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        doc.addPage(page);
        doc.save(outputFile);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(outputFile);
        font = ((PDType1Font) (doc.getPage(param0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        assertEquals(org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE, font.getEncoding());
        for (char c : text.toCharArray()) {
            String name = font.getEncoding().getName(c);
            assertEquals("dieresis", name.substring(1));
            assertFalse(font.getPath(name).getBounds2D().isEmpty());
        }
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        assertEquals(text, stripper.getText(doc).trim());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115_1(int param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
        String text = "äöüÄÖÜ";
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDType1Font font = new PDType1Font(doc, new java.io.FileInputStream(fontFile), org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE);
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        doc.addPage(page);
        doc.save(outputFile);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(outputFile);
        font = ((PDType1Font) (doc.getPage(param0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        assertEquals(org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE, font.getEncoding());
         for (char c : text.toCharArray()) {
            String name = font.getEncoding().getName(c);
//            assertEquals("dieresis", name.substring(1));
//            assertFalse(font.getPath(name).getBounds2D().isEmpty());
        };
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        // assertEquals(text, stripper.getText(doc).trim());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115_2(int param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
        String text = "äöüÄÖÜ";
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDType1Font font = new PDType1Font(doc, new java.io.FileInputStream(fontFile), org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE);
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        doc.addPage(page);
        doc.save(outputFile);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(outputFile);
        font = ((PDType1Font) (doc.getPage(param0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        // assertEquals(org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE, font.getEncoding());
        for (char c : text.toCharArray()) {
            String name = font.getEncoding().getName(c);
            assertEquals("dieresis", name.substring(1));
//            assertFalse(font.getPath(name).getBounds2D().isEmpty());
        }
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        // assertEquals(text, stripper.getText(doc).trim());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115_3(int param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
        String text = "äöüÄÖÜ";
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDType1Font font = new PDType1Font(doc, new java.io.FileInputStream(fontFile), org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE);
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        doc.addPage(page);
        doc.save(outputFile);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(outputFile);
        font = ((PDType1Font) (doc.getPage(param0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        // assertEquals(org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE, font.getEncoding());
         for (char c : text.toCharArray()) {
            String name = font.getEncoding().getName(c);
//            assertEquals("dieresis", name.substring(1));
            assertFalse(font.getPath(name).getBounds2D().isEmpty());
        };
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
//        assertEquals(text, stripper.getText(doc).trim());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115_4(int param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
        String text = "äöüÄÖÜ";
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDType1Font font = new PDType1Font(doc, new java.io.FileInputStream(fontFile), org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE);
        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.newLineAtOffset(10, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        doc.addPage(page);
        doc.save(outputFile);
        doc.close();
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(outputFile);
        font = ((PDType1Font) (doc.getPage(param0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        // assertEquals(org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding.INSTANCE, font.getEncoding());
        for (char c : text.toCharArray()) {
            String name = font.getEncoding().getName(c);
//            assertEquals("dieresis", name.substring(1));
//            assertFalse(font.getPath(name).getBounds2D().isEmpty());
        };
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        assertEquals(text, stripper.getText(doc).trim());
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(9)
        );
    }
}