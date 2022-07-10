package in.fampay.videofeedinterface.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoDetailsDto {

  private String videoTitle;
  private String videoDescription;
  private String videoThumbnailUrl;
  private String videoPublisher;
  private LocalDateTime videoUploadedAt;
}
