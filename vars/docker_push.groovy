def call(Map config) {
	retry(count: 3) {
		if (params.ecr_action == 'create') {
			docker.withRegistry('https://636181284446.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:devopsrole') {
				// docker_image.push('${imagetag}')
				String imagename = congig.imagename
				String imagetag = config.tag
                sh 'docker tag ${imagename} 636181284446.dkr.ecr.us-east-1.amazonaws.com/${imagename}:${imagetag}'
                sh 'docker push 636181284446.dkr.ecr.us-east-1.amazonaws.com/${imagename}:${imagetag}'
			}
		}
	}
}