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

public class TestProzeGen_AbstractComplexProperty_getProperty_java_lang_String_XMPSchemaTest_testListAndContainerAccessor {
    protected org.apache.xmpbox.XMPMetadata parent;

    protected XMPSchema schem;

    @org.junit.jupiter.api.BeforeEach
    public void resetDocument() throws Exception {
        parent = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schem = new XMPSchema(parent, "nsURI", "nsSchem");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor(String param0) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, schem.getPrefix(), boolname, boolVal);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        assertEquals(schem.getAllProperties(), schem.getAllProperties());
        assertTrue(schem.getAllProperties().contains(bool));
        assertTrue(schem.getAllAttributes().contains(att));
        assertEquals(bool, schem.getProperty(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testListAndContainerAccessor_1(String param0) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, schem.getPrefix(), boolname, boolVal);
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
    public void testListAndContainerAccessor_2(String param0) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, schem.getPrefix(), boolname, boolVal);
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
    public void testListAndContainerAccessor_3(String param0) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, schem.getPrefix(), boolname, boolVal);
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
    public void testListAndContainerAccessor_4(String param0) throws Exception {
        String boolname = "bool";
        boolean boolVal = true;
        org.apache.xmpbox.type.BooleanType bool = parent.getTypeMapping().createBoolean(null, schem.getPrefix(), boolname, boolVal);
        org.apache.xmpbox.type.Attribute att = new org.apache.xmpbox.type.Attribute(org.apache.xmpbox.XmpConstants.RDF_NAMESPACE, "test", "vgh");
        schem.setAttribute(att);
        schem.setBooleanProperty(bool);
        // assertEquals(schem.getAllProperties(), schem.getAllProperties());
        // assertTrue(schem.getAllProperties().contains(bool));
        // assertTrue(schem.getAllAttributes().contains(att));
        assertEquals(bool, schem.getProperty(param0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("AncestorID"),
        org.junit.jupiter.params.provider.Arguments.of("AuthorsPosition"),
        org.junit.jupiter.params.provider.Arguments.of("CaptionWriter"),
        org.junit.jupiter.params.provider.Arguments.of("Category"),
        org.junit.jupiter.params.provider.Arguments.of("City"),
        org.junit.jupiter.params.provider.Arguments.of("ColorMode"),
        org.junit.jupiter.params.provider.Arguments.of("Country"),
        org.junit.jupiter.params.provider.Arguments.of("CreateDate"),
        org.junit.jupiter.params.provider.Arguments.of("CreatorTool"),
        org.junit.jupiter.params.provider.Arguments.of("Credit"),
        org.junit.jupiter.params.provider.Arguments.of("DateCreated"),
        org.junit.jupiter.params.provider.Arguments.of("DocumentID"),
        org.junit.jupiter.params.provider.Arguments.of("Headline"),
        org.junit.jupiter.params.provider.Arguments.of("History"),
        org.junit.jupiter.params.provider.Arguments.of("ICCProfile"),
        org.junit.jupiter.params.provider.Arguments.of("Instructions"),
        org.junit.jupiter.params.provider.Arguments.of("LayerName"),
        org.junit.jupiter.params.provider.Arguments.of("LayerText"),
        org.junit.jupiter.params.provider.Arguments.of("MetadataDate"),
        org.junit.jupiter.params.provider.Arguments.of("ModifyDate"),
        org.junit.jupiter.params.provider.Arguments.of("NOT_EXISTING"),
        org.junit.jupiter.params.provider.Arguments.of("Producer"),
        org.junit.jupiter.params.provider.Arguments.of("Source"),
        org.junit.jupiter.params.provider.Arguments.of("SpectralSensitivity"),
        org.junit.jupiter.params.provider.Arguments.of("State"),
        org.junit.jupiter.params.provider.Arguments.of("SupplementalCategories"),
        org.junit.jupiter.params.provider.Arguments.of("TransmissionReference"),
        org.junit.jupiter.params.provider.Arguments.of("Urgency"),
        org.junit.jupiter.params.provider.Arguments.of("action"),
        org.junit.jupiter.params.provider.Arguments.of("bool"),
        org.junit.jupiter.params.provider.Arguments.of("category"),
        org.junit.jupiter.params.provider.Arguments.of("changed"),
        org.junit.jupiter.params.provider.Arguments.of("comments"),
        org.junit.jupiter.params.provider.Arguments.of("contributor"),
        org.junit.jupiter.params.provider.Arguments.of("coverage"),
        org.junit.jupiter.params.provider.Arguments.of("creator"),
        org.junit.jupiter.params.provider.Arguments.of("date"),
        org.junit.jupiter.params.provider.Arguments.of("description"),
        org.junit.jupiter.params.provider.Arguments.of("documentID"),
        org.junit.jupiter.params.provider.Arguments.of("event"),
        org.junit.jupiter.params.provider.Arguments.of("filePath"),
        org.junit.jupiter.params.provider.Arguments.of("format"),
        org.junit.jupiter.params.provider.Arguments.of("fromPart"),
        org.junit.jupiter.params.provider.Arguments.of("height"),
        org.junit.jupiter.params.provider.Arguments.of("id"),
        org.junit.jupiter.params.provider.Arguments.of("identifier"),
        org.junit.jupiter.params.provider.Arguments.of("image"),
        org.junit.jupiter.params.provider.Arguments.of("instanceID"),
        org.junit.jupiter.params.provider.Arguments.of("language"),
        org.junit.jupiter.params.provider.Arguments.of("lastModifyDate"),
        org.junit.jupiter.params.provider.Arguments.of("manageTo"),
        org.junit.jupiter.params.provider.Arguments.of("manageUI"),
        org.junit.jupiter.params.provider.Arguments.of("manager"),
        org.junit.jupiter.params.provider.Arguments.of("managerVariant"),
        org.junit.jupiter.params.provider.Arguments.of("maskMarkers"),
        org.junit.jupiter.params.provider.Arguments.of("modifier"),
        org.junit.jupiter.params.provider.Arguments.of("modifyDate"),
        org.junit.jupiter.params.provider.Arguments.of("my-date"),
        org.junit.jupiter.params.provider.Arguments.of("my-text"),
        org.junit.jupiter.params.provider.Arguments.of("name"),
        org.junit.jupiter.params.provider.Arguments.of("namespaceURI"),
        org.junit.jupiter.params.provider.Arguments.of("parameters"),
        org.junit.jupiter.params.provider.Arguments.of("partMapping"),
        org.junit.jupiter.params.provider.Arguments.of("prefix"),
        org.junit.jupiter.params.provider.Arguments.of("publisher"),
        org.junit.jupiter.params.provider.Arguments.of("relation"),
        org.junit.jupiter.params.provider.Arguments.of("renditionClass"),
        org.junit.jupiter.params.provider.Arguments.of("renditionParams"),
        org.junit.jupiter.params.provider.Arguments.of("schemas"),
        org.junit.jupiter.params.provider.Arguments.of("softwareAgent"),
        org.junit.jupiter.params.provider.Arguments.of("source"),
        org.junit.jupiter.params.provider.Arguments.of("subject"),
        org.junit.jupiter.params.provider.Arguments.of("toPart"),
        org.junit.jupiter.params.provider.Arguments.of("type"),
        org.junit.jupiter.params.provider.Arguments.of("url"),
        org.junit.jupiter.params.provider.Arguments.of("valueType"),
        org.junit.jupiter.params.provider.Arguments.of("version"),
        org.junit.jupiter.params.provider.Arguments.of("versionID"),
        org.junit.jupiter.params.provider.Arguments.of("when"),
        org.junit.jupiter.params.provider.Arguments.of("width")
        );
    }
}