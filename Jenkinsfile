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
            # Look at IssueInput class for more information.
            def testIssue = [fields: [ // id or key must present for project.
                                       project: [id: '10154'],
                                       summary: 'New JIRA Created from Jenkins.',
                                       description: 'New JIRA Created from Jenkins.',
                                       customfield_1000: 'customValue',
                                       // id or name must present for issueType.
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
