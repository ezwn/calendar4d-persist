package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.PhysicalActivityService;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/physical-activity", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhysicalActivityRestController {
   
   private PhysicalActivityService physicalActivityService;
   private EntitiesDTOsMapper entitiesDTOsMapper;
   
   public PhysicalActivityRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final PhysicalActivityService physicalActivityService) {
      this.physicalActivityService = physicalActivityService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<PhysicalActivityDTO> findAll() {
      return StreamSupport.stream(physicalActivityService.findAll().spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<PhysicalActivityDTO> findById(@PathVariable String id) {
      return physicalActivityService.findById(id).map(i -> entitiesDTOsMapper.toDTO(i));
   }
   
}