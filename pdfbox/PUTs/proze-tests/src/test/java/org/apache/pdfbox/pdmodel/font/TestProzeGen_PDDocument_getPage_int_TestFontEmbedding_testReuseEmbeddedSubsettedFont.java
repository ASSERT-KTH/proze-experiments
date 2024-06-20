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

/**
 * Tests font embedding.
 *
 * @author John Hewson
 * @author Tilman Hausherr
 */
// public class TestFontEmbedding extends TestCase
public class TestProzeGen_PDDocument_getPage_int_TestFontEmbedding_testReuseEmbeddedSubsettedFont {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        TestProzeGen_PDDocument_getPage_int_TestFontEmbedding_testReuseEmbeddedSubsettedFont.OUT_DIR.mkdirs();
    }

    /**
     * Test that an embedded and subsetted font can be reused.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testReuseEmbeddedSubsettedFont(int param0) throws IOException {
        String text1 = "The quick brown fox";
        String text2 = "xof nworb kciuq ehT";
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        java.io.InputStream input = PDFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
        PDType0Font font = PDType0Font.load(document, input);
        org.apache.pdfbox.pdmodel.PDPageContentStream stream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
        stream.beginText();
        stream.setFont(font, 20);
        stream.newLineAtOffset(50, 600);
        stream.showText(text1);
        stream.endText();
        stream.close();
        document.save(baos);
        document.close();
        // Append, while reusing the font subset
        document = org.apache.pdfbox.pdmodel.PDDocument.load(baos.toByteArray());
        page = document.getPage(param0);
        font = ((PDType0Font) (page.getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F1"))));
        stream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.APPEND, true);
        stream.beginText();
        stream.setFont(font, 20);
        stream.newLineAtOffset(250, 600);
        stream.showText(text2);
        stream.endText();
        stream.close();
        baos.reset();
        document.save(baos);
        document.close();
        // Test that both texts are there
        document = org.apache.pdfbox.pdmodel.PDDocument.load(baos.toByteArray());
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String extractedText = stripper.getText(document);
        assertEquals((text1 + " ") + text2, extractedText.trim());
        document.close();
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