# Stage 1: Build the application using Maven
FROM maven:3.8.4-openjdk-17 AS builder

# Set environment variables
ENV ROUTE_URI=http://localhost:8081
ENV ROUTE_PATH=/**

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]