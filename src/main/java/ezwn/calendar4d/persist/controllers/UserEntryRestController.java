package ezwn.calendar4d.persist.controllers;

import data.mng.lang.persist.services.PrincipalKeySolver;
import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntryDTOMapper;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.services.UserEntryService;
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
@RequestMapping(value="/api/v1/user/entry", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEntryRestController {
   
   private final UserEntryService userEntryService;
   private final EntryDTOMapper entitiesDTOsMapper;
   private final PrincipalKeySolver principalKeySolver;
   
   public UserEntryRestController(final EntryDTOMapper entitiesDTOsMapper, final UserEntryService userEntryService, final PrincipalKeySolver principalKeySolver) {
      this.userEntryService = userEntryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
      this.principalKeySolver = principalKeySolver;
   }
   
   @CrossOrigin
   @GetMapping("find-all-mine")
   Iterable<EntryDTO> findAllMine(java.security.Principal principal) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.findAllByCalendarUser(calendarUser));
   }
   
   @CrossOrigin
   @GetMapping("find-all-mine-by-modification-time-after")
   Iterable<EntryDTO> findAllMineByModificationTimeAfter(java.security.Principal principal, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)java.time.LocalDateTime modificationTime) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.findAllByCalendarUserAndModificationTimeAfter(calendarUser, modificationTime));
   }
   
   @CrossOrigin
   @PostMapping("save-mine")
   EntryDTO saveMine(java.security.Principal principal, @RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.save(entry));
   }
   
   @CrossOrigin
   @PostMapping("save-all-mine")
   Iterable<EntryDTO> saveAllMine(java.security.Principal principal, @RequestBody Iterable<EntryDTO> entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.saveAll(entry));
   }
   
   @CrossOrigin
   @DeleteMapping("delete-mine")
   void deleteMine(java.security.Principal principal, @RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      userEntryService.delete(entry);
   }
   
}