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
### Instructions to start application
Navigate to root folder of the project and follow the following steps after insuring the above mentioned prerequisites are already installed on the system.
S1) In the .env file add all the available youtube api keys in a comma separated manned for the variable *YOUTUBE_KEY*
```
YOUTUBE_KEY=KEY1,KEY2,KEY3
```
S2) *OPTIONAL* Set the desired password for mysql in .env(DB_PASS) and docker-compose.yml under the db service (MYSQL_ROOT_PASSWORD)
S3) Enter the following command in the root folder of the project. You can monitor the progress on docker desktop dashboard.
```bash
bash start.sh
```
Note: ElasticSearch takes about 2 mins to start (observed on my system with just 8gb ram) till then the java applications might reastart, but as soon as elastic search is up the system stabilizes.

### Instruction to stop application
Run the command given below in the root directory of the project.
```bash
docker compose down
```

## Solution Arch.
The solution contains 2 microservices
- video-scraper (Responsible for fetching videos of the search parameter specified in .env under key YOUTUBE_SEARCH_QUERY, storing it in mysql and creating search index on elastic search)
- video-feed-interface (Provide paginated feed and fuzzy search apis over the datastore)
Project is broken down into 2 microservices, video-feed-interface is completely read based and video-scraper is completely write based, this is to make sure if one microservice is down the other functionality is still up and remains unaffected)
