package in.fampay.videofeedinterface.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import in.fampay.videofeedinterface.dao.StoredVideosDao;
import in.fampay.videofeedinterface.dto.PageableResponse;
import in.fampay.videofeedinterface.dto.VideoDetailsDto;
import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videofeedinterface.mapper.YoutubeSearchMapper;
import in.fampay.videofeedinterface.service.VideoFeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoFeedServiceImpl implements VideoFeedService {

  private final StoredVideosDao storedVideosDao;
  private final YoutubeSearchMapper youtubeSearchMapper;

  @Override
  public Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getVideoFeedPaginated(final int size,
      final LocalDateTime cursor) {
    if (Objects.isNull(cursor)) {
      return createPageResponse(storedVideosDao.getInitialVideoDetailsPage(size));
    }
    return createPageResponse(storedVideosDao.getPaginatedVideoDetailsWithCursor(cursor, size));
  }

  private Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> createPageResponse(
      final Flux<StoredVideoDetailsEntity> entityFlux) {

    return entityFlux.map(youtubeSearchMapper::convertYoutubeSearchDtoToEntity)
        .collectList()
        .map(dtoList -> PageableResponse
            .<VideoDetailsDto, LocalDateTime>builder()
            .dataList(dtoList)
            .pageCursor(getCursor(dtoList))
            .size(dtoList.size())
            .build());
  }

  private LocalDateTime getCursor(final List<VideoDetailsDto> dtoList) {

    if (Objects.isNull(dtoList) || dtoList.isEmpty()) {
      return null;
    }
    return dtoList.get(dtoList.size() - 1).getVideoUploadedAt();
  }

  @Override
  public Mono<PageableResponse<VideoDetailsDto, LocalDateTime>> getSearchResultPaginated(final int size,
      final String query) {

    return createPageResponse(storedVideosDao.getPaginatedSearchResult(query, size));
  }
}
