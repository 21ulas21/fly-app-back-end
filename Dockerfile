FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/pinsoft-0.0.1-SNAPSHOT.jar /app/pinsoft.jar

EXPOSE 8080

CMD java -jar pinsoft.jar