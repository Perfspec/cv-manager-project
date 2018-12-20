pipeline {
	agent any
	stages {
        stage('--run-eureka--') {
            steps {
            sh "./var/lib/jenkins/workspace/cloud-time_qa/eureka/deploy.bash"
            }
        }
        stage('--run-zuul--') {
						steps {
            sh "./var/lib/jenkins/workspace/cloud-time_qa/zuul/deploy.bash"
						}
				}
				stage('--run-cv-api-for-cloud--') {
						steps {
						sh "./var/lib/jenkins/workspace/cloud-time_qa/cv-api-for-cloud/deploy.bash"
						}
				}
				stage('--run-user-creation-api--') {
						steps {
							sh "./var/lib/jenkins/workspace/cloud-time_qa/user-creation-api/deploy.bash"
						}
				}
        stage('--run-consumer--') {
						steps {
						sh "./var/lib/jenkins/workspace/cloud-time_qa/consumer/deploy.bash"
						}
				}
				stage('--run-front-end--') {
					steps {
						sh "./var/lib/jenkins/workspace/cloud-time_qa/front-end/deploy.bash"
					}
				}
		}
}
