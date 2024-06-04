/**
 * ***************************************************************************
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * *************************************************************************
 */
package org.apache.xmpbox.schema;

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_XMPSchema_setAboutAsSimple_java_lang_String_XMPSchemaTest_rdfAboutTest {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void rdfAboutTest(String param0) {
        assertEquals("", schem.getAboutValue());
        String about = "about";
        schem.setAboutAsSimple(param0);
        assertEquals(about, schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        assertEquals("", schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        assertEquals("", schem.getAboutValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void rdfAboutTest_1(String param0) {
        assertEquals("", schem.getAboutValue());
        String about = "about";
        schem.setAboutAsSimple(param0);
        // assertEquals(about, schem.getAboutValue());
        schem.setAboutAsSimple(param0);
//        assertEquals("", schem.getAboutValue());
        schem.setAboutAsSimple(param0);
//        assertEquals("", schem.getAboutValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void rdfAboutTest_2(String param0) {
        // assertEquals("", schem.getAboutValue());
        String about = "about";
        schem.setAboutAsSimple(param0);
        assertEquals(about, schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        // assertEquals("", schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        // assertEquals("", schem.getAboutValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void rdfAboutTest_3(String param0) {
//        assertEquals("", schem.getAboutValue());
        String about = "about";
        schem.setAboutAsSimple(param0);
        // assertEquals(about, schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        assertEquals("", schem.getAboutValue());
        schem.setAboutAsSimple(param0);
//        assertEquals("", schem.getAboutValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void rdfAboutTest_4(String param0) {
//        assertEquals("", schem.getAboutValue());
        String about = "about";
        schem.setAboutAsSimple(param0);
        // assertEquals(about, schem.getAboutValue());
        schem.setAboutAsSimple(param0);
//        assertEquals("", schem.getAboutValue());
        schem.setAboutAsSimple(param0);
        assertEquals("", schem.getAboutValue());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(""),
        org.junit.jupiter.params.provider.Arguments.of("about"),
        org.junit.jupiter.params.provider.Arguments.of("aboutTest")
        );
    }
}