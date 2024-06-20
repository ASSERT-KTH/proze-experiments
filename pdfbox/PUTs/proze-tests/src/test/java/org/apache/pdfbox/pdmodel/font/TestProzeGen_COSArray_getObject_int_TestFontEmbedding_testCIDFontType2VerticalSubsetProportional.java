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
import static org.junit.jupiter.api.Assertions.assertNull;
/**
 * Tests font embedding.
 *
 * @author John Hewson
 * @author Tilman Hausherr
 */
// public class TestFontEmbedding extends TestCase
public class TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR.mkdirs();
    }

    /**
     * Embed a proportional TTF as vertical CIDFontType2 with subsetting.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        assertEquals(2, w2.size());
        assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
            assertEquals(n, metrics.getInt(i++));
        }
        document.close();
        String extracted = getUnicodeText(pdf);
        assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    private String getUnicodeText(java.io.File file) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String text = stripper.getText(document);
        document.close();
        return text;
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_1(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_2(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_3(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_4(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_5(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_6(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
            assertEquals(n, metrics.getInt(i++));
        }
        document.close();
        String extracted = getUnicodeText(pdf);
        // assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCIDFontType2VerticalSubsetProportional_7(int param0) throws IOException {
        String text = "「ABC」";
        String expectedExtractedtext = "「\nA\nB\nC\n」";
        java.io.File pdf = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSArray_getObject_int_TestFontEmbedding_testCIDFontType2VerticalSubsetProportional.OUT_DIR, "CIDFontType2VP.pdf");
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage(org.apache.pdfbox.pdmodel.common.PDRectangle.A4);
        document.addPage(page);
        java.io.File ipafont = new java.io.File("target/fonts/ipagp00303", "ipagp.ttf");
        PDType0Font vfont = PDType0Font.loadVertical(document, ipafont);
        org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(vfont, 20);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        byte[] encode = vfont.encode(text);
        int cid = ((encode[0] & 0xff) << 8) + (encode[1] & 0xff);
        // assertEquals(12607, cid);
        org.apache.pdfbox.cos.COSDictionary fontDict = vfont.getCOSObject();
        // assertEquals(org.apache.pdfbox.cos.COSName.IDENTITY_V, fontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.ENCODING));
        document.save(pdf);
        org.apache.pdfbox.cos.COSDictionary descFontDict = vfont.getDescendantFont().getCOSObject();
        org.apache.pdfbox.cos.COSArray dw2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.DW2)));
        // assertNull(dw2);
        org.apache.pdfbox.cos.COSArray w2 = ((org.apache.pdfbox.cos.COSArray) (descFontDict.getDictionaryObject(org.apache.pdfbox.cos.COSName.W2)));
        // assertEquals(2, w2.size());
        // assertEquals(12607, w2.getInt(0));
        org.apache.pdfbox.cos.COSArray metrics = ((org.apache.pdfbox.cos.COSArray) (w2.getObject(param0)));
        int i = 0;
        for (int n : new int[]{ -570, 500, 450, -570, 500, 880 }) {
//            assertEquals(n, metrics.getInt(i++));
        };
        document.close();
        String extracted = getUnicodeText(pdf);
        assertEquals(expectedExtractedtext, extracted.replaceAll("\r", "").trim());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(101),
        org.junit.jupiter.params.provider.Arguments.of(102),
        org.junit.jupiter.params.provider.Arguments.of(103),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(105),
        org.junit.jupiter.params.provider.Arguments.of(106),
        org.junit.jupiter.params.provider.Arguments.of(107),
        org.junit.jupiter.params.provider.Arguments.of(108),
        org.junit.jupiter.params.provider.Arguments.of(109),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(110),
        org.junit.jupiter.params.provider.Arguments.of(111),
        org.junit.jupiter.params.provider.Arguments.of(112),
        org.junit.jupiter.params.provider.Arguments.of(113),
        org.junit.jupiter.params.provider.Arguments.of(114),
        org.junit.jupiter.params.provider.Arguments.of(115),
        org.junit.jupiter.params.provider.Arguments.of(116),
        org.junit.jupiter.params.provider.Arguments.of(117),
        org.junit.jupiter.params.provider.Arguments.of(118),
        org.junit.jupiter.params.provider.Arguments.of(119),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(121),
        org.junit.jupiter.params.provider.Arguments.of(122),
        org.junit.jupiter.params.provider.Arguments.of(123),
        org.junit.jupiter.params.provider.Arguments.of(124),
        org.junit.jupiter.params.provider.Arguments.of(125),
        org.junit.jupiter.params.provider.Arguments.of(126),
        org.junit.jupiter.params.provider.Arguments.of(127),
        org.junit.jupiter.params.provider.Arguments.of(128),
        org.junit.jupiter.params.provider.Arguments.of(129),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(130),
        org.junit.jupiter.params.provider.Arguments.of(131),
        org.junit.jupiter.params.provider.Arguments.of(132),
        org.junit.jupiter.params.provider.Arguments.of(133),
        org.junit.jupiter.params.provider.Arguments.of(134),
        org.junit.jupiter.params.provider.Arguments.of(135),
        org.junit.jupiter.params.provider.Arguments.of(136),
        org.junit.jupiter.params.provider.Arguments.of(137),
        org.junit.jupiter.params.provider.Arguments.of(138),
        org.junit.jupiter.params.provider.Arguments.of(139),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(140),
        org.junit.jupiter.params.provider.Arguments.of(141),
        org.junit.jupiter.params.provider.Arguments.of(142),
        org.junit.jupiter.params.provider.Arguments.of(143),
        org.junit.jupiter.params.provider.Arguments.of(144),
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
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(29),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(30),
        org.junit.jupiter.params.provider.Arguments.of(31),
        org.junit.jupiter.params.provider.Arguments.of(32),
        org.junit.jupiter.params.provider.Arguments.of(33),
        org.junit.jupiter.params.provider.Arguments.of(34),
        org.junit.jupiter.params.provider.Arguments.of(35),
        org.junit.jupiter.params.provider.Arguments.of(36),
        org.junit.jupiter.params.provider.Arguments.of(37),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(40),
        org.junit.jupiter.params.provider.Arguments.of(41),
        org.junit.jupiter.params.provider.Arguments.of(42),
        org.junit.jupiter.params.provider.Arguments.of(43),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(45),
        org.junit.jupiter.params.provider.Arguments.of(46),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(48),
        org.junit.jupiter.params.provider.Arguments.of(49),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(50),
        org.junit.jupiter.params.provider.Arguments.of(51),
        org.junit.jupiter.params.provider.Arguments.of(52),
        org.junit.jupiter.params.provider.Arguments.of(53),
        org.junit.jupiter.params.provider.Arguments.of(54),
        org.junit.jupiter.params.provider.Arguments.of(55),
        org.junit.jupiter.params.provider.Arguments.of(56),
        org.junit.jupiter.params.provider.Arguments.of(57),
        org.junit.jupiter.params.provider.Arguments.of(58),
        org.junit.jupiter.params.provider.Arguments.of(59),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(60),
        org.junit.jupiter.params.provider.Arguments.of(61),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(63),
        org.junit.jupiter.params.provider.Arguments.of(64),
        org.junit.jupiter.params.provider.Arguments.of(65),
        org.junit.jupiter.params.provider.Arguments.of(66),
        org.junit.jupiter.params.provider.Arguments.of(67),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(69),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(70),
        org.junit.jupiter.params.provider.Arguments.of(71),
        org.junit.jupiter.params.provider.Arguments.of(72),
        org.junit.jupiter.params.provider.Arguments.of(73),
        org.junit.jupiter.params.provider.Arguments.of(74),
        org.junit.jupiter.params.provider.Arguments.of(75),
        org.junit.jupiter.params.provider.Arguments.of(76),
        org.junit.jupiter.params.provider.Arguments.of(77),
        org.junit.jupiter.params.provider.Arguments.of(78),
        org.junit.jupiter.params.provider.Arguments.of(79),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(80),
        org.junit.jupiter.params.provider.Arguments.of(81),
        org.junit.jupiter.params.provider.Arguments.of(82),
        org.junit.jupiter.params.provider.Arguments.of(83),
        org.junit.jupiter.params.provider.Arguments.of(84),
        org.junit.jupiter.params.provider.Arguments.of(85),
        org.junit.jupiter.params.provider.Arguments.of(86),
        org.junit.jupiter.params.provider.Arguments.of(87),
        org.junit.jupiter.params.provider.Arguments.of(88),
        org.junit.jupiter.params.provider.Arguments.of(89),
        org.junit.jupiter.params.provider.Arguments.of(9),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(91),
        org.junit.jupiter.params.provider.Arguments.of(92),
        org.junit.jupiter.params.provider.Arguments.of(93),
        org.junit.jupiter.params.provider.Arguments.of(94),
        org.junit.jupiter.params.provider.Arguments.of(95),
        org.junit.jupiter.params.provider.Arguments.of(96),
        org.junit.jupiter.params.provider.Arguments.of(97),
        org.junit.jupiter.params.provider.Arguments.of(98),
        org.junit.jupiter.params.provider.Arguments.of(99)
        );
    }
}