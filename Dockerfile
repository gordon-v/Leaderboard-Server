FROM openjdk:21

LABEL authors="gordon"

ARG JAR_FILE=build/libs/Leaderboard-Server-0.0.1-SNAPSHOT.jar

WORKDIR /opt/leaderboard/

COPY build/libs/Leaderboard-Server-0.0.1-SNAPSHOT.jar leaderboard.jar

ENTRYPOINT ["java","-jar","leaderboard.jar"]

