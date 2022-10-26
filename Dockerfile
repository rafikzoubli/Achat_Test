FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achat.jar xyz.jar
ENTRYPOINT ["java", "-jar","/xyz.jar"]