/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.codec;

import java.nio.ByteBuffer;

/**
 * In charge of encoding a message of type MESSAGE into another form (could be a {@link ByteBuffer} or any other
 * protocol level construction.
 * 
 * Must be immutable, a CONTEXT will be provided per session.
 * 
 * @param <INPUT> the incoming message to encode (your high level protocol Pojo/DTO)
 * @param <OUTPUT> the encoded message (the low level message, usually a {@link ByteBuffer})
 * @param <ENCODING_STATE> the context where to save the current encoding state (e.g. encoding context switching..)
 * 
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 * 
 */
public interface ProtocolEncoder<INPUT /* message type */, OUTPUT, ENCODING_STATE> {

    /**
     * Create a new session context for this decoder
     * 
     * @return the newly created context
     */
    ENCODING_STATE createEncoderState();

    /**
     * Encodes higher-level message objects of type <code>INPUT</code> into binary or protocol-specific data of type
     * <code>OUTPUT</code>.
     * 
     * @param message the message to encode
     * @param context the encoding context (will be stored in the session for the next decode call)
     */
    OUTPUT encode(INPUT message, ENCODING_STATE context);

}