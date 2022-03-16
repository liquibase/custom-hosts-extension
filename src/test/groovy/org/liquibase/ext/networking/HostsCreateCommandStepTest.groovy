package org.liquibase.ext.networking

import liquibase.Scope
import liquibase.command.CommandResultsBuilder
import liquibase.command.CommandScope
import spock.lang.Specification

class HostsCreateCommandStepTest extends Specification {

    def "can configure host"(){
        when:
            Scope.child([
                    (HostsConfiguration.HOSTS.key): "not-a-domain:127.0.0.1"
            ], { ->
                def createHostsCommand = new HostsCreateCommandStep()
                def outputStream = new ByteArrayOutputStream()
                def builder = new CommandResultsBuilder(new CommandScope("mock"), outputStream)
                createHostsCommand.run(builder)
            } as Scope.ScopedRunner)

        then:
            InetAddress.getByName("not-a-domain").getHostAddress() == "127.0.0.1"
    }
}
