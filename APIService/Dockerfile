FROM openjdk:8-jdk-alpine

COPY ./target/APIService-*.jar /api-service/api-service.jar
WORKDIR /api-service
EXPOSE 8085
ENTRYPOINT ["java","-jar","/api-service/api-service.jar"]
