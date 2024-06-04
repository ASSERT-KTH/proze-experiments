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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProzeGen_TypeMapping_createBoolean_java_lang_String_java_lang_String_java_lang_String_boolean_XMPSchemaTest_testListAndContainerAccessor {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor(String param0, String param1, String param2, boolean param3) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(param0, param1, param2, param3);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        assertEquals(schem.getAllProperties(), schem.getAllProperties());
        assertTrue(schem.getAllProperties().contains(bool));
        assertTrue(schem.getAllAttributes().contains(att));
        assertEquals(bool, schem.getProperty(boolname));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor_1(String param0, String param1, String param2, boolean param3) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(param0, param1, param2, param3);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        assertEquals(schem.getAllProperties(), schem.getAllProperties());
        // assertTrue(schem.getAllProperties().contains(bool));
        // assertTrue(schem.getAllAttributes().contains(att));
        // assertEquals(bool, schem.getProperty(boolname));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor_2(String param0, String param1, String param2, boolean param3) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(param0, param1, param2, param3);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        // assertEquals(schem.getAllProperties(), schem.getAllProperties());
        assertTrue(schem.getAllProperties().contains(bool));
        // assertTrue(schem.getAllAttributes().contains(att));
        // assertEquals(bool, schem.getProperty(boolname));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor_3(String param0, String param1, String param2, boolean param3) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(param0, param1, param2, param3);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        // assertEquals(schem.getAllProperties(), schem.getAllProperties());
        // assertTrue(schem.getAllProperties().contains(bool));
        assertTrue(schem.getAllAttributes().contains(att));
        // assertEquals(bool, schem.getProperty(boolname));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor_4(String param0, String param1, String param2, boolean param3) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(param0, param1, param2, param3);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        // assertEquals(schem.getAllProperties(), schem.getAllProperties());
        // assertTrue(schem.getAllProperties().contains(bool));
        // assertTrue(schem.getAllAttributes().contains(att));
        assertEquals(bool, schem.getProperty(boolname));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(null, "nsSchem", "bool", true),
        org.junit.jupiter.params.provider.Arguments.of(null, "nsSchem", "boolType", false),
        org.junit.jupiter.params.provider.Arguments.of(null, "rdf", "li", true),
        org.junit.jupiter.params.provider.Arguments.of(null, "test", "boolean", true),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/pdfa/", "test", "boolean", true)
        );
    }
}