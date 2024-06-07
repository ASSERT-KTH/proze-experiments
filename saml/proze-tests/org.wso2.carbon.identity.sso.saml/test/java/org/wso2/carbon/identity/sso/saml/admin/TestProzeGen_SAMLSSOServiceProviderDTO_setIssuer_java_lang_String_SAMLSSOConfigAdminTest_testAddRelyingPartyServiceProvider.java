/* Copyright (c) (2017-2023), WSO2 LLC. (http://www.wso2.com).

WSO2 LLC. licenses this file to you under the Apache License,
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
package org.wso2.carbon.identity.sso.saml.admin;
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class, org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class, org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO.class, org.wso2.carbon.identity.sp.metadata.saml2.util.Parser.class, org.wso2.carbon.registry.core.session.UserRegistry.class, org.wso2.carbon.identity.sso.saml.admin.SAMLSSOConfigAdmin.class, org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.apache.xerces.*", "org.w3c.dom.*" })
public class TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAMLSSOConfigAdminTest_testAddRelyingPartyServiceProvider extends org.powermock.modules.testng.PowerMockTestCase {
    private org.wso2.carbon.identity.sso.saml.admin.SAMLSSOConfigAdmin samlssoConfigAdmin;

    @org.mockito.Mock
    org.wso2.carbon.registry.core.session.UserRegistry userRegistry;

    @org.mockito.Mock
    private org.wso2.carbon.identity.core.SAMLSSOServiceProviderManager samlSSOServiceProviderManager;

    @org.mockito.Mock
    org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder identitySAMLSSOServiceComponentHolder;

    @org.mockito.Mock(serializable = true)
    org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProvDO;

    @org.mockito.Mock
    org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager ssoServiceProviderConfigManager;

    @org.mockito.Mock
    org.wso2.carbon.identity.sp.metadata.saml2.util.Parser parser;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        org.wso2.carbon.identity.sso.saml.TestUtils.startTenantFlow(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        samlssoConfigAdmin = new org.wso2.carbon.identity.sso.saml.admin.SAMLSSOConfigAdmin(userRegistry);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.getInstance()).thenReturn(identitySAMLSSOServiceComponentHolder);
        org.powermock.api.mockito.PowerMockito.when(identitySAMLSSOServiceComponentHolder.getSAMLSSOServiceProviderManager()).thenReturn(samlSSOServiceProviderManager);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO.class);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws java.lang.Exception {
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testAddRelyingPartyServiceProvider(java.lang.String param0) throws org.wso2.carbon.identity.base.IdentityException {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.getInstance()).thenReturn(ssoServiceProviderConfigManager);
        org.powermock.api.mockito.PowerMockito.when(samlSSOServiceProviderManager.addServiceProvider(org.mockito.ArgumentMatchers.any(org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO.class), org.mockito.ArgumentMatchers.anyInt())).thenReturn(true);
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO samlssoServiceProviderDTO = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO();
        samlssoServiceProviderDTO.setIssuer(param0);
        org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), true);
        samlssoServiceProvDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.when(ssoServiceProviderConfigManager.getServiceProvider("testUser")).thenReturn(samlssoServiceProvDO);
        org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), false);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testAddRelyingPartyServiceProvider_1(java.lang.String param0) throws org.wso2.carbon.identity.base.IdentityException {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.getInstance()).thenReturn(ssoServiceProviderConfigManager);
        org.powermock.api.mockito.PowerMockito.when(samlSSOServiceProviderManager.addServiceProvider(org.mockito.ArgumentMatchers.any(org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO.class), org.mockito.ArgumentMatchers.anyInt())).thenReturn(true);
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO samlssoServiceProviderDTO = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO();
        samlssoServiceProviderDTO.setIssuer(param0);
        org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), true);
        samlssoServiceProvDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.when(ssoServiceProviderConfigManager.getServiceProvider("testUser")).thenReturn(samlssoServiceProvDO);
        // org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), false);
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testAddRelyingPartyServiceProvider_2(java.lang.String param0) throws org.wso2.carbon.identity.base.IdentityException {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.getInstance()).thenReturn(ssoServiceProviderConfigManager);
        org.powermock.api.mockito.PowerMockito.when(samlSSOServiceProviderManager.addServiceProvider(org.mockito.ArgumentMatchers.any(org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO.class), org.mockito.ArgumentMatchers.anyInt())).thenReturn(true);
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO samlssoServiceProviderDTO = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO();
        samlssoServiceProviderDTO.setIssuer(param0);
        // org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), true);
        samlssoServiceProvDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.powermock.api.mockito.PowerMockito.when(ssoServiceProviderConfigManager.getServiceProvider("testUser")).thenReturn(samlssoServiceProvDO);
        org.testng.Assert.assertEquals(samlssoConfigAdmin.addRelyingPartyServiceProvider(samlssoServiceProviderDTO), false);
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{""},
        new java.lang.Object[]{null},
        new java.lang.Object[]{"issuer"},
        new java.lang.Object[]{"issuer1"},
        new java.lang.Object[]{"saml2-web-app-pickup-dispatch.com"},
        new java.lang.Object[]{"saml2-web-app-pickup-manager.com"},
        new java.lang.Object[]{"sample-app"},
        new java.lang.Object[]{"testUser"},
        new java.lang.Object[]{"travelocity.com"},
        new java.lang.Object[]{"user@example.com"}
        };
    }
}