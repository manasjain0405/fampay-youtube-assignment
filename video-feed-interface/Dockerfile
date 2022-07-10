FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8010
ADD /video-feed-interface/target/video-feed-interface.jar video-feed-interface.jar
ENTRYPOINT ["java", "-jar", "video-feed-interface.jar"]