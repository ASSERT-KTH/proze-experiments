/* Copyright 2015 The Apache Software Foundation.

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
package org.apache.pdfbox.pdmodel.common;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject {
    // next two entries are to be used for comparison with
    // COSArrayList behaviour in order to ensure that the
    // intended object is now at the correct position.
    // Will also be used for Collection/Array based setting
    // and comparison
    static java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> tbcAnnotationsList;

    static org.apache.pdfbox.cos.COSBase[] tbcAnnotationsArray;

    // next entries are to be used within COSArrayList
    static java.util.List<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotationsList;

    static org.apache.pdfbox.cos.COSArray annotationsArray;

    // to be used when testing retrieving filtered items as can be done with
    // {@link PDPage.getAnnotations(AnnotationFilter annotationFilter)}
    static org.apache.pdfbox.pdmodel.PDPage pdPage;

    private static final java.io.File OUT_DIR = new java.io.File("target/test-output/pdmodel/common");

    /* Create three new different annotations and add them to the Java List/Array as
    well as PDFBox List/Array implementations.
     */
    @BeforeAll
    public static void setUp() throws Exception {
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle aCircle = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle.SUB_TYPE_CIRCLE);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList.add(txtMark);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList.add(txtLink);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList.add(aCircle);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList.size());
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList.add(txtMark);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList.add(txtLink);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList.add(aCircle);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsList.size());
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray = new org.apache.pdfbox.cos.COSArray();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray.add(txtMark);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray.add(txtLink);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray.add(aCircle);
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray.add(txtLink);
        assertEquals(4, TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsArray.size());
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray = new org.apache.pdfbox.cos.COSBase[4];
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray[0] = txtMark.getCOSObject();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray[1] = txtLink.getCOSObject();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray[2] = aCircle.getCOSObject();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray[3] = txtLink.getCOSObject();
        assertEquals(4, TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.tbcAnnotationsArray.length);
        // add the annotations to the page
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.pdPage = new org.apache.pdfbox.pdmodel.PDPage();
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.pdPage.setAnnotations(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.annotationsList);
        // create test output directory
        TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR.mkdirs();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        assertEquals(4, pageAnnots.size(), "There shall be 4 annotations generated");
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        assertEquals(4, annotations.size(), "There shall be 4 annotations retrieved");
        assertEquals(4, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 4");
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        assertEquals(3, annotations.size(), "There shall be 3 annotations left");
        assertEquals(3, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 2");
        pdf.close();
    }


    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject_1(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        assertEquals(4, pageAnnots.size(), "There shall be 4 annotations generated");
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        // assertEquals("There shall be 3 annotations left", 3, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 2", 3, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject_2(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        // assertEquals("There shall be 4 annotations generated", 4, pageAnnots.size());
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        assertEquals(4, annotations.size(), "There shall be 4 annotations retrieved");
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        // assertEquals("There shall be 3 annotations left", 3, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 2", 3, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject_3(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        // assertEquals("There shall be 4 annotations generated", 4, pageAnnots.size());
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        assertEquals(4, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 4");
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        // assertEquals("There shall be 3 annotations left", 3, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 2", 3, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject_4(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        // assertEquals("There shall be 4 annotations generated", 4, pageAnnots.size());
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        assertEquals(3, annotations.size(), "There shall be 3 annotations left");
        // assertEquals("The size of the internal COSArray shall be 2", 3, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeSingleIndirectObject_5(int param0) throws java.io.IOException {
        // generate test file
        org.apache.pdfbox.pdmodel.PDDocument pdf = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        pdf.addPage(page);
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> pageAnnots = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtMark);
        pageAnnots.add(txtLink);
        // assertEquals("There shall be 4 annotations generated", 4, pageAnnots.size());
        page.setAnnotations(pageAnnots);
        pdf.save(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDDocument_COSArrayListTest_getPage_int_removeSingleIndirectObject.OUT_DIR + "/removeSingleIndirectObjectTest.pdf"));
        page = pdf.getPage(param0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = annotations.get(0);
        annotations.remove(toBeRemoved);
        // assertEquals("There shall be 3 annotations left", 3, annotations.size());
        assertEquals(3, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 2");
        pdf.close();
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