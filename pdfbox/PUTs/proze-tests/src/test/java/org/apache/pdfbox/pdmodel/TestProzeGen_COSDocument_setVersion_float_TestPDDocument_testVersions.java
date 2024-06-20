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
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testcase introduced with PDFBOX-1581.
 */
// public class TestPDDocument extends TestCase
public class TestProzeGen_COSDocument_setVersion_float_TestPDDocument_testVersions {
    private static final java.io.File testResultsDir = new java.io.File("target/test-output");

    // @Override
    @org.junit.jupiter.api.BeforeAll
    public static void setUp() throws Exception {
        // super.setUp();
        TestProzeGen_COSDocument_setVersion_float_TestPDDocument_testVersions.testResultsDir.mkdirs();
    }

    /**
     * Test get/setVersion.
     *
     * @throws IOException
     * 		if something went wrong
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions(float param0) throws IOException {
        PDDocument document = new PDDocument();
        assertEquals(1.4F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        assertEquals(1.3F, document.getVersion(), 0.0);
        assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        assertEquals(1.4F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        assertEquals(1.5F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_1(float param0) throws IOException {
        PDDocument document = new PDDocument();
        assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
//        assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_2(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_3(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
//        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_4(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_5(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_6(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_7(float param0) throws IOException {
        PDDocument document = new PDDocument();
//        assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_8(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_9(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
//        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_10(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_11(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
//        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testVersions_12(float param0) throws IOException {
        PDDocument document = new PDDocument();
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.getDocument().setVersion(param0);
        document.getDocumentCatalog().setVersion(null);
        // assertEquals(1.3F, document.getVersion(), 0.0);
        // assertEquals(1.3F, document.getDocument().getVersion(), 0.0);
        // assertNull(document.getDocumentCatalog().getVersion());
        document.close();
        document = new PDDocument();
        document.setVersion(1.3F);
        // assertEquals(1.4F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        // assertEquals("1.4", document.getDocumentCatalog().getVersion());
        document.setVersion(1.5F);
        // assertEquals(1.5F, document.getVersion(), 0.0);
        // assertEquals(1.4F, document.getDocument().getVersion(), 0.0);
        assertEquals("1.5", document.getDocumentCatalog().getVersion());
        document.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(1.0F),
        org.junit.jupiter.params.provider.Arguments.of(1.2F),
        org.junit.jupiter.params.provider.Arguments.of(1.3F),
        org.junit.jupiter.params.provider.Arguments.of(1.4F),
        org.junit.jupiter.params.provider.Arguments.of(1.5F),
        org.junit.jupiter.params.provider.Arguments.of(1.6F),
        org.junit.jupiter.params.provider.Arguments.of(1.7000000000000002F)
        );
    }
}