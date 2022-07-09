package in.fampay.videofeedinterface.entity;

import java.time.LocalDate;

import in.fampay.videofeedinterface.entity.context.VideoMetadataContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
@Table("stored_video_details_entity")
public class StoredVideoDetailsEntity extends BaseEntity {

  @Column("ref_id")
  private String referenceId;

  @Column("video_title")
  private String videoTitle;

  @Column("video_description")
  private String videoDescription;

  @Column("video_uploaded_at")
  private LocalDate videoUploadedAt;

  @Column("context")
  private VideoMetadataContext context;
}
