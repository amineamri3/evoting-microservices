FROM  openjdk:8
EXPOSE 8081
ADD /target/user-service-0.0.1.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]