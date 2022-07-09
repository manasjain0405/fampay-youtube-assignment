package in.fampay.videofeedinterface.config;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;

@Configuration
public class ElasticSearchClientConfig extends AbstractReactiveElasticsearchConfiguration {

  @Override
  @Bean
  public ReactiveElasticsearchClient reactiveElasticsearchClient() {

    val clientConfiguration = ClientConfiguration
        .builder()
        .connectedTo("localhost:9200")
        .build();
    return ReactiveRestClients.create(clientConfiguration);
  }

}
