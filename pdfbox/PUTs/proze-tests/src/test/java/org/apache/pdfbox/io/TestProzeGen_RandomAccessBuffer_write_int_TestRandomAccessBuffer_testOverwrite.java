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
package org.apache.pdfbox.io;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a unit test for {@link RandomAccessBuffer}.
 */
// public class TestRandomAccessBuffer extends TestCase
public class TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite {
    private static final int CHUNK_SIZE = 1024;

    /**
     * Test if overwriting works.
     *
     * @throws IOException
     * 		is thrown if something went wrong.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOverwrite(int param0) throws IOException {
        byte[] byteArray = new byte[TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100];
        RandomAccessBuffer buffer = new RandomAccessBuffer();
        for (int i = TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE; i < (TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100); i++) {
            byteArray[i] = 1;
        }
        buffer.write(byteArray);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        assertEquals(5, result);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        assertEquals(25, result);
        buffer.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOverwrite_1(int param0) throws IOException {
        byte[] byteArray = new byte[TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100];
        RandomAccessBuffer buffer = new RandomAccessBuffer();
        for (int i = TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE; i < (TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100); i++) {
            byteArray[i] = 1;
        }
        buffer.write(byteArray);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        assertEquals(5, result);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        // assertEquals(25, result);
        buffer.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testOverwrite_2(int param0) throws IOException {
        byte[] byteArray = new byte[TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100];
        RandomAccessBuffer buffer = new RandomAccessBuffer();
        for (int i = TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE; i < (TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE + 100); i++) {
            byteArray[i] = 1;
        }
        buffer.write(byteArray);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        // assertEquals(5, result);
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        for (int i = 0; i < 5; i++) {
            buffer.write(param0);
        }
        buffer.seek(TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testOverwrite.CHUNK_SIZE - 5);
        byteArray = new byte[10];
        buffer.read(byteArray, 0, byteArray.length);
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += byteArray[i];
        }
        assertEquals(25, result);
        buffer.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(5),
        org.junit.jupiter.params.provider.Arguments.of(6),
        org.junit.jupiter.params.provider.Arguments.of(7),
        org.junit.jupiter.params.provider.Arguments.of(8),
        org.junit.jupiter.params.provider.Arguments.of(9)
        );
    }
}