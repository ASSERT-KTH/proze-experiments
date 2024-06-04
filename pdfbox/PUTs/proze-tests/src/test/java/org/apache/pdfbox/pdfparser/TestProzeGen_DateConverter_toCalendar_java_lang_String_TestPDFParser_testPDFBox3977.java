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
package org.apache.pdfbox.pdfparser;
import org.junit.jupiter.params.provider.NullSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977 {
    private static final String PATH_OF_PDF = "src/test/resources/input/yaddatest.pdf";

    private static final java.io.File tmpDirectory = new java.io.File(System.getProperty("java.io.tmpdir"));

    private static final java.io.File TARGETPDFDIR = new java.io.File("target/pdfs");

    private int numberOfTmpFiles = 0;

    /**
     * Initialize the number of tmp file before the test
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        numberOfTmpFiles = getNumberOfTempFile();
    }

    /**
     * Count the number of temporary files
     *
     * @return  */
    private int getNumberOfTempFile() {
        int result = 0;
        java.io.File[] tmpPdfs = TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.tmpDirectory.listFiles(new java.io.FilenameFilter() {
            @Override
            public boolean accept(java.io.File dir, String name) {
                return name.startsWith(COSParser.TMP_FILE_PREFIX) && name.endsWith("pdf");
            }
        });
        if (tmpPdfs != null) {
            result = tmpPdfs.length;
        }
        return result;
    }

    /**
     * Test whether /Info dictionary is retrieved correctly in brute force search for the
     * Info/Catalog dictionaries.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar(param0), di.getCreationDate());
        assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar(param0), di.getModificationDate());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977_1(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        // assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        // assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20070608151915+02'00'"), di.getCreationDate());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20080604152122+02'00'"), di.getModificationDate());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977_2(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        // assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        // assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20070608151915+02'00'"), di.getCreationDate());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20080604152122+02'00'"), di.getModificationDate());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977_3(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        // assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        // assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20070608151915+02'00'"), di.getCreationDate());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20080604152122+02'00'"), di.getModificationDate());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977_4(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        // assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        // assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        // assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar(param0), di.getCreationDate());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20080604152122+02'00'"), di.getModificationDate());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3977_5(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_DateConverter_toCalendar_java_lang_String_TestPDFParser_testPDFBox3977.TARGETPDFDIR, "PDFBOX-3977-63NGFQRI44HQNPIPEJH5W2TBM6DJZWMI.pdf"));
        org.apache.pdfbox.pdmodel.PDDocumentInformation di = doc.getDocumentInformation();
        // assertEquals("QuarkXPress(tm) 6.52", di.getCreator());
        // assertEquals("Acrobat Distiller 7.0 pour Macintosh", di.getProducer());
        // assertEquals("Fich sal Fabr corr1 (Page 6)", di.getTitle());
        // assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar("D:20070608151915+02'00'"), di.getCreationDate());
        assertEquals(org.apache.pdfbox.util.DateConverter.toCalendar(param0), di.getModificationDate());
        doc.close();
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