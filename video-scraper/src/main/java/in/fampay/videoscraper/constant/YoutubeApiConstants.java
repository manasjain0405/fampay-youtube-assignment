package in.fampay.videoscraper.constant;

import java.util.Arrays;
import java.util.List;

public final class YoutubeApiConstants {

  public static final String PART_PARAMETER = "snippet";
  public static final String ORDER_PARAMETER = "date";
  public static final String TYPE_PARAMETER = "video";
  public static final Long MAX_RESULT_PARAMETER = 5L;

  public static final List<Integer> API_SUCCESS_CODE = Arrays.asList(200, 202);
  public static final Integer API_DUPLICATE_RESPONSE_CODE = 304;
  public static final Integer API_KEY_EXPIRE_CODE = 403;

}
