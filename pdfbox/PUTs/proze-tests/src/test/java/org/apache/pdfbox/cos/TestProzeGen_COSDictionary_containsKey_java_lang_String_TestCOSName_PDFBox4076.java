/* Copyright 2018 The Apache Software Foundation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.cos;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProzeGen_COSDictionary_containsKey_java_lang_String_TestCOSName_PDFBox4076 {
    /**
     * PDFBOX-4076: Check that characters outside of US_ASCII are not replaced with "?".
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void PDFBox4076(String param0) throws IOException {
        String special = "中国你好!";
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        document.getDocumentCatalog().getCOSObject().setString(COSName.getPDFName(special), special);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        document.save(baos);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(baos.toByteArray());
        COSDictionary catalogDict = document.getDocumentCatalog().getCOSObject();
        assertTrue(catalogDict.containsKey(param0));
        assertEquals(special, catalogDict.getString(special));
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void PDFBox4076_1(String param0) throws IOException {
        String special = "中国你好!";
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        document.getDocumentCatalog().getCOSObject().setString(COSName.getPDFName(special), special);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        document.save(baos);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(baos.toByteArray());
        COSDictionary catalogDict = document.getDocumentCatalog().getCOSObject();
        assertTrue(catalogDict.containsKey(param0));
        // assertEquals(special, catalogDict.getString(special));
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void PDFBox4076_2(String param0) throws IOException {
        String special = "中国你好!";
        org.apache.pdfbox.pdmodel.PDDocument document = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        document.addPage(page);
        document.getDocumentCatalog().getCOSObject().setString(COSName.getPDFName(special), special);
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        document.save(baos);
        document.close();
        document = org.apache.pdfbox.pdmodel.PDDocument.load(baos.toByteArray());
        COSDictionary catalogDict = document.getDocumentCatalog().getCOSObject();
        // assertTrue(catalogDict.containsKey(special));
        assertEquals(special, catalogDict.getString(special));
        document.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("0"),
        org.junit.jupiter.params.provider.Arguments.of("1"),
        org.junit.jupiter.params.provider.Arguments.of("4"),
        org.junit.jupiter.params.provider.Arguments.of("F2"),
        org.junit.jupiter.params.provider.Arguments.of("F3"),
        org.junit.jupiter.params.provider.Arguments.of("Form10"),
        org.junit.jupiter.params.provider.Arguments.of("Form11"),
        org.junit.jupiter.params.provider.Arguments.of("Form12"),
        org.junit.jupiter.params.provider.Arguments.of("Form13"),
        org.junit.jupiter.params.provider.Arguments.of("Form14"),
        org.junit.jupiter.params.provider.Arguments.of("Form15"),
        org.junit.jupiter.params.provider.Arguments.of("Form16"),
        org.junit.jupiter.params.provider.Arguments.of("Form17"),
        org.junit.jupiter.params.provider.Arguments.of("Form18"),
        org.junit.jupiter.params.provider.Arguments.of("Form19"),
        org.junit.jupiter.params.provider.Arguments.of("Form2"),
        org.junit.jupiter.params.provider.Arguments.of("Form20"),
        org.junit.jupiter.params.provider.Arguments.of("Form21"),
        org.junit.jupiter.params.provider.Arguments.of("Form22"),
        org.junit.jupiter.params.provider.Arguments.of("Form23"),
        org.junit.jupiter.params.provider.Arguments.of("Form24"),
        org.junit.jupiter.params.provider.Arguments.of("Form25"),
        org.junit.jupiter.params.provider.Arguments.of("Form26"),
        org.junit.jupiter.params.provider.Arguments.of("Form27"),
        org.junit.jupiter.params.provider.Arguments.of("Form28"),
        org.junit.jupiter.params.provider.Arguments.of("Form29"),
        org.junit.jupiter.params.provider.Arguments.of("Form3"),
        org.junit.jupiter.params.provider.Arguments.of("Form30"),
        org.junit.jupiter.params.provider.Arguments.of("Form31"),
        org.junit.jupiter.params.provider.Arguments.of("Form32"),
        org.junit.jupiter.params.provider.Arguments.of("Form33"),
        org.junit.jupiter.params.provider.Arguments.of("Form34"),
        org.junit.jupiter.params.provider.Arguments.of("Form35"),
        org.junit.jupiter.params.provider.Arguments.of("Form36"),
        org.junit.jupiter.params.provider.Arguments.of("Form4"),
        org.junit.jupiter.params.provider.Arguments.of("Form5"),
        org.junit.jupiter.params.provider.Arguments.of("Form6"),
        org.junit.jupiter.params.provider.Arguments.of("Form7"),
        org.junit.jupiter.params.provider.Arguments.of("Form8"),
        org.junit.jupiter.params.provider.Arguments.of("Form9"),
        org.junit.jupiter.params.provider.Arguments.of("Herr"),
        org.junit.jupiter.params.provider.Arguments.of("Im2"),
        org.junit.jupiter.params.provider.Arguments.of("Im3"),
        org.junit.jupiter.params.provider.Arguments.of("OL14"),
        org.junit.jupiter.params.provider.Arguments.of("OL2"),
        org.junit.jupiter.params.provider.Arguments.of("OL3"),
        org.junit.jupiter.params.provider.Arguments.of("OL5"),
        org.junit.jupiter.params.provider.Arguments.of("OL6"),
        org.junit.jupiter.params.provider.Arguments.of("OL7"),
        org.junit.jupiter.params.provider.Arguments.of("Off"),
        org.junit.jupiter.params.provider.Arguments.of("On"),
        org.junit.jupiter.params.provider.Arguments.of("Option1"),
        org.junit.jupiter.params.provider.Arguments.of("Option3"),
        org.junit.jupiter.params.provider.Arguments.of("PMD"),
        org.junit.jupiter.params.provider.Arguments.of(""),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton01"),
        org.junit.jupiter.params.provider.Arguments.of("RadioButton02"),
        org.junit.jupiter.params.provider.Arguments.of("Value01"),
        org.junit.jupiter.params.provider.Arguments.of("Value02"),
        org.junit.jupiter.params.provider.Arguments.of("Yes"),
        org.junit.jupiter.params.provider.Arguments.of("ja"),
        org.junit.jupiter.params.provider.Arguments.of("nein"),
        org.junit.jupiter.params.provider.Arguments.of("oc2"),
        org.junit.jupiter.params.provider.Arguments.of("oc3"),
        org.junit.jupiter.params.provider.Arguments.of("oc4"),
        org.junit.jupiter.params.provider.Arguments.of("中国你好!")
        );
    }
}