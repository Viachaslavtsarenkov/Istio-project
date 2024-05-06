FROM amazoncorretto:17.0.9-al2023-headless as extractor
WORKDIR /project-audio-service
COPY build/libs/app.jar /project-audio-service/
RUN java -Djarmode=layertools -jar app.jar extract


FROM amazoncorretto:17.0.9-al2023-headless
WORKDIR /app
COPY --from=extractor /project-audio-service/dependencies/. /app/.
COPY --from=extractor /project-audio-service/spring-boot-loader/. /app/.
COPY --from=extractor /project-audio-service/snapshot-dependencies/. /app/.
COPY --from=extractor /project-audio-service/application/. /app/.
CMD ["java", "org.springframework.boot.loader.JarLauncher"]