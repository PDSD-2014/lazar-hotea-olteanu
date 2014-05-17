#!/bin/bash
# Starts the server

java -cp bin/server.jar:bin/json-simple-1.1.1.jar:bin/mysql-connector-java-5.1.29-bin.jar core.Server
