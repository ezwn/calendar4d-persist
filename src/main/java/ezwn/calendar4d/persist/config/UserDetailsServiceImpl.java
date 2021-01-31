package ezwn.calendar4d.persist.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ezwn.calendar4d.persist.repositories.CalendarUserRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
	public static class User implements UserDetails {

		private static final long serialVersionUID = 1L;
		
		private CalendarUser calendarUser;
	 
	    public User(CalendarUser gourmet) {
	        this.calendarUser = gourmet;
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
		}

		@Override
		public String getPassword() {
			return "{noop}" + calendarUser.getPassword();
		}

		@Override
		public String getUsername() {
			return calendarUser.getUserName();
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

		public CalendarUser getCalendarUser() {
			return calendarUser;
		}

		public void setGourmet(CalendarUser calendarUser) {
			this.calendarUser = calendarUser;
		}
	}
	
    @Autowired
    private CalendarUserRepository calendarUserRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	CalendarUser calendarUser = calendarUserRepository.findByUserName(username);
        return new User(calendarUser);
    }

}