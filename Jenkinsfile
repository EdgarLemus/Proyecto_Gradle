pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'gradle clean'
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
