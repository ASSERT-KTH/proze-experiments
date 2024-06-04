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

public class TestProzeGen_COSFloat_init_TestCOSUtils_testIsFloat {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testIsFloat(float param0) {
        try {
            org.apache.pdfbox.cos.COSObject co = new org.apache.pdfbox.cos.COSObject(new org.apache.pdfbox.cos.COSFloat(param0));
            co.setGenerationNumber(0);
            co.setObjectNumber(10);
            assertFalse(COSUtils.isFloat(co, new IOCOSDocument()));
            org.apache.pdfbox.cos.COSDocument doc = new org.apache.pdfbox.cos.COSDocument();
            addToXref(doc, new org.apache.pdfbox.cos.COSObjectKey(co), 1000);
            COSUtils.isFloat(co, doc);
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
        org.junit.jupiter.params.provider.Arguments.of(-0.0F),
        org.junit.jupiter.params.provider.Arguments.of(-1.0F),
        org.junit.jupiter.params.provider.Arguments.of(-1.1467F),
        org.junit.jupiter.params.provider.Arguments.of(-1.15F),
        org.junit.jupiter.params.provider.Arguments.of(-113.0F),
        org.junit.jupiter.params.provider.Arguments.of(-114.51F),
        org.junit.jupiter.params.provider.Arguments.of(-12.0F),
        org.junit.jupiter.params.provider.Arguments.of(-138.92F),
        org.junit.jupiter.params.provider.Arguments.of(-143.0F),
        org.junit.jupiter.params.provider.Arguments.of(-15.0F),
        org.junit.jupiter.params.provider.Arguments.of(-15.5F),
        org.junit.jupiter.params.provider.Arguments.of(-157.0F),
        org.junit.jupiter.params.provider.Arguments.of(-16.4768F),
        org.junit.jupiter.params.provider.Arguments.of(-165.45F),
        org.junit.jupiter.params.provider.Arguments.of(-166.0F),
        org.junit.jupiter.params.provider.Arguments.of(-168.0F),
        org.junit.jupiter.params.provider.Arguments.of(-169.0F),
        org.junit.jupiter.params.provider.Arguments.of(-170.0F),
        org.junit.jupiter.params.provider.Arguments.of(-174.0F),
        org.junit.jupiter.params.provider.Arguments.of(-180.0F),
        org.junit.jupiter.params.provider.Arguments.of(-2.8742F),
        org.junit.jupiter.params.provider.Arguments.of(-200.0F),
        org.junit.jupiter.params.provider.Arguments.of(-207.0F),
        org.junit.jupiter.params.provider.Arguments.of(-217.0F),
        org.junit.jupiter.params.provider.Arguments.of(-218.0F),
        org.junit.jupiter.params.provider.Arguments.of(-220.0F),
        org.junit.jupiter.params.provider.Arguments.of(-225.0F),
        org.junit.jupiter.params.provider.Arguments.of(-228.0F),
        org.junit.jupiter.params.provider.Arguments.of(-23.0F),
        org.junit.jupiter.params.provider.Arguments.of(-24.0901F),
        org.junit.jupiter.params.provider.Arguments.of(-250.0F),
        org.junit.jupiter.params.provider.Arguments.of(-251.65F),
        org.junit.jupiter.params.provider.Arguments.of(-27.0F),
        org.junit.jupiter.params.provider.Arguments.of(-291.44F),
        org.junit.jupiter.params.provider.Arguments.of(-293.0F),
        org.junit.jupiter.params.provider.Arguments.of(-3.2704F),
        org.junit.jupiter.params.provider.Arguments.of(-3.4206F),
        org.junit.jupiter.params.provider.Arguments.of(-307.0F),
        org.junit.jupiter.params.provider.Arguments.of(-325.0F),
        org.junit.jupiter.params.provider.Arguments.of(-376.0F),
        org.junit.jupiter.params.provider.Arguments.of(-395.77F),
        org.junit.jupiter.params.provider.Arguments.of(-446.34F),
        org.junit.jupiter.params.provider.Arguments.of(-459.24F),
        org.junit.jupiter.params.provider.Arguments.of(-51.75F),
        org.junit.jupiter.params.provider.Arguments.of(-517.0F),
        org.junit.jupiter.params.provider.Arguments.of(-554.21F),
        org.junit.jupiter.params.provider.Arguments.of(-560.0F),
        org.junit.jupiter.params.provider.Arguments.of(-568.0F),
        org.junit.jupiter.params.provider.Arguments.of(-57.0F),
        org.junit.jupiter.params.provider.Arguments.of(-6.3305F),
        org.junit.jupiter.params.provider.Arguments.of(-6.618F),
        org.junit.jupiter.params.provider.Arguments.of(-6.8455F),
        org.junit.jupiter.params.provider.Arguments.of(-628.0F),
        org.junit.jupiter.params.provider.Arguments.of(-665.0F),
        org.junit.jupiter.params.provider.Arguments.of(0.0F),
        org.junit.jupiter.params.provider.Arguments.of(1.0F),
        org.junit.jupiter.params.provider.Arguments.of(1.145F),
        org.junit.jupiter.params.provider.Arguments.of(1.1467F),
        org.junit.jupiter.params.provider.Arguments.of(1.1475F),
        org.junit.jupiter.params.provider.Arguments.of(1.1497F),
        org.junit.jupiter.params.provider.Arguments.of(1.15F),
        org.junit.jupiter.params.provider.Arguments.of(1.1502F),
        org.junit.jupiter.params.provider.Arguments.of(1.153F),
        org.junit.jupiter.params.provider.Arguments.of(1.1533F),
        org.junit.jupiter.params.provider.Arguments.of(1.1536F),
        org.junit.jupiter.params.provider.Arguments.of(1.1545F),
        org.junit.jupiter.params.provider.Arguments.of(1.155F),
        org.junit.jupiter.params.provider.Arguments.of(1.1585F),
        org.junit.jupiter.params.provider.Arguments.of(1.16F),
        org.junit.jupiter.params.provider.Arguments.of(1.19F),
        org.junit.jupiter.params.provider.Arguments.of(1.22F),
        org.junit.jupiter.params.provider.Arguments.of(1.225F),
        org.junit.jupiter.params.provider.Arguments.of(1.2467F),
        org.junit.jupiter.params.provider.Arguments.of(1000.0F),
        org.junit.jupiter.params.provider.Arguments.of(1003.0F),
        org.junit.jupiter.params.provider.Arguments.of(1005.0F),
        org.junit.jupiter.params.provider.Arguments.of(1006.0F),
        org.junit.jupiter.params.provider.Arguments.of(1007.0F),
        org.junit.jupiter.params.provider.Arguments.of(1008.0F),
        org.junit.jupiter.params.provider.Arguments.of(1010.0F),
        org.junit.jupiter.params.provider.Arguments.of(1037.0F),
        org.junit.jupiter.params.provider.Arguments.of(1048.0F),
        org.junit.jupiter.params.provider.Arguments.of(1082.0F),
        org.junit.jupiter.params.provider.Arguments.of(1090.0F),
        org.junit.jupiter.params.provider.Arguments.of(1113.0F),
        org.junit.jupiter.params.provider.Arguments.of(1114.0F),
        org.junit.jupiter.params.provider.Arguments.of(1116.0F),
        org.junit.jupiter.params.provider.Arguments.of(114.51F),
        org.junit.jupiter.params.provider.Arguments.of(1157.0F),
        org.junit.jupiter.params.provider.Arguments.of(1190.5513F),
        org.junit.jupiter.params.provider.Arguments.of(120.0F),
        org.junit.jupiter.params.provider.Arguments.of(120.75F),
        org.junit.jupiter.params.provider.Arguments.of(1224.0F),
        org.junit.jupiter.params.provider.Arguments.of(126.72F),
        org.junit.jupiter.params.provider.Arguments.of(138.92F),
        org.junit.jupiter.params.provider.Arguments.of(151.13F),
        org.junit.jupiter.params.provider.Arguments.of(161.45F),
        org.junit.jupiter.params.provider.Arguments.of(165.45F),
        org.junit.jupiter.params.provider.Arguments.of(1683.7795F),
        org.junit.jupiter.params.provider.Arguments.of(18.0F),
        org.junit.jupiter.params.provider.Arguments.of(19.0F),
        org.junit.jupiter.params.provider.Arguments.of(198.0F),
        org.junit.jupiter.params.provider.Arguments.of(199.0F),
        org.junit.jupiter.params.provider.Arguments.of(2.0F),
        org.junit.jupiter.params.provider.Arguments.of(2.2704F),
        org.junit.jupiter.params.provider.Arguments.of(2.2800000000000002F),
        org.junit.jupiter.params.provider.Arguments.of(2.32F),
        org.junit.jupiter.params.provider.Arguments.of(20.0F),
        org.junit.jupiter.params.provider.Arguments.of(200.0F),
        org.junit.jupiter.params.provider.Arguments.of(2000.0F),
        org.junit.jupiter.params.provider.Arguments.of(2028.0F),
        org.junit.jupiter.params.provider.Arguments.of(2034.0F),
        org.junit.jupiter.params.provider.Arguments.of(2383.937F),
        org.junit.jupiter.params.provider.Arguments.of(24.0901F),
        org.junit.jupiter.params.provider.Arguments.of(2480.0F),
        org.junit.jupiter.params.provider.Arguments.of(250.0F),
        org.junit.jupiter.params.provider.Arguments.of(251.65F),
        org.junit.jupiter.params.provider.Arguments.of(283.74F),
        org.junit.jupiter.params.provider.Arguments.of(291.44F),
        org.junit.jupiter.params.provider.Arguments.of(297.63782F),
        org.junit.jupiter.params.provider.Arguments.of(3370.3938F),
        org.junit.jupiter.params.provider.Arguments.of(3508.0F),
        org.junit.jupiter.params.provider.Arguments.of(395.77F),
        org.junit.jupiter.params.provider.Arguments.of(404.12F),
        org.junit.jupiter.params.provider.Arguments.of(410.41F),
        org.junit.jupiter.params.provider.Arguments.of(419.52756F),
        org.junit.jupiter.params.provider.Arguments.of(426.0F),
        org.junit.jupiter.params.provider.Arguments.of(439.0F),
        org.junit.jupiter.params.provider.Arguments.of(439.202F),
        org.junit.jupiter.params.provider.Arguments.of(441.0F),
        org.junit.jupiter.params.provider.Arguments.of(446.34F),
        org.junit.jupiter.params.provider.Arguments.of(449.09998F),
        org.junit.jupiter.params.provider.Arguments.of(449.55F),
        org.junit.jupiter.params.provider.Arguments.of(450.0F),
        org.junit.jupiter.params.provider.Arguments.of(459.24F),
        org.junit.jupiter.params.provider.Arguments.of(461.0F),
        org.junit.jupiter.params.provider.Arguments.of(462.0F),
        org.junit.jupiter.params.provider.Arguments.of(471.45F),
        org.junit.jupiter.params.provider.Arguments.of(50.0F),
        org.junit.jupiter.params.provider.Arguments.of(505.0F),
        org.junit.jupiter.params.provider.Arguments.of(51.75F),
        org.junit.jupiter.params.provider.Arguments.of(511.75555F),
        org.junit.jupiter.params.provider.Arguments.of(517.27F),
        org.junit.jupiter.params.provider.Arguments.of(518.0603F),
        org.junit.jupiter.params.provider.Arguments.of(523.0F),
        org.junit.jupiter.params.provider.Arguments.of(525.8F),
        org.junit.jupiter.params.provider.Arguments.of(525.9778F),
        org.junit.jupiter.params.provider.Arguments.of(532.0F),
        org.junit.jupiter.params.provider.Arguments.of(542.0F),
        org.junit.jupiter.params.provider.Arguments.of(542.2286F),
        org.junit.jupiter.params.provider.Arguments.of(542.7714F),
        org.junit.jupiter.params.provider.Arguments.of(554.15F),
        org.junit.jupiter.params.provider.Arguments.of(554.21F),
        org.junit.jupiter.params.provider.Arguments.of(562.0F),
        org.junit.jupiter.params.provider.Arguments.of(564.3619F),
        org.junit.jupiter.params.provider.Arguments.of(566.41F),
        org.junit.jupiter.params.provider.Arguments.of(588.03156F),
        org.junit.jupiter.params.provider.Arguments.of(595.0F),
        org.junit.jupiter.params.provider.Arguments.of(595.22F),
        org.junit.jupiter.params.provider.Arguments.of(595.27563F),
        org.junit.jupiter.params.provider.Arguments.of(595.276F),
        org.junit.jupiter.params.provider.Arguments.of(600.0F),
        org.junit.jupiter.params.provider.Arguments.of(612.0F),
        org.junit.jupiter.params.provider.Arguments.of(616.049F),
        org.junit.jupiter.params.provider.Arguments.of(629.0F),
        org.junit.jupiter.params.provider.Arguments.of(650.0F),
        org.junit.jupiter.params.provider.Arguments.of(653.0F),
        org.junit.jupiter.params.provider.Arguments.of(662.0F),
        org.junit.jupiter.params.provider.Arguments.of(669.0F),
        org.junit.jupiter.params.provider.Arguments.of(670.0F),
        org.junit.jupiter.params.provider.Arguments.of(671.5F),
        org.junit.jupiter.params.provider.Arguments.of(672.25F),
        org.junit.jupiter.params.provider.Arguments.of(676.0F),
        org.junit.jupiter.params.provider.Arguments.of(683.0F),
        org.junit.jupiter.params.provider.Arguments.of(715.0F),
        org.junit.jupiter.params.provider.Arguments.of(718.0F),
        org.junit.jupiter.params.provider.Arguments.of(746.0248F),
        org.junit.jupiter.params.provider.Arguments.of(749.0F),
        org.junit.jupiter.params.provider.Arguments.of(750.0F),
        org.junit.jupiter.params.provider.Arguments.of(770.0F),
        org.junit.jupiter.params.provider.Arguments.of(792.0F),
        org.junit.jupiter.params.provider.Arguments.of(801.0F),
        org.junit.jupiter.params.provider.Arguments.of(805.0F),
        org.junit.jupiter.params.provider.Arguments.of(820.0F),
        org.junit.jupiter.params.provider.Arguments.of(841.8898F),
        org.junit.jupiter.params.provider.Arguments.of(842.0F),
        org.junit.jupiter.params.provider.Arguments.of(849.0F),
        org.junit.jupiter.params.provider.Arguments.of(869.0F),
        org.junit.jupiter.params.provider.Arguments.of(883.0F),
        org.junit.jupiter.params.provider.Arguments.of(898.0F),
        org.junit.jupiter.params.provider.Arguments.of(921.0F),
        org.junit.jupiter.params.provider.Arguments.of(931.0F),
        org.junit.jupiter.params.provider.Arguments.of(935.0F),
        org.junit.jupiter.params.provider.Arguments.of(962.0F),
        org.junit.jupiter.params.provider.Arguments.of(981.0F),
        org.junit.jupiter.params.provider.Arguments.of(996.0F),
        org.junit.jupiter.params.provider.Arguments.of(998.0F)
        );
    }
}