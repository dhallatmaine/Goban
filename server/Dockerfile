FROM openjdk:10-jdk
VOLUME /tmp
ADD target/Goban-1.0-SNAPSHOT.jar target/app.jar
ADD config.yml target/config.yml
RUN bash -c 'touch target/app.jar'
ENTRYPOINT ["java","-jar","target/app.jar", "server", "target/config.yml"]
