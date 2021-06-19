FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]