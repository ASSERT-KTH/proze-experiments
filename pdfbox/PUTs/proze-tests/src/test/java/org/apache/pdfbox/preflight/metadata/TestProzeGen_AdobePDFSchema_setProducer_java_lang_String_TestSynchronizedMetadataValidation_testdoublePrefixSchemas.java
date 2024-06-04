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
package org.apache.pdfbox.preflight.metadata;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Class of SynchronizedMetaDataValidation (for 6-7-3 Isartor Tests)
 *
 * @author Germain Costenobel
 */
public class TestProzeGen_AdobePDFSchema_setProducer_java_lang_String_TestSynchronizedMetadataValidation_testdoublePrefixSchemas {
    protected org.apache.pdfbox.pdmodel.PDDocument doc;

    protected org.apache.pdfbox.pdmodel.PDDocumentInformation dico;

    protected org.apache.xmpbox.XMPMetadata metadata;

    protected String title;

    protected String author;

    protected String subject;

    protected String keywords;

    protected String creator;

    protected String producer;

    protected java.util.Calendar creationDate;

    protected java.util.Calendar modifyDate;

    protected static SynchronizedMetaDataValidation sync;

    protected java.util.List<org.apache.pdfbox.preflight.ValidationResult.ValidationError> ve;

    @org.junit.jupiter.api.BeforeAll
    public static void initSynchronizedMetadataValidation() {
        TestProzeGen_AdobePDFSchema_setProducer_java_lang_String_TestSynchronizedMetadataValidation_testdoublePrefixSchemas.sync = new SynchronizedMetaDataValidation();
    }

    @org.junit.jupiter.api.BeforeEach
    public void initNewDocumentInformation() throws Exception {
        doc = new org.apache.pdfbox.pdmodel.PDDocument();
        dico = doc.getDocumentInformation();
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
    }

    /**
     * Check reaction when metadata are well-formed
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testdoublePrefixSchemas(String param0) throws Exception {
        initValues();
        // building temporary XMP metadata
        org.apache.xmpbox.schema.DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, "dctest");
        metadata.addSchema(dc2);
        org.apache.xmpbox.schema.XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();
        org.apache.xmpbox.schema.XMPBasicSchema xmp2 = new org.apache.xmpbox.schema.XMPBasicSchema(metadata, "xmptest");
        metadata.addSchema(xmp2);
        org.apache.xmpbox.schema.AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();
        org.apache.xmpbox.schema.AdobePDFSchema pdf2 = new org.apache.xmpbox.schema.AdobePDFSchema(metadata, "pdftest");
        metadata.addSchema(pdf2);
        // write some temp info in 'false' schemas
        dc2.setCoverage("tmpcover");
        xmp2.setCreatorTool("tmpcreator");
        pdf2.setKeywords("tmpkeys");
        // Writing info in XMP and Document Information dictionary
        // TITLE
        dico.setTitle(title);
        dc.setTitle("x-default", title);
        // AUTHOR
        dico.setAuthor(author);
        dc.addCreator(author);
        // SUBJECT
        dico.setSubject(subject);
        dc.addDescription("x-default", subject);
        // KEYWORDS
        dico.setKeywords(keywords);
        pdf.setKeywords(keywords);
        // CREATOR
        dico.setCreator(creator);
        xmp.setCreatorTool(creator);
        // PRODUCER
        dico.setProducer(producer);
        pdf.setProducer(param0);
        // CREATION DATE
        dico.setCreationDate(creationDate);
        xmp.setCreateDate(creationDate);
        // MODIFY DATE
        dico.setModificationDate(modifyDate);
        xmp.setModifyDate(modifyDate);
        // Launching synchronization test
        try {
            ve = TestProzeGen_AdobePDFSchema_setProducer_java_lang_String_TestSynchronizedMetadataValidation_testdoublePrefixSchemas.sync.validateMetadataSynchronization(doc, metadata);
            assertTrue(ve.isEmpty());
        } catch (org.apache.pdfbox.preflight.exception.ValidationException e) {
            throw new Exception(e.getMessage());
        }
    }

    @org.junit.jupiter.api.AfterEach
    public void checkErrors() throws Exception {
        try {
            doc.close();
        } catch (java.io.IOException e) {
            throw new Exception("Error while closing PDF Document");
        }
        /* Iterator<ValidationError> it=ve.iterator(); while(it.hasNext()){ ValidationError tmp=it.next();
        System.out.println("Error:"+ tmp.getDetails()+"\n code: "+tmp.getErrorCode()); }
         */
    }

    private void initValues() {
        title = "TITLE";
        author = "AUTHOR(S)";
        subject = "SUBJECTS";
        keywords = "KEYWORD(S)";
        creator = "CREATOR";
        producer = "PRODUCER";
        creationDate = java.util.Calendar.getInstance();
        modifyDate = java.util.Calendar.getInstance();
        // PDFBOX-4292: because xmp keeps the milliseconds before writing to XML,
        // but COS doesn't, tests would fail when calendar values are compared
        // so reset the milliseconds.
        creationDate.set(java.util.Calendar.MILLISECOND, 0);
        modifyDate.set(java.util.Calendar.MILLISECOND, 0);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("Producer"),
        org.junit.jupiter.params.provider.Arguments.of("producer"),
        org.junit.jupiter.params.provider.Arguments.of("testcase"),
                org.junit.jupiter.params.provider.Arguments.of("XMPProducer"),
                org.junit.jupiter.params.provider.Arguments.of("PRODUCER")
        );
    }
}