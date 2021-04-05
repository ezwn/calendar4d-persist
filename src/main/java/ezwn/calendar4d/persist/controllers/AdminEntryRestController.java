package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntryDTOMapper;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.services.AdminEntryService;
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

@RolesAllowed("ADMIN")
@RestController
@RequestMapping(value="/api/v1/admin/entry", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminEntryRestController {
   
   private final AdminEntryService adminEntryService;
   private final EntryDTOMapper entitiesDTOsMapper;
   
   public AdminEntryRestController(final EntryDTOMapper entitiesDTOsMapper, final AdminEntryService adminEntryService) {
      this.adminEntryService = adminEntryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<EntryDTO> findAll() {
      return entitiesDTOsMapper.toDTO(adminEntryService.findAll());
   }
   
   @CrossOrigin
   @PostMapping("")
   public EntryDTO save(@RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      return entitiesDTOsMapper.toDTO(adminEntryService.save(entry));
   }
   
   @CrossOrigin
   @PostMapping("save-all")
   public Iterable<EntryDTO> saveAll(@RequestBody Iterable<EntryDTO> entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      return entitiesDTOsMapper.toDTO(adminEntryService.saveAll(entry));
   }
   
   @CrossOrigin
   @DeleteMapping("")
   public void delete(@RequestBody EntryDTO entryDTO) {
      final var entry = entitiesDTOsMapper.toEntity(entryDTO);
      adminEntryService.delete(entry);
   }
   
}