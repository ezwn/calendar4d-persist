package ezwn.calendar4d.persist.security;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.repositories.SystemUserRoleRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.persist.security.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SystemCalendarUserRepository calendarUserRepository;

	@Autowired
	private SystemUserRoleRepository userRoleRepository;

	@Override
	public User loadUserByUsername(String username) {
		CalendarUser calendarUser = calendarUserRepository.findByUserName(username);

		List<String> roles = StreamSupport.stream(userRoleRepository.findAllByUserId(username).spliterator(), false)
				.map(userRole -> userRole.getRole()).collect(Collectors.toList());

		return new User(calendarUser.getUserName(), calendarUser.getPassword(), roles);
	}

}