pipeline {

    agent any

    stages{

        stage('Git Checkout'){

            steps{
                git 'https://github.com/rafikzoubli/Achat_Test.git'
            }
        }
        stage('UNIT Testing'){

            steps{
                sh 'mvn test'
            }
        }
        stage('Integration testing'){

            steps{
                sh 'mvn verify -DskipUnitTests'
            }
        }
        stage('Maven Build'){

            steps{
                sh 'mvn clean install'
            }
        }
        stage('SonarQube analysis'){
            steps{
                script{
                     withSonarQubeEnv(credentialsId: 'sonar-api') {
                      sh 'mvn clean package sonar:sonar'
                 }
                }
            }
        }
        stage('Quality Gate status'){

            steps{

                script{

                    waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api'
                }
            }
        }