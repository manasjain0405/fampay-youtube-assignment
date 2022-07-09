package in.fampay.videoscraper.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import in.fampay.videoscraper.client.YoutubeApiClient;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeSearchResponseDto;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("youtube/v3")
@Slf4j
public class YoutubeApiTestController {

  private final YoutubeApiClient apiClient;

  private final String key;

  public YoutubeApiTestController(final YoutubeApiClient apiClient, @Value("${youtube.api.key}") final String key) {
    this.apiClient = apiClient;
    this.key = key;
  }

  @GetMapping(value ="/test-search")
  public ResponseEntity<YoutubeSearchResponseDto> testYoutubeClient(
      @RequestParam(name = "q") final String query,
      @RequestParam(name = "part", required = false, defaultValue = "snippet") final String part,
      @RequestParam(name = "maxResults") final Long maxResults,
      @RequestParam(name = "order", required = false, defaultValue = "date") final String orderBy,
      @RequestParam(name = "type", required = false, defaultValue = "video") final String type,
      @RequestParam(name = "fetchResultAfterDays", required = false, defaultValue = "30")
      final Long fetchResultAfterDays) {

    val publishedAfter = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))
        .minusDays(fetchResultAfterDays);
    return apiClient.fetchYoutubeSearchResultPaginated(key, query, part, maxResults, orderBy, type, publishedAfter);
  }
}
