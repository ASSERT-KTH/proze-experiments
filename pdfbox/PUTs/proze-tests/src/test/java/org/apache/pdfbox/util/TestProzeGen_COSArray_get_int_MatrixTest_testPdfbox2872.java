/* Copyright 2015 The Apache Software Foundation.

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
package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Neil McErlean
 * @author Tilman Hausherr
 */
public class TestProzeGen_COSArray_get_int_MatrixTest_testPdfbox2872 {
    /**
     * Test of PDFBOX-2872 bug
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(param0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(param0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(param0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(param0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(param0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_1(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(param0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(1));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(2));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(3));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(4));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(5));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_2(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(0));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(param0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(2));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(3));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(4));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(5));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_3(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(1));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(param0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(3));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(4));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(5));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_4(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(1));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(2));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(param0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(4));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(5));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_5(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(1));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(2));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(3));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(param0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(5));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPdfbox2872_6(int param0) {
        Matrix m = new Matrix(2, 4, 5, 8, 2, 0);
        org.apache.pdfbox.cos.COSArray toCOSArray = m.toCOSArray();
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(0));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(4), toCOSArray.get(1));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(5), toCOSArray.get(2));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(8), toCOSArray.get(3));
        // assertEquals(new org.apache.pdfbox.cos.COSFloat(2), toCOSArray.get(4));
        assertEquals(new org.apache.pdfbox.cos.COSFloat(0), toCOSArray.get(param0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(101),
        org.junit.jupiter.params.provider.Arguments.of(102),
        org.junit.jupiter.params.provider.Arguments.of(103),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(105),
        org.junit.jupiter.params.provider.Arguments.of(106),
        org.junit.jupiter.params.provider.Arguments.of(107),
        org.junit.jupiter.params.provider.Arguments.of(108),
        org.junit.jupiter.params.provider.Arguments.of(109),
        org.junit.jupiter.params.provider.Arguments.of(11),
        org.junit.jupiter.params.provider.Arguments.of(110),
        org.junit.jupiter.params.provider.Arguments.of(111),
        org.junit.jupiter.params.provider.Arguments.of(112),
        org.junit.jupiter.params.provider.Arguments.of(113),
        org.junit.jupiter.params.provider.Arguments.of(114),
        org.junit.jupiter.params.provider.Arguments.of(12),
        org.junit.jupiter.params.provider.Arguments.of(13),
        org.junit.jupiter.params.provider.Arguments.of(14),
        org.junit.jupiter.params.provider.Arguments.of(15),
        org.junit.jupiter.params.provider.Arguments.of(16),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(19),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(20),
        org.junit.jupiter.params.provider.Arguments.of(21),
        org.junit.jupiter.params.provider.Arguments.of(22),
        org.junit.jupiter.params.provider.Arguments.of(23),
        org.junit.jupiter.params.provider.Arguments.of(24),
        org.junit.jupiter.params.provider.Arguments.of(25),
        org.junit.jupiter.params.provider.Arguments.of(26),
        org.junit.jupiter.params.provider.Arguments.of(27),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(29),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(30),
        org.junit.jupiter.params.provider.Arguments.of(31),
        org.junit.jupiter.params.provider.Arguments.of(32),
        org.junit.jupiter.params.provider.Arguments.of(33),
        org.junit.jupiter.params.provider.Arguments.of(34),
        org.junit.jupiter.params.provider.Arguments.of(35),
        org.junit.jupiter.params.provider.Arguments.of(36),
        org.junit.jupiter.params.provider.Arguments.of(37),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(39),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(40),
        org.junit.jupiter.params.provider.Arguments.of(41),
        org.junit.jupiter.params.provider.Arguments.of(42),
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
        org.junit.jupiter.params.provider.Arguments.of(54),
        org.junit.jupiter.params.provider.Arguments.of(55),
        org.junit.jupiter.params.provider.Arguments.of(56),
        org.junit.jupiter.params.provider.Arguments.of(57),
        org.junit.jupiter.params.provider.Arguments.of(58),
        org.junit.jupiter.params.provider.Arguments.of(59),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(60),
        org.junit.jupiter.params.provider.Arguments.of(61),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(63),
        org.junit.jupiter.params.provider.Arguments.of(64),
        org.junit.jupiter.params.provider.Arguments.of(65),
        org.junit.jupiter.params.provider.Arguments.of(66),
        org.junit.jupiter.params.provider.Arguments.of(67),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(69),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(70),
        org.junit.jupiter.params.provider.Arguments.of(71),
        org.junit.jupiter.params.provider.Arguments.of(72),
        org.junit.jupiter.params.provider.Arguments.of(73),
        org.junit.jupiter.params.provider.Arguments.of(74),
        org.junit.jupiter.params.provider.Arguments.of(75),
        org.junit.jupiter.params.provider.Arguments.of(76),
        org.junit.jupiter.params.provider.Arguments.of(77),
        org.junit.jupiter.params.provider.Arguments.of(78),
        org.junit.jupiter.params.provider.Arguments.of(79),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(80),
        org.junit.jupiter.params.provider.Arguments.of(81),
        org.junit.jupiter.params.provider.Arguments.of(82),
        org.junit.jupiter.params.provider.Arguments.of(83),
        org.junit.jupiter.params.provider.Arguments.of(84),
        org.junit.jupiter.params.provider.Arguments.of(85),
        org.junit.jupiter.params.provider.Arguments.of(86),
        org.junit.jupiter.params.provider.Arguments.of(87),
        org.junit.jupiter.params.provider.Arguments.of(88),
        org.junit.jupiter.params.provider.Arguments.of(89),
        org.junit.jupiter.params.provider.Arguments.of(9),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(91),
        org.junit.jupiter.params.provider.Arguments.of(92),
        org.junit.jupiter.params.provider.Arguments.of(93),
        org.junit.jupiter.params.provider.Arguments.of(94),
        org.junit.jupiter.params.provider.Arguments.of(95),
        org.junit.jupiter.params.provider.Arguments.of(96),
        org.junit.jupiter.params.provider.Arguments.of(97),
        org.junit.jupiter.params.provider.Arguments.of(98),
        org.junit.jupiter.params.provider.Arguments.of(99)
        );
    }
}