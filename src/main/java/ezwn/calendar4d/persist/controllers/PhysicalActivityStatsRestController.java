package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.PhysicalActivityStatsDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.PhysicalActivityStatsService;
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
@RequestMapping(value="/physical-activity-stats", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhysicalActivityStatsRestController {
   
   private PhysicalActivityStatsService physicalActivityStatsService;
   
   public PhysicalActivityStatsRestController(final PhysicalActivityStatsService physicalActivityStatsService) {
      this.physicalActivityStatsService = physicalActivityStatsService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final PhysicalActivityStatsDTO physicalActivityStatsDTO) {
      physicalActivityStatsService.save(EntitiesDTOsMapper.toEntity(physicalActivityStatsDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<PhysicalActivityStatsDTO> physicalActivityStatsDTOList) {
      physicalActivityStatsService.saveAll(physicalActivityStatsDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<PhysicalActivityStatsDTO> findAll() {
      return StreamSupport.stream(physicalActivityStatsService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<PhysicalActivityStatsDTO> findById(@PathVariable String id) {
      return physicalActivityStatsService.findById(id).map(EntitiesDTOsMapper::toDTO);
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final PhysicalActivityStatsDTO physicalActivityStatsDTO) {
      physicalActivityStatsService.delete(EntitiesDTOsMapper.toEntity(physicalActivityStatsDTO));
   }
   
}