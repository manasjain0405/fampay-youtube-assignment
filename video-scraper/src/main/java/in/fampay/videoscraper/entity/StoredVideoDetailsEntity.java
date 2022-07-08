package in.fampay.videoscraper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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

}
