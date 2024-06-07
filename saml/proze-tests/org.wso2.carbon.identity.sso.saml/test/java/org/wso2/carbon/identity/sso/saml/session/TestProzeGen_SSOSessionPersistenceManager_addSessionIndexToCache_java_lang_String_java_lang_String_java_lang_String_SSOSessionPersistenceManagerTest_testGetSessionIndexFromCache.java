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
package org.wso2.carbon.identity.sso.saml.session;
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.core.util.IdentityTenantUtil.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.w3c.dom.*" })
public class TestProzeGen_SSOSessionPersistenceManager_addSessionIndexToCache_java_lang_String_java_lang_String_java_lang_String_SSOSessionPersistenceManagerTest_testGetSessionIndexFromCache extends org.powermock.modules.testng.PowerMockTestCase {
    private org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager ssoSessionPersistenceManager;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        org.mockito.MockitoAnnotations.initMocks(this);
        ssoSessionPersistenceManager = new org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager();
        org.wso2.carbon.identity.sso.saml.TestUtils.startTenantFlow(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantId(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantDomain(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        // remove the exsisting sessionIndex from cache
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.removeSessionIndexFromCache("sessionId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws java.lang.Exception {
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testGetSessionIndexFromCache(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws java.lang.Exception {
        java.lang.String sessionIndex = "sessionIndex";
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache(param0, param1, param2);
        java.lang.String actualSessionIndex = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionIndexFromCache("sessionId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.testng.Assert.assertEquals(actualSessionIndex, sessionIndex);
    }

    public static void initializeData() throws org.wso2.carbon.identity.base.IdentityException {
        java.lang.String sessionIndex = "sessionIndex";
        java.lang.String subject = "subject";
        java.lang.String issuer = "issuer";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        samlssoServiceProviderDO.setDoSingleLogout(true);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache("sessionId", sessionIndex, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getPersistenceManager().persistSession(sessionIndex, subject, samlssoServiceProviderDO, null, issuer, null, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO1 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO1.setIssuer("issuer1");
        samlssoServiceProviderDO1.setDoSingleLogout(true);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache("sessionId1", "sessionIndex2", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getPersistenceManager().persistSession("sessionIndex2", subject, samlssoServiceProviderDO1, null, "issuer1", null, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO2 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO2.setIssuer("issuer2");
        samlssoServiceProviderDO2.setDoSingleLogout(false);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache("sessionId2", sessionIndex, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getPersistenceManager().persistSession(sessionIndex, subject, samlssoServiceProviderDO2, null, "issuer2", null, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO3 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO3.setIssuer("issuer3");
        samlssoServiceProviderDO3.setDoSingleLogout(true);
        samlssoServiceProviderDO3.setDoFrontChannelLogout(true);
        samlssoServiceProviderDO3.setFrontChannelLogoutBinding(org.wso2.carbon.identity.sso.saml.common.SAMLSSOProviderConstants.HTTP_REDIRECT_BINDING);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache("sessionId3", "sessionIndex3", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getPersistenceManager().persistSession("sessionIndex3", subject, samlssoServiceProviderDO3, null, "issuer3", null, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
    }

    @org.testng.annotations.DataProvider(name = "testRemoveSession1")
    public java.lang.Object[][] data() throws org.wso2.carbon.identity.base.IdentityException {
        return new java.lang.Object[][]{ new java.lang.Object[]{ null, null, null }, new java.lang.Object[]{ "sessionId", null, "sessionIndex" }, new java.lang.Object[]{ "sessionId", "issuer", "sessionIndex" }, new java.lang.Object[]{ "sessionId2", "issuer2", "sessionIndex" }, new java.lang.Object[]{ "sessionId1", "issuer1", null }, new java.lang.Object[]{ "sessionId1", null, null }, new java.lang.Object[]{ "sessionId3", "issuer3", "sessionIndex3" } };
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"39011ee9-4c05-4092-ac18-475ff558fb44-v2", "45968110-dea2-49c2-a403-0aa402caa033", "carbon.super"},
        new java.lang.Object[]{"52a46bc3-9225-433d-9090-4b41a6ccbf7e-v2", "614f4355-74cf-4e47-a05c-323b20812f1e", "carbon.super"},
        new java.lang.Object[]{"6f83baa2-2259-406e-ae70-9a0a57ccb37f-v2", "d5c336dc-0853-4010-855d-38d37b386832", "carbon.super"},
        new java.lang.Object[]{"89da4f70-8f1e-45f7-a8f7-26b1100f7720-v2", "dddcd246-6f7d-46ea-a6cc-82df03a5e6f0", "carbon.super"},
        new java.lang.Object[]{"a0e95eb5-eeec-4f94-b4b3-e5a59268e20e-v2", "86f3f0d4-60a5-4319-9bd8-2cc6c3a50eda", "carbon.super"},
        new java.lang.Object[]{"samlssoToeknIdTwo", "theSessionIndexTwo", "carbon.super"},
        new java.lang.Object[]{"samlssoTokenId", "sessionIndex", "carbon.super"},
        new java.lang.Object[]{"samlssoTokenId", "theSessionIndex", "carbon.super"},
        new java.lang.Object[]{"sessionId", "sessionIndex", "carbon.super"},
        new java.lang.Object[]{"sessionId1", "sessionIndex2", "carbon.super"},
        new java.lang.Object[]{"sessionId2", "sessionIndex", "carbon.super"},
        new java.lang.Object[]{"sessionId3", "sessionIndex3", "carbon.super"},
        new java.lang.Object[]{"sessionIndex", "sessionIndex", "carbon.super"},
        new java.lang.Object[]{"tokenid", "sessionIndex", "carbon.super"}
        };
    }
}