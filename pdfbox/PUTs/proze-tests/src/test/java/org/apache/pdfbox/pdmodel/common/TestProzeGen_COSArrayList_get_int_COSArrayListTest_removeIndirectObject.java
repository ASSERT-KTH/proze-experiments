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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject {
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
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle aCircle = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle.SUB_TYPE_CIRCLE);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList.add(txtMark);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList.add(txtLink);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList.add(aCircle);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList.size());
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList.add(txtMark);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList.add(txtLink);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList.add(aCircle);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsList.size());
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray = new org.apache.pdfbox.cos.COSArray();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray.add(txtMark);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray.add(txtLink);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray.add(aCircle);
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray.add(txtLink);
        assertEquals(4, TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsArray.size());
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray = new org.apache.pdfbox.cos.COSBase[4];
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray[0] = txtMark.getCOSObject();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray[1] = txtLink.getCOSObject();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray[2] = aCircle.getCOSObject();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray[3] = txtLink.getCOSObject();
        assertEquals(4, TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.tbcAnnotationsArray.length);
        // add the annotations to the page
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.pdPage = new org.apache.pdfbox.pdmodel.PDPage();
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.pdPage.setAnnotations(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.annotationsList);
        // create test output directory
        TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR.mkdirs();
    }


    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        assertEquals(4, annotations.size(), "There shall be 4 annotations retrieved");
        assertEquals(4, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 4");
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        assertEquals(1, annotations.size(), "There shall be 1 annotations left");
        assertEquals(1, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 1");
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject_1(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        // assertEquals("There shall be 1 annotations left", 1, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 1", 1, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject_2(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        assertEquals(4, annotations.size(), "There shall be 4 annotations retrieved");
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        // assertEquals("There shall be 1 annotations left", 1, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 1", 1, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject_3(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        assertEquals(4, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 4");
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        // assertEquals("There shall be 1 annotations left", 1, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 1", 1, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject_4(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        assertEquals(1, annotations.size(), "There shall be 1 annotations left");
        // assertEquals("The size of the internal COSArray shall be 1", 1, annotations.getCOSArray().size());
        pdf.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeIndirectObject_5(int param0) throws java.io.IOException {
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
        pdf.save(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf");
        pdf.close();
        pdf = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_COSArrayList_get_int_COSArrayListTest_removeIndirectObject.OUT_DIR + "/removeIndirectObjectTest.pdf"));
        page = pdf.getPage(0);
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> annotations = ((COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>) (page.getAnnotations()));
        // assertEquals("There shall be 4 annotations retrieved", 4, annotations.size());
        // assertEquals("The size of the internal COSArray shall be 4", 4, annotations.getCOSArray().size());
        java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> toBeRemoved = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        toBeRemoved.add(annotations.get(param0));
        annotations.removeAll(toBeRemoved);
        // assertEquals("There shall be 1 annotations left", 1, annotations.size());
        assertEquals(1, annotations.getCOSArray().size(), "The size of the internal COSArray shall be 1");
        pdf.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(114),
        org.junit.jupiter.params.provider.Arguments.of(115),
        org.junit.jupiter.params.provider.Arguments.of(116),
        org.junit.jupiter.params.provider.Arguments.of(118),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(124),
        org.junit.jupiter.params.provider.Arguments.of(128),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(170),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(195),
        org.junit.jupiter.params.provider.Arguments.of(196),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(202),
        org.junit.jupiter.params.provider.Arguments.of(203),
        org.junit.jupiter.params.provider.Arguments.of(206),
        org.junit.jupiter.params.provider.Arguments.of(207),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(213),
        org.junit.jupiter.params.provider.Arguments.of(214),
        org.junit.jupiter.params.provider.Arguments.of(218),
        org.junit.jupiter.params.provider.Arguments.of(219),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(220),
        org.junit.jupiter.params.provider.Arguments.of(223),
        org.junit.jupiter.params.provider.Arguments.of(228),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(246),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(252),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(29),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(30),
        org.junit.jupiter.params.provider.Arguments.of(31),
        org.junit.jupiter.params.provider.Arguments.of(32),
        org.junit.jupiter.params.provider.Arguments.of(33),
        org.junit.jupiter.params.provider.Arguments.of(34),
        org.junit.jupiter.params.provider.Arguments.of(35),
        org.junit.jupiter.params.provider.Arguments.of(36),
        org.junit.jupiter.params.provider.Arguments.of(37),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(40),
        org.junit.jupiter.params.provider.Arguments.of(41),
        org.junit.jupiter.params.provider.Arguments.of(42),
        org.junit.jupiter.params.provider.Arguments.of(43),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(45),
        org.junit.jupiter.params.provider.Arguments.of(46),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(48),
        org.junit.jupiter.params.provider.Arguments.of(49),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(50),
        org.junit.jupiter.params.provider.Arguments.of(51),
        org.junit.jupiter.params.provider.Arguments.of(52),
        org.junit.jupiter.params.provider.Arguments.of(53),
        org.junit.jupiter.params.provider.Arguments.of(54),
        org.junit.jupiter.params.provider.Arguments.of(55),
        org.junit.jupiter.params.provider.Arguments.of(56),
        org.junit.jupiter.params.provider.Arguments.of(57),
        org.junit.jupiter.params.provider.Arguments.of(58),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(60),
        org.junit.jupiter.params.provider.Arguments.of(63),
        org.junit.jupiter.params.provider.Arguments.of(65),
        org.junit.jupiter.params.provider.Arguments.of(66),
        org.junit.jupiter.params.provider.Arguments.of(67),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(69),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(70),
        org.junit.jupiter.params.provider.Arguments.of(71),
        org.junit.jupiter.params.provider.Arguments.of(72),
        org.junit.jupiter.params.provider.Arguments.of(73),
        org.junit.jupiter.params.provider.Arguments.of(74),
        org.junit.jupiter.params.provider.Arguments.of(75),
        org.junit.jupiter.params.provider.Arguments.of(76),
        org.junit.jupiter.params.provider.Arguments.of(77),
        org.junit.jupiter.params.provider.Arguments.of(78),
        org.junit.jupiter.params.provider.Arguments.of(79),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(80),
        org.junit.jupiter.params.provider.Arguments.of(81),
        org.junit.jupiter.params.provider.Arguments.of(82),
        org.junit.jupiter.params.provider.Arguments.of(83),
        org.junit.jupiter.params.provider.Arguments.of(84),
        org.junit.jupiter.params.provider.Arguments.of(85),
        org.junit.jupiter.params.provider.Arguments.of(86),
        org.junit.jupiter.params.provider.Arguments.of(87),
        org.junit.jupiter.params.provider.Arguments.of(88),
        org.junit.jupiter.params.provider.Arguments.of(89),
        org.junit.jupiter.params.provider.Arguments.of(9),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(91),
        org.junit.jupiter.params.provider.Arguments.of(92)
        );
    }
}