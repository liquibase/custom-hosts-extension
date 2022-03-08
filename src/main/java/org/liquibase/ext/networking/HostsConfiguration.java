package org.liquibase.ext.networking;

import liquibase.configuration.AutoloadedConfigurations;
import liquibase.configuration.ConfigurationDefinition;

public class HostsConfiguration implements AutoloadedConfigurations {
    public static ConfigurationDefinition<String> HOSTS;

    static {
        ConfigurationDefinition.Builder builder = new ConfigurationDefinition.Builder("liquibase.networking");
        HOSTS = builder.define("hosts", String.class)
                .setDescription("Comma seperated list of HOST:IP_ADDRESS entries for custom Hostnames.")
                .build();
    }
}
