FROM amazoncorretto:17.0.9-al2023-headless as extractor
WORKDIR /project-client-service
COPY build/libs/app.jar /project-client-service/
RUN java -Djarmode=layertools -jar app.jar extract

FROM amazoncorretto:17.0.9-al2023-headless
WORKDIR /app
COPY --from=extractor /project-client-service/dependencies/. /app/.
COPY --from=extractor /project-client-service/spring-boot-loader/. /app/.
COPY --from=extractor /project-client-service/snapshot-dependencies/. /app/.
COPY --from=extractor /project-client-service/application/. /app/.
EXPOSE 8080
CMD ["java", "org.springframework.boot.loader.JarLauncher"]