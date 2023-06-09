pipeline {
    agent any
    parameters {
        choice(name: 'OS', choices: ['linux', 'windows', 'darwin', 'android', 'ios'], description: 'Pick OS')
        choice(name: 'ARCH', choices: ['amd64', 'arm64', 'ppc64', '386'], description: 'Pick build arch')
    }
    environment {
        REPO = 'https://github.com/Swingyboy/kbot'
        BRANCH = 'main'
    }
    stages {
        
        stage('clone') {
            steps {
                echo 'CLONE REPOSITORY'
                    git branch: "${BRANCH}", url: "${REPO}"
            }
        }
        
        stage("test"){
            steps {
                script {
                    echo 'TEST EXECUTION STARTED'
                    sh 'make test'
                }
            }
        }
        
        stage("build"){
            steps {
                script {
                    echo 'BUILD EXECUTION STARTED'
                    sh "make build TARGETOS=${params.OS} TARGETARCH=${params.ARCH}"
                }
            }
        }
        
        stage("image"){
            steps {
                script{
                    echo 'BUILD EXECUTION STARTED'
                    sh "make image TARGETARCH=${params.ARCH}"
                }
            }
        }
        
        stage("push"){
            steps {
                script{
                    docker.withRegistry('', 'dockerhub'){
                    sh "make push TARGETARCH=${params.ARCH}"
                    }
                }
            }
        }
    }
} 