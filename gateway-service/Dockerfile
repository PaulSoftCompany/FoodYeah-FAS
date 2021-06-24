FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8080
COPY build/libs/*.jar gateway-service.jar
ENTRYPOINT ["java","-jar","/gateway-service.jar"]