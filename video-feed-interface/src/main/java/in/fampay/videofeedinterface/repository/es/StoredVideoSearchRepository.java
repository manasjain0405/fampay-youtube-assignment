package in.fampay.videofeedinterface.repository.es;

import in.fampay.videofeedinterface.entity.es.StoredVideoSearchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface StoredVideoSearchRepository extends ReactiveSortingRepository<StoredVideoSearchEntity, String> {

  @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\", \"description\"], \"fuzziness\": \"AUTO\"}}")
  Flux<StoredVideoSearchEntity> fuzzySearchTitleAndDescription(final String q, final Pageable pageable);

}
