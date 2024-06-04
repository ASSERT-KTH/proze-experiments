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

import static org.junit.jupiter.api.Assertions.*;

public class TestProzeGen_XMPSchema_getUnqualifiedLanguagePropertyValue_java_lang_String_java_lang_String_XMPSchemaTest_testAltProperties {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        assertEquals(defaultLang, languages.get(0));
        assertTrue(languages.contains(usLang));
        assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_1(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_2(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_3(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_4(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_5(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_6(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_7(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
//        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAltProperties_8(String param0, String param1) throws Exception {
        String altProp = "AltProp";
        String defaultLang = "x-default";
        String defaultVal = "Default Language";
        String usLang = "en-us";
        String usVal = "American Language";
        String frLang = "fr-fr";
        String frVal = "Lang française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, usLang, usVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, defaultLang, defaultVal);
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(defaultVal, schem.getUnqualifiedLanguagePropertyValue(altProp, defaultLang));
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        // assertEquals(usVal, schem.getUnqualifiedLanguagePropertyValue(altProp, usLang));
        java.util.List<String> languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        // assertEquals(defaultLang, languages.get(0));
        // assertTrue(languages.contains(usLang));
        // assertTrue(languages.contains(frLang));
        frVal = "Langue française";
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
        // assertEquals(frVal, schem.getUnqualifiedLanguagePropertyValue(altProp, frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, null);
        languages = schem.getUnqualifiedLanguagePropertyLanguagesValue(altProp);
        assertFalse(languages.contains(frLang));
        schem.setUnqualifiedLanguagePropertyValue(altProp, frLang, frVal);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("AltProp", "en-us"),
        org.junit.jupiter.params.provider.Arguments.of("AltProp", "fr-fr"),
        org.junit.jupiter.params.provider.Arguments.of("AltProp", "x-default"),
        org.junit.jupiter.params.provider.Arguments.of("UsageTerms", "en"),
        org.junit.jupiter.params.provider.Arguments.of("UsageTerms", "fr"),
        org.junit.jupiter.params.provider.Arguments.of("langprop", "x-default"),
        org.junit.jupiter.params.provider.Arguments.of("title", null)
        );
    }
}