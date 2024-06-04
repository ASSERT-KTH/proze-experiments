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

/**
 *
 * @author Tilman Hausherr
 */
public class TestProzeGen_PDActionURI_setURI_java_lang_String_PDActionURITest_testUTF7URI {
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideProzeArguments")
    public void testUTF7URI(String param0) {
        PDActionURI actionURI = new PDActionURI();
        actionURI.setURI(param0);
        assertEquals("http://pdfbox.apache.org/", actionURI.getURI());
    }

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideProzeArguments() {
        return java.util.stream.Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("http://pdfbox.apache.org/"),
        org.junit.jupiter.params.provider.Arguments.of("http://çµ„åŒ¶æ›¿ç¶Ž.com/")
        );
    }
}