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
public class TestProzeGen_Matrix_getValue_int_int_MatrixTest_testScaling {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        assertEquals(4, m.getValue(param0, param1), 0);
        assertEquals(8, m.getValue(param0, param1), 0);
        assertEquals(0, m.getValue(param0, param1), 0);
        assertEquals(12, m.getValue(param0, param1), 0);
        assertEquals(6, m.getValue(param0, param1), 0);
        assertEquals(0, m.getValue(param0, param1), 0);
        assertEquals(15, m.getValue(param0, param1), 0);
        assertEquals(30, m.getValue(param0, param1), 0);
        assertEquals(1, m.getValue(param0, param1), 0);
    }

    /**
     * This method asserts that the matrix values for the given {@link Matrix} object are equal to the pristine, or
     * original, values.
     *
     * @param m
     * 		the Matrix to test.
     */
    private void assertMatrixIsPristine(Matrix m) {
        assertMatrixValuesEqualTo(new float[]{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, m);
    }

    /**
     * This method asserts that the matrix values for the given {@link Matrix} object have the specified values.
     *
     * @param values
     * 		the expected values
     * @param m
     * 		the matrix to test
     */
    private void assertMatrixValuesEqualTo(float[] values, Matrix m) {
        float delta = 1.0E-5F;
        for (int i = 0; i < values.length; i++) {
            // Need to convert a (row, column) coordinate into a straight index.
            int row = ((int) (Math.floor(i / 3)));
            int column = i % 3;
            StringBuilder failureMsg = new StringBuilder();
            failureMsg.append("Incorrect value for matrix[").append(row).append(",").append(column).append("]");
            assertEquals(values[i], m.getValue(row, column), delta,
                    failureMsg.toString());
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_1(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        assertEquals(4, m.getValue(param0, param1), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_2(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        assertEquals(8, m.getValue(param0, param1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_3(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        assertEquals(0, m.getValue(param0, param1), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_4(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        assertEquals(12, m.getValue(param0, param1), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_5(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        assertEquals(6, m.getValue(param0, param1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_6(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        assertEquals(0, m.getValue(param0, param1), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_7(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        assertEquals(15, m.getValue(param0, param1), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_8(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        assertEquals(30, m.getValue(param0, param1), 0);
        // assertEquals(1, m.getValue(2, 2), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testScaling_9(int param0, int param1) {
        Matrix m = new Matrix(2, 4, 4, 2, 15, 30);
        m.scale(2, 3);
        // assertEquals(4, m.getValue(0, 0), 0);
        // assertEquals(8, m.getValue(0, 1), 0);
        // assertEquals(0, m.getValue(0, 2), 0);
        // assertEquals(12, m.getValue(1, 0), 0);
        // assertEquals(6, m.getValue(1, 1), 0);
        // assertEquals(0, m.getValue(1, 2), 0);
        // assertEquals(15, m.getValue(2, 0), 0);
        // assertEquals(30, m.getValue(2, 1), 0);
        assertEquals(1, m.getValue(param0, param1), 0);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0, 0),
        org.junit.jupiter.params.provider.Arguments.of(0, 1),
        org.junit.jupiter.params.provider.Arguments.of(0, 2),
        org.junit.jupiter.params.provider.Arguments.of(1, 0),
        org.junit.jupiter.params.provider.Arguments.of(1, 1),
        org.junit.jupiter.params.provider.Arguments.of(1, 2),
        org.junit.jupiter.params.provider.Arguments.of(2, 0),
        org.junit.jupiter.params.provider.Arguments.of(2, 1),
        org.junit.jupiter.params.provider.Arguments.of(2, 2)
        );
    }
}