/* Copyright 2014 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unittest for org.apache.pdfbox.pdfparser.InputStreamSource
 */
public class TestProzeGen_InputStreamSource_readFully_int_InputStreamSourceTest_testPositionUnreadBytes {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_1(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        // assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        // assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        // assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_2(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        // assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        // assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        // assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_3(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        // assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        // assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        // assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_4(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        // assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        // assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        // assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        // assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
//        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_5(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        // assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        // assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        // assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        // assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPositionUnreadBytes_6(int param0) throws java.io.IOException {
        byte[] inputValues = new byte[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(inputValues);
        InputStreamSource inputStreamSource = new InputStreamSource(bais);
        // assertEquals(0, inputStreamSource.getPosition());
        inputStreamSource.read();
        inputStreamSource.read();
        byte[] readBytes = inputStreamSource.readFully(param0);
        // assertEquals(8, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes);
        // assertEquals(2, inputStreamSource.getPosition());
        inputStreamSource.read();
//        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.read(readBytes, 2, 4);
        // assertEquals(7, inputStreamSource.getPosition());
        inputStreamSource.unread(readBytes, 2, 4);
        assertEquals(3, inputStreamSource.getPosition());
        inputStreamSource.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(109),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(29),
        org.junit.jupiter.params.provider.Arguments.of(30),
        org.junit.jupiter.params.provider.Arguments.of(31),
        org.junit.jupiter.params.provider.Arguments.of(33),
        org.junit.jupiter.params.provider.Arguments.of(35),
        org.junit.jupiter.params.provider.Arguments.of(36),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(40),
        org.junit.jupiter.params.provider.Arguments.of(41),
        org.junit.jupiter.params.provider.Arguments.of(43),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(45),
        org.junit.jupiter.params.provider.Arguments.of(46),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(48),
        org.junit.jupiter.params.provider.Arguments.of(49),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(50),
        org.junit.jupiter.params.provider.Arguments.of(51),
        org.junit.jupiter.params.provider.Arguments.of(52),
        org.junit.jupiter.params.provider.Arguments.of(53),
        org.junit.jupiter.params.provider.Arguments.of(56),
        org.junit.jupiter.params.provider.Arguments.of(57),
        org.junit.jupiter.params.provider.Arguments.of(58),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(60),
        org.junit.jupiter.params.provider.Arguments.of(61),
        org.junit.jupiter.params.provider.Arguments.of(63),
        org.junit.jupiter.params.provider.Arguments.of(64),
        org.junit.jupiter.params.provider.Arguments.of(66),
        org.junit.jupiter.params.provider.Arguments.of(67),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(89),
        org.junit.jupiter.params.provider.Arguments.of(92),
        org.junit.jupiter.params.provider.Arguments.of(96),
                org.junit.jupiter.params.provider.Arguments.of(10)
        );
    }
}