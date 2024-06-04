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
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author adam
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFox5048 {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        TestProzeGen_PDDocument_getPage_int_PDFontTest_testPDFox5048.OUT_DIR.mkdirs();
    }

    /**
     * Test using broken Type1C font.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFox5048(int param0) throws IOException {
        java.io.InputStream is = new java.net.URL("https://issues.apache.org/jira/secure/attachment/13017227/stringwidth.pdf").openStream();
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(is);
        org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
        PDFont font = page.getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F70"));
        assertTrue(font.isDamaged());
        assertEquals(0.0F, font.getHeight(0), 0);
        assertEquals(0.0F, font.getStringWidth("Pa"), 0);
        doc.close();
        is.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFox5048_1(int param0) throws IOException {
        java.io.InputStream is = new java.net.URL("https://issues.apache.org/jira/secure/attachment/13017227/stringwidth.pdf").openStream();
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(is);
        org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
        PDFont font = page.getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F70"));
        assertTrue(font.isDamaged());
        // assertEquals(0.0F, font.getHeight(0), 0);
        // assertEquals(0.0F, font.getStringWidth("Pa"), 0);
        doc.close();
        is.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFox5048_2(int param0) throws IOException {
        java.io.InputStream is = new java.net.URL("https://issues.apache.org/jira/secure/attachment/13017227/stringwidth.pdf").openStream();
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(is);
        org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
        PDFont font = page.getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F70"));
        // assertTrue(font.isDamaged());
        assertEquals(0.0F, font.getHeight(0), 0);
        // assertEquals(0.0F, font.getStringWidth("Pa"), 0);
        doc.close();
        is.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFox5048_3(int param0) throws IOException {
        java.io.InputStream is = new java.net.URL("https://issues.apache.org/jira/secure/attachment/13017227/stringwidth.pdf").openStream();
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(is);
        org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
        PDFont font = page.getResources().getFont(org.apache.pdfbox.cos.COSName.getPDFName("F70"));
        // assertTrue(font.isDamaged());
        // assertEquals(0.0F, font.getHeight(0), 0);
        assertEquals(0.0F, font.getStringWidth("Pa"), 0);
        doc.close();
        is.close();
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