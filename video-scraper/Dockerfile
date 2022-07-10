FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8020
ADD target/video-scraper.jar video-scraper.jar
ENTRYPOINT ["java", "-jar", "application.jar"]