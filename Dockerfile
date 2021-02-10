# only needs Java, because it is started as spring boot application
FROM java:openjdk-8u111-jre-alpine

MAINTAINER Milad

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} spring-boot-nomad-cluster-6.10.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/spring-boot-nomad-cluster-6.10.0-SNAPSHOT.jar"]