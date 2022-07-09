package in.fampay.videoscraper.repository;

import java.util.Optional;

import in.fampay.videoscraper.entity.StoredVideoDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredVideoDetailsRepository extends JpaRepository<StoredVideoDetailsEntity, Long> {

  Optional<StoredVideoDetailsEntity> findByReferenceId(final String referenceId);

}
