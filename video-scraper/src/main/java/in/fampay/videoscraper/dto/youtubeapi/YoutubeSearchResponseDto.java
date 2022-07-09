package in.fampay.videoscraper.dto.youtubeapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeSearchResponseDto {

  @JsonProperty("kind")
  public String kind;

  @JsonProperty("etag")
  public String etag;

  @JsonProperty("nextPageToken")
  public String nextPageToken;

  @JsonProperty("regionCode")
  public String regionCode;

  @JsonProperty("pageInfo")
  public YoutubeSearchPageInfo youtubeSearchPageInfo;

  @JsonProperty("items")
  public List<YoutubeSearchItem> youtubeSearchItems;

}



