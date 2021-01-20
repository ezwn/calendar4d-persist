package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.SubjectEntryTypeDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.SubjectEntryTypeService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/subject-entry-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectEntryTypeRestController {
   
   private SubjectEntryTypeService subjectEntryTypeService;
   
   public SubjectEntryTypeRestController(final SubjectEntryTypeService subjectEntryTypeService) {
      this.subjectEntryTypeService = subjectEntryTypeService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final SubjectEntryTypeDTO subjectEntryTypeDTO) {
      subjectEntryTypeService.save(EntitiesDTOsMapper.toEntity(subjectEntryTypeDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<SubjectEntryTypeDTO> subjectEntryTypeDTOList) {
      subjectEntryTypeService.saveAll(subjectEntryTypeDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<SubjectEntryTypeDTO> findAll() {
      return StreamSupport.stream(subjectEntryTypeService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
}