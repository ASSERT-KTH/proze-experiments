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

/**
 * Test the date conversion utility.
 */
public class TestProzeGen_DateConverter_toCalendar_java_lang_String_DateConverterTest_testDateFormatting {
    /**
     * Test formatting ISO8601 date formats.
     *
     * Test with additional time zone
     * information normally not supported by ISO8601
     *
     * @throws Exception
     * 		when there is an exception
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDateFormatting(String param0) throws Exception {
        final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        java.util.Calendar cal = DateConverter.toCalendar(param0);
        assertEquals(dateFormat.format(cal.getTime()), dateFormat.format(DateConverter.toCalendar(param0).getTime()));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("1985-01-05"),
        org.junit.jupiter.params.provider.Arguments.of("2001-02-05T12:32:48Z"),
        org.junit.jupiter.params.provider.Arguments.of("2007-11-09T09:55:36+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2008-01-18T16:59:54+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2008-11-12T15:29:40+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2008-11-12T15:29:43+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2009-04-26T16:56:29-06:00"),
        org.junit.jupiter.params.provider.Arguments.of("2009-11-08T19:16:29+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2010-01-28T14:07:18-05:00"),
        org.junit.jupiter.params.provider.Arguments.of("2010-03-10T14:14:45+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2010-03-22T14:33:11+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2011-11-20T10:09:00Z"),
        org.junit.jupiter.params.provider.Arguments.of("2011-11-20T10:09Z"),
        org.junit.jupiter.params.provider.Arguments.of("2012-03-06T06:30:15Z"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T07:23:35-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T07:59:36-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T07:59:55-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T08:00:01-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T08:00:07-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2012-07-26T08:00:08-04:00"),
        org.junit.jupiter.params.provider.Arguments.of("2014-01-23T20:09:45+01:00"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T08:37:19.192PST"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192+00:00"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192+02:00"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192+05:30"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192+10:30"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192-05:30"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192Europe/Berlin"),
        org.junit.jupiter.params.provider.Arguments.of("2015-02-02T16:37:19.192Z"),
        org.junit.jupiter.params.provider.Arguments.of("2015-12-08T12:07-05:00"),
        org.junit.jupiter.params.provider.Arguments.of("2015-12-08T12:07:00-05:00"),
                org.junit.jupiter.params.provider.Arguments.of("2018-08-17T09:58:37Z")
        );
    }
}