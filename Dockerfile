FROM maven:3-openjdk-17 as builder
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY --from=builder ${JAR_FILE} beebot-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/beebot-server.jar"]
