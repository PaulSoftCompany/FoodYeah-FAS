FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
COPY build/libs/*.jar admin-service.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/admin-service.jar"]