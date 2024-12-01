FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/bloggs-0.0.1.jar
COPY ${JAR_FILE} bloggs.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bloggs.jar"]