#!/bin/sh
mvn clean install -f ./video-scraper/pom.xml > video-scraper-build.log
mvn clean install -f ./video-feed-interface/pom.xml > video-feed-build.log
docker build . -t video-scraper-application:1.0 -f video-scraper/Dockerfile
docker build . -t video-feed-application:1.0 -f video-feed-interface/Dockerfile
docker compose up -d