def call() {
    retry(count: 3) {
		if (params.eksctl_action == 'create' && params.ecr_action == 'create') {
			sh 'zap.sh -cmd -port 9090 -quickurl http://$(kubectl get services/buggy-app --namespace devsecops -o json| jq -r ".status.loadBalancer.ingress[] | .hostname") -quickprogress -quickout ${WORKSPACE}/""$BUILD_NUMBER""_DAST_ZAP_buggyapp.html'
		    archiveArtifacts(artifacts: '""$BUILD_NUMBER""_DAST_ZAP_buggyapp.html')
		}
	}
}