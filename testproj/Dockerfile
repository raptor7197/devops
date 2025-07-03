# 1. Start from a base image with Java pre-installed
FROM anapsix/alpine-java:8

# 2. Set a working directory inside the container
# This is where our application will live.
WORKDIR /app

# 3. Copy the JAR file from your host's target directory to the container's /app directory.
# We also rename it to a simpler 'app.jar' to make the CMD command cleaner.
COPY target/number-game-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# 4. Specify the command to run when the container starts.
# This runs the 'app.jar' file located in our WORKDIR.
CMD ["java", "-jar", "app.jar"]

