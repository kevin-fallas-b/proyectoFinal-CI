pipeline {
    agent any
    stages {
        stage('Maven steps'){
            agent {
               docker { image 'maven:3.8.5-eclipse-temurin-11-alpine' }
             }
            stages{
                stage('Install Dependencies') {
                    steps {
                        sh 'mvn dependency:resolve --no-transfer-progress'
                    }
                }

                stage('Unit Tests') {
                    steps {
                        sh 'mvn test --no-transfer-progress'
                    }
                }

                stage('Build') {
                    steps {
                        sh 'mvn clean install -DskipTests --no-transfer-progress'
                    }
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
