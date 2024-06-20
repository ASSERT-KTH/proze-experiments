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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a unit test for {@link RandomAccessBuffer}.
 */
// public class TestRandomAccessBuffer extends TestCase
public class TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testPDFBOX2969 {
    private static final int CHUNK_SIZE = 1024;

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBOX2969(int param0) throws Exception {
        // create buffer with non-default chunk size
        // by providing an array with unusual size
        // (larger than RandomAccessBuffer.DEFAULT_CHUNK_SIZE)
        int chunkSize = (TestProzeGen_RandomAccessBuffer_write_int_TestRandomAccessBuffer_testPDFBOX2969.CHUNK_SIZE << 4) + 3;
        byte[] byteArray = new byte[chunkSize];
        RandomAccessBuffer buffer = new RandomAccessBuffer(byteArray);
        // fill completely
        for (int i = 0; i < chunkSize; i++) {
            buffer.write(param0);
        }
        // create clone
        RandomAccessBuffer bufferClone = buffer.clone();
        // read all from both
        buffer.seek(0);
        int bufRead = buffer.read(new byte[((int) (buffer.length()))]);
        bufferClone.seek(0);
        int bufCloneRead = bufferClone.read(new byte[((int) (bufferClone.length()))]);
        assertEquals(bufRead, bufCloneRead);
        buffer.close();
        bufferClone.close();
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