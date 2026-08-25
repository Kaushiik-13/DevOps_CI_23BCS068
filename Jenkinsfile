pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'rm -rf build && mkdir -p build'
                sh 'javac -d build src/Calculator.java tests/CalculatorTest.java'
            }
        }

        stage('Test') {
            steps {
                sh 'java -cp build CalculatorTest'
            }
        }

        stage('Result') {
            steps {
                echo 'Calculator build and automated tests completed successfully.'
                sh 'git --no-pager log -1 --oneline'
            }
        }
    }

    post {
        success {
            echo 'CI RESULT: SUCCESS'
        }
        failure {
            echo 'CI RESULT: FAILURE - review the failed stage and console output.'
        }
        always {
            echo "Finished Jenkins build ${env.BUILD_NUMBER}."
        }
    }
}
