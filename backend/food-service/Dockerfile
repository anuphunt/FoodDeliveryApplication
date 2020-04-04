# Moved here to test one java script.
# That connects to mysql database on another contianer
FROM openjdk:10-jre-slim

FROM openjdk:8 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/home/gradle/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0
COPY . .
#RUN ./gradlew build
#
#
#ENV ARTIFACT_NAME=food-service-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/home/gradle/
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
#CMD ["java","-jar",$ARTIFACT_NAME]