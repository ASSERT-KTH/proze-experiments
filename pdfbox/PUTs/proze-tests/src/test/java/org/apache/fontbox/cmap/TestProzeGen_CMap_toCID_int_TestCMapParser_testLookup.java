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
package org.apache.fontbox.cmap;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This will test the CMapParser implementation.
 */
// public class TestCMapParser extends TestCase
public class TestProzeGen_CMap_toCID_int_TestCMapParser_testLookup {
    /**
     * Check whether the parser and the resulting mapping is working correct.
     *
     * @throws IOException
     * 		If something went wrong
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        assertEquals( "A", cMap.toUnicode(CMap.toInt(bytes1, bytes1.length)),
                "bytes 00 01 from bfrange <0001> <0005> <0041>");
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        assertEquals( str2, cMap.toUnicode(CMap.toInt(bytes2, bytes2.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes3 = new byte[]{ 1, 32 };
        assertEquals( "P", cMap.toUnicode(CMap.toInt(bytes3, bytes3.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes4 = new byte[]{ 1, 33 };
        assertEquals( "R", cMap.toUnicode(CMap.toInt(bytes4, bytes4.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        assertEquals( str5, cMap.toUnicode(CMap.toInt(bytes5, bytes5.length)),
                "bytes 00 0A from bfchar <000A> <002A>");
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        assertEquals(str6, cMap.toUnicode(CMap.toInt(bytes6, bytes6.length)),
                "bytes 01 0A from bfchar <010A> <002B>");
        int cid1 = 65;
        assertEquals(65, cMap.toCID(param0), "CID 65 from cidrange <0000> <00ff> 0 ");
        int cid2 = 280;
        int strCID2 = 0x118;
        assertEquals(strCID2, cMap.toCID(param0), "CID 280 from cidrange <0100> <01ff> 256");
        int cid3 = 520;
        int strCID3 = 0x208;
        assertEquals(strCID3, cMap.toCID(param0), "CID 520 from cidchar <0208> 520");
        int cid4 = 300;
        int strCID4 = 0x12c;
        assertEquals(strCID4, cMap.toCID(param0), "CID 300 from cidrange <0300> <0300> 300");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_1(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        assertEquals( "A", cMap.toUnicode(CMap.toInt(bytes1, bytes1.length)), "bytes 00 01 from bfrange <0001> <0005> <0041>");
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_2(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        assertEquals( str2, cMap.toUnicode(CMap.toInt(bytes2, bytes2.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_3(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        assertEquals( "P", cMap.toUnicode(CMap.toInt(bytes3, bytes3.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_4(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        assertEquals( "R", cMap.toUnicode(CMap.toInt(bytes4, bytes4.length)),
                "bytes 01 00 from bfrange <0100> <0109> <0030>");
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_5(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        assertEquals( str5, cMap.toUnicode(CMap.toInt(bytes5, bytes5.length)),
                "bytes 00 0A from bfchar <000A> <002A>");
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_6(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        assertEquals(str6, cMap.toUnicode(CMap.toInt(bytes6, bytes6.length)),
                "bytes 01 0A from bfchar <010A> <002B>");
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_7(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        assertEquals(65, cMap.toCID(param0),
                "CID 65 from cidrange <0000> <00ff> 0 ");
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_8(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        assertEquals(strCID2, cMap.toCID(param0), "CID 280 from cidrange <0100> <01ff> 256");
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_9(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        assertEquals(strCID3, cMap.toCID(param0), "CID 520 from cidchar <0208> 520");
        int cid4 = 300;
        int strCID4 = 0x12c;
        // assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testLookup_10(int param0) throws IOException {
        CMap cMap = new CMapParser().parse(new java.io.File("src/test/resources/cmap", "CMapTest"));
        byte[] bytes1 = new byte[]{ 0, 1 };
        // assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes1, bytes1.length)));
        byte[] bytes2 = new byte[]{ 1, 00 };
        String str2 = "0";
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes2, bytes2.length)));
        byte[] bytes3 = new byte[]{ 1, 32 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes3, bytes3.length)));
        byte[] bytes4 = new byte[]{ 1, 33 };
        // assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes4, bytes4.length)));
        byte[] bytes5 = new byte[]{ 0, 10 };
        String str5 = "*";
        // assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes5, bytes5.length)));
        byte[] bytes6 = new byte[]{ 1, 10 };
        String str6 = "+";
        // assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(org.apache.fontbox.cmap.CMap.toInt(bytes6, bytes6.length)));
        int cid1 = 65;
        // assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));
        int cid2 = 280;
        int strCID2 = 0x118;
        // assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));
        int cid3 = 520;
        int strCID3 = 0x208;
        // assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));
        int cid4 = 300;
        int strCID4 = 0x12c;
        assertEquals(strCID4, cMap.toCID(param0), "CID 300 from cidrange <0300> <0300> 300");
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(100),
        org.junit.jupiter.params.provider.Arguments.of(104),
        org.junit.jupiter.params.provider.Arguments.of(120),
        org.junit.jupiter.params.provider.Arguments.of(12345),
        org.junit.jupiter.params.provider.Arguments.of(17),
        org.junit.jupiter.params.provider.Arguments.of(18),
        org.junit.jupiter.params.provider.Arguments.of(258),
        org.junit.jupiter.params.provider.Arguments.of(271),
        org.junit.jupiter.params.provider.Arguments.of(272),
        org.junit.jupiter.params.provider.Arguments.of(28),
        org.junit.jupiter.params.provider.Arguments.of(280),
        org.junit.jupiter.params.provider.Arguments.of(282),
        org.junit.jupiter.params.provider.Arguments.of(286),
        org.junit.jupiter.params.provider.Arguments.of(296),
        org.junit.jupiter.params.provider.Arguments.of(3),
        org.junit.jupiter.params.provider.Arguments.of(300),
        org.junit.jupiter.params.provider.Arguments.of(336),
        org.junit.jupiter.params.provider.Arguments.of(346),
        org.junit.jupiter.params.provider.Arguments.of(349),
        org.junit.jupiter.params.provider.Arguments.of(367),
        org.junit.jupiter.params.provider.Arguments.of(373),
        org.junit.jupiter.params.provider.Arguments.of(374),
        org.junit.jupiter.params.provider.Arguments.of(38),
        org.junit.jupiter.params.provider.Arguments.of(381),
        org.junit.jupiter.params.provider.Arguments.of(393),
        org.junit.jupiter.params.provider.Arguments.of(396),
        org.junit.jupiter.params.provider.Arguments.of(4),
        org.junit.jupiter.params.provider.Arguments.of(400),
        org.junit.jupiter.params.provider.Arguments.of(410),
        org.junit.jupiter.params.provider.Arguments.of(437),
        org.junit.jupiter.params.provider.Arguments.of(44),
        org.junit.jupiter.params.provider.Arguments.of(448),
        org.junit.jupiter.params.provider.Arguments.of(449),
        org.junit.jupiter.params.provider.Arguments.of(455),
        org.junit.jupiter.params.provider.Arguments.of(460),
        org.junit.jupiter.params.provider.Arguments.of(47),
        org.junit.jupiter.params.provider.Arguments.of(514),
        org.junit.jupiter.params.provider.Arguments.of(520),
        org.junit.jupiter.params.provider.Arguments.of(62),
        org.junit.jupiter.params.provider.Arguments.of(65),
        org.junit.jupiter.params.provider.Arguments.of(65535),
        org.junit.jupiter.params.provider.Arguments.of(68),
        org.junit.jupiter.params.provider.Arguments.of(854),
        org.junit.jupiter.params.provider.Arguments.of(856),
        org.junit.jupiter.params.provider.Arguments.of(859),
        org.junit.jupiter.params.provider.Arguments.of(862),
        org.junit.jupiter.params.provider.Arguments.of(863),
        org.junit.jupiter.params.provider.Arguments.of(884),
        org.junit.jupiter.params.provider.Arguments.of(90),
        org.junit.jupiter.params.provider.Arguments.of(94)
        );
    }
}