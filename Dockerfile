FROM denoland/deno

ADD target/sci-all-auth-api.jar sci-all-auth-api.jar
ENTRYPOINT ["java", "-jar", "sci-all-auth-api.jar"]