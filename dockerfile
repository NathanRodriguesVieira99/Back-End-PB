FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-23-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install 

FROM eclipse-temurin:23-jdk-jammy

EXPOSE 8080

COPY --from=build /target/Backend_PB-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]