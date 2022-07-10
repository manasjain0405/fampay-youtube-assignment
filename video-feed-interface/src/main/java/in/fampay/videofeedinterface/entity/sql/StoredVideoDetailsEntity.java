package in.fampay.videofeedinterface.entity.sql;

import java.time.LocalDateTime;

import in.fampay.videofeedinterface.entity.sql.constants.StoredVideoDetailsColumns;
import in.fampay.videofeedinterface.entity.sql.context.VideoMetadataContext;
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

  @Column(StoredVideoDetailsColumns.REF_ID)
  private String referenceId;

  @Column(StoredVideoDetailsColumns.VIDEO_TITLE)
  private String videoTitle;

  @Column(StoredVideoDetailsColumns.VIDEO_DESCRIPTION)
  private String videoDescription;

  @Column(StoredVideoDetailsColumns.VIDEO_UPLOADED_AT)
  private LocalDateTime videoUploadedAt;

  @Column(StoredVideoDetailsColumns.CONTEXT)
  private VideoMetadataContext context;
}
