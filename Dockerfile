FROM maven:3.8.2-jdk-8
RUN yum install curl
RUN curl -u Rafik:admin -o achat.jar "http://localhost/repository/maven-releases/tn/esprit/rh/achat/1.0/Achat-1.0.jar" -L
EXPOSE 8089
ENTRYPOINT ["java", "-jar","/achat.jar"]