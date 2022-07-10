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
@Document(indexName = "video_title_desc_search")
public class StoredVideoSearchEntity {

  @Id
  @Field(type = FieldType.Keyword, name = "refId")
  private String referenceId;

  @Field(type = FieldType.Text, name = "videoTitle")
  private String videoTitle;

  @Field(type = FieldType.Text, name = "videoDescription")
  private String videoDescription;

}
