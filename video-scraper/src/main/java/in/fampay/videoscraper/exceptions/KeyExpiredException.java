package in.fampay.videoscraper.exceptions;

public class KeyExpiredException extends RuntimeException {

  public KeyExpiredException() {
  }

  public KeyExpiredException(String message) {
    super(message);
  }
}
