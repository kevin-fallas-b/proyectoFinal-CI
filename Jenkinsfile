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
                
                 stage('SonarQube Analysis') {
                     steps{
                        withSonarQubeEnv('sq-1') {
                          sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Proyecto-Kevin-Fallas"
                        }
                     }
                  }

                stage('Build') {
                    steps {
                        sh 'mvn clean install -DskipTests --no-transfer-progress'
                    }
                }
            }
        }
        
    }
}
