FROM gradle:jdk10 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM java:8
VOLUME /tmp
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/libs/src-1.0-SNAPSHOT.jar food-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","food-service-1.0-SNAPSHOT.jar"]