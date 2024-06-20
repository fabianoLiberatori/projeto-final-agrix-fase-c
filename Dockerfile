FROM maven:3.8.5-openjdk-17 as build-image

WORKDIR /to-build-app

COPY . .

# dependecy para deixar em cache as dependencias do mvn no docker
RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build-image /to-build-app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]