ARG CONTAINER_REGISTRY

FROM $CONTAINER_REGISTRY/groww-base-images:openjdk11-alpine

ARG JAR_FILE

ADD target/$JAR_FILE onboarding-data-server.jar
COPY start.sh .

ARG SERVER_PORT=8056

EXPOSE ${SERVER_PORT}
EXPOSE ${JMX_PORT}

CMD ["bash", "-c", "/start.sh"]