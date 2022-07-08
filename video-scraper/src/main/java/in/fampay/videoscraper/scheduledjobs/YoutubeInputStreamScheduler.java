package in.fampay.videoscraper.scheduledjobs;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YoutubeInputStreamScheduler {

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    log.info("The time is now {}", LocalDate.now());
  }
}
