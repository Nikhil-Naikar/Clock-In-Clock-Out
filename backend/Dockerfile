# docker using layers, caching features, so it can reuse unchanges layers

FROM maven:3.8.6-openjdk-18-slim as build
WORKDIR /home/app

# code will not change often
COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/backend/demo/BackendApplication.java /home/app/src/main/java/com/backend/demo/BackendApplication.java

#this step takes a long time, cause it downloads all the dependencies
RUN mvn -f /home/app/pom.xml clean package

# above layers will be reused if no changes made to pom.xml or BackendApplication.java
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:18.0-slim
EXPOSE 1111
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
