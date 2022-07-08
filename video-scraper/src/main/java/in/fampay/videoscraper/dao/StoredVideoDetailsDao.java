package in.fampay.videoscraper.dao;

import java.util.Optional;

import in.fampay.videoscraper.entity.StoredVideoDetailsEntity;
import in.fampay.videoscraper.repository.StoredVideoDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoredVideoDetailsDao {

  private final StoredVideoDetailsRepository storedVideoDetailsRepository;

  public Optional<StoredVideoDetailsEntity> getByReferenceId(final String referenceId) {

    return storedVideoDetailsRepository.findByReferenceId(referenceId);
  }

  public final Page<StoredVideoDetailsEntity> getPaginatedVideoDetailsAfterReference(final long lastPageReference,
      final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("video_uploaded_at").descending());
    return storedVideoDetailsRepository.findByIdGreaterThan(lastPageReference, pagination);
  }

  public final Page<StoredVideoDetailsEntity> getInitialVideoDetailsPage(final int size) {

    val pagination = PageRequest.of(0, size, Sort.by("video_uploaded_at").descending());
    return storedVideoDetailsRepository.findAll(pagination);
  }
}
