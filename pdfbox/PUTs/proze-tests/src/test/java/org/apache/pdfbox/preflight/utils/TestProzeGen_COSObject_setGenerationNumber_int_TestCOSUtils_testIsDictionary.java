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
package org.apache.pdfbox.preflight.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

public class TestProzeGen_COSObject_setGenerationNumber_int_TestCOSUtils_testIsDictionary {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIsDictionary(int param0) {
        try {
            org.apache.pdfbox.cos.COSObject co = new org.apache.pdfbox.cos.COSObject(new org.apache.pdfbox.cos.COSDictionary());
            co.setGenerationNumber(param0);
            co.setObjectNumber(10);
            assertFalse(COSUtils.isDictionary(co, new IOCOSDocument()));
            org.apache.pdfbox.cos.COSDocument doc = new org.apache.pdfbox.cos.COSDocument();
            addToXref(doc, new org.apache.pdfbox.cos.COSObjectKey(co), 1000);
            COSUtils.isDictionary(co, doc);
            doc.close();
        } catch (java.io.IOException e) {
            fail(e.getMessage());
        }
    }

    protected void addToXref(org.apache.pdfbox.cos.COSDocument doc, org.apache.pdfbox.cos.COSObjectKey key, long value) {
        java.util.Map<org.apache.pdfbox.cos.COSObjectKey, Long> xrefTable = new java.util.HashMap<org.apache.pdfbox.cos.COSObjectKey, Long>(1);
        xrefTable.put(key, value);
        doc.addXRefTable(xrefTable);
    }

    /**
     * Class used to check the catch block in COSUtils methods
     */
    private class IOCOSDocument extends org.apache.pdfbox.cos.COSDocument {
        IOCOSDocument() throws java.io.IOException {
            super();
        }

        IOCOSDocument(java.io.File scratchDir) throws java.io.IOException {
            super(new org.apache.pdfbox.io.ScratchFile(scratchDir));
        }

        @Override
        public void close() throws java.io.IOException {
            super.close();
            throw new java.io.IOException("Exception for code coverage");
        }

        @Override
        public org.apache.pdfbox.cos.COSObject getObjectFromPool(org.apache.pdfbox.cos.COSObjectKey key) throws java.io.IOException {
            super.close();
            throw new java.io.IOException("Exception for code coverage");
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(0),
        org.junit.jupiter.params.provider.Arguments.of(1)
        );
    }
}