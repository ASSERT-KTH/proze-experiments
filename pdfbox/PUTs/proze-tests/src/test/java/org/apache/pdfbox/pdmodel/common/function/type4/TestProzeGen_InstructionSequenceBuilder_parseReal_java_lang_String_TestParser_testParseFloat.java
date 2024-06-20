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

/**
 * Tests the type 4 function parser.
 */
// public class TestParser extends TestCase
public class TestProzeGen_InstructionSequenceBuilder_parseReal_java_lang_String_TestParser_testParseFloat {
    /**
     * Tests parsing of real values.
     *
     * @throws Exception
     * 		if an error occurs
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat(String param0) throws Exception {
        assertEquals(0, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(-1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(3.14157, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(-1.2, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        assertEquals(1.0E-5, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_1(String param0) throws Exception {
        assertEquals(0, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_2(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        assertEquals(1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_3(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        assertEquals(1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_4(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        assertEquals(-1, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_5(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        assertEquals(3.14157, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_6(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        assertEquals(-1.2, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
        // assertEquals(1.0E-5, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1.0E-5"), 1.0E-5F);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testParseFloat_7(String param0) throws Exception {
        // assertEquals(0, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("0"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("1"), 1.0E-5F);
        // assertEquals(1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("+1"), 1.0E-5F);
        // assertEquals(-1, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1"), 1.0E-5F);
        // assertEquals(3.14157, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("3.14157"), 1.0E-5F);
        // assertEquals(-1.2, org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder.parseReal("-1.2"), 1.0E-5F);
        assertEquals(1.0E-5, InstructionSequenceBuilder.parseReal(param0), 1.0E-5F);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("+1"),
        org.junit.jupiter.params.provider.Arguments.of("-1"),
        org.junit.jupiter.params.provider.Arguments.of("-1.2"),
        org.junit.jupiter.params.provider.Arguments.of("-2.1"),
        org.junit.jupiter.params.provider.Arguments.of("-4.1"),
        org.junit.jupiter.params.provider.Arguments.of("-4.8"),
        org.junit.jupiter.params.provider.Arguments.of("-47.8"),
        org.junit.jupiter.params.provider.Arguments.of("-6.5"),
        org.junit.jupiter.params.provider.Arguments.of("-7.5"),
        org.junit.jupiter.params.provider.Arguments.of("-90.0"),
        org.junit.jupiter.params.provider.Arguments.of(".38"),
        org.junit.jupiter.params.provider.Arguments.of(".72"),
        org.junit.jupiter.params.provider.Arguments.of("0"),
        org.junit.jupiter.params.provider.Arguments.of("0.23"),
        org.junit.jupiter.params.provider.Arguments.of("0.5"),
        org.junit.jupiter.params.provider.Arguments.of("1"),
        org.junit.jupiter.params.provider.Arguments.of("1.000000"),
        org.junit.jupiter.params.provider.Arguments.of("1.0E-5"),
        org.junit.jupiter.params.provider.Arguments.of("1.5"),
        org.junit.jupiter.params.provider.Arguments.of("2.1"),
        org.junit.jupiter.params.provider.Arguments.of("2.5"),
        org.junit.jupiter.params.provider.Arguments.of("3.14157"),
        org.junit.jupiter.params.provider.Arguments.of("3.2"),
        org.junit.jupiter.params.provider.Arguments.of("4.4"),
        org.junit.jupiter.params.provider.Arguments.of("4.5"),
        org.junit.jupiter.params.provider.Arguments.of("520.9"),
        org.junit.jupiter.params.provider.Arguments.of("6.5"),
        org.junit.jupiter.params.provider.Arguments.of("7.7")
        );
    }
}