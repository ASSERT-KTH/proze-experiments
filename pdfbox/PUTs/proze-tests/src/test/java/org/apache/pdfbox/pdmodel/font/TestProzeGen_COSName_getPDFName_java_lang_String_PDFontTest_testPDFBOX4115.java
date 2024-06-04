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
public class TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115 {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR.mkdirs();
    }

    /**
     * PDFBOX-4115: Test ability to create PDF with german umlaut glyphs with a type 1 font.
     * Test for everything that went wrong before this was fixed.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX4115(String param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
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
        font = ((PDType1Font) (doc.getPage(0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName(param0))));
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
    public void testPDFBOX4115_1(String param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
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
        font = ((PDType1Font) (doc.getPage(0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName(param0))));
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
    public void testPDFBOX4115_2(String param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
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
        font = ((PDType1Font) (doc.getPage(0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName(param0))));
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
    public void testPDFBOX4115_3(String param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
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
        font = ((PDType1Font) (doc.getPage(0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName(param0))));
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
    public void testPDFBOX4115_4(String param0) throws IOException {
        java.io.File fontFile = new java.io.File("target/fonts", "n019003l.pfb");
        java.io.File outputFile = new java.io.File(org.apache.pdfbox.pdmodel.font.TestProzeGen_COSName_getPDFName_java_lang_String_PDFontTest_testPDFBOX4115.OUT_DIR, "FontType1.pdf");
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
        font = ((PDType1Font) (doc.getPage(0).getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName(param0))));
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
        org.junit.jupiter.params.provider.Arguments.of("A"),
        org.junit.jupiter.params.provider.Arguments.of("AESV3"),
        org.junit.jupiter.params.provider.Arguments.of("AcroForm"),
        org.junit.jupiter.params.provider.Arguments.of("Ascent"),
        org.junit.jupiter.params.provider.Arguments.of("Author"),
        org.junit.jupiter.params.provider.Arguments.of("AvgWidth"),
        org.junit.jupiter.params.provider.Arguments.of("BG2"),
        org.junit.jupiter.params.provider.Arguments.of("BJEDEG+Arial-BoldMT"),
        org.junit.jupiter.params.provider.Arguments.of("BJEDFM+ArialMT"),
        org.junit.jupiter.params.provider.Arguments.of("BJEDHC+Arial-ItalicMT"),
        org.junit.jupiter.params.provider.Arguments.of("BJEFFP+TimesNewRomanPSMT"),
        org.junit.jupiter.params.provider.Arguments.of("BJEKNL+Arial-BoldItalicMT"),
        org.junit.jupiter.params.provider.Arguments.of("BM"),
        org.junit.jupiter.params.provider.Arguments.of("BaseFont"),
        org.junit.jupiter.params.provider.Arguments.of("BitsPerComponent"),
        org.junit.jupiter.params.provider.Arguments.of("BleedBox"),
        org.junit.jupiter.params.provider.Arguments.of("CA"),
        org.junit.jupiter.params.provider.Arguments.of("CF"),
        org.junit.jupiter.params.provider.Arguments.of("CFM"),
        org.junit.jupiter.params.provider.Arguments.of("CIDFontType2"),
        org.junit.jupiter.params.provider.Arguments.of("CIDSystemInfo"),
        org.junit.jupiter.params.provider.Arguments.of("CIDToGIDMap"),
        org.junit.jupiter.params.provider.Arguments.of("CapHeight"),
        org.junit.jupiter.params.provider.Arguments.of("Catalog"),
        org.junit.jupiter.params.provider.Arguments.of("ColorSpace"),
        org.junit.jupiter.params.provider.Arguments.of("Colors"),
        org.junit.jupiter.params.provider.Arguments.of("Columns"),
        org.junit.jupiter.params.provider.Arguments.of("Contents"),
        org.junit.jupiter.params.provider.Arguments.of("Count"),
        org.junit.jupiter.params.provider.Arguments.of("CreationDate"),
        org.junit.jupiter.params.provider.Arguments.of("Creator"),
        org.junit.jupiter.params.provider.Arguments.of("CropBox"),
        org.junit.jupiter.params.provider.Arguments.of("D"),
        org.junit.jupiter.params.provider.Arguments.of("DCTDecode"),
        org.junit.jupiter.params.provider.Arguments.of("DR"),
        org.junit.jupiter.params.provider.Arguments.of("DW"),
        org.junit.jupiter.params.provider.Arguments.of("DecodeParms"),
        org.junit.jupiter.params.provider.Arguments.of("Default"),
        org.junit.jupiter.params.provider.Arguments.of("DescendantFonts"),
        org.junit.jupiter.params.provider.Arguments.of("Descent"),
        org.junit.jupiter.params.provider.Arguments.of("DeviceRGB"),
        org.junit.jupiter.params.provider.Arguments.of("EF"),
        org.junit.jupiter.params.provider.Arguments.of("EmbeddedFile"),
        org.junit.jupiter.params.provider.Arguments.of("EmbeddedFiles"),
        org.junit.jupiter.params.provider.Arguments.of("Encoding"),
        org.junit.jupiter.params.provider.Arguments.of("Encrypt"),
        org.junit.jupiter.params.provider.Arguments.of("ExtGState"),
        org.junit.jupiter.params.provider.Arguments.of("F"),
        org.junit.jupiter.params.provider.Arguments.of("F0"),
        org.junit.jupiter.params.provider.Arguments.of("F1"),
        org.junit.jupiter.params.provider.Arguments.of("F13"),
        org.junit.jupiter.params.provider.Arguments.of("F14"),
        org.junit.jupiter.params.provider.Arguments.of("F2"),
        org.junit.jupiter.params.provider.Arguments.of("F70"),
        org.junit.jupiter.params.provider.Arguments.of("F87"),
        org.junit.jupiter.params.provider.Arguments.of("Fields"),
        org.junit.jupiter.params.provider.Arguments.of("Filespec"),
        org.junit.jupiter.params.provider.Arguments.of("Filter"),
        org.junit.jupiter.params.provider.Arguments.of("First"),
        org.junit.jupiter.params.provider.Arguments.of("FirstChar"),
        org.junit.jupiter.params.provider.Arguments.of("Flags"),
        org.junit.jupiter.params.provider.Arguments.of("FlateDecode"),
        org.junit.jupiter.params.provider.Arguments.of("Font"),
        org.junit.jupiter.params.provider.Arguments.of("FontBBox"),
        org.junit.jupiter.params.provider.Arguments.of("FontDescriptor"),
        org.junit.jupiter.params.provider.Arguments.of("FontFamily"),
        org.junit.jupiter.params.provider.Arguments.of("FontFile2"),
        org.junit.jupiter.params.provider.Arguments.of("FontName"),
        org.junit.jupiter.params.provider.Arguments.of("FontStretch"),
        org.junit.jupiter.params.provider.Arguments.of("FontWeight"),
        org.junit.jupiter.params.provider.Arguments.of("GS1"),
        org.junit.jupiter.params.provider.Arguments.of("GoTo"),
        org.junit.jupiter.params.provider.Arguments.of("Height"),
        org.junit.jupiter.params.provider.Arguments.of("Helv"),
        org.junit.jupiter.params.provider.Arguments.of("Helvetica"),
        org.junit.jupiter.params.provider.Arguments.of("ID"),
        org.junit.jupiter.params.provider.Arguments.of("Identity"),
        org.junit.jupiter.params.provider.Arguments.of("Identity-H"),
        org.junit.jupiter.params.provider.Arguments.of("Im1"),
        org.junit.jupiter.params.provider.Arguments.of("Im2"),
        org.junit.jupiter.params.provider.Arguments.of("Im3"),
        org.junit.jupiter.params.provider.Arguments.of("Im4"),
        org.junit.jupiter.params.provider.Arguments.of("Im5"),
        org.junit.jupiter.params.provider.Arguments.of("Im6"),
        org.junit.jupiter.params.provider.Arguments.of("Im7"),
        org.junit.jupiter.params.provider.Arguments.of("Im83"),
        org.junit.jupiter.params.provider.Arguments.of("Im9"),
        org.junit.jupiter.params.provider.Arguments.of("Image"),
        org.junit.jupiter.params.provider.Arguments.of("ImageB"),
        org.junit.jupiter.params.provider.Arguments.of("ImageC"),
        org.junit.jupiter.params.provider.Arguments.of("ImageI"),
        org.junit.jupiter.params.provider.Arguments.of("Index"),
        org.junit.jupiter.params.provider.Arguments.of("Info"),
        org.junit.jupiter.params.provider.Arguments.of("ItalicAngle"),
        org.junit.jupiter.params.provider.Arguments.of("Keywords"),
        org.junit.jupiter.params.provider.Arguments.of("Kids"),
        org.junit.jupiter.params.provider.Arguments.of("Last"),
        org.junit.jupiter.params.provider.Arguments.of("LastChar"),
        org.junit.jupiter.params.provider.Arguments.of("Length"),
        org.junit.jupiter.params.provider.Arguments.of("Length1"),
        org.junit.jupiter.params.provider.Arguments.of("Limits"),
        org.junit.jupiter.params.provider.Arguments.of("MacRomanEncoding"),
        org.junit.jupiter.params.provider.Arguments.of("MaxWidth"),
        org.junit.jupiter.params.provider.Arguments.of("MediaBox"),
        org.junit.jupiter.params.provider.Arguments.of("Metadata"),
        org.junit.jupiter.params.provider.Arguments.of("MissingWidth"),
        org.junit.jupiter.params.provider.Arguments.of("ModDate"),
        org.junit.jupiter.params.provider.Arguments.of("N"),
        org.junit.jupiter.params.provider.Arguments.of("Name"),
        org.junit.jupiter.params.provider.Arguments.of("Names"),
        org.junit.jupiter.params.provider.Arguments.of("Next"),
        org.junit.jupiter.params.provider.Arguments.of("Normal"),
        org.junit.jupiter.params.provider.Arguments.of("Nums"),
        org.junit.jupiter.params.provider.Arguments.of("O"),
        org.junit.jupiter.params.provider.Arguments.of("OE"),
        org.junit.jupiter.params.provider.Arguments.of("OMXUQX+Century"),
        org.junit.jupiter.params.provider.Arguments.of("OMXUQX+MS-Mincho"),
        org.junit.jupiter.params.provider.Arguments.of("OMXUQX+MS-PGothic"),
        org.junit.jupiter.params.provider.Arguments.of("OP"),
        org.junit.jupiter.params.provider.Arguments.of("OPM"),
        org.junit.jupiter.params.provider.Arguments.of("ObjStm"),
        org.junit.jupiter.params.provider.Arguments.of("OpenAction"),
        org.junit.jupiter.params.provider.Arguments.of("Ordering"),
        org.junit.jupiter.params.provider.Arguments.of("Outlines"),
        org.junit.jupiter.params.provider.Arguments.of("P"),
        org.junit.jupiter.params.provider.Arguments.of("PDF"),
        org.junit.jupiter.params.provider.Arguments.of("Page"),
        org.junit.jupiter.params.provider.Arguments.of("PageLabels"),
        org.junit.jupiter.params.provider.Arguments.of("PageMode"),
        org.junit.jupiter.params.provider.Arguments.of("Pages"),
        org.junit.jupiter.params.provider.Arguments.of("Parent"),
        org.junit.jupiter.params.provider.Arguments.of("Perms"),
        org.junit.jupiter.params.provider.Arguments.of("Predictor"),
        org.junit.jupiter.params.provider.Arguments.of("Prev"),
        org.junit.jupiter.params.provider.Arguments.of("ProcSet"),
        org.junit.jupiter.params.provider.Arguments.of("Producer"),
        org.junit.jupiter.params.provider.Arguments.of("R"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton01"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton02"),
        org.junit.jupiter.params.provider.Arguments.of("Registry"),
        org.junit.jupiter.params.provider.Arguments.of("Resources"),
        org.junit.jupiter.params.provider.Arguments.of("Root"),
        org.junit.jupiter.params.provider.Arguments.of("Rotate"),
        org.junit.jupiter.params.provider.Arguments.of("S"),
        org.junit.jupiter.params.provider.Arguments.of("SA"),
        org.junit.jupiter.params.provider.Arguments.of("SM"),
        org.junit.jupiter.params.provider.Arguments.of("Size"),
        org.junit.jupiter.params.provider.Arguments.of("Standard"),
        org.junit.jupiter.params.provider.Arguments.of("StdCF"),
        org.junit.jupiter.params.provider.Arguments.of("StemV"),
        org.junit.jupiter.params.provider.Arguments.of("StmF"),
        org.junit.jupiter.params.provider.Arguments.of("StoredCompanionFileList"),
        org.junit.jupiter.params.provider.Arguments.of("StrF"),
        org.junit.jupiter.params.provider.Arguments.of("Subject"),
        org.junit.jupiter.params.provider.Arguments.of("Subtype"),
        org.junit.jupiter.params.provider.Arguments.of("Supplement"),
        org.junit.jupiter.params.provider.Arguments.of("TT10"),
        org.junit.jupiter.params.provider.Arguments.of("TT2"),
        org.junit.jupiter.params.provider.Arguments.of("TT4"),
        org.junit.jupiter.params.provider.Arguments.of("TT6"),
        org.junit.jupiter.params.provider.Arguments.of("TT8"),
        org.junit.jupiter.params.provider.Arguments.of("Text"),
        org.junit.jupiter.params.provider.Arguments.of("Title"),
        org.junit.jupiter.params.provider.Arguments.of("ToUnicode"),
        org.junit.jupiter.params.provider.Arguments.of("TrueType"),
        org.junit.jupiter.params.provider.Arguments.of("Type"),
        org.junit.jupiter.params.provider.Arguments.of("Type0"),
        org.junit.jupiter.params.provider.Arguments.of("Type1"),
        org.junit.jupiter.params.provider.Arguments.of("U"),
        org.junit.jupiter.params.provider.Arguments.of("UCR2"),
        org.junit.jupiter.params.provider.Arguments.of("UE"),
        org.junit.jupiter.params.provider.Arguments.of("UseOutlines"),
        org.junit.jupiter.params.provider.Arguments.of("V"),
        org.junit.jupiter.params.provider.Arguments.of("W"),
        org.junit.jupiter.params.provider.Arguments.of("Width"),
        org.junit.jupiter.params.provider.Arguments.of("Widths"),
        org.junit.jupiter.params.provider.Arguments.of("WinAnsiEncoding"),
        org.junit.jupiter.params.provider.Arguments.of("XHeight"),
        org.junit.jupiter.params.provider.Arguments.of("XML"),
        org.junit.jupiter.params.provider.Arguments.of("XObject"),
        org.junit.jupiter.params.provider.Arguments.of("XRef"),
        org.junit.jupiter.params.provider.Arguments.of("XYZ"),
        org.junit.jupiter.params.provider.Arguments.of("Yes"),
        org.junit.jupiter.params.provider.Arguments.of("ZLJMVU+Arial"),
        org.junit.jupiter.params.provider.Arguments.of("ZLJMVU+Arial,Bold"),
        org.junit.jupiter.params.provider.Arguments.of("ZLJMVU+TimesNewRoman"),
        org.junit.jupiter.params.provider.Arguments.of("ZaDb"),
        org.junit.jupiter.params.provider.Arguments.of("ca"),
        org.junit.jupiter.params.provider.Arguments.of("op"),
        org.junit.jupiter.params.provider.Arguments.of("中国你好!")
        );
    }
}