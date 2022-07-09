package in.fampay.videoscraper.repository.es;

import in.fampay.videoscraper.entity.es.StoredVideoSearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredVideoSearchEntityRepository extends ElasticsearchRepository<StoredVideoSearchEntity, String> {

}
