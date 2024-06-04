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

import static org.junit.jupiter.api.Assertions.assertEquals; /**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_TTFParser_parse_java_lang_String_TTFSubsetterTest_testPDFBox3379 {
    /**
     * Test of PDFBOX-3379: check that left side bearings in partially monospaced font are kept.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(4, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("space"));
        assertEquals(2, subset.nameToGID("A"));
        assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
        for (String name : names) {
            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_1(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
         for (java.lang.String name : names) {
//            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_2(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
         for (java.lang.String name : names) {
//            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_3(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
         for (java.lang.String name : names) {
//            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_4(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
         for (java.lang.String name : names) {
//            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_5(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
         for (java.lang.String name : names) {
//            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_6(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
        for (String name : names) {
            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3379_7(String param0) throws java.io.IOException {
        TrueTypeFont full = new TTFParser().parse(param0);
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full);
        ttfSubsetter.add('A');
        ttfSubsetter.add(' ');
        ttfSubsetter.add('B');
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser().parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(4, subset.getNumberOfGlyphs());
        // assertEquals(0, subset.nameToGID(".notdef"));
        // assertEquals(1, subset.nameToGID("space"));
        // assertEquals(2, subset.nameToGID("A"));
        // assertEquals(3, subset.nameToGID("B"));
        String[] names = new String[]{ "A", "B", "space" };
        for (String name : names) {
            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));
        }
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