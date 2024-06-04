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
public class TestProzeGen_HorizontalMetricsTable_getLeftSideBearing_int_TTFSubsetterTest_testPDFBox3319 {
    /**
     * Test of PDFBOX-3319: check that widths and left side bearings in partially monospaced font
     * are kept.
     *
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319(int param0) throws java.io.IOException {
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
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(param0), subset.getHorizontalMetrics().getLeftSideBearing(param0));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319_1(int param0) throws java.io.IOException {
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
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
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
    public void testPDFBox3319_2(int param0) throws java.io.IOException {
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
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
//            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(param0), subset.getHorizontalMetrics().getLeftSideBearing(param0));
        }
        subset.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3319_3(int param0) throws java.io.IOException {
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
        TrueTypeFont subset = new TTFParser(true).parse(new java.io.ByteArrayInputStream(baos.toByteArray()));
        // assertEquals(6, subset.getNumberOfGlyphs());
        for (java.util.Map.Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {
            Integer newGID = entry.getKey();
            Integer oldGID = entry.getValue();
//            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));
            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(param0), subset.getHorizontalMetrics().getLeftSideBearing(param0));
        }
        subset.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(1004),
        org.junit.jupiter.params.provider.Arguments.of(1005),
        org.junit.jupiter.params.provider.Arguments.of(1006),
        org.junit.jupiter.params.provider.Arguments.of(1007),
        org.junit.jupiter.params.provider.Arguments.of(1008),
        org.junit.jupiter.params.provider.Arguments.of(1009),
        org.junit.jupiter.params.provider.Arguments.of(1010),
        org.junit.jupiter.params.provider.Arguments.of(1011),
        org.junit.jupiter.params.provider.Arguments.of(1012),
        org.junit.jupiter.params.provider.Arguments.of(1013),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(105),
        org.junit.jupiter.params.provider.Arguments.of(1089),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(112),
        org.junit.jupiter.params.provider.Arguments.of(115),
        org.junit.jupiter.params.provider.Arguments.of(116),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(121),
        org.junit.jupiter.params.provider.Arguments.of(122),
        org.junit.jupiter.params.provider.Arguments.of(126),
        org.junit.jupiter.params.provider.Arguments.of(127),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(131),
        org.junit.jupiter.params.provider.Arguments.of(132),
        org.junit.jupiter.params.provider.Arguments.of(133),
        org.junit.jupiter.params.provider.Arguments.of(134),
        org.junit.jupiter.params.provider.Arguments.of(135),
        org.junit.jupiter.params.provider.Arguments.of(136),
        org.junit.jupiter.params.provider.Arguments.of(137),
        org.junit.jupiter.params.provider.Arguments.of(138),
        org.junit.jupiter.params.provider.Arguments.of(139),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(141),
        org.junit.jupiter.params.provider.Arguments.of(142),
        org.junit.jupiter.params.provider.Arguments.of(143),
        org.junit.jupiter.params.provider.Arguments.of(144),
        org.junit.jupiter.params.provider.Arguments.of(145),
        org.junit.jupiter.params.provider.Arguments.of(146),
        org.junit.jupiter.params.provider.Arguments.of(148),
        org.junit.jupiter.params.provider.Arguments.of(149),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(150),
        org.junit.jupiter.params.provider.Arguments.of(151),
        org.junit.jupiter.params.provider.Arguments.of(152),
        org.junit.jupiter.params.provider.Arguments.of(155),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(177),
        org.junit.jupiter.params.provider.Arguments.of(179),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(180),
        org.junit.jupiter.params.provider.Arguments.of(182),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(196),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(2015),
        org.junit.jupiter.params.provider.Arguments.of(2021),
        org.junit.jupiter.params.provider.Arguments.of(2024),
        org.junit.jupiter.params.provider.Arguments.of(2025),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(213),
        org.junit.jupiter.params.provider.Arguments.of(219),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(223),
        org.junit.jupiter.params.provider.Arguments.of(227),
        org.junit.jupiter.params.provider.Arguments.of(229),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(234),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(253),
        org.junit.jupiter.params.provider.Arguments.of(254),
        org.junit.jupiter.params.provider.Arguments.of(258),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(268),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(271),
        org.junit.jupiter.params.provider.Arguments.of(272),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(282),
        org.junit.jupiter.params.provider.Arguments.of(284),
        org.junit.jupiter.params.provider.Arguments.of(286),
        org.junit.jupiter.params.provider.Arguments.of(29),
        org.junit.jupiter.params.provider.Arguments.of(292),
        org.junit.jupiter.params.provider.Arguments.of(296),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(30),
        org.junit.jupiter.params.provider.Arguments.of(336),
        org.junit.jupiter.params.provider.Arguments.of(34),
        org.junit.jupiter.params.provider.Arguments.of(346),
        org.junit.jupiter.params.provider.Arguments.of(349),
        org.junit.jupiter.params.provider.Arguments.of(35),
        org.junit.jupiter.params.provider.Arguments.of(36),
        org.junit.jupiter.params.provider.Arguments.of(361),
        org.junit.jupiter.params.provider.Arguments.of(364),
        org.junit.jupiter.params.provider.Arguments.of(367),
        org.junit.jupiter.params.provider.Arguments.of(37),
        org.junit.jupiter.params.provider.Arguments.of(373),
        org.junit.jupiter.params.provider.Arguments.of(374),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(381),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(393),
        org.junit.jupiter.params.provider.Arguments.of(395),
        org.junit.jupiter.params.provider.Arguments.of(396),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(40),
        org.junit.jupiter.params.provider.Arguments.of(400),
        org.junit.jupiter.params.provider.Arguments.of(41),
        org.junit.jupiter.params.provider.Arguments.of(410),
        org.junit.jupiter.params.provider.Arguments.of(42),
        org.junit.jupiter.params.provider.Arguments.of(43),
        org.junit.jupiter.params.provider.Arguments.of(437),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(448),
        org.junit.jupiter.params.provider.Arguments.of(449),
        org.junit.jupiter.params.provider.Arguments.of(45),
        org.junit.jupiter.params.provider.Arguments.of(454),
        org.junit.jupiter.params.provider.Arguments.of(455),
        org.junit.jupiter.params.provider.Arguments.of(46),
        org.junit.jupiter.params.provider.Arguments.of(460),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(48),
        org.junit.jupiter.params.provider.Arguments.of(481),
        org.junit.jupiter.params.provider.Arguments.of(483),
        org.junit.jupiter.params.provider.Arguments.of(484),
        org.junit.jupiter.params.provider.Arguments.of(486),
        org.junit.jupiter.params.provider.Arguments.of(49),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(50),
        org.junit.jupiter.params.provider.Arguments.of(51),
        org.junit.jupiter.params.provider.Arguments.of(514),
        org.junit.jupiter.params.provider.Arguments.of(52),
        org.junit.jupiter.params.provider.Arguments.of(523),
        org.junit.jupiter.params.provider.Arguments.of(524),
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
        org.junit.jupiter.params.provider.Arguments.of(845),
        org.junit.jupiter.params.provider.Arguments.of(85),
        org.junit.jupiter.params.provider.Arguments.of(853),
        org.junit.jupiter.params.provider.Arguments.of(854),
        org.junit.jupiter.params.provider.Arguments.of(855),
        org.junit.jupiter.params.provider.Arguments.of(856),
        org.junit.jupiter.params.provider.Arguments.of(859),
        org.junit.jupiter.params.provider.Arguments.of(86),
        org.junit.jupiter.params.provider.Arguments.of(862),
        org.junit.jupiter.params.provider.Arguments.of(863),
        org.junit.jupiter.params.provider.Arguments.of(87),
        org.junit.jupiter.params.provider.Arguments.of(876),
        org.junit.jupiter.params.provider.Arguments.of(88),
        org.junit.jupiter.params.provider.Arguments.of(882),
        org.junit.jupiter.params.provider.Arguments.of(884),
        org.junit.jupiter.params.provider.Arguments.of(885),
        org.junit.jupiter.params.provider.Arguments.of(886),
        org.junit.jupiter.params.provider.Arguments.of(887),
        org.junit.jupiter.params.provider.Arguments.of(888),
        org.junit.jupiter.params.provider.Arguments.of(889),
        org.junit.jupiter.params.provider.Arguments.of(89),
        org.junit.jupiter.params.provider.Arguments.of(890),
        org.junit.jupiter.params.provider.Arguments.of(894),
        org.junit.jupiter.params.provider.Arguments.of(895),
        org.junit.jupiter.params.provider.Arguments.of(9),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(91),
        org.junit.jupiter.params.provider.Arguments.of(92),
        org.junit.jupiter.params.provider.Arguments.of(93),
        org.junit.jupiter.params.provider.Arguments.of(94),
        org.junit.jupiter.params.provider.Arguments.of(95),
        org.junit.jupiter.params.provider.Arguments.of(970),
        org.junit.jupiter.params.provider.Arguments.of(972)
        );
    }
}