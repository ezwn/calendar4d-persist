package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.services.AdminEntryService;
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

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(value="/api/v1/admin/entry", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminEntryRestController {
   
   private final AdminEntryService adminEntryService;
   private final EntitiesDTOsMapper entitiesDTOsMapper;
   
   public AdminEntryRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final AdminEntryService adminEntryService) {
      this.adminEntryService = adminEntryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("find-all")
   Iterable<EntryDTO> findAll() {
      return StreamSupport.stream(adminEntryService.findAll().spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("save")
   EntryDTO save(Entry entry) {
      return entitiesDTOsMapper.toDTO(adminEntryService.save(entry));
   }
   
   @CrossOrigin
   @GetMapping("save-all")
   Iterable<EntryDTO> saveAll(Iterable<Entry> entry) {
      return StreamSupport.stream(adminEntryService.saveAll(entry).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("delete")
   void delete(Entry entry) {
      adminEntryService.delete(entry);
   }
   
}