FROM openjdk:8

ADD target/election-service.jar election-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","election-service.jar"]
