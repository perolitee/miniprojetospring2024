pipeline{
    agent any
    environment {

    }

    stages{
        stage('SCM') {
            steps{
                git branch: 'main',
                credentialsId: 'sonarqube',
                url: 'https://github.com/programadormovel/miniprojetospring2024.git'
            }
        }

        stage('Mvn Package'){
            steps{
                sh 'mvn clean package'
            }
        }

        stage('SonarQube analysis') {
            steps{
                withSonarQubeEnv() {
                    sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=miniprojetospring2024 -Dsonar.host.url=http://127.0.0.1:9000 -Dsonar.login=sqp_4a899e5c5fb0e85f9475555eccfdc54ca5b7f665'
                }
            }
        }
    }

}

