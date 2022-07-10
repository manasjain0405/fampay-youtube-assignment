package in.fampay.videofeedinterface.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse<T, U> {

  private List<T> dataList;
  private U pageCursor;
  private int size;
}
