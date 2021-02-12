package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.PhysicalActivityService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping(value="/physical-activity/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhysicalActivityRestAdminController {
   
   private PhysicalActivityService physicalActivityService;
   private EntitiesDTOsMapper entitiesDTOsMapper;
   
   public PhysicalActivityRestAdminController(final EntitiesDTOsMapper entitiesDTOsMapper, final PhysicalActivityService physicalActivityService) {
      this.physicalActivityService = physicalActivityService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final PhysicalActivityDTO physicalActivityDTO) {
      physicalActivityService.save(entitiesDTOsMapper.toEntity(physicalActivityDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<PhysicalActivityDTO> physicalActivityDTOList) {
      physicalActivityService.saveAll(physicalActivityDTOList.stream().map(i -> entitiesDTOsMapper.toEntity(i)).collect(Collectors.toList()));
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
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final PhysicalActivityDTO physicalActivityDTO) {
      physicalActivityService.delete(entitiesDTOsMapper.toEntity(physicalActivityDTO));
   }
   
}