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

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests all implemented PostScript operators.
 */
// public class TestOperators extends TestCase
public class TestProzeGen_Type4Tester_popReal_float_TestOperators_testCvr {
    /**
     * Tests the "cvr" operator.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCvr(float param0) throws Exception {
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("-47.8 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("520.9 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 cvr").popReal(param0).isEmpty();
        ExecutionContext context = org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 77 cvr").toExecutionContext();
        assertTrue(context.getStack().pop() instanceof Float, "Expected a real as the result of 'cvr'");
        assertTrue(context.getStack().pop() instanceof Integer, "Expected an int from an integer literal");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCvr_1(float param0) throws Exception {
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("-47.8 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("520.9 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 cvr").popReal(param0).isEmpty();
        ExecutionContext context = org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 77 cvr").toExecutionContext();
        assertTrue(context.getStack().pop() instanceof Float, "Expected a real as the result of 'cvr'");
        // assertTrue("Expected an int from an integer literal", context.getStack().pop() instanceof java.lang.Integer);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCvr_2(float param0) throws Exception {
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("-47.8 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("520.9 cvr").popReal(param0).isEmpty();
        org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 cvr").popReal(param0).isEmpty();
        ExecutionContext context = org.apache.pdfbox.pdmodel.common.function.type4.Type4Tester.create("77 77 cvr").toExecutionContext();
        // assertTrue("Expected a real as the result of 'cvr'", context.getStack().pop() instanceof java.lang.Float);
        assertTrue(context.getStack().pop() instanceof Integer, "Expected an int from an integer literal");
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(-1.0F),
        org.junit.jupiter.params.provider.Arguments.of(-4.0F),
        org.junit.jupiter.params.provider.Arguments.of(-4.5F),
        org.junit.jupiter.params.provider.Arguments.of(-47.8F),
        org.junit.jupiter.params.provider.Arguments.of(-5.0F),
        org.junit.jupiter.params.provider.Arguments.of(-6.0F),
        org.junit.jupiter.params.provider.Arguments.of(0.0F),
        org.junit.jupiter.params.provider.Arguments.of(1.0F),
        org.junit.jupiter.params.provider.Arguments.of(1.5F),
        org.junit.jupiter.params.provider.Arguments.of(2.0F),
        org.junit.jupiter.params.provider.Arguments.of(2147483650.0F),
        org.junit.jupiter.params.provider.Arguments.of(3.0F),
        org.junit.jupiter.params.provider.Arguments.of(520.9F),
        org.junit.jupiter.params.provider.Arguments.of(7.0F),
        org.junit.jupiter.params.provider.Arguments.of(77.0F)
        );
    }
}