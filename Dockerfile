FROM amazoncorretto:17-alpine-jdk

ADD target/sci-all-auth-api.jar sci-all-auth-api.jar
ENTRYPOINT ["java", "-jar", "sci-all-auth-api.jar"]