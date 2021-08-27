pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
     RESULTADOKEYJIRA = ""
     RESULTADOSTAGE = "" 
   }
    stages {      
        stage('JIRA Get Issue') {
            steps {
                script {
                    try {
                         def issue = jiraGetIssue idOrKey: 'RS-6', site: 'JiraToken'
                        RESULTADOSTAGE = currentBuild.result
                        if(RESULTADOSTAGE == 'SUCCESS'){
                        RESULTADOKEYJIRA = issue.data.toString()
                        }
                        echo issue.data.toString()
                      } catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                      }                    
                }
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
