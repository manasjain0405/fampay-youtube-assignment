package in.fampay.videoscraper.client;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import in.fampay.videoscraper.dto.youtubeapi.YoutubeSearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "youtube-client", url = "${youtube.api.base-url}")
public interface YoutubeApiClient {

  @GetMapping(value = "/search", consumes = "application/json", produces = "application/json")
  ResponseEntity<YoutubeSearchResponseDto> fetchYoutubeSearchResultPaginated(
      @RequestParam(name = "key") final String key,
      @RequestParam(name = "q") final String query,
      @RequestParam(name = "part", defaultValue = "snippet") final String part,
      @RequestParam(name = "maxResults") final Long maxResults,
      @RequestParam(name = "order", defaultValue = "date") final String orderBy,
      @RequestParam(name = "type", defaultValue = "video") final String type,
      @RequestParam(name = "publishedAfter") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
      final ZonedDateTime publishedAfter);
}
