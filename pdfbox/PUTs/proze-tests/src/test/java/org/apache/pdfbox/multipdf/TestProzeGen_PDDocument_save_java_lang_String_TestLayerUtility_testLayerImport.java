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
package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests the {@link LayerUtility} class.
 */
// public class TestLayerUtility extends TestCase
public class TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    /**
     * {@inheritDoc }
     */
    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir.mkdirs();
    }

    /**
     * Tests layer import.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLayerImport(String param0) throws Exception {
        java.io.File mainPDF = createMainPDF();
        java.io.File overlay1 = createOverlay1();
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-with-form-overlay.pdf");
        org.apache.pdfbox.pdmodel.PDDocument targetDoc = org.apache.pdfbox.pdmodel.PDDocument.load(mainPDF);
        org.apache.pdfbox.pdmodel.PDDocument overlay1Doc = org.apache.pdfbox.pdmodel.PDDocument.load(overlay1);
        try {
            LayerUtility layerUtil = new LayerUtility(targetDoc);
            org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);
            org.apache.pdfbox.pdmodel.PDPage targetPage = targetDoc.getPage(0);
            layerUtil.wrapInSaveRestore(targetPage);
            java.awt.geom.AffineTransform at = new java.awt.geom.AffineTransform();
            layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");
            targetDoc.save(param0);
        } finally {
            targetDoc.close();
            overlay1Doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(targetFile);
        try {
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            // OCGs require PDF 1.5 or later
            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(0);
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup ocg = ((org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup) (page.getResources().getProperties(org.apache.pdfbox.cos.COSName.getPDFName("oc1"))));
            assertNotNull(ocg);
            assertEquals("overlay", ocg.getName());
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties ocgs = catalog.getOCProperties();
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup overlay = ocgs.getGroup("overlay");
            assertEquals(ocg.getName(), overlay.getName());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLayerImport_1(String param0) throws Exception {
        java.io.File mainPDF = createMainPDF();
        java.io.File overlay1 = createOverlay1();
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-with-form-overlay.pdf");
        org.apache.pdfbox.pdmodel.PDDocument targetDoc = org.apache.pdfbox.pdmodel.PDDocument.load(mainPDF);
        org.apache.pdfbox.pdmodel.PDDocument overlay1Doc = org.apache.pdfbox.pdmodel.PDDocument.load(overlay1);
        try {
            LayerUtility layerUtil = new LayerUtility(targetDoc);
            org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);
            org.apache.pdfbox.pdmodel.PDPage targetPage = targetDoc.getPage(0);
            layerUtil.wrapInSaveRestore(targetPage);
            java.awt.geom.AffineTransform at = new java.awt.geom.AffineTransform();
            layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");
            targetDoc.save(param0);
        } finally {
            targetDoc.close();
            overlay1Doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(targetFile);
        try {
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            // OCGs require PDF 1.5 or later
            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(0);
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup ocg = ((org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup) (page.getResources().getProperties(org.apache.pdfbox.cos.COSName.getPDFName("oc1"))));
//            assertNotNull(ocg);
//            assertEquals("overlay", ocg.getName());
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties ocgs = catalog.getOCProperties();
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup overlay = ocgs.getGroup("overlay");
//            assertEquals(ocg.getName(), overlay.getName());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLayerImport_2(String param0) throws Exception {
        java.io.File mainPDF = createMainPDF();
        java.io.File overlay1 = createOverlay1();
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-with-form-overlay.pdf");
        org.apache.pdfbox.pdmodel.PDDocument targetDoc = org.apache.pdfbox.pdmodel.PDDocument.load(mainPDF);
        org.apache.pdfbox.pdmodel.PDDocument overlay1Doc = org.apache.pdfbox.pdmodel.PDDocument.load(overlay1);
        try {
            LayerUtility layerUtil = new LayerUtility(targetDoc);
            org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);
            org.apache.pdfbox.pdmodel.PDPage targetPage = targetDoc.getPage(0);
            layerUtil.wrapInSaveRestore(targetPage);
            java.awt.geom.AffineTransform at = new java.awt.geom.AffineTransform();
            layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");
            targetDoc.save(param0);
        } finally {
            targetDoc.close();
            overlay1Doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(targetFile);
        try {
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            // OCGs require PDF 1.5 or later
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(0);
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup ocg = ((org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup) (page.getResources().getProperties(org.apache.pdfbox.cos.COSName.getPDFName("oc1"))));
            assertNotNull(ocg);
//            assertEquals("overlay", ocg.getName());
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties ocgs = catalog.getOCProperties();
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup overlay = ocgs.getGroup("overlay");
//            assertEquals(ocg.getName(), overlay.getName());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLayerImport_3(String param0) throws Exception {
        java.io.File mainPDF = createMainPDF();
        java.io.File overlay1 = createOverlay1();
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-with-form-overlay.pdf");
        org.apache.pdfbox.pdmodel.PDDocument targetDoc = org.apache.pdfbox.pdmodel.PDDocument.load(mainPDF);
        org.apache.pdfbox.pdmodel.PDDocument overlay1Doc = org.apache.pdfbox.pdmodel.PDDocument.load(overlay1);
        try {
            LayerUtility layerUtil = new LayerUtility(targetDoc);
            org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);
            org.apache.pdfbox.pdmodel.PDPage targetPage = targetDoc.getPage(0);
            layerUtil.wrapInSaveRestore(targetPage);
            java.awt.geom.AffineTransform at = new java.awt.geom.AffineTransform();
            layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");
            targetDoc.save(param0);
        } finally {
            targetDoc.close();
            overlay1Doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(targetFile);
        try {
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            // OCGs require PDF 1.5 or later
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(0);
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup ocg = ((org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup) (page.getResources().getProperties(org.apache.pdfbox.cos.COSName.getPDFName("oc1"))));
//            assertNotNull(ocg);
            assertEquals("overlay", ocg.getName());
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties ocgs = catalog.getOCProperties();
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup overlay = ocgs.getGroup("overlay");
//            assertEquals(ocg.getName(), overlay.getName());
        } finally {
            doc.close();
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLayerImport_4(String param0) throws Exception {
        java.io.File mainPDF = createMainPDF();
        java.io.File overlay1 = createOverlay1();
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-with-form-overlay.pdf");
        org.apache.pdfbox.pdmodel.PDDocument targetDoc = org.apache.pdfbox.pdmodel.PDDocument.load(mainPDF);
        org.apache.pdfbox.pdmodel.PDDocument overlay1Doc = org.apache.pdfbox.pdmodel.PDDocument.load(overlay1);
        try {
            LayerUtility layerUtil = new LayerUtility(targetDoc);
            org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);
            org.apache.pdfbox.pdmodel.PDPage targetPage = targetDoc.getPage(0);
            layerUtil.wrapInSaveRestore(targetPage);
            java.awt.geom.AffineTransform at = new java.awt.geom.AffineTransform();
            layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");
            targetDoc.save(param0);
        } finally {
            targetDoc.close();
            overlay1Doc.close();
        }
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(targetFile);
        try {
            org.apache.pdfbox.pdmodel.PDDocumentCatalog catalog = doc.getDocumentCatalog();
            // OCGs require PDF 1.5 or later
//            assertEquals(1.5F, doc.getVersion(), 0.0);
            org.apache.pdfbox.pdmodel.PDPage page = doc.getPage(0);
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup ocg = ((org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup) (page.getResources().getProperties(org.apache.pdfbox.cos.COSName.getPDFName("oc1"))));
//            assertNotNull(ocg);
//            assertEquals("overlay", ocg.getName());
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties ocgs = catalog.getOCProperties();
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup overlay = ocgs.getGroup("overlay");
            assertEquals(ocg.getName(), overlay.getName());
        } finally {
            doc.close();
        }
    }

    private java.io.File createMainPDF() throws java.io.IOException {
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "text-doc.pdf");
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
            final String[] text = new String[]{ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer fermentum lacus in eros", "condimentum eget tristique risus viverra. Sed ac sem et lectus ultrices placerat. Nam", "fringilla tincidunt nulla id euismod. Vivamus eget mauris dui. Mauris luctus ullamcorper", "leo, et laoreet diam suscipit et. Nulla viverra commodo sagittis. Integer vitae rhoncus velit.", "Mauris porttitor ipsum in est sagittis non luctus purus molestie. Sed placerat aliquet", "vulputate." };
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 720);
            contentStream.setFont(font, 14);
            contentStream.showText("Simple test document with text.");
            contentStream.endText();
            font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA;
            contentStream.beginText();
            int fontSize = 12;
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(50, 700);
            for (String line : text) {
                contentStream.newLineAtOffset(0, (-fontSize) * 1.2F);
                contentStream.showText(line);
            }
            contentStream.endText();
            contentStream.close();
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
        return targetFile;
    }

    private java.io.File createOverlay1() throws java.io.IOException {
        java.io.File targetFile = new java.io.File(TestProzeGen_PDDocument_save_java_lang_String_TestLayerUtility_testLayerImport.testResultsDir, "overlay1.pdf");
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
            // Setup page content stream and paint background/title
            org.apache.pdfbox.pdmodel.PDPageContentStream contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page, org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode.OVERWRITE, false);
            org.apache.pdfbox.pdmodel.font.PDFont font = org.apache.pdfbox.pdmodel.font.PDType1Font.HELVETICA_BOLD;
            contentStream.setNonStrokingColor(java.awt.Color.LIGHT_GRAY);
            contentStream.beginText();
            float fontSize = 96;
            contentStream.setFont(font, fontSize);
            String text = "OVERLAY";
            // float sw = font.getStringWidth(text);
            // Too bad, base 14 fonts don't return character metrics.
            org.apache.pdfbox.pdmodel.common.PDRectangle crop = page.getCropBox();
            float cx = crop.getWidth() / 2.0F;
            float cy = crop.getHeight() / 2.0F;
            org.apache.pdfbox.util.Matrix transform = new org.apache.pdfbox.util.Matrix();
            transform.translate(cx, cy);
            transform.rotate(Math.toRadians(45));
            /* sw/2 */
            transform.translate(-190, 0);
            contentStream.setTextMatrix(transform);
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();
            doc.save(targetFile.getAbsolutePath());
        } finally {
            doc.close();
        }
        return targetFile;
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