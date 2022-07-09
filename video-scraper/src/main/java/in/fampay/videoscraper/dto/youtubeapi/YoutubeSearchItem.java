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
public class YoutubeSearchItem {

  @JsonProperty("kind")
  public String kind;

  @JsonProperty("etag")
  public String etag;

  @JsonProperty("id")
  public YoutubeVideoId youtubeVideoId;

  @JsonProperty("snippet")
  public YoutubeVideoDetails youtubeVideoDetails;
}
