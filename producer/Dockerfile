FROM openjdk:12-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY /build/libs/producer-0.0.1.jar /app
ENTRYPOINT ["java","-jar","producer-0.0.1.jar"]