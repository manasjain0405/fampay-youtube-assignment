package in.fampay.videoscraper.dto.youtubeapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class PageInfo {

  public int totalResults;
  public int resultsPerPage;
}
