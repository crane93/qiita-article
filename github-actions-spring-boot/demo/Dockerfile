FROM openjdk:18-jdk-bullseye
ENV APP_HOME=/usr/app/

RUN apt update && apt upgrade -y && apt install -y curl gnupg sudo git vim wget && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /demo/home
COPY . /demo/home