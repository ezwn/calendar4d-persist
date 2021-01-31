package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.EntryTypeService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/entry-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryTypeRestController {
   
   private EntryTypeService entryTypeService;
   
   public EntryTypeRestController(final EntryTypeService entryTypeService) {
      this.entryTypeService = entryTypeService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final EntryTypeDTO entryTypeDTO) {
      entryTypeService.save(EntitiesDTOsMapper.toEntity(entryTypeDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<EntryTypeDTO> entryTypeDTOList) {
      entryTypeService.saveAll(entryTypeDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<EntryTypeDTO> findAll() {
      return StreamSupport.stream(entryTypeService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<EntryTypeDTO> findById(@PathVariable String id) {
      return entryTypeService.findById(id).map(EntitiesDTOsMapper::toDTO);
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final EntryTypeDTO entryTypeDTO) {
      entryTypeService.delete(EntitiesDTOsMapper.toEntity(entryTypeDTO));
   }
   
}