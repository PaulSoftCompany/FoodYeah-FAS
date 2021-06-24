FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8092
COPY build/libs/*.war food-service.war
ENTRYPOINT ["java","-jar","/food-service.war"]