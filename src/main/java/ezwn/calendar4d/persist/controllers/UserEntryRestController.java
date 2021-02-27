package ezwn.calendar4d.persist.controllers;

import data.mng.lang.persist.services.PrincipalKeySolver;
import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.services.UserEntryService;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping(value="/api/v1/user/entry", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEntryRestController {
   
   private final UserEntryService userEntryService;
   private final EntitiesDTOsMapper entitiesDTOsMapper;
   private final PrincipalKeySolver principalKeySolver;
   
   public UserEntryRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final UserEntryService userEntryService, final PrincipalKeySolver principalKeySolver) {
      this.userEntryService = userEntryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
      this.principalKeySolver = principalKeySolver;
   }
   
   @CrossOrigin
   @GetMapping("find-all-mine")
   Iterable<EntryDTO> findAllMine(java.security.Principal principal) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return StreamSupport.stream(userEntryService.findAllByCalendarUser(calendarUser).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("find-all-mine-by-modification-time-after")
   Iterable<EntryDTO> findAllMineByModificationTimeAfter(java.security.Principal principal, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)java.time.LocalDateTime modificationTime) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return StreamSupport.stream(userEntryService.findAllByCalendarUserAndModificationTimeAfter(calendarUser, modificationTime).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("save-mine")
   EntryDTO saveMine(java.security.Principal principal, Entry entry) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userEntryService.save(entry));
   }
   
   @CrossOrigin
   @GetMapping("save-all-mine")
   Iterable<EntryDTO> saveAllMine(java.security.Principal principal, Iterable<Entry> entry) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      return StreamSupport.stream(userEntryService.saveAll(entry).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("delete-mine")
   void deleteMine(java.security.Principal principal, Entry entry) {
      final String calendarUser = principalKeySolver.principalKey(principal).get();
      userEntryService.delete(entry);
   }
   
}