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

import org.apache.xmpbox.XMPMetadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestProzeGen_AdobePDFSchema_setKeywords_java_lang_String_AdobePDFTest_testPDFAIdentification {
    XMPMetadata metadata;
    XMPSchema schema;

    @org.junit.jupiter.api.BeforeEach
    public void initTempMetaData() throws Exception {
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
        schema = metadata.createAndAddAdobePDFSchema();
//        schemaClass = AdobePDFSchema.class;
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        assertNull(schem.getProducer());
        schem.setProducer(producer);
        assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        assertEquals(keywords, schem.getKeywords());
        assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        assertEquals(pdfVersion, schem.getPDFVersion());
        assertEquals("pdf", schem.getProducerProperty().getPrefix());
        assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_1(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_2(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_3(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_4(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_5(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_6(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_7(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_8(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_9(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        // assertEquals(producer, schem.getProducer());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFAIdentification_10(String param0) throws Exception {
        AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();
        String keywords = "keywords ihih";
        String pdfVersion = "1.4";
        String producer = "producer";
        schem.setKeywords(param0);
        schem.setPDFVersion(pdfVersion);
        // assertNull(schem.getProducer());
        schem.setProducer(producer);
        // assertEquals("pdf", schem.getKeywordsProperty().getPrefix());
        // assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());
        // assertEquals(keywords, schem.getKeywords());
        // assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());
        // assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());
        // assertEquals(pdfVersion, schem.getPDFVersion());
        // assertEquals("pdf", schem.getProducerProperty().getPrefix());
        // assertEquals("Producer", schem.getProducerProperty().getPropertyName());
        assertEquals(producer, schem.getProducer());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("keywords ihih"),
        org.junit.jupiter.params.provider.Arguments.of("kw1 kw2 kw3"),
        org.junit.jupiter.params.provider.Arguments.of("XMPkeywords"),
        org.junit.jupiter.params.provider.Arguments.of("KEYWORD(S)"),
        org.junit.jupiter.params.provider.Arguments.of("tmpkeys")

        );
    }
}