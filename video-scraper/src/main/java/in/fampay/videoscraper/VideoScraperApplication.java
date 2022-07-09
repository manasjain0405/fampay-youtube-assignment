package in.fampay.videoscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
@EnableScheduling
@EnableFeignClients(basePackages = {"in.fampay.videoscraper.client"})
@EntityScan(basePackages = {"in.fampay.videoscraper.entity"})
@EnableElasticsearchRepositories(basePackages = "in.fampay.videoscraper.repository")
public class VideoScraperApplication {

  public static void main(String[] args) {
    SpringApplication.run(VideoScraperApplication.class, args);
  }

}
