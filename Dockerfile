FROM ubuntu:latest
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean
WORKDIR /app
COPY task-manager-rest/target/task-manager-rest-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-Dspring.profiles.active=docker","-jar","task-manager-rest-0.0.1-SNAPSHOT.jar"]
