/* Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

WSO2 Inc. licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except
in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */
package org.wso2.carbon.identity.query.saml;
/**
 * Test Class for the QueryResponseBuilder.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class, org.wso2.carbon.identity.query.saml.QueryResponseBuilder.class })
public class TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess extends org.powermock.modules.testng.PowerMockTestCase {
    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testBuildforSuccess(java.lang.String param0) throws java.lang.Exception {
        org.wso2.carbon.identity.query.saml.TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess.DummyAssertion dummyAssertion = new org.wso2.carbon.identity.query.saml.TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess.DummyAssertion();
        java.util.List<org.opensaml.saml.saml2.core.Assertion> assertions = new java.util.ArrayList<>();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.opensaml.saml.saml2.core.Response response = new org.wso2.carbon.identity.query.saml.TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess.DummyResponse();
        assertions.add(dummyAssertion);
        org.wso2.carbon.identity.query.saml.TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess.DummyIssuer issuer = new org.wso2.carbon.identity.query.saml.TestProzeGen_OpenSAML3Util_getIssuer_java_lang_String_QueryResponseBuilderTest_testBuildforSuccess.DummyIssuer();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.getIssuer(param0)).thenReturn(issuer);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.setSignature(org.mockito.ArgumentMatchers.any(org.opensaml.saml.saml2.core.Response.class), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.any(org.wso2.carbon.identity.query.saml.SignKeyDataHolder.class))).thenReturn(response);
        org.wso2.carbon.identity.query.saml.SignKeyDataHolder testSign = org.mockito.Mockito.mock(org.wso2.carbon.identity.query.saml.SignKeyDataHolder.class);
        org.powermock.api.mockito.PowerMockito.whenNew(org.wso2.carbon.identity.query.saml.SignKeyDataHolder.class).withAnyArguments().thenReturn(testSign);
        org.testng.Assert.assertTrue(org.wso2.carbon.identity.query.saml.QueryResponseBuilder.build(assertions, ssoIdpConfigs, "test").getAssertions() != null);
    }

    @org.testng.annotations.DataProvider(name = "provideValidationType")
    public java.lang.Object[][] createValidationType() {
        java.lang.String VAL_MESSAGE_BODY = "Validation Message Body";
        java.lang.String INTERNAL_SERVER_ERROR = "Internal Server Error";
        java.lang.String VAL_MESSAGE_TYPE = "Validation Message Type";
        java.lang.String VAL_VERSION = "Validating the Version";
        java.lang.String VAL_ISSUER = "Checking for Issuer";
        java.lang.String VAL_SIGNATURE = "Validating Signature";
        java.lang.String NO_ASSERTIONS = "No Assertions Matched";
        java.lang.String VAL_ASSERTION_ID = "Invalid Assertion ID";
        java.lang.String VAL_SUBJECT = "Invalid Subject";
        java.lang.String VAL_ACTIONS = "No Actions";
        java.lang.String VAL_RESOURCE = "No Resource";
        java.lang.String VAL_AUTHN_QUERY = "No sessionIndex or AuthnContextClassRefs";
        java.lang.String STRING_TO_OMELEMENT = "String convert to OMElement";
        java.lang.String NULL_OMELEMENT = "OMElement is null";
        java.lang.String VAL_VALIDATION_ERROR = "Validation error";
        java.lang.String VAL_PROFILE_ENABLED = "Checking Assertion Query/Request profile enabled";
        java.lang.String SUCCESS_CODE = "urn:oasis:names:tc:SAML:2.0:status:Success";
        java.lang.String REQUESTOR_ERROR = "urn:oasis:names:tc:SAML:2.0:status:Requester";
        java.lang.String IDENTITY_PROVIDER_ERROR = "urn:oasis:names:tc:SAML:2.0:status:Responder";
        java.lang.String VERSION_MISMATCH = "urn:oasis:names:tc:SAML:2.0:status:VersionMismatch";
        java.lang.String AUTHN_FAILURE = "urn:oasis:names:tc:SAML:2.0:status:AuthnFailed";
        java.lang.String NO_PASSIVE = "urn:oasis:names:tc:SAML:2.0:status:NoPassive";
        java.lang.String UNKNOWN_PRINCIPAL = "urn:oasis:names:tc:SAML:2.0:status:UnknownPrincipal";
        java.lang.String NO_AUTHN_CONTEXT = "urn:oasis:names:tc:SAML:2.0:status:NoAuthnContext";
        return new java.lang.Object[][]{ new java.lang.Object[]{ VAL_VERSION, VERSION_MISMATCH }, new java.lang.Object[]{ VAL_ISSUER, UNKNOWN_PRINCIPAL }, new java.lang.Object[]{ VAL_SIGNATURE, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_MESSAGE_TYPE, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_MESSAGE_BODY, REQUESTOR_ERROR }, new java.lang.Object[]{ NO_ASSERTIONS, NO_AUTHN_CONTEXT }, new java.lang.Object[]{ VAL_ASSERTION_ID, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_SUBJECT, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_ACTIONS, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_RESOURCE, REQUESTOR_ERROR }, new java.lang.Object[]{ VAL_AUTHN_QUERY, REQUESTOR_ERROR }, new java.lang.Object[]{ STRING_TO_OMELEMENT, IDENTITY_PROVIDER_ERROR }, new java.lang.Object[]{ NULL_OMELEMENT, IDENTITY_PROVIDER_ERROR }, new java.lang.Object[]{ VAL_VALIDATION_ERROR, REQUESTOR_ERROR }, new java.lang.Object[]{ INTERNAL_SERVER_ERROR, IDENTITY_PROVIDER_ERROR }, new java.lang.Object[]{ VAL_PROFILE_ENABLED, IDENTITY_PROVIDER_ERROR } };
    }

    class DummyIssuer extends org.opensaml.saml.saml2.core.impl.IssuerImpl {
        protected DummyIssuer() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    class DummyAssertion extends org.opensaml.saml.saml2.core.impl.AssertionImpl {
        protected DummyAssertion() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    class DummyResponse extends org.opensaml.saml.saml2.core.impl.ResponseImpl {
        protected DummyResponse() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{""},
        new java.lang.Object[]{"carbon.super"},
        new java.lang.Object[]{"test"}
        };
    }
}