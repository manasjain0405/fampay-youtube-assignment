package in.fampay.videofeedinterface.entity.sql;

import java.io.Serializable;
import java.time.LocalDateTime;

import in.fampay.videofeedinterface.entity.sql.constants.BaseEntityColumns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity implements Serializable {

  @Id
  @Column(BaseEntityColumns.ID)
  private Long id;

  @CreatedDate
  @Column(BaseEntityColumns.CREATED_AT)
  private LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  @Column(BaseEntityColumns.UPDATED_AT)
  private LocalDateTime updatedAt = LocalDateTime.now();

  @Version
  @Column(BaseEntityColumns.VERSION)
  private Long version;

}
