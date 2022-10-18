FROM maven:3.6.0-jdk-11 as compileStage
WORKDIR /app
COPY ./backend .
RUN mvn clean package -DskipTests -q

FROM maven:3.6.0-jdk-11
WORKDIR /app
EXPOSE 1337
COPY --from=compileStage /app/target/snippet-0.0.1.jar ./
CMD ["java","-jar","snippet-0.0.1.jar"]