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
package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This will test the CMapParser implementation.
 */
// public class TestCMapParser extends TestCase
public class TestProzeGen_CMap_toUnicode_int_TestCMapParser_testParserWithMalformedbfrange2 {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        assertNotNull(cMap, "Failed to parse malformed CMap file");
        assertEquals( "0", cMap.toUnicode(param0), "bytes 00 01 from bfrange <0001> <0009> <0030>");
        assertEquals("A", cMap.toUnicode(param0), "bytes 02 32 from bfrange <0232> <0432> <0041>");
        assertNotNull(cMap.toUnicode(param0));
        assertNotNull(cMap.toUnicode(param0));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        assertNotNull(cMap.toUnicode(param0));
        assertNull(cMap.toUnicode(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_1(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        assertNotNull(cMap, "Failed to parse malformed CMap file");
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_2(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        assertEquals( "0", cMap.toUnicode(param0), "bytes 00 01 from bfrange <0001> <0009> <0030>");
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_3(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        assertEquals( "A", cMap.toUnicode(param0), "bytes 02 32 from bfrange <0232> <0432> <0041>");
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_4(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
        assertNotNull(cMap.toUnicode(param0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
//        assertNotNull(cMap.toUnicode(param0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_5(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
        // assertNotNull(cMap.toUnicode(0x2f0));
        assertNotNull(cMap.toUnicode(param0));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_6(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
//        assertNotNull(cMap.toUnicode(param0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        assertNotNull(cMap.toUnicode(param0));
        // assertNull(cMap.toUnicode(0x2f1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParserWithMalformedbfrange2_7(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull("Failed to parse malformed CMap file", cMap);
        // assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x1));
        // assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));
        // assertNotNull(cMap.toUnicode(0x2f0));
        // assertNotNull(cMap.toUnicode(0x2f1));
        cMap = new CMapParser(true).parse(new java.io.File("src/test/resources/cmap", "CMapMalformedbfrange2"));
        // assertNotNull(cMap.toUnicode(0x2f0));
        assertNull(cMap.toUnicode(param0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(12345),
        org.junit.jupiter.params.provider.Arguments.of(12543),
        org.junit.jupiter.params.provider.Arguments.of(12544),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(200),
        org.junit.jupiter.params.provider.Arguments.of(256),
        org.junit.jupiter.params.provider.Arguments.of(258),
        org.junit.jupiter.params.provider.Arguments.of(266),
        org.junit.jupiter.params.provider.Arguments.of(271),
        org.junit.jupiter.params.provider.Arguments.of(272),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(282),
        org.junit.jupiter.params.provider.Arguments.of(286),
        org.junit.jupiter.params.provider.Arguments.of(288),
        org.junit.jupiter.params.provider.Arguments.of(289),
        org.junit.jupiter.params.provider.Arguments.of(296),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(336),
        org.junit.jupiter.params.provider.Arguments.of(346),
        org.junit.jupiter.params.provider.Arguments.of(349),
        org.junit.jupiter.params.provider.Arguments.of(364),
        org.junit.jupiter.params.provider.Arguments.of(367),
        org.junit.jupiter.params.provider.Arguments.of(373),
        org.junit.jupiter.params.provider.Arguments.of(374),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(381),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(393),
        org.junit.jupiter.params.provider.Arguments.of(396),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(400),
        org.junit.jupiter.params.provider.Arguments.of(410),
        org.junit.jupiter.params.provider.Arguments.of(437),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(448),
        org.junit.jupiter.params.provider.Arguments.of(449),
        org.junit.jupiter.params.provider.Arguments.of(454),
        org.junit.jupiter.params.provider.Arguments.of(455),
        org.junit.jupiter.params.provider.Arguments.of(460),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(514),
        org.junit.jupiter.params.provider.Arguments.of(562),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(65535),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(72),
        org.junit.jupiter.params.provider.Arguments.of(75),
        org.junit.jupiter.params.provider.Arguments.of(752),
        org.junit.jupiter.params.provider.Arguments.of(753),
        org.junit.jupiter.params.provider.Arguments.of(853),
        org.junit.jupiter.params.provider.Arguments.of(854),
        org.junit.jupiter.params.provider.Arguments.of(856),
        org.junit.jupiter.params.provider.Arguments.of(859),
        org.junit.jupiter.params.provider.Arguments.of(862),
        org.junit.jupiter.params.provider.Arguments.of(863),
        org.junit.jupiter.params.provider.Arguments.of(884),
        org.junit.jupiter.params.provider.Arguments.of(894),
        org.junit.jupiter.params.provider.Arguments.of(895),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(94)
        );
    }
}