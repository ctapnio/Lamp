FROM openjdk:8-jdk-alpine
COPY target/A2ChristianTapnio-0.0.1-SNAPSHOT.jar A2ChristianTapnio-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","A2ChristianTapnio-0.0.1-SNAPSHOT.jar"]
