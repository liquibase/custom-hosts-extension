package org.liquibase.ext.networking;

import liquibase.repackaged.org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.validator.routines.InetAddressValidator;

public class Hosts {
    public Host[] hosts = {};

    public Hosts(String hostConfiguration) throws Exception {
        if (hostConfiguration.contains(",")) {
            String[] multiHosts = hostConfiguration.split(",");
            for (String h: multiHosts) {
                this.addToHosts(h);
            }
        } else {
            this.addToHosts(hostConfiguration);
        }
    }

    private void addToHosts(String hostConfiguration) throws Exception {
        String[] host = hostConfiguration.split(":");
        InetAddressValidator validator = new InetAddressValidator();
        if (!validator.isValid(host[1])) {
            throw new Exception(host[1] + " is not a valid IP Address");
        }
        this.hosts = ArrayUtils.add(this.hosts, new Host(host[0], host[1]));
    }

    public Host[] getHosts() {
        return this.hosts;
    }
}

