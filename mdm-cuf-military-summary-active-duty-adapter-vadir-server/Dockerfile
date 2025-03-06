FROM amazoncorretto:17.0.10

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose port 9081
EXPOSE 9081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
