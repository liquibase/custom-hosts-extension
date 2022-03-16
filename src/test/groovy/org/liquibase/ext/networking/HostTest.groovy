package org.liquibase.ext.networking

import spock.lang.Specification

class HostTest extends Specification {
    def "can config host"() {
        when:
            def host = new Host("hostname", "127.0.0.1")
        then:
            host.getName() == "hostname"
            host.getIp() == "127.0.0.1"
    }
}
