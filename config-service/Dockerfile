FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8081
COPY build/libs/*.war config-service.war
ENTRYPOINT ["java","-jar","/config-service.war"]