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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This will test the CMapParser implementation.
 */
// public class TestCMapParser extends TestCase
public class TestProzeGen_CMap_toCID_int_TestCMapParser_testIdentity {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined("Identity-H");
        assertEquals(65, cMap.toCID(param0), "Indentity-H CID 65");
        assertEquals(12345, cMap.toCID(param0), "Indentity-H CID 12345");
        assertEquals(0xffff, cMap.toCID(param0), "Indentity-H CID 0xFFFF");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_1(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined("Identity-H");
        assertEquals(65, cMap.toCID(param0), "Indentity-H CID 65");
        // assertEquals("Indentity-H CID 12345", 12345, cMap.toCID(12345));
        // assertEquals("Indentity-H CID 0xFFFF", 0xffff, cMap.toCID(0xffff));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_2(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined("Identity-H");
        // assertEquals("Indentity-H CID 65", 65, cMap.toCID(65));
        assertEquals(12345, cMap.toCID(param0), "Indentity-H CID 12345");
        // assertEquals("Indentity-H CID 0xFFFF", 0xffff, cMap.toCID(0xffff));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_3(int param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined("Identity-H");
        // assertEquals("Indentity-H CID 65", 65, cMap.toCID(65));
        // assertEquals("Indentity-H CID 12345", 12345, cMap.toCID(12345));
        assertEquals(0xffff, cMap.toCID(param0), "Indentity-H CID 0xFFFF");
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(12345),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(258),
        org.junit.jupiter.params.provider.Arguments.of(271),
        org.junit.jupiter.params.provider.Arguments.of(272),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(280),
        org.junit.jupiter.params.provider.Arguments.of(282),
        org.junit.jupiter.params.provider.Arguments.of(286),
        org.junit.jupiter.params.provider.Arguments.of(296),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(300),
        org.junit.jupiter.params.provider.Arguments.of(336),
        org.junit.jupiter.params.provider.Arguments.of(346),
        org.junit.jupiter.params.provider.Arguments.of(349),
        org.junit.jupiter.params.provider.Arguments.of(367),
        org.junit.jupiter.params.provider.Arguments.of(373),
        org.junit.jupiter.params.provider.Arguments.of(374),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(381),
        org.junit.jupiter.params.provider.Arguments.of(393),
        org.junit.jupiter.params.provider.Arguments.of(396),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(400),
        org.junit.jupiter.params.provider.Arguments.of(410),
        org.junit.jupiter.params.provider.Arguments.of(437),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(448),
        org.junit.jupiter.params.provider.Arguments.of(449),
        org.junit.jupiter.params.provider.Arguments.of(455),
        org.junit.jupiter.params.provider.Arguments.of(460),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(514),
        org.junit.jupiter.params.provider.Arguments.of(520),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(65),
        org.junit.jupiter.params.provider.Arguments.of(65535),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(854),
        org.junit.jupiter.params.provider.Arguments.of(856),
        org.junit.jupiter.params.provider.Arguments.of(859),
        org.junit.jupiter.params.provider.Arguments.of(862),
        org.junit.jupiter.params.provider.Arguments.of(863),
        org.junit.jupiter.params.provider.Arguments.of(884),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(94)
        );
    }
}