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
                    def issue = jiraGetIssue idOrKey: 'RS-8', site: 'JiraToken'
                    echo issue.data.toString()
                }
            }
            echo currentBuild.result
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
