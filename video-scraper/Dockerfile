FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8020
ADD video-scraper/target/video-scraper.jar video-scraper.jar
ENTRYPOINT ["java", "-jar", "video-scraper.jar"]