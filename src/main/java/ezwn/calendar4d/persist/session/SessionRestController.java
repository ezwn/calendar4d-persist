package ezwn.calendar4d.persist.session;

import java.security.Principal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezwn.calendar4d.persist.config.UserDetailsServiceImpl.User;
import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.CalendarUserDTOMapper;
import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;

@RestController
@RequestMapping(value="/api/v1/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionRestController {

	private final SystemCalendarUserRepository calendarUserRepository;
	private final CalendarUserDTOMapper entitiesDTOsMapper;
	
   public SessionRestController(final CalendarUserDTOMapper entitiesDTOsMapper, final SystemCalendarUserRepository calendarUserRepository) {
	      this.calendarUserRepository = calendarUserRepository;
	      this.entitiesDTOsMapper = entitiesDTOsMapper;
	   }
   
   @CrossOrigin
   @GetMapping("")
   public CalendarUserDTO login(Principal principal) {
		if (principal instanceof User) {
			return entitiesDTOsMapper.toDTO(((User)principal).getCalendarUser());
		} else {
			return entitiesDTOsMapper.toDTO(calendarUserRepository.findByUserName(principal.getName()));
		}
   }

   @CrossOrigin	
   @PostMapping("")
   public void register(@RequestBody final CalendarUserDTO calendarUserDTO) {
	   calendarUserRepository.save(entitiesDTOsMapper.toEntity(calendarUserDTO));
   }
   
}