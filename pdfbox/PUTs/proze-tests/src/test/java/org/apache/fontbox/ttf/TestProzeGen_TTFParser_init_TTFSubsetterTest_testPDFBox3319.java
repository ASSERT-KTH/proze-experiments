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
public class TestProzeGen_TTFParser_init_TTFSubsetterTest_testPDFBox3319 {
    /**
     * Test of PDFBOX-3319: check that widths and left side bearings in partially monospaced font
     * are kept.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319(boolean param0) throws java.io.IOException {
        System.out.println("Searching for SimHei font...");
        org.apache.fontbox.util.autodetect.FontFileFinder fontFileFinder = new org.apache.fontbox.util.autodetect.FontFileFinder();
        java.util.List<java.net.URI> files = fontFileFinder.find();
        java.io.File simhei = null;
        for (java.net.URI uri : files) {
            if ((uri.getPath() != null) && uri.getPath().toLowerCase(java.util.Locale.US).endsWith("simhei.ttf")) {
                simhei = new java.io.File(uri);
            }
        }
        if (simhei == null) {
            System.err.println("SimHei font not available on this machine, test skipped");
            return;
        }
        System.out.println("SimHei font found!");
        TrueTypeFont full = new TTFParser().parse(simhei);
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
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full, tables);
        String chinese = "中国你好!";
        for (int offset = 0; offset < chinese.length();) {
            int codePoint = chinese.codePointAt(offset);
            ttfSubsetter.add(codePoint);
            offset += Character.charCount(codePoint);
        }
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(oldGID), subset.getHorizontalMetrics().getLeftSideBearing(newGID));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319_1(boolean param0) throws java.io.IOException {
        System.out.println("Searching for SimHei font...");
        org.apache.fontbox.util.autodetect.FontFileFinder fontFileFinder = new org.apache.fontbox.util.autodetect.FontFileFinder();
        java.util.List<java.net.URI> files = fontFileFinder.find();
        java.io.File simhei = null;
        for (java.net.URI uri : files) {
            if ((uri.getPath() != null) && uri.getPath().toLowerCase(java.util.Locale.US).endsWith("simhei.ttf")) {
                simhei = new java.io.File(uri);
            }
        }
        if (simhei == null) {
            System.err.println("SimHei font not available on this machine, test skipped");
            return;
        }
        System.out.println("SimHei font found!");
        TrueTypeFont full = new TTFParser().parse(simhei);
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
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full, tables);
        String chinese = "中国你好!";
        for (int offset = 0; offset < chinese.length();) {
            int codePoint = chinese.codePointAt(offset);
            ttfSubsetter.add(codePoint);
            offset += Character.charCount(codePoint);
        }
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(6, subset.getNumberOfGlyphs());
         for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
//            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(oldGID), subset.getHorizontalMetrics().getLeftSideBearing(newGID));
        };
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319_2(boolean param0) throws java.io.IOException {
        System.out.println("Searching for SimHei font...");
        org.apache.fontbox.util.autodetect.FontFileFinder fontFileFinder = new org.apache.fontbox.util.autodetect.FontFileFinder();
        java.util.List<java.net.URI> files = fontFileFinder.find();
        java.io.File simhei = null;
        for (java.net.URI uri : files) {
            if ((uri.getPath() != null) && uri.getPath().toLowerCase(java.util.Locale.US).endsWith("simhei.ttf")) {
                simhei = new java.io.File(uri);
            }
        }
        if (simhei == null) {
            System.err.println("SimHei font not available on this machine, test skipped");
            return;
        }
        System.out.println("SimHei font found!");
        TrueTypeFont full = new TTFParser().parse(simhei);
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
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full, tables);
        String chinese = "中国你好!";
        for (int offset = 0; offset < chinese.length();) {
            int codePoint = chinese.codePointAt(offset);
            ttfSubsetter.add(codePoint);
            offset += Character.charCount(codePoint);
        }
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(oldGID), subset.getHorizontalMetrics().getLeftSideBearing(newGID));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319_3(boolean param0) throws java.io.IOException {
        System.out.println("Searching for SimHei font...");
        org.apache.fontbox.util.autodetect.FontFileFinder fontFileFinder = new org.apache.fontbox.util.autodetect.FontFileFinder();
        java.util.List<java.net.URI> files = fontFileFinder.find();
        java.io.File simhei = null;
        for (java.net.URI uri : files) {
            if ((uri.getPath() != null) && uri.getPath().toLowerCase(java.util.Locale.US).endsWith("simhei.ttf")) {
                simhei = new java.io.File(uri);
            }
        }
        if (simhei == null) {
            System.err.println("SimHei font not available on this machine, test skipped");
            return;
        }
        System.out.println("SimHei font found!");
        TrueTypeFont full = new TTFParser().parse(simhei);
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
        TTFSubsetter ttfSubsetter = new TTFSubsetter(full, tables);
        String chinese = "中国你好!";
        for (int offset = 0; offset < chinese.length();) {
            int codePoint = chinese.codePointAt(offset);
            ttfSubsetter.add(codePoint);
            offset += Character.charCount(codePoint);
        }
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ttfSubsetter.writeToStream(baos);
        TrueTypeFont subset = new TTFParser(param0).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
//            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(oldGID), subset.getHorizontalMetrics().getLeftSideBearing(newGID));
        }
        subset.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(false),
        org.junit.jupiter.params.provider.Arguments.of(true)
        );
    }
}