package in.fampay.videoscraper.dto.youtubeapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Item {

  public String kind;
  public String etag;
  public Id id;
  public Snippet snippet;
}
