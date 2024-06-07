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
public class TestProzeGen_SessionInfoData_removeServiceProvider_java_lang_String_SessionInfoDataTest_testRemoveServiceProvider {
    @org.mockito.Mock
    private org.wso2.carbon.identity.sso.saml.session.SessionInfoData sessionInfoData;

    @org.mockito.Mock
    private org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO samlssoServiceProviderDO;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws java.lang.Exception {
        sessionInfoData = new org.wso2.carbon.identity.sso.saml.session.SessionInfoData();
        samlssoServiceProviderDO = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        sessionInfoData.addServiceProvider("testUser", samlssoServiceProviderDO, null);
        sessionInfoData.addServiceProvider("testUser1", samlssoServiceProviderDO, "rpSessionId");
        sessionInfoData.setSubject("testUser", "subject");
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws java.lang.Exception {
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testRemoveServiceProvider(java.lang.String param0) throws java.lang.Exception {
        sessionInfoData.removeServiceProvider(param0);
        org.testng.Assert.assertFalse(sessionInfoData.getServiceProviderList().containsKey("testUser1"));
        org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().containsKey("testUser1"));
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testRemoveServiceProvider_1(java.lang.String param0) throws java.lang.Exception {
        sessionInfoData.removeServiceProvider(param0);
        org.testng.Assert.assertFalse(sessionInfoData.getServiceProviderList().containsKey("testUser1"));
        // org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().containsKey("testUser1"));
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testRemoveServiceProvider_2(java.lang.String param0) throws java.lang.Exception {
        sessionInfoData.removeServiceProvider(param0);
        // org.testng.Assert.assertFalse(sessionInfoData.getServiceProviderList().containsKey("testUser1"));
        org.testng.Assert.assertFalse(sessionInfoData.getRPSessionsList().containsKey("testUser1"));
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{"CONSOLE"},
        new java.lang.Object[]{"issuer"},
        new java.lang.Object[]{"issuer1"},
        new java.lang.Object[]{"issuer2"},
        new java.lang.Object[]{"issuerOne"},
        new java.lang.Object[]{"issuerTwo"},
        new java.lang.Object[]{"saml2-web-app-pickup-dispatch.com"},
        new java.lang.Object[]{"saml2-web-app-pickup-manager.com"},
        new java.lang.Object[]{"testUser1"}
        };
    }
}