#FROM maven:3.8.5-jdk-11
FROM maven:3.5.3-jdk-8-alpine
COPY pom.xml /tmp/
COPY src /tmp/src/
COPY testng.xml /tmp/
COPY Dockerfile /tmp/
# COPY target/ICEYE-1.0-SNAPSHOT.jar /tmp/
COPY jcommander-1.82.jar /tmp/
WORKDIR /tmp/
RUN mvn package
EXPOSE 9292
ENTRYPOINT "java -cp /root/.m2/repository/org/testng/testng/6.14.3/testng-6.14.3.jar:/tmp/ICEYE-1.0-SNAPSHOT.jar:/tmp/jcommander-1.82.jar org.testng.TestNG /tmp/testng.xml"