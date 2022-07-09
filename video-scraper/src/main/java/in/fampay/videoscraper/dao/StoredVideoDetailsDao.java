package in.fampay.videoscraper.dao;

import java.util.Optional;

import in.fampay.videoscraper.entity.StoredVideoDetailsEntity;
import in.fampay.videoscraper.repository.StoredVideoDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoredVideoDetailsDao {

  private final StoredVideoDetailsRepository storedVideoDetailsRepository;

  public Optional<StoredVideoDetailsEntity> getByReferenceId(final String referenceId) {

    return storedVideoDetailsRepository.findByReferenceId(referenceId);
  }

  public final StoredVideoDetailsEntity save(final StoredVideoDetailsEntity entity) {

    return storedVideoDetailsRepository.save(entity);
  }
}
