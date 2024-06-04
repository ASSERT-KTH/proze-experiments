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

public class TestProzeGen_XMPSchema_getUnqualifiedTextProperty_java_lang_String_XMPSchemaTest_testSpecifiedSimplePropertyFormer {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSpecifiedSimplePropertyFormer(String param0) throws Exception {
        String prop = "testprop";
        String val = "value";
        String val2 = "value2";
        schem.setTextPropertyValueAsSimple(prop, val);
        org.apache.xmpbox.type.TextType text = schem.getMetadata().getTypeMapping().createText(null, schem.getPrefix(), prop, "value2");
        schem.setTextProperty(text);
        assertEquals(val2, schem.getUnqualifiedTextPropertyValue(prop));
        assertEquals(text, schem.getUnqualifiedTextProperty(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSpecifiedSimplePropertyFormer_1(String param0) throws Exception {
        String prop = "testprop";
        String val = "value";
        String val2 = "value2";
        schem.setTextPropertyValueAsSimple(prop, val);
        org.apache.xmpbox.type.TextType text = schem.getMetadata().getTypeMapping().createText(null, schem.getPrefix(), prop, "value2");
        schem.setTextProperty(text);
        assertEquals(val2, schem.getUnqualifiedTextPropertyValue(prop));
        // assertEquals(text, schem.getUnqualifiedTextProperty(prop));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSpecifiedSimplePropertyFormer_2(String param0) throws Exception {
        String prop = "testprop";
        String val = "value";
        String val2 = "value2";
        schem.setTextPropertyValueAsSimple(prop, val);
        org.apache.xmpbox.type.TextType text = schem.getMetadata().getTypeMapping().createText(null, schem.getPrefix(), prop, "value2");
        schem.setTextProperty(text);
        // assertEquals(val2, schem.getUnqualifiedTextPropertyValue(prop));
        assertEquals(text, schem.getUnqualifiedTextProperty(param0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("testprop"),
        org.junit.jupiter.params.provider.Arguments.of("textProp"),
        org.junit.jupiter.params.provider.Arguments.of("textType"),
                org.junit.jupiter.params.provider.Arguments.of("intType")
        );
    }
}