pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'gradle clean'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
          success {
            echo 'Success..'
          }
          failure {
            
          }
          unsuccessful {
            
          }
    }

}
