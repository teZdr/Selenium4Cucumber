node {
    try {
        cleanWs()
        
        stage('Pull the code') {
            git url: 'https://github.com/teZdr/Selenium4Cucumber'
        }
        stage('Run the dockers') {
//             sh 'cd /var/lib/jenkins/workspace/Selenium4/'
            sh 'pwd'
            sh 'ls -lha'
            sh 'docker-compose up -d'
        }
        stage('Run the tests') {
            sh 'mvn clean install -Dbrowser=chrome'
        }
        
        stage('Kill docker') {
            sh 'docker-compose down'
        }
        
    }
    catch(e) {
        sh 'Build Error'
    }
}
