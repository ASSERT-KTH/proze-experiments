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

public class TestProzeGen_XMPSchema_getUnqualifiedSequenceValueList_java_lang_String_XMPSchemaTest_testMergeSchema {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    /**
     * check if merging is ok
     *
     * @throws IllegalArgumentException
     * @throws java.io.IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        assertTrue(bag.contains(valBagSchem1));
        assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        assertTrue(seq.contains(valSeqSchem1));
        assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_1(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        // assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        // assertTrue(bag.contains(valBagSchem1));
        // assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        // assertTrue(seq.contains(valSeqSchem1));
        // assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_2(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        // assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        // assertTrue(bag.contains(valBagSchem1));
        // assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        // assertTrue(seq.contains(valSeqSchem1));
        // assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_3(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        // assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        // assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        assertTrue(bag.contains(valBagSchem1));
        // assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        // assertTrue(seq.contains(valSeqSchem1));
        // assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_4(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        // assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        // assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        // assertTrue(bag.contains(valBagSchem1));
        assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        // assertTrue(seq.contains(valSeqSchem1));
        // assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_5(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        // assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        // assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        // assertTrue(bag.contains(valBagSchem1));
        // assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
        assertTrue(seq.contains(valSeqSchem1));
//        assertTrue(seq.contains(valSeqSchem1));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMergeSchema_6(String param0) throws Exception {
        String bagName = "bagName";
        String seqName = "seqName";
        String qseqName = "test:" + seqName;
        String altName = "AltProp";
        String qaltName = "test:" + altName;
        String valBagSchem1 = "BagvalSchem1";
        String valBagSchem2 = "BagvalSchem2";
        String valSeqSchem1 = "seqvalSchem1";
        String valSeqSchem2 = "seqvalSchem2";
        String valAltSchem1 = "altvalSchem1";
        String langAltSchem1 = "x-default";
        String valAltSchem2 = "altvalSchem2";
        String langAltSchem2 = "fr-fr";
        XMPSchema schem1 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem1.addQualifiedBagValue(bagName, valBagSchem1);
        schem1.addUnqualifiedSequenceValue(seqName, valSeqSchem1);
        schem1.setUnqualifiedLanguagePropertyValue(altName, langAltSchem1, valAltSchem1);
        XMPSchema schem2 = new XMPSchema(parent, "http://www.test.org/schem/", "test");
        schem2.addQualifiedBagValue(bagName, valBagSchem2);
        schem2.addUnqualifiedSequenceValue(seqName, valSeqSchem2);
        schem2.setUnqualifiedLanguagePropertyValue(altName, langAltSchem2, valAltSchem2);
        schem1.merge(schem2);
        // assertEquals(valAltSchem2, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem2));
        // assertEquals(valAltSchem1, schem1.getUnqualifiedLanguagePropertyValue(altName, langAltSchem1));
        java.util.List<String> bag = schem1.getUnqualifiedBagValueList(bagName);
        // assertTrue(bag.contains(valBagSchem1));
        // assertTrue(bag.contains(valBagSchem2));
        java.util.List<String> seq = schem1.getUnqualifiedSequenceValueList(param0);
//        assertTrue(seq.contains(valSeqSchem1));
        assertTrue(seq.contains(valSeqSchem1));
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