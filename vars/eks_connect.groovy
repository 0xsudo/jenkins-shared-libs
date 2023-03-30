def call() {
    if (params.eksctl_action == 'create' && params.ecr_action == 'create') {
		sh 'aws eks update-kubeconfig --region ${config.region} --name us-east-1'
		sh 'sleep 120'
	}
}