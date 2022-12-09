FROM maven:3.6.3-jdk-11
COPY ./ ./
RUN mvn package -Dmaven.test.skip
ENTRYPOINT ["java","-jar","/target/app.jar"]
