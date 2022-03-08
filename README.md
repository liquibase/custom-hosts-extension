# Liquibase Custom Hosts Extension
Create custom host entries during Liquibase runtime instead of configuring them on the host system (i.e. /etc/hosts)

# Installation
```shell
lpm add custom-hosts
```

# Usage
Add the `networking-hosts` property to your liquibase command. The value of this property needs to follow the `HOST:IP_ADDRESS` pattern. Multiple hosts are allowed with a comma separator (i.e. `not-a-domain:127.0.01,also-not-a-domain:127.0.0.1`).

### Possible formats:

cli: `--networking-hosts=PARAM`

properties file: `liquibase.networking.hosts= PARAM`

environment variable: `LIQUIBASE_NETWORKING_HOSTS=PARAM`