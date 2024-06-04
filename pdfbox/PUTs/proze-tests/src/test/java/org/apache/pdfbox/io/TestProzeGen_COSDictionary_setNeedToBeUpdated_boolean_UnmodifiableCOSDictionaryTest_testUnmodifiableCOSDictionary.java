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

public class TestProzeGen_COSDictionary_setNeedToBeUpdated_boolean_UnmodifiableCOSDictionaryTest_testUnmodifiableCOSDictionary {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testUnmodifiableCOSDictionary(boolean param0) {
        org.apache.pdfbox.cos.COSDictionary unmodifiableCOSDictionary = new org.apache.pdfbox.cos.COSDictionary().asUnmodifiableDictionary();
        try {
            unmodifiableCOSDictionary.clear();
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.removeItem(org.apache.pdfbox.cos.COSName.A);
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.addAll(new org.apache.pdfbox.cos.COSDictionary());
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.mergeInto(new org.apache.pdfbox.cos.COSDictionary());
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.setFlag(org.apache.pdfbox.cos.COSName.A, 0, true);
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
        try {
            unmodifiableCOSDictionary.setNeedToBeUpdated(param0);
            fail("An UnsupportedOperationException should have been thrown");
        } catch (UnsupportedOperationException exception) {
            // nothing to do
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(false),
        org.junit.jupiter.params.provider.Arguments.of(true)
        );
    }
}