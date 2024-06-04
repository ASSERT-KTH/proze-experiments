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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test for the PDSignatureField class.
 */
public class TestProzeGen_PDField_setPartialName_java_lang_String_PDSignatureFieldTest_createDefaultSignatureField {
    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        assertEquals("Sig", sigField.getFieldType());
        assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        assertNotNull(acroForm.getField("SignatureField"));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField_1(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        // assertEquals("Sig", sigField.getFieldType());
        // assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        // assertNotNull(acroForm.getField("SignatureField"));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField_2(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        // assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        assertEquals("Sig", sigField.getFieldType());
        // assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        // assertNotNull(acroForm.getField("SignatureField"));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField_3(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        // assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        // assertEquals("Sig", sigField.getFieldType());
        assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        // assertNotNull(acroForm.getField("SignatureField"));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField_4(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        // assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        // assertEquals("Sig", sigField.getFieldType());
        // assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        // assertNotNull(acroForm.getField("SignatureField"));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void createDefaultSignatureField_5(String param0) throws java.io.IOException {
        PDSignatureField sigField = new PDSignatureField(acroForm);
        sigField.setPartialName(param0);
        // assertEquals(sigField.getFieldType(), sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.FT));
        // assertEquals("Sig", sigField.getFieldType());
        // assertEquals(org.apache.pdfbox.cos.COSName.ANNOT, sigField.getCOSObject().getItem(org.apache.pdfbox.cos.COSName.TYPE));
        // assertEquals(org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget.SUB_TYPE, sigField.getCOSObject().getNameAsString(org.apache.pdfbox.cos.COSName.SUBTYPE));
        java.util.List<PDField> fields = new java.util.ArrayList<PDField>();
        fields.add(sigField);
        this.acroForm.setFields(fields);
        assertNotNull(acroForm.getField("SignatureField"));
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