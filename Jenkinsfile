#!/usr/bin/env groovy

node {
    git 'https://github.com/Dturati/estudos-JSF'
}

node {
    sh 'git pull origin master'
}

node {
    sh 'mvn clean install'
}

node {
    sh "chmod 777 -R target"
}


node {
    sh "cp target/maratona_jsf.war /home/david/Documentos/maratona_java/wildfly-11.0.0.Final/standalone/deployments"
}