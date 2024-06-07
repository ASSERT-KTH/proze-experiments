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
public class TestProzeGen_SessionInfoData_getSubject_java_lang_String_SSOSessionPersistenceManagerTest_testPersistSession extends org.powermock.modules.testng.PowerMockTestCase {
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
    public void testPersistSession(java.lang.String param0) throws java.lang.Exception {
        java.lang.String issuer = "testUser";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("samlTokenId", new org.wso2.carbon.identity.sso.saml.session.SessionInfoData(), org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        ssoSessionPersistenceManager.persistSession("samlTokenId", "subject", samlssoServiceProviderDO, "rpSessionId", issuer, org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData = ssoSessionPersistenceManager.getSessionInfoDataFromCache("samlTokenId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.testng.Assert.assertEquals(sessionInfoData.getSubject(param0), "subject");
        org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().isEmpty());
        org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer), samlssoServiceProviderDO);
        org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer).getAssertionConsumerUrl(), org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL);
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

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testPersistSession_1(java.lang.String param0) throws java.lang.Exception {
        java.lang.String issuer = "testUser";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("samlTokenId", new org.wso2.carbon.identity.sso.saml.session.SessionInfoData(), org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        ssoSessionPersistenceManager.persistSession("samlTokenId", "subject", samlssoServiceProviderDO, "rpSessionId", issuer, org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData = ssoSessionPersistenceManager.getSessionInfoDataFromCache("samlTokenId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.testng.Assert.assertEquals(sessionInfoData.getSubject(param0), "subject");
        // org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().isEmpty());
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer), samlssoServiceProviderDO);
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer).getAssertionConsumerUrl(), org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testPersistSession_2(java.lang.String param0) throws java.lang.Exception {
        java.lang.String issuer = "testUser";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("samlTokenId", new org.wso2.carbon.identity.sso.saml.session.SessionInfoData(), org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        ssoSessionPersistenceManager.persistSession("samlTokenId", "subject", samlssoServiceProviderDO, "rpSessionId", issuer, org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData = ssoSessionPersistenceManager.getSessionInfoDataFromCache("samlTokenId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        // org.testng.Assert.assertEquals(sessionInfoData.getSubject(issuer), "subject");
        org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().isEmpty());
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer), samlssoServiceProviderDO);
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer).getAssertionConsumerUrl(), org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testPersistSession_3(java.lang.String param0) throws java.lang.Exception {
        java.lang.String issuer = "testUser";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("samlTokenId", new org.wso2.carbon.identity.sso.saml.session.SessionInfoData(), org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        ssoSessionPersistenceManager.persistSession("samlTokenId", "subject", samlssoServiceProviderDO, "rpSessionId", issuer, org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData = ssoSessionPersistenceManager.getSessionInfoDataFromCache("samlTokenId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        // org.testng.Assert.assertEquals(sessionInfoData.getSubject(issuer), "subject");
        // org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().isEmpty());
        org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer), samlssoServiceProviderDO);
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer).getAssertionConsumerUrl(), org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testPersistSession_4(java.lang.String param0) throws java.lang.Exception {
        java.lang.String issuer = "testUser";
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(issuer);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("samlTokenId", new org.wso2.carbon.identity.sso.saml.session.SessionInfoData(), org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        ssoSessionPersistenceManager.persistSession("samlTokenId", "subject", samlssoServiceProviderDO, "rpSessionId", issuer, org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData = ssoSessionPersistenceManager.getSessionInfoDataFromCache("samlTokenId", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        // org.testng.Assert.assertEquals(sessionInfoData.getSubject(issuer), "subject");
        // org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().isEmpty());
        // org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer), samlssoServiceProviderDO);
        org.testng.Assert.assertEquals(sessionInfoData.getServiceProviderList().get(issuer).getAssertionConsumerUrl(), org.wso2.carbon.identity.sso.saml.TestConstants.ACS_URL);
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"issuerTwo"},
        new java.lang.Object[]{"saml2-web-app-pickup-dispatch.com"},
        new java.lang.Object[]{"saml2-web-app-pickup-manager.com"},
        new java.lang.Object[]{"testUser"}
        };
    }
}