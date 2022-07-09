package in.fampay.videoscraper.entity.sql.converter;

import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.fampay.videoscraper.entity.sql.context.VideoMetadataContext;
import in.fampay.videoscraper.utils.ThrowingFunction;
import in.fampay.videoscraper.utils.ThrowingSupplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Converter
@Component
@RequiredArgsConstructor
@Slf4j
public class VideoMetadataConverter implements AttributeConverter<VideoMetadataContext, byte[]> {

  private final ObjectMapper objectMapper;

  @Override
  public byte[] convertToDatabaseColumn(final VideoMetadataContext attribute) {

    return Optional.ofNullable(attribute)
        .map(ThrowingFunction.unchecked(objectMapper::writeValueAsBytes))
        .orElseGet(ThrowingSupplier.unchecked(() -> objectMapper.writeValueAsBytes(new VideoMetadataContext())));
  }

  @Override
  public VideoMetadataContext convertToEntityAttribute(final byte[] dbData) {

    return Optional.ofNullable(dbData)
        .map(ThrowingFunction.unchecked(data -> objectMapper.readValue(data, VideoMetadataContext.class)))
        .orElseGet(VideoMetadataContext::new);
  }
}