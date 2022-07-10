package in.fampay.videoscraper.repository.sql;

import java.util.Optional;

import in.fampay.videoscraper.entity.sql.StoredVideoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredVideoDetailsRepository extends JpaRepository<StoredVideoDetailsEntity, Long> {

  Optional<StoredVideoDetailsEntity> findByReferenceId(final String referenceId);

}
