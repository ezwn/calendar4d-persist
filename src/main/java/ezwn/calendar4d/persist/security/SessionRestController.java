package ezwn.calendar4d.persist.security;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.CalendarUserDTOMapper;
import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.repositories.SystemUserRoleRepository;

@RestController
@RequestMapping(value = "/api/v1/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionRestController {

	private final SystemCalendarUserRepository calendarUserRepository;
	private final SystemUserRoleRepository userRoleRepository;

	private final CalendarUserDTOMapper entitiesDTOsMapper;

	public SessionRestController(final CalendarUserDTOMapper entitiesDTOsMapper,
			final SystemCalendarUserRepository calendarUserRepository, SystemUserRoleRepository userRoleRepository) {
		this.calendarUserRepository = calendarUserRepository;
		this.entitiesDTOsMapper = entitiesDTOsMapper;
		this.userRoleRepository = userRoleRepository;
	}

	@CrossOrigin
	@GetMapping("")
	public UserDTO login(Principal principal) {

		final List<String> roles = StreamSupport
				.stream(userRoleRepository.findAllByUserId(principal.getName()).spliterator(), false)
				.map(userRole -> userRole.getRole()).collect(Collectors.toList());
		
		return new UserDTO(principal.getName(), roles);
	}

	@CrossOrigin
	@PostMapping("")
	public void register(@RequestBody final CalendarUserDTO calendarUserDTO) {
		calendarUserRepository.save(entitiesDTOsMapper.toEntity(calendarUserDTO));
	}

}