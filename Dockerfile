FROM maven:3.5.4-jdk-8-alpine as maven

COPY ./pom.xml ./pom.xml

COPY ./src  ./src

RUN mvn dependency:go-offline -B

#Genera el proyecto y empaqueta el archivo JAR del directorio Target
RUN mvn package

FROM openjdk:8u171-jre-alpine

WORKDIR /app

COPY --from=maven target/TrabajoAS-*.jar ./TrabajoAS.jar

CMD ["java", "-jar", "./TrabajoAS.jar"]