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
package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_TrueTypeFont_nameToGID_java_lang_String_TTFSubsetterTest_testPDFBox3757 {
    /**
     * Test of PDFBOX-3757: check that PostScript names that are not part of WGL4Names don't get
     * shuffled in buildPostTable().
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(5, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(param0));
        assertEquals(1, subset.nameToGID(param0));
        assertEquals(2, subset.nameToGID(param0));
        assertEquals(3, subset.nameToGID(param0));
        assertEquals(4, subset.nameToGID(param0));
        PostScriptTable pst = subset.getPostScript();
        assertEquals(".notdef", pst.getName(0));
        assertEquals("O", pst.getName(1));
        assertEquals("Odieresis", pst.getName(2));
        assertEquals("uni200A", pst.getName(3));
        assertEquals("dieresis.uc", pst.getName(4));
        assertTrue(subset.getPath("uni200A").getBounds2D().isEmpty(),
                "Hair space path should be empty");
        assertFalse(subset.getPath("dieresis.uc").getBounds2D().isEmpty(),
                "UC dieresis path should not be empty");
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_1(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_2(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(param0));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_3(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID(param0));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_4(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        assertEquals(2, subset.nameToGID(param0));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_5(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        assertEquals(3, subset.nameToGID(param0));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_6(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        assertEquals(4, subset.nameToGID(param0));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_7(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_8(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_9(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_10(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_11(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_12(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        assertTrue(subset.getPath("uni200A").getBounds2D().isEmpty(),
                "Hair space path should be empty");
        // assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757_13(String param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        // assertEquals(4, subset.nameToGID("dieresis.uc"));
        PostScriptTable pst = subset.getPostScript();
        // assertEquals(".notdef", pst.getName(0));
        // assertEquals("O", pst.getName(1));
        // assertEquals("Odieresis", pst.getName(2));
        // assertEquals("uni200A", pst.getName(3));
        // assertEquals("dieresis.uc", pst.getName(4));
        // assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());
        assertFalse(subset.getPath("dieresis.uc").getBounds2D().isEmpty(),
                "UC dieresis path should not be empty");
        subset.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(".notdef"),
        org.junit.jupiter.params.provider.Arguments.of("A"),
        org.junit.jupiter.params.provider.Arguments.of("B"),
        org.junit.jupiter.params.provider.Arguments.of("D"),
        org.junit.jupiter.params.provider.Arguments.of("E"),
        org.junit.jupiter.params.provider.Arguments.of("F"),
        org.junit.jupiter.params.provider.Arguments.of("H"),
        org.junit.jupiter.params.provider.Arguments.of("I"),
        org.junit.jupiter.params.provider.Arguments.of("L"),
        org.junit.jupiter.params.provider.Arguments.of("M"),
        org.junit.jupiter.params.provider.Arguments.of("O"),
        org.junit.jupiter.params.provider.Arguments.of("Odieresis"),
        org.junit.jupiter.params.provider.Arguments.of("P"),
        org.junit.jupiter.params.provider.Arguments.of("R"),
        org.junit.jupiter.params.provider.Arguments.of("S"),
        org.junit.jupiter.params.provider.Arguments.of("W"),
        org.junit.jupiter.params.provider.Arguments.of("a"),
        org.junit.jupiter.params.provider.Arguments.of("adieresis"),
        org.junit.jupiter.params.provider.Arguments.of("b"),
        org.junit.jupiter.params.provider.Arguments.of("comma"),
        org.junit.jupiter.params.provider.Arguments.of("d"),
        org.junit.jupiter.params.provider.Arguments.of("dieresis.uc"),
        org.junit.jupiter.params.provider.Arguments.of("e"),
        org.junit.jupiter.params.provider.Arguments.of("eight"),
        org.junit.jupiter.params.provider.Arguments.of("f"),
        org.junit.jupiter.params.provider.Arguments.of("five"),
        org.junit.jupiter.params.provider.Arguments.of("four"),
        org.junit.jupiter.params.provider.Arguments.of("g"),
        org.junit.jupiter.params.provider.Arguments.of("hyphen"),
        org.junit.jupiter.params.provider.Arguments.of("i"),
        org.junit.jupiter.params.provider.Arguments.of("k"),
        org.junit.jupiter.params.provider.Arguments.of("l"),
        org.junit.jupiter.params.provider.Arguments.of("m"),
        org.junit.jupiter.params.provider.Arguments.of("n"),
        org.junit.jupiter.params.provider.Arguments.of("nine"),
        org.junit.jupiter.params.provider.Arguments.of("o"),
        org.junit.jupiter.params.provider.Arguments.of("odieresis"),
        org.junit.jupiter.params.provider.Arguments.of("one"),
        org.junit.jupiter.params.provider.Arguments.of("p"),
        org.junit.jupiter.params.provider.Arguments.of("period"),
        org.junit.jupiter.params.provider.Arguments.of("r"),
        org.junit.jupiter.params.provider.Arguments.of("s"),
        org.junit.jupiter.params.provider.Arguments.of("seven"),
        org.junit.jupiter.params.provider.Arguments.of("six"),
        org.junit.jupiter.params.provider.Arguments.of("slash"),
        org.junit.jupiter.params.provider.Arguments.of("space"),
        org.junit.jupiter.params.provider.Arguments.of("t"),
        org.junit.jupiter.params.provider.Arguments.of("three"),
        org.junit.jupiter.params.provider.Arguments.of("two"),
        org.junit.jupiter.params.provider.Arguments.of("u"),
        org.junit.jupiter.params.provider.Arguments.of("udieresis"),
        org.junit.jupiter.params.provider.Arguments.of("\u200A"),
        org.junit.jupiter.params.provider.Arguments.of("v"),
        org.junit.jupiter.params.provider.Arguments.of("w"),
        org.junit.jupiter.params.provider.Arguments.of("x"),
        org.junit.jupiter.params.provider.Arguments.of("z"),
        org.junit.jupiter.params.provider.Arguments.of("zero")
        );
    }
}