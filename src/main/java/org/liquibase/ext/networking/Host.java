package org.liquibase.ext.networking;

public class Host {
    private final String name;
    private final String ip;

    public Host(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
}

