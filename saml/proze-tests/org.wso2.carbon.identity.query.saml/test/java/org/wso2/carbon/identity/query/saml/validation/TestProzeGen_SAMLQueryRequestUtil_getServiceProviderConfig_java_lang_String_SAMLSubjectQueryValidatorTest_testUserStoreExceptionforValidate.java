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
package org.wso2.carbon.identity.query.saml.validation;
/**
 * Test Class for the SAMLSubjectQueryValidator.
 */
@org.powermock.core.classloader.annotations.PrepareForTest({ org.wso2.carbon.utils.multitenancy.MultitenantUtils.class, org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.class, org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class, org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class })
@org.powermock.core.classloader.annotations.PowerMockIgnore({ "javax.xml.*", "org.xml.*", "org.w3c.dom.*" })
public class TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate extends org.powermock.modules.testng.PowerMockTestCase {
    @org.mockito.Mock
    org.wso2.carbon.user.core.service.RealmService testRealmService;

    @org.mockito.Mock
    org.wso2.carbon.user.core.UserRealm testUserRealm;

    @org.mockito.Mock
    org.wso2.carbon.user.core.UserStoreManager testuserStoreManager;

    org.wso2.carbon.identity.query.saml.validation.SAMLSubjectQueryValidator testsamlSubjectQueryValidator = new org.wso2.carbon.identity.query.saml.validation.SAMLSubjectQueryValidator();

    java.util.List<org.wso2.carbon.identity.query.saml.dto.InvalidItemDTO> invalidItems = new java.util.ArrayList<>();

    @org.testng.annotations.BeforeClass
    public void setUp() {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.initPrivilegedCarbonContext("testDomain", 1, "testuser");
    }

    @org.testng.annotations.AfterClass
    public void tearDown() {
        org.wso2.carbon.identity.query.saml.validation.TestUtil.stopPrivilegedCarbonContext();
    }

    @org.testng.annotations.DataProvider(name = "provideSubectQuery")
    public java.lang.Object[][] createSubjectQuery() {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID dumID1 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID dumID2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID dumID3 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID();
        dumID1.setFormat("failtest");
        dumID2.setFormat("test");
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject dumSub1 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject dumSub2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject dumSub3 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject dumSub4 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject();
        dumSub2.setNameID(dumID1);
        dumSub3.setNameID(dumID2);
        dumSub4.setNameID(dumID3);
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer1 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer3 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer4 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer6 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        issuer1.setValue("test");
        issuer2.setValue("test");
        issuer3.setValue("test");
        issuer4.setValue("test");
        issuer5.setValue("test");
        issuer6.setValue("test");
        issuer1.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        issuer2.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        issuer3.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        issuer4.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        issuer5.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        issuer6.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ1 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ3 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ4 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ5 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ6 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        dumSQ2.setSubject(dumSub1);
        dumSQ3.setSubject(dumSub2);
        dumSQ4.setSubject(dumSub3);
        dumSQ5.setSubject(dumSub4);
        dumSQ1.setIssuer(issuer1);
        dumSQ2.setIssuer(issuer2);
        dumSQ3.setIssuer(issuer3);
        dumSQ4.setIssuer(issuer4);
        dumSQ5.setIssuer(issuer5);
        dumSQ6.setIssuer(issuer6);
        dumSQ1.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        dumSQ2.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        dumSQ3.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        dumSQ4.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        dumSQ5.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        dumSQ6.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_10);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs1 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs2 = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        ssoIdpConfigs1.setCertAlias("test");
        ssoIdpConfigs1.setAssertionQueryRequestProfileEnabled(true);
        ssoIdpConfigs2.setNameIDFormat("test");
        ssoIdpConfigs2.setCertAlias("test");
        ssoIdpConfigs2.setAssertionQueryRequestProfileEnabled(true);
        return new java.lang.Object[][]{ new java.lang.Object[]{ dumSQ1, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ6, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ2, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ3, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ4, false, ssoIdpConfigs1 }, new java.lang.Object[]{ dumSQ5, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ4, false, ssoIdpConfigs2 }, new java.lang.Object[]{ dumSQ4, true, ssoIdpConfigs2 } };
    }

    @org.testng.annotations.Test(dataProvider = "provideProzeArguments")
    public void testUserStoreExceptionforValidate(java.lang.String param0) throws org.wso2.carbon.identity.query.saml.exception.IdentitySAML2QueryException, org.wso2.carbon.user.api.UserStoreException {
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID dumID2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyNameID();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject dumSub = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubject();
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery dumSQ2 = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummySubjectQuery();
        dumID2.setFormat("test");
        dumSub.setNameID(dumID2);
        dumSQ2.setSubject(dumSub);
        org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer issuer = new org.wso2.carbon.identity.query.saml.validation.TestProzeGen_SAMLQueryRequestUtil_getServiceProviderConfig_java_lang_String_SAMLSubjectQueryValidatorTest_testUserStoreExceptionforValidate.DummyIssuer();
        issuer.setValue("test");
        issuer.setFormat(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestConstants.GenericConstants.ISSUER_FORMAT);
        dumSQ2.setIssuer(issuer);
        dumSQ2.setVersion(org.opensaml.saml.common.SAMLVersion.VERSION_20);
        org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO ssoIdpConfigs = new org.wso2.carbon.identity.core.model.SAMLSSOServiceProviderDO();
        ssoIdpConfigs.setNameIDFormat("test");
        ssoIdpConfigs.setCertAlias("test");
        ssoIdpConfigs.setAssertionQueryRequestProfileEnabled(true);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.utils.multitenancy.MultitenantUtils.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.class);
        org.powermock.api.mockito.PowerMockito.mockStatic(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.class);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.SAMLQueryRequestUtil.getServiceProviderConfig(param0)).thenReturn(ssoIdpConfigs);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.util.OpenSAML3Util.validateXMLSignature(((org.opensaml.saml.saml2.core.RequestAbstractType) (org.mockito.ArgumentMatchers.any())), org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.utils.multitenancy.MultitenantUtils.getTenantAwareUsername(org.mockito.ArgumentMatchers.anyString())).thenReturn("test");
        org.powermock.api.mockito.PowerMockito.when(testRealmService.getTenantUserRealm(org.mockito.ArgumentMatchers.anyInt())).thenReturn(testUserRealm);
        org.powermock.api.mockito.PowerMockito.when(testUserRealm.getUserStoreManager()).thenReturn(testuserStoreManager);
        org.powermock.api.mockito.PowerMockito.when(org.wso2.carbon.identity.query.saml.internal.SAMLQueryServiceComponent.getRealmservice()).thenReturn(testRealmService);
        org.powermock.api.mockito.PowerMockito.when(testuserStoreManager.isExistingUser(org.mockito.ArgumentMatchers.anyString())).thenThrow(new org.wso2.carbon.user.core.UserStoreException());
        testsamlSubjectQueryValidator.validate(invalidItems, dumSQ2);
    }

    class DummySubjectQuery extends org.opensaml.saml.saml2.core.impl.SubjectQueryImpl {
        protected DummySubjectQuery() {
            super("testNSU", "testELN", "testNSP");
        }

        org.opensaml.saml.saml2.core.Subject subject;

        @java.lang.Override
        public void setSubject(org.opensaml.saml.saml2.core.Subject subject) {
            this.subject = subject;
        }

        @java.lang.Override
        public org.opensaml.saml.saml2.core.Subject getSubject() {
            return subject;
        }
    }

    class DummySubject extends org.opensaml.saml.saml2.core.impl.SubjectImpl {
        protected DummySubject() {
            super("testNSU", "testELN", "testNSP");
        }

        org.opensaml.saml.saml2.core.NameID nameID;

        @java.lang.Override
        public void setNameID(org.opensaml.saml.saml2.core.NameID newNameID) {
            nameID = newNameID;
        }

        @java.lang.Override
        public org.opensaml.saml.saml2.core.NameID getNameID() {
            return nameID;
        }
    }

    class DummyNameID extends org.opensaml.saml.saml2.core.impl.NameIDImpl {
        protected DummyNameID() {
            super("testNSU", "testELN", "testNSP");
        }

        java.lang.String format;

        java.lang.String value;

        @java.lang.Override
        public void setFormat(java.lang.String newFormat) {
            format = newFormat;
            value = newFormat;
        }

        @java.lang.Override
        public java.lang.String getFormat() {
            return format;
        }

        @java.lang.Override
        public java.lang.String getValue() {
            return value;
        }
    }

    class DummyIssuer extends org.opensaml.saml.saml2.core.impl.IssuerImpl {
        protected DummyIssuer() {
            super("testNSU", "testELN", "testNSP");
        }
    }

    @org.testng.annotations.DataProvider(name = "provideProzeArguments")
    private static java.lang.Object[][] values() {
        return new java.lang.Object[][]{
        new java.lang.Object[]{""},
        new java.lang.Object[]{"failtest"},
        new java.lang.Object[]{"test"}
        };
    }
}