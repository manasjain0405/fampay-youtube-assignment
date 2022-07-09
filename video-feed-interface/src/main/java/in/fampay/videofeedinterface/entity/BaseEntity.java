package in.fampay.videofeedinterface.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
  @Column("id")
  private Long id;

  @CreatedDate
  @Column("created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  @Column("updated_at")
  private LocalDateTime updatedAt;

  @Version
  @Column("version")
  private Long version;

}
