FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=/target/devops-training-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]