# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# Copy the jar file into the image
COPY target/*.jar app.jar

# Expose the port the app runs in
EXPOSE 8080

# Specify the command to run when the container starts
ENTRYPOINT ["java","-jar","/app.jar"]