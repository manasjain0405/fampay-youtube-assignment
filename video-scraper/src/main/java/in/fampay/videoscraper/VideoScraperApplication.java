package in.fampay.videoscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VideoScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoScraperApplication.class, args);
	}

}
