FROM openjdk:17
EXPOSE 8084
COPY build/libs/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]