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
public class YoutubeThumbnails {

  @JsonProperty("default")
  public YoutubeThumbnailDetails defaultThumbnail;

  @JsonProperty("medium")
  public YoutubeThumbnailDetails medium;

  @JsonProperty("high")
  public YoutubeThumbnailDetails high;
}
