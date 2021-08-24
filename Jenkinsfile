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
        stage('JIRA') {
           def testIssue = [fields: [ project: [id: '10154'],
                                       summary: 'New JIRA Created from Jenkins.',
                                       description: 'New JIRA Created from Jenkins.',
                                       customfield_1000: 'customValue',
                                       issuetype: [id: '3']]]

            response = jiraNewIssue issue: testIssue

            echo response.successful.toString()
            echo response.data.toString()
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
