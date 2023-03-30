def call(int period) {
    if (params.eksctl_action == 'create' && params.ecr_action == 'create') {
		sh 'sleep 10; echo "Deployment ready for DAST analysis on EKS"'
	}
}