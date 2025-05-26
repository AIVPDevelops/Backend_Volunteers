# Imagen base oficial de Java 21
FROM eclipse-temurin:21-jre

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el jar generado en Maven o Gradle
COPY target/*.jar app.jar

# Expone el puerto que usa tu aplicación
EXPOSE 8080

# Comando para correr la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]