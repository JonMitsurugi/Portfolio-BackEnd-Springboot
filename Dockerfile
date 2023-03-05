FROM amazoncorretto:19
MAINTAINER JMA
COPY target/jma-0.0.1-SNAPSHOT.jar jma-app.jar
ENTRYPOINT ["java","-jar","/jma-app.jar"]