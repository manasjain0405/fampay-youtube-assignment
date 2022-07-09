package in.fampay.videoscraper.dto.youtubeapi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Snippet {

  public LocalDate publishedAt;
  public String channelId;
  public String title;
  public String description;
  public Thumbnails thumbnails;
  public String channelTitle;
  public String liveBroadcastContent;
  public LocalDate publishTime;
}
