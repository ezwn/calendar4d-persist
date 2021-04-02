package ezwn.calendar4d.persist.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.repositories.SystemUserRoleRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	public static class User implements UserDetails {

		private static final long serialVersionUID = 1L;

		private final Collection<? extends GrantedAuthority> grantedAuthorities;
		private final String userName;
		private final String password;

		public User(CalendarUser calendarUser, List<String> roles) {
			grantedAuthorities = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
					.collect(Collectors.toList());
			
			this.password = calendarUser.getPassword();
			this.userName = calendarUser.getUserName();
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return grantedAuthorities;
		}

		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public String getUsername() {
			return userName;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}

	@Autowired
	private SystemCalendarUserRepository calendarUserRepository;

	@Autowired
	private SystemUserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		CalendarUser calendarUser = calendarUserRepository.findByUserName(username);

		List<String> roles = StreamSupport.stream(userRoleRepository.findAllByUserId(username).spliterator(), false)
				.map(userRole -> userRole.getRole()).collect(Collectors.toList());

		return new User(calendarUser, roles);
	}

}