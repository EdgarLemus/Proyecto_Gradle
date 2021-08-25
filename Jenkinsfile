pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
     RESULTADO = ""
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
                    RESULTADO = issue.data.toString()
                    
                    
                }
            }            
        }
    }
    post {
          success {
            echo 'success..'
              echo RESULTADO.split(',')[0]
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
