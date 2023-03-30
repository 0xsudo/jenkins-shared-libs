def call() {
    if (params.eksctl_action == 'create' && params.ecr_action == 'create') {
		sh 'eksctl create cluster --name devsecops-buggy-app --region us-east-1 --zones us-east-1a,us-east-1b --nodegroup-name linux-buggy-app --nodes 2 --instance-types t2.micro --tags "app=buggy-app" --version 1.25'
	} else {
		// deleting the cluster directly created a race condition btwn node groups and cluster, decided to do it in two steps
		sh 'eksctl delete nodegroup --name linux-buggy-app --cluster devsecops-buggy-app --region us-east-1'
		sh 'eksctl delete cluster --name devsecops-buggy-app --region us-east-1 --force'
	}
}