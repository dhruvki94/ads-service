# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR into the container
COPY target/AdsService.jar app.jar

# Expose the port your Spring Boot app will run on (default is 8080)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
