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
package org.apache.xmpbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue; /**
 * Test with 2 dublinCore with different prefix (Test comportment of XMPMetadata)
 *
 * @author a183132
 */
public class TestProzeGen_DublinCoreSchema_setCoverage_java_lang_String_DoubleSameTypeSchemaTest_testDoubleDublinCore {
    protected XMPMetadata metadata;

    @org.junit.jupiter.api.BeforeEach
    public void testInit() throws Exception {
        metadata = XMPMetadata.createXMPMetadata();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(creators.get(0));
        dc1.addCreator(creators.get(1));
        String coverage = "Coverage";
        dc2.setCoverage(param0);
        dc2.addCreator(creators.get(0));
        dc2.addCreator(creators.get(1));
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
        for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_1(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(creators.get(0));
        dc1.addCreator(creators.get(1));
        String coverage = "Coverage";
        dc2.setCoverage(param0);
        dc2.addCreator(creators.get(0));
        dc2.addCreator(creators.get(1));
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        // assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
         for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
//            assertTrue(dc.getCreators().containsAll(creators));
        };
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_2(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(creators.get(0));
        dc1.addCreator(creators.get(1));
        String coverage = "Coverage";
        dc2.setCoverage(param0);
        dc2.addCreator(creators.get(0));
        dc2.addCreator(creators.get(1));
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        // assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
         for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
//            assertTrue(dc.getCreators().containsAll(creators));
        };
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_3(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(creators.get(0));
        dc1.addCreator(creators.get(1));
        String coverage = "Coverage";
        dc2.setCoverage(param0);
        dc2.addCreator(creators.get(0));
        dc2.addCreator(creators.get(1));
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        // assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        // assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
        for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("Coverage"),
        org.junit.jupiter.params.provider.Arguments.of("coverage"),
                org.junit.jupiter.params.provider.Arguments.of("tmpcover")
        );
    }
}