package org.liquibase.ext.networking;

import com.alibaba.dcm.DnsCacheManipulator;
import liquibase.Scope;
import liquibase.command.AbstractCommandStep;
import liquibase.command.CommandDefinition;
import liquibase.command.CommandResultsBuilder;
import liquibase.ui.UIService;

public class HostsCreateCommandStep extends AbstractCommandStep {

    @Override
    public String[][] defineCommandNames() {
        return new String[0][];
    }

    @Override
    public int getOrder(CommandDefinition commandDefinition) {
        return 1;
    }

    @Override
    public void run(CommandResultsBuilder commandResultsBuilder) throws Exception {
        UIService ui = Scope.getCurrentScope().getUI();
        Hosts hosts = new Hosts(HostsConfiguration.HOSTS.getCurrentValue());
        for(Host host: hosts.getHosts()) {
            try {
                DnsCacheManipulator.setDnsCache(host.getName(), host.getIp());
            } catch (Exception e) {
                ui.sendErrorMessage(e.getMessage());
                throw new Exception(e);
            }
        }
    }
}
