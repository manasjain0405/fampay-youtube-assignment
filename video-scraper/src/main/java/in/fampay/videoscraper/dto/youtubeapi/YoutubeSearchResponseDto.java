package in.fampay.videoscraper.dto.youtubeapi;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeSearchResponseDto {

  public String kind;
  public String etag;
  public String nextPageToken;
  public String regionCode;
  public PageInfo pageInfo;
  public List<Item> items;

}



