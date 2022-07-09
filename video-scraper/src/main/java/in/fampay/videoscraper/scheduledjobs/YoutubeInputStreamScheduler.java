package in.fampay.videoscraper.scheduledjobs;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videoscraper.client.YoutubeApiClient;
import in.fampay.videoscraper.constant.YoutubeApiConstants;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeSearchResponseDto;
import in.fampay.videoscraper.mappers.YoutubeSearchMapper;
import in.fampay.videoscraper.utils.ThrowingConsumer;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YoutubeInputStreamScheduler {

  private final YoutubeApiClient apiClient;
  private final String key;
  private final String query;
  private final StreamBridge streamBridge;

  private final YoutubeSearchMapper youtubeSearchMapper;
  private final ObjectMapper objectMapper;

  public YoutubeInputStreamScheduler(
      final YoutubeApiClient apiClient,
      final YoutubeSearchMapper youtubeSearchMapper,
      final StreamBridge streamBridge,
      final ObjectMapper objectMapper,
      @Value("${youtube.api.key}") final String key,
      @Value("${youtube.query}") final String query) {

    this.apiClient = apiClient;
    this.streamBridge = streamBridge;
    this.key = key;
    this.query = query;
    this.objectMapper = objectMapper;
    this.youtubeSearchMapper = youtubeSearchMapper;
  }

  @Scheduled(fixedRate = 60000)
  public void reportCurrentTime() {

    // TODO: 09/07/22 Logic for publishedAfter
    val result = apiClient.fetchYoutubeSearchResultPaginated(key, query, YoutubeApiConstants.PART_PARAMETER,
        YoutubeApiConstants.MAX_RESULT_PARAMETER, YoutubeApiConstants.ORDER_PARAMETER,
        YoutubeApiConstants.TYPE_PARAMETER, ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).minusDays(60));
    log.info("Youtube Api Result {}", result);
    if (YoutubeApiConstants.API_SUCCESS_CODE == result.getStatusCodeValue()) {

      Optional.ofNullable(result.getBody())
          .map(YoutubeSearchResponseDto::getYoutubeSearchItems)
          .ifPresent(youtubeSearchItems ->
              youtubeSearchItems.parallelStream()
                  .map(youtubeSearchMapper::convertYoutubeSearchDtoToEntity)
                  .forEach(ThrowingConsumer.unchecked(x -> {
                    streamBridge.send("init-video-refresh",
                        MessageBuilder.withPayload(objectMapper.writeValueAsString(x))
                            .setHeader(KafkaHeaders.MESSAGE_KEY, x.getReferenceId())
                            .build());
                  })));
    } else if (YoutubeApiConstants.API_KEY_EXPIRE_CODE == result.getStatusCodeValue()) {
      log.info("Change Key Expired");
    }
  }
}
