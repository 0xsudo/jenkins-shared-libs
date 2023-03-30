import devops.jnkns.Utils

def call(Map params = [:]) {
    retry(count: 3) {
		params = Utils.parseParams(this, params)
		
		withDockerRegistry([credentialsId: 'docker-login', url: '']) {
			script {
				if (params.ecr_action == 'create') {
					// docker.build('buggy-app')
					sh 'docker build -t ${params.imagename} .'
				}
			}
		}
	}
}