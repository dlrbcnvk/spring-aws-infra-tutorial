FROM openjdk:17-alpine

ENV APP_HOME=/Users/joseong-gyu/Documents/goorm_bootcamp/goorm-aws

ARG JAR_FILE_PATH=build/libs/spring-aws-tutorial-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

COPY $JAR_FILE_PATH spring-aws-tutorial-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-aws-tutorial-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
