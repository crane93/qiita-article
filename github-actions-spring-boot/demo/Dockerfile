FROM openjdk:18-jdk-bullseye
ENV APP_HOME=/usr/app/

RUN apt update && apt upgrade -y && apt install -y curl gnupg sudo git vim wget && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ARG UID=1001
ARG GID=1001
ARG UNAME=qiita

ENV UID ${UID}
ENV GID ${GID}
ENV UNAME ${UNAME}

RUN useradd --uid $UID --create-home --shell /bin/bash -G sudo,root $UNAME
RUN echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers
RUN sudo ln -sf /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
    
USER $UNAME
USER root

WORKDIR /demo/home
COPY . /demo/home
RUN ./gradlew test