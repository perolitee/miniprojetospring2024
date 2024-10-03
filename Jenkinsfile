pipeline {
    agent any

    environment {
        // Definir variáveis de ambiente do SonarQube
        SONARQUBE_SERVER = 'sonarqube' // Nome da instância do SonarQube configurada no Jenkins
        GITHUB_REPO = 'https://github.com/programadormovel/miniprojetospring2024.git'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clonar o repositório do GitHub
                git branch: 'main', url: env.GITHUB_REPO
            }
        }

        stage('Build') {

            steps {
                withMaven(globalMavenSettingsConfig: '', jdk: '11', maven: '3.9.4', mavenSettingsConfig: '', publisherStrategy: 'EXPLICIT', traceability: true) {
                    // some block
                    // Compilar o projeto (substitua 'mvn clean install' pelo comando adequado para seu projeto)
                    sh 'mvn clean install'
//                     sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=miniprojetospring'
                    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=miniprojetospring2024 -Dsonar.sources=. -Dsonar.host.url=http://192.168.0.2:9000 -Dsonar.login=sqp_3ceadd0b157eef45c001a8fe35a23d55d613f453"
                }
            }
        }

//         stage('SonarQube Analysis') {
//             environment {
//                 // Variáveis SonarQube
//                 SONAR_SCANNER_HOME = tool 'SonarQube Scanner' // Nome do scanner configurado no Jenkins
//             }
//             steps {
//                 // Executar a análise do SonarQube
//                 withSonarQubeEnv(env.SONARQUBE_SERVER) {
//                 sh "${env.SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectKey=miniprojetospring2024 -Dsonar.sources=. -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_5afd2208524dc9941738ecd052d10250cd248062"
// //                     sh "mvn clean verify sonar:sonar -Dsonar.projectKey=miniprojetospring2024 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_b3751d8d6f4d6c124e551ebcdf05d3f126b15c09"
// //                     sh "${env.SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectKey=miniprojetospring2024 -Dsonar.sources=src -Dsonar.java.binaries=target"
//                 }
//             }
//         }

        stage('Quality Gate') {
            steps {
                // Aguardar e verificar o status da análise do SonarQube
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy') {
            steps {
                // Executar o deploy do projeto (modifique conforme necessário para seu ambiente)
                echo 'Deploy do projeto iniciado...'
                // Exemplo: script de deploy ou comando específico
                // sh 'bash deploy_script.sh'
            }
        }
    }

    post {
        always {
            // Enviar e-mails ou notificação de falha
            echo 'Pipeline finalizado!'
        }
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Falha no pipeline!'
        }
    }
}
