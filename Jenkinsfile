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
                          sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Proyecto-Kevin-Fallas --no-transfer-progress"
                        }
                     }
                  }

                stage('Build') {
                    steps {
                        sh 'mvn clean install -DskipTests --no-transfer-progress'
                    }
                }
                
                stage('Deploy'){
                    steps{
                        deploy adapters: [tomcat8(url: 'http://44.204.40.132:8080/', 
                                  credentialsId: 'tomcat')], 
                         war: 'target/*.war',
                         contextPath: '/appKevin'
                    }
                }
            }
        }
        
    }
}
