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
 * Test Class for the SAMLAttributeQueryValidator.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.utils.multitenancy.MultitenantUtils.class, org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.class, org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class, org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.w3c.dom.*" })
public class TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLAttributeQueryValidatorTest_testValidate extends org.powermock.modules.testng.PowerMockTestCase {
    @org.mockito.Mock
    org.wso2.carbon.user.core.service.RealmService testRealmService;

    @org.mockito.Mock
    org.wso2.carbon.user.core.UserRealm testUserRealm;

    @org.mockito.Mock
    org.wso2.carbon.user.core.UserStoreManager testuserStoreManager;

    org.wso2.carbon.identity.query.saml.validation.SAMLAttributeQueryValidator testclass = new org.wso2.carbon.identity.query.saml.validation.SAMLAttributeQueryValidator();

    java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();

    @org.testng.annotations.BeforeClass
    public void setUp() {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.initPrivilegedCarbonContext("testDomain", 1, "testuser");
    }

    @org.testng.annotations.AfterClass
    public void tearDown() {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.stopPrivilegedCarbonContext();
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testValidate(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException, org.wso2.carbon.user.api.UserStoreException {
        org.wso2.carbon.identity.query.saml.validation.DummyNameID dumID2 = new org.wso2.carbon.identity.query.saml.validation.DummyNameID();
        org.wso2.carbon.identity.query.saml.validation.DummySubject dumSub = new org.wso2.carbon.identity.query.saml.validation.DummySubject();
        org.wso2.carbon.identity.query.saml.validation.DummySubjectQueryImpl dumSQ2 = new org.wso2.carbon.identity.query.saml.validation.DummySubjectQueryImpl();
        dumID2.setFormat("test");
        dumSub.setNameID(dumID2);
        dumSQ2.setSubject(dumSub);
        org.wso2.carbon.identity.query.saml.validation.DummyIssuer issuer = new org.wso2.carbon.identity.query.saml.validation.DummyIssuer();
        issuer.setValue("test");
        issuer.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        dumSQ2.setIssuer(issuer);
        dumSQ2.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        ssoIdpConfigs.setNameIDFormat("test");
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.utils.multitenancy.MultitenantUtils.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.utils.multitenancy.MultitenantUtils.getTenantAwareUsername(org.mockito.ArgumentMatchers.anyString())).thenReturn("test");
        org.powermock.api.mockito.PowerMockito.when(testRealmService.getTenantUserRealm(org.mockito.ArgumentMatchers.anyInt())).thenReturn(testUserRealm);
        org.powermock.api.mockito.PowerMockito.when(testUserRealm.getUserStoreManager()).thenReturn(testuserStoreManager);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.getRealmservice()).thenReturn(testRealmService);
        org.powermock.api.mockito.PowerMockito.when(testuserStoreManager.isExistingUser(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        testclass.validate(invalidItems, dumSQ2);
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