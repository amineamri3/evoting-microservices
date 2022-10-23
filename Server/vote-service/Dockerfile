FROM openjdk:8

ADD target/vote-service.jar vote-service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","vote-service.jar"]
