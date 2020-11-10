package ezwn.calendar4d.persist.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "ezwn.calendar4d.persist.schema" })
@EnableJpaRepositories(basePackages = { "ezwn.calendar4d.persist.repositories" })
public class JpaConfig {

}
