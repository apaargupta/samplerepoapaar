pipeline {
    agent any
    stages {
    def mvnHome
        stage('Build') {
            steps {
                //
                mvnHome = tool 'MVN'
                withMaven(maven : 'MVN') {
                    // sh 'mvn '
                    bat(/"${mvnHome}\bin\mvn" clean install/)
                }
            }
        }
        stage('Test') {
            steps {
                //
            }
        }
        stage('Deploy') {
            steps {
                //
            }
        }
    }
}