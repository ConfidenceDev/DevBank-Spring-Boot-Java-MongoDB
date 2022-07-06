FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/devbank.jar devbank.jar
ENTRYPOINT ["java", "-jar", "/devbank.jar"]