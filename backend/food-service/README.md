How to run:

1. docker build --build-arg JAR_FILE=build/libs/food-service-0.0.1-SNAPSHOT.jar -t spring-docker .

2. docker run -p 8080:8080 -t spring-docker


