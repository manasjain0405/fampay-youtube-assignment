package in.fampay.videofeedinterface.mapper;

import in.fampay.videofeedinterface.dto.VideoDetailsDto;
import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@Slf4j
public abstract class YoutubeSearchMapper {

  @Mappings({
      @Mapping(target = "videoTitle", source = "videoTitle"),
      @Mapping(target = "videoDescription", source = "videoDescription"),
      @Mapping(target = "videoUploadedAt", source = "videoUploadedAt"),
      @Mapping(target = "videoThumbnailUrl", source = "context.thumbnailUrl"),
      @Mapping(target = "videoPublisher", source = "context.publisherAccountName"),
  })
  public abstract VideoDetailsDto convertYoutubeSearchDtoToEntity(final StoredVideoDetailsEntity entity);


}
