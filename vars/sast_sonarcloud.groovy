def call() {
    retry(count: 3) {
		if (params.ecr_action == 'create') {
			withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {
				sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=0xsudo_DevSecOps -Dsonar.organization=buggyapp-devsecops -Dsonar.host.url=https://sonarcloud.io' //-Dsonar.login=sonar_token
			}
		}
	}
}