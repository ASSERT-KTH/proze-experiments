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
package org.apache.pdfbox.pdmodel.graphics.optionalcontent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests optional content group functionality (also called layers).
 */
// public class TestOptionalContentGroups extends TestCase
public class TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir.mkdirs();
    }

    /**
     * Convert a list of TextPosition objects to a string.
     *
     * @param contents
     * 		list of TextPosition objects.
     * @return  */
    private String textPositionListToString(java.util.List<Object> contents) {
        StringBuilder sb = new StringBuilder();
        for (Object o : contents) {
            org.apache.pdfbox.text.TextPosition tp = ((org.apache.pdfbox.text.TextPosition) (o));
            sb.append(tp.getUnicode());
        }
        return sb.toString();
    }

    /**
     * PDFBOX-4496: setGroupEnabled(String, boolean) must catch all OCGs of a name even when several
     * names are identical.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
            assertFalse(ocprops.setGroupEnabled("science", true));
            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
            assertFalse(ocprops.setGroupEnabled("alternative", false));
            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_1(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("science", true));
//            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
//            assertFalse(ocprops.setGroupEnabled("alternative", false));
//            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        // org.junit.Assert.assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_2(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
//            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
            assertFalse(ocprops.setGroupEnabled("science", true));
//            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
//            assertFalse(ocprops.setGroupEnabled("alternative", false));
//            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        // org.junit.Assert.assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_3(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
//            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("science", true));
            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
//            assertFalse(ocprops.setGroupEnabled("alternative", false));
//            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        // org.junit.Assert.assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_4(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
//            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("science", true));
//            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
            assertFalse(ocprops.setGroupEnabled("alternative", false));
//            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        // org.junit.Assert.assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_5(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
//            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("science", true));
//            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
//            assertFalse(ocprops.setGroupEnabled("alternative", false));
            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        // org.junit.Assert.assertArrayEquals(expectedData.getData(), actualData.getData());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGenerationSameNameCanHaveSameVisibilityOff_6(String param0) throws IOException {
        java.awt.image.BufferedImage expectedImage;
        java.awt.image.BufferedImage actualImage;
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            // Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            // ocprops.setBaseState(BaseState.ON); //ON=default
            // Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
//            assertTrue(ocprops.isGroupEnabled("background"));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("science");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("science", true));
//            assertTrue(ocprops.isGroupEnabled("science"));
            // Create OCG for disabled1
            PDOptionalContentGroup disabled1 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled1);
            // Create OCG for disabled2 with same name as disabled1
            PDOptionalContentGroup disabled2 = new PDOptionalContentGroup("alternative");
            ocprops.addGroup(disabled2);
//            assertFalse(ocprops.setGroupEnabled("alternative", false));
//            assertFalse(ocprops.isGroupEnabled("alternative"));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            contentStream.endMarkedContent();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("The earth is a sphere");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer1
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled1);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer2
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled2);
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            doc.getDocumentCatalog().setPageMode(org.apache.pdfbox.pdmodel.PageMode.USE_OPTIONAL_CONTENT);
            java.io.File targetFile = new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf");
            doc.save(param0);
            doc.close();
            // render PDF with science disabled and alternatives with same name enabled
            doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off.pdf"));
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("background", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("science", false);
            doc.getDocumentCatalog().getOCProperties().setGroupEnabled("alternative", true);
            actualImage = new org.apache.pdfbox.rendering.PDFRenderer(doc).renderImage(0, 2);
            javax.imageio.ImageIO.write(actualImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-actual.png"));
        } finally {
            doc.close();
        };
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        try {
            // Create new page
            org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
            doc2.addPage(page);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            if (resources == null) {
                resources = new org.apache.pdfbox.pdmodel.PDResources();
                page.setResources(resources);
            }
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc2, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("Alternative 1: The earth is a flat circle");
            contentStream.endText();
            contentStream.setNonStrokingColor(java.awt.Color.BLUE);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 450);
            contentStream.showText("Alternative 2: The earth is a flat parallelogram");
            contentStream.endText();
            contentStream.close();
            expectedImage = new org.apache.pdfbox.rendering.PDFRenderer(doc2).renderImage(0, 2);
            javax.imageio.ImageIO.write(expectedImage, "png", new java.io.File(org.apache.pdfbox.pdmodel.graphics.optionalcontent.TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGGenerationSameNameCanHaveSameVisibilityOff.testResultsDir, "ocg-generation-same-name-off-expected.png"));
        } finally {
            doc2.close();
        }
        java.awt.image.DataBufferInt expectedData = ((java.awt.image.DataBufferInt) (expectedImage.getRaster().getDataBuffer()));
        java.awt.image.DataBufferInt actualData = ((java.awt.image.DataBufferInt) (actualImage.getRaster().getDataBuffer()));
        assertArrayEquals(expectedData.getData(), actualData.getData());
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