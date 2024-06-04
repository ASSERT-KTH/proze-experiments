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

public class TestProzeGen_XMPSchema_getUnqualifiedLanguagePropertyValue_java_lang_String_java_lang_String_XMPSchemaTest_testAsSimpleMethods {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        assertEquals(Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_1(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        assertEquals(Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_2(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_3(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_4(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
//        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_5(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
//        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_6(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
//        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_7(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
//        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_8(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
//        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_9(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_10(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_11(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_12(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
//        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(param0, param1));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_13(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
//        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_14(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
//        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_15(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
//        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        // assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAsSimpleMethods_16(String param0, String param1) throws Exception {
        String bool = "bool";
        boolean boolVal = true;
        String date = "date";
        java.util.Calendar dateVal = java.util.Calendar.getInstance();
        String integ = "integer";
        Integer i = 1;
        String langprop = "langprop";
        String lang = "x-default";
        String langVal = "langVal";
        String bagprop = "bagProp";
        String bagVal = "bagVal";
        String seqprop = "SeqProp";
        String seqPropVal = "seqval";
        String seqdate = "SeqDate";
        String prefSchem = "";
        schem.setBooleanPropertyValueAsSimple(bool, boolVal);
        schem.setDatePropertyValueAsSimple(date, dateVal);
        schem.setIntegerPropertyValueAsSimple(integ, i);
        schem.setUnqualifiedLanguagePropertyValue(langprop, lang, langVal);
        schem.addBagValueAsSimple(bagprop, bagVal);
        schem.addUnqualifiedSequenceValue(seqprop, seqPropVal);
        schem.addSequenceDateValueAsSimple(seqdate, dateVal);
        // assertEquals(java.lang.Boolean.valueOf(boolVal), schem.getBooleanProperty(prefSchem + bool).getValue());
        // assertEquals(dateVal, schem.getDateProperty(prefSchem + date).getValue());
        // assertEquals("" + i, schem.getIntegerProperty(prefSchem + integ).getStringValue());
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
//        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
        // assertEquals(boolVal, schem.getBooleanPropertyValueAsSimple(bool).booleanValue());
        // assertEquals(dateVal, schem.getDatePropertyValueAsSimple(date));
        // assertEquals(i, schem.getIntegerPropertyValueAsSimple(integ));
        // assertEquals(langVal, schem.getUnqualifiedLanguagePropertyValue(langprop, lang));
        // assertTrue(schem.getUnqualifiedBagValueList(bagprop).contains(bagVal));
        // assertTrue(schem.getUnqualifiedSequenceValueList(seqprop).contains(seqPropVal));
        // assertTrue(schem.getUnqualifiedSequenceDateValueList(seqdate).contains(dateVal));
        assertTrue(schem.getUnqualifiedLanguagePropertyLanguagesValue(langprop).contains(lang));
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