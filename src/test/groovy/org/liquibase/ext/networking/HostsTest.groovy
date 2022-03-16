package org.liquibase.ext.networking

import groovy.test.GroovyAssert
import spock.lang.Specification

class HostsTest extends Specification {

    def oneHost
    def multiHost
    def invalidIPv4
    def invalidIPv6

    def setup() {
        oneHost = "not-a-domain:127.0.0.1";
        multiHost = "not-a-domain:127.0.0.1,also-not-a-domain:127.0.0.1";
        invalidIPv4 = "invalid:444.555.666.777";
        invalidIPv6 = "invalid:ffff:ffff:ffff:gggg:ffff:ffff:ffff:ffff";
    }

    def "can load hosts"() {
        when:
            def hosts = new Hosts(oneHost)
        then:
            assert hosts instanceof Hosts
    }

    def "can load multihosts"(){
        when:
            def hosts = new Hosts(multiHost)
        then:
            hosts.getHosts().length == 2
    }

    def "can catch invalid IPv4"(){
        expect:
            GroovyAssert.shouldFail {new Hosts(invalidIPv4)}
    }

    def "can catch invalid IPv6"(){
        expect:
            GroovyAssert.shouldFail {new Hosts(invalidIPv6)}
    }
}