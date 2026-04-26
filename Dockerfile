FROM eclipse-temurin:17-jdk-jammy
COPY target/*-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]