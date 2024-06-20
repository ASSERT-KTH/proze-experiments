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
public class TestProzeGen_CMapParser_parsePredefined_java_lang_String_TestCMapParser_testIdentity {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity(String param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined(param0);
        assertEquals(65, cMap.toCID(65), "Indentity-H CID 65");
        assertEquals(12345, cMap.toCID(12345), "Indentity-H CID 12345");
        assertEquals(0xffff, cMap.toCID(0xffff), "Indentity-H CID 0xFFFF");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_1(String param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined(param0);
        assertEquals(65, cMap.toCID(65), "Indentity-H CID 65");
        // assertEquals("Indentity-H CID 12345", 12345, cMap.toCID(12345));
        // assertEquals("Indentity-H CID 0xFFFF", 0xffff, cMap.toCID(0xffff));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_2(String param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined(param0);
        // assertEquals("Indentity-H CID 65", 65, cMap.toCID(65));
        assertEquals(12345, cMap.toCID(12345), "Indentity-H CID 12345");
        // assertEquals("Indentity-H CID 0xFFFF", 0xffff, cMap.toCID(0xffff));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIdentity_3(String param0) throws java.io.IOException {
        CMap cMap = new CMapParser().parsePredefined(param0);
        // assertEquals("Indentity-H CID 65", 65, cMap.toCID(65));
        // assertEquals("Indentity-H CID 12345", 12345, cMap.toCID(12345));
        assertEquals(0xffff, cMap.toCID(0xffff), "Indentity-H CID 0xFFFF");
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("Adobe-Japan1-6"),
        org.junit.jupiter.params.provider.Arguments.of("Adobe-Japan1-UCS2"),
        org.junit.jupiter.params.provider.Arguments.of("Adobe-Korea1-UCS2"),
        org.junit.jupiter.params.provider.Arguments.of("Identity-H"),
        org.junit.jupiter.params.provider.Arguments.of("Identity-V"),
        org.junit.jupiter.params.provider.Arguments.of("UniJIS-UCS2-H")
        );
    }
}