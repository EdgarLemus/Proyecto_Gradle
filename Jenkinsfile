pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
     RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
   }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'gradle clean'
            }
        }
        stage('JIRA Get Issue') {
            steps {
                script {
                    try {
                         def issue = jiraGetIssue idOrKey: 'RS-8', site: 'JiraToken'                        
                      } catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()
                      }
                    RESULTADOSTAGE = currentBuild.result
                    if(RESULTADOSTAGE == 'SUCCESS'){
                        RESULTADOKEYJIRA = issue.data.toString()
                    }
                    echo currentBuild.result
                }
            }
        }
    }
    post {
          success {
            echo 'success..'
              //echo RESULTADOKEYJIRA.split(',')[11].split(':')[1]
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
