package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.PhysicalActivityStatsDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.PhysicalActivityStatsService;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping(value="/physical-activity-stats/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhysicalActivityStatsRestAdminController {
   
   private PhysicalActivityStatsService physicalActivityStatsService;
   private EntitiesDTOsMapper entitiesDTOsMapper;
   
   public PhysicalActivityStatsRestAdminController(final EntitiesDTOsMapper entitiesDTOsMapper, final PhysicalActivityStatsService physicalActivityStatsService) {
      this.physicalActivityStatsService = physicalActivityStatsService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<PhysicalActivityStatsDTO> findAll() {
      return StreamSupport.stream(physicalActivityStatsService.findAll().spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<PhysicalActivityStatsDTO> findById(@PathVariable String id) {
      return physicalActivityStatsService.findById(id).map(i -> entitiesDTOsMapper.toDTO(i));
   }
   
}