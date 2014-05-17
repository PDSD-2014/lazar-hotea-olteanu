#!/bin/bash
# Generates a jar archive which contains all sources needed by Server
cp config.properties bin
cp json-simple-1.1.1.jar bin
cp mysql-connector-java-5.1.29-bin.jar bin
cd bin
jar cf ../server.jar json-simple-1.1.1.jar mysql-connector-java-5.1.29-bin.jar core/*.class db/*.class gameplay/*.class utils/*.class config.properties
rm config.properties
rm json-simple-1.1.1.jar
rm mysql-connector-java-5.1.29-bin.jar
