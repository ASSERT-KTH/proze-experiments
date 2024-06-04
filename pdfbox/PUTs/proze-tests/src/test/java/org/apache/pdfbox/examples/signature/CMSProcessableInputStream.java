/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.examples.signature;
/**
 * Wraps a InputStream into a CMSProcessable object for bouncy castle. It's a memory saving
 * alternative to the {@link org.bouncycastle.cms.CMSProcessableByteArray CMSProcessableByteArray}
 * class.
 *
 * @author Thomas Chojecki
 */
class CMSProcessableInputStream implements org.bouncycastle.cms.CMSTypedData {
    private java.io.InputStream in;

    private final org.bouncycastle.asn1.ASN1ObjectIdentifier contentType;

    CMSProcessableInputStream(java.io.InputStream is) {
        this(new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data.getId()), is);
    }

    CMSProcessableInputStream(org.bouncycastle.asn1.ASN1ObjectIdentifier type, java.io.InputStream is) {
        contentType = type;
        in = is;
    }

    @Override
    public Object getContent() {
        return in;
    }

    @Override
    public void write(java.io.OutputStream out) throws java.io.IOException, org.bouncycastle.cms.CMSException {
        // read the content only one time
        org.apache.pdfbox.io.IOUtils.copy(in, out);
        in.close();
    }

    @Override
    public org.bouncycastle.asn1.ASN1ObjectIdentifier getContentType() {
        return contentType;
    }
}