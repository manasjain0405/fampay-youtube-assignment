package in.fampay.videoscraper.exceptions;

public class OutOfApiKeyException extends RuntimeException {

  public OutOfApiKeyException() {
  }

  public OutOfApiKeyException(String message) {
    super(message);
  }
}
