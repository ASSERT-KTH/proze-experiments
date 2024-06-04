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

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class of SynchronizedMetaDataValidation (for 6-7-3 Isartor Tests)
 *
 * @author Germain Costenobel
 */
public class TestProzeGen_DublinCoreSchema_addSubject_java_lang_String_TestSynchronizedMetadataValidation_testAllInfoUnsynchronized {
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
        TestProzeGen_DublinCoreSchema_addSubject_java_lang_String_TestSynchronizedMetadataValidation_testAllInfoUnsynchronized.sync = new SynchronizedMetaDataValidation();
    }

    @org.junit.jupiter.api.BeforeEach
    public void initNewDocumentInformation() throws Exception {
        doc = new org.apache.pdfbox.pdmodel.PDDocument();
        dico = doc.getDocumentInformation();
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
    }

    /**
     * Check the detection of unsynchronized information between Document Information dictionary and XMP
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAllInfoUnsynchronized(String param0) throws Exception {
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
        // SUBJECT
        dico.setSubject("dicoSubj");
        dc.addSubject(param0);
        // KEYWORDS
        dico.setKeywords("DicoKeywords");
        pdf.setKeywords("XMPkeywords");
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
            ve = TestProzeGen_DublinCoreSchema_addSubject_java_lang_String_TestSynchronizedMetadataValidation_testAllInfoUnsynchronized.sync.validateMetadataSynchronization(doc, metadata);
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
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1146225759968300386"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1392272327183899908"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-182988858125731975"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1852339425441943309"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1900772303935681369"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2067261394808555486"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2091027979763793714"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2091578115784479228"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2106836249791210950"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2193787806834063369"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2263699721918617436"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2409003043423000916"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-24157964672873318"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2535570789986293969"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2539438959239451889"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2579987830768444747"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3007629020936134095"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3079028241403922160"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3324430215779067459"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3407319324895758876"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3599911034025141741"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3611019928449678879"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4088964863957380234"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4165277845048220891"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4394001590681622240"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4490760052151427880"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4524716116585635782"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-452571949048066355"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4823680748991535702"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4852488030433257192"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4962768465676381896"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5107760878263691613"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-521680058060950348"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5409570862886775287"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5498408931421147064"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5671922923304202798"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5786779711791346590"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5903650977588132801"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5915820465594209127"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5975777033383448969"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6002352866564347729"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-624442390353999425"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6502539556361269620"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7032140007123265132"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-70591755805933854"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7279034627279850911"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7376125401836766554"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7794213270533888476"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7941665912106614919"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7976842744623875709"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8088023745980736359"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8487015566313487278"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8566491766607722658"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8755040990697026872"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-9125022219997241826"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-9165961187756132353"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1087260334824232817"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1107339592678590356"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1300374604449424929"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1372752801953400699"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1595766985463867229"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1700910066891940131"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1861962808214056146"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2079474561314178171"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2211365961747669838"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2953291064589729249"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_3274475765164550167"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_3316087686867228312"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4099658816967626906"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4114398978561234432"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4437113781045784766"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4522430536109795615"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4844864339334191977"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4998506055709173717"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5196900052625893865"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5218419924534419098"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5267710899612281684"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5396497051205534880"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_569588179352633096"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5735735701858246310"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5999249939616733191"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_612921655668580231"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6215102397609294298"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6273608151558078519"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6332247857572285788"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6387287228819116301"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6530376668697802925"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_700379425727366914"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7055064031518476115"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_717151221327455784"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7994166002291775133"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8172535054961992686"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8227571774284354649"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_829656184298986607"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8382303995622517417"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8410482971724777152"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8490515760943125641"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_871906047505015315"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8773396537514094683"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8846479646384253205"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_898299922266032858"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_9174130300978301228"),
        org.junit.jupiter.params.provider.Arguments.of("XMPSubj"),
        org.junit.jupiter.params.provider.Arguments.of("2ndSubj")
        );
    }
}