FROM ghcr.io/graalvm/jdk-community:22
WORKDIR /app

COPY ./ /app/

RUN ./gradlew build




