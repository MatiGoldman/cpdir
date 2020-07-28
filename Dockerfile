FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/cpdir-assignment.jar cpdir-assignment.jar
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait
CMD ["/sayhello"]
ENTRYPOINT ["java", "-jar", "/cpdir-assignment.jar"]
