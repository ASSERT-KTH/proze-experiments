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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_TTFParser_parse_java_lang_String_TTFSubsetterTest_testEmptySubset2 {
    /**
     * Test of PDFBOX-2854: empty subset with selected tables.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testEmptySubset2(String param0) throws java.io.IOException {
        TrueTypeFont x = new TTFParser().parse(param0);
        java.util.List<String> tables = new java.util.ArrayList<String>();
        tables.add("head");
        tables.add("hhea");
        tables.add("loca");
        tables.add("maxp");
        tables.add("cvt ");
        tables.add("prep");
        tables.add("glyf");
        tables.add("hmtx");
        tables.add("fpgm");
        tables.add("gasp");
        TTFSubsetter ttfSubsetter = new TTFSubsetter(x, tables);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(1, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        assertNotNull(subset.getGlyph().getGlyph(0));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testEmptySubset2_1(String param0) throws java.io.IOException {
        TrueTypeFont x = new TTFParser().parse(param0);
        java.util.List<String> tables = new java.util.ArrayList<String>();
        tables.add("head");
        tables.add("hhea");
        tables.add("loca");
        tables.add("maxp");
        tables.add("cvt ");
        tables.add("prep");
        tables.add("glyf");
        tables.add("hmtx");
        tables.add("fpgm");
        tables.add("gasp");
        TTFSubsetter ttfSubsetter = new TTFSubsetter(x, tables);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(1, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testEmptySubset2_2(String param0) throws java.io.IOException {
        TrueTypeFont x = new TTFParser().parse(param0);
        java.util.List<String> tables = new java.util.ArrayList<String>();
        tables.add("head");
        tables.add("hhea");
        tables.add("loca");
        tables.add("maxp");
        tables.add("cvt ");
        tables.add("prep");
        tables.add("glyf");
        tables.add("hmtx");
        tables.add("fpgm");
        tables.add("gasp");
        TTFSubsetter ttfSubsetter = new TTFSubsetter(x, tables);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(1, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        // assertNotNull(subset.getGlyph().getGlyph(0));
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testEmptySubset2_3(String param0) throws java.io.IOException {
        TrueTypeFont x = new TTFParser().parse(param0);
        java.util.List<String> tables = new java.util.ArrayList<String>();
        tables.add("head");
        tables.add("hhea");
        tables.add("loca");
        tables.add("maxp");
        tables.add("cvt ");
        tables.add("prep");
        tables.add("glyf");
        tables.add("hmtx");
        tables.add("fpgm");
        tables.add("gasp");
        TTFSubsetter ttfSubsetter = new TTFSubsetter(x, tables);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(1, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        assertNotNull(subset.getGlyph().getGlyph(0));
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