pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'JiraToken'
   }
    stages {     
        stage('JIRA Create Issue') {
            steps {
                script {
                        
                            def testIssue = [fields : [
                                                        project: [id: '10154'],
                                                        summary: 'Sinergia Tecnologica de Jira desde Jenkins con Banco Popular',
                                                        description: 'Realiza la integracion desde Jenkins mediante un Pipeline a Jira luego de ejecutar las pruebas.',
                                                        issuetype: [id: '10071']]]
                        response = jiraNewIssue issue: testIssue , site: JIRASERVER

                        echo response.successful.toString()
                        echo response.data.toString()                                        
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
