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
package org.wso2.carbon.identity.sso.saml.util;
/**
 * Unit test cases for SAMLSSOUtil.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.idp.mgt.IdentityProviderManager.class, org.wso2.carbon.identity.core.util.IdentityUtil.class, org.wso2.carbon.identity.application.common.util.IdentityApplicationManagementUtil.class, org.wso2.carbon.core.util.KeyStoreManager.class, org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class, org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class, org.wso2.carbon.identity.core.util.IdentityTenantUtil.class, org.wso2.carbon.identity.core.ServiceURLBuilder.class, org.wso2.carbon.identity.base.IdentityConstants.class, org.wso2.carbon.identity.application.authentication.framework.internal.FrameworkServiceComponent.class, org.wso2.carbon.utils.security.KeystoreUtils.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.w3c.dom.*", "org.apache.xerces.*" })
public class TestProzeGen_SAMLSSOUtil_buildResponseStatus_java_lang_String_java_lang_String_SAMLSSOUtilTest_testBuildResponseStatus extends org.powermock.modules.testng.PowerMockTestCase {
    private static final java.lang.String SAMPLE_TENANTED_SAML_URL = "https://localhost:9443/t/wso2.com/samlsso";

    @org.mockito.Mock
    private org.wso2.carbon.user.core.service.RealmService realmService;

    @org.mockito.Mock
    private org.wso2.carbon.user.core.tenant.TenantManager tenantManager;

    @org.mockito.Mock
    private org.wso2.carbon.idp.mgt.IdentityProviderManager identityProviderManager;

    @org.mockito.Mock
    private org.wso2.carbon.identity.application.common.model.IdentityProvider identityProvider;

    @org.mockito.Mock
    private org.wso2.carbon.core.util.KeyStoreManager keyStoreManager;

    @org.mockito.Mock
    private org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig federatedAuthenticatorConfig;

    private org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData;

    @org.mockito.Mock
    private org.wso2.carbon.identity.core.SAMLSSOServiceProviderManager samlSSOServiceProviderManager;

    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder identitySAMLSSOServiceComponentHolder;

    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager ssoServiceProviderConfigManager;

    @org.mockito.Mock
    org.wso2.carbon.identity.core.ServiceURL serviceURL;

    @org.mockito.Mock
    private org.wso2.carbon.identity.core.ServiceURLBuilder serviceURLBuilder;

    @org.testng.annotations.ObjectFactory
    public org.testng.IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    @org.testng.annotations.BeforeTest
    public void setUp() throws java.lang.Exception {
        org.wso2.carbon.identity.sso.saml.TestUtils.startTenantFlow(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
    }

    private void prepareForGetKeyStorePath() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.utils.security.KeystoreUtils.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.utils.security.KeystoreUtils.getKeyStoreFileLocation(org.wso2.carbon.identity.sso.saml.TestConstants.WSO2_TENANT_DOMAIN)).thenReturn(org.wso2.carbon.identity.sso.saml.TestConstants.WSO2_TENANT_DOMAIN.replace(".", "-") + org.wso2.carbon.identity.sso.saml.TestUtils.getFilePath(org.wso2.carbon.identity.sso.saml.TestConstants.KEY_STORE_NAME));
    }

    private void prepareForGetIssuer() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantId(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantDomain(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.powermock.api.mockito.PowerMockito.when(tenantManager.getTenantId(org.mockito.ArgumentMatchers.anyString())).thenReturn(-1234);
        org.powermock.api.mockito.PowerMockito.when(realmService.getTenantManager()).thenReturn(tenantManager);
        org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.setRealmService(realmService);
        prepareResidentIdP();
    }

    private void prepareForGetSPConfig() throws java.lang.Exception {
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setIssuer(org.wso2.carbon.identity.sso.saml.TestConstants.ISSUER_WITH_QUALIFIER);
        samlssoServiceProviderDO.setIssuerQualifier(org.wso2.carbon.identity.sso.saml.TestConstants.ISSUER_QUALIFIER);
        samlssoServiceProviderDO.setIdpEntityIDAlias(org.wso2.carbon.identity.sso.saml.TestConstants.IDP_ENTITY_ID_ALIAS);
        org.powermock.api.mockito.PowerMockito.when(samlSSOServiceProviderManager.getServiceProvider(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyInt())).thenReturn(samlssoServiceProviderDO);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.getInstance()).thenReturn(identitySAMLSSOServiceComponentHolder);
        org.powermock.api.mockito.PowerMockito.when(identitySAMLSSOServiceComponentHolder.getSAMLSSOServiceProviderManager()).thenReturn(samlSSOServiceProviderManager);
        org.powermock.api.mockito.PowerMockito.when(samlSSOServiceProviderManager.isServiceProviderExists(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyInt())).thenReturn(true);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.getInstance()).thenReturn(ssoServiceProviderConfigManager);
        org.powermock.api.mockito.PowerMockito.when(ssoServiceProviderConfigManager.getServiceProvider(org.wso2.carbon.identity.sso.saml.TestConstants.ISSUER_WITH_QUALIFIER)).thenReturn(samlssoServiceProviderDO);
    }

    private void prepareServiceURLBuilder() throws org.wso2.carbon.identity.core.URLBuilderException {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.ServiceURLBuilder.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.ServiceURLBuilder.create()).thenReturn(serviceURLBuilder);
        org.powermock.api.mockito.PowerMockito.when(serviceURLBuilder.addPath(org.mockito.ArgumentMatchers.any())).thenReturn(serviceURLBuilder);
        org.powermock.api.mockito.PowerMockito.when(serviceURLBuilder.addFragmentParameter(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenReturn(serviceURLBuilder);
        org.powermock.api.mockito.PowerMockito.when(serviceURLBuilder.addParameter(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenReturn(serviceURLBuilder);
        org.powermock.api.mockito.PowerMockito.when(serviceURLBuilder.build()).thenReturn(serviceURL);
    }

    private void setTenantQualifiedUrlMode() {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.isTenantQualifiedUrlsEnabled()).thenReturn(true);
    }

    private void prepareResidentIdP() throws org.wso2.carbon.idp.mgt.IdentityProviderManagementException {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.idp.mgt.IdentityProviderManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.idp.mgt.IdentityProviderManager.getInstance()).thenReturn(identityProviderManager);
        org.powermock.api.mockito.PowerMockito.when(identityProviderManager.getResidentIdP(org.mockito.ArgumentMatchers.anyString())).thenReturn(identityProvider);
        org.wso2.carbon.identity.application.common.model.Property property = new org.wso2.carbon.identity.application.common.model.Property();
        property.setName(org.wso2.carbon.identity.application.common.util.IdentityApplicationConstants.Authenticator.SAML2SSO.IDP_ENTITY_ID);
        property.setValue(org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN);
        org.wso2.carbon.identity.application.common.model.Property[] properties = new org.wso2.carbon.identity.application.common.model.Property[]{ property };
        org.powermock.api.mockito.PowerMockito.when(federatedAuthenticatorConfig.getProperties()).thenReturn(properties);
        org.powermock.api.mockito.PowerMockito.when(federatedAuthenticatorConfig.getName()).thenReturn(org.wso2.carbon.identity.application.common.util.IdentityApplicationConstants.Authenticator.SAML2SSO.NAME);
        org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[] fedAuthConfs = new org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[]{ federatedAuthenticatorConfig };
        org.powermock.api.mockito.PowerMockito.when(identityProvider.getFederatedAuthenticatorConfigs()).thenReturn(fedAuthConfs);
    }

    @org.testng.annotations.DataProvider(name = "testCompressResponse")
    public static java.lang.Object[][] compressStrings() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.AUTHN_FAILED_SAML_RESPONSE, "Compressed Authentication Failed SAML response should not be empty." }, new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.GENERAL_STRING, "Compressed general string should not be empty." } };
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testBuildResponseStatus(java.lang.String param0, java.lang.String param1) {
        java.lang.String statusCode = "500";
        java.lang.String statusMsg = "Internal Server Error";
        org.opensaml.saml.saml2.core.Status status = org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.buildResponseStatus(param0, param1);
        org.testng.Assert.assertEquals(status.getStatusCode().getValue(), statusCode, "Status code is not properly set in the Status " + "object.");
        org.testng.Assert.assertEquals(status.getStatusMessage().getMessage(), statusMsg, "Status Message is not properly set in " + "the Status object.");
    }

    @org.testng.annotations.DataProvider(name = "remainingSessionParticipantsforSloData")
    public java.lang.Object[][] remainingSessionParticipantsforSloData() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ null, null, true, 0 }, new java.lang.Object[]{ null, "issuer", false, 0 }, new java.lang.Object[]{ "sessionIndex", null, false, 2 }, new java.lang.Object[]{ "sessionIndex", "issuer1", false, 1 }, new java.lang.Object[]{ "sessionIndex", "issuer1", true, 2 } };
    }

    public void initializeData() {
        org.wso2.carbon.identity.sso.saml.TestUtils.startTenantFlow(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantId(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantDomain(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID)).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO1 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO1.setIssuer("issuer1");
        samlssoServiceProviderDO1.setDoSingleLogout(true);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO2 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO2.setIssuer("issuer2");
        samlssoServiceProviderDO2.setDoSingleLogout(true);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO3 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO3.setIssuer("issuer3");
        samlssoServiceProviderDO3.setDoSingleLogout(false);
        sessionInfoData = new org.wso2.carbon.identity.sso.saml.session.SessionInfoData();
        sessionInfoData.addServiceProvider("issuer1", samlssoServiceProviderDO1, null);
        sessionInfoData.addServiceProvider("issuer2", samlssoServiceProviderDO2, null);
        sessionInfoData.addServiceProvider("issuer3", samlssoServiceProviderDO3, null);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionIndexToCache("samlssoTokenId", "sessionIndex", org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.addSessionInfoDataToCache("sessionIndex", sessionInfoData, org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
    }

    @org.testng.annotations.DataProvider(name = "issuerProvider")
    public java.lang.Object[][] getIssuerData() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ "travelocity.com", null, "travelocity.com" }, new java.lang.Object[]{ "travelocity.com", "", "travelocity.com" }, new java.lang.Object[]{ "travelocity.com", "wso2.com", "travelocity.com:urn:sp:qualifier:wso2.com" } };
    }

    @org.testng.annotations.DataProvider(name = "issuerWithQualifierProvider")
    public java.lang.Object[][] getIssuerWithQualifierData() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ "travelocity.com", "travelocity.com" }, new java.lang.Object[]{ "travelocity.com:urn:sp:qualifier:wso2.com", "travelocity.com" } };
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testBuildResponseStatus_1(java.lang.String param0, java.lang.String param1) {
        java.lang.String statusCode = "500";
        java.lang.String statusMsg = "Internal Server Error";
        org.opensaml.saml.saml2.core.Status status = org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.buildResponseStatus(param0, param1);
        org.testng.Assert.assertEquals(status.getStatusCode().getValue(), statusCode, "Status code is not properly set in the Status " + "object.");
        // org.testng.Assert.assertEquals(status.getStatusMessage().getMessage(), statusMsg, "Status Message is not properly set in " + "the Status object.");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testBuildResponseStatus_2(java.lang.String param0, java.lang.String param1) {
        java.lang.String statusCode = "500";
        java.lang.String statusMsg = "Internal Server Error";
        org.opensaml.saml.saml2.core.Status status = org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.buildResponseStatus(param0, param1);
        // org.testng.Assert.assertEquals(status.getStatusCode().getValue(), statusCode, "Status code is not properly set in the Status " + "object.");
        org.testng.Assert.assertEquals(status.getStatusMessage().getMessage(), statusMsg, "Status Message is not properly set in " + "the Status object.");
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"500", "Internal Server Error"},
        new java.lang.Object[]{"urn:oasis:names:tc:SAML:2.0:status:Success", null}
        };
    }
}