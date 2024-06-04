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
package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_Attribute_init_AttributeTest_testAtt {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        assertEquals(nsUri, att.getNamespace());
        assertEquals(localName, att.getName());
        assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        assertEquals(nsUri2, att.getNamespace());
        assertEquals(localName2, att.getName());
        assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_1(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        assertEquals(nsUri, att.getNamespace());
        // assertEquals(localName, att.getName());
        // assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        // assertEquals(nsUri2, att.getNamespace());
        // assertEquals(localName2, att.getName());
        // assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_2(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        // assertEquals(nsUri, att.getNamespace());
        assertEquals(localName, att.getName());
        // assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        // assertEquals(nsUri2, att.getNamespace());
        // assertEquals(localName2, att.getName());
        // assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_3(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        // assertEquals(nsUri, att.getNamespace());
        // assertEquals(localName, att.getName());
        assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        // assertEquals(nsUri2, att.getNamespace());
        // assertEquals(localName2, att.getName());
        // assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_4(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        // assertEquals(nsUri, att.getNamespace());
        // assertEquals(localName, att.getName());
        // assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        assertEquals(nsUri2, att.getNamespace());
        // assertEquals(localName2, att.getName());
        // assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_5(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        // assertEquals(nsUri, att.getNamespace());
        // assertEquals(localName, att.getName());
        // assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        // assertEquals(nsUri2, att.getNamespace());
        assertEquals(localName2, att.getName());
        // assertEquals(value2, att.getValue());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAtt_6(String param0, String param1, String param2) {
        String nsUri = "nsUri";
        String prefix = "prefix";
        String localName = "localName";
        String value = "value";
        Attribute att = new Attribute(param0, param1, param2);
        // assertEquals(nsUri, att.getNamespace());
        // assertEquals(localName, att.getName());
        // assertEquals(value, att.getValue());
        String nsUri2 = "nsUri2";
        String prefix2 = "prefix2";
        String localName2 = "localName2";
        String value2 = "value2";
        att.setNsURI(nsUri2);
        att.setName(localName2);
        att.setValue(value2);
        // assertEquals(nsUri2, att.getNamespace());
        // assertEquals(localName2, att.getName());
        assertEquals(value2, att.getValue());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("http://www.tefst2.org/test/", "value2", "StringValue.2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/test/", "value1", "StringValue1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/test/", "value2", "StringValue2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test2.org/test/", "value2", "StringValueTwo"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "about", ""),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "about", "YEP"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "parseType", "Resource"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "test", "vgh"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "DocumentID", "e7127190-445c-11ea-0000-b3bc74086807"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "Producer", "GPL Ghostscript 8.64"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "conformance", "B"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "format", "application/pdf"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "lang", "fr-FR"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "lang", "x-default"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.w3.org/XML/1998/namespace", "part", "1"),
        org.junit.jupiter.params.provider.Arguments.of("nsUri", "localName", "value")
        );
    }
}