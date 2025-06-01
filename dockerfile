FROM eclipse-temurin:23-jdk-jammy AS build


RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app
COPY . .

RUN mvn clean install

FROM eclipse-temurin:23-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/Backend_PB-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
