FROM gradle:jdk8-alpine as builder

COPY --chown=gradle:gradle . /home/gradle/
RUN gradle build

FROM java:8-jre-alpine

RUN addgroup -S -g 1000 app \
    && adduser -D -S -G app -u 1000 -s /bin/ash app
USER app
WORKDIR /home/app
COPY --from=builder --chown=app:app /home/gradle/build/libs/cowweb-0.1.jar .
CMD ["java", "-jar", "/home/app/cowweb-0.1.jar"]