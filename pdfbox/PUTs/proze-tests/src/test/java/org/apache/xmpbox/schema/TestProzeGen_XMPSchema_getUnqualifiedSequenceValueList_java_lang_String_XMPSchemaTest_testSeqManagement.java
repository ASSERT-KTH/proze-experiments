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

public class TestProzeGen_XMPSchema_getUnqualifiedSequenceValueList_java_lang_String_XMPSchemaTest_testSeqManagement {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    /**
     * Check if Seq (Ordered Array) management is ok
     *
     * @throws IllegalArgumentException
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        assertEquals(1, dates.size());
        assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        assertEquals(3, values.size());
        assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        assertEquals(bool.getStringValue(), values.get(1));
        assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        assertEquals(0, schem.getUnqualifiedSequenceValueList(param0).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_1(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_2(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_3(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_4(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_5(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_6(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_7(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        // assertEquals(0, schem.getUnqualifiedSequenceValueList(seqName).size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSeqManagement_8(String param0) throws Exception {
        java.util.Calendar date = java.util.Calendar.getInstance();
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, "rdf", "li", true);
        String textVal = "seqValue";
        String seqName = "SEQNAME";
        schem.addUnqualifiedSequenceDateValue(seqName, date);
        schem.addUnqualifiedSequenceValue(seqName, bool);
        schem.addUnqualifiedSequenceValue(seqName, textVal);
        java.util.List<java.util.Calendar> dates = schem.getUnqualifiedSequenceDateValueList(seqName);
        // assertEquals(1, dates.size());
        // assertEquals(date, dates.get(0));
        java.util.List<String> values = schem.getUnqualifiedSequenceValueList(param0);
        // assertEquals(3, values.size());
        // assertEquals(org.apache.xmpbox.DateConverter.toISO8601(date), values.get(0));
        // assertEquals(bool.getStringValue(), values.get(1));
        // assertEquals(textVal, values.get(2));
        schem.removeUnqualifiedSequenceDateValue(seqName, date);
        // assertEquals(0, schem.getUnqualifiedSequenceDateValueList(seqName).size());
        schem.removeUnqualifiedSequenceValue(seqName, bool);
        schem.removeUnqualifiedSequenceValue(seqName, textVal);
        assertEquals(0, schem.getUnqualifiedSequenceValueList(param0).size());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("History"),
        org.junit.jupiter.params.provider.Arguments.of("SEQNAME"),
        org.junit.jupiter.params.provider.Arguments.of("SeqProp"),
        org.junit.jupiter.params.provider.Arguments.of("creator"),
        org.junit.jupiter.params.provider.Arguments.of("seqName")
        );
    }
}