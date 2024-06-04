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
package org.apache.pdfbox.pdmodel.interactive.form;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test for the PDButton class.
 */
public class TestProzeGen_PDField_setPartialName_java_lang_String_PDAcroFormTest_testBadDA {
    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    private static final java.io.File IN_DIR = new java.io.File("src/test/resources/org/apache/pdfbox/pdmodel/interactive/form");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
    }

    /**
     * PDFBOX-4235: a bad /DA string should not result in an NPE.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testBadDA(String param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        PDAcroForm acroForm = new PDAcroForm(document);
        doc.getDocumentCatalog().setAcroForm(acroForm);
        acroForm.setDefaultResources(new org.apache.pdfbox.pdmodel.PDResources());
        PDTextField textBox = new PDTextField(acroForm);
        textBox.setPartialName(param0);
        // https://stackoverflow.com/questions/50609478/
        // "tf" is a typo, should have been "Tf" and this results that no font is chosen
        textBox.setDefaultAppearance("/Helv 0 tf 0 g");
        acroForm.getFields().add(textBox);
        org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget widget = textBox.getWidgets().get(0);
        org.apache.pdfbox.pdmodel.common.PDRectangle rect = new org.apache.pdfbox.pdmodel.common.PDRectangle(50, 750, 200, 20);
        widget.setRectangle(rect);
        widget.setPage(page);
        page.getAnnotations().add(widget);
        try {
            textBox.setValue("huhu");
        } catch (IllegalArgumentException ex) {
            return;
        } finally {
            doc.close();
        }
        fail("IllegalArgumentException should have been thrown");
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws IOException {
        document.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("SampleField"),
        org.junit.jupiter.params.provider.Arguments.of("Signature1"),
        org.junit.jupiter.params.provider.Arguments.of("SignatureField"),
        org.junit.jupiter.params.provider.Arguments.of("checkbox")
        );
    }
}