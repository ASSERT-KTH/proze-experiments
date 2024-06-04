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
import java.io.IOException;
/**
 * Time Stamping Authority (TSA) Client [RFC 3161].
 *
 * @author Vakhtang Koroghlishvili
 * @author John Hewson
 */
public class TSAClient {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(TSAClient.class);

    private final java.net.URL url;

    private final String username;

    private final String password;

    private final java.security.MessageDigest digest;

    // SecureRandom.getInstanceStrong() would be better, but sometimes blocks on Linux
    private static final java.util.Random RANDOM = new java.security.SecureRandom();

    /**
     *
     * @param url
     * 		the URL of the TSA service
     * @param username
     * 		user name of TSA
     * @param password
     * 		password of TSA
     * @param digest
     * 		the message digest to use
     */
    public TSAClient(java.net.URL url, String username, String password, java.security.MessageDigest digest) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.digest = digest;
    }

    /**
     *
     * @param content
     * @return the time stamp token
     * @throws IOException
     * 		if there was an error with the connection or data from the TSA server,
     * 		or if the time stamp response could not be validated
     */
    public org.bouncycastle.tsp.TimeStampToken getTimeStampToken(byte[] content) throws IOException {
        digest.reset();
        byte[] hash = digest.digest(content);
        // 32-bit cryptographic nonce
        int nonce = TSAClient.RANDOM.nextInt();
        // generate TSA request
        org.bouncycastle.tsp.TimeStampRequestGenerator tsaGenerator = new org.bouncycastle.tsp.TimeStampRequestGenerator();
        tsaGenerator.setCertReq(true);
        org.bouncycastle.asn1.ASN1ObjectIdentifier oid = getHashObjectIdentifier(digest.getAlgorithm());
        org.bouncycastle.tsp.TimeStampRequest request = tsaGenerator.generate(oid, hash, java.math.BigInteger.valueOf(nonce));
        // get TSA response
        byte[] tsaResponse = getTSAResponse(request.getEncoded());
        org.bouncycastle.tsp.TimeStampResponse response;
        try {
            response = new org.bouncycastle.tsp.TimeStampResponse(tsaResponse);
            response.validate(request);
        } catch (org.bouncycastle.tsp.TSPException e) {
            throw new IOException(e);
        }
        org.bouncycastle.tsp.TimeStampToken timeStampToken = response.getTimeStampToken();
        if (timeStampToken == null) {
            // https://www.ietf.org/rfc/rfc3161.html#section-2.4.2
            throw new IOException(((((("Response from " + url) + " does not have a time stamp token, status: ") + response.getStatus()) + " (") + response.getStatusString()) + ")");
        }
        return timeStampToken;
    }

    // gets response data for the given encoded TimeStampRequest data
    // throws IOException if a connection to the TSA cannot be established
    private byte[] getTSAResponse(byte[] request) throws IOException {
        TSAClient.LOG.debug("Opening connection to TSA server");
        // todo: support proxy servers
        java.net.URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/timestamp-query");
        TSAClient.LOG.debug("Established connection to TSA server");
        if ((((username != null) && (password != null)) && (!username.isEmpty())) && (!password.isEmpty())) {
            // See https://stackoverflow.com/questions/12732422/ (needs jdk8)
            // or see implementation in 3.0
            throw new UnsupportedOperationException("authentication not implemented yet");
        }
        // read response
        java.io.OutputStream output = null;
        try {
            output = connection.getOutputStream();
            output.write(request);
        } catch (IOException ex) {
            TSAClient.LOG.error("Exception when writing to " + this.url, ex);
            throw ex;
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(output);
        }
        TSAClient.LOG.debug("Waiting for response from TSA server");
        java.io.InputStream input = null;
        byte[] response;
        try {
            input = connection.getInputStream();
            response = org.apache.pdfbox.io.IOUtils.toByteArray(input);
        } catch (IOException ex) {
            TSAClient.LOG.error("Exception when reading from " + this.url, ex);
            throw ex;
        } finally {
            org.apache.pdfbox.io.IOUtils.closeQuietly(input);
        }
        TSAClient.LOG.debug("Received response from TSA server");
        return response;
    }

    // returns the ASN.1 OID of the given hash algorithm
    private org.bouncycastle.asn1.ASN1ObjectIdentifier getHashObjectIdentifier(String algorithm) {
        if (algorithm.equals("MD2")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.md2.getId());
        } else if (algorithm.equals("MD5")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.md5.getId());
        } else if (algorithm.equals("SHA-1")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.oiw.OIWObjectIdentifiers.idSHA1.getId());
        } else if (algorithm.equals("SHA-224")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.nist.NISTObjectIdentifiers.id_sha224.getId());
        } else if (algorithm.equals("SHA-256")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.nist.NISTObjectIdentifiers.id_sha256.getId());
        } else if (algorithm.equals("SHA-384")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.nist.NISTObjectIdentifiers.id_sha384.getId());
        } else if (algorithm.equals("SHA-512")) {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(org.bouncycastle.asn1.nist.NISTObjectIdentifiers.id_sha512.getId());
        } else {
            return new org.bouncycastle.asn1.ASN1ObjectIdentifier(algorithm);
        }
    }
}