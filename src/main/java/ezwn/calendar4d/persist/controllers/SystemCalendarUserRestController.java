package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.calendar4d.persist.services.SystemCalendarUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('SYSTEM')")
@RestController
@RequestMapping(value="/api/v1/system/calendar-user", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemCalendarUserRestController {
   
   private final SystemCalendarUserService systemCalendarUserService;
   private final EntitiesDTOsMapper entitiesDTOsMapper;
   
   public SystemCalendarUserRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final SystemCalendarUserService systemCalendarUserService) {
      this.systemCalendarUserService = systemCalendarUserService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("save")
   CalendarUserDTO save(CalendarUser calendarUser) {
      return entitiesDTOsMapper.toDTO(systemCalendarUserService.save(calendarUser));
   }
   
   @CrossOrigin
   @GetMapping("find-by-user-name")
   CalendarUserDTO findByUserName(@RequestParam String userName) {
      return entitiesDTOsMapper.toDTO(systemCalendarUserService.findByUserName(userName));
   }
   
}