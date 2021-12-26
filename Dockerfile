FROM  adoptopenjdk/openjdk11-openj9:jre-11.0.10_9_openj9-0.24.0-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]