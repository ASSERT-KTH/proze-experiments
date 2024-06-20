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
public class TestProzeGen_Type4Tester_popReal_float_TestOperators_testSqrt {

    /**
     * Tests the "sqrt" operator.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSqrt(float param0) throws Exception {
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("0 sqrt").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("1 sqrt").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("4 sqrt").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("4.4 sqrt").popReal(2.097617F, 1.0E-6).isEmpty();
        try {
            org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("-4.1 sqrt");
            fail("Expected rangecheck");
        } catch (IllegalArgumentException iae) {
            // expected
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(-1.0),
        org.junit.jupiter.params.provider.Arguments.of(-4.0),
        org.junit.jupiter.params.provider.Arguments.of(-4.5),
        org.junit.jupiter.params.provider.Arguments.of(-47.8),
        org.junit.jupiter.params.provider.Arguments.of(-5.0),
        org.junit.jupiter.params.provider.Arguments.of(-6.0),
        org.junit.jupiter.params.provider.Arguments.of(0.0),
        org.junit.jupiter.params.provider.Arguments.of(1.0),
        org.junit.jupiter.params.provider.Arguments.of(1.5),
        org.junit.jupiter.params.provider.Arguments.of(2.0),
        org.junit.jupiter.params.provider.Arguments.of(2147483650.0),
        org.junit.jupiter.params.provider.Arguments.of(3.0),
        org.junit.jupiter.params.provider.Arguments.of(520.9),
        org.junit.jupiter.params.provider.Arguments.of(7.0),
        org.junit.jupiter.params.provider.Arguments.of(77.0)
        );
    }
}