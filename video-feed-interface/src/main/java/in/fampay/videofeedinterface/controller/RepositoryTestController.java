package in.fampay.videofeedinterface.controller;

import in.fampay.videofeedinterface.dao.StoredVideosDao;
import in.fampay.videofeedinterface.entity.es.StoredVideoSearchEntity;
import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController("repository-test-controller")
@RequiredArgsConstructor
@Slf4j
public class RepositoryTestController {

  private final StoredVideosDao storedVideosDao;

  @GetMapping("/testPaginatedQuery")
  public Flux<StoredVideoDetailsEntity> getPaginatedQuery() {
    return storedVideosDao.getInitialVideoDetailsPage(10);
  }

  @GetMapping("/testSearchQuery")
  public Flux<StoredVideoDetailsEntity> getPaginatedSearchQuery(@RequestParam("searchParam") final String query) {
    return storedVideosDao.getPaginatedSearchResult(query, 10);
  }
}
