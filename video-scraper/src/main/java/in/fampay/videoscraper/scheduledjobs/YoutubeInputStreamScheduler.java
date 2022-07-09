package in.fampay.videoscraper.scheduledjobs;

import in.fampay.videoscraper.constant.YoutubeApiConstants;
import in.fampay.videoscraper.service.VideoFetchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YoutubeInputStreamScheduler {

  private final String query;
  private final VideoFetchService youtubeVideoFetchService;

  public YoutubeInputStreamScheduler(
      final @Qualifier("youtube-video-fetch-service") VideoFetchService youtubeVideoFetchService,
      @Value("${youtube.query}") final String query) {

    this.youtubeVideoFetchService = youtubeVideoFetchService;
    this.query = query;
  }

  @Scheduled(fixedRate = 60000)
  public void reportCurrentTime() {

    youtubeVideoFetchService.fetchVideoOnQueryParam(query, YoutubeApiConstants.MAX_RESULT_PARAMETER);
  }
}
