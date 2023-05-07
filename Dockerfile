# Use the official OpenJDK base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Autify-BE-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application listens on
EXPOSE 8080

# Set the entrypoint command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
