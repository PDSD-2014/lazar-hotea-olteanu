#!/bin/bash
# Starts the server

java -cp server.jar:json-simple-1.1.1.jar:mysql-connector-java-5.1.29-bin.jar core.Server
