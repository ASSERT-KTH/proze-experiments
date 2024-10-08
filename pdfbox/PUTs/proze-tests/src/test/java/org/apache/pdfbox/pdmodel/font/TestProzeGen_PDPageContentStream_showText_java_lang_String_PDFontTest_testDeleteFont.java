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
package org.apache.pdfbox.pdmodel.font;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author adam
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont {
    private static final java.io.File OUT_DIR = new java.io.File("target/test-output");

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR.mkdirs();
    }

    /**
     * Check that font can be deleted after usage.
     *
     * @throws IOException
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDeleteFont(String param0) throws IOException {
        java.io.File tempFontFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "LiberationSans-Regular.ttf");
        java.io.File tempPdfFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "testDeleteFont.pdf");
        String text = "Test PDFBOX-4823";
        java.io.InputStream is = PDFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
        java.io.OutputStream os = new java.io.FileOutputStream(tempFontFile);
        org.apache.pdfbox.io.IOUtils.copy(is, os);
        is.close();
        os.close();
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDFont font1 = PDType0Font.load(doc, tempFontFile);
        cs.beginText();
        cs.setFont(font1, 50);
        cs.newLineAtOffset(50, 700);
        cs.showText(param0);
        cs.endText();
        cs.close();
        doc.save(tempPdfFile);
        doc.close();
        assertTrue(tempFontFile.delete());
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(tempPdfFile);
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String extractedText = stripper.getText(doc);
        assertEquals(text, extractedText.trim());
        doc.close();
        assertTrue(tempPdfFile.delete());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDeleteFont_1(String param0) throws IOException {
        java.io.File tempFontFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "LiberationSans-Regular.ttf");
        java.io.File tempPdfFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "testDeleteFont.pdf");
        String text = "Test PDFBOX-4823";
        java.io.InputStream is = PDFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
        java.io.OutputStream os = new java.io.FileOutputStream(tempFontFile);
        org.apache.pdfbox.io.IOUtils.copy(is, os);
        is.close();
        os.close();
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDFont font1 = PDType0Font.load(doc, tempFontFile);
        cs.beginText();
        cs.setFont(font1, 50);
        cs.newLineAtOffset(50, 700);
        cs.showText(param0);
        cs.endText();
        cs.close();
        doc.save(tempPdfFile);
        doc.close();
        assertTrue(tempFontFile.delete());
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(tempPdfFile);
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String extractedText = stripper.getText(doc);
        // assertEquals(text, extractedText.trim());
        doc.close();
        // assertTrue(tempPdfFile.delete());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDeleteFont_2(String param0) throws IOException {
        java.io.File tempFontFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "LiberationSans-Regular.ttf");
        java.io.File tempPdfFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "testDeleteFont.pdf");
        String text = "Test PDFBOX-4823";
        java.io.InputStream is = PDFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
        java.io.OutputStream os = new java.io.FileOutputStream(tempFontFile);
        org.apache.pdfbox.io.IOUtils.copy(is, os);
        is.close();
        os.close();
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDFont font1 = PDType0Font.load(doc, tempFontFile);
        cs.beginText();
        cs.setFont(font1, 50);
        cs.newLineAtOffset(50, 700);
        cs.showText(param0);
        cs.endText();
        cs.close();
        doc.save(tempPdfFile);
        doc.close();
        // assertTrue(tempFontFile.delete());
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(tempPdfFile);
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String extractedText = stripper.getText(doc);
        assertEquals(text, extractedText.trim());
        doc.close();
        // assertTrue(tempPdfFile.delete());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testDeleteFont_3(String param0) throws IOException {
        java.io.File tempFontFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "LiberationSans-Regular.ttf");
        java.io.File tempPdfFile = new java.io.File(TestProzeGen_PDPageContentStream_showText_java_lang_String_PDFontTest_testDeleteFont.OUT_DIR, "testDeleteFont.pdf");
        String text = "Test PDFBOX-4823";
        java.io.InputStream is = PDFont.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
        java.io.OutputStream os = new java.io.FileOutputStream(tempFontFile);
        org.apache.pdfbox.io.IOUtils.copy(is, os);
        is.close();
        os.close();
        org.apache.pdfbox.pdmodel.PDDocument doc = new org.apache.pdfbox.pdmodel.PDDocument();
        org.apache.pdfbox.pdmodel.PDPage page = new org.apache.pdfbox.pdmodel.PDPage();
        doc.addPage(page);
        org.apache.pdfbox.pdmodel.PDPageContentStream cs = new org.apache.pdfbox.pdmodel.PDPageContentStream(doc, page);
        PDFont font1 = PDType0Font.load(doc, tempFontFile);
        cs.beginText();
        cs.setFont(font1, 50);
        cs.newLineAtOffset(50, 700);
        cs.showText(param0);
        cs.endText();
        cs.close();
        doc.save(tempPdfFile);
        doc.close();
        // assertTrue(tempFontFile.delete());
        doc = org.apache.pdfbox.pdmodel.PDDocument.load(tempPdfFile);
        org.apache.pdfbox.text.PDFTextStripper stripper = new org.apache.pdfbox.text.PDFTextStripper();
        String extractedText = stripper.getText(doc);
        // assertEquals(text, extractedText.trim());
        doc.close();
        assertTrue(tempPdfFile.delete());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(" "),
        org.junit.jupiter.params.provider.Arguments.of("        NOAA's Undersea Research Program "),
        org.junit.jupiter.params.provider.Arguments.of("       30 seconds without falling. "),
        org.junit.jupiter.params.provider.Arguments.of("       Bounce a tennis ball off the wall and try to catch it while "),
        org.junit.jupiter.params.provider.Arguments.of("       Choose a smooth-surfaced solid wall, approved by an "),
        org.junit.jupiter.params.provider.Arguments.of("       Continue to practice this activity over time until you can "),
        org.junit.jupiter.params.provider.Arguments.of("       Count how many seconds you can stand on one foot "),
        org.junit.jupiter.params.provider.Arguments.of("       If a player loses balance and both feet touch the floor, he "),
        org.junit.jupiter.params.provider.Arguments.of("       Space a distance more than arms length apart. "),
        org.junit.jupiter.params.provider.Arguments.of("       Try to balance on one foot while gently tossing a gym "),
        org.junit.jupiter.params.provider.Arguments.of("       around the outside of the circle before rejoining the "),
        org.junit.jupiter.params.provider.Arguments.of("       foot up behind you, level with your knee. "),
        org.junit.jupiter.params.provider.Arguments.of("       the wall. Try not to let the ball or your foot touch the "),
        org.junit.jupiter.params.provider.Arguments.of("       without having to start over. "),
        org.junit.jupiter.params.provider.Arguments.of("    Do not throw the ball too hard, nor use a ball that is too "),
        org.junit.jupiter.params.provider.Arguments.of("    Remember that drinking plenty of water is important "),
        org.junit.jupiter.params.provider.Arguments.of("    While exploring, astronauts must watch out "),
        org.junit.jupiter.params.provider.Arguments.of("    doing this activity. "),
        org.junit.jupiter.params.provider.Arguments.of("    for rocks and craters in their paths to avoid tripping! "),
        org.junit.jupiter.params.provider.Arguments.of(" 083 for snow and ice removal. "),
        org.junit.jupiter.params.provider.Arguments.of(" A "),
        org.junit.jupiter.params.provider.Arguments.of(" Astronauts simulating gall bladder removal "),
        org.junit.jupiter.params.provider.Arguments.of(" Base Lift Transporter "),
        org.junit.jupiter.params.provider.Arguments.of(" LEGOnauts at Base Dual Transporter "),
        org.junit.jupiter.params.provider.Arguments.of(" Mass Transporter "),
        org.junit.jupiter.params.provider.Arguments.of(" Select Comparison"),
        org.junit.jupiter.params.provider.Arguments.of(" Solo Transporters "),
        org.junit.jupiter.params.provider.Arguments.of(" i cy and slippery conditions "),
        org.junit.jupiter.params.provider.Arguments.of(" voiding slips and falls during "),
        org.junit.jupiter.params.provider.Arguments.of("(NURP) Aquarius (see box below), an "),
        org.junit.jupiter.params.provider.Arguments.of("- ­"),
        org.junit.jupiter.params.provider.Arguments.of("-- "),
        org.junit.jupiter.params.provider.Arguments.of("09.2017"),
        org.junit.jupiter.params.provider.Arguments.of("1. Wear boots or overshoes with gripping soles. Slick leather, "),
        org.junit.jupiter.params.provider.Arguments.of("10. Dress warmly. Being cold may cause you to hurry or "),
        org.junit.jupiter.params.provider.Arguments.of("100000"),
        org.junit.jupiter.params.provider.Arguments.of("106,76"),
        org.junit.jupiter.params.provider.Arguments.of("11. Be extremely careful getting out of your vehicle. If "),
        org.junit.jupiter.params.provider.Arguments.of("113.020 "),
        org.junit.jupiter.params.provider.Arguments.of("115.470 "),
        org.junit.jupiter.params.provider.Arguments.of("12. Don't take shortcuts. Always use sidewalks and the "),
        org.junit.jupiter.params.provider.Arguments.of("123456"),
        org.junit.jupiter.params.provider.Arguments.of("12” "),
        org.junit.jupiter.params.provider.Arguments.of("13. When walking after sunset or in shadowed areas, be alert "),
        org.junit.jupiter.params.provider.Arguments.of("1315 East-West Highway, Silver Spring, MD 20910 "),
        org.junit.jupiter.params.provider.Arguments.of("14. Use handrails for balance wherever available. "),
        org.junit.jupiter.params.provider.Arguments.of("16” Robot "),
        org.junit.jupiter.params.provider.Arguments.of("17.40 "),
        org.junit.jupiter.params.provider.Arguments.of("172,20"),
        org.junit.jupiter.params.provider.Arguments.of("17,394.41 "),
        org.junit.jupiter.params.provider.Arguments.of("180"),
        org.junit.jupiter.params.provider.Arguments.of("19.06.1980"),
        org.junit.jupiter.params.provider.Arguments.of("1,173.74 "),
        org.junit.jupiter.params.provider.Arguments.of("2. Do not walk with your hands in your pockets. This reduces "),
        org.junit.jupiter.params.provider.Arguments.of("2.10 "),
        org.junit.jupiter.params.provider.Arguments.of("20"),
        org.junit.jupiter.params.provider.Arguments.of("201707"),
        org.junit.jupiter.params.provider.Arguments.of("206 "),
        org.junit.jupiter.params.provider.Arguments.of("209 "),
        org.junit.jupiter.params.provider.Arguments.of("23,780.82 "),
        org.junit.jupiter.params.provider.Arguments.of("2x4 border "),
        org.junit.jupiter.params.provider.Arguments.of("3. Take short deliberate shuffling steps in very icy areas. "),
        org.junit.jupiter.params.provider.Arguments.of("31.11 "),
        org.junit.jupiter.params.provider.Arguments.of("33.090 "),
        org.junit.jupiter.params.provider.Arguments.of("34 "),
        org.junit.jupiter.params.provider.Arguments.of("341 "),
        org.junit.jupiter.params.provider.Arguments.of("35 "),
        org.junit.jupiter.params.provider.Arguments.of("37"),
        org.junit.jupiter.params.provider.Arguments.of("3,842.68 "),
        org.junit.jupiter.params.provider.Arguments.of("4"),
        org.junit.jupiter.params.provider.Arguments.of("4 ft "),
        org.junit.jupiter.params.provider.Arguments.of("4. Do not carry or swing heavy loads, such as large boxes, "),
        org.junit.jupiter.params.provider.Arguments.of("42.53 "),
        org.junit.jupiter.params.provider.Arguments.of("4207. "),
        org.junit.jupiter.params.provider.Arguments.of("46.550 "),
        org.junit.jupiter.params.provider.Arguments.of("5. Give yourself plenty of time. Take short steps with your "),
        org.junit.jupiter.params.provider.Arguments.of("51.010 "),
        org.junit.jupiter.params.provider.Arguments.of("6. Don't step on uneven surfaces. Avoid curbs covered with "),
        org.junit.jupiter.params.provider.Arguments.of("6.87 "),
        org.junit.jupiter.params.provider.Arguments.of("62 feet below the ocean’s surface. "),
        org.junit.jupiter.params.provider.Arguments.of("69123"),
        org.junit.jupiter.params.provider.Arguments.of("7. Try to walk on snow rather than icy areas. "),
        org.junit.jupiter.params.provider.Arguments.of("8. Place your full attention on walking. Distractions such as "),
        org.junit.jupiter.params.provider.Arguments.of("80"),
        org.junit.jupiter.params.provider.Arguments.of("9. If you are the first one to arrive at your building, take the "),
        org.junit.jupiter.params.provider.Arguments.of("9,728.95 "),
        org.junit.jupiter.params.provider.Arguments.of("A quarius is currently the only operational, offshore "),
        org.junit.jupiter.params.provider.Arguments.of("AAPL"),
        org.junit.jupiter.params.provider.Arguments.of("Additionally, habitation onboard Aquarius "),
        org.junit.jupiter.params.provider.Arguments.of("Agile: NASA’s Neurosciences Laboratory closely monitor the "),
        org.junit.jupiter.params.provider.Arguments.of("All diagnostic and surgical tasks were performed "),
        org.junit.jupiter.params.provider.Arguments.of("All people need to have well-developed balance and spatial "),
        org.junit.jupiter.params.provider.Arguments.of("Alternative 1: The earth is a flat circle"),
        org.junit.jupiter.params.provider.Arguments.of("Alternative 2: The earth is a flat parallelogram"),
        org.junit.jupiter.params.provider.Arguments.of("Andrew Shepard, "),
        org.junit.jupiter.params.provider.Arguments.of("Apple Inc"),
        org.junit.jupiter.params.provider.Arguments.of("Aquarius. "),
        org.junit.jupiter.params.provider.Arguments.of("Astronauts are able to practice for space walks "),
        org.junit.jupiter.params.provider.Arguments.of("BASE and every time it is returned to the "),
        org.junit.jupiter.params.provider.Arguments.of("BASE. "),
        org.junit.jupiter.params.provider.Arguments.of("Bankkaufmann/-frau"),
        org.junit.jupiter.params.provider.Arguments.of("Base "),
        org.junit.jupiter.params.provider.Arguments.of("Being ready and able who often report difficulty walking "),
        org.junit.jupiter.params.provider.Arguments.of("Below is everything that we know about the challenge. "),
        org.junit.jupiter.params.provider.Arguments.of("Berxviiitpai"),
        org.junit.jupiter.params.provider.Arguments.of("Bodo W."),
        org.junit.jupiter.params.provider.Arguments.of("Boom"),
        org.junit.jupiter.params.provider.Arguments.of("COMPLETELY inside the ROBOT BASE without penalty. "),
        org.junit.jupiter.params.provider.Arguments.of("CR"),
        org.junit.jupiter.params.provider.Arguments.of("CRLF"),
        org.junit.jupiter.params.provider.Arguments.of("Call Plant Engineering at extensions 3082 or 3 "),
        org.junit.jupiter.params.provider.Arguments.of("CastObce"),
        org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy1"),
        org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy2"),
        org.junit.jupiter.params.provider.Arguments.of("CisloSmlouvy3"),
        org.junit.jupiter.params.provider.Arguments.of("Complete the balance game without losing your balance. "),
        org.junit.jupiter.params.provider.Arguments.of("Complete the practice of throwing and catching the tennis "),
        org.junit.jupiter.params.provider.Arguments.of("Coordination: their inner ear, and their muscles to help "),
        org.junit.jupiter.params.provider.Arguments.of("D"),
        org.junit.jupiter.params.provider.Arguments.of("DE35672300000000123461"),
        org.junit.jupiter.params.provider.Arguments.of("Datum: 21.04.2017"),
        org.junit.jupiter.params.provider.Arguments.of("December 7, 2002 "),
        org.junit.jupiter.params.provider.Arguments.of("December 7, 2002 at Hogg Middle School. "),
        org.junit.jupiter.params.provider.Arguments.of("Dipl.-Ing."),
        org.junit.jupiter.params.provider.Arguments.of("Divide into groups, each forming a circle. Each circle should "),
        org.junit.jupiter.params.provider.Arguments.of("EXPLORATION ZONE.  Is anyone here ready to step up to the "),
        org.junit.jupiter.params.provider.Arguments.of("Email"),
        org.junit.jupiter.params.provider.Arguments.of("Engineering at extension 3084. "),
        org.junit.jupiter.params.provider.Arguments.of("Environment Mission Operations (NEEMO) "),
        org.junit.jupiter.params.provider.Arguments.of("FIT EXPLORER MISSION HANDOUT "),
        org.junit.jupiter.params.provider.Arguments.of("Fall 2002 Simple Machines Robotics Competition "),
        org.junit.jupiter.params.provider.Arguments.of("FirstName"),
        org.junit.jupiter.params.provider.Arguments.of("Follow these instructions to train like an astronaut. "),
        org.junit.jupiter.params.provider.Arguments.of("For further information contact:      space "),
        org.junit.jupiter.params.provider.Arguments.of("For replacement of calcium ice melt buckets at the entrance "),
        org.junit.jupiter.params.provider.Arguments.of("Game: "),
        org.junit.jupiter.params.provider.Arguments.of("HABITATION ZONE counts 5 points. "),
        org.junit.jupiter.params.provider.Arguments.of("HABITATION ZONE. "),
        org.junit.jupiter.params.provider.Arguments.of("Heidelberg"),
        org.junit.jupiter.params.provider.Arguments.of("Hogg Middle School "),
        org.junit.jupiter.params.provider.Arguments.of("INDEX"),
        org.junit.jupiter.params.provider.Arguments.of("INTC"),
        org.junit.jupiter.params.provider.Arguments.of("IdentificationNumber"),
        org.junit.jupiter.params.provider.Arguments.of("If after contacting any of the Plant Engineering numbers, the "),
        org.junit.jupiter.params.provider.Arguments.of("If not, we would all fall over constantly and have trouble "),
        org.junit.jupiter.params.provider.Arguments.of("Improving your     The area under your feet should be clear of "),
        org.junit.jupiter.params.provider.Arguments.of("In your circle: "),
        org.junit.jupiter.params.provider.Arguments.of("Index Funds S&P 500Â® Equal Wei..."),
        org.junit.jupiter.params.provider.Arguments.of("Intel Corp"),
        org.junit.jupiter.params.provider.Arguments.of("International Space Station module "),
        org.junit.jupiter.params.provider.Arguments.of("It is important that everyone recognizes the hazards of "),
        org.junit.jupiter.params.provider.Arguments.of("Kits. "),
        org.junit.jupiter.params.provider.Arguments.of("Knowing where you It’s a NASA Fact: "),
        org.junit.jupiter.params.provider.Arguments.of("LANDING ZONE is considered part of the "),
        org.junit.jupiter.params.provider.Arguments.of("LEGOnauts from the LANDING ZONE to the "),
        org.junit.jupiter.params.provider.Arguments.of("LEGOnauts, welcome to LEGO Centauri.  Wow, that was a "),
        org.junit.jupiter.params.provider.Arguments.of("LF"),
        org.junit.jupiter.params.provider.Arguments.of("LFCR"),
        org.junit.jupiter.params.provider.Arguments.of("LastName"),
        org.junit.jupiter.params.provider.Arguments.of("Lebensweg 1 "),
        org.junit.jupiter.params.provider.Arguments.of("Living in Aquarius for up to two weeks, astronauts "),
        org.junit.jupiter.params.provider.Arguments.of("Look in a mirror, or have another student watch you to check "),
        org.junit.jupiter.params.provider.Arguments.of("Lorem "),
        org.junit.jupiter.params.provider.Arguments.of("MISSION ASSIGNMENT:  Balance Training "),
        org.junit.jupiter.params.provider.Arguments.of("MISSION COMPLETE:  Test Yourself! "),
        org.junit.jupiter.params.provider.Arguments.of("MISSION QUESTION: How could you perform a physical "),
        org.junit.jupiter.params.provider.Arguments.of("MISSION: CONTROL! "),
        org.junit.jupiter.params.provider.Arguments.of("MLP Finanzdienstleistungen"),
        org.junit.jupiter.params.provider.Arguments.of("MU"),
        org.junit.jupiter.params.provider.Arguments.of("Micron Technology Inc"),
        org.junit.jupiter.params.provider.Arguments.of("MistoNarozeni"),
        org.junit.jupiter.params.provider.Arguments.of("NASA astronauts live and work onboard the "),
        org.junit.jupiter.params.provider.Arguments.of("NASA partnership designed to prepare "),
        org.junit.jupiter.params.provider.Arguments.of("NEEMO missions on board Aquarius "),
        org.junit.jupiter.params.provider.Arguments.of("NEEMO missions, astronauts have practiced "),
        org.junit.jupiter.params.provider.Arguments.of("NURC-UNCW Director "),
        org.junit.jupiter.params.provider.Arguments.of("NURP Supports NASA Extreme "),
        org.junit.jupiter.params.provider.Arguments.of("National Aeronautics and Space Administration "),
        org.junit.jupiter.params.provider.Arguments.of("National Marine Sanctuary (FKNMS) seafloor "),
        org.junit.jupiter.params.provider.Arguments.of("National Undersea Research Program’s "),
        org.junit.jupiter.params.provider.Arguments.of("Nr. 661242"),
        org.junit.jupiter.params.provider.Arguments.of("Obec"),
        org.junit.jupiter.params.provider.Arguments.of("Open your eyes if you start to lose your balance. "),
        org.junit.jupiter.params.provider.Arguments.of("Operations (NEEMO) program is a NOAA- "),
        org.junit.jupiter.params.provider.Arguments.of("Operations Center (ExPOC) control room, Aquarius, the "),
        org.junit.jupiter.params.provider.Arguments.of("P rogram (NURP).  Its unique design allows scientists to live "),
        org.junit.jupiter.params.provider.Arguments.of("PDF 1.5: Optional Content Groups"),
        org.junit.jupiter.params.provider.Arguments.of(""),
        org.junit.jupiter.params.provider.Arguments.of("Phone: (301) 713-2427   Fax: (301) 713-1967 "),
        org.junit.jupiter.params.provider.Arguments.of("Platform "),
        org.junit.jupiter.params.provider.Arguments.of("Please contact Lucien at Lucien.Junkin@jsc.nasa.gov with "),
        org.junit.jupiter.params.provider.Arguments.of("Practice: "),
        org.junit.jupiter.params.provider.Arguments.of("Produkt1"),
        org.junit.jupiter.params.provider.Arguments.of("Produkt2"),
        org.junit.jupiter.params.provider.Arguments.of("Produkt3"),
        org.junit.jupiter.params.provider.Arguments.of("Psc"),
        org.junit.jupiter.params.provider.Arguments.of("QCOM"),
        org.junit.jupiter.params.provider.Arguments.of("Quad Transporter "),
        org.junit.jupiter.params.provider.Arguments.of("Qualcomm Inc"),
        org.junit.jupiter.params.provider.Arguments.of("ROBOT BASE during the mission. "),
        org.junit.jupiter.params.provider.Arguments.of("ROBOT BASE to continue the mission. "),
        org.junit.jupiter.params.provider.Arguments.of("ROV tethered from a boat "),
        org.junit.jupiter.params.provider.Arguments.of("Record observations before and after this physical "),
        org.junit.jupiter.params.provider.Arguments.of("Remotely operated vehicles (ROVs) equipped "),
        org.junit.jupiter.params.provider.Arguments.of("Risiko"),
        org.junit.jupiter.params.provider.Arguments.of("Robot "),
        org.junit.jupiter.params.provider.Arguments.of("Robot Base "),
        org.junit.jupiter.params.provider.Arguments.of("SPACE"),
        org.junit.jupiter.params.provider.Arguments.of("SPACE "),
        org.junit.jupiter.params.provider.Arguments.of("Services Division at extension "),
        org.junit.jupiter.params.provider.Arguments.of("Similar in size to the International Space "),
        org.junit.jupiter.params.provider.Arguments.of("Space Center’s Exploration Planning and "),
        org.junit.jupiter.params.provider.Arguments.of("Spatial Awareness: "),
        org.junit.jupiter.params.provider.Arguments.of("Station (ISS) living module, Aquarius provides "),
        org.junit.jupiter.params.provider.Arguments.of("Status Check: Have you updated your Mission Journal? "),
        org.junit.jupiter.params.provider.Arguments.of("Steady yourself on the doorframe until "),
        org.junit.jupiter.params.provider.Arguments.of("TAB"),
        org.junit.jupiter.params.provider.Arguments.of("TAB "),
        org.junit.jupiter.params.provider.Arguments.of("Telephone"),
        org.junit.jupiter.params.provider.Arguments.of("Test PDFBOX-4823"),
        org.junit.jupiter.params.provider.Arguments.of("Test1"),
        org.junit.jupiter.params.provider.Arguments.of("Test2"),
        org.junit.jupiter.params.provider.Arguments.of("Thank you for maintaining the spirit of the game! "),
        org.junit.jupiter.params.provider.Arguments.of("The NASA Extreme Environment Mission "),
        org.junit.jupiter.params.provider.Arguments.of("The earth is a sphere"),
        org.junit.jupiter.params.provider.Arguments.of("The mission control base on Key Largo supports "),
        org.junit.jupiter.params.provider.Arguments.of("The quick brown fox"),
        org.junit.jupiter.params.provider.Arguments.of("Think Safety! "),
        org.junit.jupiter.params.provider.Arguments.of("This is from a disabled layer. If you see this, that's NOT good!"),
        org.junit.jupiter.params.provider.Arguments.of("This is from an enabled layer. If you see this, that's good."),
        org.junit.jupiter.params.provider.Arguments.of("Through NEEMO, NURP has enabled NASA to "),
        org.junit.jupiter.params.provider.Arguments.of("Time yourself while trying to balance on two feet with your "),
        org.junit.jupiter.params.provider.Arguments.of("To train for medical emergencies in space, onboard "),
        org.junit.jupiter.params.provider.Arguments.of("Transporter "),
        org.junit.jupiter.params.provider.Arguments.of("Transporter, LEGOnaut, etc.) "),
        org.junit.jupiter.params.provider.Arguments.of("Uhrzeit: 13:14"),
        org.junit.jupiter.params.provider.Arguments.of("Ulice"),
        org.junit.jupiter.params.provider.Arguments.of("Undersea Research Center at UNC Wilmington to "),
        org.junit.jupiter.params.provider.Arguments.of("Unicode русский язык Tiếng Việt"),
        org.junit.jupiter.params.provider.Arguments.of("Using your muscles problems are usually corrected after "),
        org.junit.jupiter.params.provider.Arguments.of("What is NEEMO? "),
        org.junit.jupiter.params.provider.Arguments.of("When you are participating in athletics, especially sports "),
        org.junit.jupiter.params.provider.Arguments.of("While practicing simple balance activities, you can also lift "),
        org.junit.jupiter.params.provider.Arguments.of("YOUR MISSION:  Mission: Control! "),
        org.junit.jupiter.params.provider.Arguments.of("You should see a green textline, but no red text line."),
        org.junit.jupiter.params.provider.Arguments.of("You should see this text, but no red text line."),
        org.junit.jupiter.params.provider.Arguments.of("You will perform throwing and catching techniques on one "),
        org.junit.jupiter.params.provider.Arguments.of("ability to manipulate equipment "),
        org.junit.jupiter.params.provider.Arguments.of("activity that "),
        org.junit.jupiter.params.provider.Arguments.of("adult for use. "),
        org.junit.jupiter.params.provider.Arguments.of("affect your balance. "),
        org.junit.jupiter.params.provider.Arguments.of("aliquyam"),
        org.junit.jupiter.params.provider.Arguments.of("aliquyam "),
        org.junit.jupiter.params.provider.Arguments.of("all obstacles. "),
        org.junit.jupiter.params.provider.Arguments.of("along with all attached pieces will be removed "),
        org.junit.jupiter.params.provider.Arguments.of("amet, "),
        org.junit.jupiter.params.provider.Arguments.of("and after returning to Earth, "),
        org.junit.jupiter.params.provider.Arguments.of("and agile. It will "),
        org.junit.jupiter.params.provider.Arguments.of("and balance on one foot. "),
        org.junit.jupiter.params.provider.Arguments.of("and building entrance ways.  Note: Do not attempt to carry "),
        org.junit.jupiter.params.provider.Arguments.of("and from others while "),
        org.junit.jupiter.params.provider.Arguments.of("and funded by NOAA's Undersea Research "),
        org.junit.jupiter.params.provider.Arguments.of("and work on the seafloor for extended "),
        org.junit.jupiter.params.provider.Arguments.of("and work. . "),
        org.junit.jupiter.params.provider.Arguments.of("any questions or comments. "),
        org.junit.jupiter.params.provider.Arguments.of("aquanauts. "),
        org.junit.jupiter.params.provider.Arguments.of("are in your space "),
        org.junit.jupiter.params.provider.Arguments.of("are very important. Even jumping on a trampoline or riding a "),
        org.junit.jupiter.params.provider.Arguments.of("around corners and feeling like they are "),
        org.junit.jupiter.params.provider.Arguments.of("around them is "),
        org.junit.jupiter.params.provider.Arguments.of("as snowy steps. "),
        org.junit.jupiter.params.provider.Arguments.of("asdfASDF1234äöü"),
        org.junit.jupiter.params.provider.Arguments.of("assembly in space. "),
        org.junit.jupiter.params.provider.Arguments.of("astronauts for long-duration space habitation. "),
        org.junit.jupiter.params.provider.Arguments.of("astronauts have practiced telementoring, a "),
        org.junit.jupiter.params.provider.Arguments.of("awareness "),
        org.junit.jupiter.params.provider.Arguments.of("awareness and may lose some "),
        org.junit.jupiter.params.provider.Arguments.of("awareness. "),
        org.junit.jupiter.params.provider.Arguments.of("balance and     Stay at least an arms distance from the wall "),
        org.junit.jupiter.params.provider.Arguments.of("balance if you do slip. "),
        org.junit.jupiter.params.provider.Arguments.of("balance organs in "),
        org.junit.jupiter.params.provider.Arguments.of("balancing on one foot. Raise your "),
        org.junit.jupiter.params.provider.Arguments.of("ball for 60 seconds "),
        org.junit.jupiter.params.provider.Arguments.of("ball to a player across from you. "),
        org.junit.jupiter.params.provider.Arguments.of("be encountered. "),
        org.junit.jupiter.params.provider.Arguments.of("be in the LANDING ZONE. "),
        org.junit.jupiter.params.provider.Arguments.of("be used to drag the robot, corral LEGOnauts, etc.). "),
        org.junit.jupiter.params.provider.Arguments.of("been resolved, report the condition to the Safety & Health "),
        org.junit.jupiter.params.provider.Arguments.of("before, during, "),
        org.junit.jupiter.params.provider.Arguments.of("between parked cars. Be especially careful when stepping to "),
        org.junit.jupiter.params.provider.Arguments.of("bicycle "),
        org.junit.jupiter.params.provider.Arguments.of("both feet on the pavement before you attempt to stand. "),
        org.junit.jupiter.params.provider.Arguments.of("buoyancy.  Water drag notwithstanding, walking Testing the "),
        org.junit.jupiter.params.provider.Arguments.of("can serve as an analog for extra-vehicular "),
        org.junit.jupiter.params.provider.Arguments.of("can spe nd working in the ocean’s depths.  A buoy on the "),
        org.junit.jupiter.params.provider.Arguments.of("cases or purses that may cause you "),
        org.junit.jupiter.params.provider.Arguments.of("center of balance to take hold of "),
        org.junit.jupiter.params.provider.Arguments.of("challenge? "),
        org.junit.jupiter.params.provider.Arguments.of("chances of being  Mission Explorations: "),
        org.junit.jupiter.params.provider.Arguments.of("cleared paths in parking lots. Never walk "),
        org.junit.jupiter.params.provider.Arguments.of("communication networks and science where astronauts live "),
        org.junit.jupiter.params.provider.Arguments.of("compared to your During the first few days of space flight "),
        org.junit.jupiter.params.provider.Arguments.of("conditions exist... "),
        org.junit.jupiter.params.provider.Arguments.of("conduct a variety of training and evaluation "),
        org.junit.jupiter.params.provider.Arguments.of("consetetur "),
        org.junit.jupiter.params.provider.Arguments.of("contain at least 6 players. "),
        org.junit.jupiter.params.provider.Arguments.of("control body movement. These "),
        org.junit.jupiter.params.provider.Arguments.of("control room on space flights. "),
        org.junit.jupiter.params.provider.Arguments.of("corners. Seeing our surroundings and being able to move "),
        org.junit.jupiter.params.provider.Arguments.of("crew members, "),
        org.junit.jupiter.params.provider.Arguments.of("days following a storm. Once parking lots, sidewalks and "),
        org.junit.jupiter.params.provider.Arguments.of("decrease the "),
        org.junit.jupiter.params.provider.Arguments.of("diam "),
        org.junit.jupiter.params.provider.Arguments.of("different layout"),
        org.junit.jupiter.params.provider.Arguments.of("different levels -- down or up "),
        org.junit.jupiter.params.provider.Arguments.of("dolor "),
        org.junit.jupiter.params.provider.Arguments.of("dolore "),
        org.junit.jupiter.params.provider.Arguments.of("due to a fall. Examples: towel, pillow, or cushion. "),
        org.junit.jupiter.params.provider.Arguments.of("during this physical experience in your Mission Journal. "),
        org.junit.jupiter.params.provider.Arguments.of("easily. to relearn how to use information from their eyes, tiny "),
        org.junit.jupiter.params.provider.Arguments.of("eirmod "),
        org.junit.jupiter.params.provider.Arguments.of("electrical power to robot motors (i.e. it can not "),
        org.junit.jupiter.params.provider.Arguments.of("elitr, "),
        org.junit.jupiter.params.provider.Arguments.of("energy can be generated from activating a "),
        org.junit.jupiter.params.provider.Arguments.of("erat, "),
        org.junit.jupiter.params.provider.Arguments.of("et "),
        org.junit.jupiter.params.provider.Arguments.of("expand crew and mission control communication "),
        org.junit.jupiter.params.provider.Arguments.of("experience in your Mission Journal. "),
        org.junit.jupiter.params.provider.Arguments.of("exploration team into action.  Unfortunately, our transporters "),
        org.junit.jupiter.params.provider.Arguments.of("eyes closed. "),
        org.junit.jupiter.params.provider.Arguments.of("feet pointed slightly outward. This will "),
        org.junit.jupiter.params.provider.Arguments.of("field value"),
        org.junit.jupiter.params.provider.Arguments.of("field). "),
        org.junit.jupiter.params.provider.Arguments.of("floor. Try to balance for at least "),
        org.junit.jupiter.params.provider.Arguments.of("foot to "),
        org.junit.jupiter.params.provider.Arguments.of("for accuracy as "),
        org.junit.jupiter.params.provider.Arguments.of("for black ice – particularly in the "),
        org.junit.jupiter.params.provider.Arguments.of("for human habitation on other planets.  During "),
        org.junit.jupiter.params.provider.Arguments.of("from play for the remainder of the mission. "),
        org.junit.jupiter.params.provider.Arguments.of("from side-to-side. Their brain has "),
        org.junit.jupiter.params.provider.Arguments.of("further develop space flight training procedures; "),
        org.junit.jupiter.params.provider.Arguments.of("game. "),
        org.junit.jupiter.params.provider.Arguments.of("get injured in the process. "),
        org.junit.jupiter.params.provider.Arguments.of("grassy slopes can be as dangerous "),
        org.junit.jupiter.params.provider.Arguments.of("habitation.  The facility is supported by a 10- "),
        org.junit.jupiter.params.provider.Arguments.of("hazardous condition has not "),
        org.junit.jupiter.params.provider.Arguments.of("heavy. "),
        org.junit.jupiter.params.provider.Arguments.of("help keep your center of balance under you and provide a "),
        org.junit.jupiter.params.provider.Arguments.of("host live-links with the ISS and the Johnson "),
        org.junit.jupiter.params.provider.Arguments.of("http://www.nurp.noaa.gov "),
        org.junit.jupiter.params.provider.Arguments.of("hurt, or hurting "),
        org.junit.jupiter.params.provider.Arguments.of("ice. "),
        org.junit.jupiter.params.provider.Arguments.of("icy/slippery walks and roadways and makes "),
        org.junit.jupiter.params.provider.Arguments.of("immediate life support systems, posing the "),
        org.junit.jupiter.params.provider.Arguments.of("important so we do not bump into things and get hurt. "),
        org.junit.jupiter.params.provider.Arguments.of("improve balance and spatial awareness. You will also record "),
        org.junit.jupiter.params.provider.Arguments.of("initiative to spread salt on the steps "),
        org.junit.jupiter.params.provider.Arguments.of("invidunt "),
        org.junit.jupiter.params.provider.Arguments.of("ipsum "),
        org.junit.jupiter.params.provider.Arguments.of("keep your balance for 60 seconds "),
        org.junit.jupiter.params.provider.Arguments.of("labore "),
        org.junit.jupiter.params.provider.Arguments.of("life support, and communications to the "),
        org.junit.jupiter.params.provider.Arguments.of("line at the beginning of the mission). "),
        org.junit.jupiter.params.provider.Arguments.of("linebreak"),
        org.junit.jupiter.params.provider.Arguments.of("long journey from Earth.  Now we must put our "),
        org.junit.jupiter.params.provider.Arguments.of("m arine scientists to study coral reefs and coastal ocean "),
        org.junit.jupiter.params.provider.Arguments.of("magna "),
        org.junit.jupiter.params.provider.Arguments.of("manipulating the flight of ROVs in space.   Maneuvering an "),
        org.junit.jupiter.params.provider.Arguments.of("medical procedures.  In the training exercise, a "),
        org.junit.jupiter.params.provider.Arguments.of("meter buoy on the surface that provides power, "),
        org.junit.jupiter.params.provider.Arguments.of("method where physicians on Earth guide non- "),
        org.junit.jupiter.params.provider.Arguments.of("mission. "),
        org.junit.jupiter.params.provider.Arguments.of("missions with 24-hour video, audio and life- "),
        org.junit.jupiter.params.provider.Arguments.of("missions. "),
        org.junit.jupiter.params.provider.Arguments.of("more coordinated     and after physical activities. "),
        org.junit.jupiter.params.provider.Arguments.of("motor. "),
        org.junit.jupiter.params.provider.Arguments.of("multi."),
        org.junit.jupiter.params.provider.Arguments.of("nonumy "),
        org.junit.jupiter.params.provider.Arguments.of("not be able to do some physical "),
        org.junit.jupiter.params.provider.Arguments.of("o perated by the University of North Carolina at Wilmington, "),
        org.junit.jupiter.params.provider.Arguments.of("objectives typical of an outer space mission. "),
        org.junit.jupiter.params.provider.Arguments.of("observations about improvements in balance and spatial "),
        org.junit.jupiter.params.provider.Arguments.of("of water remains and refreezes when the temperature drops. "),
        org.junit.jupiter.params.provider.Arguments.of("offer limited mobility and a slightly negative "),
        org.junit.jupiter.params.provider.Arguments.of("on a pair of highly complex surgical dummies. "),
        org.junit.jupiter.params.provider.Arguments.of("on shoes will increase the risk of slipping. "),
        org.junit.jupiter.params.provider.Arguments.of("one day be employed to find locations suitable "),
        org.junit.jupiter.params.provider.Arguments.of("one foot "),
        org.junit.jupiter.params.provider.Arguments.of("operating ROVs underwater, which simulates "),
        org.junit.jupiter.params.provider.Arguments.of("or backpack while walking on ice are dangerous. "),
        org.junit.jupiter.params.provider.Arguments.of("or she must hop on one foot, "),
        org.junit.jupiter.params.provider.Arguments.of("or when the robot is returned to base but elastic stored "),
        org.junit.jupiter.params.provider.Arguments.of("other foot down. "),
        org.junit.jupiter.params.provider.Arguments.of("p eriods using a special technique called saturation diving, "),
        org.junit.jupiter.params.provider.Arguments.of("page90."),
        org.junit.jupiter.params.provider.Arguments.of("paragraphbreak"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox."),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.page90.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("pdfbox.portrait.single.rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("perform the emergency removal of a gallbladder. "),
        org.junit.jupiter.params.provider.Arguments.of("physicians in space to perform the necessary "),
        org.junit.jupiter.params.provider.Arguments.of("plastic, or smooth surfaced soles "),
        org.junit.jupiter.params.provider.Arguments.of("portrait."),
        org.junit.jupiter.params.provider.Arguments.of("possible, swing your legs around and place "),
        org.junit.jupiter.params.provider.Arguments.of("potential dangers associated with space "),
        org.junit.jupiter.params.provider.Arguments.of("problems associated with lengthy space missions. "),
        org.junit.jupiter.params.provider.Arguments.of("processes. Aquarius is owned by NOAA, "),
        org.junit.jupiter.params.provider.Arguments.of("reading, digging in your pocketbook "),
        org.junit.jupiter.params.provider.Arguments.of("reduce the risk of injury when slippery "),
        org.junit.jupiter.params.provider.Arguments.of("requires an absolute reliance on one’s "),
        org.junit.jupiter.params.provider.Arguments.of("requires both! "),
        org.junit.jupiter.params.provider.Arguments.of("revised 12/16/03 "),
        org.junit.jupiter.params.provider.Arguments.of("robot back in the ROBOT BASE to continue the mission. "),
        org.junit.jupiter.params.provider.Arguments.of("robot is partially inside the ROBOT BASE "),
        org.junit.jupiter.params.provider.Arguments.of("robot. "),
        org.junit.jupiter.params.provider.Arguments.of("robots is 3 LEGO Motorized Simple Machines "),
        org.junit.jupiter.params.provider.Arguments.of("rotation0"),
        org.junit.jupiter.params.provider.Arguments.of("rotation180"),
        org.junit.jupiter.params.provider.Arguments.of("rotation270"),
        org.junit.jupiter.params.provider.Arguments.of("rotation90"),
        org.junit.jupiter.params.provider.Arguments.of("routine. Until then, they have "),
        org.junit.jupiter.params.provider.Arguments.of("sadipscing "),
        org.junit.jupiter.params.provider.Arguments.of("same layout"),
        org.junit.jupiter.params.provider.Arguments.of("scientists from "),
        org.junit.jupiter.params.provider.Arguments.of("sdfASDF1234äöü"),
        org.junit.jupiter.params.provider.Arguments.of("sed "),
        org.junit.jupiter.params.provider.Arguments.of("sense of balance when they return to Earth. Research "),
        org.junit.jupiter.params.provider.Arguments.of("serves as an analog for ROV manipulation in "),
        org.junit.jupiter.params.provider.Arguments.of("several weeks have passed and "),
        org.junit.jupiter.params.provider.Arguments.of("sheparda@uncw.edu "),
        org.junit.jupiter.params.provider.Arguments.of("simulating the interaction between astronaut and habitat, "),
        org.junit.jupiter.params.provider.Arguments.of("single annotation"),
        org.junit.jupiter.params.provider.Arguments.of("sit "),
        org.junit.jupiter.params.provider.Arguments.of("situated on the FKNMS seafloor. "),
        org.junit.jupiter.params.provider.Arguments.of("skateboarding, bowling, diving, and skiing, balance and "),
        org.junit.jupiter.params.provider.Arguments.of("someone else, While standing still, stand on a soft surface "),
        org.junit.jupiter.params.provider.Arguments.of("spatial awareness "),
        org.junit.jupiter.params.provider.Arguments.of("stable base for support. "),
        org.junit.jupiter.params.provider.Arguments.of("steps have been cleared, a thin layer "),
        org.junit.jupiter.params.provider.Arguments.of("steps or from curbs (don't step on curbs); and remember, "),
        org.junit.jupiter.params.provider.Arguments.of("stretched rubber band) when the mission begins "),
        org.junit.jupiter.params.provider.Arguments.of("such as dancing, "),
        org.junit.jupiter.params.provider.Arguments.of("suits while constructing structures underwater "),
        org.junit.jupiter.params.provider.Arguments.of("support  and communications capabilities. "),
        org.junit.jupiter.params.provider.Arguments.of("support systems monitoring. NEEMO missions "),
        org.junit.jupiter.params.provider.Arguments.of("surface provides the Aquarius with power, life "),
        org.junit.jupiter.params.provider.Arguments.of("surgeon in Canada guided Aquarius aquanauts to "),
        org.junit.jupiter.params.provider.Arguments.of("surroundings. astronauts experience a change in spatial "),
        org.junit.jupiter.params.provider.Arguments.of("team to develop a robot that will help transport 30 "),
        org.junit.jupiter.params.provider.Arguments.of("team will be required to immediately place the "),
        org.junit.jupiter.params.provider.Arguments.of("techniques; and evaluate methods that address "),
        org.junit.jupiter.params.provider.Arguments.of("tempor "),
        org.junit.jupiter.params.provider.Arguments.of("tense your muscles -- both of which can "),
        org.junit.jupiter.params.provider.Arguments.of("testMultipleFontFileReuse1"),
        org.junit.jupiter.params.provider.Arguments.of("testMultipleFontFileReuse2"),
        org.junit.jupiter.params.provider.Arguments.of("testMultipleFontFileReuse3"),
        org.junit.jupiter.params.provider.Arguments.of("text"),
        org.junit.jupiter.params.provider.Arguments.of("that leaves LEGO Centauri (i.e. the playing "),
        org.junit.jupiter.params.provider.Arguments.of("the EXPLORATION ZONE. "),
        org.junit.jupiter.params.provider.Arguments.of("the HABITATION ZONE. "),
        org.junit.jupiter.params.provider.Arguments.of("the ROBOT BASE. "),
        org.junit.jupiter.params.provider.Arguments.of("the ability to use your arms for "),
        org.junit.jupiter.params.provider.Arguments.of("the appropriate adjustments. Several things can be done to "),
        org.junit.jupiter.params.provider.Arguments.of("the door, because this may cause a fall. "),
        org.junit.jupiter.params.provider.Arguments.of("the physical isolation, operational complexity, Zvezda, the "),
        org.junit.jupiter.params.provider.Arguments.of("the physiological issues and potential medical "),
        org.junit.jupiter.params.provider.Arguments.of("the plane of the zone. "),
        org.junit.jupiter.params.provider.Arguments.of("the salt bucket if you believe it is "),
        org.junit.jupiter.params.provider.Arguments.of("their robot that is outside of the ROBOT "),
        org.junit.jupiter.params.provider.Arguments.of("to increase the difficulty. "),
        org.junit.jupiter.params.provider.Arguments.of("to lose your balance while you are walking. "),
        org.junit.jupiter.params.provider.Arguments.of("to move quickly and “tumbling” when they move their heads "),
        org.junit.jupiter.params.provider.Arguments.of("together to move balance exercises are added to their fitness "),
        org.junit.jupiter.params.provider.Arguments.of("too heavy.  Have someone else help you so that you don’t "),
        org.junit.jupiter.params.provider.Arguments.of("undersea lab that rests on the Florida Keys "),
        org.junit.jupiter.params.provider.Arguments.of("underwater habitat in the world, typically used by "),
        org.junit.jupiter.params.provider.Arguments.of("underwater in these suits provides an experience while "),
        org.junit.jupiter.params.provider.Arguments.of("ut "),
        org.junit.jupiter.params.provider.Arguments.of("vertically (i.e. the robot can not hang over the "),
        org.junit.jupiter.params.provider.Arguments.of("very similar to walking on the moon. Wearing the "),
        org.junit.jupiter.params.provider.Arguments.of("voluptua."),
        org.junit.jupiter.params.provider.Arguments.of("walking around "),
        org.junit.jupiter.params.provider.Arguments.of("ways to the building, call Plant "),
        org.junit.jupiter.params.provider.Arguments.of("wearing EX-14 system diving suits. "),
        org.junit.jupiter.params.provider.Arguments.of("were damaged in the landing; therefore we need a "),
        org.junit.jupiter.params.provider.Arguments.of("which dramatically increases the time divers "),
        org.junit.jupiter.params.provider.Arguments.of("while throwing the tennis ball against "),
        org.junit.jupiter.params.provider.Arguments.of("will make you "),
        org.junit.jupiter.params.provider.Arguments.of("with US Navy EX-14 hard-hat dive suits, which "),
        org.junit.jupiter.params.provider.Arguments.of("with video cameras and manipulator arms may "),
        org.junit.jupiter.params.provider.Arguments.of("without reaching your hand out to an object or touching your "),
        org.junit.jupiter.params.provider.Arguments.of("work alongside experts from NURP’s National "),
        org.junit.jupiter.params.provider.Arguments.of("world’s only operational underwater "),
        org.junit.jupiter.params.provider.Arguments.of("would improve balance and spatial awareness? "),
        org.junit.jupiter.params.provider.Arguments.of("www.nasa.gov "),
        org.junit.jupiter.params.provider.Arguments.of("xof nworb kciuq ehT"),
        org.junit.jupiter.params.provider.Arguments.of("you have gained your balance. Avoid reaching beyond your "),
        org.junit.jupiter.params.provider.Arguments.of("you practice this activity for improving balance and spatial "),
        org.junit.jupiter.params.provider.Arguments.of("you want it to. activities like fly a plane or drive a car. "),
        org.junit.jupiter.params.provider.Arguments.of("your body the way to be extra careful; which means they may "),
        org.junit.jupiter.params.provider.Arguments.of("~˜"),
        org.junit.jupiter.params.provider.Arguments.of("äöüÄÖÜ"),
        org.junit.jupiter.params.provider.Arguments.of("“Mountain” "),
        org.junit.jupiter.params.provider.Arguments.of("• A LEGOnaut counts if any part of the LEGOnaut is breaking "),
        org.junit.jupiter.params.provider.Arguments.of("• A LEGOnaut in both the EXPLORATION ZONE and "),
        org.junit.jupiter.params.provider.Arguments.of("• A penalty of 10 points will be assessed for each LEGOnaut "),
        org.junit.jupiter.params.provider.Arguments.of("• A penalty of 5 points will be assessed if a team touches "),
        org.junit.jupiter.params.provider.Arguments.of("• A playing piece is NEVER considered part of the robot. "),
        org.junit.jupiter.params.provider.Arguments.of("• A team may touch any playing piece (Lift Transporter, Mass "),
        org.junit.jupiter.params.provider.Arguments.of("• If a controller or wire are used illegally (judges call), the "),
        org.junit.jupiter.params.provider.Arguments.of("• If a playing piece is illegally touched, the playing piece "),
        org.junit.jupiter.params.provider.Arguments.of("• If a robot is touched, the robot must be returned to the "),
        org.junit.jupiter.params.provider.Arguments.of("• The ROBOT BASE is the 12” x 16” boundary extended "),
        org.junit.jupiter.params.provider.Arguments.of("• The black line between the HABITATION ZONE and "),
        org.junit.jupiter.params.provider.Arguments.of("• The black line indicating the ROBOT BASE is NOT part of "),
        org.junit.jupiter.params.provider.Arguments.of("• The controller and wire are NOT considered part of the "),
        org.junit.jupiter.params.provider.Arguments.of("• The controller and wire can ONLY be used to provide "),
        org.junit.jupiter.params.provider.Arguments.of("• The equipment available for a team to build a robot or "),
        org.junit.jupiter.params.provider.Arguments.of("• The following diagram presents the environment which will "),
        org.junit.jupiter.params.provider.Arguments.of("• The following diagram presents where the LEGOnauts will "),
        org.junit.jupiter.params.provider.Arguments.of("• The mountain is considered part of the HABITATION ZONE. "),
        org.junit.jupiter.params.provider.Arguments.of("• The robot shall not have any elastic stored energy (i.e. "),
        org.junit.jupiter.params.provider.Arguments.of("• The team can touch their robot without penalty when the "),
        org.junit.jupiter.params.provider.Arguments.of("• The team has 2 minutes to complete the mission. "),
        org.junit.jupiter.params.provider.Arguments.of("• The team must be ready to execute the mission on "),
        org.junit.jupiter.params.provider.Arguments.of("• The team scores 2 points for transporting a LEGOnaut to "),
        org.junit.jupiter.params.provider.Arguments.of("• The team scores 5 points for transporting a LEGOnaut to "),
        org.junit.jupiter.params.provider.Arguments.of("• The team’s robot/robots must start inside of the ROBOT "),
        org.junit.jupiter.params.provider.Arguments.of("• The team’s score is determined at the end of the 2-minute "),
        org.junit.jupiter.params.provider.Arguments.of("「ABC」"),
        org.junit.jupiter.params.provider.Arguments.of("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン１２３４５６７８")
        );
    }
}