pipeline {

    agent any

    stages{

        stage('Git'){

            steps{
                echo "Getting Project From git"
                git 'https://github.com/rafikzoubli/Achat_Test.git'
            }
        }

        stage('Compiling'){

            steps{
                sh 'mvn test'
                 sh 'mvn clean install'
               }
        }

    }


    
}
