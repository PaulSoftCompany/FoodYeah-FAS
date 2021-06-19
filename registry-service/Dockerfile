FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8099
COPY build/libs/*.jar registry-service.jar
ENTRYPOINT ["java","-jar","/registry-service.jar"]