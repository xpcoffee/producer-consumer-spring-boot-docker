FROM gradle:6.7.1-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:12-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/producer-0.0.1.jar /app
ENTRYPOINT ["java","-jar","producer-0.0.1.jar"]