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
public class TestProzeGen_TTFParser_init_TTFSubsetterTest_testPDFBox3757 {
    /**
     * Test of PDFBOX-3757: check that PostScript names that are not part of WGL4Names don't get
     * shuffled in buildPostTable().
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3757(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(5, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("O"));
        assertEquals(2, subset.nameToGID("Odieresis"));
        assertEquals(3, subset.nameToGID("uni200A"));
        assertEquals(4, subset.nameToGID("dieresis.uc"));
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
    public void testPDFBox3757_1(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_2(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
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
    public void testPDFBox3757_3(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("O"));
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
    public void testPDFBox3757_4(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        assertEquals(2, subset.nameToGID("Odieresis"));
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
    public void testPDFBox3757_5(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        assertEquals(3, subset.nameToGID("uni200A"));
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
    public void testPDFBox3757_6(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(5, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("O"));
        // assertEquals(2, subset.nameToGID("Odieresis"));
        // assertEquals(3, subset.nameToGID("uni200A"));
        assertEquals(4, subset.nameToGID("dieresis.uc"));
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
    public void testPDFBox3757_7(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_8(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_9(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_10(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_11(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_12(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3757_13(boolean param0) throws java.io.IOException {
        final java.io.File testFile = new java.io.File("src/test/resources/ttf/LiberationSans-Regular.ttf");
        TrueTypeFont ttf = new TTFParser().parse(testFile);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);
        ttfSubsetter.add('Ö');
        ttfSubsetter.add(' ');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
        org.junit.jupiter.params.provider.Arguments.of(false),
        org.junit.jupiter.params.provider.Arguments.of(true)
        );
    }
}