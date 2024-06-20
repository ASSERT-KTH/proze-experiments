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
package org.apache.pdfbox.text;
import java.io.IOException;
import java.net.URISyntaxException;

import difflib.ChangeDelta;
import difflib.DeleteDelta;
import difflib.DiffUtils;
import difflib.Patch;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for PDFTextStripper.
 *
 * FILE SET VALIDATION
 *
 * This test suite is designed to test PDFTextStripper using a set of PDF
 * files and known good output for each.  The default mode of testAll()
 * is to process each *.pdf file in "src/test/resources/input".  An output
 * file is created in "target/test-output" with the same name as the PDF file,
 * plus an additional ".txt" suffix.
 *
 * The output file is then tested against a known good result file from
 * the input directory (again, with the same name as the tested PDF file,
 * but with the additional ".txt" suffix).  The process is performed both
 * with and without sorting enabled.  The sorted files have a "-sorted.txt"
 * suffix.
 *
 * So for the file "src/test/resources/input/hello.pdf", an output file will
 * be generated named "target/test-output/hello.pdf.txt".  Then that file
 * will be compared to the known good file
 * "src/test/resources/input/hello.pdf.txt", if it exists.
 *
 * To support testing with files that are not officially distributed
 * with PDFBox, this test will also look in the "target/test-input-ext"
 * directory.
 *
 * Any errors are logged, and at the end of processing all *.pdf files, if
 * there were any errors, the test fails.  The logging is at INFO, as the
 * general goal is overall validation, and on failure, the indication of
 * which file or files failed.
 *
 * When processing new PDF files, you may use testAll() to generate output,
 * verify the output manually, then move the output file to the test input
 * directory to use as the basis for future validations.
 *
 * SINGLE FILE VALIDATION
 *
 * To further research individual failures, the org.apache.pdfbox.util.TextStripper.file
 * system property may be set with the name of a single file in the "test/input"
 * directory.  In this mode, testAll() will evaluate only that file, and will
 * do so with DEBUG level logging.
 *
 * @author Robert Dickinson
 * @author Ben Litchfield
 */
// public class TestTextStripper extends TestCase
public class TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems {
    /**
     * Logger instance.
     */
    private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.class);

    private boolean bFail = false;

    private static PDFTextStripper stripper = null;

    private static final String ENCODING = "UTF-8";

    /**
     * Test class constructor.
     *
     * @param name
     * 		The name of the test class.
     * @throws IOException
     * 		If there is an error creating the test.
     */
    // public TestTextStripper( String name ) throws IOException
    // {
    // super( name );
    // stripper = new PDFTextStripper();
    // stripper.setLineSeparator("\n");
    // }
    /**
     * Test suite setup.
     */
    // @Override
    @BeforeEach
    public void setUp() throws Exception {
        // If you want to test a single file using DEBUG logging, from an IDE,
        // you can do something like this:
        // 
        // System.setProperty("org.apache.pdfbox.util.TextStripper.file", "FVS318Ref.pdf");
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper = new PDFTextStripper();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setLineSeparator("\n");
    }

    /**
     * Determine whether two strings are equal, where two null strings are
     * considered equal.
     *
     * @param expected
     * 		Expected string
     * @param actual
     * 		Actual String
     * @return <code>true</code> is the strings are both null,
    or if their contents are the same, otherwise <code>false</code>.
     */
    private boolean stringsEqual(String expected, String actual) {
        boolean equals = true;
        if ((expected == null) && (actual == null)) {
            return true;
        } else if ((expected != null) && (actual != null)) {
            expected = expected.trim();
            actual = actual.trim();
            char[] expectedArray = expected.toCharArray();
            char[] actualArray = actual.toCharArray();
            int expectedIndex = 0;
            int actualIndex = 0;
            while ((expectedIndex < expectedArray.length) && (actualIndex < actualArray.length)) {
                if (expectedArray[expectedIndex] != actualArray[actualIndex]) {
                    equals = false;
                    TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.log.warn(((((((("Lines differ at index" + " expected:") + expectedIndex) + "-") + ((int) (expectedArray[expectedIndex]))) + " actual:") + actualIndex) + "-") + ((int) (actualArray[actualIndex])));
                    break;
                }
                expectedIndex = skipWhitespace(expectedArray, expectedIndex);
                actualIndex = skipWhitespace(actualArray, actualIndex);
                expectedIndex++;
                actualIndex++;
            } 
            if (equals) {
                if (expectedIndex != expectedArray.length) {
                    equals = false;
                    TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.log.warn("Expected line is longer at:" + expectedIndex);
                }
                if (actualIndex != actualArray.length) {
                    equals = false;
                    TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.log.warn("Actual line is longer at:" + actualIndex);
                }
                if (expectedArray.length != actualArray.length) {
                    equals = false;
                    TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.log.warn((("Expected lines: " + expectedArray.length) + ", actual lines: ") + actualArray.length);
                }
            }
        } else {
            equals = (((expected == null) && (actual != null)) && actual.trim().isEmpty()) || (((actual == null) && (expected != null)) && expected.trim().isEmpty());
        }
        return equals;
    }

    /**
     * If the current index is whitespace then skip any subsequent whitespace.
     */
    private int skipWhitespace(char[] array, int index) {
        // if we are at a space character then skip all space
        // characters, but when all done rollback 1 because stringsEqual
        // will roll forward 1
        if ((array[index] == ' ') || (array[index] > 256)) {
            while ((index < array.length) && ((array[index] == ' ') || (array[index] > 256))) {
                index++;
            } 
            index--;
        }
        return index;
    }

    private void compareResult(java.io.File expectedFile, java.io.File outFile, java.io.File inFile, boolean bSort, java.io.File diffFile) throws IOException {
        boolean localFail = false;
        java.io.LineNumberReader expectedReader = new java.io.LineNumberReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedFile), TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.ENCODING));
        java.io.LineNumberReader actualReader = new java.io.LineNumberReader(new java.io.InputStreamReader(new java.io.FileInputStream(outFile), TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.ENCODING));
        while (true) {
            String expectedLine = expectedReader.readLine();
            while ((expectedLine != null) && (expectedLine.trim().length() == 0)) {
                expectedLine = expectedReader.readLine();
            } 
            String actualLine = actualReader.readLine();
            while ((actualLine != null) && (actualLine.trim().length() == 0)) {
                actualLine = actualReader.readLine();
            } 
            if (!stringsEqual(expectedLine, actualLine)) {
                this.bFail = true;
                localFail = true;
                TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.log.error((((((((((((((("FAILURE: Line mismatch for file " + inFile.getName()) + " (sort = ") + bSort) + ")") + " at expected line: ") + expectedReader.getLineNumber()) + " at actual line: ") + actualReader.getLineNumber()) + "\nexpected line was: \"") + expectedLine) + "\"") + "\nactual line was:   \"") + actualLine) + "\"") + "\n");
                // lets report all lines, even though this might produce some verbose logging
                // break;
            }
            if ((expectedLine == null) || (actualLine == null)) {
                break;
            }
        } 
        expectedReader.close();
        actualReader.close();
        if (!localFail) {
            outFile.delete();
        } else {
            // https://code.google.com/p/java-diff-utils/wiki/SampleUsage
            java.util.List<String> original = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.fileToLines(expectedFile);
            java.util.List<String> revised = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.fileToLines(outFile);
            // Compute diff. Get the Patch object. Patch is the container for computed deltas.
            Patch patch = DiffUtils.diff(original, revised);
            java.io.PrintStream diffPS = new java.io.PrintStream(diffFile, TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.ENCODING);
            for (Object delta : patch.getDeltas()) {
                if (delta instanceof ChangeDelta) {
                    ChangeDelta<String> cdelta = ((ChangeDelta<String>) (delta));
                    diffPS.println("Org: " + cdelta.getOriginal());
                    diffPS.println("New: " + cdelta.getRevised());
                    diffPS.println();
                } else if (delta instanceof difflib.DeleteDelta) {
                    DeleteDelta<String> ddelta = ((DeleteDelta<String>) (delta));
                    diffPS.println("Org: " + ddelta.getOriginal());
                    diffPS.println("New: " + ddelta.getRevised());
                    diffPS.println();
                } else if (delta instanceof difflib.InsertDelta) {
                    difflib.InsertDelta<String> idelta = ((difflib.InsertDelta<String>) (delta));
                    diffPS.println("Org: " + idelta.getOriginal());
                    diffPS.println("New: " + idelta.getRevised());
                    diffPS.println();
                } else {
                    diffPS.println(delta);
                }
            }
            diffPS.close();
        }
    }

    // Helper method for get the file content
    private static java.util.List<String> fileToLines(java.io.File file) throws IOException {
        java.util.List<String> lines = new java.util.LinkedList<String>();
        String line;
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.ENCODING));
        while ((line = in.readLine()) != null) {
            lines.add(line);
        } 
        in.close();
        return lines;
    }

    private int findOutlineItemDestPageNum(org.apache.pdfbox.pdmodel.PDDocument doc, org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi) throws IOException {
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination pageDest = ((org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination) (oi.getDestination()));
        // two methods to get the page index, the result should be identical!
        int indexOfPage = doc.getPages().indexOf(oi.findDestinationPage(doc));
        int pageNum = pageDest.retrievePageNumber();
        assertEquals(indexOfPage, pageNum);
        return pageNum;
    }

    /**
     * Test whether stripping controlled by outline items works properly. The test file has 4
     * outline items at the top level, that point to 0-based pages 0, 2, 3 and 4. We are testing
     * text stripping by outlines pointing to 0-based pages 2 and 3, and also text stripping of the
     * 0-based page 2. The test makes sure that the output is different to a complete strip, not
     * empty, different to each other when different bookmark intervals are used, but identical from
     * bookmark intervals to strips with page intervals. When fed with orphan bookmarks, stripping
     * must be empty.
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textoi23.isEmpty());
        assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textp34.isEmpty());
        assertNotEquals(textoi23, textFull);
        assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textoi2.isEmpty());
        assertNotEquals(textoi2, textoi23);
        assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textp3.isEmpty());
        assertNotEquals(textp3, textp34);
        assertNotEquals(textoi23, textFull);
        assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_1(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_2(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_3(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_4(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_5(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_6(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_7(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_8(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_9(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_10(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_11(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_12(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_13(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_14(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_15(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
//         assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_16(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_17(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_18(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_19(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
//        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
//        assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_20(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // assertTrue(textOiOrphan.isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testStripByOutlineItems_21(int param0) throws IOException, URISyntaxException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(org.apache.pdfbox.pdmodel.TestPDPageTree.class.getResource("with_outline.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline outline = doc.getDocumentCatalog().getDocumentOutline();
        Iterable<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> children = outline.children();
        java.util.Iterator<org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem> it = children.iterator();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi0 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi2 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi3 = it.next();
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oi4 = it.next();
        // assertEquals(0, findOutlineItemDestPageNum(doc, oi0));
        // assertEquals(2, findOutlineItemDestPageNum(doc, oi2));
        // assertEquals(3, findOutlineItemDestPageNum(doc, oi3));
        // assertEquals(4, findOutlineItemDestPageNum(doc, oi4));
        String textFull = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textFull.isEmpty());
        String expectedTextFull = ((((((((((((("First level 1\n" + "First level 2\n") + "Fist level 3\n") + "Some content\n") + "Some other content\n") + "Second at level 1\n") + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n") + "Fourth level 1\n") + "Content\n") + "Content\n";
        // assertEquals(expectedTextFull, textFull.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi3);
        String textoi23 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi23.isEmpty());
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi23 = ((((("Second at level 1\n" + "Second level 2\n") + "Content\n") + "Third level 1\n") + "Third level 2\n") + "Third level 3\n") + "Content\n";
        // assertEquals(expectedTextoi23, textoi23.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(4);
        String textp34 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp34.isEmpty());
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi23, textp34);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oi2);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oi2);
        String textoi2 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textoi2.isEmpty());
        // assertNotEquals(textoi2, textoi23);
        // assertNotEquals(textoi23, textFull);
        String expectedTextoi2 = ("Second at level 1\n" + "Second level 2\n") + "Content\n";
        // assertEquals(expectedTextoi2, textoi2.replaceAll("\r", ""));
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(null);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartPage(param0);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndPage(3);
        String textp3 = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        // junit.framework.TestCase.assertFalse(textp3.isEmpty());
        // assertNotEquals(textp3, textp34);
        // assertNotEquals(textoi23, textFull);
        // assertEquals(textoi2, textp3);
        org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem oiOrphan = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem();
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setStartBookmark(oiOrphan);
        TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.setEndBookmark(oiOrphan);
        String textOiOrphan = TestProzeGen_PDFTextStripper_setStartPage_int_TestTextStripper_testStripByOutlineItems.stripper.getText(doc);
        assertTrue(textOiOrphan.isEmpty());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(3)
        );
    }
}