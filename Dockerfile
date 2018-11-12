FROM openjdk:8
COPY build/libs/SpringBootLearning-0.0.1-SNAPSHOT.jar  main.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "users-mysql.jar"]