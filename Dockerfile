#
# Build stage
#
FROM jelastic/maven:3.9.5-openjdk-21 AS build
COPY src /home/capstone/src
COPY pom.xml /home/capstone
RUN mvn -f /home/capstone/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/capstone.jar"]