FROM docker.io/openjdk:17

ADD build/libs/*.jar /app/
CMD java $JAVA_OPTIONS -Duser.timezone=Europe/Moscow -jar /app/*.jar

EXPOSE 8080
