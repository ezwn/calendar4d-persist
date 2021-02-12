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
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.repositories.CalendarUserRepository;

@RestController
@RequestMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionRestController {

	private final CalendarUserRepository calendarUserRepository;
	private final EntitiesDTOsMapper entitiesDTOsMapper;
	
   public SessionRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final CalendarUserRepository calendarUserRepository) {
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