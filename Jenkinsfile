pipeline {
    agent any
    stages {
        stage('Pull the code') {
            steps {
                sh 'git clone --branch ubu-test https://github.com/teZdr/Selenium4Cucumber'
                
            }
        }
        stage('Prepare ws') {
            steps {
                sh 'cd /var/lib/jenkins/workspace/PipelineTest/Selenium4Cucumber/'
                sh 'pwd'
                sh 'ls -lha'
            }
        }
        stage('Run the dockers') {
            steps {
                sh 'docker-compose up -d'
            }
        }
        stage('Run the tests') {
            steps {
                sh 'mvn clean install -Dbrowser=chrome'
            }
        }
        stage('Stop docker') {
            steps {
                sh 'docker stop $(docker ps -a -q)'
                sh 'docker rm $(docker ps -a -q)'
            }
        }
    }
    post { 
        always { 
            cleanWs()
        }
    }
}
