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

/**
 * Test if a sequence of linebreak/paragraph characters produces the same
 * number of paragraphs as Adobe Acrobat produces when setting the value
 * via JavaScript.
 */
public class TestProzeGen_PlainText_init_PlainTextTest_characterLF {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void characterLF(String param0) {
        PlainText text = new PlainText(param0);
        assertEquals(2, text.getParagraphs().size());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(" "),
                org.junit.jupiter.params.provider.Arguments.of(" Select Comparison"),
                org.junit.jupiter.params.provider.Arguments.of("-- "),
                org.junit.jupiter.params.provider.Arguments.of("09.2017"),
                org.junit.jupiter.params.provider.Arguments.of("100000"),
                org.junit.jupiter.params.provider.Arguments.of("106,76"),
                org.junit.jupiter.params.provider.Arguments.of("113.020 "),
                org.junit.jupiter.params.provider.Arguments.of("115.470 "),
                org.junit.jupiter.params.provider.Arguments.of("123456"),
                org.junit.jupiter.params.provider.Arguments.of("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"),
                org.junit.jupiter.params.provider.Arguments.of("17.40 "),
                org.junit.jupiter.params.provider.Arguments.of("172,20"),
                org.junit.jupiter.params.provider.Arguments.of("17,394.41 "),
                org.junit.jupiter.params.provider.Arguments.of("180"),
                org.junit.jupiter.params.provider.Arguments.of("19.06.1980"),
                org.junit.jupiter.params.provider.Arguments.of("1,173.74 "),
                org.junit.jupiter.params.provider.Arguments.of("2.10 "),
                org.junit.jupiter.params.provider.Arguments.of("20"),
                org.junit.jupiter.params.provider.Arguments.of("201707"),
                org.junit.jupiter.params.provider.Arguments.of("206 "),
                org.junit.jupiter.params.provider.Arguments.of("209 "),
                org.junit.jupiter.params.provider.Arguments.of("23,780.82 "),
                org.junit.jupiter.params.provider.Arguments.of("31.11 "),
                org.junit.jupiter.params.provider.Arguments.of("33.090 "),
                org.junit.jupiter.params.provider.Arguments.of("34 "),
                org.junit.jupiter.params.provider.Arguments.of("341 "),
                org.junit.jupiter.params.provider.Arguments.of("35 "),
                org.junit.jupiter.params.provider.Arguments.of("37"),
                org.junit.jupiter.params.provider.Arguments.of("3,842.68 "),
                org.junit.jupiter.params.provider.Arguments.of("4"),
                org.junit.jupiter.params.provider.Arguments.of("42.53 "),
                org.junit.jupiter.params.provider.Arguments.of("46.550 "),
                org.junit.jupiter.params.provider.Arguments.of("51.010 "),
                org.junit.jupiter.params.provider.Arguments.of("6.87 "),
                org.junit.jupiter.params.provider.Arguments.of("69123"),
                org.junit.jupiter.params.provider.Arguments.of("80"),
                org.junit.jupiter.params.provider.Arguments.of("9,728.95 "),
                org.junit.jupiter.params.provider.Arguments.of("AAPL"),
                org.junit.jupiter.params.provider.Arguments.of("Apple Inc"),
                org.junit.jupiter.params.provider.Arguments.of("Bankkaufmann/-frau"),
                org.junit.jupiter.params.provider.Arguments.of("Berxviiitpai"),
                org.junit.jupiter.params.provider.Arguments.of("Bodo W."),
                org.junit.jupiter.params.provider.Arguments.of("Boom"),
                org.junit.jupiter.params.provider.Arguments.of("CR\rCR"),
                org.junit.jupiter.params.provider.Arguments.of("CRLF\r\nCRLF"),
                org.junit.jupiter.params.provider.Arguments.of("CastObce"),
                org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy1"),
                org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy2"),
                org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy3"),
                org.junit.jupiter.params.provider.Arguments.of("D"),
                org.junit.jupiter.params.provider.Arguments.of("DE35672300000000123461"),
                org.junit.jupiter.params.provider.Arguments.of("Datum: 21.04.2017"),
                org.junit.jupiter.params.provider.Arguments.of("Dipl.-Ing."),
                org.junit.jupiter.params.provider.Arguments.of("Email"),
                org.junit.jupiter.params.provider.Arguments.of("FirstName"),
                org.junit.jupiter.params.provider.Arguments.of("Heidelberg"),
                org.junit.jupiter.params.provider.Arguments.of("INDEX"),
                org.junit.jupiter.params.provider.Arguments.of("INTC"),
                org.junit.jupiter.params.provider.Arguments.of("IdentificationNumber"),
                org.junit.jupiter.params.provider.Arguments.of("Index Funds S&P 500Â® Equal Wei..."),
                org.junit.jupiter.params.provider.Arguments.of("Intel Corp"),
                org.junit.jupiter.params.provider.Arguments.of("LFLF"),
                org.junit.jupiter.params.provider.Arguments.of("LFCR\n\rLFCR"),
                org.junit.jupiter.params.provider.Arguments.of("LastName"),
                org.junit.jupiter.params.provider.Arguments.of("Lebensweg 1 "),
                org.junit.jupiter.params.provider.Arguments.of("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam"),
                org.junit.jupiter.params.provider.Arguments.of("MLP Finanzdienstleistungen"),
                org.junit.jupiter.params.provider.Arguments.of("MU"),
                org.junit.jupiter.params.provider.Arguments.of("Micron Technology Inc"),
                org.junit.jupiter.params.provider.Arguments.of("MistoNarozeni"),
                org.junit.jupiter.params.provider.Arguments.of("Multiline - Fixed"),
                org.junit.jupiter.params.provider.Arguments.of("Multiline - auto"),
                org.junit.jupiter.params.provider.Arguments.of("NUL NUL"),
                org.junit.jupiter.params.provider.Arguments.of("Nr. 661242"),
                org.junit.jupiter.params.provider.Arguments.of("Obec"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of("Produkt1"),
                org.junit.jupiter.params.provider.Arguments.of("Produkt2"),
                org.junit.jupiter.params.provider.Arguments.of("Produkt3"),
                org.junit.jupiter.params.provider.Arguments.of("Psc"),
                org.junit.jupiter.params.provider.Arguments.of("QCOM"),
                org.junit.jupiter.params.provider.Arguments.of("Qualcomm Inc"),
                org.junit.jupiter.params.provider.Arguments.of("Risiko"),
                org.junit.jupiter.params.provider.Arguments.of("SPACE SPACE"),
                org.junit.jupiter.params.provider.Arguments.of("Singleline - Fixed"),
                org.junit.jupiter.params.provider.Arguments.of("Singleline - auto"),
                org.junit.jupiter.params.provider.Arguments.of("TAB	TAB"),
                org.junit.jupiter.params.provider.Arguments.of("Telephone"),
                org.junit.jupiter.params.provider.Arguments.of("Test1"),
                org.junit.jupiter.params.provider.Arguments.of("Test2"),
                org.junit.jupiter.params.provider.Arguments.of("Uhrzeit: 13:14"),
                org.junit.jupiter.params.provider.Arguments.of("Ulice"),
                org.junit.jupiter.params.provider.Arguments.of("asdfASDF1234äöü"),
                org.junit.jupiter.params.provider.Arguments.of("different layout"),
                org.junit.jupiter.params.provider.Arguments.of("field value"),
                org.junit.jupiter.params.provider.Arguments.of("linebreak linebreak"),
                org.junit.jupiter.params.provider.Arguments.of("paragraphbreak paragraphbreak"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation0Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation180Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation270Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.multi.rotation90Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation0"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation180"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation270"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation90"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation0Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation180Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation270Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.multi.rotation90Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation0"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation180"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation270"),
                org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation90"),
                org.junit.jupiter.params.provider.Arguments.of("same layout"),
                org.junit.jupiter.params.provider.Arguments.of("sdfASDF1234äöü"),
                org.junit.jupiter.params.provider.Arguments.of("single annotation"),
                org.junit.jupiter.params.provider.Arguments.of("text"),
                org.junit.jupiter.params.provider.Arguments.of("země")
        );
    }
}