package in.fampay.videoscraper.entity.sql;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;

import in.fampay.videoscraper.entity.sql.context.VideoMetadataContext;
import in.fampay.videoscraper.entity.sql.converter.VideoMetadataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stored_video_details_entity",
       indexes = @Index(name = "uploadedAtIndex", columnList = "video_uploaded_at"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoredVideoDetailsEntity extends BaseEntity {

  @Column(name = "ref_id")
  private String referenceId;

  @Column(name = "video_title")
  private String videoTitle;

  @Column(name = "video_description")
  private String videoDescription;

  @Column(name = "video_uploaded_at")
  private LocalDateTime videoUploadedAt;

  @Column(name = "context", columnDefinition = "blob")
  @Lob
  @Convert(converter = VideoMetadataConverter.class)
  private VideoMetadataContext context;
}
