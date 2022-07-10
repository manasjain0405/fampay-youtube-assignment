package in.fampay.videofeedinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = {"in.fampay.videofeedinterface.repository.sql"})
@EnableElasticsearchRepositories(basePackages = "in.fampay.videofeedinterface.repository.es")
public class VideoFeedInterfaceApplication {

  public static void main(String[] args) {
    SpringApplication.run(VideoFeedInterfaceApplication.class, args);
  }

}
