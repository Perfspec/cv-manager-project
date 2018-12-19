pipeline {
	agent any
	stages {
		stage('--run-docker--') {
			steps {
        sh "sudo systemctl disable docker"
        sh "sudo systemctl stop docker"
        sh "sudo systemctl start docker"
				sh "sudo systemctl enable docker"
    stage('--run-docker-compose--') {
			steps {
        sh "cd /var/lib/jenkins/workspace/cv-manager-project/"
        sh "docker-compose up --build -d"
			}
		}
  	stage('--run-eureka--') {
  		steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/eureka/"
				sh "./deploy.bash"
      }
		}
		stage('--run-zuul--') {
			steps {
        sh "cd /var/lib/jenkins/workspace/cv-manager-project/zuul/"
				sh "./deploy.bash"
			}
		}
		stage('--run-cv-api-for-cloud--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/cv-api-for-cloud/"
				sh "./deploy.bash"
			}
		}
		stage('--run-cv-trainee-service--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/cv-trainee-service/"
				sh "./deploy.bash"
			}
		}
		stage('--run-cv-trainer-service--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/cv-trainer-service/"
				sh "./deploy.bash"
			}
		}
		stage('--run-user-creation-api--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/user-creation-api/"
				sh "./deploy.bash"
			}
		}
    stage('--run-consumer--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/consumer/"
				sh "./deploy.bash"
			}
		}
		stage('--run-front-end--') {
			steps {
				sh "cd /var/lib/jenkins/workspace/cv-manager-project/front-end/"
				sh "./deploy.bash"
			}
		}
  }
}
