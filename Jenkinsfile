pipeline {
    agent {
        docker { image '3.8.5-eclipse-temurin-11-alpine' }
    }
    stages {
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
      
      stage('SAST') {
            steps {
                echo 'npm run sonar'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

    }
}