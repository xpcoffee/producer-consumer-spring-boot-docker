FROM openjdk:12-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY /build/libs/consumer-0.0.1.jar /app
ENTRYPOINT ["java","-jar","consumer-0.0.1.jar"]