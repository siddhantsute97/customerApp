FROM eclipse-temurin:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar customerApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customerApp-jar"]
EXPOSE 4070