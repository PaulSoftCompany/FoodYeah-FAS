FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8093
COPY build/libs/*.war user-service.war
ENTRYPOINT ["java","-jar","/user-service.war"]

