package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.PhysicalActivityService;
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
@RequestMapping(value="/physical-activity", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhysicalActivityRestController {
   
   private PhysicalActivityService physicalActivityService;
   
   public PhysicalActivityRestController(final PhysicalActivityService physicalActivityService) {
      this.physicalActivityService = physicalActivityService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final PhysicalActivityDTO physicalActivityDTO) {
      physicalActivityService.save(EntitiesDTOsMapper.toEntity(physicalActivityDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<PhysicalActivityDTO> physicalActivityDTOList) {
      physicalActivityService.saveAll(physicalActivityDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<PhysicalActivityDTO> findAll() {
      return StreamSupport.stream(physicalActivityService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
}