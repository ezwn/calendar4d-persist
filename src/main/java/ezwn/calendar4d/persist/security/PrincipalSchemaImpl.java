package ezwn.calendar4d.persist.security;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.persist.security.PrincipalSchemaAdapter;

@Service
public class PrincipalSchemaImpl implements PrincipalSchemaAdapter {
	
	@Autowired
	private SystemCalendarUserRepository calendarUserRepository;
	
	@Override
	public Optional<String> principalKey(Principal principal) {
		if (principal instanceof CalendarUser) {
			return Optional.of(
					((CalendarUser)principal).getUserName()
				);
		}
		
		return Optional.of(calendarUserRepository.findByUserName(principal.getName()).getUserName());
	}
}
