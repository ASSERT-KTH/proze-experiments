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
package org.wso2.carbon.identity.sso.saml.extension.eidas;
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "org.mockito.*", "javax.xml.*", "org.xml.*", "org.apache.xerces.*", "org.w3c.dom.*" })
public class TestProzeGen_SAMLSSOReqValidationResponseDTO_setPassive_boolean_EidasExtensionProcessorTest_testProcessSAMLExtensions {
    @org.mockito.InjectMocks
    org.wso2.carbon.identity.sso.saml.extension.eidas.EidasExtensionProcessor eidasExtensionProcessor;

    @org.mockito.Mock
    org.opensaml.saml.saml2.core.RequestAbstractType request;

    @org.mockito.Mock
    org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO validationResp;

    @org.testng.annotations.BeforeMethod
    public void init() throws java.lang.Exception {
        eidasExtensionProcessor = new org.wso2.carbon.identity.sso.saml.extension.eidas.EidasExtensionProcessor();
        java.lang.String requestFile = "src/test/resources/sample_eidas_request.xml";
        request = ((org.opensaml.saml.saml2.core.AuthnRequest) (org.wso2.carbon.identity.sso.saml.TestUtils.unmarshallElement(requestFile)));
        validationResp = new org.wso2.carbon.identity.sso.saml.dto.SAMLSSOReqValidationResponseDTO();
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testProcessSAMLExtensions(boolean param0) throws org.wso2.carbon.identity.base.IdentityException {
        validationResp.setValid(true);
        validationResp.setForceAuthn(true);
        validationResp.setPassive(param0);
        validationResp.setRequestedAuthnContextComparison(org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration.MINIMUM.toString());
        eidasExtensionProcessor.processSAMLExtensions(request, validationResp);
        org.testng.Assert.assertEquals(validationResp.getProperties().get(org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_REQUEST), org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_PREFIX, "Error in setting the request type.");
        org.testng.Assert.assertTrue(validationResp.isValid(), "Error when validating the SAML extensions in request");
        org.testng.Assert.assertNotEquals(validationResp.getRequestedAttributes().size(), 0, "Error in processing " + "and setting the requested attributes retrieved in request.");
        org.w3c.dom.NodeList requestedAttrs = request.getExtensions().getUnknownXMLObjects(org.wso2.carbon.identity.sso.saml.extension.eidas.model.RequestedAttributes.DEFAULT_ELEMENT_NAME).get(0).getDOM().getChildNodes();
        org.testng.Assert.assertEquals(requestedAttrs.getLength(), validationResp.getRequestedAttributes().size(), "Error in " + "processing and setting the requested attributes retrieved in request.");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testProcessSAMLExtensions_1(boolean param0) throws org.wso2.carbon.identity.base.IdentityException {
        validationResp.setValid(true);
        validationResp.setForceAuthn(true);
        validationResp.setPassive(param0);
        validationResp.setRequestedAuthnContextComparison(org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration.MINIMUM.toString());
        eidasExtensionProcessor.processSAMLExtensions(request, validationResp);
        org.testng.Assert.assertEquals(validationResp.getProperties().get(org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_REQUEST), org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_PREFIX, "Error in setting the request type.");
        // org.testng.Assert.assertTrue(validationResp.isValid(), "Error when validating the SAML extensions in request");
        // org.testng.Assert.assertNotEquals(validationResp.getRequestedAttributes().size(), 0, "Error in processing " + "and setting the requested attributes retrieved in request.");
        org.w3c.dom.NodeList requestedAttrs = request.getExtensions().getUnknownXMLObjects(org.wso2.carbon.identity.sso.saml.extension.eidas.model.RequestedAttributes.DEFAULT_ELEMENT_NAME).get(0).getDOM().getChildNodes();
        // org.testng.Assert.assertEquals(requestedAttrs.getLength(), validationResp.getRequestedAttributes().size(), "Error in " + "processing and setting the requested attributes retrieved in request.");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testProcessSAMLExtensions_2(boolean param0) throws org.wso2.carbon.identity.base.IdentityException {
        validationResp.setValid(true);
        validationResp.setForceAuthn(true);
        validationResp.setPassive(param0);
        validationResp.setRequestedAuthnContextComparison(org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration.MINIMUM.toString());
        eidasExtensionProcessor.processSAMLExtensions(request, validationResp);
        // org.testng.Assert.assertEquals(validationResp.getProperties().get(org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_REQUEST), org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_PREFIX, "Error in setting the request type.");
        org.testng.Assert.assertTrue(validationResp.isValid(), "Error when validating the SAML extensions in request");
        // org.testng.Assert.assertNotEquals(validationResp.getRequestedAttributes().size(), 0, "Error in processing " + "and setting the requested attributes retrieved in request.");
        org.w3c.dom.NodeList requestedAttrs = request.getExtensions().getUnknownXMLObjects(org.wso2.carbon.identity.sso.saml.extension.eidas.model.RequestedAttributes.DEFAULT_ELEMENT_NAME).get(0).getDOM().getChildNodes();
        // org.testng.Assert.assertEquals(requestedAttrs.getLength(), validationResp.getRequestedAttributes().size(), "Error in " + "processing and setting the requested attributes retrieved in request.");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testProcessSAMLExtensions_3(boolean param0) throws org.wso2.carbon.identity.base.IdentityException {
        validationResp.setValid(true);
        validationResp.setForceAuthn(true);
        validationResp.setPassive(param0);
        validationResp.setRequestedAuthnContextComparison(org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration.MINIMUM.toString());
        eidasExtensionProcessor.processSAMLExtensions(request, validationResp);
        // org.testng.Assert.assertEquals(validationResp.getProperties().get(org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_REQUEST), org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_PREFIX, "Error in setting the request type.");
        // org.testng.Assert.assertTrue(validationResp.isValid(), "Error when validating the SAML extensions in request");
        org.testng.Assert.assertNotEquals(validationResp.getRequestedAttributes().size(), 0, "Error in processing " + "and setting the requested attributes retrieved in request.");
        org.w3c.dom.NodeList requestedAttrs = request.getExtensions().getUnknownXMLObjects(org.wso2.carbon.identity.sso.saml.extension.eidas.model.RequestedAttributes.DEFAULT_ELEMENT_NAME).get(0).getDOM().getChildNodes();
        // org.testng.Assert.assertEquals(requestedAttrs.getLength(), validationResp.getRequestedAttributes().size(), "Error in " + "processing and setting the requested attributes retrieved in request.");
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testProcessSAMLExtensions_4(boolean param0) throws org.wso2.carbon.identity.base.IdentityException {
        validationResp.setValid(true);
        validationResp.setForceAuthn(true);
        validationResp.setPassive(param0);
        validationResp.setRequestedAuthnContextComparison(org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration.MINIMUM.toString());
        eidasExtensionProcessor.processSAMLExtensions(request, validationResp);
        // org.testng.Assert.assertEquals(validationResp.getProperties().get(org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_REQUEST), org.wso2.carbon.identity.sso.saml.extension.eidas.util.EidasConstants.EIDAS_PREFIX, "Error in setting the request type.");
        // org.testng.Assert.assertTrue(validationResp.isValid(), "Error when validating the SAML extensions in request");
        // org.testng.Assert.assertNotEquals(validationResp.getRequestedAttributes().size(), 0, "Error in processing " + "and setting the requested attributes retrieved in request.");
        org.w3c.dom.NodeList requestedAttrs = request.getExtensions().getUnknownXMLObjects(org.wso2.carbon.identity.sso.saml.extension.eidas.model.RequestedAttributes.DEFAULT_ELEMENT_NAME).get(0).getDOM().getChildNodes();
        org.testng.Assert.assertEquals(requestedAttrs.getLength(), validationResp.getRequestedAttributes().size(), "Error in " + "processing and setting the requested attributes retrieved in request.");
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{false},
        new java.lang.Object[]{true}
        };
    }
}