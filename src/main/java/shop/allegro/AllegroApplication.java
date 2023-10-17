package shop.allegro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AllegroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllegroApplication.class, args);
	}

}
