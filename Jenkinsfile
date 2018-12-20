pipeline {
	agent any
	stages {
        stage('--run-docker-compose--') {
            steps {
            sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/"
            sh "docker-compose up --build -d"
            }
        }
        stage('--run-eureka--') {
            steps {
            sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/eureka/"
            sh "./deploy.bash"
            }
        }
        stage('--run-zuul--') {
						steps {
            sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/zuul/"
						sh "./deploy.bash"
						}
				}
				stage('--run-cv-api-for-cloud--') {
						steps {
						sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/cv-api-for-cloud/"
						sh "./deploy.bash"
						}
				}
				stage('--run-cv-trainee-service--') {
						steps {
						sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/cv-trainee-service/"
						sh "./deploy.bash"
				}
				}
				stage('--run-cv-trainer-service--') {
						steps {
							sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/cv-trainer-service/"
							sh "./deploy.bash"
						}
				}
				stage('--run-user-creation-api--') {
						steps {
							sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/user-creation-api/"
							sh "./deploy.bash"
						}
				}
        stage('--run-consumer--') {
						steps {
						sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/consumer/"
						sh "./deploy.bash"
						}
				}
				stage('--run-front-end--') {
					steps {
						sh "cd /var/lib/jenkins/workspace/cv-manager-project_qa/front-end/"
						sh "./deploy.bash"
					}
				}
    }
}
