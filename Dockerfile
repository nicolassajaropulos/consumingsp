# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set environment variables
ENV ROUTE_URI=http://localhost:8081
ENV ROUTE_PATH=/**

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/app.jar /app/app.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]