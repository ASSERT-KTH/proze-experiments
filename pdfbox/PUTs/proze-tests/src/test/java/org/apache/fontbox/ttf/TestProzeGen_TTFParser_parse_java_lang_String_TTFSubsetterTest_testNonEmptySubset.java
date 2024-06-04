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
public class TestProzeGen_TTFParser_parse_java_lang_String_TTFSubsetterTest_testNonEmptySubset {
    /**
     * Test of PDFBOX-2854: subset with one glyph.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(2, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("a"));
        assertNotNull(subset.getGlyph().getGlyph(0));
        assertNotNull(subset.getGlyph().getGlyph(1));
        assertNull(subset.getGlyph().getGlyph(2));
        assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_1(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_2(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_3(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_4(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_5(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_6(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_7(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        // assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testNonEmptySubset_8(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('a');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(2, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("a"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        // assertNotNull(subset.getGlyph().getGlyph(1));
        // assertNull(subset.getGlyph().getGlyph(2));
        // assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));
        assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));
        subset.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("src/test/resources/ttf/LiberationSans-Regular.ttf"),
        org.junit.jupiter.params.provider.Arguments.of("target/pdfs/DejaVuSansMono.ttf"),
        org.junit.jupiter.params.provider.Arguments.of("target/pdfs/NotoEmoji-Regular.ttf")
        );
    }
}