package org.liquibase.ext.networking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HostsTest {

    private final String oneHost = "not-a-domain:127.0.0.1";
    private final String multiHost = "not-a-domain:127.0.0.1,also-not-a-domain:127.0.0.1";
    private final String invalidIPv4 = "invalid:444.555.666.777";
    private final String invalidIPv6 = "invalid:ffff:ffff:ffff:gggg:ffff:ffff:ffff:ffff";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void canLoadHosts() throws Exception {
        Hosts hosts = new Hosts(oneHost);
        assertInstanceOf(Hosts.class, hosts);
    }

    @Test
    void canLoadMultiHosts() throws Exception {
        Hosts hosts = new Hosts(multiHost);
        assertEquals(2, hosts.getHosts().length);
    }

    @Test
    void canCatchInvalidIPv4() {
        assertThrows(Exception.class, () -> {
            Hosts hosts = new Hosts(invalidIPv4);
        });
    }

    @Test
    void canCatchInvalidIPv6() {
        assertThrows(Exception.class, () -> {
            Hosts hosts = new Hosts(invalidIPv6);
        });
    }
}