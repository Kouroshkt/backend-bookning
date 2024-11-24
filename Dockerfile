# Byggfas
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Körfas
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /build/target/backend-bookning-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
