/* Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.carbon.identity.sso.saml;
/**
 * Unit Tests for SAMLLogoutHandler.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ javax.servlet.http.HttpServletRequest.class, org.wso2.carbon.idp.mgt.IdentityProviderManager.class, org.opensaml.core.config.InitializationService.class, javax.net.ssl.SSLContext.class, org.wso2.carbon.identity.application.common.model.IdentityProvider.class, org.wso2.carbon.identity.core.util.IdentityUtil.class, org.wso2.carbon.base.ServerConfiguration.class, org.wso2.carbon.core.util.KeyStoreManager.class, java.lang.Class.class, org.wso2.carbon.security.keystore.KeyStoreAdmin.class, org.wso2.carbon.core.util.KeyStoreUtil.class, org.wso2.carbon.identity.core.util.IdentityTenantUtil.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.apache.xerces.*", "org.w3c.dom.*", "javax.net.*", "javax.security.*" })
public class TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent extends org.powermock.modules.testng.PowerMockTestCase {
    private static java.lang.String SESSION_INDEX_ONE = "theSessionIndex";

    private static java.lang.String SESSION_TOKEN_ID_ONE = "samlssoTokenId";

    private static java.lang.String SESSION_INDEX_TWO = "theSessionIndexTwo";

    private static java.lang.String SESSION_TOKEN_ID_TWO = "samlssoToeknIdTwo";

    @org.mockito.Mock
    private javax.net.ssl.SSLContext sslContext;

    @org.mockito.Mock
    private java.security.SecureRandom secureRandom;

    @org.mockito.Mock
    private org.wso2.carbon.base.ServerConfiguration serverConfiguration;

    @org.mockito.Mock
    private org.wso2.carbon.idp.mgt.IdentityProviderManager identityProviderManager;

    @org.mockito.Mock
    private org.wso2.carbon.identity.application.common.model.IdentityProvider identityProvider;

    @org.mockito.Mock
    private org.wso2.carbon.core.util.KeyStoreManager keyStoreManager;

    @org.mockito.Mock
    private org.wso2.carbon.registry.core.service.RegistryService registryService;

    @org.mockito.Mock
    private org.wso2.carbon.registry.core.session.UserRegistry registry;

    @org.mockito.Mock
    private org.wso2.carbon.registry.core.Collection collection;

    private javax.net.ssl.KeyManager[] keyManagers = new javax.net.ssl.KeyManager[]{ new javax.net.ssl.KeyManager() {} };

    private javax.net.ssl.TrustManager[] trustManagers = new javax.net.ssl.TrustManager[]{ new javax.net.ssl.TrustManager() {} };

    private org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[] federatedAuthenticatorConfigs = new org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[]{  };

    private java.lang.String[] collectionString = new java.lang.String[]{  };

    org.wso2.carbon.identity.sso.saml.SAMLLogoutHandler samlLogoutHandler = new org.wso2.carbon.identity.sso.saml.SAMLLogoutHandler();

    @org.testng.annotations.BeforeTest
    public void startTenantFlow() {
        org.wso2.carbon.identity.sso.saml.TestUtils.startTenantFlow(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
    }

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantId(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantDomain(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO serviceProviderDOOne = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        serviceProviderDOOne.setIssuer("issuerOne");
        serviceProviderDOOne.setDoSingleLogout(true);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO serviceProviderDOTwo = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        serviceProviderDOTwo.setIssuer("issuerTwo");
        serviceProviderDOTwo.setDoSingleLogout(true);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataOne = new org.wso2.carbon.identity.sso.saml.session.SessionInfoData();
        sessionInfoDataOne.addServiceProvider("issuerOne", serviceProviderDOOne, null);
        sessionInfoDataOne.addServiceProvider("issuerTwo", serviceProviderDOTwo, null);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataTwo = new org.wso2.carbon.identity.sso.saml.session.SessionInfoData();
        sessionInfoDataTwo.addServiceProvider("issuerOne", serviceProviderDOOne, null);
        sessionInfoDataTwo.addServiceProvider("issuerTwo", serviceProviderDOTwo, null);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache(org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_TOKEN_ID_ONE, org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_INDEX_ONE, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache(org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_TOKEN_ID_TWO, org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_INDEX_TWO, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache(org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_INDEX_ONE, sessionInfoDataOne, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache(org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_INDEX_TWO, sessionInfoDataTwo, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        // creating mocks
        createMocks();
    }

    private void createMocks() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.mockStatic(javax.net.ssl.SSLContext.class);
        org.powermock.api.mockito.PowerMockito.when(javax.net.ssl.SSLContext.getInstance(org.mockito.ArgumentMatchers.anyString())).thenReturn(sslContext);
        org.powermock.api.mockito.PowerMockito.doNothing().when(sslContext).init(keyManagers, trustManagers, secureRandom);
        org.powermock.api.mockito.PowerMockito.spy(org.wso2.carbon.idp.mgt.IdentityProviderManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.idp.mgt.IdentityProviderManager.getInstance()).thenReturn(identityProviderManager);
        org.powermock.api.mockito.PowerMockito.when(identityProviderManager.getResidentIdP(org.mockito.ArgumentMatchers.anyString())).thenReturn(identityProvider);
        org.powermock.api.mockito.PowerMockito.when(identityProvider.getFederatedAuthenticatorConfigs()).thenReturn(federatedAuthenticatorConfigs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityUtil.getProperty(org.wso2.carbon.identity.base.IdentityConstants.ServerConfig.ENTITY_ID)).thenReturn("IDPOne");
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityUtil.getProperty(org.wso2.carbon.identity.sso.saml.SAMLSSOConstants.SAMLSSO_SIGNER_CLASS_NAME)).thenReturn("org.wso2.carbon.identity.sso.saml.builders.signature.DefaultSSOSigner");
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.base.ServerConfiguration.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.base.ServerConfiguration.getInstance()).thenReturn(serverConfiguration);
        org.powermock.api.mockito.PowerMockito.when(serverConfiguration.getFirstProperty("Security.KeyStore.KeyAlias")).thenReturn("wso2carbon");
        org.powermock.api.mockito.PowerMockito.when(serverConfiguration.getFirstProperty("Security.KeyStore.KeyPassword")).thenReturn("wso2carbon");
        org.powermock.api.mockito.PowerMockito.when(serverConfiguration.getFirstProperty("Security.KeyStore.Location")).thenReturn("");
        org.powermock.api.mockito.PowerMockito.when(serverConfiguration.getFirstProperty("Security.KeyStore.Type")).thenReturn("");
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.core.util.KeyStoreUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.core.util.KeyStoreUtil.getKeyStoreFileName(org.mockito.ArgumentMatchers.anyString())).thenReturn("wso2carbon");
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.core.util.KeyStoreUtil.isPrimaryStore(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        java.security.KeyStore keyStore = org.wso2.carbon.identity.sso.saml.TestUtils.loadKeyStoreFromFileSystem(org.wso2.carbon.identity.sso.saml.TestUtils.getFilePath("wso2carbon.jks"), "wso2carbon", "JKS");
        org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.setRegistryService(registryService);
        org.powermock.api.mockito.PowerMockito.when(registryService.getGovernanceSystemRegistry()).thenReturn(registry);
        org.powermock.api.mockito.PowerMockito.when(registry.resourceExists(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.powermock.api.mockito.PowerMockito.when(registry.get(org.mockito.ArgumentMatchers.anyString())).thenReturn(collection);
        org.powermock.api.mockito.PowerMockito.when(collection.getChildren()).thenReturn(collectionString);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.core.util.KeyStoreManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.core.util.KeyStoreManager.getInstance(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID)).thenReturn(keyStoreManager);
        org.powermock.api.mockito.PowerMockito.when(keyStoreManager.getPrimaryKeyStore()).thenReturn(keyStore);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testHandleEvent(java.lang.String param0, java.lang.String param1) throws java.lang.Exception {
        org.wso2.carbon.identity.event.event.Event eventOne = setupEvent(org.wso2.carbon.identity.event.IdentityEventConstants.EventName.SESSION_TERMINATE.name(), "issuerOne");
        samlLogoutHandler.handleEvent(eventOne);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataOne = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataTwo = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        org.testng.Assert.assertNull(sessionInfoDataOne);
        org.testng.Assert.assertNotNull(sessionInfoDataTwo);
    }

    private org.wso2.carbon.identity.event.event.Event setupEvent(java.lang.String eventName, java.lang.String issuer) {
        javax.servlet.http.HttpServletRequest request = org.powermock.api.mockito.PowerMockito.mock(javax.servlet.http.HttpServletRequest.class);
        java.util.HashMap<java.lang.String, java.lang.Object> eventProperties = new java.util.HashMap<>();
        org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext context = new org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext();
        context.setRelyingParty(issuer);
        eventProperties.put(org.wso2.carbon.identity.event.IdentityEventConstants.EventProperty.REQUEST, request);
        eventProperties.put(org.wso2.carbon.identity.event.IdentityEventConstants.EventProperty.CONTEXT, context);
        javax.servlet.http.Cookie[] cookies = new javax.servlet.http.Cookie[1];
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("samlssoTokenId", org.wso2.carbon.identity.sso.saml.TestProzeGen_SSOSessionPersistenceManager_getSessionInfoDataFromCache_java_lang_String_java_lang_String_SAMLLogoutHandlerTest_testHandleEvent.SESSION_TOKEN_ID_ONE);
        cookies[0] = cookie;
        org.powermock.api.mockito.PowerMockito.when(request.getCookies()).thenReturn(cookies);
        return new org.wso2.carbon.identity.event.event.Event(eventName, eventProperties);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testHandleEvent_1(java.lang.String param0, java.lang.String param1) throws java.lang.Exception {
        org.wso2.carbon.identity.event.event.Event eventOne = setupEvent(org.wso2.carbon.identity.event.IdentityEventConstants.EventName.SESSION_TERMINATE.name(), "issuerOne");
        samlLogoutHandler.handleEvent(eventOne);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataOne = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataTwo = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        org.testng.Assert.assertNull(sessionInfoDataOne);
        // org.testng.Assert.assertNotNull(sessionInfoDataTwo);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testHandleEvent_2(java.lang.String param0, java.lang.String param1) throws java.lang.Exception {
        org.wso2.carbon.identity.event.event.Event eventOne = setupEvent(org.wso2.carbon.identity.event.IdentityEventConstants.EventName.SESSION_TERMINATE.name(), "issuerOne");
        samlLogoutHandler.handleEvent(eventOne);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataOne = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoDataTwo = org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getSessionInfoDataFromCache(param0, param1);
        // org.testng.Assert.assertNull(sessionInfoDataOne);
        org.testng.Assert.assertNotNull(sessionInfoDataTwo);
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"45968110-dea2-49c2-a403-0aa402caa033", "carbon.super"},
        new java.lang.Object[]{"614f4355-74cf-4e47-a05c-323b20812f1e", "carbon.super"},
        new java.lang.Object[]{"86f3f0d4-60a5-4319-9bd8-2cc6c3a50eda", "carbon.super"},
        new java.lang.Object[]{null, "carbon.super"},
        new java.lang.Object[]{"d5c336dc-0853-4010-855d-38d37b386832", "carbon.super"},
        new java.lang.Object[]{"dddcd246-6f7d-46ea-a6cc-82df03a5e6f0", "carbon.super"},
        new java.lang.Object[]{"samlTokenId", "carbon.super"},
        new java.lang.Object[]{"sessionId", "carbon.super"},
        new java.lang.Object[]{"sessionIndex", "carbon.super"},
        new java.lang.Object[]{"sessionIndex1", "carbon.super"},
        new java.lang.Object[]{"sessionIndex2", "carbon.super"},
        new java.lang.Object[]{"sessionIndex3", "carbon.super"},
        new java.lang.Object[]{"theSessionIndex", "carbon.super"},
        new java.lang.Object[]{"theSessionIndexTwo", "carbon.super"}
        };
    }
}