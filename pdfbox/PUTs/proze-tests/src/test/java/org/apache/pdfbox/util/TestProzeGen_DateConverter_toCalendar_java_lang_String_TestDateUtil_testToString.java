/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.util;

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the date conversion utility.
 *
 * @author Ben Litchfield
 * @author Fred Hansen
 */
// public class TestDateUtil extends TestCase
public class TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString {
    private static final int MINS = 60 * 1000;

    private static final int HRS = 60 * TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.MINS;

    // expect parse fail
    private static final int BAD = -666;

    private static void checkToString(int yr, int mon, int day, int hr, int min, int sec, java.util.TimeZone tz, int offsetHours, int offsetMinutes) throws Exception {
        // construct a GregoreanCalendar from args
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar(tz, java.util.Locale.ENGLISH);
        cal.set(yr, mon - 1, day, hr, min, sec);
        // create expected strings
        String pdfDate = String.format(java.util.Locale.US, "D:%04d%02d%02d%02d%02d%02d%+03d'%02d'", yr, mon, day, hr, min, sec, offsetHours, offsetMinutes);
        String iso8601Date = String.format(java.util.Locale.US, "%04d-%02d-%02d" + "T%02d:%02d:%02d%+03d:%02d", yr, mon, day, hr, min, sec, offsetHours, offsetMinutes);
        // compare outputs from toString and toISO8601 with expected values
        assertEquals(pdfDate, DateConverter.toString(cal));
        assertEquals(iso8601Date, DateConverter.toISO8601(cal));
    }

    /**
     * Test toString() and toISO8601() for various dates.
     *
     * @throws Exception
     * 		if something went wrong.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testToString(String param0) throws Exception {
        java.util.TimeZone tzPgh = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.TimeZone tzBerlin = java.util.TimeZone.getTimeZone("Europe/Berlin");
        java.util.TimeZone tzMaputo = java.util.TimeZone.getTimeZone("Africa/Maputo");
        java.util.TimeZone tzAruba = java.util.TimeZone.getTimeZone("America/Aruba");
        java.util.TimeZone tzJamaica = java.util.TimeZone.getTimeZone("America/Jamaica");
        java.util.TimeZone tzMcMurdo = java.util.TimeZone.getTimeZone("Antartica/McMurdo");
        java.util.TimeZone tzAdelaide = java.util.TimeZone.getTimeZone("Australia/Adelaide");
        assertNull(DateConverter.toCalendar(((org.apache.pdfbox.cos.COSString) (null))));
        assertNull(DateConverter.toCalendar(param0));
        assertNull(DateConverter.toCalendar(param0));
        assertNull(DateConverter.toCalendar(param0));
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2013, 8, 28, 3, 14, 15, tzPgh, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2014, 2, 28, 3, 14, 15, tzPgh, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzBerlin, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzBerlin, +1, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2017, 8, 28, 3, 14, 15, tzAruba, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2018, 1, 1, 1, 14, 15, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2019, 12, 31, 12, 59, 59, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2020, 2, 29, 0, 0, 0, tzMaputo, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzAdelaide, +9, 30);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzAdelaide, +10, 30);
        for (int m = 1; m <= 12; ++m) {
            TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(1980 + m, m, 1, 1, 14, 15, tzMcMurdo, +0, 0);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testToString_1(String param0) throws Exception {
        java.util.TimeZone tzPgh = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.TimeZone tzBerlin = java.util.TimeZone.getTimeZone("Europe/Berlin");
        java.util.TimeZone tzMaputo = java.util.TimeZone.getTimeZone("Africa/Maputo");
        java.util.TimeZone tzAruba = java.util.TimeZone.getTimeZone("America/Aruba");
        java.util.TimeZone tzJamaica = java.util.TimeZone.getTimeZone("America/Jamaica");
        java.util.TimeZone tzMcMurdo = java.util.TimeZone.getTimeZone("Antartica/McMurdo");
        java.util.TimeZone tzAdelaide = java.util.TimeZone.getTimeZone("Australia/Adelaide");
        assertNull(DateConverter.toCalendar(((org.apache.pdfbox.cos.COSString) (null))));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((java.lang.String) (null))));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:    "));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:"));
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2013, 8, 28, 3, 14, 15, tzPgh, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2014, 2, 28, 3, 14, 15, tzPgh, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzBerlin, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzBerlin, +1, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2017, 8, 28, 3, 14, 15, tzAruba, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2018, 1, 1, 1, 14, 15, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2019, 12, 31, 12, 59, 59, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2020, 2, 29, 0, 0, 0, tzMaputo, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzAdelaide, +9, 30);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzAdelaide, +10, 30);
        for (int m = 1; m <= 12; ++m) {
            TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(1980 + m, m, 1, 1, 14, 15, tzMcMurdo, +0, 0);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testToString_2(String param0) throws Exception {
        java.util.TimeZone tzPgh = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.TimeZone tzBerlin = java.util.TimeZone.getTimeZone("Europe/Berlin");
        java.util.TimeZone tzMaputo = java.util.TimeZone.getTimeZone("Africa/Maputo");
        java.util.TimeZone tzAruba = java.util.TimeZone.getTimeZone("America/Aruba");
        java.util.TimeZone tzJamaica = java.util.TimeZone.getTimeZone("America/Jamaica");
        java.util.TimeZone tzMcMurdo = java.util.TimeZone.getTimeZone("Antartica/McMurdo");
        java.util.TimeZone tzAdelaide = java.util.TimeZone.getTimeZone("Australia/Adelaide");
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((org.apache.pdfbox.cos.COSString) (null))));
        assertNull(DateConverter.toCalendar(param0));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:    "));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:"));
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2013, 8, 28, 3, 14, 15, tzPgh, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2014, 2, 28, 3, 14, 15, tzPgh, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzBerlin, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzBerlin, +1, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2017, 8, 28, 3, 14, 15, tzAruba, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2018, 1, 1, 1, 14, 15, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2019, 12, 31, 12, 59, 59, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2020, 2, 29, 0, 0, 0, tzMaputo, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzAdelaide, +9, 30);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzAdelaide, +10, 30);
        for (int m = 1; m <= 12; ++m) {
            TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(1980 + m, m, 1, 1, 14, 15, tzMcMurdo, +0, 0);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testToString_3(String param0) throws Exception {
        java.util.TimeZone tzPgh = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.TimeZone tzBerlin = java.util.TimeZone.getTimeZone("Europe/Berlin");
        java.util.TimeZone tzMaputo = java.util.TimeZone.getTimeZone("Africa/Maputo");
        java.util.TimeZone tzAruba = java.util.TimeZone.getTimeZone("America/Aruba");
        java.util.TimeZone tzJamaica = java.util.TimeZone.getTimeZone("America/Jamaica");
        java.util.TimeZone tzMcMurdo = java.util.TimeZone.getTimeZone("Antartica/McMurdo");
        java.util.TimeZone tzAdelaide = java.util.TimeZone.getTimeZone("Australia/Adelaide");
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((org.apache.pdfbox.cos.COSString) (null))));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((java.lang.String) (null))));
        assertNull(DateConverter.toCalendar(param0));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:"));
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2013, 8, 28, 3, 14, 15, tzPgh, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2014, 2, 28, 3, 14, 15, tzPgh, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzBerlin, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzBerlin, +1, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2017, 8, 28, 3, 14, 15, tzAruba, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2018, 1, 1, 1, 14, 15, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2019, 12, 31, 12, 59, 59, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2020, 2, 29, 0, 0, 0, tzMaputo, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzAdelaide, +9, 30);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzAdelaide, +10, 30);
        for (int m = 1; m <= 12; ++m) {
            TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(1980 + m, m, 1, 1, 14, 15, tzMcMurdo, +0, 0);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testToString_4(String param0) throws Exception {
        java.util.TimeZone tzPgh = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.TimeZone tzBerlin = java.util.TimeZone.getTimeZone("Europe/Berlin");
        java.util.TimeZone tzMaputo = java.util.TimeZone.getTimeZone("Africa/Maputo");
        java.util.TimeZone tzAruba = java.util.TimeZone.getTimeZone("America/Aruba");
        java.util.TimeZone tzJamaica = java.util.TimeZone.getTimeZone("America/Jamaica");
        java.util.TimeZone tzMcMurdo = java.util.TimeZone.getTimeZone("Antartica/McMurdo");
        java.util.TimeZone tzAdelaide = java.util.TimeZone.getTimeZone("Australia/Adelaide");
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((org.apache.pdfbox.cos.COSString) (null))));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar(((java.lang.String) (null))));
        // assertNull(org.apache.pdfbox.util.DateConverter.toCalendar("D:    "));
        assertNull(DateConverter.toCalendar(param0));
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2013, 8, 28, 3, 14, 15, tzPgh, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2014, 2, 28, 3, 14, 15, tzPgh, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzBerlin, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzBerlin, +1, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2017, 8, 28, 3, 14, 15, tzAruba, -4, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2018, 1, 1, 1, 14, 15, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2019, 12, 31, 12, 59, 59, tzJamaica, -5, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2020, 2, 29, 0, 0, 0, tzMaputo, +2, 0);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2015, 8, 28, 3, 14, 15, tzAdelaide, +9, 30);
        TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(2016, 2, 28, 3, 14, 15, tzAdelaide, +10, 30);
        for (int m = 1; m <= 12; ++m) {
            TestProzeGen_DateConverter_toCalendar_java_lang_String_TestDateUtil_testToString.checkToString(1980 + m, m, 1, 1, 14, 15, tzMcMurdo, +0, 0);
        }
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