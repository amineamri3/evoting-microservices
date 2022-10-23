FROM  openjdk:8
EXPOSE 8080
ADD /target/auth-service-0.0.1.jar auth-service.jar
ENTRYPOINT ["java", "-jar", "auth-service.jar"]