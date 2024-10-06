FROM openjdk:17
EXPOSE 8086
COPY build/libs/movement-service-0.0.1-SNAPSHOT.jar movement-service.jar
ENTRYPOINT ["java", "-jar", "/movement-service.jar"]