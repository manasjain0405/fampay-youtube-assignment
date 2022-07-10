package in.fampay.videofeedinterface.config;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;

@Configuration
public class ElasticSearchClientConfig extends AbstractReactiveElasticsearchConfiguration {

  @Value("${spring.elasticsearch.url}")
  private String hostUrl;
  @Override
  @Bean
  public ReactiveElasticsearchClient reactiveElasticsearchClient() {

    val clientConfiguration = ClientConfiguration
        .builder()
        .connectedTo(hostUrl)
        .build();
    return ReactiveRestClients.create(clientConfiguration);
  }

}
