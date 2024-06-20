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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.preflight.ValidationResult;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class of SynchronizedMetaDataValidation (for 6-7-3 Isartor Tests)
 *
 * @author Germain Costenobel
 */
public class TestProzeGen_DateConverter_toCalendar_java_lang_String_pdf_TestSynchronizedMetadataValidation_testPDFBox4292 {
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
        sync = new SynchronizedMetaDataValidation();
    }

    @org.junit.jupiter.api.BeforeEach
    public void initNewDocumentInformation() throws Exception {
        doc = new org.apache.pdfbox.pdmodel.PDDocument();
        dico = doc.getDocumentInformation();
        metadata = org.apache.xmpbox.XMPMetadata.createXMPMetadata();
    }

    /**
     * Tests that two date values, which are from different time zones but
     * really identical, are detected as such.
     *
     * @throws Exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox4292(String param0) throws Exception {
        initValues();
        java.util.Calendar cal1 = org.apache.pdfbox.util.DateConverter.toCalendar(param0);
        java.util.Calendar cal2 = org.apache.xmpbox.DateConverter.toCalendar("2018-08-17T09:58:37Z");
        org.apache.xmpbox.schema.XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();
        dico.setCreationDate(cal1);
        xmp.setCreateDate(cal2);
        dico.setModificationDate(cal1);
        xmp.setModifyDate(cal2);
        // Launching synchronization test
        try {
            ve = sync.validateMetadataSynchronization(doc, metadata);
            // Test unsynchronized value
            assertEquals(0, ve.size());
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
                org.junit.jupiter.params.provider.Arguments.of("  20090319 200122"),
                org.junit.jupiter.params.provider.Arguments.of(" 2000 Feb 29 GMT + 11:00"),
                org.junit.jupiter.params.provider.Arguments.of(" 2000 Feb 29 GMT + 11:30"),
                org.junit.jupiter.params.provider.Arguments.of(" 2000 Feb 29 UTC + 11:00"),
                org.junit.jupiter.params.provider.Arguments.of(" Sun, January 11, 2015 "),
                org.junit.jupiter.params.provider.Arguments.of("07/06/1986"),
                org.junit.jupiter.params.provider.Arguments.of("1/1/43"),
                org.junit.jupiter.params.provider.Arguments.of("1/1/45 00:00:00"),
                org.junit.jupiter.params.provider.Arguments.of("1960-7-6T17:22:1EST"),
                org.junit.jupiter.params.provider.Arguments.of("1970 12 23:08"),
                org.junit.jupiter.params.provider.Arguments.of("1975-7-6T17:22:1-1000"),
                org.junit.jupiter.params.provider.Arguments.of("1976-7-6T17:22:1GMT-4"),
                org.junit.jupiter.params.provider.Arguments.of("19910706 17:7:1 Z+0600"),
                org.junit.jupiter.params.provider.Arguments.of("19920401 24:25"),
                org.junit.jupiter.params.provider.Arguments.of("19920706 17:07:01"),
                org.junit.jupiter.params.provider.Arguments.of("19921001 11:60"),
                org.junit.jupiter.params.provider.Arguments.of("19921232 11:25"),
                org.junit.jupiter.params.provider.Arguments.of("19921301 11:25"),
                org.junit.jupiter.params.provider.Arguments.of("19930706+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19940706+01'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19950706+02'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19960706+03'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19970706-10'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19980706-11'00'"),
                org.junit.jupiter.params.provider.Arguments.of("19990706"),
                org.junit.jupiter.params.provider.Arguments.of("2000 Feb 29"),
                org.junit.jupiter.params.provider.Arguments.of("2001-01-31T10:33+01:00  "),
                org.junit.jupiter.params.provider.Arguments.of("2001-01-31T10:33.123+01:00"),
                org.junit.jupiter.params.provider.Arguments.of("200312172:2:3"),
                org.junit.jupiter.params.provider.Arguments.of("20070430193647+713'00' illegal tz hr"),
                org.junit.jupiter.params.provider.Arguments.of("20110423"),
                org.junit.jupiter.params.provider.Arguments.of("2012 Feb 29 GMT+11"),
                org.junit.jupiter.params.provider.Arguments.of("2012 Feb 30 GMT+11"),
                org.junit.jupiter.params.provider.Arguments.of("2013"),
                org.junit.jupiter.params.provider.Arguments.of("20140326172513Z"),
                org.junit.jupiter.params.provider.Arguments.of("20140401+0200"),
                org.junit.jupiter.params.provider.Arguments.of("20160401+04'00'"),
                org.junit.jupiter.params.provider.Arguments.of("20160401+04'30'"),
                org.junit.jupiter.params.provider.Arguments.of("20170401+09'00'"),
                org.junit.jupiter.params.provider.Arguments.of("20170401+09'30'"),
                org.junit.jupiter.params.provider.Arguments.of("20180401-02'00'"),
                org.junit.jupiter.params.provider.Arguments.of("20180401-02'30'"),
                org.junit.jupiter.params.provider.Arguments.of("20190401 6:1:1 -1100"),
                org.junit.jupiter.params.provider.Arguments.of("20190401 6:1:1 -1130"),
                org.junit.jupiter.params.provider.Arguments.of("2073 12 25:08"),
                org.junit.jupiter.params.provider.Arguments.of("2076-7-6T17:22:1EDT"),
                org.junit.jupiter.params.provider.Arguments.of("2100 Feb 29 GMT+11"),
                org.junit.jupiter.params.provider.Arguments.of("26 May 2020 11:25:10"),
                org.junit.jupiter.params.provider.Arguments.of("26 May 2021 11:23"),
                org.junit.jupiter.params.provider.Arguments.of("32 May 2000 11:25"),
                org.junit.jupiter.params.provider.Arguments.of("333three digit year"),
                org.junit.jupiter.params.provider.Arguments.of("5/12/2005 15:57:16"),
                org.junit.jupiter.params.provider.Arguments.of("6 Jul 1982 17:22:1"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1973 17:22:1"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1974"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1983 17:22:1"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1984 17:22:01"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1985"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1987 17:22:1"),
                org.junit.jupiter.params.provider.Arguments.of("7/6/1988"),
                org.junit.jupiter.params.provider.Arguments.of("9:47 5/12/2002"),
                org.junit.jupiter.params.provider.Arguments.of("D:"),
                org.junit.jupiter.params.provider.Arguments.of("D:    "),
                org.junit.jupiter.params.provider.Arguments.of("D:05/12/2005"),
                org.junit.jupiter.params.provider.Arguments.of("D:20050526205258+01'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20070608151915+02'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20080604152122+02'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20080819141517-04'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20080819141521-04'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20100423"),
                org.junit.jupiter.params.provider.Arguments.of("D:2012"),
                org.junit.jupiter.params.provider.Arguments.of("D:20140326142505-02'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20140326172513Z"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150319+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150324+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150329+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150340+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150431+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150432+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150458+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150536+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150554+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20160411160115+12'00'"),
                org.junit.jupiter.params.provider.Arguments.of("Friday July 6 17:22:1 GMT+08:00 1979"),
                org.junit.jupiter.params.provider.Arguments.of("Friday, January 11, 2115"),
                org.junit.jupiter.params.provider.Arguments.of("Monday, Jan 11, 1915"),
                org.junit.jupiter.params.provider.Arguments.of("Monday, July 6, 1981"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of("Sun, Jul 6, 1980 at 4:23pm"),
                org.junit.jupiter.params.provider.Arguments.of("Thu Jul 6, 1978 17:22:1"),
                org.junit.jupiter.params.provider.Arguments.of("Thu, July 6, 1972 5:22:1 pm"),
                org.junit.jupiter.params.provider.Arguments.of("Tuesday, 6 Jul 1971 5:22:1 PM"),
                org.junit.jupiter.params.provider.Arguments.of("Tuesday, July 28, 1998 4:00:09 PM"),
                org.junit.jupiter.params.provider.Arguments.of("Tuesday, May 32 2000 11:25"),
                org.junit.jupiter.params.provider.Arguments.of("Tuesday, May 32 2000 11:27 UCT"),
                org.junit.jupiter.params.provider.Arguments.of("Unknown"),
                org.junit.jupiter.params.provider.Arguments.of("Wed, January 11, 2215"),
                org.junit.jupiter.params.provider.Arguments.of("Wednesday, Jul 6, 1977"),
                org.junit.jupiter.params.provider.Arguments.of("nodigits"),
                org.junit.jupiter.params.provider.Arguments.of("20180817115837+02'00'")
        );
    }
}