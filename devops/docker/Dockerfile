FROM openjdk:11
ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh
ADD libs/*.jar app.jar
ENTRYPOINT ["./entrypoint.sh"]