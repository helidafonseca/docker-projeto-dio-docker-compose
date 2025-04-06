FROM gradle:8.4.0-jdk17 AS build
COPY . /app
WORKDIR /app
RUN gradle installDist --stacktrace --info

FROM openjdk:17-slim
RUN apt-get update && apt-get install -y findutils && rm -rf /var/lib/apt/lists/*
COPY --from=build /app/build/install/kotlin-backend /app
WORKDIR /app
CMD ["bin/kotlin-backend"]
