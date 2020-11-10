package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.EntryService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/entry", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryRestController {
   
   private EntryService entryService;
   
   public EntryRestController(final EntryService entryService) {
      this.entryService = entryService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final EntryDTO entryDTO) {
      entryService.save(EntitiesDTOsMapper.toEntity(entryDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<EntryDTO> entryDTOList) {
      entryService.saveAll(entryDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<EntryDTO> findAll() {
      return StreamSupport.stream(entryService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/find-all-by-modification-time-after")
   public Iterable<EntryDTO> findAllByModificationTimeAfter(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime param0
   ) {
      return StreamSupport.stream(entryService.findAllByModificationTimeAfter(param0).spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
}