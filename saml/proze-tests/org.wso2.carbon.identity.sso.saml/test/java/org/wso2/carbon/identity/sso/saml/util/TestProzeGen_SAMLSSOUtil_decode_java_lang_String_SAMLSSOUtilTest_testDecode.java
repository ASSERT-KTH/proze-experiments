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
public class TestProzeGen_SAMLSSOUtil_decode_java_lang_String_SAMLSSOUtilTest_testDecode extends org.powermock.modules.testng.PowerMockTestCase {
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

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testDecode(java.lang.String param0) throws java.lang.Exception {
        org.testng.Assert.assertEquals(org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.decode(param0), org.wso2.carbon.identity.sso.saml.TestConstants.DECODED_REDIRECT_AUTHN_REQUEST, "Decoded value of encoded Redirect Authentication Request is not as expected.");
        org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.decode(param0);
    }

    @org.testng.annotations.DataProvider(name = "testCompressResponse")
    public static java.lang.Object[][] compressStrings() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.AUTHN_FAILED_SAML_RESPONSE, "Compressed Authentication Failed SAML response should not be empty." }, new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.GENERAL_STRING, "Compressed general string should not be empty." } };
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

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{""},
        new java.lang.Object[]{"nVNdb9pAEPwr1r2DHYMqcsJEFBQVKW1dcPLQt+O8hoP76u2ZkH/fsw0RrVKEKvlpb3Z2dmY9fjgqGR3AoTA6I3f9hESguSmF3mTkuXjsjcjDZIxMSUuntd/qJfyqAX0U+jTS9iEjtdPUMBRINVOA1HO6mn59omk/odYZb7iRJJoigvNh0MxorBW4FbiD4PC8fMrI1ntL41gazuTWoKejZJTE3rEDhJrwb31uVLw1Cvo7tCSaBxFCM9/qbprxj+774XAQN+oQDYkejePQys9IxSQCiRbzjOyUsut9ZSrB7I6vS83XXO33YITcMmBKl2tpN/tNQGPOEMUBMuJd3bQj1rDQ6Jn2GUmTdNhLPoWvSO7p3Yimg/4wGfwkUX7a/rPQnafXrFp3IKRfiiLv5d9XBYleztkEADkn0U53t2fAzs6TyV+OjuNLxo4/tfRboFjMcyMFf7sYk96etZTmdeaA+XfLQgiK+esETUWUvaqFUtvsjh60J9EqbzT9qJkUlQCXkU4xid81ny4TyjbocGMejv6/xM+MsswJbGyHI+P+ZDy9ZJ7J4OoSqosJN4dwFcYpb6hDubm5V+PK5oiAh80KxzRa43wX24d6Jt3bvwyZnBO//JsnvwE="},
        new java.lang.Object[]{"nVNdj9owEHzvr4j8Dsnx0YJFOFHQqSddexS4PvTNZzbBnGOn3g3H/fvaCZyiqkWor5v1zOzMZHJ7LHR0AIfKmpTddBMWgZF2q0yesqfNXWfEbqcfJigKXfJZRTuzgl8VIEUzRHDkn82twaoAtwZ3UBKeVg8p2xGVPI61lULvLFJX2oKPklESkxMH8HNFb2EYK7OFY3ePJYtmRE49VwQNopdwgrwPOykbj4fD4XiQjFm08AqUEVSrDmTYZuPjwaAfB82IlkV31kmotacsExqBRfeLlOk97DNVvCghbb4zWZlbLfdK2Ty3OZTZ3uYvpcfw27gUiOoAKSNXheeIlVeFJAylrJfcfOok407v4yYZ8X6fDwbdpJ/8ZNHSWbLS6s/+ytrRyhluBSrkRhSAnCRfz74+8F434c/NEvIvm82ys3xcb1j045xMLyTjszLI6ywuQ5UnXjY9JVcLdtcDiHO4bPpHYJO4jdjg90r+zUPcL5ZWK/kWzbS2r3MHgt4d8xkUgi6ThonadrJ6lZfhdCQwxKL1MuB/r4RWmQKXsoa97UjvWkvid82nJsO27oYvHcGRorktSuEUBtfhKCT9F0tDwtvIc+1dXUHWgrs6hItrkssA7cehpq/WbUPvQPrLNk4YLK2jJra/6pk23/5lyPScePvvn/4G"},
        new java.lang.Object[]{"nVNdj9owEPwrkd9DQg61YBFOFHQq0rVNIdeHvhmzIb76q14Hrv/+nAROVGopquQne3dmdmY9vX9RMjqAQ2F0ToaDlESgudkJvc/JU/kQj8n9bIpMSUvnja/1Gn42gD4KfRpp95CTxmlqGAqkmilA6jndzD890myQUuuMN9xIEs0RwflAtDAaGwVuA+4gODytH3NSe29pkkjDmawNejpOx2nS4mfxEbYxsza2gv9obKyYZntwA25UUhsFg2e0JFoGVUIz3w3SouFvcJPR6K6DQzQkejCOQzdPTiomEUi0WuZEGa1Dh9kqq/cGal3LurbPqt5WUDMwArSqLNuFaiwYojhATrxr2nbEBlYaPdM+J1majeL0XThlOqHD9zS7GwzHk+8kKk52fBC6N/mad9u+COnHsizi4sumJNG3c1ihgJyj6djd7aGwcxRk9i+Lp8klRU+YWfo5YK6WhZGC/7rgzW7fBinNceGA+TcPQyqK+esA7Y3YxVVXSm1rBnrQnkSbotX0tWFSVAJcTnrFJHnTfNpd2HXJhy308OL/S/zCKMucwDYHeGHcn5Kgl8gLGWxeQ3XBcHMqV8s45S10uG6X8Gjcrt0q4GGy0jGN1jjfx/ZHPbP+7W+GzM6JX/732Ss="},
        new java.lang.Object[]{"nVNdj9owEPwrkd9JAo1OYBFOFHQq0rWikOtD34y9Ieb8kXodjvv3dZLjSqsWoUp+Ws/OjmfW0/uTVtERHEprcjKMUxKB4VZIs8/JU/EwGJP72RSZVjWdN74yG/jRAPoo9Bmk3UVOGmeoZSiRGqYBqed0O//8SEdxSmtnveVWkWiOCM6HQQtrsNHgtuCOksPT5jEnlfc1TRJlOVOVRU/H6ThNvGNHCDXpX2NudVJZDfEBaxItgwhpmO90t834W/ckyz4krTpES6IH6zh08nNSMoVAotUyJ4bXerfTSojDfleJ2lTS8PLAuNg/758PpVAA0lY6oHHNEOURfvUjNrAy6JnxORmlo2yQ3oVTpBM6nNA0i4d32XcSrd+e/1Ga3tRrXu16ENJPRbEebEBIB9yT6Ns5oAAi5zg6Be72INjZfjL7w9ZpcsnY849q+iVQrJZrqyR/vRgzuj1wpezLwgHzwTfvGuiS0MxfJ2grUgzKDkrr9u3owQQftutW09eGKVlKcDnpFZPkXfPbeoLo0g6L5uHk/0v8wuqaOYmt7XBiIYZ+CL1kXqjg6gbKiwk3h3AVxilvqUO5XbwX60S7SGEZQBSOGayt831sf9Uz6+/+ZcjsnPjll579BA=="},
        new java.lang.Object[]{"nVPBjtowFPyVyPeQNItasAgrCloVadumkO2hN+O8EINju34O0L9fJ4EVlVqKKuVkj2fmzbxMHk+1DA5gUWiVkneDmASguC6E2qbkJX8KR+RxOkFWS0NnjavUCn42gC7w7xTS7iIljVVUMxRIFasBqeN0Pfv8TJNBTI3VTnMtSTBDBOu80FwrbGqwa7AHweFl9ZySyjlDo0hqzmSl0dFRPIqjlj8Jj7AJmTGhEXzfmLAQaJjj1YDrOqp0DYMdGhIsvC2hmOsmaenwN77xcPjQ8SFqEjxpy6EbKCUlkwgkWC5SIovdvgDGeFXvdkWlweyFLKpqu9lv9/VWF6yEXV1uPRozhigOkBJnm/Y5YgNLhY4pl5IkToZh/N5/eTymw5g+xIP4w/gHCbJzHh+F6lO+Fd6mByH9lOdZmH1d5yT4fmnLA8ilm07d3t8Ku3RBpv/MeBJda/SKiaFfPOlykWkp+K8r4eT+fZBSH+cWmHsL0ddSM3eboD0RRVh2UGraNNCBciRYZ62nbw2TohRgU9I7JtGb5/P2QtFV7/fQwcn9l/m5rg2zAtsi4MS4O1dBr5nn0ue8gvJK4e5absI45S21P2638Kht0a4VcD9ZbplCo63ra/ujn2l/97dAppfGr//46Ss="},
        new java.lang.Object[]{"nVPRjtowEPyVyO8hIaAWLMKJgk5FurYp5O6hb8ZZiA/Hdr0O0L+vk8CJSj2KKvnJ3p2ZnVlPHk6VDA5gUWiVkn4vJgEorguhdil5zh/DEXmYTpBV0tBZ7Uq1gp81oAt8n0LaPqSktopqhgKpYhUgdZyuZ1+eaNKLqbHaaa4lCWaIYJ0nmmuFdQV2DfYgODyvnlJSOmdoFEnNmSw1OjqKR3HU4CfhETYhMyY0gu9rExYCDXO87HFdRaWuoPeKhgQLL0so5tpJGjj8A288HA5aPERNgkdtObQDpWTLJAIJlgvfVoid2pVFYRjs+U7oPRfCaLHfbFS5e9WVqIqi2vthlpgxRHGAlDhbN+2INSwVOqZcSpI4GYbxB3/yeEz7H+lg2OuPBz9IkJ39+CRU5/It8zZdEdLPeZ6F2bd1ToKXS1q+gFyyadnt/amwSxZk+k+PJ9E1R8eYGPrVgy4XmZaC/7oiTu7fByn1cW6BuTcTfSwVc7cBmhtRhNu2lJrGDXSgHAnWWaPpe82k2AqwKekUk+hN83l7oWij93vo4OT+S/xcV4ZZgU0QcGLcnaOg18hz6X1ewfaK4e5YbpZxyhtof91s4VHbolkr4H6y3DKFRlvXxfZXPdPu7T1DppfEr3/89Dc="},
        new java.lang.Object[]{"nZJBbxoxEIXv/RWW77CwpVVqsRtRaCqktKJAeujNeAfW4LVdzywh/z7eBRpStVEUySf7zXvjb2Z4fagM20NA7WzG+90eZ2CVK7TdZPxuedO54tf5uyHKyngxqqm0c/hdAxIbIUKgWDZ2FusKwgLCXiu4m99mnILcg3FK00NXuYqzSSzRVlIbUxJ5FEkSBdKUDkl8GgzeJ1FYOStjCGc3Liho8zK+lgaBs+kk43alLPjCr+VuuyqLnV6B1ZXcrIqd3G58UZZ+u3KqiGqcSUS9h6d6xBqmFklaynjaSwed3sd4lv2eiGfQ71596P3ibBYcOeXMZ22PGL5+WXL288wobRhFahZFSyXjdbDCSdQorKwABSmxGH27FVEp/MmM5yeGbRfh9QbyjJnnf0EdJpeOR//Ui+/RYjqZOaPVAxsZ4+7HASRBM5QaWrKVpJdDmxtddNatVPjm60hgibPFrPH/UUuj1xpCxo/pl0TS1yJJ/vR82iko2onHhSI4EBu7ysugsaEOB6noTSn55fKerMcmYp3D+k1jeFGmhGq843WzfvcuFM06gYp/WwZp0btA58H9q6P8+Pg/Jvmz2pMkfwQ="},
        new java.lang.Object[]{"nZJLa8MwEITv/RVGdye249S2iB0CoRDoA5q0h94Ua/1ILa2rVUr77ysnTZ/QQ0HosMx+zAw7m7+oznsGQy3qnIWjgHmgS5StrnN2t7nwUzYvzmYkVBf1/BJr3NtbeNoDWW/pvlYLe1htrO2Jj8cdlqJrkCzP4ngyHhaJkHmrZc4e+1L2XdeoWukd9Eo2VV01rcRdKYWq6ma3BXxE5dREe1hpskLbnEVBmPhh4N4mSHkc8Uk0CtP4gXnXaG/0jVlUFswvXfKpuwVBg8u1y9WBd8zBvPtT8GgI7qrQxI9Rc7Y3mqOglrgWCojbkq8XV5fcSXlv0GKJHSuOzfCDX/OV8DdAEIEZimOFNeIZXGutfR2VqGbjr8QT/9oRVkvvAo0S9m/0MGmlXx2kHLR1YPYvZ0KqVp/8HB0Up0tYAw3NrbSEl0JOk22anUd+sq0CP5aQ+WmSTf1tICciDKHKouk758fmx/TbZRVv"},
        new java.lang.Object[]{"nZJPbxMxEMXvfArL9/zbRkCt7FYhoShSQSFJOXBzvbOsg3e8eGbT9Nvj3SSQolJVlXyy37w3/s1MrvaVEzsIZD2mctQfSgFofG7xRypvN9e99/IqezMhXblaTRsucQW/GiAWUyIIHMtmHqmpIKwh7KyB29VNKjnoHThvLD/0ja+kmMcSi5q7mJK5JjUYRIF2pSdWl+PxxSAKK486hkhx7YOBLi+VhXYEUizmsbI2iHleusJXBrd1bsEWXusStwj19q40P+8qRBPVtNREdgd/64kaWCCxRk5lMkzGveHbeDajoYpnfNEfvbv8LsUyePbGuw8WDxg+fdxI8e3EKGkZRWpIqqOSyiag8posKdQVkGKj1tPPNyoqVX00k9mRYddFeLmBPmGW2T9QJ4Nzx4N/Uqsv0WIxX3pnzYOYOufvZwE0QzuUBjqylebnQ9sbm/eKTqrq9uvEgCzFetn6f220s4WFkMpD+jmR5KVIBn96Pu4U5N3E40Ix7FnMfFXrYKmlDntt+FUp2fnyHq1nLmJdQfGqMTwrM8q03vG6Xb97H/J2ncDEv22CRqp94NPgnuooOzz+j0n2qPYoyX4D"},
        new java.lang.Object[]{"nZJPbxMxEMXvfArL92TTZYVaK7tVSCiKVFBIUg7cjHeWOPU/PLNp+u3r3SQQEFRVJZ/sN++NfzPj6701bAcRtXclvxiOOAOnfK3dj5LfrW8Gl/y6ejNGaU0Qk5Y2bgk/W0BiE0SIlMqm3mFrIa4g7rSCu+VtySnKHRivND0OlbeczVKJdpL6mA1RQJFlSSDNxiOJq6J4myWh9U6mEM5ufFTQ55W8kQaBs/ms5Pcb0E3ttnVtgtFWy3u9DbXfWukNfJcu1EqpbaOTGhcSUe/gdz1iC3OHJB2VPB/lxWD0Lp31xUikU+TDy+LqG2eL6Mkrb95rd8Dw8cOas68nRnnHKFFzKHoqJW+jE16iRuGkBRSkxGry6VYkpQhHM14dGfZdxJcbyBNmXv0FdZydOx788yA+J4v5bOGNVo9sYox/mEaQBN1QWujJWknPh3Y3uh40vVSE7utI4Iiz1aLz/9JKoxsNseSH9HMi+UuRZL96Pu4U1P3E00IR7IlNvQ0yauyow14qelVKdb68R+upSViX0LxqDM/KlFCdd7ru1u/Bx7pbJ1Dpb+soHQYf6TS4f3VUHR7/x6T6o/YoqZ4A"},
        new java.lang.Object[]{"nZJPj9owEMXv/RSW7xA2oP6xSFYUuhXStqLA9tCb15kQF9uTehyW/fZ1Qmhp1a5WK/kQOW/eG/9mptdHa9gBPGl0Gb8ajjgDp7DQbpfxu+3N4C2/zl9NSVpTi1kTKreGHw1QYDMi8CGWzdFRY8FvwB+0grv1bcaDlwcwqHR4HCq0nC1iiXYydDFVCDWJJIkCaSqkIN5NJuMkCi06GUM4u0GvoMvLeCkNAWfLRfy0uHeA+wqtvK/uK+mquq72aoeF3ekSoYLvMaKIalpJIn2A3/VEDSwdBelCxtNROhmMXsezvRqJeCbj4Th9842zlceACs177U4YPn7Ycvb1zChtGUVqjkRHJeONdwIlaRJOWiARlNjMPt2KqBR1b8bznmHXhX++gTxj5vlfUKfJpePJP63F52ixXKzQaPXIZsbgw9yDDNAOpYGOrJXh6dD2RheDspOKun06BXCBs82q9f/SSKNLDT7jp/RLIulzkSS/eu53Copu4nGhAhwDm6OtpdfUUoejVOFFKfnl8vbWcxOxrqF80RielCmhWu943a7fA/qiXSdQ8W1bLx3V6MN5cP/qKD/9/B+T/I/aXpL/BA=="}
        };
    }
}