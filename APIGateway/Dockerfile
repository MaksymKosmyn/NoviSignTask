FROM openjdk:8-jdk-alpine

ADD target/APIGateway.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8765
