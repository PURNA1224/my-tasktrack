FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17.0-jdk-slim

WORKDIR /app

COPY  --from=build /app/target/TodoBackEnd-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/TodoBackEnd-0.0.1-SNAPSHOT.jar" ]