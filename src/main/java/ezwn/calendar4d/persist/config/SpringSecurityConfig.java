package ezwn.calendar4d.persist.config;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import data.mng.lang.persist.services.PrincipalKeySolver;
import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SystemCalendarUserRepository calendarUserRepository;
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PrincipalKeySolver principalKeySolver() {
		return new PrincipalKeySolver() {
			
			@Override
			public Optional<String> principalKey(Principal principal) {
				if (principal instanceof CalendarUser) {
					return Optional.of(
							((CalendarUser)principal).getUserName()
						);
				}
				return Optional.of(calendarUserRepository.findByUserName(principal.getName()).getUserName());
			}
		};
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/service-info/**").permitAll()

				.antMatchers(HttpMethod.GET, "/login").authenticated()
				.antMatchers(HttpMethod.POST, "/login").permitAll()

				.antMatchers(HttpMethod.GET, "/mine/**").authenticated()
				.antMatchers(HttpMethod.POST, "/mine/**").authenticated()
				.antMatchers(HttpMethod.GET, "/admin/**").authenticated()
				.antMatchers(HttpMethod.POST, "/admin/**").authenticated()
				
				.and().csrf().disable().formLogin()
				.disable();
	}
}