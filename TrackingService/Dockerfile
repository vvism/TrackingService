FROM maven:3.6.3-jdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine

COPY --from==build /target/trackingservice-0.0.1-SNAPSHOT.jar trackingservice.jar

EXPOSE 9090
ENTRYPOINT ["java" , "-jar", "trackingservice.jar"]
 