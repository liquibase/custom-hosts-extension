package org.liquibase.ext.networking

import liquibase.Scope
import liquibase.command.CommandResultsBuilder
import liquibase.command.CommandScope
import spock.lang.Specification

class HostsCleanupCommandStepTest extends Specification {

    def "can cleanup host"(){
        when:
            Scope.child([
                    (HostsConfiguration.HOSTS.key): "not-a-domain:127.0.0.1"
            ], { ->

                def createHostsCommand = new HostsCreateCommandStep()
                def cleanHostsCommand = new HostsCleanupCommandStep()
                def outputStream = new ByteArrayOutputStream()
                def builder = new CommandResultsBuilder(new CommandScope("mock"), outputStream)
                createHostsCommand.run(builder)
                cleanHostsCommand.run(builder)
            } as Scope.ScopedRunner)

        then:
            GroovyAssert.shouldFail {InetAddress.getByName("not-a-domain").getHostAddress()}
    }
}
