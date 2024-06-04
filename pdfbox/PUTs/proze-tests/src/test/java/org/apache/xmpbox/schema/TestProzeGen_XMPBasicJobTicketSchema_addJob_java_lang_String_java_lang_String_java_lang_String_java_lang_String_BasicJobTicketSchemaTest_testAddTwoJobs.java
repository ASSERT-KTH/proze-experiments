/**
 * ***************************************************************************
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestProzeGen_XMPBasicJobTicketSchema_addJob_java_lang_String_java_lang_String_java_lang_String_java_lang_String_BasicJobTicketSchemaTest_testAddTwoJobs {
    protected static org.apache.xmpbox.xml.DomXmpParser builder;

    protected org.apache.xmpbox.XMPMetadata metadata;

    protected org.apache.xmpbox.xml.XmpSerializer serializer;

    @org.junit.jupiter.api.BeforeAll
    public static void bc() throws Exception {
        TestProzeGen_XMPBasicJobTicketSchema_addJob_java_lang_String_java_lang_String_java_lang_String_java_lang_String_BasicJobTicketSchemaTest_testAddTwoJobs.builder = new org.apache.xmpbox.xml.DomXmpParser();
    }

    @org.junit.jupiter.api.BeforeEach
    public void initTempMetaData() throws Exception {
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        serializer = new org.apache.xmpbox.xml.XmpSerializer();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddTwoJobs(String param0, String param1, String param2, String param3) throws Exception {
        XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();
        basic.addJob(param0, param1, param2, param3);
        basic.addJob("zeid2", "zename2", "zeurl2");
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        serializer.serialize(metadata, bos, true);
        org.apache.xmpbox.XMPMetadata rxmp = TestProzeGen_XMPBasicJobTicketSchema_addJob_java_lang_String_java_lang_String_java_lang_String_java_lang_String_BasicJobTicketSchemaTest_testAddTwoJobs.builder.parse(bos.toByteArray());
        XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();
        assertNotNull(jt);
        assertEquals(2, jt.getJobs().size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddTwoJobs_1(String param0, String param1, String param2, String param3) throws Exception {
        XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();
        basic.addJob(param0, param1, param2, param3);
        basic.addJob("zeid2", "zename2", "zeurl2");
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        serializer.serialize(metadata, bos, true);
        org.apache.xmpbox.XMPMetadata rxmp = TestProzeGen_XMPBasicJobTicketSchema_addJob_java_lang_String_java_lang_String_java_lang_String_java_lang_String_BasicJobTicketSchemaTest_testAddTwoJobs.builder.parse(bos.toByteArray());
        XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();
        assertNotNull(jt);
        // assertEquals(2, jt.getJobs().size());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAddTwoJobs_2(String param0, String param1, String param2, String param3) throws Exception {
        XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();
        basic.addJob(param0, param1, param2, param3);
        basic.addJob("zeid2", "zename2", "zeurl2");
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        serializer.serialize(metadata, bos, true);
        org.apache.xmpbox.XMPMetadata rxmp = TestProzeGen_XMPBasicJobTicketSchema_addJob_java_lang_String_java_lang_String_java_lang_String_java_lang_String_BasicJobTicketSchemaTest_testAddTwoJobs.builder.parse(bos.toByteArray());
        XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();
        // assertNotNull(jt);
        assertEquals(2, jt.getJobs().size());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("zeid1", "zename1", "zeurl1", "aaa"),
        org.junit.jupiter.params.provider.Arguments.of("zeid2", "zename2", "zeurl2", null),
        org.junit.jupiter.params.provider.Arguments.of("zeid2", "zename2", "zeurl2", "aaa")
        );
    }
}