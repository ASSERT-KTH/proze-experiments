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
public class TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir.mkdirs();
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

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGsWithSameNameCanHaveDifferentVisibility(String param0) throws Exception {
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
            // Create visible OCG
            PDOptionalContentGroup visible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(visible);
            assertTrue(ocprops.isGroupEnabled(visible));
            // Create invisible OCG
            PDOptionalContentGroup invisible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(invisible);
            assertFalse(ocprops.setGroupEnabled(invisible, false));
            assertFalse(ocprops.isGroupEnabled(invisible));
            // Check that visible layer is still visible
            assertTrue(ocprops.isGroupEnabled(visible));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, visible);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see this text, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, invisible);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir, "ocg-generation-same-name.pdf");
            doc.save(param0);
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGsWithSameNameCanHaveDifferentVisibility_1(String param0) throws Exception {
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
            // Create visible OCG
            PDOptionalContentGroup visible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(visible);
            assertTrue(ocprops.isGroupEnabled(visible));
            // Create invisible OCG
            PDOptionalContentGroup invisible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(invisible);
//            assertFalse(ocprops.setGroupEnabled(invisible, false));
//            assertFalse(ocprops.isGroupEnabled(invisible));
            // Check that visible layer is still visible
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, visible);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see this text, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, invisible);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir, "ocg-generation-same-name.pdf");
            doc.save(param0);
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGsWithSameNameCanHaveDifferentVisibility_2(String param0) throws Exception {
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
            // Create visible OCG
            PDOptionalContentGroup visible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(visible);
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Create invisible OCG
            PDOptionalContentGroup invisible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(invisible);
            assertFalse(ocprops.setGroupEnabled(invisible, false));
//            assertFalse(ocprops.isGroupEnabled(invisible));
            // Check that visible layer is still visible
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, visible);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see this text, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, invisible);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir, "ocg-generation-same-name.pdf");
            doc.save(param0);
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGsWithSameNameCanHaveDifferentVisibility_3(String param0) throws Exception {
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
            // Create visible OCG
            PDOptionalContentGroup visible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(visible);
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Create invisible OCG
            PDOptionalContentGroup invisible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(invisible);
//            assertFalse(ocprops.setGroupEnabled(invisible, false));
            assertFalse(ocprops.isGroupEnabled(invisible));
            // Check that visible layer is still visible
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, visible);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see this text, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, invisible);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir, "ocg-generation-same-name.pdf");
            doc.save(param0);
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOCGsWithSameNameCanHaveDifferentVisibility_4(String param0) throws Exception {
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
            // Create visible OCG
            PDOptionalContentGroup visible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(visible);
//            assertTrue(ocprops.isGroupEnabled(visible));
            // Create invisible OCG
            PDOptionalContentGroup invisible = new PDOptionalContentGroup("layer");
            ocprops.addGroup(invisible);
//            assertFalse(ocprops.setGroupEnabled(invisible, false));
//            assertFalse(ocprops.isGroupEnabled(invisible));
            // Check that visible layer is still visible
            assertTrue(ocprops.isGroupEnabled(visible));
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, visible);
            contentStream.beginText();
            contentStream.setFont(font, 14);
            contentStream.newLineAtOffset(80, 700);
            contentStream.showText("PDF 1.5: Optional Content Groups");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 680);
            contentStream.showText("You should see this text, but no red text line.");
            contentStream.endText();
            contentStream.endMarkedContent();
            // Paint disabled layer
            contentStream.beginMarkedContent(org.apache.pdfbox.cos.COSName.OC, invisible);
            contentStream.setNonStrokingColor(java.awt.Color.RED);
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(80, 500);
            contentStream.showText("This is from a disabled layer. If you see this, that's NOT good!");
            contentStream.endText();
            contentStream.endMarkedContent();
            contentStream.close();
            java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestOptionalContentGroups_testOCGsWithSameNameCanHaveDifferentVisibility.testResultsDir, "ocg-generation-same-name.pdf");
            doc.save(param0);
        } finally {
            doc.close();
        }
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