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
public class YoutubeThumbnailDetails {

  @JsonProperty("url")
  public String url;

  @JsonProperty("width")
  public int width;

  @JsonProperty("height")
  public int height;
}
