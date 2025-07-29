# ----------- Build Stage -----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

# Build the app and detect final jar name
RUN mvn clean package -DskipTests && \
    JAR_NAME=$(mvn help:evaluate -Dexpression=project.build.finalName -q -DforceStdout) && \
    cp target/$JAR_NAME.jar app.jar

# ----------- Runtime Stage -----------
FROM eclipse-temurin:21

WORKDIR /app

COPY --from=build /app/app.jar app.jar

ENV PORT=8089
EXPOSE 8089

ENTRYPOINT ["java", "-jar", "app.jar"]
