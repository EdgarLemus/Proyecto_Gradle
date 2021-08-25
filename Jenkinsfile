pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
     RESULTADOSTAGE = '' 
   }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'gradle clean'
            }
        }
        stage('JIRA Get Issue') {
            environment {
                 RESULTADOKEYJIRA = ''
                 }
            steps {
                script {
                    try {
                         def issue = jiraGetIssue idOrKey: 'RS-8', site: 'JiraToken'
                        RESULTADOKEYJIRA = issue.data.toString()
                        RESULTADOSTAGE = currentBuild.result
                      } catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                          echo RESULTADOSTAGE
                      }                    
                }
            }
        }
    }
    post {
          success {
            echo 'success..'
              echo RESULTADOKEYJIRA.split(',')[11].split(':')[1]
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
