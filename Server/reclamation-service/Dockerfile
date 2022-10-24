FROM  openjdk:8
EXPOSE 8088
ADD /target/reclamation-service-0.0.1.jar reclamation-service.jar
ENTRYPOINT ["java", "-jar", "reclamation-service.jar"]