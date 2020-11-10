package ezwn.calendar4d.persist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "data.mng.lang.persist", "ezwn.calendar4d.persist" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}