# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build

# Kopiera källkod och pom.xml till build-miljön
COPY src /app/src
COPY pom.xml /app

# Bygg projektet och skapa en JAR-fil utan att köra tester
RUN mvn -f /app/pom.xml clean package -DskipTests

# Extrahera beroenden från JAR-filen
RUN mkdir -p /app/target/dependency && (cd /app/target/dependency; jar -xf ../*.jar)

# Stage 2: Run
FROM eclipse-temurin:22-jre-alpine

# Definiera en ARG-variabel för beroendevägen
ARG DEPENDENCY=/app/target/dependency

# Miljövariabler för H2 och Spring Boot-konfiguration
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:bookning
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PLATFORM=H2

# Kopiera beroenden och applikationsfiler från byggsteget
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Exponera porten Spring Boot kör på
EXPOSE 8080

# Starta applikationen
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "org.iths.bookning.BookningApplication"]
