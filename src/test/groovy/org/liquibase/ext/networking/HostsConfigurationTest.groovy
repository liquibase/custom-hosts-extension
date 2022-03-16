package org.liquibase.ext.networking

import spock.lang.Specification

class HostsConfigurationTest extends Specification {
    def "empty"(){
        when:
            def hosts = HostsConfiguration.HOSTS

        then:
            hosts.getCurrentValue() == null
            hosts.getDescription() == "Comma seperated list of HOST:IP_ADDRESS entries for custom Hostnames."
    }
}
