#!/bin/sh

docker build -t video-feed-application:1.0 ./video-feed-interface/
docker build -t video-scraper-application:1.0 ./video-scraper/
docker compose up -d