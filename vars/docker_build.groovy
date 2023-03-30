def call() {
	withDockerRegistry([credentialsId: 'docker-login', url: '']) {
		script {			
			if (params.ecr_action == 'create') {
				sh 'docker build -t buggy-app .'
			}
		}
	}
}
