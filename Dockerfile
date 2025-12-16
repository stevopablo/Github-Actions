FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia pom e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código
COPY src ./src

# Gera o JAR
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia SOMENTE o JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
