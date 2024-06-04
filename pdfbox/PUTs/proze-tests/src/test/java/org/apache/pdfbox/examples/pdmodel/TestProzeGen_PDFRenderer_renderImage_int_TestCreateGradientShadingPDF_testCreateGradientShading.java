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
package org.apache.pdfbox.examples.pdmodel;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDFRenderer_renderImage_int_TestCreateGradientShadingPDF_testCreateGradientShading {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testCreateGradientShading(int param0) throws java.io.IOException {
        String filename = "target/GradientShading.pdf";
        CreateGradientShadingPDF creator = new CreateGradientShadingPDF();
        creator.create(filename);
        org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(filename));
        java.util.Set<java.awt.Color> set = new java.util.HashSet<java.awt.Color>();
        java.awt.image.BufferedImage bim = new org.apache.pdfbox.rendering.PDFRenderer(document).renderImage(param0);
        for (int x = 0; x < bim.getWidth(); ++x) {
            for (int y = 0; y < bim.getHeight(); ++y) {
                set.add(new java.awt.Color(bim.getRGB(x, y)));
            }
        }
        assertTrue(set.size() > 10000);// 10258 different colors on windows 10

        document.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}