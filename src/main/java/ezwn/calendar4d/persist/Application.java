package ezwn.calendar4d.persist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "ezwn.persist", "ezwn.calendar4d.persist" })
@EntityScan(basePackages = { "ezwn.calendar4d.persist.schema" })
@EnableJpaRepositories(basePackages = { "ezwn.calendar4d.persist.repositories" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}