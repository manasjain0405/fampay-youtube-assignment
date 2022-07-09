package in.fampay.videoscraper.dao;

import java.util.Optional;

import in.fampay.videoscraper.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videoscraper.mappers.YoutubeSearchMapper;
import in.fampay.videoscraper.repository.es.StoredVideoSearchEntityRepository;
import in.fampay.videoscraper.repository.sql.StoredVideoDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoredVideoDetailsDao {

  private final StoredVideoDetailsRepository storedVideoDetailsRepository;
  private final StoredVideoSearchEntityRepository videoSearchEntityRepository;
  private final YoutubeSearchMapper youtubeSearchMapper;


  public Optional<StoredVideoDetailsEntity> getByReferenceId(final String referenceId) {

    return storedVideoDetailsRepository.findByReferenceId(referenceId);
  }

  public final void save(final StoredVideoDetailsEntity entity) {

    storedVideoDetailsRepository.save(entity);
    videoSearchEntityRepository.save(youtubeSearchMapper.convertVideoDetailsToVideoSearchEntity(entity));
  }
}
