FROM openjdk:8

ADD target/ms-candidat.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]