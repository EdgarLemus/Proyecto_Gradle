pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    stages {
        stage('Clean Past Tests') {
            steps {
                bat 'gradle clean'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'gradle test'
            }
        }
        stage('Create Report') {
            steps {
                bat 'gradle aggregate'
            }
        }
        stage('Publish Report SerenityBDD'){
           steps {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'C:\\etc\\rc.d\\init.d\\jenkins\\workspace\\PipelineJira\\target\\site\\serenity', reportFiles: 'index.html', reportName: 'SerenityBDD Report', reportTitles: ''])
            }
        }
    }
    post {
          success {
            echo 'success..'
            bat ('call "cicd-script.bat"');
          }
          failure {
            echo 'failure..'
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }
}
