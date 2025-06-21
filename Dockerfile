#
# Build stage
#
FROM openjdk:21-jdk AS build
COPY src /home/capstone/src
COPY pom.xml /home/capstone
RUN mvn -f /home/capstone/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/capstone/target/capstone.jar"]