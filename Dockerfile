FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:nexus -o achat.jar "http://localhost/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
#ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]