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
                 sh 'mvn clean install'
               }
        }



       stage('Sonar') {

       steps {

      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    }
  }
}

}
