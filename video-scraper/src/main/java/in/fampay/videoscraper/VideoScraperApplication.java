package in.fampay.videoscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
@EnableScheduling
@EnableFeignClients(basePackages = {"in.fampay.videoscraper.client"})
@EntityScan(basePackages = {"in.fampay.videoscraper.entity"})
@EnableJpaRepositories(basePackages = "in.fampay.videoscraper.repository.sql")
@EnableElasticsearchRepositories(basePackages = "in.fampay.videoscraper.repository.es")
@EnableRetry
@EnableTransactionManagement
public class VideoScraperApplication {

  public static void main(String[] args) {
    SpringApplication.run(VideoScraperApplication.class, args);
  }

}
