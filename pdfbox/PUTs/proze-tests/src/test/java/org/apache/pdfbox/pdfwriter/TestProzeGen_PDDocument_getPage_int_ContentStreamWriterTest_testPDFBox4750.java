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
package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDDocument_getPage_int_ContentStreamWriterTest_testPDFBox4750 {
    private final java.io.File testDirIn = new java.io.File("target/test-output/contentstream/in");

    private final java.io.File testDirOut = new java.io.File("target/test-output/contentstream/out");

    public TestProzeGen_PDDocument_getPage_int_ContentStreamWriterTest_testPDFBox4750() {
        testDirIn.mkdirs();
        testDirOut.mkdirs();
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
    }

    /**
     * Test parse content stream, write back tokens and compare rendering.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4750(int param0) throws java.io.IOException {
        String filename = "PDFBOX-4750.pdf";
        java.io.File file = new java.io.File("target/pdfs", filename);
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
        org.apache.pdfbox.rendering.PDFRenderer r = new org.apache.pdfbox.rendering.PDFRenderer(doc);
        for (int i = 0; i < doc.getNumberOfPages(); ++i) {
            java.awt.image.BufferedImage bim1 = r.renderImageWithDPI(i, 96);
            javax.imageio.ImageIO.write(bim1, "png", new java.io.File(testDirIn, ((filename + "-") + (i + 1)) + ".png"));
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.common.PDStream newContent = new org.apache.pdfbox.pdmodel.common.PDStream(doc);
            org.apache.pdfbox.pdfparser.PDFStreamParser parser = new org.apache.pdfbox.pdfparser.PDFStreamParser(page);
            parser.parse();
            java.io.OutputStream os = newContent.createOutputStream(org.apache.pdfbox.cos.COSName.FLATE_DECODE);
            ContentStreamWriter tokenWriter = new ContentStreamWriter(os);
            tokenWriter.writeTokens(parser.getTokens());
            os.close();
            page.setContents(newContent);
        }
        doc.save(new java.io.File(testDirIn, filename));
        doc.close();
        org.apache.pdfbox.rendering.TestPDFToImage testPDFToImage = new org.apache.pdfbox.rendering.TestPDFToImage(org.apache.pdfbox.rendering.TestPDFToImage.class.getName());
        if (!testPDFToImage.doTestFile(new java.io.File(testDirIn, filename), testDirIn.getAbsolutePath(), testDirOut.getAbsolutePath())) {
            fail("Rendering failed or is not identical, see in " + testDirOut);
        }
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