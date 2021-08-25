pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
     RESULTADOKEYJIRA = ""
     RESULTADOSTAGE = "" 
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
                         def issue = jiraGetIssue idOrKey: 'RS-4', site: 'JiraToken'
                        RESULTADOSTAGE = currentBuild.result
                        if(RESULTADOSTAGE == 'SUCCESS'){
                        RESULTADOKEYJIRA = issue.data.toString()
                        }
                      } catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                      }                    
                }
            }
        }
        stage('JIRA Create Issue') {
            steps {
                script {
                    if(RESULTADOSTAGE != 'SUCCESS'){
                        try{
                            def testIssue = [fields: [ project: [id: '10154'],
                                       summary: 'New JIRA Created from Jenkins.',
                                       description: 'New JIRA Created from Jenkins.',
                                       customfield_1000: 'customValue',
                                       issuetype: [id: '3']]]

                        response = jiraNewIssue issue: testIssue
                        echo response.successful.toString()
                        echo response.data.toString()
                        }catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                      }
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
