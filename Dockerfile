# Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml to leverage Docker layer caching
COPY pom.xml .

# Download all dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the application, skipping tests as they should be run in a separate CI step
RUN mvn package -DskipTests

# Stage 2: Create the final, lightweight runtime image
FROM eclipse-temurin:21-jre-jammy

# Create a dedicated, non-root user for security
RUN groupadd --system appgroup && useradd --system -g appgroup appuser

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar

# Change ownership of the application JAR to the non-root user
RUN chown appuser:appgroup app.jar

# Switch to the non-root user
USER appuser

# Expose the port the application will run on (default for Spring Boot is 8080)
EXPOSE 8080

# Define the command to run the application
# The SPRING_PROFILES_ACTIVE=gcp environment variable must be set in the Cloud Run service configuration.
ENTRYPOINT ["java", "-jar", "app.jar"]
