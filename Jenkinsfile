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
        stage('JIRA Issue') {
            steps {
                script {
                    def issue = jiraGetIssue idOrKey: 'RS-4', site: 'JiraToken'
                    echo issue.data.toString()
                }
            }            
        }
    }
    post {
          success {
            echo 'success..'
              echo currentBuild.result
          }
          failure {
            echo 'failure..'
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }

}
