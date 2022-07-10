package in.fampay.videofeedinterface.controller;

import java.time.LocalDateTime;

import in.fampay.videofeedinterface.constants.ApplicationConstants;
import in.fampay.videofeedinterface.dto.PageableResponse;
import in.fampay.videofeedinterface.dto.VideoDetailsDto;
import in.fampay.videofeedinterface.service.VideoFeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("video-feed")
@RequiredArgsConstructor
@Slf4j
public class VideoFeedController {

  private final VideoFeedService videoFeedService;

  @GetMapping("/page")
  public Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getPaginatedFeed(
      @RequestParam("size") final int size,
      @RequestParam(value = "cursor", required = false)
      @DateTimeFormat(pattern = ApplicationConstants.DATETIME_FORMAT) final LocalDateTime cursor) {

    return videoFeedService.getVideoFeedPaginated(size, cursor);
  }

  @GetMapping("/search")
  public Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getPaginatedSearchQuery(
      @RequestParam("size") final int size, @RequestParam("query") final String query) {

    return videoFeedService.getSearchResultPaginated(size, query);
  }
}
