pipeline {
    agent any
    stages {
        stage {
            steps ('install nginx and git'){
                sh '''
                sudo apt update
                sudo apt install nginx -y
                sudo apt install git -y
                sudo systemctl start nginx
                '''
            }
        }
        stage ('clone github code'){
            steps {
                git branch: 'main', url: 'https://github.com/pujapatel81/pipelinerepo.git'
            }
        }
        stage ('deploy'){
            steps {
                sh'''
                sudo rm -rf /var/www/html/*
                sudo cp  *  /var/www/html/
                '''
            }
        }
    }
}