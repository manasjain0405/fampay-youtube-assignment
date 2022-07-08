package in.fampay.videoscraper.consumer;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddVideoEntryConsumer {

  @Bean
  Consumer<Message<String>> addVideoEntry() {

    return (dtoFlux) -> {
      log.info("Data: {}", dtoFlux);
    };
  }

}
