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
                 sh 'mvn clean -U'
                 sh 'mvn install'

               }
        }


       stage('Sonar') {

       steps {

      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    }
  }



    stage('Mockito') {

    steps {

    sh 'mvn test'

    }

    }



    stage ('Nexus') {

    steps {

    sh 'mvn deploy -DSkipTests'

    }

    }

    stage ('Docker') {

        steps {

        sh 'docker build -t getting-started-achat .'

        }

            }


}

}
