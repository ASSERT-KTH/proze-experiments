/* Copyright 2017 The Apache Software Foundation.

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
package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDActionURI_setURI_java_lang_String_PDActionURITest_testUTF8URI {
    /**
     * PDFBOX-3913: Check that URIs encoded in UTF-8 are also supported.
     * PDFBOX-3946: Check that there is no NPE if URI missing.
     */
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testUTF8URI(String param0) {
        PDActionURI actionURI = new PDActionURI();
        assertNull(actionURI.getURI());
        actionURI.setURI(param0);
        assertEquals("http://経営承継.com/", actionURI.getURI());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testUTF8URI_1(String param0) {
        PDActionURI actionURI = new PDActionURI();
        assertNull(actionURI.getURI());
        actionURI.setURI(param0);
        // assertEquals("http://経営承継.com/", actionURI.getURI());
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testUTF8URI_2(String param0) {
        PDActionURI actionURI = new PDActionURI();
        // assertNull(actionURI.getURI());
        actionURI.setURI(param0);
        assertEquals("http://経営承継.com/", actionURI.getURI());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("http://pdfbox.apache.org/"),
        org.junit.jupiter.params.provider.Arguments.of("http://çµ„åŒ¶æ›¿ç¶Ž.com/")
        );
    }
}