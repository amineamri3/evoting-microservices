FROM  openjdk:8
EXPOSE 8086
ADD /target/supervisor-service-0.0.1.jar supervisor-service.jar
ENTRYPOINT ["java", "-jar", "supervisor-service.jar"]