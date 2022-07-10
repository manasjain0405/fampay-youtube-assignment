package in.fampay.videofeedinterface.service;

import java.time.LocalDateTime;

import in.fampay.videofeedinterface.dto.PageableResponse;
import in.fampay.videofeedinterface.dto.VideoDetailsDto;
import reactor.core.publisher.Mono;

public interface VideoFeedService {

  Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getVideoFeedPaginated(final int size,
      final LocalDateTime cursor);

  Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getSearchResultPaginated(final int size, final String query);

}
