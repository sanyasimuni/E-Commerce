# Use an official openjdk runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target folder into the container
COPY target/User-MS-0.0.1-SNAPSHOT.jar User-MS-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8787

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "User-MS0.0.1-SNAPSHOT.jar"]
