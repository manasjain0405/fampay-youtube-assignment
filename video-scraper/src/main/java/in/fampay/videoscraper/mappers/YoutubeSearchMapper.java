package in.fampay.videoscraper.mappers;

import java.util.Optional;

import in.fampay.videoscraper.dto.youtubeapi.YoutubeSearchItem;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeThumbnailDetails;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeThumbnails;
import in.fampay.videoscraper.dto.youtubeapi.YoutubeVideoDetails;
import in.fampay.videoscraper.entity.es.StoredVideoSearchEntity;
import in.fampay.videoscraper.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videoscraper.entity.sql.context.VideoMetadataContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@Slf4j
public abstract class YoutubeSearchMapper {

  public static final String ES_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

  @Mappings({
      @Mapping(target = "referenceId", source = "youtubeVideoId.videoId"),
      @Mapping(target = "videoTitle", source = "youtubeVideoDetails.title"),
      @Mapping(target = "videoDescription", source = "youtubeVideoDetails.description"),
      @Mapping(target = "videoUploadedAt", source = "youtubeVideoDetails.publishedAt"),
  })
  public abstract StoredVideoDetailsEntity convertYoutubeSearchDtoToEntity(final YoutubeSearchItem youtubeSearchItem);

  @AfterMapping
  void buildYoutubeVideoDetailsContext(
      @MappingTarget final StoredVideoDetailsEntity.StoredVideoDetailsEntityBuilder entityBuilder,
      final YoutubeSearchItem youtubeSearchItem) {

    val videoMetadataContextBuilder = VideoMetadataContext.builder();

    Optional.ofNullable(youtubeSearchItem)
        .map(YoutubeSearchItem::getYoutubeVideoDetails)
        .map(YoutubeVideoDetails::getYoutubeThumbnails)
        .map(YoutubeThumbnails::getDefaultThumbnail)
        .map(YoutubeThumbnailDetails::getUrl)
        .ifPresent(videoMetadataContextBuilder::thumbnailUrl);
    Optional.ofNullable(youtubeSearchItem)
        .map(YoutubeSearchItem::getYoutubeVideoDetails)
        .map(YoutubeVideoDetails::getChannelTitle)
        .ifPresent(videoMetadataContextBuilder::publisherAccountName);
    entityBuilder.context(videoMetadataContextBuilder.build());
  }

  @Mappings({
      @Mapping(target = "referenceId", source = "referenceId"),
      @Mapping(target = "videoTitle", source = "videoTitle"),
      @Mapping(target = "videoDescription", source = "videoDescription"),
  })
  public abstract StoredVideoSearchEntity convertVideoDetailsToVideoSearchEntity(
      final StoredVideoDetailsEntity videoDetailsEntity);

}
