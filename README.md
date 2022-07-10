# fampay-youtube-assignment

## Problem Statement
To make an API to fetch latest videos sorted in reverse chronological order of their publishing date-time from YouTube for a given tag/search query in a paginated response.
### Goals
- Server should call the YouTube API continuously in background (async) with some interval (say 10 seconds) for fetching the latest videos for a predefined search query and should store the data of videos (specifically these fields - Video title, description, publishing datetime, thumbnails URLs and any other fields you require) in a database with proper indexes.
- A GET API which returns the stored video data in a paginated response sorted in descending order of published datetime.
- A basic search API to search the stored videos using their title and description.
- Dockerize the project.
- It should be scalable and optimised.
### Bonus Goals
- Add support for supplying multiple API keys so that if quota is exhausted on one, it automatically uses the next available key.
- Make a dashboard to view the stored videos with filters and sorting options (optional)
- Optimise search api, so that it's able to search videos containing partial match for the search query in either video title or description.
    - Ex 1: A video with title *`How to make tea?`* should match for the search query `tea how`

## Technology Used
- Spring Boot (For implementation of MVC and using @Scheduled as cron)
- Spring Web Flux (Used for read api, WebFlux being a non thread blocking architecture optimises high throughput read operations) 
- MySql (For Storing Video Details and for indexing helping in optimising paginated queries)
- Kafka (To decouple the logic of saving data in mysql and elasticsearch making sure the thread running the scheduled task is not blocked for long, also to provide idempotency in writing data to data stores using the partition key of kafka, will help if multiple instances of same application are deployed)
- ElasticSearch (For storing the columns and creating index on videoTitle and videoDescription allowing fuzzy search capabilities on the same)

## How To run the application
### Prerequisites
- Maven
- Docker
- bash/zsh shell
### Instructions
Navigate to root folder of the project and run the following command after insuring the above mentioned prerequisites are already installed on the system.
```bash
bash start.sh
```
