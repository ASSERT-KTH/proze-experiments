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
package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_PageMode_fromString_java_lang_String_PageModeTest_fromStringInputNotNullOutputNotNull4 {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void fromStringInputNotNullOutputNotNull4(String param0) {
        // Arrange
        final String value = "UseNone";
        // Act
        final PageMode retval = PageMode.fromString(param0);
        // Assert result
        assertEquals(PageMode.USE_NONE, retval);
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("FullScreen"),
        org.junit.jupiter.params.provider.Arguments.of("UseAttachments"),
        org.junit.jupiter.params.provider.Arguments.of("UseNone"),
        org.junit.jupiter.params.provider.Arguments.of("UseOC"),
        org.junit.jupiter.params.provider.Arguments.of("UseOutlines"),
        org.junit.jupiter.params.provider.Arguments.of("UseThumbs")
        );
    }
}