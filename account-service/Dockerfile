FROM openjdk:17
EXPOSE 8085
COPY build/libs/account-service-0.0.1-SNAPSHOT.jar account-service.jar
ENTRYPOINT ["java", "-jar", "/account-service.jar"]