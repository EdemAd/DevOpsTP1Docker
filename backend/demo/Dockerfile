FROM eclipse-temurin:21-jdk-alpine AS myapp-build

# Répertoire de travail
WORKDIR /opt/myapp

# Copier le fichier pom.xml et le dossier src
COPY pom.xml .
COPY src ./src

# Construire l'application avec Maven
RUN apk add --no-cache maven && mvn package -DskipTests

# Image pour l'exécution de l'application
FROM eclipse-temurin:21-jre-alpine

# Répertoire de travail
WORKDIR /opt/myapp

# Copier le JAR généré à partir de l'étape de build
COPY --from=myapp-build /opt/myapp/target/*.jar myapp.jar

# Exposer le port
EXPOSE 8080

# Lancer l'application Java
ENTRYPOINT ["java", "-jar", "myapp.jar"]
