package in.fampay.videoscraper.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import in.fampay.videoscraper.entity.context.VideoMetadataContext;
import in.fampay.videoscraper.entity.converter.VideoMetadataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stored_video_details_entity")
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
  private LocalDate videoUploadedAt;

  @Column(name = "context", columnDefinition = "blob")
  @Lob
  @Convert(converter = VideoMetadataConverter.class)
  private VideoMetadataContext context;
}
