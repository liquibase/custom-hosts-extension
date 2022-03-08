package org.liquibase.ext.networking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostTest {
    private Host host = new Host("hostname", "127.0.0.1");

    @Test
    void canGetHostname() {
        assertEquals("hostname", host.getName());
    }

    @Test
    void canGetIp() {
        assertEquals("127.0.0.1", host.getIp());
    }
}