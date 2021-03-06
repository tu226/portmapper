/*
 * Copyright 2013-2016, Kasra Faghihi
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.offbynull.portmapper.gateways.process.internalmessages;

/**
 * Close a process. Only possible response is {@link CloseProcessResponse}.
 * @author Kasra Faghihi
 */
public final class CloseProcessRequest extends IdentifiableProcessResponse {

    /**
     * Constructs a {@link CloseProcessRequest}.
     * @param id id of process
     */
    public CloseProcessRequest(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "CloseProcessRequest{super=" + super.toString() + '}';
    }

}
