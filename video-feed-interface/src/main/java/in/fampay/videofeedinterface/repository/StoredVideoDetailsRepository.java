package in.fampay.videofeedinterface.repository;

import java.util.Optional;

import in.fampay.videofeedinterface.entity.StoredVideoDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StoredVideoDetailsRepository extends ReactiveCrudRepository<StoredVideoDetailsEntity, Long> {

  Optional<StoredVideoDetailsEntity> findByReferenceId(final String referenceId);

  Mono<Page<StoredVideoDetailsEntity>> findByIdGreaterThan(final long cursorId, final Pageable pageable);

  Mono<Page<StoredVideoDetailsEntity>> findAll(final Pageable pageable);
}
