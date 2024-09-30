node("master") {

	try {


		stage('SCM') {

			git branch: 'main',
			credentialsId: 'sonarqube',
			url: 'https://github.com/programadormovel/cadastro-produto-react'
		}

		stage('Mvn Package'){

			sh 'mvn clean package'
		}

		stage('SonarQube analysis') {

			withSonarQubeEnv('sonarqube') {

				sh 'mvn sonar:sonar -Dsonar.projectKey=My-Pipeline -Dsonar.host.url=http://127.0.0.1:9000 -Dsonar.login=sqp_4a899e5c5fb0e85f9475555eccfdc54ca5b7f665'

			}

		}




	}catch (e) {

		throw e
	}


}