#!/usr/bin/env groovy

pipeline {
    agent any

    stages{

        stage('git'){
            steps{
                git 'https://github.com/Dturati/estudos-JSF'
            }
        }

        stage('git pull'){
            steps{
                sh 'git config --global user.email "davidturati@gmail.com"'
                sh 'git config --global user.name "Dturati'
                sh 'git pull origin versao-0.1'
            }
        }

        stage('Build com maven'){
            steps{
                sh 'sudo mvn clean install'
            }
        }

        stage('Deploy:copiando war'){
            steps{
                sh "sudo cp target/maratona_jsf.war /home/david/Documentos/maratona_java/wildfly-11.0.0.Final/standalone/deployments"
            }
        }
    }

    post{
        success {
                step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'davidturati@gmail.com', sendToIndividuals: true])
        }
    }

}
