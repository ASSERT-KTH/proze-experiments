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
public class TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testSimpleReadWrite {
    private static final int CHUNK_SIZE = 1024;

    /**
     * Test the {@link RandomAccessBuffer#read()}
     * and {@link RandomAccessBuffer#write(int)} method.
     *
     * @throws IOException
     * 		is thrown if something went wrong.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSimpleReadWrite(int param0) throws IOException {
        // create a buffer filled with 10 figures from 0 to 9
        RandomAccessBuffer buffer = new RandomAccessBuffer();
        for (int i = 0; i < 10; i++) {
            buffer.write(param0);
        }
        // jump back to the beginning of the buffer
        buffer.seek(0);
        // sum up all figures, the result should be 45
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += buffer.read();
        }
        assertEquals(45, result);
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