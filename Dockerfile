# Dockerfile

# Stage 1 : Build (compilation)
FROM maven:3.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:resolve

# Copier le code source
COPY src ./src

# Compiler et créer le JAR
RUN mvn clean package -DskipTests

# Stage 2 : Runtime (exécution)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port (optionnel, pour la console)
EXPOSE 8080

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
