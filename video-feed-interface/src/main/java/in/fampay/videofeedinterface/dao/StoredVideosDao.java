package in.fampay.videofeedinterface.dao;

import in.fampay.videofeedinterface.entity.es.StoredVideoSearchEntity;
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

  public final Flux<StoredVideoDetailsEntity> getPaginatedVideoDetailsAfterReference(final long lastPageReference,
      final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findByIdGreaterThan(lastPageReference, pagination);
  }

  public final Flux<StoredVideoDetailsEntity> getInitialVideoDetailsPage(final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findAllBy(pagination);
  }

  public final Flux<StoredVideoSearchEntity> getPaginatedSearchResult(final String query, final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoSearchRepository.fuzzySearchTitleAndDescription(query, pagination);
  }

}
