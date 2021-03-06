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
                
            }
            
        }
         stage('Deploy'){
            steps{
                
                script {
                    if (env.BRANCH_NAME == 'main') {
                        deploy adapters: [tomcat9(url: 'http://54.158.155.126:8080', 
                            credentialsId: 'tomcat')], 
                            contextPath: 'proyectoFinal',   
                            war: 'target/*.war'
                        echo 'War file deployed on production server'
                    } else {
                        echo 'Skipping deploy - Non production environment'
                    }
                }
                
                
                
            }
        }
    }
}
