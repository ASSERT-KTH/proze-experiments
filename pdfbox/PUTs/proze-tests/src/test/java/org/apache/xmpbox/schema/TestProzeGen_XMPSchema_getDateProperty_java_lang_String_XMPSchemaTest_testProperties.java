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

public class TestProzeGen_XMPSchema_getDateProperty_java_lang_String_XMPSchemaTest_testProperties {
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
    public void testProperties(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
        schem.setTextProperty(text);
        assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        assertEquals(dateType, schem.getDateProperty(param0));
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
            schem.getDateProperty(param0);
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
    public void testProperties_1(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_2(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_3(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_4(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_5(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_6(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_7(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
        schem.setTextProperty(text);
        // assertEquals(text, schem.getUnqualifiedTextProperty("textType"));
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String date = "nsSchem:dateProp";
        schem.setDatePropertyValue(date, dateVal);
        // assertEquals(dateVal, schem.getDatePropertyValue(date));
        org.apache.xmpbox.type.DateType dateType = parent.getTypeMapping().createDate(null, "nsSchem", "dateType", java.util.Calendar.getInstance());
        schem.setDateProperty(dateType);
        assertEquals(dateType, schem.getDateProperty(param0));
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
            schem.getDateProperty(param0);
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
    public void testProperties_8(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_9(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_10(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_11(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_12(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_13(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
    public void testProperties_14(String param0) throws Exception {
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
        org.apache.xmpbox.type.TextType text = parent.getTypeMapping().createText(null, "nsSchem", "textType", "GRINGO");
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
            schem.getDateProperty(param0);
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
        org.junit.jupiter.params.provider.Arguments.of("date"),
        org.junit.jupiter.params.provider.Arguments.of("dateType"),
                org.junit.jupiter.params.provider.Arguments.of("textType")
        );
    }
}