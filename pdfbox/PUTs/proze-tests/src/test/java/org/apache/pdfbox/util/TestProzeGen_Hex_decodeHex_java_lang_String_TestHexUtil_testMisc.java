/* Copyright 2016 The Apache Software Foundation.

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
package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals; /**
 *
 * @author Michael Doswald
 */
// public class TestHexUtil extends TestCase
public class TestProzeGen_Hex_decodeHex_java_lang_String_TestHexUtil_testMisc {
    /**
     * Test getBytes() and getString() and decodeHex()
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(param0));
        }
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        assertEquals(dstString.length(), byteSrcArray.length * 2);
        assertArrayEquals(dstString.getBytes(Charsets.US_ASCII), byteDstArray);
        assertArrayEquals(byteSrcArray, Hex.decodeHex(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_1(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(param0));
        }
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
        // assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        // assertEquals(dstString.length(), byteSrcArray.length * 2);
        // assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
        // assertArrayEquals(byteSrcArray, org.apache.pdfbox.util.Hex.decodeHex(dstString));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_2(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
//        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        // assertEquals(dstString.length(), byteSrcArray.length * 2);
        // assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
        // assertArrayEquals(byteSrcArray, org.apache.pdfbox.util.Hex.decodeHex(dstString));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_3(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
        // assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        assertEquals(dstString.length(), byteSrcArray.length * 2);
        // assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
        // assertArrayEquals(byteSrcArray, org.apache.pdfbox.util.Hex.decodeHex(dstString));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_4(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(param0));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
        // assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        // assertEquals(dstString.length(), byteSrcArray.length * 2);
//        assertArrayEquals(dstString.getBytes(Charsets.US_ASCII), byteDstArray);
        // assertArrayEquals(byteSrcArray, org.apache.pdfbox.util.Hex.decodeHex(dstString));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_5(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
        // assertEquals(dstString.length(), byteSrcArray.length * 2);
        // assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
//        assertArrayEquals(byteSrcArray, Hex.decodeHex(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_6(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
//        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
         assertEquals(dstString.length(), byteSrcArray.length * 2);
        // assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
//        assertArrayEquals(byteSrcArray, Hex.decodeHex(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_7(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
//        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
//        assertEquals(dstString.length(), byteSrcArray.length * 2);
         assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
//        assertArrayEquals(byteSrcArray, Hex.decodeHex(param0));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testMisc_8(String param0) throws java.io.IOException {
        byte[] byteSrcArray = new byte[256];
        for (int i = 0; i < 256; ++i) {
            byteSrcArray[i] = ((byte) (i));
            byte[] bytes = Hex.getBytes(((byte) (i)));
//            assertEquals(2, bytes.length);
            String s2 = String.format(java.util.Locale.US, "%02X", i);
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
            s2 = Hex.getString(((byte) (i)));
//            assertArrayEquals(s2.getBytes(Charsets.US_ASCII), bytes);
//            assertArrayEquals(new byte[]{ ((byte) (i)) }, Hex.decodeHex(s2));
        };
        byte[] byteDstArray = Hex.getBytes(byteSrcArray);
//        assertEquals(byteDstArray.length, byteSrcArray.length * 2);
        String dstString = Hex.getString(byteSrcArray);
//        assertEquals(dstString.length(), byteSrcArray.length * 2);
//        assertArrayEquals(dstString.getBytes(org.apache.pdfbox.util.Charsets.US_ASCII), byteDstArray);
        assertArrayEquals(byteSrcArray, Hex.decodeHex(param0));
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("00"),
        org.junit.jupiter.params.provider.Arguments.of("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F404142434445464748494A4B4C4D4E4F505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF0F1F2F3F4F5F6F7F8F9FAFBFCFDFEFF"),
        org.junit.jupiter.params.provider.Arguments.of("01"),
        org.junit.jupiter.params.provider.Arguments.of("02"),
        org.junit.jupiter.params.provider.Arguments.of("03"),
        org.junit.jupiter.params.provider.Arguments.of("04"),
        org.junit.jupiter.params.provider.Arguments.of("05"),
        org.junit.jupiter.params.provider.Arguments.of("06"),
        org.junit.jupiter.params.provider.Arguments.of("07"),
        org.junit.jupiter.params.provider.Arguments.of("08"),
        org.junit.jupiter.params.provider.Arguments.of("09"),
        org.junit.jupiter.params.provider.Arguments.of("0A"),
        org.junit.jupiter.params.provider.Arguments.of("0B"),
        org.junit.jupiter.params.provider.Arguments.of("0C"),
        org.junit.jupiter.params.provider.Arguments.of("0D"),
        org.junit.jupiter.params.provider.Arguments.of("0E"),
        org.junit.jupiter.params.provider.Arguments.of("0F"),
        org.junit.jupiter.params.provider.Arguments.of("10"),
        org.junit.jupiter.params.provider.Arguments.of("11"),
        org.junit.jupiter.params.provider.Arguments.of("12"),
        org.junit.jupiter.params.provider.Arguments.of("13"),
        org.junit.jupiter.params.provider.Arguments.of("14"),
        org.junit.jupiter.params.provider.Arguments.of("15"),
        org.junit.jupiter.params.provider.Arguments.of("16"),
        org.junit.jupiter.params.provider.Arguments.of("17"),
        org.junit.jupiter.params.provider.Arguments.of("18"),
        org.junit.jupiter.params.provider.Arguments.of("19"),
        org.junit.jupiter.params.provider.Arguments.of("1A"),
        org.junit.jupiter.params.provider.Arguments.of("1B"),
        org.junit.jupiter.params.provider.Arguments.of("1C"),
        org.junit.jupiter.params.provider.Arguments.of("1D"),
        org.junit.jupiter.params.provider.Arguments.of("1E"),
        org.junit.jupiter.params.provider.Arguments.of("1F"),
        org.junit.jupiter.params.provider.Arguments.of("20"),
        org.junit.jupiter.params.provider.Arguments.of("21"),
        org.junit.jupiter.params.provider.Arguments.of("22"),
        org.junit.jupiter.params.provider.Arguments.of("23"),
        org.junit.jupiter.params.provider.Arguments.of("24"),
        org.junit.jupiter.params.provider.Arguments.of("25"),
        org.junit.jupiter.params.provider.Arguments.of("26"),
        org.junit.jupiter.params.provider.Arguments.of("27"),
        org.junit.jupiter.params.provider.Arguments.of("28"),
        org.junit.jupiter.params.provider.Arguments.of("29"),
        org.junit.jupiter.params.provider.Arguments.of("2A"),
        org.junit.jupiter.params.provider.Arguments.of("2B"),
        org.junit.jupiter.params.provider.Arguments.of("2C"),
        org.junit.jupiter.params.provider.Arguments.of("2D"),
        org.junit.jupiter.params.provider.Arguments.of("2E"),
        org.junit.jupiter.params.provider.Arguments.of("2F"),
        org.junit.jupiter.params.provider.Arguments.of("30"),
        org.junit.jupiter.params.provider.Arguments.of("31"),
        org.junit.jupiter.params.provider.Arguments.of("32"),
        org.junit.jupiter.params.provider.Arguments.of("33"),
        org.junit.jupiter.params.provider.Arguments.of("34"),
        org.junit.jupiter.params.provider.Arguments.of("35"),
        org.junit.jupiter.params.provider.Arguments.of("36"),
        org.junit.jupiter.params.provider.Arguments.of("37"),
        org.junit.jupiter.params.provider.Arguments.of("38"),
        org.junit.jupiter.params.provider.Arguments.of("39"),
        org.junit.jupiter.params.provider.Arguments.of("3A"),
        org.junit.jupiter.params.provider.Arguments.of("3B"),
        org.junit.jupiter.params.provider.Arguments.of("3C"),
        org.junit.jupiter.params.provider.Arguments.of("3D"),
        org.junit.jupiter.params.provider.Arguments.of("3E"),
        org.junit.jupiter.params.provider.Arguments.of("3F"),
        org.junit.jupiter.params.provider.Arguments.of("40"),
        org.junit.jupiter.params.provider.Arguments.of("41"),
        org.junit.jupiter.params.provider.Arguments.of("42"),
        org.junit.jupiter.params.provider.Arguments.of("43"),
        org.junit.jupiter.params.provider.Arguments.of("44"),
        org.junit.jupiter.params.provider.Arguments.of("45"),
        org.junit.jupiter.params.provider.Arguments.of("46"),
        org.junit.jupiter.params.provider.Arguments.of("47"),
        org.junit.jupiter.params.provider.Arguments.of("48"),
        org.junit.jupiter.params.provider.Arguments.of("49"),
        org.junit.jupiter.params.provider.Arguments.of("4A"),
        org.junit.jupiter.params.provider.Arguments.of("4B"),
        org.junit.jupiter.params.provider.Arguments.of("4C"),
        org.junit.jupiter.params.provider.Arguments.of("4D"),
        org.junit.jupiter.params.provider.Arguments.of("4E"),
        org.junit.jupiter.params.provider.Arguments.of("4F"),
        org.junit.jupiter.params.provider.Arguments.of("50"),
        org.junit.jupiter.params.provider.Arguments.of("51"),
        org.junit.jupiter.params.provider.Arguments.of("52"),
        org.junit.jupiter.params.provider.Arguments.of("53"),
        org.junit.jupiter.params.provider.Arguments.of("54"),
        org.junit.jupiter.params.provider.Arguments.of("55"),
        org.junit.jupiter.params.provider.Arguments.of("56"),
        org.junit.jupiter.params.provider.Arguments.of("57"),
        org.junit.jupiter.params.provider.Arguments.of("58"),
        org.junit.jupiter.params.provider.Arguments.of("59"),
        org.junit.jupiter.params.provider.Arguments.of("5A"),
        org.junit.jupiter.params.provider.Arguments.of("5B"),
        org.junit.jupiter.params.provider.Arguments.of("5C"),
        org.junit.jupiter.params.provider.Arguments.of("5D"),
        org.junit.jupiter.params.provider.Arguments.of("5E"),
        org.junit.jupiter.params.provider.Arguments.of("5F"),
        org.junit.jupiter.params.provider.Arguments.of("60"),
        org.junit.jupiter.params.provider.Arguments.of("61"),
        org.junit.jupiter.params.provider.Arguments.of("62"),
        org.junit.jupiter.params.provider.Arguments.of("63"),
        org.junit.jupiter.params.provider.Arguments.of("64"),
        org.junit.jupiter.params.provider.Arguments.of("65"),
        org.junit.jupiter.params.provider.Arguments.of("66"),
        org.junit.jupiter.params.provider.Arguments.of("67"),
        org.junit.jupiter.params.provider.Arguments.of("68"),
        org.junit.jupiter.params.provider.Arguments.of("69"),
        org.junit.jupiter.params.provider.Arguments.of("6A"),
        org.junit.jupiter.params.provider.Arguments.of("6B"),
        org.junit.jupiter.params.provider.Arguments.of("6C"),
        org.junit.jupiter.params.provider.Arguments.of("6D"),
        org.junit.jupiter.params.provider.Arguments.of("6E"),
        org.junit.jupiter.params.provider.Arguments.of("6F"),
        org.junit.jupiter.params.provider.Arguments.of("70"),
        org.junit.jupiter.params.provider.Arguments.of("71"),
        org.junit.jupiter.params.provider.Arguments.of("72"),
        org.junit.jupiter.params.provider.Arguments.of("73"),
        org.junit.jupiter.params.provider.Arguments.of("74"),
        org.junit.jupiter.params.provider.Arguments.of("75"),
        org.junit.jupiter.params.provider.Arguments.of("76"),
        org.junit.jupiter.params.provider.Arguments.of("77"),
        org.junit.jupiter.params.provider.Arguments.of("78"),
        org.junit.jupiter.params.provider.Arguments.of("79"),
        org.junit.jupiter.params.provider.Arguments.of("7A"),
        org.junit.jupiter.params.provider.Arguments.of("7B"),
        org.junit.jupiter.params.provider.Arguments.of("7C"),
        org.junit.jupiter.params.provider.Arguments.of("7D"),
        org.junit.jupiter.params.provider.Arguments.of("7E"),
        org.junit.jupiter.params.provider.Arguments.of("7F"),
        org.junit.jupiter.params.provider.Arguments.of("80"),
        org.junit.jupiter.params.provider.Arguments.of("81"),
        org.junit.jupiter.params.provider.Arguments.of("82"),
        org.junit.jupiter.params.provider.Arguments.of("83"),
        org.junit.jupiter.params.provider.Arguments.of("84"),
        org.junit.jupiter.params.provider.Arguments.of("85"),
        org.junit.jupiter.params.provider.Arguments.of("86"),
        org.junit.jupiter.params.provider.Arguments.of("87"),
        org.junit.jupiter.params.provider.Arguments.of("88"),
        org.junit.jupiter.params.provider.Arguments.of("89"),
        org.junit.jupiter.params.provider.Arguments.of("8A"),
        org.junit.jupiter.params.provider.Arguments.of("8B"),
        org.junit.jupiter.params.provider.Arguments.of("8C"),
        org.junit.jupiter.params.provider.Arguments.of("8D"),
        org.junit.jupiter.params.provider.Arguments.of("8E"),
        org.junit.jupiter.params.provider.Arguments.of("8F"),
        org.junit.jupiter.params.provider.Arguments.of("90"),
        org.junit.jupiter.params.provider.Arguments.of("91"),
        org.junit.jupiter.params.provider.Arguments.of("92"),
        org.junit.jupiter.params.provider.Arguments.of("93"),
        org.junit.jupiter.params.provider.Arguments.of("94"),
        org.junit.jupiter.params.provider.Arguments.of("95"),
        org.junit.jupiter.params.provider.Arguments.of("96"),
        org.junit.jupiter.params.provider.Arguments.of("97"),
        org.junit.jupiter.params.provider.Arguments.of("98"),
        org.junit.jupiter.params.provider.Arguments.of("99"),
        org.junit.jupiter.params.provider.Arguments.of("9A"),
        org.junit.jupiter.params.provider.Arguments.of("9B"),
        org.junit.jupiter.params.provider.Arguments.of("9C"),
        org.junit.jupiter.params.provider.Arguments.of("9D"),
        org.junit.jupiter.params.provider.Arguments.of("9E"),
        org.junit.jupiter.params.provider.Arguments.of("9F"),
        org.junit.jupiter.params.provider.Arguments.of("A0"),
        org.junit.jupiter.params.provider.Arguments.of("A1"),
        org.junit.jupiter.params.provider.Arguments.of("A2"),
        org.junit.jupiter.params.provider.Arguments.of("A3"),
        org.junit.jupiter.params.provider.Arguments.of("A4"),
        org.junit.jupiter.params.provider.Arguments.of("A5"),
        org.junit.jupiter.params.provider.Arguments.of("A6"),
        org.junit.jupiter.params.provider.Arguments.of("A7"),
        org.junit.jupiter.params.provider.Arguments.of("A8"),
        org.junit.jupiter.params.provider.Arguments.of("A9"),
        org.junit.jupiter.params.provider.Arguments.of("AA"),
        org.junit.jupiter.params.provider.Arguments.of("AB"),
        org.junit.jupiter.params.provider.Arguments.of("AC"),
        org.junit.jupiter.params.provider.Arguments.of("AD"),
        org.junit.jupiter.params.provider.Arguments.of("AE"),
        org.junit.jupiter.params.provider.Arguments.of("AF"),
        org.junit.jupiter.params.provider.Arguments.of("B0"),
        org.junit.jupiter.params.provider.Arguments.of("B1"),
        org.junit.jupiter.params.provider.Arguments.of("B2"),
        org.junit.jupiter.params.provider.Arguments.of("B3"),
        org.junit.jupiter.params.provider.Arguments.of("B4"),
        org.junit.jupiter.params.provider.Arguments.of("B5"),
        org.junit.jupiter.params.provider.Arguments.of("B6"),
        org.junit.jupiter.params.provider.Arguments.of("B7"),
        org.junit.jupiter.params.provider.Arguments.of("B8"),
        org.junit.jupiter.params.provider.Arguments.of("B9"),
        org.junit.jupiter.params.provider.Arguments.of("BA"),
        org.junit.jupiter.params.provider.Arguments.of("BB"),
        org.junit.jupiter.params.provider.Arguments.of("BC"),
        org.junit.jupiter.params.provider.Arguments.of("BD"),
        org.junit.jupiter.params.provider.Arguments.of("BE"),
        org.junit.jupiter.params.provider.Arguments.of("BF"),
        org.junit.jupiter.params.provider.Arguments.of("C0"),
        org.junit.jupiter.params.provider.Arguments.of("C1"),
        org.junit.jupiter.params.provider.Arguments.of("C2"),
        org.junit.jupiter.params.provider.Arguments.of("C3"),
        org.junit.jupiter.params.provider.Arguments.of("C4"),
        org.junit.jupiter.params.provider.Arguments.of("C5"),
        org.junit.jupiter.params.provider.Arguments.of("C6"),
        org.junit.jupiter.params.provider.Arguments.of("C7"),
        org.junit.jupiter.params.provider.Arguments.of("C8"),
        org.junit.jupiter.params.provider.Arguments.of("C9"),
        org.junit.jupiter.params.provider.Arguments.of("CA"),
        org.junit.jupiter.params.provider.Arguments.of("CB"),
        org.junit.jupiter.params.provider.Arguments.of("CC"),
        org.junit.jupiter.params.provider.Arguments.of("CD"),
        org.junit.jupiter.params.provider.Arguments.of("CE"),
        org.junit.jupiter.params.provider.Arguments.of("CF"),
        org.junit.jupiter.params.provider.Arguments.of("D0"),
        org.junit.jupiter.params.provider.Arguments.of("D1"),
        org.junit.jupiter.params.provider.Arguments.of("D2"),
        org.junit.jupiter.params.provider.Arguments.of("D3"),
        org.junit.jupiter.params.provider.Arguments.of("D4"),
        org.junit.jupiter.params.provider.Arguments.of("D5"),
        org.junit.jupiter.params.provider.Arguments.of("D6"),
        org.junit.jupiter.params.provider.Arguments.of("D7"),
        org.junit.jupiter.params.provider.Arguments.of("D8"),
        org.junit.jupiter.params.provider.Arguments.of("D9"),
        org.junit.jupiter.params.provider.Arguments.of("DA"),
        org.junit.jupiter.params.provider.Arguments.of("DB"),
        org.junit.jupiter.params.provider.Arguments.of("DC"),
        org.junit.jupiter.params.provider.Arguments.of("DD"),
        org.junit.jupiter.params.provider.Arguments.of("DE"),
        org.junit.jupiter.params.provider.Arguments.of("DF"),
        org.junit.jupiter.params.provider.Arguments.of("E0"),
        org.junit.jupiter.params.provider.Arguments.of("E1"),
        org.junit.jupiter.params.provider.Arguments.of("E2"),
        org.junit.jupiter.params.provider.Arguments.of("E3"),
        org.junit.jupiter.params.provider.Arguments.of("E4"),
        org.junit.jupiter.params.provider.Arguments.of("E5"),
        org.junit.jupiter.params.provider.Arguments.of("E6"),
        org.junit.jupiter.params.provider.Arguments.of("E7"),
        org.junit.jupiter.params.provider.Arguments.of("E8"),
        org.junit.jupiter.params.provider.Arguments.of("E9"),
        org.junit.jupiter.params.provider.Arguments.of("EA"),
        org.junit.jupiter.params.provider.Arguments.of("EB"),
        org.junit.jupiter.params.provider.Arguments.of("EC"),
        org.junit.jupiter.params.provider.Arguments.of("ED"),
        org.junit.jupiter.params.provider.Arguments.of("EE"),
        org.junit.jupiter.params.provider.Arguments.of("EF"),
        org.junit.jupiter.params.provider.Arguments.of("F0"),
        org.junit.jupiter.params.provider.Arguments.of("F1"),
        org.junit.jupiter.params.provider.Arguments.of("F2"),
        org.junit.jupiter.params.provider.Arguments.of("F3"),
        org.junit.jupiter.params.provider.Arguments.of("F4"),
        org.junit.jupiter.params.provider.Arguments.of("F5"),
        org.junit.jupiter.params.provider.Arguments.of("F6"),
        org.junit.jupiter.params.provider.Arguments.of("F7"),
        org.junit.jupiter.params.provider.Arguments.of("F8"),
        org.junit.jupiter.params.provider.Arguments.of("F9"),
        org.junit.jupiter.params.provider.Arguments.of("FA"),
        org.junit.jupiter.params.provider.Arguments.of("FB"),
        org.junit.jupiter.params.provider.Arguments.of("FC"),
        org.junit.jupiter.params.provider.Arguments.of("FD"),
        org.junit.jupiter.params.provider.Arguments.of("FE"),
        org.junit.jupiter.params.provider.Arguments.of("FF"),
                org.junit.jupiter.params.provider.Arguments.of("308006092a864886f70d010702a0803080020101310b300906052b0e03021a0500308006092a864886f70d0107010000a0820edb308204a130820389a00302010202043e1cbd28300d06092a864886f70d01010505003069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341301e170d3033303130383233333732335a170d3233303130393030303732335a3069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f7420434130820122300d06092a864886f70d01010105000382010f003082010a0282010100cc4f5484f7a7a2e733537f3f9c12886b2c9947677e0f1eb9ad1488f9c310d81df0f0d59f690a2f5935b0cc6ca94c9c15a09fce20bfa0cf54e2e02066453f3986387e9cc48e0722c624f60112b035df55ea6990b0db85371ee24e07b242a16a1369a066ea809111592a9b08795a20442dc9bd73388b3c2fe0431b5db30bf0af351a29feefa692dd814c9d3d598ead313c407e9b913606fce25c8dd18d26d55c45cfaf653fb1aad26296f4a838eaba6042f4f41c4a3515cef84e22560f9518c5f8969f9ffbb0b77825e9806bbdd60af0c674949df30f50db9a77ce4b7083238da0ca7820445c3c5464f1eaa230199fea4c064d06784b5e92df22d2c967b37ad2010203010001a382014f3082014b301106096086480186f842010104040302000730818e0603551d1f048186308183308180a07ea07ca47a3078310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341310d300b0603550403130443524c31302b0603551d1004243022800f32303033303130383233333732335a810f32303233303130393030303732335a300b0603551d0f040403020106301f0603551d2304183016801482b7384a93aa9b10ef80bbd954e2f10ffb809cde301d0603551d0e0416041482b7384a93aa9b10ef80bbd954e2f10ffb809cde300c0603551d13040530030101ff301d06092a864886f67d0741000410300e1b0856362e303a342e3003020490300d06092a864886f70d0101050500038201010032da9f4375c1fa6fc96fdbab1d36373ebc611936b7023c1d2359986c9eee4d85e754c8201fa7d4bbe2bf00777d246b702f5cc13a7649b5d3e023842a716a22f3c127299815f63590e4044cc38dbc9f611ce7fd248cd144438c16ba9b4da5d4352fbc11cebdf751378d9f90e414f1183fbee9591235f93392f39ee0d56b9a719b994bc871c3e1b16109c4e5fa91f0423a377d34f972e8cdaa621c21e9d5f48210e37b05b62d68560b7e7e922c6f4d72820ced5674b29db9ab2d2b1d105fdb2775708ffd1dd7e202a079e51ce5ffaf6440512d9e9b47db42a57c1fc2a648b0d7be92694da4f62957c5781118dc8751ca13b2629d4f2b32bd31a5c1fa52ab0588c8308204cb308203b3a00302010202043e1cbdb5300d06092a864886f70d01010505003069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341301e170d3034303131373030303333395a170d3135303131353038303030305a3045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f626530820122300d06092a864886f70d01010105000382010f003082010a0282010100a7e577e064785ae73985bcafd2f55b28130e54dd49face62f592fd9e987b9fe5f87ac16ce1ea4025c1712782a73ee407659d28c87514e1387bd2659880ac1deac12dd5a47a653efcf0dbebdce1f04d1c2e80dfc6e905ea854f5e3e9649385d486ec7f5a5c5cd1afa4b75c60aebe097e4300d32e22d85be38d17a0d7c2ddd3410b4a45e263389664e3a659d01bcc4ad2b205a781e83299b26888a3cf6ab28d77543648347db0d4abd7834ca00e2ce836d6ef8003c5ca6c27b08352d6495f42572f9f4c744499bd6d84172b7e463590202f733b2eaae57748cc7c851a5afb8708bca2bf2b51bb3ab5749ec4f2b9a27630c493f1bedbba5fd777cd67bbd1eccf8890203010001a382019d3082019930120603551d130101ff040830060101ff02010130500603551d2004493047304506092a864886f72f0102013038303606082b06010505070201162a68747470733a2f2f7777772e61646f62652e636f6d2f6d6973632f706b692f6364735f63702e68746d6c30140603551d25040d300b06092a864886f72f0101053081b20603551d1f0481aa3081a73022a020a01e861c687474703a2f2f63726c2e61646f62652e636f6d2f6364732e63726c308180a07ea07ca47a3078310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341310d300b0603550403130443524c31300b0603551d0f040403020106301f0603551d2304183016801482b7384a93aa9b10ef80bbd954e2f10ffb809cde301d0603551d0e04160414ab8059c365836d1d7d13bd19c3ec1a8f0d476aa3301906092a864886f67d074100040c300a1b0456362e3003020490300d06092a864886f70d010105050003820101003f39592ea2008eb15e11612cd2e0b6f58c898645ce13d99fdd849a146b084c5f869758f4a5a8d38f21f8477e50af77e5a16daadc77cdcd3799f74267af50e1544443eb310c809a42b49a95ba4d2c8b1b972478214bf2a270a7f86172493f1f5ea6e211175b220519f39e717dd2cbe63893170297348c69d89f79d07e4e246928529c369869e6110c929cb225a197a4b9cdfc12ec683c8437b272484c40a2969e51b5090af0952162b0a09dba8a1dc11b5681fb7c931d778b228adec6da966eaf9d573ee67b9f4b8bc8f93c0c5e857adcda98692ae869f0569349cbe77cc65cf132f80ebd421cc456224a9f65a0aade60b7efa330c34899b44e6c8aa07e017556308205633082044ba00302010202020362300d06092a864886f70d01010505003045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f6265301e170d3038303132333137333832305a170d3039303230353137333832305a3081893121301f06092a864886f70d0109011612706b69737570706f72744067706f2e676f76310b30090603550406130255533131302f060355040a1328556e697465642053746174657320476f7665726e6d656e74205072696e74696e67204f6666696365312430220603550403131b5375706572696e74656e64656e74206f6620446f63756d656e747330820122300d06092a864886f70d01010105000382010f003082010a0282010100b7e0b5ddfa0be181b52c8225ec8a65b82ec27c142c5197a9cd6ef63773ddf107d79cf2493db87b7a77fed6aba3d2fc4907f452abfc5b38effb9527c9fc4135f27b4ae1505073e1dd1cdb87acfe51a851664423057135cb50942c33d7220f4529eb21e40b75fe741c18f9cd897002bbfc83739129146877c9a52cd0b111a658ceb38775c0c94f98235c06d85f79b6b3add232efeae988ff57b20be0e4bc46689e8f8a18d020d1bf1975a02e03c82c1d76dc67e8b4f0cb1ee3c0c452f4e3ca0baa9d4529688e2cb3a15d2bb67dc0bbf22fb1e74a1e523420c2b0c3a50997fb3ee1f6b3ac30c022843aba78f83d2315f513d12692fce6f8a6fdc86b9e914725e6fd0203010001a382021630820212300e0603551d0f0101ff0404030205e03081e50603551d200101ff0481da3081d73081d406092a864886f72f0102013081c630819006082b060105050702023081831a81805468697320636572746966696361746520686173206265656e2069737375656420696e206163636f7264616e6365207769746820746865204163726f6261742043726564656e7469616c7320435053206c6f636174656420617420687474703a2f2f7777772e67656f74727573742e636f6d2f7265736f75726365732f637073303106082b060105050702011625687474703a2f2f7777772e67656f74727573742e636f6d2f7265736f75726365732f637073303a0603551d1f04333031302fa02da02b8629687474703a2f2f63726c2e67656f74727573742e636f6d2f63726c732f61646f62656361312e63726c301f0603551d23041830168014ab8059c365836d1d7d13bd19c3ec1a8f0d476aa3304406082b0601050507010104383036303406082b060105050730018628687474703a2f2f61646f62652d6f6373702e67656f74727573742e636f6d2f726573706f6e64657230140603551d25040d300b06092a864886f72f010105303c060a2a864886f72f01010901042e302c0201018627687474703a2f2f61646f62652d74696d657374616d702e67656f74727573742e636f6d2f7473613013060a2a864886f72f0101090204053003020101300c0603551d1304053003020100300d06092a864886f70d0101050500038201010009fca169c6200cc2cf85d865a49d20c0574add1be5dcd51d28ae0af1a04413bb447fa3cacc4e9e80bf953c92fa6bcba4b7e50381e0908c260a86ac85f70581ae5d589c59710107367bdcf38130193184fbe15bf17febea10615aa7efa5589693a68a6b23783b35c66d2e269cb61b946dc913759d5377b3f9cc5a5041258ec7ea201c678fe8bae9afab3fbf0f9b9b2948444be1a07edd365c60f3d0d69077a4f02cfad40e068311cb74663320076efa3aa9f0b145a6c20c980cec9295e6689b73dd3a60544618b8e4f6d3b976b2baebaaa0cf213494a49cbff9d1f2d1f8ab6f1381f46536050d28bddb6550e5d72d74221f70cec1f2c58c82a5fbcda0b11f5d203182182530821821020101304b3045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f626502020362300906052b0e03021a0500a0820717301806092a864886f70d010903310b06092a864886f70d010701301c06092a864886f70d010905310f170d3038313231343132343234385a302306092a864886f70d01090431160414dbd8830cdc3c1d4348cd570edfce745a7076c54b308206b606092a864886f72f010108318206a7308206a3a0820238308202343082023030820118020101300d06092a864886f70d01010505003069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341170d3038303932343137353030305a170d3039303932343030303030305a304a302302043e1cbdaa170d3034303131373031303930355a300c300a0603551d1504030a0104302302043e1cbda8170d3034303131373031333932395a300c300a0603551d1504030a0104a02f302d300a0603551d140403020112301f0603551d2304183016801482b7384a93aa9b10ef80bbd954e2f10ffb809cde300d06092a864886f70d01010505000382010100c19720f7c5a62781fcc9164db49d50695d261806da53d0930129767422b0d5231122f8ff27492ad4ecb2094ed7893a485e4a48e996e6959b3d296124b69540e69bd99d174286e0f6a83917efc428240f9f429b1ff3320b586135c0dd8d84052f46f1ddc7367581bae3df079c6b00e69136a26263abdbb5b5159279927720734bf07c1012f4d67116fd37e801b7dae376e20aa66f31078d1acef9824adb889d1d54e2dc30a442abcd02e66cb5096926f90a732ab49cb0405b1a549bfbd4c9e047e015d647b6831fd958bd1b871907f239eb17199bb1dc39ec38000aa6ba9889547cd78191423cb7358a6e844f4c67e6702e5095b17ef5901a9079cf3694fa11cea18204633082045f3082045b0a0100a08204543082045006092b0601050507300101048204413082043d3081b5a2160414bef04a7291f5dd978877cfb9bf3597dd90041011180f32303038313231333137353435315a30653063303b300906052b0e03021a0500041446f806e65891b8c18ce8d3e95780ff4d1f06f41a0414f77d34909e23a905b1c14a4cf8c6b89d957d1bb0020203628000180f32303038313231333137343331315aa011180f32303038313231343137343331315aa1233021301f06092b06010505073001020412041095bd43ba2f894858b625e384d09d3965300d06092a864886f70d0101050500038181004705e5e58d53d465d4d2b07b0ab3fcff5b7f93edc9ed4b3f8b48d407d6b24a78cfe5493eed0280d108cd64ae08d79fd5b6b25c6eb4668bc376a40515f70e6d1b1569c03c6799939ed299983175b74ed02ff825230198e5ccb05f4e7f32b5c6a2d662c2fd96426e0afae374f12627e3f87e1c79fb79538b37d3ea0822ce0102fca08202ee308202ea308202e6308201cea003020102020202a8300d06092a864886f70d01010505003045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f6265301e170d3037303431333138303830345a170d3132303431313138303830345a3050310b300906035504061302555331153013060355040a0c0c47656f547275737420496e63312a302806035504030c2147656f5472757374204f43535020526573706f6e64657220666f722041646f626530819f300d06092a864886f70d010101050003818d0030818902818100e209cd621b70ed4e907955d93839c6847323f8e819d03077f77ac493a6b6abd92ad76f480367b4df22814df25f411f5a58a736423f7476c4aa3e3bd30c714642c6a09b6150ba19c0ddf6f551684fcde108766e9bc43b2743c9d6a8aab19d667310b65b769dc8f5b04b8b322aa1b668bf3b7ad0b34c8219ffba7befba1a5e552b0203010001a3593057301f0603551d23041830168014ab8059c365836d1d7d13bd19c3ec1a8f0d476aa3300e0603551d0f0101ff04040302078030130603551d25040c300a06082b06010505070309300f06092b060105050730010504020500300d06092a864886f70d010105050003820101004d93423d5c6322f7bbaee09a95b7f43bdc7bcbcb172c7a49bc612de0c0539a013e168cd2d3a9d1a5fbc9ce3371839b5944e1b46af2b8438030e5c23b493fafdd18140770be63b2f59e33277e2d656e9469201d77d72bd2505ef2418e9efbd25fd5e5014bbcd4c64c3aedf440a5f7c314bb05ea23443f478eb37c06973e67c8f62346ad8937cd03fbb8a751efc8e3e36ad4c395020222afd1b3a5cc8b96f1d3a806c9c84886b6f199d86b95e9571b563bb6e0658a9b45bbbcdc1a449aeb174e4ccc146bea30d9d81610e4df75fcde9af2a7c868670235fa348bea753af8e1d3715b9c45b73c0e290846953c46ba8e0f1912388e4f3ffc5c63e67b961136797d8a300d06092a864886f70d0101010500048201008c4a87c56a957779c9bad79b6af4a2864f0e55be460f77a8775a7fff909f6175babc38490e1bec09b1871c7b216a2f34c1c04908f7f150bb96b317e7ce1f193448f7dd8aa6cdaaab60d04d8b1bc5bf57b80c1ece7b3e2f420aed8a0c572da0dd48b50cd0764e9798a4576e68a8188baaa5a65ac4ba5cb61dc09f6bbf3e7e9b1e1220c55f15427bd40e9091518c688256bc7dbb45d61982db2b2f45e3816c8857158635eba280a8b9ee19fc810f70582862ece8d7644da6829326bf5b74a763e1d2e98e7b82e3576e3d7462522d10b618579f8a91baaf38632db778a371d0f32151da08223887c366efd449ecf4e6fb6e98f43e650b43c5e54dbdb9a532c3d15aa1820f9430820f90060b2a864886f70d010910020e31820f7f30820f7b06092a864886f70d010702a0820f6c30820f68020103310b300906052b0e03021a050030820103060b2a864886f70d0109100104a081f30481f03081ed020101060229023021300906052b0e03021a05000414614285c170372c0fa76c12a6c97a129018956300020302ea68180f32303038313231343132343231355a300302013c0101ff021004613effb49f32a01be0aa6f7d5557cca08190a4818d30818a310b3009060355040613025553311630140603550408130d4d6173736163687573657474733110300e060355040713074e65656468616d31153013060355040a130c47656f547275737420496e6331133011060355040b130a50726f64756374696f6e312530230603550403131c61646f62652d74696d657374616d702e67656f74727573742e636f6da0820cc93082035130820239a0030201020202008f300d06092a864886f70d01010505003045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f6265301e170d3035303131303031323931305a170d3135303131353038303030305a30818a310b3009060355040613025553311630140603550408130d4d6173736163687573657474733110300e060355040713074e65656468616d31153013060355040a130c47656f547275737420496e6331133011060355040b130a50726f64756374696f6e312530230603550403131c61646f62652d74696d657374616d702e67656f74727573742e636f6d30819f300d06092a864886f70d010101050003818d0030818902818100d16f1268b4b14f590bae10384ab4e31a05425ea46c48bd6c5e6a131bab50d59aa9e4f3cfa3c3fe657cf2023f3419d681eb7132d200533b32bcf7a72c9029028ca94ca27a6cee1bfefb11250d7c135251f0053ddb47b83314f08b3c001567164eb72fec1d96fbc32252a4134f3e55328245d8e6b81565b4ca50e9070b150ce6010203010001a38188308185303a0603551d1f04333031302fa02da02b8629687474703a2f2f63726c2e67656f74727573742e636f6d2f63726c732f61646f62656361312e63726c301f0603551d23041830168014ab8059c365836d1d7d13bd19c3ec1a8f0d476aa3300e0603551d0f0101ff0404030206c030160603551d250101ff040c300a06082b06010505070308300d06092a864886f70d010105050003820101009a7c978ddb57f85efd35fd0a8204dde980b63100fdb34f487974ddf133f7ac19a2cdf33eedfde272081e0866a435f3d198850c2e86b454ce4ab77ed3d97d13ab3056bac7db2b1ec79d7e2fd6dfc6f0d249953e124a1487bfef1b8e3538954a02996da811c0b9bd7c0f47925f8c2ca88acd7a9e981c3b4e59053f8b2c35f27818a313aa969b02c37c4a4bc882f35519b2538204ee3be6ae06f7197c0352f777c905c64511db3c28779e3f610466eecf2b7b1a796a9c489edf0cc8c8c1b6113ff0bd35f9e0115728d7bb9432ef663fcc5ef77757b80c4d2556d2402ccca6a8e7a2dfad54e0a75557dd4050630990a9aa0053015ece287e8c4be35ba718268fc4ac308204a130820389a00302010202043e1cbd28300d06092a864886f70d01010505003069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341301e170d3033303130383233333732335a170d3233303130393030303732335a3069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f7420434130820122300d06092a864886f70d01010105000382010f003082010a0282010100cc4f5484f7a7a2e733537f3f9c12886b2c9947677e0f1eb9ad1488f9c310d81df0f0d59f690a2f5935b0cc6ca94c9c15a09fce20bfa0cf54e2e02066453f3986387e9cc48e0722c624f60112b035df55ea6990b0db85371ee24e07b242a16a1369a066ea809111592a9b08795a20442dc9bd73388b3c2fe0431b5db30bf0af351a29feefa692dd814c9d3d598ead313c407e9b913606fce25c8dd18d26d55c45cfaf653fb1aad26296f4a838eaba6042f4f41c4a3515cef84e22560f9518c5f8969f9ffbb0b77825e9806bbdd60af0c674949df30f50db9a77ce4b7083238da0ca7820445c3c5464f1eaa230199fea4c064d06784b5e92df22d2c967b37ad2010203010001a382014f3082014b301106096086480186f842010104040302000730818e0603551d1f048186308183308180a07ea07ca47a3078310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341310d300b0603550403130443524c31302b0603551d1004243022800f32303033303130383233333732335a810f32303233303130393030303732335a300b0603551d0f040403020106301f0603551d2304183016801482b7384a93aa9b10ef80bbd954e2f10ffb809cde301d0603551d0e0416041482b7384a93aa9b10ef80bbd954e2f10ffb809cde300c0603551d13040530030101ff301d06092a864886f67d0741000410300e1b0856362e303a342e3003020490300d06092a864886f70d0101050500038201010032da9f4375c1fa6fc96fdbab1d36373ebc611936b7023c1d2359986c9eee4d85e754c8201fa7d4bbe2bf00777d246b702f5cc13a7649b5d3e023842a716a22f3c127299815f63590e4044cc38dbc9f611ce7fd248cd144438c16ba9b4da5d4352fbc11cebdf751378d9f90e414f1183fbee9591235f93392f39ee0d56b9a719b994bc871c3e1b16109c4e5fa91f0423a377d34f972e8cdaa621c21e9d5f48210e37b05b62d68560b7e7e922c6f4d72820ced5674b29db9ab2d2b1d105fdb2775708ffd1dd7e202a079e51ce5ffaf6440512d9e9b47db42a57c1fc2a648b0d7be92694da4f62957c5781118dc8751ca13b2629d4f2b32bd31a5c1fa52ab0588c8308204cb308203b3a00302010202043e1cbdb5300d06092a864886f70d01010505003069310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341301e170d3034303131373030303333395a170d3135303131353038303030305a3045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f626530820122300d06092a864886f70d01010105000382010f003082010a0282010100a7e577e064785ae73985bcafd2f55b28130e54dd49face62f592fd9e987b9fe5f87ac16ce1ea4025c1712782a73ee407659d28c87514e1387bd2659880ac1deac12dd5a47a653efcf0dbebdce1f04d1c2e80dfc6e905ea854f5e3e9649385d486ec7f5a5c5cd1afa4b75c60aebe097e4300d32e22d85be38d17a0d7c2ddd3410b4a45e263389664e3a659d01bcc4ad2b205a781e83299b26888a3cf6ab28d77543648347db0d4abd7834ca00e2ce836d6ef8003c5ca6c27b08352d6495f42572f9f4c744499bd6d84172b7e463590202f733b2eaae57748cc7c851a5afb8708bca2bf2b51bb3ab5749ec4f2b9a27630c493f1bedbba5fd777cd67bbd1eccf8890203010001a382019d3082019930120603551d130101ff040830060101ff02010130500603551d2004493047304506092a864886f72f0102013038303606082b06010505070201162a68747470733a2f2f7777772e61646f62652e636f6d2f6d6973632f706b692f6364735f63702e68746d6c30140603551d25040d300b06092a864886f72f0101053081b20603551d1f0481aa3081a73022a020a01e861c687474703a2f2f63726c2e61646f62652e636f6d2f6364732e63726c308180a07ea07ca47a3078310b300906035504061302555331233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311d301b060355040b131441646f6265205472757374205365727669636573311630140603550403130d41646f626520526f6f74204341310d300b0603550403130443524c31300b0603551d0f040403020106301f0603551d2304183016801482b7384a93aa9b10ef80bbd954e2f10ffb809cde301d0603551d0e04160414ab8059c365836d1d7d13bd19c3ec1a8f0d476aa3301906092a864886f67d074100040c300a1b0456362e3003020490300d06092a864886f70d010105050003820101003f39592ea2008eb15e11612cd2e0b6f58c898645ce13d99fdd849a146b084c5f869758f4a5a8d38f21f8477e50af77e5a16daadc77cdcd3799f74267af50e1544443eb310c809a42b49a95ba4d2c8b1b972478214bf2a270a7f86172493f1f5ea6e211175b220519f39e717dd2cbe63893170297348c69d89f79d07e4e246928529c369869e6110c929cb225a197a4b9cdfc12ec683c8437b272484c40a2969e51b5090af0952162b0a09dba8a1dc11b5681fb7c931d778b228adec6da966eaf9d573ee67b9f4b8bc8f93c0c5e857adcda98692ae869f0569349cbe77cc65cf132f80ebd421cc456224a9f65a0aade60b7efa330c34899b44e6c8aa07e017556318201803082017c020101304b3045310b300906035504061302555331163014060355040a130d47656f547275737420496e632e311e301c0603550403131547656f547275737420434120666f722041646f62650202008f300906052b0e03021a0500a0818c301a06092a864886f70d010903310d060b2a864886f70d0109100104301c06092a864886f70d010905310f170d3038313231343132343231355a302306092a864886f70d01090431160414b3a065f2bc93eda0a354f9df4bad44381e6d9e4d302b060b2a864886f70d010910020c311c301a301830160414d5d1f87994cd860c5d892001adab7acec3ddb61d300d06092a864886f70d0101010500048180b3adfd55b774589125eee5efaea10811f9b1502c0008066733ffd5beeb47a2a44f344bffcfaafce06c1ebb2dc22623f788ebc84267a4cfe985ba07443f77a134ce1df14a54102e6063926b29f2ec7524749431b0332eab86c4fc70519bcb4d993326778e62884fc2fc438845b3af9dc2a589ea3dfbd37d38ae3f78f7f18d665300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
        );
    }
}