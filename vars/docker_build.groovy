// import devops.jnkns.ParamParser

def call(Map params) {
    // Access the parameters
    String imagename = params.imagename
    // String param2 = params.param2

	withDockerRegistry([credentialsId: 'docker-login', url: '']) {
		script {
			if (params.ecr_action == 'create') {
				// docker.build('buggy-app')
				sh 'docker build -t ${imagename} .'
			}
		}
	}
}
