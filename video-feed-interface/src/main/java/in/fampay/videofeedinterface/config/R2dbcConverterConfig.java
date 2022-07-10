package in.fampay.videofeedinterface.config;

import java.util.ArrayList;
import java.util.List;

import in.fampay.videofeedinterface.entity.sql.converter.StoredVideoDetailsReadConverter;
import in.fampay.videofeedinterface.entity.sql.converter.StoredVideoDetailsWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.MySqlDialect;

@Configuration
public class R2dbcConverterConfig {

  @Bean
  public R2dbcCustomConversions customConversions() {
    List<Converter<?, ?>> converterList = new ArrayList<>();
    converterList.add(new StoredVideoDetailsReadConverter());
    converterList.add(new StoredVideoDetailsWriteConverter());
    return R2dbcCustomConversions.of(MySqlDialect.INSTANCE, converterList);
  }
}
