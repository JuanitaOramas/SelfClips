package eci.selfClips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class SelfClipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfClipsApplication.class, args);
	}

}
