package in.fampay.videoscraper.entity.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoMetadataContext {

  private String thumbnailUrl;
  private String publisherAccountName;
}
