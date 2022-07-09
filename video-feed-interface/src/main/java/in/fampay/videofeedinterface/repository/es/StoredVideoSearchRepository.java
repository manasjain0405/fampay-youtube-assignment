package in.fampay.videofeedinterface.repository.es;

import in.fampay.videofeedinterface.entity.es.StoredVideoSearchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StoredVideoSearchRepository extends ReactiveSortingRepository<StoredVideoSearchEntity, String> {

  @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"videoTitle\", \"videoDescription\"], \"fuzziness\": \"AUTO\"}}")
  Flux<StoredVideoSearchEntity> fuzzySearchTitleAndDescription(final String q, final Pageable pageable);

}
