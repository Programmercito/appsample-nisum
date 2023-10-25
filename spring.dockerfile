FROM eclipse-temurin:11.0.20.1_1-jdk-ubi9-minimal
EXPOSE 8080
RUN wget -O app.jar https://github.com/Programmercito/appsample-nisum/releases/download/prod/appsample-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar" ]