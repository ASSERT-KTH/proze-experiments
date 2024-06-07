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
 * Tests Assertion building functionality.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.core.util.IdentityUtil.class, org.wso2.carbon.identity.core.util.IdentityTenantUtil.class, org.wso2.carbon.idp.mgt.IdentityProviderManager.class, org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class, org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class, org.wso2.carbon.identity.application.authentication.framework.util.FrameworkUtils.class })
@org.wso2.carbon.identity.common.testng.WithCarbonHome
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.net.*", "javax.xml.*", "org.xml.*", "org.w3c.dom.*", "javax.security.*", "org.mockito.*" })
public class TestProzeGen_SAMLSSOUtil_setSPInitSSOAuthnRequestValidator_java_lang_String_AssertionBuildingTest_getSPInitAuthReqValidatorWithInvalidClass extends org.powermock.modules.testng.PowerMockTestCase {
    @org.testng.annotations.ObjectFactory
    public org.testng.IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    @org.mockito.Mock
    private org.wso2.carbon.user.core.service.RealmService realmService;

    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder identitySAMLSSOServiceComponentHolder;

    @org.mockito.Mock
    private org.wso2.carbon.identity.core.SAMLSSOServiceProviderManager samlssoServiceProviderManager;

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

    @org.mockito.Mock
    org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager ssoServiceProviderConfigManager;

    @org.mockito.Mock
    private org.opensaml.security.x509.X509Credential x509Credential;

    @org.testng.annotations.BeforeMethod
    public void setUpBeforeMethod() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.application.authentication.framework.util.FrameworkUtils.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.application.authentication.framework.util.FrameworkUtils.getMultiAttributeSeparator()).thenReturn(org.wso2.carbon.identity.core.util.IdentityCoreConstants.MULTI_ATTRIBUTE_SEPARATOR_DEFAULT);
    }

    @org.testng.annotations.DataProvider(name = "getSPInitSSOAuthnRequestValidator")
    public java.lang.Object[][] getSSOAuthnValidatorClasses() {
        java.lang.String signatureAlgorithm = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        return new java.lang.Object[][]{ new java.lang.Object[]{ null, "Expected SP init SSO Authn Request validator not to be null" }, new java.lang.Object[]{ "org.wso2.carbon.identity.sso.saml.validators.SPInitSSOAuthnRequestValidator", "Expected SP init SSO" + " Authn Request validator not to be null" } };
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void getSPInitAuthReqValidatorWithInvalidClass(java.lang.String param0) throws java.lang.Exception {
        org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.setSPInitSSOAuthnRequestValidator(param0);
        org.wso2.carbon.identity.saml.common.util.SAMLInitializer.doBootstrap();
        org.opensaml.saml.saml2.core.AuthnRequest authnRequest = org.wso2.carbon.identity.sso.saml.SAMLTestRequestBuilder.buildAuthnRequest(org.wso2.carbon.identity.sso.saml.TestConstants.TRAVELOCITY_ISSUER, false, false, org.apache.axis2.transport.http.HTTPConstants.HTTP_METHOD_GET, org.wso2.carbon.identity.sso.saml.TestConstants.TRAVELOCITY_ISSUER, org.wso2.carbon.identity.sso.saml.TestConstants.IDP_URL);
        org.wso2.carbon.identity.sso.saml.validators.SSOAuthnRequestValidator spInitSSOAuthnRequestValidator = org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.getSPInitSSOAuthnRequestValidator(authnRequest);
        org.testng.Assert.assertNull(spInitSSOAuthnRequestValidator, "Expected SP init SSO Authn Request validator to be null");
    }

    private void prepareForGetIssuer() throws java.lang.Exception {
        org.powermock.api.mockito.PowerMockito.when(tenantManager.getTenantId(org.mockito.ArgumentMatchers.anyString())).thenReturn(org.wso2.carbon.utils.multitenancy.MultitenantConstants.SUPER_TENANT_ID);
        org.powermock.api.mockito.PowerMockito.when(realmService.getTenantManager()).thenReturn(tenantManager);
        org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.setRealmService(realmService);
        org.wso2.carbon.identity.application.common.model.Property property = new org.wso2.carbon.identity.application.common.model.Property();
        property.setName(org.wso2.carbon.identity.application.common.util.IdentityApplicationConstants.Authenticator.SAML2SSO.IDP_ENTITY_ID);
        property.setValue(org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN);
        org.wso2.carbon.identity.application.common.model.Property[] properties = new org.wso2.carbon.identity.application.common.model.Property[]{ property };
        org.powermock.api.mockito.PowerMockito.when(federatedAuthenticatorConfig.getProperties()).thenReturn(properties);
        org.powermock.api.mockito.PowerMockito.when(federatedAuthenticatorConfig.getName()).thenReturn(org.wso2.carbon.identity.application.common.util.IdentityApplicationConstants.Authenticator.SAML2SSO.NAME);
        org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[] fedAuthConfs = new org.wso2.carbon.identity.application.common.model.FederatedAuthenticatorConfig[]{ federatedAuthenticatorConfig };
        org.powermock.api.mockito.PowerMockito.when(identityProvider.getFederatedAuthenticatorConfigs()).thenReturn(fedAuthConfs);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.idp.mgt.IdentityProviderManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.idp.mgt.IdentityProviderManager.getInstance()).thenReturn(identityProviderManager);
        org.powermock.api.mockito.PowerMockito.when(identityProviderManager.getResidentIdP(org.mockito.ArgumentMatchers.anyString())).thenReturn(identityProvider);
    }

    private void prepareForUserAttributes(java.lang.String attrConsumerIndex, java.lang.String issuer, java.lang.String spName) {
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.SSOServiceProviderConfigManager.getInstance()).thenReturn(ssoServiceProviderConfigManager);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setAttributeConsumingServiceIndex(attrConsumerIndex);
        samlssoServiceProviderDO.setEnableAttributesByDefault(true);
        samlssoServiceProviderDO.setIssuer(issuer);
        ssoServiceProviderConfigManager.addServiceProvider(issuer, samlssoServiceProviderDO);
        org.powermock.api.mockito.PowerMockito.when(ssoServiceProviderConfigManager.getServiceProvider(spName)).thenReturn(samlssoServiceProviderDO);
    }

    private org.opensaml.saml.saml2.core.Assertion buildAssertion() throws java.lang.Exception {
        prepareForGetIssuer();
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityUtil.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.core.util.IdentityTenantUtil.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.core.util.IdentityUtil.getServerURL(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyBoolean(), org.mockito.ArgumentMatchers.anyBoolean())).thenReturn(org.wso2.carbon.identity.sso.saml.TestConstants.SAMPLE_SERVER_URL);
        prepareForUserAttributes(org.wso2.carbon.identity.sso.saml.TestConstants.ATTRIBUTE_CONSUMER_INDEX, org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN, org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN);
        java.util.Map<java.lang.String, java.lang.String> inputAttributes = new java.util.HashMap<>();
        inputAttributes.put(org.wso2.carbon.identity.sso.saml.TestConstants.CLAIM_URI1, org.wso2.carbon.identity.sso.saml.TestConstants.CLAIM_VALUE1);
        inputAttributes.put(org.wso2.carbon.identity.sso.saml.TestConstants.CLAIM_URI2, org.wso2.carbon.identity.sso.saml.TestConstants.CLAIM_VALUE2);
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOAuthnReqDTO authnReqDTO = org.wso2.carbon.identity.sso.saml.TestUtils.buildAuthnReqDTO(inputAttributes, org.wso2.carbon.identity.sso.saml.TestConstants.SAMPLE_NAME_ID_FORMAT, org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN, org.wso2.carbon.identity.sso.saml.TestConstants.TEST_USER_NAME);
        authnReqDTO.setNameIDFormat(org.wso2.carbon.identity.sso.saml.TestConstants.SAMPLE_NAME_ID_FORMAT);
        authnReqDTO.setIssuer(org.wso2.carbon.identity.sso.saml.TestConstants.LOACALHOST_DOMAIN);
        org.opensaml.saml.saml2.core.Response response = new org.opensaml.saml.saml2.core.impl.ResponseBuilder().buildObject();
        response.setIssuer(org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.getIssuer());
        response.setID(org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.createID());
        if (!authnReqDTO.isIdPInitSSOEnabled()) {
            response.setInResponseTo(authnReqDTO.getId());
        }
        response.setDestination(authnReqDTO.getAssertionConsumerURL());
        response.setStatus(org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.buildResponseStatus(org.wso2.carbon.identity.sso.saml.SAMLSSOConstants.StatusCodes.SUCCESS_CODE, null));
        response.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        org.joda.time.DateTime issueInstant = new org.joda.time.DateTime();
        response.setIssueInstant(issueInstant);
        org.opensaml.saml.saml2.core.Assertion assertion = org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.buildSAMLAssertion(authnReqDTO, new org.joda.time.DateTime(00L), org.wso2.carbon.identity.sso.saml.TestConstants.SESSION_ID);
        return assertion;
    }

    private org.opensaml.saml.saml2.core.Assertion buildAssertionWithSessionNotOnOrAfter() throws java.lang.Exception {
        org.opensaml.saml.saml2.core.Assertion assertion = buildAssertion();
        java.util.List<org.opensaml.saml.saml2.core.AuthnStatement> authStatements = assertion.getAuthnStatements();
        if ((authStatements != null) && (authStatements.size() > 0)) {
            // There can be only one authentication stmt inside the SAML assertion of generating in the test
            org.opensaml.saml.saml2.core.AuthnStatement authStmt = authStatements.get(0);
            java.lang.String sessionNotOnOrAfterValue = org.wso2.carbon.identity.sso.saml.TestConstants.SAML_SESSION_NOT_ON_OR_AFTER_PERIOD_NUMERIC;
            if (org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.isSAMLNotOnOrAfterPeriodDefined(sessionNotOnOrAfterValue)) {
                org.joda.time.DateTime sessionNotOnOrAfter = new org.joda.time.DateTime(authStmt.getAuthnInstant().getMillis() + java.util.concurrent.TimeUnit.SECONDS.toMillis(((long) (org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.getSAMLSessionNotOnOrAfterPeriod(sessionNotOnOrAfterValue)))));
                authStmt.setSessionNotOnOrAfter(sessionNotOnOrAfter);
            }
        }
        return assertion;
    }

    private void prepareIdentityPersistentManager(java.lang.String attrConsumerIndex, java.lang.String issuer, java.util.List acsList) throws org.wso2.carbon.identity.base.IdentityException {
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        samlssoServiceProviderDO.setAttributeConsumingServiceIndex(attrConsumerIndex);
        samlssoServiceProviderDO.setEnableAttributesByDefault(true);
        samlssoServiceProviderDO.setIssuer(issuer);
        samlssoServiceProviderDO.setAssertionConsumerUrls(acsList);
        org.powermock.api.mockito.PowerMockito.when(samlssoServiceProviderManager.getServiceProvider(org.mockito.ArgumentMatchers.eq(issuer), org.mockito.ArgumentMatchers.anyInt())).thenReturn(samlssoServiceProviderDO);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.internal.IdentitySAMLSSOServiceComponentHolder.getInstance()).thenReturn(identitySAMLSSOServiceComponentHolder);
        org.powermock.api.mockito.PowerMockito.when(identitySAMLSSOServiceComponentHolder.getSAMLSSOServiceProviderManager()).thenReturn(samlssoServiceProviderManager);
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{null},
        new java.lang.Object[]{"org.wso2.carbon.identity.sso.saml.validators.NonExistingClass"},
        new java.lang.Object[]{"org.wso2.carbon.identity.sso.saml.validators.SPInitSSOAuthnRequestValidator"}
        };
    }
}