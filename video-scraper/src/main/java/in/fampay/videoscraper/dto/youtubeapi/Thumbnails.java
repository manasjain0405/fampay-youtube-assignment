package in.fampay.videoscraper.dto.youtubeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Thumbnails {

  @JsonProperty("default")
  public ThumbnailDetails mydefault;

  @JsonProperty("medium")
  public ThumbnailDetails medium;

  @JsonProperty("high")
  public ThumbnailDetails high;
}
