pipeline {
    agent any
    stages {
        stage('Maven steps'){
            agent {
               docker { image 'maven:3.8.5-eclipse-temurin-11-alpine' }
             }
            stage('Install Dependencies') {
                steps {
                    sh 'mvn dependency:resolve'
                }
            }

            stage('Unit Tests') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Build') {
                steps {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }
        stage('SAST') {
                steps {
                    echo 'npm run sonar'
                }
            }
    }
}
