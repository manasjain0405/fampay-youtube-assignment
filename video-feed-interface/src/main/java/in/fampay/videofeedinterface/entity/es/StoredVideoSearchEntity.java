package in.fampay.videofeedinterface.entity.es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "title_desc_search")
public class StoredVideoSearchEntity {

  @Id
  @Field(type = FieldType.Keyword, name = "refId")
  private String refId;

  @Field(type = FieldType.Text, name = "title")
  private String title;

  @Field(type = FieldType.Text, name = "description")
  private String description;

}
