package ezwn.calendar4d.persist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/service-info/**").permitAll()

				.antMatchers(HttpMethod.GET, "/login").authenticated()
				.antMatchers(HttpMethod.POST, "/login").permitAll()

				.antMatchers(HttpMethod.GET, "/entry/**").authenticated()
				.antMatchers(HttpMethod.POST, "/entry/**").authenticated()
				
				.and().csrf().disable().formLogin()
				.disable();
	}
}