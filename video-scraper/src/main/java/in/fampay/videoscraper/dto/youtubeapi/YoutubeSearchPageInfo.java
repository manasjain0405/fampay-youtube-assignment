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
public class YoutubeSearchPageInfo {

  @JsonProperty("totalResults")
  public int totalResults;

  @JsonProperty("resultsPerPage")
  public int resultsPerPage;
}
