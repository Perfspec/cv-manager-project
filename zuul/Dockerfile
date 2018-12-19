FROM java:8
ARG artifact_id
ARG version
ENV artifact=${artifact_id}-${version}.jar
COPY target/${artifact} /opt/${artifact}
EXPOSE 8080
ENTRYPOINT java -jar /opt/${artifact}
