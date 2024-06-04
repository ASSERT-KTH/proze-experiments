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
package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_RenderingIntent_fromString_java_lang_String_RenderingIntentTest_fromStringInputNotNullOutputNotNull {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void fromStringInputNotNullOutputNotNull(String param0) {
        // Arrange
        final String value = "AbsoluteColorimetric";
        // Act
        final RenderingIntent retval = RenderingIntent.fromString(param0);
        // Assert result
        assertEquals(RenderingIntent.ABSOLUTE_COLORIMETRIC, retval);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("AbsoluteColorimetric"),
        org.junit.jupiter.params.provider.Arguments.of(""),
        org.junit.jupiter.params.provider.Arguments.of("Perceptual"),
        org.junit.jupiter.params.provider.Arguments.of("RelativeColorimetric"),
        org.junit.jupiter.params.provider.Arguments.of("Saturation")
        );
    }
}