pipeline {

    agent any

    environment {
    		DOCKERHUB_CREDENTIALS=credentials('dockerhubaccount')
    	}

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

    stage('Build') {

    			steps {
    				sh 'docker build -t rafikzoubli/achat_docker:latest .'
    			}
    		}

    		stage('Login') {

    			steps {
    				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    			}
    		}

    		stage('Push') {

    			steps {
    				sh 'docker push rafikzoubli/achat_docker:latest'
    			}
    		}
}

    	    post {
    		always {
    			sh 'docker logout'
    		}
    	}

}
