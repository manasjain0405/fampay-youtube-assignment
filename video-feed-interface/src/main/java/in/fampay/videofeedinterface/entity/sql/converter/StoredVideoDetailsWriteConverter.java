package in.fampay.videofeedinterface.entity.sql.converter;

import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videofeedinterface.entity.sql.StoredVideoDetailsEntity;
import in.fampay.videofeedinterface.entity.sql.constants.BaseEntityColumns;
import in.fampay.videofeedinterface.entity.sql.constants.StoredVideoDetailsColumns;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

@WritingConverter
@Slf4j
public class StoredVideoDetailsWriteConverter implements Converter<StoredVideoDetailsEntity, OutboundRow> {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.findAndRegisterModules();
  }

  @SneakyThrows
  @Override
  public OutboundRow convert(StoredVideoDetailsEntity source) {

    OutboundRow row = new OutboundRow();
    if (Objects.nonNull(source.getId())) {
      row.put(BaseEntityColumns.ID, Parameter.from(source.getId()));
    }
    row.put(BaseEntityColumns.CREATED_AT, Parameter.from(source.getCreatedAt()));
    row.put(BaseEntityColumns.UPDATED_AT, Parameter.from(source.getUpdatedAt()));
    row.put(BaseEntityColumns.VERSION, Parameter.from(source.getVersion()));
    row.put(StoredVideoDetailsColumns.REF_ID, Parameter.from(source.getReferenceId()));
    row.put(StoredVideoDetailsColumns.VIDEO_TITLE, Parameter.from(source.getVideoTitle()));
    row.put(StoredVideoDetailsColumns.VIDEO_DESCRIPTION, Parameter.from(source.getVideoDescription()));
    row.put(StoredVideoDetailsColumns.VIDEO_UPLOADED_AT, Parameter.from(source.getVideoUploadedAt()));
    row.put(StoredVideoDetailsColumns.CONTEXT,
        Parameter.fromOrEmpty(objectMapper.writeValueAsBytes(source.getContext()), byte[].class));
    return row;
  }
}
