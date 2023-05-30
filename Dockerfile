FROM openjdk:17-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD target/trainingmanager-0.0.1-SNAPSHOT.jar trainingmanager.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/trainingmanager.jar"]