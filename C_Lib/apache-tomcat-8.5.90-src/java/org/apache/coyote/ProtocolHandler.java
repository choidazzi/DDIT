/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.coyote;

import java.util.concurrent.Executor;

import org.apache.tomcat.util.net.SSLHostConfig;

/**
 * Abstract the protocol implementation, including threading, etc. This is the main interface to be implemented by a
 * coyote protocol. Adapter is the main interface to be implemented by a coyote servlet container.
 *
 * @author Remy Maucherat
 * @author Costin Manolache
 *
 * @see Adapter
 */
public interface ProtocolHandler {

    /**
     * Return the adapter associated with the protocol handler.
     *
     * @return the adapter
     */
    Adapter getAdapter();


    /**
     * The adapter, used to call the connector.
     *
     * @param adapter The adapter to associate
     */
    void setAdapter(Adapter adapter);


    /**
     * The executor, provide access to the underlying thread pool.
     *
     * @return The executor used to process requests
     */
    Executor getExecutor();


    /**
     * Initialise the protocol.
     *
     * @throws Exception If the protocol handler fails to initialise
     */
    void init() throws Exception;


    /**
     * Start the protocol.
     *
     * @throws Exception If the protocol handler fails to start
     */
    void start() throws Exception;


    /**
     * Pause the protocol (optional).
     *
     * @throws Exception If the protocol handler fails to pause
     */
    void pause() throws Exception;


    /**
     * Resume the protocol (optional).
     *
     * @throws Exception If the protocol handler fails to resume
     */
    void resume() throws Exception;


    /**
     * Stop the protocol.
     *
     * @throws Exception If the protocol handler fails to stop
     */
    void stop() throws Exception;


    /**
     * Destroy the protocol (optional).
     *
     * @throws Exception If the protocol handler fails to destroy
     */
    void destroy() throws Exception;


    /**
     * Close the server socket (to prevent further connections) if the server socket was bound on {@link #start()}
     * (rather than on {@link #init()} but do not perform any further shutdown.
     */
    void closeServerSocketGraceful();


    /**
     * Wait for the client connections to the server to close gracefully. The method will return when all of the client
     * connections have closed or the method has been waiting for {@code waitTimeMillis}.
     *
     * @param waitMillis The maximum time to wait in milliseconds for the client connections to close.
     *
     * @return The wait time, if any remaining when the method returned
     */
    long awaitConnectionsClose(long waitMillis);


    /**
     * Requires APR/native library
     *
     * @return <code>true</code> if this Protocol Handler requires the APR/native library, otherwise <code>false</code>
     *
     * @deprecated This method will be removed in Tomcat 10.1.x onwards
     */
    @Deprecated boolean isAprRequired();


    /**
     * Does this ProtocolHandler support sendfile?
     *
     * @return <code>true</code> if this Protocol Handler supports sendfile, otherwise <code>false</code>
     */
    boolean isSendfileSupported();


    /**
     * Add a new SSL configuration for a virtual host.
     *
     * @param sslHostConfig the configuration
     */
    void addSslHostConfig(SSLHostConfig sslHostConfig);


    /**
     * Find all configured SSL virtual host configurations which will be used by SNI.
     *
     * @return the configurations
     */
    SSLHostConfig[] findSslHostConfigs();


    /**
     * Add a new protocol for used by HTTP/1.1 upgrade or ALPN.
     *
     * @param upgradeProtocol the protocol
     */
    void addUpgradeProtocol(UpgradeProtocol upgradeProtocol);


    /**
     * Return all configured upgrade protocols.
     *
     * @return the protocols
     */
    UpgradeProtocol[] findUpgradeProtocols();
}
