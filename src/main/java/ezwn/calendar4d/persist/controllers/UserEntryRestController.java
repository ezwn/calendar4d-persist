package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntryDTOMapper;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.services.UserEntryService;
import ezwn.persist.security.PrincipalSchemaAdapter;
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
   private final PrincipalSchemaAdapter principalSchemaAdapter;
   
   public UserEntryRestController(final EntryDTOMapper entitiesDTOsMapper, final UserEntryService userEntryService, final PrincipalSchemaAdapter principalSchemaAdapter) {
      this.userEntryService = userEntryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
      this.principalSchemaAdapter = principalSchemaAdapter;
   }
   
   @CrossOrigin
   @GetMapping("mine")
   public Iterable<EntryDTO> findAllMine(java.security.Principal principal) {
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.findAllByCalendarUser(calendarUser));
   }
   
   @CrossOrigin
   @GetMapping("mine/find-all-mine-by-modification-time-after")
   public Iterable<EntryDTO> findAllMineByModificationTimeAfter(java.security.Principal principal, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)java.time.LocalDateTime modificationTime) {
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.findAllByCalendarUserAndModificationTimeAfter(calendarUser, modificationTime));
   }
   
   @CrossOrigin
   @PostMapping("mine")
   public EntryDTO saveMine(java.security.Principal principal, @RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.save(entry));
   }
   
   @CrossOrigin
   @PostMapping("save-all-mine")
   public Iterable<EntryDTO> saveAllMine(java.security.Principal principal, @RequestBody Iterable<EntryDTO> entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.saveAll(entry));
   }
   
   @CrossOrigin
   @DeleteMapping("mine")
   public void deleteMine(java.security.Principal principal, @RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      userEntryService.delete(entry);
   }
   
}