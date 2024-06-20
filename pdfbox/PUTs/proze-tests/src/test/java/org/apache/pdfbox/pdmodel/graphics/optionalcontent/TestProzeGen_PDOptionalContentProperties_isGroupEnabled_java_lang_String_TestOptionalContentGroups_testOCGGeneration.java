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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests optional content group functionality (also called layers).
 */
// public class TestOptionalContentGroups extends TestCase
public class TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir.mkdirs();
    }

    /**
     * Tests OCG generation.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration(String param0) throws Exception {
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
            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
            assertFalse(ocprops.setGroupEnabled("enabled", true));
            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
            assertFalse(ocprops.setGroupEnabled("disabled", true));
            assertTrue(ocprops.isGroupEnabled(param0));
            assertTrue(ocprops.setGroupEnabled("disabled", false));
            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_1(String param0) throws Exception {
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
            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_2(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_3(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_4(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_5(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_6(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            assertTrue(ocprops.setGroupEnabled("disabled", false));
//            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGGeneration_7(String param0) throws Exception {
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
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
//            assertFalse(ocprops.setGroupEnabled("enabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
            // Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
//            assertFalse(ocprops.setGroupEnabled("disabled", true));
//            assertTrue(ocprops.isGroupEnabled(param0));
//            assertTrue(ocprops.setGroupEnabled("disabled", false));
            assertFalse(ocprops.isGroupEnabled(param0));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint enabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText("This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, disabled);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDOptionalContentProperties_isGroupEnabled_java_lang_String_TestOptionalContentGroups_testOCGGeneration.testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
    }


    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("alternative"),
        org.junit.jupiter.params.provider.Arguments.of("background"),
        org.junit.jupiter.params.provider.Arguments.of("disabled"),
        org.junit.jupiter.params.provider.Arguments.of("enabled"),
        org.junit.jupiter.params.provider.Arguments.of("science")
        );
    }
}