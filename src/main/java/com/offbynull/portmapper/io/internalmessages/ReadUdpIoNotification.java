/*
 * Copyright (c) 2013-2016, Kasra Faghihi, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.offbynull.portmapper.io.internalmessages;

import java.net.InetSocketAddress;
import java.util.Arrays;

public final class ReadUdpIoNotification extends IdentifiableIoNotification {
    private InetSocketAddress socketAddress;
    private byte[] data;

    public ReadUdpIoNotification(int id, InetSocketAddress socketAddress, byte[] data) {
        super(id);
        this.socketAddress = socketAddress;
        this.data = Arrays.copyOf(data, data.length);
    }

    public InetSocketAddress getSocketAddress() {
        return socketAddress;
    }

    public byte[] getData() {
        return Arrays.copyOf(data, data.length);
    }

}