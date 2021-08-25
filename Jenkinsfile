pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'JiraToken'
        RESULTADOEXCEPCION = 'true'
   }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'gradle clean'
            }
        }
         stage('JIRA Comment Issue') {
            steps {
                script {
                    try{
                      def comment = [ 
                        body: 'test comment'
                      ]
                      jiraAddComment idOrKey: 'RS-7', input: comment
                    }catch (Exception e) {
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
