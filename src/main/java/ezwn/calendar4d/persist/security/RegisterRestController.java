package ezwn.calendar4d.persist.security;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.CalendarUserDTOMapper;
import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterRestController {
	
	private final SystemCalendarUserRepository calendarUserRepository;

	private final CalendarUserDTOMapper entitiesDTOsMapper;

	public RegisterRestController(
			CalendarUserDTOMapper entitiesDTOsMapper,
			SystemCalendarUserRepository calendarUserRepository
		) {
		this.calendarUserRepository = calendarUserRepository;
		this.entitiesDTOsMapper = entitiesDTOsMapper;
	}

	@CrossOrigin
	@PostMapping("register")
	public void register(@RequestBody final CalendarUserDTO calendarUserDTO) {
		calendarUserRepository.save(entitiesDTOsMapper.toEntity(calendarUserDTO));
	}

}