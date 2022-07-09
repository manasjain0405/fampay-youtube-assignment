package in.fampay.videoscraper.dto.youtubeapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Id {

  public String kind;
  public String videoId;
}
