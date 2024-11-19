# Usa una imagen base con soporte para Java 21
FROM eclipse-temurin:21-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Mensaje para verificar en qué directorio estamos
RUN echo "Directorio de trabajo actual: $(pwd)"

# Listar los archivos disponibles en el contexto antes de copiar
RUN echo "Archivos disponibles en el contexto de construcción:" && ls -l

# Copia el archivo JAR de tu aplicación en el contenedor
COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar

# Verifica que el archivo se copió correctamente
RUN echo "Archivos en el directorio de trabajo después de copiar:" && ls -l

# Expone el puerto donde tu aplicación escuchará
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
