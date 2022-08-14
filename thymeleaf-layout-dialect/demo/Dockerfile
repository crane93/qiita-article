ARG ECR_GRADLE_URI=gradle:7.2.0-jdk16-openj9
# FROM gradle:7.2.0-jdk16-openj9
FROM $ECR_GRADLE_URI
ENV APP_HOME=/usr/app/

RUN apt update && apt upgrade -y && apt install -y curl gnupg sudo git vim wget && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

#디폴트, 만약 도커컴포즈 실행시 build.arg에 정의한 ARG가 없을때
ARG UID=1001
ARG GID=1001
ARG UNAME=dev-ec2-user

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
RUN gradle build -x test