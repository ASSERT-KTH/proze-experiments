/* Copyright (c) 2017, WSO2 LLC. (http://www.wso2.org).

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
/**
 * Unit Tests for SAMLSSOService.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.identity.core.util.IdentityUtil.class, org.wso2.carbon.identity.sso.saml.util.SAMLSSOUtil.class, org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO.class, org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.class, org.wso2.carbon.identity.central.log.mgt.utils.LoggerUtils.class })
public class TestProzeGen_SSOSessionPersistenceManager_getSessionIndexFromTokenId_java_lang_String_java_lang_String_SAMLSSOServiceTest_testDoSingleLogout extends org.powermock.modules.testng.PowerMockTestCase {
    @org.testng.annotations.DataProvider(name = "testAuthenticate")
    public static java.lang.Object[][] isIDPInitSSOEnabled() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ true }, new java.lang.Object[]{ false } };
    }

    @org.testng.annotations.DataProvider(name = "testValidateSPInitSSORequestLogout")
    public static java.lang.Object[][] logoutRequests() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_POST_LOGOUT_REQUEST, null, true }, new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_REDIRECT_LOGOUT_REQUEST, org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_QUERY_STRING_FOR_REDIRECT_LOGOUT_REQUEST, false } };
    }

    @org.testng.annotations.DataProvider(name = "testValidateSPInitSSORequestAuthentication")
    public static java.lang.Object[][] authnRequests() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_POST_AUTHN_REQUEST, null, true }, new java.lang.Object[]{ org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_REDIRECT_AUTHN_REQUEST, org.wso2.carbon.identity.sso.saml.TestConstants.ENCODED_QUERY_STRING_FOR_AUTHN_REQUEST, false } };
    }

    @org.testng.annotations.DataProvider(name = "testValidateIdPInitSSORequestAuthentication")
    public static java.lang.Object[][] idpInitAuthRequests() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ true }, new java.lang.Object[]{ false } };
    }

    @org.testng.annotations.DataProvider(name = "testValidateIdPInitSSORequestLogout")
    public static java.lang.Object[][] idpInitLogoutRequests() {
        return new java.lang.Object[][]{ new java.lang.Object[]{ true }, new java.lang.Object[]{ false } };
    }

    @org.testng.annotations.ObjectFactory
    public org.testng.IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    private org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO mockValidSPInitLogoutRequestProcessing(java.lang.String ACSUrl) {
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO samlssoReqValidationResponseDTO = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO();
        samlssoReqValidationResponseDTO.setLogOutReq(true);
        samlssoReqValidationResponseDTO.setAssertionConsumerURL(ACSUrl);
        samlssoReqValidationResponseDTO.setValid(true);
        return samlssoReqValidationResponseDTO;
    }

    private org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO mockValidIDPInitLogoutRequestProcessing(java.lang.String returnToUrl) {
        org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO samlssoReqValidationResponseDTO = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO();
        samlssoReqValidationResponseDTO.setLogOutReq(true);
        samlssoReqValidationResponseDTO.setReturnToURL(returnToUrl);
        samlssoReqValidationResponseDTO.setValid(true);
        return samlssoReqValidationResponseDTO;
    }

    private org.wso2.carbon.identity.sso.saml.dto.SAMLSSORespDTO executeAuthenticate(org.wso2.carbon.identity.sso.saml.dto.SAMLSSOAuthnReqDTO authReqDTO) throws org.wso2.carbon.identity.base.IdentityException {
        org.wso2.carbon.identity.sso.saml.SAMLSSOService samlssoService = new org.wso2.carbon.identity.sso.saml.SAMLSSOService();
        return samlssoService.authenticate(authReqDTO, "1234", true, "fb", "basic");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testDoSingleLogout(java.lang.String param0, java.lang.String param1) throws java.lang.Exception {
        org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager ssoSessionPersistenceManager = org.powermock.api.mockito.PowerMockito.mock(org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.sso.saml.session.SSOSessionPersistenceManager.getPersistenceManager()).thenReturn(ssoSessionPersistenceManager);
        org.powermock.api.mockito.PowerMockito.when(ssoSessionPersistenceManager.getSessionIndexFromTokenId(param0, param1)).thenReturn("theSessionIndex");
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.central.log.mgt.utils.LoggerUtils.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.central.log.mgt.utils.LoggerUtils.isDiagnosticLogsEnabled()).thenReturn(true);
        org.wso2.carbon.identity.sso.saml.SAMLSSOService samlssoService = new org.wso2.carbon.identity.sso.saml.SAMLSSOService();
        org.testng.Assert.assertTrue(samlssoService.doSingleLogout("aSeesionID").isLogOutReq(), " Should return" + "SAMLSSOReqValidationResponseDTO where isLogOutReq is true");
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"39011ee9-4c05-4092-ac18-475ff558fb44-v2", "carbon.super"},
        new java.lang.Object[]{"52a46bc3-9225-433d-9090-4b41a6ccbf7e-v2", "carbon.super"},
        new java.lang.Object[]{"6f83baa2-2259-406e-ae70-9a0a57ccb37f-v2", "carbon.super"},
        new java.lang.Object[]{"", ""},
        new java.lang.Object[]{null, "carbon.super"},
        new java.lang.Object[]{"a0e95eb5-eeec-4f94-b4b3-e5a59268e20e-v2", "carbon.super"},
        new java.lang.Object[]{"samlssoTokenId", "carbon.super"},
        new java.lang.Object[]{"sessionId", "carbon.super"}
        };
    }
}