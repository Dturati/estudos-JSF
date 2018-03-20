#!/usr/bin/env groovy

node {
    sh 'mvn clean install'
}

node {
    sh "chmod 777 -R target"
}


node {
    sh "cp target/maratona_jsf.war /home/david/Documentos/maratona_java/wildfly-11.0.0.Final/standalone/deployments"
}