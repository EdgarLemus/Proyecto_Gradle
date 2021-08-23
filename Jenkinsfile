pipeline {
    
    agent {
        label 'AgenteSQA'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[credentialsId: '7717de6e-06e1-4809-866d-6685a573e1a0', url: 'https://github.com/EdgarLemus/Proyecto_Gradle.git']]])
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'gradle clean'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
