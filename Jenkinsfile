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
                jiraAssignIssue idOrKey: 'Test-1', site: 'JiraToken', userName: 'juan.orjuela@sqasa.co'
            }
        }
    }
    post {
          success {
            echo 'success..'
          }
          failure {
            echo 'failure..'
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }

}
