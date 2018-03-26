FROM openjdk:8-jre-alpine

ENV SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${SLEEP}s..." && \
    sleep ${SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar

EXPOSE 9998

ADD *.jar /app.jar
