# Liquibase Custom Hosts Extension
![Community](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/mcred/liquibase-header-footer/feature/badges/badges/community.json)
![Pro](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/mcred/liquibase-header-footer/feature/badges/badges/pro.json)

Create custom host entries during Liquibase runtime instead of configuring them on the host system (i.e. /etc/hosts)

# Installation
The easiest way to install this extension is with `lpm` [liquibase package manager](https://github.com/liquibase/liquibase-package-manager).
```shell
lpm update
lpm add custom-hosts
```

# Usage
Add the `networking-hosts` property to your liquibase command. The value of this property needs to follow the `HOST:IP_ADDRESS` pattern. Multiple hosts are allowed with a comma separator (i.e. `not-a-domain:127.0.01,also-not-a-domain:127.0.0.1`).

### Possible formats:

cli: `--networking-hosts=PARAM`

properties file: `liquibase.networking.hosts= PARAM`

environment variable: `LIQUIBASE_NETWORKING_HOSTS=PARAM`

# Example
```shell
liquibase --url jdbc:postgresql://not-a-domain:5432/postgres --networking-hosts=not-a-domain:127.0.0.1 status

####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ## 
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ## 
##  Free schema change activity reports at        ##
##      https://hub.liquibase.com                 ##
##                                                ##
####################################################
Starting Liquibase at 11:31:57 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
Liquibase Version: 4.8.0
Liquibase Community 4.8.0 by Liquibase
1 change sets have not been applied to postgres@jdbc:postgresql://not-a-domain:5432/postgres
Liquibase command 'status' was executed successfully.
```