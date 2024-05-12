FROM ghcr.io/graalvm/jdk-community:21
RUN microdnf install findutils

COPY ./ /app/
WORKDIR /app

RUN ./gradlew

RUN ./gradlew build




