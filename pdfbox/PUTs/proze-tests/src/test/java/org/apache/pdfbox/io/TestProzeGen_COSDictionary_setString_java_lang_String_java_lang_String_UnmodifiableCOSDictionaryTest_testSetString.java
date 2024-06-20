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

import static org.junit.jupiter.api.Assertions.fail;

public class TestProzeGen_COSDictionary_setString_java_lang_String_java_lang_String_UnmodifiableCOSDictionaryTest_testSetString {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testSetString(String param0, String param1) {
        org.apache.pdfbox.cos.COSDictionary unmodifiableCOSDictionary = new org.apache.pdfbox.cos.COSDictionary().asUnmodifiableDictionary();
        try {
            unmodifiableCOSDictionary.setString(org.apache.pdfbox.cos.COSName.A, "A");
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.setString(param0, param1);
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("key1", "3"),
        org.junit.jupiter.params.provider.Arguments.of("key2", "0")
        );
    }
}