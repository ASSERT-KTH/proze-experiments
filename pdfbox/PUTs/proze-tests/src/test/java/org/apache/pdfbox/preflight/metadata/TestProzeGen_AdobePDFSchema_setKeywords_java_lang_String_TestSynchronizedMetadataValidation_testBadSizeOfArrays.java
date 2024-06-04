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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class of SynchronizedMetaDataValidation (for 6-7-3 Isartor Tests)
 *
 * @author Germain Costenobel
 */
public class TestProzeGen_AdobePDFSchema_setKeywords_java_lang_String_TestSynchronizedMetadataValidation_testBadSizeOfArrays {
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
        TestProzeGen_AdobePDFSchema_setKeywords_java_lang_String_TestSynchronizedMetadataValidation_testBadSizeOfArrays.sync = new SynchronizedMetaDataValidation();
    }

    @org.junit.jupiter.api.BeforeEach
    public void initNewDocumentInformation() throws Exception {
        doc = new org.apache.pdfbox.pdmodel.PDDocument();
        dico = doc.getDocumentInformation();
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
    }

    /**
     * in XMP, Subject and Author must be embedded in a single entry text array This function check the detection of
     * multiple entries for these properties
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBadSizeOfArrays(String param0) throws Exception {
        // building temporary XMP metadata
        org.apache.xmpbox.schema.DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();
        org.apache.xmpbox.schema.AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();
        org.apache.xmpbox.schema.XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();
        // Writing info in XMP and Document Information dictionary
        // TITLE
        dico.setTitle("dicoTitle");
        dc.setTitle("x-default", "XMPTitle");
        // AUTHOR
        dico.setAuthor("dicoAuthor");
        dc.addCreator("XMPAuthor");
        dc.addCreator("2ndCreator");
        // SUBJECT
        dico.setSubject("dicoSubj");
        dc.addSubject("XMPSubj");
        dc.addSubject("2ndSubj");
        // KEYWORDS
        dico.setKeywords("DicoKeywords");
        pdf.setKeywords(param0);
        // CREATOR
        dico.setCreator("DicoCreator");
        xmp.setCreatorTool("XMPCreator");
        // PRODUCER
        dico.setProducer("DicoProducer");
        pdf.setProducer("XMPProducer");
        // CREATION DATE
        dico.setCreationDate(java.util.Calendar.getInstance());
        java.util.GregorianCalendar XMPCreate = new java.util.GregorianCalendar(2008, 11, 05);
        xmp.setCreateDate(XMPCreate);
        // MODIFY DATE
        dico.setModificationDate(java.util.Calendar.getInstance());
        java.util.GregorianCalendar XMPModify = new java.util.GregorianCalendar(2009, 10, 15);
        xmp.setModifyDate(XMPModify);
        // Launching synchronization test
        try {
            ve = TestProzeGen_AdobePDFSchema_setKeywords_java_lang_String_TestSynchronizedMetadataValidation_testBadSizeOfArrays.sync.validateMetadataSynchronization(doc, metadata);
            // Test unsychronized value
            assertEquals(8, ve.size());
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
        org.junit.jupiter.params.provider.Arguments.of("keywords ihih"),
        org.junit.jupiter.params.provider.Arguments.of("kw1 kw2 kw3"),
                org.junit.jupiter.params.provider.Arguments.of("XMPkeywords"),
                org.junit.jupiter.params.provider.Arguments.of("KEYWORD(S)"),
                org.junit.jupiter.params.provider.Arguments.of("tmpkeys")
        );
    }
}