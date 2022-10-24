FROM  openjdk:8
EXPOSE 7999
ADD /target/gateway-service-0.0.1.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]