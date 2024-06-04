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
import org.apache.xmpbox.type.BadFieldValueException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProzeGen_TypeMapping_createText_java_lang_String_java_lang_String_java_lang_String_java_lang_String_XMPSchemaTest_testProperties {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    /**
     * Test All common simple properties management in XMPSchema
     *
     * @throws IllegalArgumentException
     * @throws BadFieldValueException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties(String param0, String param1, String param2, String param3) throws Exception {
        assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_1(String param0, String param1, String param2, String param3) throws Exception {
        assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_2(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_3(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_4(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_5(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_6(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_7(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_8(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_9(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_10(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_11(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        // assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_12(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_13(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testProperties_14(String param0, String param1, String param2, String param3) throws Exception {
        // assertEquals("nsURI", schem.getNamespace());
        schem.addNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        String aboutVal = "aboutTest";
        schem.setAboutAsSimple(aboutVal);
        // assertEquals(aboutVal, schem.getAboutValue());
        org.apache.xmpbox.type.Attribute about = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "about", "YEP");
        schem.setAbout(about);
        // assertEquals(about, schem.getAboutAttribute());
        String textProp = "textProp";
        String textPropVal = "TextPropTest";
        schem.setTextPropertyValue(textProp, textPropVal);
        // assertEquals(textPropVal, schem.getUnqualifiedTextPropertyValue(textProp));
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(param0, param1, param2, param3);
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        // assertEquals(dateType, schem.getDateProperty("dateType"));
        String bool = "nsSchem:booleanTestProp";
        Boolean boolVal = false;
        schem.setBooleanPropertyValue(bool, boolVal);
        // assertEquals(boolVal, schem.getBooleanPropertyValue(bool));
        org.apache.xmpbox.type.BooleanType boolType = parent.getTypeMapping().createBoolean(null, "nsSchem", "boolType", false);
        schem.setBooleanProperty(boolType);
        // assertEquals(boolType, schem.getBooleanProperty("boolType"));
        String intProp = "nsSchem:IntegerTestProp";
        Integer intPropVal = 5;
        schem.setIntegerPropertyValue(intProp, intPropVal);
        // assertEquals(intPropVal, schem.getIntegerPropertyValue(intProp));
        org.apache.xmpbox.type.IntegerType intType = parent.getTypeMapping().createInteger(null, "nsSchem", "intType", 5);
        schem.setIntegerProperty(intType);
        // assertEquals(intType, schem.getIntegerProperty("intType"));
        boolean ok = false;
        try {
            schem.getIntegerProperty("boolType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getUnqualifiedTextProperty("intType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
//        assertTrue(ok);
        ok = false;
        try {
            schem.getDateProperty("textType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        assertTrue(ok);
        ok = false;
        try {
            schem.getBooleanProperty("dateType");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(null, "nsSchem", "testprop", "value2"),
        org.junit.jupiter.params.provider.Arguments.of(null, "nsSchem", "textType", "GRINGO"),
        org.junit.jupiter.params.provider.Arguments.of(null, "pdf", "Keywords", "kw1 kw2 kw3"),
        org.junit.jupiter.params.provider.Arguments.of(null, "pdf", "PDFVersion", "1.4"),
        org.junit.jupiter.params.provider.Arguments.of(null, "pdf", "Producer", "testcase"),
        org.junit.jupiter.params.provider.Arguments.of(null, "pdfaid", "amd", "2005"),
        org.junit.jupiter.params.provider.Arguments.of(null, "pdfaid", "conformance", "B"),
        org.junit.jupiter.params.provider.Arguments.of(null, "rdf", "li", "valeur1"),
        org.junit.jupiter.params.provider.Arguments.of(null, "rdf", "li", "valeur2"),
        org.junit.jupiter.params.provider.Arguments.of(null, "rdf", "li", "valueOne"),
        org.junit.jupiter.params.provider.Arguments.of(null, "test", "simpleProperty", "YEP"),
        org.junit.jupiter.params.provider.Arguments.of(null, "test", "text", "TEXTCONTENT"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/pdf/1.3/", "pdf", "Keywords", "keywords ihih"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/pdf/1.3/", "pdf", "Keywords", "kw1 kw2 kw3"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/pdf/1.3/", "pdf", "PDFVersion", "1.4"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/pdf/1.3/", "pdf", "Producer", "producer"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/pdf/1.3/", "pdf", "Producer", "testcase"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-1190170906791206538"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-1196354142282609106"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-1348567761086932695"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-202794344369750853"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-2249964687613095135"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-244458886760681070"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-2628164541589179320"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-3216312171279505175"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-340361907532297356"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-4311638713915155743"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-4522991670864817619"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-4962768465676381896"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-5210152995441434909"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-5363494434240314477"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-5733106969560432212"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-607773862726288595"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-7161543070615504302"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-7389163565126097532"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-7608907635831063041"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-7741173486426683015"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-8001452389104390757"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-846147182680156500"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-8721744512256759029"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-8854145483064058925"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-9060256936861573999"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-9079271718673674089"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_-9153939890293236721"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_1764918724938744774"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_195870917213804349"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_3215756086476554383"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_3309585112540959789"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_352844271869063821"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_3608328132042144426"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_3666865995010835395"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_4128119277247214110"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_4403853902809241132"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_5363036084009068242"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_5751403247357802698"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6137188591007822636"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6445907778663155537"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6720123662701563665"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6959230021119356421"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6973620291621951390"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_6975799212844688755"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_7221016524385233889"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_7353099229195120813"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_7625833742628500402"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_7914569469690380829"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_8032606425891005712"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_876154657865971204"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerName", "Text_String_8942753471678124505"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-1220639146938437793"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-2177261062841423530"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-2545270698787760492"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-2878601394632152949"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-3175050628816258587"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-3419067527425617474"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-3639589092411609896"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4076506904733337357"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4096035293452057883"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4152026599103715220"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4357052510527275110"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4632769570221518808"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4718265784400963272"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4857211597820477264"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-4962768465676381896"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-5280204163237852520"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-5805046797583721138"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-5913987531737092777"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-6750511766592197129"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-677673494096496334"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-6904388557532637448"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-6985912244192972431"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-7013213496968037543"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-7139631865988364484"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-7901212797279311117"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-8099721640747576587"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-8181433248735608235"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-8847142944706012738"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_-993781943078286372"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_1422508220586299710"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_2039937750886604569"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_2693665700906835972"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_2771145036459328837"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_2822395889769524680"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_3455832030579311268"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_364260843899381458"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_3790500328820827913"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_3911777392713886630"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_4393158125505300138"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_4851444538841815734"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_4916618829031622055"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_4920631251756286720"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_4929676941166346156"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_6445764801220674682"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_6576698861419713829"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_6945052122655716214"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_7286750759523518245"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_7523541662705863534"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_8027023165327585277"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_8207976685053616381"),
        org.junit.jupiter.params.provider.Arguments.of("http://ns.adobe.com/photoshop/1.0/", "photoshop", "LayerText", "Text_String_8981979950407312386"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1050063012396143081"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1095126021618856829"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1129807464970911847"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1146225759968300386"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-122641405074325201"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1289869456984181525"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1299581855210072286"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1383817867029340713"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1467326996579834165"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1493521057674437289"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1499191953869661897"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1546123798850563013"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1562623214028879402"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-157061371952644666"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1577415214310942426"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1631481037288248118"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1657739215676926524"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1663251609209999663"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1724879092216197994"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-182988858125731975"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1852339425441943309"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1885020071224716333"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1887936929675865937"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1900772303935681369"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1939387118223338726"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1943587766938892793"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1949374130124859591"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-1998406999658571556"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2017523391635326598"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-204894070011301535"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2057159406708459040"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2065213823127397403"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2067261394808555486"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2076645228180496649"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2091027979763793714"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2091578115784479228"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2102737890241173365"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2106836249791210950"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2153756568927187280"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2174449875319289756"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2193787806834063369"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2213774514853417502"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2263699721918617436"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2278054280620416786"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2302236656138695682"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2323061384328256461"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2336879726603568242"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2337446602528395160"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2408006956144883229"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2409003043423000916"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-24157964672873318"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2441685322594929744"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2468750872006114596"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2480569008817337654"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2485844489563577572"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2509345806167387081"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2535570789986293969"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2539438959239451889"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2543200474341585551"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2565989277618584006"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-256605813721884170"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2568731851525148737"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2579987830768444747"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2635538937122388303"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2697069592259562950"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-276553793373454956"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2797304782525163236"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-2987736608769585871"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3007629020936134095"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3015674791693873780"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-30595409936194802"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3079028241403922160"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-31013836104608426"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3138899471111702031"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3159454432976967402"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3192116631329279993"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3245464750526397701"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3324430215779067459"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3367397968254851325"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3407319324895758876"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3416048088926864965"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3466638618472476051"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3517318722054838409"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3536095080820980268"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3575127020095079694"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3591800702202742937"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3599911034025141741"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3602561294723958043"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3611019928449678879"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3621158923511606962"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3629924765041704399"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-365412503883586313"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3680853694350614483"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-369244867834002178"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3716255918708822100"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3717697983365546718"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3722528292707667571"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3760280585015893463"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3803878342785276307"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-384911745054741468"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3856019469471580060"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3899140708052419488"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3937949451467893051"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3937971441321047161"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-393800732345577971"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3940573313309399211"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3944536452042790783"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-3990511837158226186"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4041861987210254037"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4072407490665205942"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4088964863957380234"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4101417259217371342"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4113759959591624140"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4147637244458010171"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4148842165819124460"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4165277845048220891"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-420105131612431991"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4234449368385967218"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4247382582787637854"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4285669509751312096"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4301437726103677754"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4394001590681622240"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4428507626100339573"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4441640162834254086"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4469445906575693464"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4478597375383617590"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4490760052151427880"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4524716116585635782"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-452571949048066355"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4552291241027629550"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4554482330995177614"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4564915498511770209"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4625601953640150521"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4666765402814076573"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4675729570144404365"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4700016787240620585"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-474928823476993567"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4769310799068247716"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4823680748991535702"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4852488030433257192"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4898214526306899415"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-4962768465676381896"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5001106409233644145"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5036027953588220653"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5071931235585637057"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5126145410622861772"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5159358379144199691"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5165873688755198291"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5185500554785562272"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-521680058060950348"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5237905392756629943"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5238257396625222054"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5256122759849092433"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5259414003397540211"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5274051397373625032"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5276369451512352494"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5285418777871253616"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5352388353970708753"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-539253255129623690"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5409570862886775287"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5473170763905270375"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-548244885112575818"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5498408931421147064"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5516415144078601880"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5567182918652240952"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-556814783805510507"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5609381539297065165"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5612761795197137106"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5655088119695589020"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5671922923304202798"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5716861171268863503"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5758045060583863006"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5805046527833630922"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-580517874506696265"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5844887149864871318"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5878341413728556447"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5903650977588132801"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5915820465594209127"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5975777033383448969"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-5991904155998973731"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6002352866564347729"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6025004575794035782"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6086499371823038967"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6175048693758615118"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-624442390353999425"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6276353345436866607"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6279518014267387846"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6284208901570934872"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6286334539164285854"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6291833136749940266"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6294389194630488478"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6354406006088166276"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6421023054279985066"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-644540634365453325"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6453324735107263062"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6455949491547510209"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6502539556361269620"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6670421636655900426"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6680775438846035225"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6701662734306497331"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6723683906431074752"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6752019490208577109"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6754698751878267074"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6755790169423522890"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6794862423359076257"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6798678528608711649"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6817334724676795234"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6861210127755763696"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6897356465666981271"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6959729427745168920"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-6985597153280644534"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7032140007123265132"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-70591755805933854"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7092207158477499848"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7138260094162023665"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7140501849072596231"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7162077765869786118"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7174318100784964218"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7191633668582614167"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7195280639906539295"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7199925770204963991"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7245853466271414178"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7277663109332846097"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7279034627279850911"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7300621129295834628"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7323799520531697446"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7332563219429653430"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7354230540966914428"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7355854904343991216"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7376125401836766554"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7494913187882697075"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7568143465823703682"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7579289054961446242"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7581297167516163689"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7581338975723126180"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7645261462414831338"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7693292708651319684"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7697022947558831050"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7697101658071237844"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7721626810876183538"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7754069845973179016"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7794213270533888476"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7851623748001448235"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7859792761491123607"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7864307245710937401"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7889298573604878684"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7903747822466468414"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7941665912106614919"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7960426412628371800"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-7976842744623875709"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8088023745980736359"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8128462786251532907"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8149462399427873151"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8159071638551219708"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8166812765722162191"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8183873427027850178"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8184408921100797660"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8211415790429932708"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8213270627530433990"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-825356929464772946"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8266494768561920808"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8274041462767967374"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8303414024349028524"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8358100075481912918"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8360481972953686651"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8374461390294323446"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8430456936702754468"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8487015566313487278"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8566491766607722658"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8571365367170674854"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8603260654654526841"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8726744172952011921"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8733232637139376148"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8755040990697026872"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8759716600598688933"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8775380097684109599"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8835964354329449277"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8838211813080068778"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8875180882601997200"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8916587197659442676"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8922809239339716561"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8923676160351581279"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8974237724025932493"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-8985184928476881755"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9014858844555622959"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-904336236693129814"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9051384032443196535"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9056550110490406789"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9125022219997241826"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9165961187756132353"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-9196150389019460504"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-971888327188283551"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_-976574768391644684"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_103783574514906365"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1062386157183531149"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1077703084245401584"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1087260334824232817"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1107339592678590356"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1153937446235533054"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1243755844506222581"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_125542192122165938"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1259314079669946267"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1293336858776964093"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1300374604449424929"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1320772518774788702"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1360401260136364296"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1365655488868903558"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1372752801953400699"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1395894076247212719"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1454575468569965205"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1462406983952962362"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_152249264538356966"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1562062510973913206"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1595766985463867229"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1654493942524960914"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1703771462155759617"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1715268455290928359"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1726068482336306057"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1735414460049222672"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1758889851686991422"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1782918510431766855"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1795022882898898245"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1798223842165826076"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1799934278820606669"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1812637055472323300"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1911375796351995922"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_1953954492668423242"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_207162279998543571"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2079474561314178171"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2158667534037640501"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2159161995808922867"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2174202140423748468"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2233333308160599927"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2233754594764623950"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_224409654452236877"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2283356800164456163"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2314897582053088577"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2334722588528808502"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2352766423180538123"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2365625448445669051"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2380342067036448302"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2395070671718809322"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2402186465374562741"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2408037583883445420"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_251838328768893510"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_25461944429738059"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2551278753224682144"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2584586812056531419"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2612382186869543148"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2618842720734772796"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_268028089880226453"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2686750477610094220"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_269807811901968195"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2702846443489091248"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2722315836397405406"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2748468737935019588"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2763404463935409102"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2809494288288982467"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2850009245265055720"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2850361919576185475"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2867804717292470286"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2880242633987710040"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2917699250148732511"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2942510148882728337"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2953291064589729249"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2963931510055269656"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_2977832282343866983"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3019327797954460875"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3033858342713060479"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3119455569976593063"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3146611155177047392"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3274475765164550167"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3316087686867228312"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3330644454723024449"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3334300259114919197"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3339525617691528826"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3380203009816296588"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3431753434557434371"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3449010013036346930"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3471850643204752700"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3522808109475804719"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3627550920356315679"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3631071629641059105"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3705226634378577902"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_370905959466003909"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_370974946746223973"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3732144679661725105"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3782330926463256001"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3808993009324810967"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3817790310546328434"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3820564393595093254"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3866117516309903145"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3876919914169915609"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3890583298414659006"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3901298598704364322"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3917385519341654890"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3936530267289361565"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3946345510772969722"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3953011239194136582"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_3953522946273429530"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4028491784365647828"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4088258742943797994"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4099658816967626906"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4114398978561234432"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4209124728790472796"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4216275409083535033"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4226080382586491499"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_424290667566093076"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4344031550595810134"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4379915947792434248"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4383736866407207890"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_438555752043785022"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4437113781045784766"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4509598582672620874"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4522430536109795615"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4525096946089120796"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_455927197988333314"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4560977067747114053"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4566055741834331871"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4617494182293171368"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4625719533312947267"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4654425740389202621"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4669641115721316487"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4677073791820781928"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4711951278901619039"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4723732562150255200"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4730731898441205024"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4834207725271468417"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4844864339334191977"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4865856448838218616"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4878102979026125234"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4898257845215987784"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4939191533044397866"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_4998506055709173717"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5010530662179761293"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5028068575708747858"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5052643448371422321"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5069316706111882422"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5094768507168297204"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5106546678348428520"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5155238767121718166"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5155533793073072931"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5196900052625893865"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5218419924534419098"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5258124907427216565"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5267710899612281684"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5320040963340246487"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5325538235460916267"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_536358749736449646"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5393814327696552421"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5396497051205534880"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5482265964648343249"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5537274315161312719"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5632960689941155759"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5641613365031634472"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5695184383849263479"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_569588179352633096"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5735735701858246310"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5778583636348327843"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5848846347355126042"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5900894177584524330"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5910836216873627736"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5911613726787157346"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_5999249939616733191"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6001274271987503613"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6007312529483121379"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6068920939317282929"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_611894735454662074"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_612921655668580231"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_613089881140479461"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6135537171552564152"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_618885187560022714"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6215102397609294298"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6228640248683534742"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6245989479722398562"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6268128083786525827"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6272769869967595344"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6273608151558078519"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6295797203161724241"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6296335513915125566"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6332247857572285788"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6354993837785394025"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6370669358992257874"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6387287228819116301"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_651410362517563313"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6530376668697802925"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6540438539463275530"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6555983139987446138"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6559229743172644308"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6586749570956633224"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6592302397723484633"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6612931805983905955"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6652613920178568222"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6757093302256655643"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6765544288896223309"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6766221764701739252"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6769750130139628429"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6779621523966412679"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6788144839671623153"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_680641220214941999"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6825554225575627771"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6867976968272446767"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6918337163282775756"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_6925180817046965809"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_698056443258243785"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_700379425727366914"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7022609019977709046"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7055064031518476115"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7107416146235199183"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_710991780278139972"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7114777282981065763"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7123238229525306939"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7124676437443333231"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7144232076809476596"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7160114135178642904"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_717151221327455784"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7195516464565736087"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7278576894237781613"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7314686716204304998"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7315521233232360139"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7366736454330800177"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7396176636810971690"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_740370917728262819"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7404650617228365944"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7485360950881188785"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7537218525610666552"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7546332314395635708"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7551194011163709496"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7623291401256829220"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7672930325061490223"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7705013356612004483"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7705534321639694579"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7721402308250216985"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7728992248817986475"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7737289057026796957"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_775093642669094003"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7765000699513051043"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7767651989569027728"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7771113236588600410"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_779353393055458998"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7808553173825754344"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7937219247379134106"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_795404709041144728"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7967253704131283151"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_7994166002291775133"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8006851455471719859"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8010746957803543500"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8031582004682232807"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8056798458600703456"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8065878915435909962"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8080159469148793911"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8088950567427797425"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8089427925423209174"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8108040485716007409"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8139223611212087831"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8147155963636054519"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8148518773216465664"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8152803391512757661"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8172535054961992686"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8176067793814562132"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8185674708504665174"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8188571889756338267"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8193435225210067190"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8206655679878940539"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8227571774284354649"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8245491705103469120"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8263872175917546263"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_829656184298986607"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8300865196944153700"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8386820722593177443"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8410482971724777152"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8420000860579744506"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8433048001333133290"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8457579424514706796"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8463697913601981116"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8477891680863961435"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8490515760943125641"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_871906047505015315"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8738021641963208415"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8773396537514094683"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8781714937696403787"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8846479646384253205"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_893445034061142624"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8934678037171464407"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8940281847530526641"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8946846261558299455"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8954103472049516819"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_898299922266032858"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_8989841175193476434"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_9037832682008019891"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_9153410146279579572"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_9174130300978301228"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_9213070412916295798"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_946159742669364316"),
        org.junit.jupiter.params.provider.Arguments.of("http://purl.org/dc/elements/1.1/", "dc", "li", "Text_String_96527463613950195"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.aiim.org/pdfa/ns/id/", "pdfaid", "amd", "2005"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.aiim.org/pdfa/ns/id/", "pdfaid", "conformance", "B"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.space.org/schem/", "space", "li", "ValueSpace1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.space.org/schem/", "space", "li", "ValueSpace2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.space.org/schem/", "space", "li", "ValueSpace3"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/pdfa/", "test", "text", "TEST"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "BagvalSchem1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "BagvalSchem2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "Value1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "Value2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "Value3"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "altvalSchem1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "altvalSchem2"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "seqvalSchem1"),
        org.junit.jupiter.params.provider.Arguments.of("http://www.test.org/schem/", "test", "li", "seqvalSchem2"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "American Language"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "Default Language"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "Lang française"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "Langue française"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "bagVal"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "langVal"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "seqValue"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "seqval"),
        org.junit.jupiter.params.provider.Arguments.of("nsURI", "nsSchem", "li", "valueTwo")
        );
    }
}