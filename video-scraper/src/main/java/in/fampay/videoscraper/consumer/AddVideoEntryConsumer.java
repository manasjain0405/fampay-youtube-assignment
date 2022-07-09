package in.fampay.videoscraper.consumer;

import java.util.function.Consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videoscraper.dao.StoredVideoDetailsDao;
import in.fampay.videoscraper.entity.StoredVideoDetailsEntity;
import in.fampay.videoscraper.utils.ThrowingConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AddVideoEntryConsumer {

  private final ObjectMapper objectMapper;
  private final StoredVideoDetailsDao storedVideoDetailsDao;

  @Bean
  Consumer<Message<String>> addVideoEntry() {

    return ThrowingConsumer.unchecked((message) -> {

      log.info("Received entity to write: {}", message);
      val entity = objectMapper.readValue(message.getPayload(), StoredVideoDetailsEntity.class);
      if (storedVideoDetailsDao.getByReferenceId(entity.getReferenceId()).isEmpty()) {
        storedVideoDetailsDao.save(entity);
      }
    });
  }

}
