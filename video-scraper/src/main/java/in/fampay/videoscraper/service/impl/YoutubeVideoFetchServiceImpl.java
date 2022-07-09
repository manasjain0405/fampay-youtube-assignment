package in.fampay.videoscraper.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videoscraper.client.YoutubeApiClient;
import in.fampay.videoscraper.constant.StreamBridgeConstants;
import in.fampay.videoscraper.constant.YoutubeApiConstants;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeSearchResponseDto;
import in.fampay.videoscraper.mappers.YoutubeSearchMapper;
import in.fampay.videoscraper.service.VideoFetchService;
import in.fampay.videoscraper.utils.ThrowingConsumer;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service("youtube-video-fetch-service")
@Slf4j
public class YoutubeVideoFetchServiceImpl implements VideoFetchService {

  private final YoutubeApiClient apiClient;
  private final String key;
  private final StreamBridge streamBridge;
  private final YoutubeSearchMapper youtubeSearchMapper;
  private final ObjectMapper objectMapper;

  public YoutubeVideoFetchServiceImpl(
      final YoutubeApiClient apiClient,
      final YoutubeSearchMapper youtubeSearchMapper,
      final StreamBridge streamBridge,
      final ObjectMapper objectMapper,
      @Value("${youtube.api.key}") final String key) {

    this.apiClient = apiClient;
    this.streamBridge = streamBridge;
    this.key = key;
    this.objectMapper = objectMapper;
    this.youtubeSearchMapper = youtubeSearchMapper;
  }

  @Override
  public void fetchVideoOnQueryParam(final String query, final Long recordFetchCount) {

    val result = apiClient.fetchYoutubeSearchResultPaginated(key, query,
        YoutubeApiConstants.PART_PARAMETER, recordFetchCount,
        YoutubeApiConstants.ORDER_PARAMETER, YoutubeApiConstants.TYPE_PARAMETER,
        ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).minusDays(60));
    log.info("Youtube Api Result {}", result);
    if (YoutubeApiConstants.API_SUCCESS_CODE.contains(result.getStatusCodeValue())) {
      log.info("Api success, data write-back init");
      Optional.ofNullable(result.getBody())
          .map(YoutubeSearchResponseDto::getYoutubeSearchItems)
          .ifPresent(youtubeSearchItems ->
              youtubeSearchItems.parallelStream()
                  .map(youtubeSearchMapper::convertYoutubeSearchDtoToEntity)
                  .forEach(ThrowingConsumer.unchecked(x -> {
                    streamBridge.send(StreamBridgeConstants.INIT_VIDEO_REFRESH_TOPIC,
                        MessageBuilder.withPayload(objectMapper.writeValueAsString(x))
                            .setHeader(KafkaHeaders.MESSAGE_KEY, x.getReferenceId())
                            .build());
                  })));
    } else if (YoutubeApiConstants.API_KEY_EXPIRE_CODE == result.getStatusCodeValue()) {
      log.info("Change Key Expired");
    }
  }
}
