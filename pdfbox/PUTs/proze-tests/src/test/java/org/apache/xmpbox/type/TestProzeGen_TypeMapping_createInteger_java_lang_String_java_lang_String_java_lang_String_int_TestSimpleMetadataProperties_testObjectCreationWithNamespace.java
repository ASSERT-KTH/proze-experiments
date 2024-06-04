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

/**
 * Test MetaData Objects for simple properties
 *
 * @author a183132
 */
public class TestProzeGen_TypeMapping_createInteger_java_lang_String_java_lang_String_java_lang_String_int_TestSimpleMetadataProperties_testObjectCreationWithNamespace {
    protected org.apache.xmpbox.XMPMetadata parent;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
    }

    /**
     * Check creation when a namespace is specified
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        assertEquals(ns, bool.getNamespace());
        assertEquals(ns, date.getNamespace());
        assertEquals(ns, integer.getNamespace());
        assertEquals(ns, real.getNamespace());
        assertEquals(ns, text.getNamespace());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace_1(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        assertEquals(ns, bool.getNamespace());
        // assertEquals(ns, date.getNamespace());
        // assertEquals(ns, integer.getNamespace());
        // assertEquals(ns, real.getNamespace());
        // assertEquals(ns, text.getNamespace());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace_2(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        // assertEquals(ns, bool.getNamespace());
        assertEquals(ns, date.getNamespace());
        // assertEquals(ns, integer.getNamespace());
        // assertEquals(ns, real.getNamespace());
        // assertEquals(ns, text.getNamespace());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace_3(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        // assertEquals(ns, bool.getNamespace());
        // assertEquals(ns, date.getNamespace());
        assertEquals(ns, integer.getNamespace());
        // assertEquals(ns, real.getNamespace());
        // assertEquals(ns, text.getNamespace());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace_4(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        // assertEquals(ns, bool.getNamespace());
        // assertEquals(ns, date.getNamespace());
        // assertEquals(ns, integer.getNamespace());
        assertEquals(ns, real.getNamespace());
        // assertEquals(ns, text.getNamespace());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testObjectCreationWithNamespace_5(String param0, String param1, String param2, int param3) throws Exception {
        String ns = "http://www.test.org/pdfa/";
        BooleanType bool = parent.getTypeMapping().createBoolean(ns, "test", "boolean", true);
        DateType date = parent.getTypeMapping().createDate(ns, "test", "date", java.util.Calendar.getInstance());
        IntegerType integer = parent.getTypeMapping().createInteger(param0, param1, param2, param3);
        RealType real = parent.getTypeMapping().createReal(ns, "test", "real", ((float) (1.6)));
        TextType text = parent.getTypeMapping().createText(ns, "test", "text", "TEST");
        // assertEquals(ns, bool.getNamespace());
        // assertEquals(ns, date.getNamespace());
        // assertEquals(ns, integer.getNamespace());
        // assertEquals(ns, real.getNamespace());
        assertEquals(ns, text.getNamespace());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(null, "nsSchem", "intType", 5),
        org.junit.jupiter.params.provider.Arguments.of(null, "test", "integer", 1),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/exif/1.0/", "exif", "Columns", 14),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/pdfa/", "test", "integer", 1)
        );
    }
}