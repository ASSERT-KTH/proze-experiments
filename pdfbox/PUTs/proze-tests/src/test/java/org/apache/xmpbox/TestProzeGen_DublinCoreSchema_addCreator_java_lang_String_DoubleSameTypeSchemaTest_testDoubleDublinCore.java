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
package org.apache.xmpbox;

import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue; /**
 * Test with 2 dublinCore with different prefix (Test comportment of XMPMetadata)
 *
 * @author a183132
 */
public class TestProzeGen_DublinCoreSchema_addCreator_java_lang_String_DoubleSameTypeSchemaTest_testDoubleDublinCore {
    protected XMPMetadata metadata;

    @org.junit.jupiter.api.BeforeEach
    public void testInit() throws Exception {
        metadata = XMPMetadata.createXMPMetadata();
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(param0);
        dc1.addCreator(param0);
        String coverage = "Coverage";
        dc2.setCoverage(coverage);
        dc2.addCreator(param0);
        dc2.addCreator(param0);
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
        for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_1(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(param0);
        dc1.addCreator(param0);
        String coverage = "Coverage";
        dc2.setCoverage(coverage);
        dc2.addCreator(param0);
        dc2.addCreator(param0);
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        // assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
         for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        };
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_2(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(param0);
        dc1.addCreator(param0);
        String coverage = "Coverage";
        dc2.setCoverage(coverage);
        dc2.addCreator(param0);
        dc2.addCreator(param0);
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        // assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
         for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        };
    }

    @org.junit.jupiter.params.ParameterizedTest
    @NullSource
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDoubleDublinCore_3(String param0) throws Exception {
        org.apache.xmpbox.schema.DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();
        String ownPrefix = "test";
        org.apache.xmpbox.schema.DublinCoreSchema dc2 = new org.apache.xmpbox.schema.DublinCoreSchema(metadata, ownPrefix);
        metadata.addSchema(dc2);
        java.util.List<String> creators = new java.util.ArrayList<String>();
        creators.add("creator1");
        creators.add("creator2");
        String format = "application/pdf";
        dc1.setFormat(format);
        dc1.addCreator(param0);
        dc1.addCreator(param0);
        String coverage = "Coverage";
        dc2.setCoverage(coverage);
        dc2.addCreator(param0);
        dc2.addCreator(param0);
        org.apache.xmpbox.type.StructuredType stDub = org.apache.xmpbox.schema.DublinCoreSchema.class.getAnnotation(org.apache.xmpbox.type.StructuredType.class);
        // assertEquals(format, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(stDub.preferedPrefix(), stDub.namespace()))).getFormat());
        // assertEquals(coverage, ((org.apache.xmpbox.schema.DublinCoreSchema) (metadata.getSchema(ownPrefix, stDub.namespace()))).getCoverage());
        java.util.List<org.apache.xmpbox.schema.XMPSchema> schems = metadata.getAllSchemas();
        org.apache.xmpbox.schema.DublinCoreSchema dc;
        for (org.apache.xmpbox.schema.XMPSchema xmpSchema : schems) {
            dc = ((org.apache.xmpbox.schema.DublinCoreSchema) (xmpSchema));
            assertTrue(dc.getCreators().containsAll(creators));
        }
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1299581855210072286"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1493521057674437289"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1562623214028879402"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1631481037288248118"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1657739215676926524"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1724879092216197994"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1885020071224716333"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-1998406999658571556"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2057159406708459040"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2065213823127397403"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-2697069592259562950"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-31013836104608426"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3159454432976967402"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3367397968254851325"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3416048088926864965"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3575127020095079694"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3629924765041704399"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-369244867834002178"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3717697983365546718"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3760280585015893463"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3803878342785276307"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3940573313309399211"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-3944536452042790783"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4301437726103677754"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4675729570144404365"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-4962768465676381896"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5276369451512352494"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-539253255129623690"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5473170763905270375"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5609381539297065165"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5612761795197137106"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-5805046527833630922"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-580517874506696265"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6025004575794035782"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6453324735107263062"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6455949491547510209"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6752019490208577109"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6755790169423522890"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-6897356465666981271"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7195280639906539295"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7568143465823703682"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7645261462414831338"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7859792761491123607"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-7864307245710937401"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8166812765722162191"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8266494768561920808"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8360481972953686651"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8775380097684109599"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8835964354329449277"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8875180882601997200"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-8985184928476881755"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-9014858844555622959"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-9051384032443196535"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-9196150389019460504"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-971888327188283551"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_-976574768391644684"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_125542192122165938"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1562062510973913206"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1703771462155759617"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1735414460049222672"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_1911375796351995922"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2233333308160599927"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2380342067036448302"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2551278753224682144"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_268028089880226453"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_269807811901968195"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2748468737935019588"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2809494288288982467"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2850361919576185475"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_2867804717292470286"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_3471850643204752700"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_3876919914169915609"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_3901298598704364322"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_424290667566093076"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4383736866407207890"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_438555752043785022"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4437113781045784766"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4669641115721316487"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4723732562150255200"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_4878102979026125234"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5052643448371422321"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_536358749736449646"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_5900894177584524330"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6295797203161724241"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6296335513915125566"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6370669358992257874"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6559229743172644308"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6592302397723484633"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6825554225575627771"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_6867976968272446767"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7022609019977709046"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7124676437443333231"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7195516464565736087"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_7767651989569027728"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8006851455471719859"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8089427925423209174"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8148518773216465664"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8457579424514706796"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8463697913601981116"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8477891680863961435"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8781714937696403787"),
        org.junit.jupiter.params.provider.Arguments.of("Text_String_8989841175193476434"),
        org.junit.jupiter.params.provider.Arguments.of("creator1"),
        org.junit.jupiter.params.provider.Arguments.of("creator2"),
                org.junit.jupiter.params.provider.Arguments.of("2ndCreator"),
                org.junit.jupiter.params.provider.Arguments.of("XMPAuthor"),
                org.junit.jupiter.params.provider.Arguments.of("AUTHOR(S)")
        );
    }
}