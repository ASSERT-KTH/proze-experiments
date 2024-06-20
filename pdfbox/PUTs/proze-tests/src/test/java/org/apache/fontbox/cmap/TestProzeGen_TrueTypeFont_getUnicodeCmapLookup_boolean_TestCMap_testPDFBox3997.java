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
package org.apache.fontbox.cmap;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This will test the CMap implementation.
 */
// public class TestCMap extends TestCase
public class TestProzeGen_TrueTypeFont_getUnicodeCmapLookup_boolean_TestCMap_testPDFBox3997 {
    /**
     * PDFBOX-3997: test unicode that is above the basic multilingual plane, here: helicopter
     * symbol, or D83D DE81 in the Noto Emoji font.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3997(boolean param0) throws IOException {
        org.apache.fontbox.ttf.TrueTypeFont ttf = new org.apache.fontbox.ttf.TTFParser().parse("target/pdfs/NotoEmoji-Regular.ttf");
        org.apache.fontbox.ttf.CmapLookup cmap = ttf.getUnicodeCmapLookup(param0);
        assertEquals(886, cmap.getGlyphId(0x1f681));
        ttf.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(false),
        org.junit.jupiter.params.provider.Arguments.of(true)
        );
    }
}