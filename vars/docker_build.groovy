import devops.jnkns.Utils

def call(def context, Map params = [:]) {
    retry(count: 3) {
		context.request.parameterNames.each { paramName ->
        	params[paramName] = context.request.getParameter(paramName)
    	}
    	return params

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