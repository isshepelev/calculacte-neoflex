FROM maven:3.9.9-amazoncorretto-11-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean verify
RUN ls /app/target

FROM openjdk:11-oracle

ENV JAVA_OPTS="-Xmx256m"

COPY --from=build /app/target/calculacte-neoflex-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["sh", "-c", "exec java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar app.jar"]

