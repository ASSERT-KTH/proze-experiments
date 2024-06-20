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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests all implemented PostScript operators.
 */
// public class TestOperators extends TestCase
public class TestProzeGen_Type4Tester_pop_int_TestOperators_testAdd {
    /**
     * Tests the "add" operator.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAdd(int param0) throws Exception {
        Type4Tester.create("5 6 add").pop(param0).isEmpty();
        Type4Tester.create("5 0.23 add").pop(5.23F).isEmpty();
        int bigValue = Integer.MAX_VALUE - 2;
        ExecutionContext context = Type4Tester.create(((bigValue + " ") + bigValue) + " add").toExecutionContext();
        float floatResult = ((Float) (context.getStack().pop()));
        assertEquals((2 * ((long) (Integer.MAX_VALUE))) - 4, floatResult, 1);
        assertTrue(context.getStack().isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAdd_1(int param0) throws Exception {
        Type4Tester.create("5 6 add").pop(param0).isEmpty();
        Type4Tester.create("5 0.23 add").pop(5.23F).isEmpty();
        int bigValue = Integer.MAX_VALUE - 2;
        ExecutionContext context = Type4Tester.create(((bigValue + " ") + bigValue) + " add").toExecutionContext();
        float floatResult = ((Float) (context.getStack().pop()));
        assertEquals((2 * ((long) (Integer.MAX_VALUE))) - 4, floatResult, 1);
        // assertTrue(context.getStack().isEmpty());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testAdd_2(int param0) throws Exception {
        Type4Tester.create("5 6 add").pop(param0).isEmpty();
        Type4Tester.create("5 0.23 add").pop(5.23F).isEmpty();
        int bigValue = Integer.MAX_VALUE - 2;
        ExecutionContext context = Type4Tester.create(((bigValue + " ") + bigValue) + " add").toExecutionContext();
        float floatResult = ((Float) (context.getStack().pop()));
        // assertEquals((2 * ((long) (java.lang.Integer.MAX_VALUE))) - 4, floatResult, 1);
        assertTrue(context.getStack().isEmpty());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(-2),
        org.junit.jupiter.params.provider.Arguments.of(-47),
        org.junit.jupiter.params.provider.Arguments.of(-52),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(2147483647),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(37),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(520),
        org.junit.jupiter.params.provider.Arguments.of(56),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(99)
        );
    }
}