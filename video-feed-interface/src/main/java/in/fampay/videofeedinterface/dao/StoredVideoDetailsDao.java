package in.fampay.videofeedinterface.dao;

import java.util.Optional;

import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videofeedinterface.repository.sql.StoredVideoDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoredVideoDetailsDao {

  private final StoredVideoDetailsRepository storedVideoDetailsRepository;

  public Optional<StoredVideoDetailsEntity> getByReferenceId(final String referenceId) {

    return storedVideoDetailsRepository.findByReferenceId(referenceId);
  }

  public final Mono<Page<StoredVideoDetailsEntity>> getPaginatedVideoDetailsAfterReference(final long lastPageReference,
      final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findByIdGreaterThan(lastPageReference, pagination);
  }

  public final Mono<Page<StoredVideoDetailsEntity>> getInitialVideoDetailsPage(final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("videoUploadedAt").descending());
    return storedVideoDetailsRepository.findAll(pagination);
  }
}
