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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_XMPSchema_getUnqualifiedBagValueList_java_lang_String_XMPSchemaTest_testBagManagement {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    /**
     * Check if Bag (Unordered Array) management is ok
     *
     * @throws IllegalArgumentException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBagManagement(String param0) throws Exception {
        String bagName = "BAGTEST";
        String value1 = "valueOne";
        String value2 = "valueTwo";
        schem.addBagValue(bagName, schem.getMetadata().getTypeMapping().createText(null, "rdf", "li", value1));
        schem.addQualifiedBagValue(bagName, value2);
        java.util.List<String> values = schem.getUnqualifiedBagValueList(param0);
        assertEquals(value1, values.get(0));
        assertEquals(value2, values.get(1));
        schem.removeUnqualifiedBagValue(bagName, value1);
        java.util.List<String> values2 = schem.getUnqualifiedBagValueList(param0);
        assertEquals(1, values2.size());
        assertEquals(value2, values2.get(0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBagManagement_1(String param0) throws Exception {
        String bagName = "BAGTEST";
        String value1 = "valueOne";
        String value2 = "valueTwo";
        schem.addBagValue(bagName, schem.getMetadata().getTypeMapping().createText(null, "rdf", "li", value1));
        schem.addQualifiedBagValue(bagName, value2);
        java.util.List<String> values = schem.getUnqualifiedBagValueList(param0);
        assertEquals(value1, values.get(0));
        // assertEquals(value2, values.get(1));
        schem.removeUnqualifiedBagValue(bagName, value1);
        java.util.List<String> values2 = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(1, values2.size());
        // assertEquals(value2, values2.get(0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBagManagement_2(String param0) throws Exception {
        String bagName = "BAGTEST";
        String value1 = "valueOne";
        String value2 = "valueTwo";
        schem.addBagValue(bagName, schem.getMetadata().getTypeMapping().createText(null, "rdf", "li", value1));
        schem.addQualifiedBagValue(bagName, value2);
        java.util.List<String> values = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(value1, values.get(0));
        assertEquals(value2, values.get(1));
        schem.removeUnqualifiedBagValue(bagName, value1);
        java.util.List<String> values2 = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(1, values2.size());
        // assertEquals(value2, values2.get(0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBagManagement_3(String param0) throws Exception {
        String bagName = "BAGTEST";
        String value1 = "valueOne";
        String value2 = "valueTwo";
        schem.addBagValue(bagName, schem.getMetadata().getTypeMapping().createText(null, "rdf", "li", value1));
        schem.addQualifiedBagValue(bagName, value2);
        java.util.List<String> values = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(value1, values.get(0));
        // assertEquals(value2, values.get(1));
        schem.removeUnqualifiedBagValue(bagName, value1);
        java.util.List<String> values2 = schem.getUnqualifiedBagValueList(param0);
        assertEquals(1, values2.size());
        // assertEquals(value2, values2.get(0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBagManagement_4(String param0) throws Exception {
        String bagName = "BAGTEST";
        String value1 = "valueOne";
        String value2 = "valueTwo";
        schem.addBagValue(bagName, schem.getMetadata().getTypeMapping().createText(null, "rdf", "li", value1));
        schem.addQualifiedBagValue(bagName, value2);
        java.util.List<String> values = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(value1, values.get(0));
        // assertEquals(value2, values.get(1));
        schem.removeUnqualifiedBagValue(bagName, value1);
        java.util.List<String> values2 = schem.getUnqualifiedBagValueList(param0);
        // assertEquals(1, values2.size());
        assertEquals(value2, values2.get(0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("Advisory"),
        org.junit.jupiter.params.provider.Arguments.of("BAGTEST"),
        org.junit.jupiter.params.provider.Arguments.of("Identifier"),
        org.junit.jupiter.params.provider.Arguments.of("Ingredients"),
        org.junit.jupiter.params.provider.Arguments.of("Owner"),
        org.junit.jupiter.params.provider.Arguments.of("Versions"),
        org.junit.jupiter.params.provider.Arguments.of("bagName"),
        org.junit.jupiter.params.provider.Arguments.of("bagProp"),
        org.junit.jupiter.params.provider.Arguments.of("contributor"),
        org.junit.jupiter.params.provider.Arguments.of("language"),
        org.junit.jupiter.params.provider.Arguments.of("publisher"),
        org.junit.jupiter.params.provider.Arguments.of("relation"),
        org.junit.jupiter.params.provider.Arguments.of("subject"),
        org.junit.jupiter.params.provider.Arguments.of("type")
        );
    }
}