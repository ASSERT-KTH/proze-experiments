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

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests optional content group functionality (also called layers).
 */
// public class TestOptionalContentGroups extends TestCase
public class TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir.mkdirs();
    }

    public void testOCGGeneration() throws Exception
    {
        PDDocument doc = new PDDocument();
        try
        {
            //Create new page
            PDPage page = new PDPage();
            doc.addPage(page);
            PDResources resources = page.getResources();
            if( resources == null )
            {
                resources = new PDResources();
                page.setResources( resources );
            }

            //Prepare OCG functionality
            PDOptionalContentProperties ocprops = new PDOptionalContentProperties();
            doc.getDocumentCatalog().setOCProperties(ocprops);
            //ocprops.setBaseState(BaseState.ON); //ON=default

            //Create OCG for background
            PDOptionalContentGroup background = new PDOptionalContentGroup("background");
            ocprops.addGroup(background);
            assertTrue(ocprops.isGroupEnabled("background"));

            //Create OCG for enabled
            PDOptionalContentGroup enabled = new PDOptionalContentGroup("enabled");
            ocprops.addGroup(enabled);
            assertFalse(ocprops.setGroupEnabled("enabled", true));
            assertTrue(ocprops.isGroupEnabled("enabled"));

            //Create OCG for disabled
            PDOptionalContentGroup disabled = new PDOptionalContentGroup("disabled");
            ocprops.addGroup(disabled);
            assertFalse(ocprops.setGroupEnabled("disabled", true));
            assertTrue(ocprops.isGroupEnabled("disabled"));
            assertTrue(ocprops.setGroupEnabled("disabled", false));
            assertFalse(ocprops.isGroupEnabled("disabled"));

            //Setup page content stream and paint background/title
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.OVERWRITE, false);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(COSName.OC, background);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see a green textline, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();

            //Paint enabled layer
            contentStream.beginMarkedContent(COSName.OC, enabled);
            contentStream.setNonStrokingColor(java.awt.Color.GREEN);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 600);
            contentStream.showText(
                    "This is from an enabled layer. If you see this, that's good.");
            contentStream.endText();
            contentStream.endMarkedContent();

            //Paint disabled layer
            contentStream.beginMarkedContent(COSName.OC, disabled);
            contentStream.setNonStrokingColor(Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText(
                    "This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();

            contentStream.close();

            File targetFile = new File(testResultsDir, "ocg-generation.pdf");
            doc.save(targetFile.getAbsolutePath());
        }
        finally
        {
            doc.close();
        }
    }
    /**
     * Tests OCG functions on a loaded PDF.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
            assertNotNull(ocg);
            assertEquals("background", ocg.getName());
            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
            assertEquals(3, names.size());
            assertTrue(names.contains("background"));
            assertTrue(ocgs.isGroupEnabled("background"));
            assertTrue(ocgs.isGroupEnabled("enabled"));
            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
            assertEquals(ocg.getName(), background.getName());
            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
            assertTrue(nameSet.contains("background"));
            assertTrue(nameSet.contains("enabled"));
            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
            assertEquals("oc1", markedContents.get(0).getTag());
            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
            assertEquals("oc2", markedContents.get(1).getTag());
            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
            assertEquals("oc3", markedContents.get(2).getTag());
            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_1(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_2(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_3(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_4(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_5(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_6(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_7(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_8(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_9(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_10(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_11(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_12(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_13(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_14(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_15(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_16(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_17(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_18(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_19(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_20(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_21(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_22(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
            assertEquals("oc3", markedContents.get(2).getTag());
//            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGConsumption_23(int param0) throws Exception {
        java.io.File pdfFile = new java.io.File(TestProzeGen_PDDocument_getPage_int_TestOptionalContentGroups_testOCGConsumption.testResultsDir, "ocg-generation.pdf");
        if (!pdfFile.exists()) {
            testOCGGeneration();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(pdfFile);
        try {
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(param0);
            org.apache.pdfbox.pdmodel.PDResources resources = page.getResources();
            org.apache.pdfbox.cos.COSName mc0 = org.apache.pdfbox.cos.COSName.getPDFName("oc1");
            PDOptionalContentGroup ocg = ((PDOptionalContentGroup) (resources.getProperties(mc0)));
//            assertNotNull(ocg);
//            assertEquals("background", ocg.getName());
//            assertNull(resources.getProperties(org.apache.pdfbox.cos.COSName.getPDFName("inexistent")));
            PDOptionalContentProperties ocgs = catalog.getOCProperties();
//            assertEquals(PDOptionalContentProperties.BaseState.ON, ocgs.getBaseState());
            java.util.Set<String> names = new java.util.HashSet<String>(java.util.Arrays.asList(ocgs.getGroupNames()));
//            assertEquals(3, names.size());
//            assertTrue(names.contains("background"));
//            assertTrue(ocgs.isGroupEnabled("background"));
//            assertTrue(ocgs.isGroupEnabled("enabled"));
//            assertFalse(ocgs.isGroupEnabled("disabled"));
            ocgs.setGroupEnabled("background", false);
//            assertFalse(ocgs.isGroupEnabled("background"));
            PDOptionalContentGroup background = ocgs.getGroup("background");
//            assertEquals(ocg.getName(), background.getName());
//            assertNull(ocgs.getGroup("inexistent"));
            java.util.Collection<PDOptionalContentGroup> coll = ocgs.getOptionalContentGroups();
//            assertEquals(3, coll.size());
            java.util.Set<String> nameSet = new java.util.HashSet<String>();
            for (PDOptionalContentGroup ocg2 : coll) {
                nameSet.add(ocg2.getName());
            }
//            assertTrue(nameSet.contains("background"));
//            assertTrue(nameSet.contains("enabled"));
//            assertTrue(nameSet.contains("disabled"));
            org.apache.pdfbox.text.PDFMarkedContentExtractor extractor = new org.apache.pdfbox.text.PDFMarkedContentExtractor();
            extractor.processPage(page);
            java.util.List<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> markedContents = extractor.getMarkedContents();
//            assertEquals("oc1", markedContents.get(0).getTag());
//            assertEquals("PDF 1.5: Optional Content Groups" + "You should see a green textline, but no red text line.", textPositionListToString(markedContents.get(0).getContents()));
//            assertEquals("oc2", markedContents.get(1).getTag());
//            assertEquals("This is from an enabled layer. If you see this, that's good.", textPositionListToString(markedContents.get(1).getContents()));
//            assertEquals("oc3", markedContents.get(2).getTag());
            assertEquals("This is from a disabled layer. If you see this, that's NOT good!", textPositionListToString(markedContents.get(2).getContents()));
        } finally {
            doc.close();
        }
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