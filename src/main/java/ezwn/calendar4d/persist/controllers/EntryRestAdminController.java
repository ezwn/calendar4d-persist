package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.EntryService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping(value="/entry/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryRestAdminController {
   
   private EntryService entryService;
   private EntitiesDTOsMapper entitiesDTOsMapper;
   
   public EntryRestAdminController(final EntitiesDTOsMapper entitiesDTOsMapper, final EntryService entryService) {
      this.entryService = entryService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final EntryDTO entryDTO) {
      entryService.save(entitiesDTOsMapper.toEntity(entryDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<EntryDTO> entryDTOList) {
      entryService.saveAll(entryDTOList.stream().map(i -> entitiesDTOsMapper.toEntity(i)).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<EntryDTO> findAll() {
      return StreamSupport.stream(entryService.findAll().spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<EntryDTO> findById(@PathVariable String id) {
      return entryService.findById(id).map(i -> entitiesDTOsMapper.toDTO(i));
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final EntryDTO entryDTO) {
      entryService.delete(entitiesDTOsMapper.toEntity(entryDTO));
   }
   
   @CrossOrigin
   @GetMapping("/find-all-by-modification-time-after")
   public Iterable<EntryDTO> findAllByModificationTimeAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime param0) {
      return StreamSupport.stream(entryService.findAllByModificationTimeAfter(param0).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
}