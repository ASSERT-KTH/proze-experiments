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
package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests all implemented PostScript operators.
 */
// public class TestOperators extends TestCase
public class TestProzeGen_Type4Tester_create_java_lang_String_TestOperators_testIDiv {
    /**
     * Tests the "div" operator.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIDiv(String param0) throws Exception {
        Type4Tester.create(param0).pop(1).isEmpty();
        Type4Tester.create(param0).pop(2).isEmpty();
        Type4Tester.create(param0).pop(-2).isEmpty();
        try {
            Type4Tester.create(param0);
            fail("Expected typecheck");
        } catch (ClassCastException cce) {
            // expected
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("-100 0 atan"),
        org.junit.jupiter.params.provider.Arguments.of("-2147483647 neg"),
        org.junit.jupiter.params.provider.Arguments.of("-2147483648 neg"),
        org.junit.jupiter.params.provider.Arguments.of("-3 abs 2.1 abs -2.1 abs -7.5 abs"),
        org.junit.jupiter.params.provider.Arguments.of("-3 neg"),
        org.junit.jupiter.params.provider.Arguments.of("-4.8 round"),
        org.junit.jupiter.params.provider.Arguments.of("-4.8 truncate"),
        org.junit.jupiter.params.provider.Arguments.of("-47.8 cvi"),
        org.junit.jupiter.params.provider.Arguments.of("-47.8 cvr"),
        org.junit.jupiter.params.provider.Arguments.of("-5 2 idiv"),
        org.junit.jupiter.params.provider.Arguments.of("-5 3 mod"),
        org.junit.jupiter.params.provider.Arguments.of("-6.5 round"),
        org.junit.jupiter.params.provider.Arguments.of("-9 -1 exp"),
        org.junit.jupiter.params.provider.Arguments.of("-90.0 sin"),
        org.junit.jupiter.params.provider.Arguments.of("0 1 atan"),
        org.junit.jupiter.params.provider.Arguments.of("0 cos"),
        org.junit.jupiter.params.provider.Arguments.of("0 sin"),
        org.junit.jupiter.params.provider.Arguments.of("0 sqrt"),
        org.junit.jupiter.params.provider.Arguments.of("1 0 atan"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 3 0 roll"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 4 0 index"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 4 3 index"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 4 5 5 -2 roll"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 4 5 5 2 roll"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 3 pop pop"),
        org.junit.jupiter.params.provider.Arguments.of("1 2 mul"),
        org.junit.jupiter.params.provider.Arguments.of("1 2.5 exch"),
        org.junit.jupiter.params.provider.Arguments.of("1 pop 7 2 pop"),
        org.junit.jupiter.params.provider.Arguments.of("1 sqrt"),
        org.junit.jupiter.params.provider.Arguments.of("1 {dup dup .72 mul exch 0 exch .38 mul}"),
        org.junit.jupiter.params.provider.Arguments.of("1.5 2 mul"),
        org.junit.jupiter.params.provider.Arguments.of("1.5 2.1 mul"),
        org.junit.jupiter.params.provider.Arguments.of("10 ln"),
        org.junit.jupiter.params.provider.Arguments.of("10 log"),
        org.junit.jupiter.params.provider.Arguments.of("100 ln"),
        org.junit.jupiter.params.provider.Arguments.of("100 log"),
        org.junit.jupiter.params.provider.Arguments.of("17 5 or 1 1 or"),
        org.junit.jupiter.params.provider.Arguments.of("2147483644 2 mul"),
        org.junit.jupiter.params.provider.Arguments.of("2147483645 2147483645 add"),
        org.junit.jupiter.params.provider.Arguments.of("3 2 div"),
        org.junit.jupiter.params.provider.Arguments.of("3 2 idiv"),
        org.junit.jupiter.params.provider.Arguments.of("3 4 add 2 sub"),
        org.junit.jupiter.params.provider.Arguments.of("3.2 ceiling -4.8 ceiling 99 ceiling"),
        org.junit.jupiter.params.provider.Arguments.of("3.2 floor -4.8 floor 99 floor"),
        org.junit.jupiter.params.provider.Arguments.of("3.2 round"),
        org.junit.jupiter.params.provider.Arguments.of("3.2 truncate"),
        org.junit.jupiter.params.provider.Arguments.of("4 2 div"),
        org.junit.jupiter.params.provider.Arguments.of("4 2 idiv"),
        org.junit.jupiter.params.provider.Arguments.of("4 4 atan"),
        org.junit.jupiter.params.provider.Arguments.of("4 sqrt"),
        org.junit.jupiter.params.provider.Arguments.of("4.4 sqrt"),
        org.junit.jupiter.params.provider.Arguments.of("4.5 neg"),
        org.junit.jupiter.params.provider.Arguments.of("5 0.23 add"),
        org.junit.jupiter.params.provider.Arguments.of("5 2 mod"),
        org.junit.jupiter.params.provider.Arguments.of("5 2 sub -7.5 1 sub"),
        org.junit.jupiter.params.provider.Arguments.of("5 3 mod"),
        org.junit.jupiter.params.provider.Arguments.of("5 6 add"),
        org.junit.jupiter.params.provider.Arguments.of("5 7 ge 7 5 ge 7 7 ge -1 2 ge"),
        org.junit.jupiter.params.provider.Arguments.of("5 7 gt 7 5 gt 7 7 gt -1 2 gt"),
        org.junit.jupiter.params.provider.Arguments.of("5 7 le 7 5 le 7 7 le -1 2 le"),
        org.junit.jupiter.params.provider.Arguments.of("5 7 lt 7 5 lt 7 7 lt -1 2 lt"),
        org.junit.jupiter.params.provider.Arguments.of("52 not -37 not"),
        org.junit.jupiter.params.provider.Arguments.of("520.9 cvi"),
        org.junit.jupiter.params.provider.Arguments.of("520.9 cvr"),
        org.junit.jupiter.params.provider.Arguments.of("6.5 round"),
        org.junit.jupiter.params.provider.Arguments.of("7 3 bitshift 142 -3 bitshift"),
        org.junit.jupiter.params.provider.Arguments.of("7 3 xor 12 3 or"),
        org.junit.jupiter.params.provider.Arguments.of("7 7 eq 7 6 eq 7 -7 eq true true eq false true eq 7.7 7.7 eq"),
        org.junit.jupiter.params.provider.Arguments.of("7 7 ne 7 6 ne 7 -7 ne true true ne false true ne 7.7 7.7 ne"),
        org.junit.jupiter.params.provider.Arguments.of("77 77 cvr"),
        org.junit.jupiter.params.provider.Arguments.of("77 cvr"),
        org.junit.jupiter.params.provider.Arguments.of("9 0.5 exp"),
        org.junit.jupiter.params.provider.Arguments.of("90 cos"),
        org.junit.jupiter.params.provider.Arguments.of("90 sin"),
        org.junit.jupiter.params.provider.Arguments.of("99 1 and 52 7 and"),
        org.junit.jupiter.params.provider.Arguments.of("99 round"),
        org.junit.jupiter.params.provider.Arguments.of("99 truncate"),
        org.junit.jupiter.params.provider.Arguments.of("false { 2 1 add } if"),
        org.junit.jupiter.params.provider.Arguments.of("false { 2 1 add } { 2 1 sub } ifelse"),
        org.junit.jupiter.params.provider.Arguments.of("true 1 2 3 3 copy"),
        org.junit.jupiter.params.provider.Arguments.of("true 1 2 dup"),
        org.junit.jupiter.params.provider.Arguments.of("true 1 exch"),
        org.junit.jupiter.params.provider.Arguments.of("true dup"),
        org.junit.jupiter.params.provider.Arguments.of("true not false not"),
        org.junit.jupiter.params.provider.Arguments.of("true true and true false and"),
        org.junit.jupiter.params.provider.Arguments.of("true true or true false or false false or"),
        org.junit.jupiter.params.provider.Arguments.of("true true xor true false xor false false xor"),
        org.junit.jupiter.params.provider.Arguments.of("true { 2 1 add } if"),
        org.junit.jupiter.params.provider.Arguments.of("true { 2 1 add } { 2 1 sub } ifelse"),
        org.junit.jupiter.params.provider.Arguments.of("{ true }")
        );
    }
}