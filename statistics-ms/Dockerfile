FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY build/libs/statistics-ms.jar /app/statistics-ms.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "statistics-ms.jar"]