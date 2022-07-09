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
public class YoutubeVideoId {

  @JsonProperty("kind")
  public String kind;

  @JsonProperty("videoId")
  public String videoId;
}
