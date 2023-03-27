def call() {
	retry(count: 3) {
		retry(count: 3) {
			if (params.ecr_action == 'create') {
				docker.withRegistry('https://636181284446.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:devopsrole') {
					docker_image.push('latest')
				}
			}
		}
	}
}