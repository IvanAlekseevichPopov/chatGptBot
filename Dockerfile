FROM ghcr.io/graalvm/jdk-community:21
RUN microdnf install findutils

EXPOSE 8080

COPY ./ /app/
WORKDIR /app

RUN ./gradlew

RUN ./gradlew jar

#TODO распилить на 3 контейнера 1. подтянутый gradle, который почти никогда не меняется 2. библиотеки в отдельном контейнере 3. Финальный контейнер


