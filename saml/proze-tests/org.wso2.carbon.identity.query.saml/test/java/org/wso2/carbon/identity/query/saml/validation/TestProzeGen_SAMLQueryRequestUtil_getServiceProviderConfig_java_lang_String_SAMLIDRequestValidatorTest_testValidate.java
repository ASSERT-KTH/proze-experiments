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
package org.wso2.carbon.identity.query.saml.validation;
/**
 * Test Class for the SAMLIDRequestValidator.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class, org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "java.net.*", "org.opensaml.*", "javax.xml.*", "org.xml.*", "org.w3c.dom.*" })
public class TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate extends org.powermock.modules.testng.PowerMockTestCase {
    org.wso2.carbon.identity.query.saml.validation.SAMLIDRequestValidator testclass = new org.wso2.carbon.identity.query.saml.validation.SAMLIDRequestValidator();

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.initPrivilegedCarbonContext("testDomain", 1, "testuser");
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.stopPrivilegedCarbonContext();
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testValidate(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer issuer5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest request5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest();
        request5.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        issuer5.setValue("test");
        issuer5.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        request5.setIssuer(issuer5);
        java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
        request5.additem();
        org.testng.AssertJUnit.assertTrue(testclass.validate(invalidItems, request5));
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(false);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
    }

    class DummyRequest extends org.opensaml.saml.saml2.core.impl.ManageNameIDRequestImpl implements org.opensaml.saml.saml2.core.AssertionIDRequest {
        java.util.List<org.opensaml.saml.saml2.core.AssertionIDRef> testlist = new java.util.ArrayList<>();

        protected DummyRequest() {
            super("testNSU", "testELN", "testNSP");
        }

        @java.lang.Override
        public java.util.List<org.opensaml.saml.saml2.core.AssertionIDRef> getAssertionIDRefs() {
            return testlist;
        }

        public void additem() {
            org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyAssertion item = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyAssertion();
            testlist.add(((org.opensaml.saml.saml2.core.AssertionIDRef) (item)));
        }
    }

    class DummyIssuer extends org.opensaml.saml.saml2.core.impl.IssuerImpl {
        protected DummyIssuer() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    class DummyAssertion extends org.opensaml.saml.saml2.core.impl.AssertionIDRefImpl {
        protected DummyAssertion() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testValidate_1(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer issuer5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest request5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest();
        request5.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        issuer5.setValue("test");
        issuer5.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        request5.setIssuer(issuer5);
        java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
        request5.additem();
        // org.testng.AssertJUnit.assertTrue(testclass.validate(invalidItems, request5));
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(false);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testValidate_2(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer issuer5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest request5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest();
        request5.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        issuer5.setValue("test");
        issuer5.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        request5.setIssuer(issuer5);
        java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        // org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
        request5.additem();
        org.testng.AssertJUnit.assertTrue(testclass.validate(invalidItems, request5));
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(false);
        // org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testValidate_3(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer issuer5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest request5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLIDRequestValidatorTest_testValidate.DummyRequest();
        request5.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        issuer5.setValue("test");
        issuer5.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        request5.setIssuer(issuer5);
        java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
        request5.additem();
        // org.testng.AssertJUnit.assertTrue(testclass.validate(invalidItems, request5));
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(false);
        org.testng.AssertJUnit.assertFalse(testclass.validate(invalidItems, request5));
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{""},
        new java.lang.Object[]{"failtest"},
        new java.lang.Object[]{"test"}
        };
    }
}