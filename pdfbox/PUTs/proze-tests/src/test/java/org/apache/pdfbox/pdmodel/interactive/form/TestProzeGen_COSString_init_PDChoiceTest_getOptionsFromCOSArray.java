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
 * Test for the PDChoice class.
 */
public class TestProzeGen_COSString_init_PDChoiceTest_getOptionsFromCOSArray {
    private org.apache.pdfbox.pdmodel.PDDocument document;

    private PDAcroForm acroForm;

    private java.util.List<String> options;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        document = new org.apache.pdfbox.pdmodel.PDDocument();
        acroForm = new PDAcroForm(document);
        options = new java.util.ArrayList<String>();
        options.add(" ");
        options.add("A");
        options.add("B");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void getOptionsFromCOSArray(String param0) {
        PDChoice choiceField = new PDComboBox(acroForm);
        org.apache.pdfbox.cos.COSArray choiceFieldOptions = new org.apache.pdfbox.cos.COSArray();
        // add entry to options
        org.apache.pdfbox.cos.COSArray entry = new org.apache.pdfbox.cos.COSArray();
        entry.add(new org.apache.pdfbox.cos.COSString(param0));
        choiceFieldOptions.add(entry);
        // add entry to options
        entry = new org.apache.pdfbox.cos.COSArray();
        entry.add(new org.apache.pdfbox.cos.COSString(param0));
        choiceFieldOptions.add(entry);
        // add entry to options
        entry = new org.apache.pdfbox.cos.COSArray();
        entry.add(new org.apache.pdfbox.cos.COSString(param0));
        choiceFieldOptions.add(entry);
        // add the options using the low level COS model as the PD model will
        // abstract the COSArray
        choiceField.getCOSObject().setItem(org.apache.pdfbox.cos.COSName.OPT, choiceFieldOptions);
        assertEquals(options, choiceField.getOptions());
    }
    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(" "),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of("	"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of("        <body style=\"font:12pt Helvetica; color:#197FB2;\" xfa:APIVersion=\"Acrobat:7.0.8\" xfa:spec=\"2.0.2\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">          <p>A free text annotation</p>        </body>      "),
                org.junit.jupiter.params.provider.Arguments.of("        <body style=\"font:12pt Helvetica; color:#D66C00;\" xfa:APIVersion=\"Acrobat:7.0.8\" xfa:spec=\"2.0.2\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">          <p dir=\"ltr\">P&amp;1 <span style=\"text-decoration:word;font-family:Helvetica\">P&amp;2</span> P&amp;3</p>        </body>      "),
                org.junit.jupiter.params.provider.Arguments.of("        <body style=\"font:12pt Helvetica; color:#D66C00;\" xfa:APIVersion=\"Acrobat:7.0.8\" xfa:spec=\"2.0.2\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">          <p>A callout annotation</p>        </body>      "),
                org.junit.jupiter.params.provider.Arguments.of("        <body xfa:APIVersion=\"Acrobat:7.0.8\" xfa:spec=\"2.0.2\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">          <p>A note annotation</p>        </body>      "),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of("\r"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(" "),
                org.junit.jupiter.params.provider.Arguments.of("!"),
                org.junit.jupiter.params.provider.Arguments.of("\""),
                org.junit.jupiter.params.provider.Arguments.of("#"),
                org.junit.jupiter.params.provider.Arguments.of("$"),
                org.junit.jupiter.params.provider.Arguments.of("%"),
                org.junit.jupiter.params.provider.Arguments.of("&"),
                org.junit.jupiter.params.provider.Arguments.of("'"),
                org.junit.jupiter.params.provider.Arguments.of("("),
                org.junit.jupiter.params.provider.Arguments.of(")"),
                org.junit.jupiter.params.provider.Arguments.of("*"),
                org.junit.jupiter.params.provider.Arguments.of("+"),
                org.junit.jupiter.params.provider.Arguments.of("-"),
                org.junit.jupiter.params.provider.Arguments.of("."),
                org.junit.jupiter.params.provider.Arguments.of("/"),
                org.junit.jupiter.params.provider.Arguments.of("/F1 12 Tf 0.019 0.305 0.627 rg"),
                org.junit.jupiter.params.provider.Arguments.of("/Helv 0 Tf 0 g "),
                org.junit.jupiter.params.provider.Arguments.of("/Helvetica 12 Tf 0.100 0.500 0.700 rg"),
                org.junit.jupiter.params.provider.Arguments.of("/Helvetica 12 Tf 0.842 0.424 0.000 rg"),
                org.junit.jupiter.params.provider.Arguments.of("0"),
                org.junit.jupiter.params.provider.Arguments.of("1"),
                org.junit.jupiter.params.provider.Arguments.of("2"),
                org.junit.jupiter.params.provider.Arguments.of("2FFACE36-C6E5-4265-8138-DEEBC397DC48"),
                org.junit.jupiter.params.provider.Arguments.of("3"),
                org.junit.jupiter.params.provider.Arguments.of("366094C8-32E8-4BD2-B712-82A3C60EFF29"),
                org.junit.jupiter.params.provider.Arguments.of("4"),
                org.junit.jupiter.params.provider.Arguments.of("5"),
                org.junit.jupiter.params.provider.Arguments.of("6"),
                org.junit.jupiter.params.provider.Arguments.of("7"),
                org.junit.jupiter.params.provider.Arguments.of("7CAA034C-18A5-4D2B-B115-E28CBFE3C924"),
                org.junit.jupiter.params.provider.Arguments.of("8"),
                org.junit.jupiter.params.provider.Arguments.of("88D147A8-CC51-4178-8102-8C63E2C90F08"),
                org.junit.jupiter.params.provider.Arguments.of("88D147A8-CC51-4178-8102-8C63E2C90F09"),
                org.junit.jupiter.params.provider.Arguments.of("9"),
                org.junit.jupiter.params.provider.Arguments.of(":"),
                org.junit.jupiter.params.provider.Arguments.of(";"),
                org.junit.jupiter.params.provider.Arguments.of("<"),
                org.junit.jupiter.params.provider.Arguments.of("="),
                org.junit.jupiter.params.provider.Arguments.of(">"),
                org.junit.jupiter.params.provider.Arguments.of("?"),
                org.junit.jupiter.params.provider.Arguments.of("@"),
                org.junit.jupiter.params.provider.Arguments.of("A"),
                org.junit.jupiter.params.provider.Arguments.of("A callout annotation"),
                org.junit.jupiter.params.provider.Arguments.of("A free text annotation"),
                org.junit.jupiter.params.provider.Arguments.of("A note annotation"),
                org.junit.jupiter.params.provider.Arguments.of("Actinium"),
                org.junit.jupiter.params.provider.Arguments.of("Adobe"),
                org.junit.jupiter.params.provider.Arguments.of("Aluminum"),
                org.junit.jupiter.params.provider.Arguments.of("Americium"),
                org.junit.jupiter.params.provider.Arguments.of("Antimony"),
                org.junit.jupiter.params.provider.Arguments.of("Argon"),
                org.junit.jupiter.params.provider.Arguments.of("Arsenic"),
                org.junit.jupiter.params.provider.Arguments.of("Astatine"),
                org.junit.jupiter.params.provider.Arguments.of("B"),
                org.junit.jupiter.params.provider.Arguments.of("B235EBE8-1549-4D17-8F2B-6ECD94DB3989"),
                org.junit.jupiter.params.provider.Arguments.of("B9BFB6E8-39BC-40DE-BDA5-E230FD7BFBC2"),
                org.junit.jupiter.params.provider.Arguments.of("C"),
                org.junit.jupiter.params.provider.Arguments.of("Courier"),
                org.junit.jupiter.params.provider.Arguments.of("D"),
                org.junit.jupiter.params.provider.Arguments.of("D02B7B2D-4EEB-4238-BD32-F41297615A4D"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150319+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150324+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150329+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150340+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150431+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150432+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150447+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150448+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150453+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150458+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150510+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150536+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("D:20150415150554+00'00'"),
                org.junit.jupiter.params.provider.Arguments.of("DE09FE2C-826D-492C-B945-457A4FA19A37"),
                org.junit.jupiter.params.provider.Arguments.of("E"),
                org.junit.jupiter.params.provider.Arguments.of("ExtendedRoman"),
                org.junit.jupiter.params.provider.Arguments.of("F"),
                org.junit.jupiter.params.provider.Arguments.of("G"),
                org.junit.jupiter.params.provider.Arguments.of("H"),
                org.junit.jupiter.params.provider.Arguments.of("Helvetica"),
                org.junit.jupiter.params.provider.Arguments.of("I"),
                org.junit.jupiter.params.provider.Arguments.of("Identity"),
                org.junit.jupiter.params.provider.Arguments.of("J"),
                org.junit.jupiter.params.provider.Arguments.of("K"),
                org.junit.jupiter.params.provider.Arguments.of("L"),
                org.junit.jupiter.params.provider.Arguments.of("M"),
                org.junit.jupiter.params.provider.Arguments.of("N"),
                org.junit.jupiter.params.provider.Arguments.of("Nimbus Sans L"),
                org.junit.jupiter.params.provider.Arguments.of("O"),
                org.junit.jupiter.params.provider.Arguments.of("P"),
                org.junit.jupiter.params.provider.Arguments.of("P&1 P&2 P&3"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(","),
                org.junit.jupiter.params.provider.Arguments.of("Q"),
                org.junit.jupiter.params.provider.Arguments.of("R"),
                org.junit.jupiter.params.provider.Arguments.of("S"),
                org.junit.jupiter.params.provider.Arguments.of("Special"),
                org.junit.jupiter.params.provider.Arguments.of("Symbol"),
                org.junit.jupiter.params.provider.Arguments.of("T"),
                org.junit.jupiter.params.provider.Arguments.of("Test value"),
                org.junit.jupiter.params.provider.Arguments.of("Test1"),
                org.junit.jupiter.params.provider.Arguments.of("Test2"),
                org.junit.jupiter.params.provider.Arguments.of("Times"),
                org.junit.jupiter.params.provider.Arguments.of("Top"),
                org.junit.jupiter.params.provider.Arguments.of("U"),
                org.junit.jupiter.params.provider.Arguments.of("V"),
                org.junit.jupiter.params.provider.Arguments.of("W"),
                org.junit.jupiter.params.provider.Arguments.of("X"),
                org.junit.jupiter.params.provider.Arguments.of("Xenon"),
                org.junit.jupiter.params.provider.Arguments.of("Y"),
                org.junit.jupiter.params.provider.Arguments.of("Ytterbium"),
                org.junit.jupiter.params.provider.Arguments.of("Yttrium"),
                org.junit.jupiter.params.provider.Arguments.of("Z"),
                org.junit.jupiter.params.provider.Arguments.of("ZapfDingbats"),
                org.junit.jupiter.params.provider.Arguments.of("Zinc"),
                org.junit.jupiter.params.provider.Arguments.of("Zirconium"),
                org.junit.jupiter.params.provider.Arguments.of("["),
                org.junit.jupiter.params.provider.Arguments.of("\\"),
                org.junit.jupiter.params.provider.Arguments.of("]"),
                org.junit.jupiter.params.provider.Arguments.of("^"),
                org.junit.jupiter.params.provider.Arguments.of("_"),
                org.junit.jupiter.params.provider.Arguments.of("`"),
                org.junit.jupiter.params.provider.Arguments.of("a"),
                org.junit.jupiter.params.provider.Arguments.of("alternative"),
                org.junit.jupiter.params.provider.Arguments.of("b"),
                org.junit.jupiter.params.provider.Arguments.of("background"),
                org.junit.jupiter.params.provider.Arguments.of("c"),
                org.junit.jupiter.params.provider.Arguments.of("d"),
                org.junit.jupiter.params.provider.Arguments.of("different layout"),
                org.junit.jupiter.params.provider.Arguments.of("disabled"),
                org.junit.jupiter.params.provider.Arguments.of("e"),
                org.junit.jupiter.params.provider.Arguments.of("enabled"),
                org.junit.jupiter.params.provider.Arguments.of("f"),
                org.junit.jupiter.params.provider.Arguments.of("g"),
                org.junit.jupiter.params.provider.Arguments.of("h"),
                org.junit.jupiter.params.provider.Arguments.of("http://www.color.org"),
                org.junit.jupiter.params.provider.Arguments.of("i"),
                org.junit.jupiter.params.provider.Arguments.of("j"),
                org.junit.jupiter.params.provider.Arguments.of("k"),
                org.junit.jupiter.params.provider.Arguments.of("l"),
                org.junit.jupiter.params.provider.Arguments.of("layer"),
                org.junit.jupiter.params.provider.Arguments.of("m"),
                org.junit.jupiter.params.provider.Arguments.of("n"),
                org.junit.jupiter.params.provider.Arguments.of("o"),
                org.junit.jupiter.params.provider.Arguments.of("p"),
                org.junit.jupiter.params.provider.Arguments.of("q"),
                org.junit.jupiter.params.provider.Arguments.of("r"),
                org.junit.jupiter.params.provider.Arguments.of("s"),
                org.junit.jupiter.params.provider.Arguments.of("sRGB IEC61966-2.1"),
                org.junit.jupiter.params.provider.Arguments.of("same layout"),
                org.junit.jupiter.params.provider.Arguments.of("science"),
                org.junit.jupiter.params.provider.Arguments.of("single annotation"),
                org.junit.jupiter.params.provider.Arguments.of("t"),
                org.junit.jupiter.params.provider.Arguments.of("u"),
                org.junit.jupiter.params.provider.Arguments.of("v"),
                org.junit.jupiter.params.provider.Arguments.of("w"),
                org.junit.jupiter.params.provider.Arguments.of("weblogic"),
                org.junit.jupiter.params.provider.Arguments.of("x"),
                org.junit.jupiter.params.provider.Arguments.of("y"),
                org.junit.jupiter.params.provider.Arguments.of("z"),
                org.junit.jupiter.params.provider.Arguments.of("{"),
                org.junit.jupiter.params.provider.Arguments.of("|"),
                org.junit.jupiter.params.provider.Arguments.of("}"),
                org.junit.jupiter.params.provider.Arguments.of("~"),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(""),
                org.junit.jupiter.params.provider.Arguments.of(" "),
                org.junit.jupiter.params.provider.Arguments.of("¡"),
                org.junit.jupiter.params.provider.Arguments.of("¢"),
                org.junit.jupiter.params.provider.Arguments.of("£"),
                org.junit.jupiter.params.provider.Arguments.of("¤"),
                org.junit.jupiter.params.provider.Arguments.of("¥"),
                org.junit.jupiter.params.provider.Arguments.of("¦"),
                org.junit.jupiter.params.provider.Arguments.of("§"),
                org.junit.jupiter.params.provider.Arguments.of("¨"),
                org.junit.jupiter.params.provider.Arguments.of("©"),
                org.junit.jupiter.params.provider.Arguments.of("ª"),
                org.junit.jupiter.params.provider.Arguments.of("«"),
                org.junit.jupiter.params.provider.Arguments.of("¬"),
                org.junit.jupiter.params.provider.Arguments.of("­"),
                org.junit.jupiter.params.provider.Arguments.of("®"),
                org.junit.jupiter.params.provider.Arguments.of("¯"),
                org.junit.jupiter.params.provider.Arguments.of("°"),
                org.junit.jupiter.params.provider.Arguments.of("±"),
                org.junit.jupiter.params.provider.Arguments.of("²"),
                org.junit.jupiter.params.provider.Arguments.of("³"),
                org.junit.jupiter.params.provider.Arguments.of("´"),
                org.junit.jupiter.params.provider.Arguments.of("µ"),
                org.junit.jupiter.params.provider.Arguments.of("¶"),
                org.junit.jupiter.params.provider.Arguments.of("·"),
                org.junit.jupiter.params.provider.Arguments.of("¸"),
                org.junit.jupiter.params.provider.Arguments.of("¹"),
                org.junit.jupiter.params.provider.Arguments.of("º"),
                org.junit.jupiter.params.provider.Arguments.of("»"),
                org.junit.jupiter.params.provider.Arguments.of("¼"),
                org.junit.jupiter.params.provider.Arguments.of("½"),
                org.junit.jupiter.params.provider.Arguments.of("¾"),
                org.junit.jupiter.params.provider.Arguments.of("¿"),
                org.junit.jupiter.params.provider.Arguments.of("À"),
                org.junit.jupiter.params.provider.Arguments.of("Á"),
                org.junit.jupiter.params.provider.Arguments.of("Â"),
                org.junit.jupiter.params.provider.Arguments.of("Ã"),
                org.junit.jupiter.params.provider.Arguments.of("Ä"),
                org.junit.jupiter.params.provider.Arguments.of("Å"),
                org.junit.jupiter.params.provider.Arguments.of("Æ"),
                org.junit.jupiter.params.provider.Arguments.of("Ç"),
                org.junit.jupiter.params.provider.Arguments.of("È"),
                org.junit.jupiter.params.provider.Arguments.of("É"),
                org.junit.jupiter.params.provider.Arguments.of("Ê"),
                org.junit.jupiter.params.provider.Arguments.of("Ë"),
                org.junit.jupiter.params.provider.Arguments.of("Ì"),
                org.junit.jupiter.params.provider.Arguments.of("Í"),
                org.junit.jupiter.params.provider.Arguments.of("Î"),
                org.junit.jupiter.params.provider.Arguments.of("Ï"),
                org.junit.jupiter.params.provider.Arguments.of("Ð"),
                org.junit.jupiter.params.provider.Arguments.of("Ñ"),
                org.junit.jupiter.params.provider.Arguments.of("Ò"),
                org.junit.jupiter.params.provider.Arguments.of("Ó"),
                org.junit.jupiter.params.provider.Arguments.of("Ô"),
                org.junit.jupiter.params.provider.Arguments.of("Õ"),
                org.junit.jupiter.params.provider.Arguments.of("Ö"),
                org.junit.jupiter.params.provider.Arguments.of("×"),
                org.junit.jupiter.params.provider.Arguments.of("Ø"),
                org.junit.jupiter.params.provider.Arguments.of("Ù"),
                org.junit.jupiter.params.provider.Arguments.of("Ú"),
                org.junit.jupiter.params.provider.Arguments.of("Û"),
                org.junit.jupiter.params.provider.Arguments.of("Ü"),
                org.junit.jupiter.params.provider.Arguments.of("Ý"),
                org.junit.jupiter.params.provider.Arguments.of("Þ"),
                org.junit.jupiter.params.provider.Arguments.of("ß"),
                org.junit.jupiter.params.provider.Arguments.of("à"),
                org.junit.jupiter.params.provider.Arguments.of("á"),
                org.junit.jupiter.params.provider.Arguments.of("â"),
                org.junit.jupiter.params.provider.Arguments.of("ã"),
                org.junit.jupiter.params.provider.Arguments.of("ä"),
                org.junit.jupiter.params.provider.Arguments.of("å"),
                org.junit.jupiter.params.provider.Arguments.of("æ"),
                org.junit.jupiter.params.provider.Arguments.of("ç"),
                org.junit.jupiter.params.provider.Arguments.of("è"),
                org.junit.jupiter.params.provider.Arguments.of("é"),
                org.junit.jupiter.params.provider.Arguments.of("ê"),
                org.junit.jupiter.params.provider.Arguments.of("ë"),
                org.junit.jupiter.params.provider.Arguments.of("ì"),
                org.junit.jupiter.params.provider.Arguments.of("í"),
                org.junit.jupiter.params.provider.Arguments.of("î"),
                org.junit.jupiter.params.provider.Arguments.of("ï"),
                org.junit.jupiter.params.provider.Arguments.of("ð"),
                org.junit.jupiter.params.provider.Arguments.of("ñ"),
                org.junit.jupiter.params.provider.Arguments.of("ò"),
                org.junit.jupiter.params.provider.Arguments.of("ó"),
                org.junit.jupiter.params.provider.Arguments.of("ô"),
                org.junit.jupiter.params.provider.Arguments.of("õ"),
                org.junit.jupiter.params.provider.Arguments.of("ö"),
                org.junit.jupiter.params.provider.Arguments.of("÷"),
                org.junit.jupiter.params.provider.Arguments.of("ø"),
                org.junit.jupiter.params.provider.Arguments.of("ù"),
                org.junit.jupiter.params.provider.Arguments.of("ú"),
                org.junit.jupiter.params.provider.Arguments.of("û"),
                org.junit.jupiter.params.provider.Arguments.of("ü"),
                org.junit.jupiter.params.provider.Arguments.of("ý"),
                org.junit.jupiter.params.provider.Arguments.of("þ"),
                org.junit.jupiter.params.provider.Arguments.of("ÿ"),
                org.junit.jupiter.params.provider.Arguments.of("ı"),
                org.junit.jupiter.params.provider.Arguments.of("Ł"),
                org.junit.jupiter.params.provider.Arguments.of("ł"),
                org.junit.jupiter.params.provider.Arguments.of("Œ"),
                org.junit.jupiter.params.provider.Arguments.of("œ"),
                org.junit.jupiter.params.provider.Arguments.of("Š"),
                org.junit.jupiter.params.provider.Arguments.of("š"),
                org.junit.jupiter.params.provider.Arguments.of("Ÿ"),
                org.junit.jupiter.params.provider.Arguments.of("Ž"),
                org.junit.jupiter.params.provider.Arguments.of("ž"),
                org.junit.jupiter.params.provider.Arguments.of("ƒ"),
                org.junit.jupiter.params.provider.Arguments.of("ˆ"),
                org.junit.jupiter.params.provider.Arguments.of("ˇ"),
                org.junit.jupiter.params.provider.Arguments.of("˘"),
                org.junit.jupiter.params.provider.Arguments.of("˙"),
                org.junit.jupiter.params.provider.Arguments.of("˚"),
                org.junit.jupiter.params.provider.Arguments.of("˛"),
                org.junit.jupiter.params.provider.Arguments.of("˜"),
                org.junit.jupiter.params.provider.Arguments.of("˝"),
                org.junit.jupiter.params.provider.Arguments.of("–"),
                org.junit.jupiter.params.provider.Arguments.of("—"),
                org.junit.jupiter.params.provider.Arguments.of("‘"),
                org.junit.jupiter.params.provider.Arguments.of("’"),
                org.junit.jupiter.params.provider.Arguments.of("‚"),
                org.junit.jupiter.params.provider.Arguments.of("“"),
                org.junit.jupiter.params.provider.Arguments.of("”"),
                org.junit.jupiter.params.provider.Arguments.of("„"),
                org.junit.jupiter.params.provider.Arguments.of("†"),
                org.junit.jupiter.params.provider.Arguments.of("‡"),
                org.junit.jupiter.params.provider.Arguments.of("•"),
                org.junit.jupiter.params.provider.Arguments.of("…"),
                org.junit.jupiter.params.provider.Arguments.of("‰"),
                org.junit.jupiter.params.provider.Arguments.of("‹"),
                org.junit.jupiter.params.provider.Arguments.of("›"),
                org.junit.jupiter.params.provider.Arguments.of("⁄"),
                org.junit.jupiter.params.provider.Arguments.of("€"),
                org.junit.jupiter.params.provider.Arguments.of("™"),
                org.junit.jupiter.params.provider.Arguments.of("−"),
                org.junit.jupiter.params.provider.Arguments.of("ﬁ"),
                org.junit.jupiter.params.provider.Arguments.of("ﬂ")
        );
    }
}