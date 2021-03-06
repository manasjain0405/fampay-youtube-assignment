package in.fampay.videofeedinterface.repository.sql;

import java.time.LocalDateTime;

import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StoredVideoDetailsRepository extends ReactiveCrudRepository<StoredVideoDetailsEntity, Long> {

  Mono<StoredVideoDetailsEntity> findByReferenceId(final String referenceId);

  Flux<StoredVideoDetailsEntity> findByVideoUploadedAtBefore(final LocalDateTime cursor, final Pageable pageable);

  Flux<StoredVideoDetailsEntity> findAllBy(final Pageable pageable);
}
