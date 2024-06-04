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

/**
 *
 * @author Andrea Vacondio
 */
public class TestProzeGen_PDPageTree_get_int_TestPDPageTransitions_readTransitions {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void readTransitions(int param0) throws java.io.IOException, java.net.URISyntaxException {
        PDDocument doc = PDDocument.load(new java.io.File(this.getClass().getResource("/org/apache/pdfbox/pdmodel/interactive/pagenavigation/transitions_test.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition firstTransition = doc.getPages().get(param0).getTransition();
        assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionStyle.Glitter.name(), firstTransition.getStyle());
        assertEquals(2, firstTransition.getDuration(), 0);
        assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionDirection.TOP_LEFT_TO_BOTTOM_RIGHT.getCOSBase(), firstTransition.getDirection());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void readTransitions_1(int param0) throws java.io.IOException, java.net.URISyntaxException {
        PDDocument doc = PDDocument.load(new java.io.File(this.getClass().getResource("/org/apache/pdfbox/pdmodel/interactive/pagenavigation/transitions_test.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition firstTransition = doc.getPages().get(param0).getTransition();
        assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionStyle.Glitter.name(), firstTransition.getStyle());
        // assertEquals(2, firstTransition.getDuration(), 0);
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionDirection.TOP_LEFT_TO_BOTTOM_RIGHT.getCOSBase(), firstTransition.getDirection());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void readTransitions_2(int param0) throws java.io.IOException, java.net.URISyntaxException {
        PDDocument doc = PDDocument.load(new java.io.File(this.getClass().getResource("/org/apache/pdfbox/pdmodel/interactive/pagenavigation/transitions_test.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition firstTransition = doc.getPages().get(param0).getTransition();
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionStyle.Glitter.name(), firstTransition.getStyle());
        assertEquals(2, firstTransition.getDuration(), 0);
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionDirection.TOP_LEFT_TO_BOTTOM_RIGHT.getCOSBase(), firstTransition.getDirection());
        doc.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void readTransitions_3(int param0) throws java.io.IOException, java.net.URISyntaxException {
        PDDocument doc = PDDocument.load(new java.io.File(this.getClass().getResource("/org/apache/pdfbox/pdmodel/interactive/pagenavigation/transitions_test.pdf").toURI()));
        org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition firstTransition = doc.getPages().get(param0).getTransition();
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionStyle.Glitter.name(), firstTransition.getStyle());
        // assertEquals(2, firstTransition.getDuration(), 0);
        assertEquals(org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransitionDirection.TOP_LEFT_TO_BOTTOM_RIGHT.getCOSBase(), firstTransition.getDirection());
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(10),
        org.junit.jupiter.params.provider.Arguments.of(11),
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