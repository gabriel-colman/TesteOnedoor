FROM openjdk:8-jdk-alpine
MAINTAINER Gabriel Colman
COPY target/agendamento-0.0.1-SNAPSHOT.jar agendamento.jar
ENTRYPOINT ["java","-jar","/agendamento.jar"]
