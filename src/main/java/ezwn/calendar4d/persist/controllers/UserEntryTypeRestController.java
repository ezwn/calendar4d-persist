package ezwn.calendar4d.persist.controllers;

import data.mng.lang.persist.services.PrincipalKeySolver;
import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.mappers.EntryTypeDTOMapper;
import ezwn.calendar4d.persist.schema.EntryType;
import ezwn.calendar4d.persist.services.UserEntryTypeService;
import javax.annotation.security.RolesAllowed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RolesAllowed("USER")
@RestController
@RequestMapping(value="/api/v1/user/entry-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEntryTypeRestController {
   
   private final UserEntryTypeService userEntryTypeService;
   private final EntryTypeDTOMapper entitiesDTOsMapper;
   private final PrincipalKeySolver principalKeySolver;
   
   public UserEntryTypeRestController(final EntryTypeDTOMapper entitiesDTOsMapper, final UserEntryTypeService userEntryTypeService, final PrincipalKeySolver principalKeySolver) {
      this.userEntryTypeService = userEntryTypeService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
      this.principalKeySolver = principalKeySolver;
   }
   
   @CrossOrigin
   @GetMapping("mine")
   Iterable<EntryTypeDTO> findAllMine(java.security.Principal principal) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryTypeService.findAllByCalendarUser(calendarUser));
   }
   
   @CrossOrigin
   @PostMapping("mine")
   EntryTypeDTO saveMine(java.security.Principal principal, @RequestBody EntryTypeDTO entryTypeDTO) {
      final var entryType = entitiesDTOsMapper.toEntity(entryTypeDTO);
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryTypeService.save(entryType));
   }
   
   @CrossOrigin
   @DeleteMapping("mine")
   void deleteMine(java.security.Principal principal, @RequestBody EntryTypeDTO entryTypeDTO) {
      final var entryType = entitiesDTOsMapper.toEntity(entryTypeDTO);
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      userEntryTypeService.delete(entryType);
   }
   
}