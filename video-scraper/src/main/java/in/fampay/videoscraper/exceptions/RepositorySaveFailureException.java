package in.fampay.videoscraper.exceptions;

public class RepositorySaveFailureException extends RuntimeException {

  public RepositorySaveFailureException() {
  }

  public RepositorySaveFailureException(String message) {
    super(message);
  }
}
