/* Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).

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
package org.wso2.carbon.identity.sso.saml;
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class, org.wso2.carbon.context.PrivilegedCarbonContext.class })
public class TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication extends org.powermock.modules.testng.PowerMockTestCase {
    @org.mockito.Mock
    private org.apache.axis2.context.ConfigurationContext configurationContext;

    @org.mockito.Mock
    private org.apache.axis2.engine.AxisConfiguration axisConfiguration;

    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder samlssoServiceComponentHolder;

    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.SAMLSSOConfigServiceImpl samlssoConfigService;

    @org.mockito.InjectMocks
    private org.wso2.carbon.identity.sso.saml.SAML2InboundAuthConfigHandler saml2InboundAuthConfigHandler;

    @org.mockito.Mock
    private org.wso2.carbon.identity.application.common.model.ServiceProvider application;

    private static final java.lang.String ISSUER = "Issuer_01";

    private static final java.lang.String APPLICATION_NAME = "dummyApplication";

    private static final java.lang.String APPLICATION_RESOURCE_ID = "dummyResourceId";

    private static final java.lang.String META_DATA_URL = "https://localhost:9443/identity/metadata/saml2";

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        org.mockito.MockitoAnnotations.initMocks(this);
        java.lang.System.setProperty("carbon.home", (((((java.lang.System.getProperty("user.dir") + java.io.File.separator) + "src") + java.io.File.separator) + "test") + java.io.File.separator) + "resources");
        initConfigsAndRealm();
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testUpdateSAML2Protocol_CreateNewApplication(java.lang.String param0) throws java.lang.Exception {
        mockSAMLSSOServiceComponentHolder();
        mockServiceProvider(false);
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO updatedSAMLServiceProvider = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOServiceProviderDTO();
        updatedSAMLServiceProvider.setIssuer(param0);
        updatedSAMLServiceProvider.setAuditLogData(getDummyAuditLogData());
        org.powermock.api.mockito.PowerMockito.when(samlssoConfigService.createServiceProviderWithMetadataURL(org.mockito.ArgumentMatchers.eq(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.META_DATA_URL), org.mockito.ArgumentMatchers.eq(false))).thenReturn(updatedSAMLServiceProvider);
        // Mock behavior when currentClientId is null, indicating a new application
        org.wso2.carbon.identity.sso.saml.dto.SAML2ProtocolConfigDTO saml2ProtocolConfigDTO = new org.wso2.carbon.identity.sso.saml.dto.SAML2ProtocolConfigDTO();
        saml2ProtocolConfigDTO.setMetadataURL(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.META_DATA_URL);
        org.wso2.carbon.identity.application.common.model.InboundAuthenticationRequestConfig result = saml2InboundAuthConfigHandler.handleConfigUpdate(application, saml2ProtocolConfigDTO);
        // Verify that SAML service provider is updated without the audit logs.
        org.mockito.Mockito.verify(samlssoConfigService, org.mockito.Mockito.times(1)).createServiceProviderWithMetadataURL(org.mockito.ArgumentMatchers.eq(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.META_DATA_URL), org.mockito.ArgumentMatchers.eq(false));
        org.mockito.Mockito.verify(samlssoConfigService, org.mockito.Mockito.times(0)).createServiceProviderWithMetadataURL(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.eq(true));
        org.testng.Assert.assertFalse(result.getData().isEmpty());
    }

    private void initConfigsAndRealm() throws java.lang.Exception {
        org.wso2.carbon.identity.core.internal.IdentityCoreServiceComponent identityCoreServiceComponent = new org.wso2.carbon.identity.core.internal.IdentityCoreServiceComponent();
        org.wso2.carbon.utils.ConfigurationContextService configurationContextService = new org.wso2.carbon.utils.ConfigurationContextService(configurationContext, null);
        org.mockito.internal.util.reflection.FieldSetter.setField(identityCoreServiceComponent, identityCoreServiceComponent.getClass().getDeclaredField("configurationContextService"), configurationContextService);
        org.powermock.api.mockito.PowerMockito.when(configurationContext.getAxisConfiguration()).thenReturn(axisConfiguration);
    }

    private void mockSAMLSSOServiceComponentHolder() {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class);
        org.mockito.Mockito.when(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.getInstance()).thenReturn(samlssoServiceComponentHolder);
        org.powermock.api.mockito.PowerMockito.when(samlssoServiceComponentHolder.getSamlSSOConfigService()).thenReturn(samlssoConfigService);
    }

    private void mockPrivilegeCarbonContext() {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.context.PrivilegedCarbonContext.class);
        org.wso2.carbon.context.PrivilegedCarbonContext privilegedCarbonContext = org.powermock.api.mockito.PowerMockito.mock(org.wso2.carbon.context.PrivilegedCarbonContext.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.context.PrivilegedCarbonContext.getThreadLocalCarbonContext()).thenReturn(privilegedCarbonContext);
    }

    private void mockServiceProvider(boolean setInboundAuthConfig) {
        this.application = new org.wso2.carbon.identity.application.common.model.ServiceProvider();
        application.setApplicationName(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.APPLICATION_NAME);
        application.setApplicationResourceId(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.APPLICATION_RESOURCE_ID);
        org.wso2.carbon.identity.application.common.model.InboundAuthenticationConfig inboundAuthenticationConfig = new org.wso2.carbon.identity.application.common.model.InboundAuthenticationConfig();
        if (setInboundAuthConfig) {
            org.wso2.carbon.identity.application.common.model.InboundAuthenticationRequestConfig inboundAuthConfig = new org.wso2.carbon.identity.application.common.model.InboundAuthenticationRequestConfig();
            inboundAuthConfig.setInboundAuthKey(org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.ISSUER);
            inboundAuthConfig.setInboundAuthType(org.wso2.carbon.identity.application.authentication.framework.util.FrameworkConstants.StandardInboundProtocols.SAML2);
            inboundAuthenticationConfig.setInboundAuthenticationRequestConfigs(new org.wso2.carbon.identity.application.common.model.InboundAuthenticationRequestConfig[]{ inboundAuthConfig });
            application.setInboundAuthenticationConfig(inboundAuthenticationConfig);
        }
    }

    private java.util.Map<java.lang.String, java.lang.Object> getDummyMap() {
        java.util.Map<java.lang.String, java.lang.Object> dummyMap = new java.util.HashMap<>();
        dummyMap.put("issuer", org.wso2.carbon.identity.sso.saml.TestProzeGen_SAMLSSOServiceProviderDTO_setIssuer_java_lang_String_SAML2InboundAuthConfigHandlerTest_testUpdateSAML2Protocol_CreateNewApplication.ISSUER);
        return dummyMap;
    }

    private java.lang.String getDummyAuditLogData() {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        java.lang.String json = gson.toJson(getDummyMap());
        return gson.fromJson(json, new com.google.gson.reflect.TypeToken<java.util.Map<java.lang.String, java.lang.Object>>() {}.getType());
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