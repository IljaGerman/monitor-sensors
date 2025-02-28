FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY build/libs/monitor-sensors-ms.jar /app/monitor-sensors-ms.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "monitor-sensors-ms.jar"]