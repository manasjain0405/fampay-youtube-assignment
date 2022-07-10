package in.fampay.videofeedinterface.entity.sql.converter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videofeedinterface.entity.sql.constants.BaseEntityColumns;
import in.fampay.videofeedinterface.entity.sql.constants.StoredVideoDetailsColumns;
import in.fampay.videofeedinterface.entity.sql.context.VideoMetadataContext;
import io.r2dbc.spi.Row;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
@Slf4j
public class StoredVideoDetailsReadConverter implements Converter<Row, StoredVideoDetailsEntity> {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.findAndRegisterModules();
  }

  @SneakyThrows
  @Override
  public StoredVideoDetailsEntity convert(Row source) {

    return StoredVideoDetailsEntity
        .builder()
        .id(source.get(BaseEntityColumns.ID, Long.class))
        .createdAt(source.get(BaseEntityColumns.CREATED_AT, LocalDateTime.class))
        .updatedAt(source.get(BaseEntityColumns.UPDATED_AT, LocalDateTime.class))
        .version(source.get(BaseEntityColumns.VERSION, Long.class))
        .referenceId(source.get(StoredVideoDetailsColumns.REF_ID, String.class))
        .videoTitle(source.get(StoredVideoDetailsColumns.VIDEO_TITLE, String.class))
        .videoDescription(source.get(StoredVideoDetailsColumns.VIDEO_DESCRIPTION, String.class))
        .videoUploadedAt(source.get(StoredVideoDetailsColumns.VIDEO_UPLOADED_AT, LocalDateTime.class))
        .context(objectMapper.readValue(source.get(StoredVideoDetailsColumns.CONTEXT, byte[].class),
            VideoMetadataContext.class))
        .build();
  }
}
