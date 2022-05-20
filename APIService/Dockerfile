FROM openjdk:8-jdk-alpine

ADD target/APIService.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "/app.jar"]
