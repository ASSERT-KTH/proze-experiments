/**
 * ***************************************************************************
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * *************************************************************************
 */
package org.apache.pdfbox.pdfparser;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProzeGen_PDFRenderer_renderImage_int_TestPDFParser_testPDFBox3950 {
    private static final String PATH_OF_PDF = "src/test/resources/input/yaddatest.pdf";

    private static final java.io.File tmpDirectory = new java.io.File(System.getProperty("java.io.tmpdir"));

    private static final java.io.File TARGETPDFDIR = new java.io.File("target/pdfs");

    private int numberOfTmpFiles = 0;

    /**
     * Initialize the number of tmp file before the test
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        numberOfTmpFiles = getNumberOfTempFile();
    }

    /**
     * Count the number of temporary files
     *
     * @return  */
    private int getNumberOfTempFile() {
        int result = 0;
        java.io.File[] tmpPdfs = TestProzeGen_PDFRenderer_renderImage_int_TestPDFParser_testPDFBox3950.tmpDirectory.listFiles(new java.io.FilenameFilter() {
            @Override
            public boolean accept(java.io.File dir, String name) {
                return name.startsWith(COSParser.TMP_FILE_PREFIX) && name.endsWith("pdf");
            }
        });
        if (tmpPdfs != null) {
            result = tmpPdfs.length;
        }
        return result;
    }

    /**
     * PDFBOX-3950: test parsing and rendering of truncated file with missing pages.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testPDFBox3950(int param0) throws IOException {
        org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(new java.io.File(TestProzeGen_PDFRenderer_renderImage_int_TestPDFParser_testPDFBox3950.TARGETPDFDIR, "PDFBOX-3950-23EGDHXSBBYQLKYOKGZUOVYVNE675PRD.pdf"));
        assertEquals(4, doc.getNumberOfPages());
        org.apache.pdfbox.rendering.PDFRenderer renderer = new org.apache.pdfbox.rendering.PDFRenderer(doc);
        for (int i = 0; i < doc.getNumberOfPages(); ++i) {
            try {
                renderer.renderImage(param0);
            } catch (IOException ex) {
                if ((i == 3) && ex.getMessage().equals("Missing descendant font array")) {
                    continue;
                }
                throw ex;
            }
        }
        doc.close();
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1),
        org.junit.jupiter.params.provider.Arguments.of(2)
        );
    }
}