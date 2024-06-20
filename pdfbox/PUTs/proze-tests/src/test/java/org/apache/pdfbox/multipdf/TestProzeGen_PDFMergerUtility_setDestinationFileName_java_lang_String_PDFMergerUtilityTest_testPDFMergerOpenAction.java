/* Copyright 2014 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.multipdf;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for PDFMergerUtility.
 *
 * @author Maruan Sahyoun (PDF files)
 * @author Tilman Hausherr (code)
 */
// public class PDFMergerUtilityTest extends TestCase
public class TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction {
    final String SRCDIR = "src/test/resources/input/merge/";

    static final String TARGETTESTDIR = "target/test-output/merge/";

    private static final java.io.File TARGETPDFDIR = new java.io.File("target/pdfs");

    final int DPI = 96;

    // @Override
    // protected void setUp() throws Exception
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR).mkdirs();
        if (!new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR).exists()) {
            throw new IOException("could not create output directory");
        }
    }

    /**
     * PDFBOX-3972: Test that OpenAction page destination isn't lost after merge.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFMergerOpenAction(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc1 = new org.apache.pdfbox.pdmodel.PDDocument();
        doc1.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc1.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc1.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc1.save(new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR, "MergerOpenActionTest1.pdf"));
        doc1.close();
        org.apache.pdfbox.pdmodel.PDDocument doc2 = new org.apache.pdfbox.pdmodel.PDDocument();
        doc2.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc2.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        doc2.addPage(new org.apache.pdfbox.pdmodel.PDPage());
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination dest = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination();
        dest.setPage(doc2.getPage(1));
        doc2.getDocumentCatalog().setOpenAction(dest);
        doc2.save(new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR, "MergerOpenActionTest2.pdf"));
        doc2.close();
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.addSource(new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR, "MergerOpenActionTest1.pdf"));
        pdfMergerUtility.addSource(new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR, "MergerOpenActionTest2.pdf"));
        pdfMergerUtility.setDestinationFileName(param0);
        pdfMergerUtility.mergeDocuments(org.apache.pdfbox.io.MemoryUsageSetting.setupMainMemoryOnly());
        org.apache.pdfbox.pdmodel.PDDocument mergedDoc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDFMergerUtility_setDestinationFileName_java_lang_String_PDFMergerUtilityTest_testPDFMergerOpenAction.TARGETTESTDIR, "MergerOpenActionTestResult.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentCatalog documentCatalog = mergedDoc.getDocumentCatalog();
        dest = ((org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination) (documentCatalog.getOpenAction()));
        assertEquals(4, documentCatalog.getPages().indexOf(dest.getPage()));
        mergedDoc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("./000752-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000753-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("./000817-merged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1031.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1065.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBOX-1100.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxJoinFieldsMerge-TextFieldsOnly-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("/home/dee/dev/forbi/pdfbox/pdfbox/target/test-output/merge/PDFBoxLegacyMerge-SameMerged.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/GlobalResourceMergeTestResult2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/JpegMultiMergeTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/MergerOpenActionTestResult.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged2.pdf"),
        org.junit.jupiter.params.provider.Arguments.of("target/test-output/merge/PDFA3A-merged3.pdf")
        );
    }
}