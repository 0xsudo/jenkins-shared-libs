import devops.jnkns.Utils

def call(Map params = [:]) {
    params = Utils.parseParams(this, params)

    retry(count: 3) {
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