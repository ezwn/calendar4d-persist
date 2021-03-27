package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.CalendarUserDTOMapper;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.calendar4d.persist.services.SystemCalendarUserService;
import javax.annotation.security.RolesAllowed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RolesAllowed("SYSTEM")
@RestController
@RequestMapping(value="/api/v1/system/calendar-user", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemCalendarUserRestController {
   
   private final SystemCalendarUserService systemCalendarUserService;
   private final CalendarUserDTOMapper entitiesDTOsMapper;
   
   public SystemCalendarUserRestController(final CalendarUserDTOMapper entitiesDTOsMapper, final SystemCalendarUserService systemCalendarUserService) {
      this.systemCalendarUserService = systemCalendarUserService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @PostMapping("")
   CalendarUserDTO save(@RequestBody CalendarUserDTO calendarUserDTO) {
      final var calendarUser = entitiesDTOsMapper.toEntity(calendarUserDTO);
      return entitiesDTOsMapper.toDTO(systemCalendarUserService.save(calendarUser));
   }
   
   @CrossOrigin
   @GetMapping("")
   CalendarUserDTO findByUserName(@RequestParam String userName) {
      return entitiesDTOsMapper.toDTO(systemCalendarUserService.findByUserName(userName));
   }
   
}