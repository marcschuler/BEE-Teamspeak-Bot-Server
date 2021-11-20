# BeeBot

![Build](https://github.com/marcschuler/BEE-Teamspeak-Bot-Server/workflows/Maven%20Build/badge.svg)

## Setup

A example docker-compose.yml file is provided which should run out of the box with the included mongodb server. PLEASE
change the password.

The default port is 8080 and can either be changed with the SEVER_PORT environment variable or by changing the exposed
port on the docker-compose file.

### Manually generate a runnable jar file

That's fine too. Just compile voa ``mvn package -DskipTests``. The jar will be in the target folder. Then just run
``java -Dspring.data.mongodb.uri=mongodb://USERNAME:PASSWORD@localhost:27017/DATABASE -jar beebot-2.1.0.jar``

## Client

### Run the included client

The client is included via docker-compose file. Please be aware that the client and the server will serve unencrypted
data

### The hard way (with SSL)

An example implementation is available at https://beebot.karlthebee.de

If you run the Client from a HTTPS site (as above) you should run the BeeBot **Server** over SSL One option is to use an
Apache server with LetsEncrypt.

``ProxyPass /beebot http://127.0.0.1:8080/``

## Login

At first startup the server will generate a (SECRET) login token. The token will be saved on file ``token.txt`` and on
stdout on startup. You have to use the token to login in the client. To generate a new token, delete the ``token.txt`` file
and restart the server

## Dynamic Names

The Bot allows to use dynamic names. For example create an private channel worker with the following name
``Channel of %client_name%``
When a user joins, the bot will create a channel called _Channel of karlthebee_, because it replaces everything inside %
signs with actual data

| Id | Type|
|-----|-----|
|client_name| The name of the client|
|client_id|The client id (integer)|
|client_ip|The client ip address|
|client_uid|The client uid (string)|
|channel_name|The name of the current channel|
|channel_id|The id of the current channel (integer|
|\n|A new line|
|\t|A tab|