# Stage 1: Build Stage
FROM eclipse-temurin:17-jdk-alpine as build

# Set the working directory for the build stage
WORKDIR /workspace/app
# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy the project's POM file
COPY pom.xml .

# Copy the application source code
COPY src src

# Grant executable permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the project with Maven, skipping tests
RUN ./mvnw install -DskipTests

# Create a directory for application dependencies and extract them from the built JAR file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


# Stage 2: Run Stage
FROM eclipse-temurin:17-jdk-alpine

# Set the volume directory for temporary files
VOLUME /tmp

# Set the location of the application dependencies from the build stage
ARG DEPENDENCY=/workspace/app/target/dependency

# Copy the application dependencies to the target directory
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF

# Copy the application class files to the target directory
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8080

# Set the entry point for running the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.autify.be.AutifyBeApplication"]
