package in.fampay.videofeedinterface.dao;

import java.time.LocalDateTime;

import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videofeedinterface.repository.es.StoredVideoSearchRepository;
import in.fampay.videofeedinterface.repository.sql.StoredVideoDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoredVideosDao {

  private final StoredVideoDetailsRepository storedVideoDetailsRepository;
  private final StoredVideoSearchRepository storedVideoSearchRepository;

  public Mono<StoredVideoDetailsEntity> getByReferenceId(final String referenceId) {

    return storedVideoDetailsRepository.findByReferenceId(referenceId);
  }

  public final Flux<StoredVideoDetailsEntity> getPaginatedVideoDetailsWithCursor(final LocalDateTime cursor,
      final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findByVideoUploadedAtBefore(cursor, pagination);
  }

  public final Flux<StoredVideoDetailsEntity> getInitialVideoDetailsPage(final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findAllBy(pagination);
  }

  public final Flux<StoredVideoDetailsEntity> getPaginatedSearchResult(final String query, final int size) {

    return storedVideoSearchRepository.fuzzySearchTitleAndDescription(query, PageRequest.of(0, size))
        .flatMap(x -> getByReferenceId(x.getReferenceId()));
  }

}
