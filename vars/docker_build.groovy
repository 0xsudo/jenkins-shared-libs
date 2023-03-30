// import devops.jnkns.ParamParser

def call(Map config) {
    // Access the parameters
    // String imagename = config.imagename
    // String param2 = config.param2

	withDockerRegistry([credentialsId: 'docker-login', url: '']) {
		script {
			String imagename = config.imagename
			
			if (params.ecr_action == 'create') {
				// docker.build('buggy-app')
				sh 'docker build -t ${imagename} .'
			}
		}
	}
}
