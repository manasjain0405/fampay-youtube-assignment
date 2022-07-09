package in.fampay.videoscraper.dto.youtubeapi;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeVideoDetails {

  @JsonProperty("publishedAt")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public LocalDateTime publishedAt;

  @JsonProperty("channelId")
  public String channelId;

  @JsonProperty("title")
  public String title;

  @JsonProperty("description")
  public String description;

  @JsonProperty("thumbnails")
  public YoutubeThumbnails youtubeThumbnails;

  @JsonProperty("channelTitle")
  public String channelTitle;

  @JsonProperty("liveBroadcastContent")
  public String liveBroadcastContent;

  @JsonProperty("publishTime")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public LocalDateTime publishTime;
}
