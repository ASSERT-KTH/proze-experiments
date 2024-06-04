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
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test merging different PDFs with Annotations.
 */
public class TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output/merge/");

    private static final java.io.File TARGET_PDF_DIR = new java.io.File("target/pdfs");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR.mkdirs();
    }

    /* PDFBOX-1065 Ensure that after merging the PDFs there are all link
    annotations and they point to the correct page.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
            assertEquals(12, destinations.getCOSObject().entrySet().size(),
                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
            assertEquals(3, sourceAnnotations01.size(),
                    "There shall be 3 source annotations at the first page");
            assertEquals(3, targetAnnotations01.size(),
                    "There shall be 3 source annotations at the third page");
            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_1(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_2(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
            assertEquals(12, destinations.getCOSObject().entrySet().size(),
                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_3(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
            assertEquals(3, sourceAnnotations01.size(),
                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_4(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
            assertEquals(3, targetAnnotations01.size(),
                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_5(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_6(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_7(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLinkAnnotations_8(int param0) throws java.io.IOException {
        // Merge the PDFs from PDFBOX-1065
        PDFMergerUtility merger = new PDFMergerUtility();
        java.io.InputStream is1 = null;
        java.io.InputStream is2 = null;
        try {
            java.io.File file1 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");
            is1 = new java.io.FileInputStream(file1);
            java.io.File file2 = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");
            is2 = new java.io.FileInputStream(file2);
            java.io.File pdfOutput = new java.io.File(TestProzeGen_PDDocument_getPage_int_MergeAnnotationsTest_testLinkAnnotations.OUT_DIR, "PDFBOX-1065.pdf");
            merger.setDestinationFileName(pdfOutput.getAbsolutePath());
            merger.addSource(is1);
            merger.addSource(is2);
            merger.mergeDocuments(null);
            // Test merge result
            org.apache.pdfbox.pdmodel.PDDocument mergedPDF = org.apache.pdfbox.pdmodel.PDDocument.load(pdfOutput);
//            assertEquals(6, mergedPDF.getNumberOfPages(), "There shall be 6 pages");
            org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();
            // Each document has 3 annotations with 2 entries in the /Dests dictionary per annotation. One for the
            // source and one for the target.
//            assertEquals(12, destinations.getCOSObject().entrySet().size(),
//                    "There shall be 12 entries");
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations01 = mergedPDF.getPage(param0).getAnnotations();
            java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotations02 = mergedPDF.getPage(param0).getAnnotations();
            // Test for the first set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations01.size(),
//                    "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations01.size(),
//                    "There shall be 3 source annotations at the third page");
//            assertTrue(testAnnotationsMatch(sourceAnnotations01, targetAnnotations01),
//                    "The annotations shall match to each other");
            // Test for the second set of annotations to be merged an linked correctly
//            assertEquals(3, sourceAnnotations02.size(), "There shall be 3 source annotations at the first page");
//            assertEquals(3, targetAnnotations02.size(), "There shall be 3 source annotations at the third page");
            assertTrue(testAnnotationsMatch(sourceAnnotations02, targetAnnotations02), "The annotations shall match to each other");
            mergedPDF.close();
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(is1);
            org.apache.pdfbox.io.IOUtils.closeQuietly(is2);
        }
    }

    /* Source and target annotations are línked by name with the target annotation's name
    being the source annotation's name prepended with 'annoRef_'
     */
    private boolean testAnnotationsMatch(java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> sourceAnnots, java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnots) {
        java.util.Map<String, org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> targetAnnotsByName = new java.util.HashMap<String, org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.cos.COSName destinationName;
        // fill the map with the annotations destination name
        for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation targetAnnot : targetAnnots) {
            destinationName = ((org.apache.pdfbox.cos.COSName) (targetAnnot.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DEST)));
            targetAnnotsByName.put(destinationName.getName(), targetAnnot);
        }
        // try to lookup the target annotation for the source annotation by destination name
        for (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation sourceAnnot : sourceAnnots) {
            destinationName = ((org.apache.pdfbox.cos.COSName) (sourceAnnot.getCOSObject().getDictionaryObject(org.apache.pdfbox.cos.COSName.DEST)));
            if (targetAnnotsByName.get("annoRef_" + destinationName.getName()) == null) {
                return false;
            }
        }
        return true;
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