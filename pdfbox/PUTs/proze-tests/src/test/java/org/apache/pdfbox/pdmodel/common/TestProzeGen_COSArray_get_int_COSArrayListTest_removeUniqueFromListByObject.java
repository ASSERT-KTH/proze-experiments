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

import static org.junit.jupiter.api.Assertions.*;

public class TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject {
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
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup txtMark = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink txtLink = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink();
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle aCircle = new org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle.SUB_TYPE_CIRCLE);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.add(txtMark);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.add(txtLink);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.add(aCircle);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.size());
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList = new java.util.ArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.add(txtMark);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.add(txtLink);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.add(aCircle);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.add(txtLink);
        assertEquals(4, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.size());
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray = new org.apache.pdfbox.cos.COSArray();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.add(txtMark);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.add(txtLink);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.add(aCircle);
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.add(txtLink);
        assertEquals(4, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray = new org.apache.pdfbox.cos.COSBase[4];
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[0] = txtMark.getCOSObject();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[1] = txtLink.getCOSObject();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[2] = aCircle.getCOSObject();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3] = txtLink.getCOSObject();
        assertEquals(4, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray.length);
        // add the annotations to the page
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.pdPage = new org.apache.pdfbox.pdmodel.PDPage();
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.pdPage.setAnnotations(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList);
        // create test output directory
        TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.OUT_DIR.mkdirs();
    }

    /**
     * Test removing a unique PDModel element by index is in sync with underlying COSArray
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        assertTrue(cosArrayList.remove(toBeRemoved), "Remove operation shall return true");
        assertEquals(3, cosArrayList.size(), "List size shall be 3");
        assertEquals( 3, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size(),
                "COSArray size shall be 3");
        assertEquals(cosArrayList.get(2), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3),
                "List object at 3 is at position 2 in COSArrayList now");
        assertEquals(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(param0), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject(),
                "COSObject of List object at 3 is at position 2 in COSArray now");
        assertEquals(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(param0), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3],
                "Array object at 3 is at position 2 in underlying COSArray now");
        assertEquals(-1, cosArrayList.indexOf(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)),
                "PDAnnotation shall no longer exist in List");
        assertEquals(-1, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]),
                "COSObject shall no longer exist in COSArray");
        assertFalse(cosArrayList.remove(toBeRemoved), "Remove shall not remove any object");
    }


    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_1(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        assertTrue(cosArrayList.remove(toBeRemoved), "Remove operation shall return true");
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_2(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        assertEquals(3, cosArrayList.size(), "List size shall be 3");
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_3(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        assertEquals(3, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size(),
                "COSArray size shall be 3");
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_4(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        assertEquals(cosArrayList.get(2), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3),
                "List object at 3 is at position 2 in COSArrayList now");
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_5(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        assertEquals(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(param0), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject(),
                "COSObject of List object at 3 is at position 2 in COSArray now");
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_6(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        assertEquals(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(param0), TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3],
                "Array object at 3 is at position 2 in underlying COSArray now");
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_7(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        assertEquals(-1, cosArrayList.indexOf(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)),
                "PDAnnotation shall no longer exist in List");
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_8(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        assertEquals(-1, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]),
                "COSObject shall no longer exist in COSArray");
        // assertFalse("Remove shall not remove any object", cosArrayList.remove(toBeRemoved));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void removeUniqueFromListByObject_9(int param0) throws Exception {
        COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation> cosArrayList = new COSArrayList<org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation>(TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList, TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray);
        int positionToRemove = 2;
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation toBeRemoved = TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsList.get(positionToRemove);
        // assertTrue("Remove operation shall return true", cosArrayList.remove(toBeRemoved));
        // assertEquals("List size shall be 3", 3, cosArrayList.size());
        // assertEquals("COSArray size shall be 3", 3, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.size());
        // assertEquals("List object at 3 is at position 2 in COSArrayList now", cosArrayList.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3));
        // assertEquals("COSObject of List object at 3 is at position 2 in COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(3).getCOSObject());
        // assertEquals("Array object at 3 is at position 2 in underlying COSArray now", org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.get(2), org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[3]);
        // assertEquals("PDAnnotation shall no longer exist in List", -1, cosArrayList.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsList.get(positionToRemove)));
        // assertEquals("COSObject shall no longer exist in COSArray", -1, org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.annotationsArray.indexOf(org.apache.pdfbox.pdmodel.common.TestProzeGen_COSArray_get_int_COSArrayListTest_removeUniqueFromListByObject.tbcAnnotationsArray[positionToRemove]));
        assertFalse(cosArrayList.remove(toBeRemoved), "Remove shall not remove any object");
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(101),
        org.junit.jupiter.params.provider.Arguments.of(102),
        org.junit.jupiter.params.provider.Arguments.of(103),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(105),
        org.junit.jupiter.params.provider.Arguments.of(106),
        org.junit.jupiter.params.provider.Arguments.of(107),
        org.junit.jupiter.params.provider.Arguments.of(108),
        org.junit.jupiter.params.provider.Arguments.of(109),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(110),
        org.junit.jupiter.params.provider.Arguments.of(111),
        org.junit.jupiter.params.provider.Arguments.of(112),
        org.junit.jupiter.params.provider.Arguments.of(113),
        org.junit.jupiter.params.provider.Arguments.of(114),
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
        org.junit.jupiter.params.provider.Arguments.of(59),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(60),
        org.junit.jupiter.params.provider.Arguments.of(61),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(63),
        org.junit.jupiter.params.provider.Arguments.of(64),
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
        org.junit.jupiter.params.provider.Arguments.of(92),
        org.junit.jupiter.params.provider.Arguments.of(93),
        org.junit.jupiter.params.provider.Arguments.of(94),
        org.junit.jupiter.params.provider.Arguments.of(95),
        org.junit.jupiter.params.provider.Arguments.of(96),
        org.junit.jupiter.params.provider.Arguments.of(97),
        org.junit.jupiter.params.provider.Arguments.of(98),
        org.junit.jupiter.params.provider.Arguments.of(99)
        );
    }
}