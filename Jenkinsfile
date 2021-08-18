pipeline {
    agent "AgenteSQA"

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat "gradle clean test aggregate"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
