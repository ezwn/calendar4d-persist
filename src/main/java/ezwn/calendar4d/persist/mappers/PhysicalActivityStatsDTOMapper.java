package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.PhysicalActivityStatsDTO;
import ezwn.calendar4d.persist.schema.PhysicalActivityStats;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityStatsDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public PhysicalActivityStatsDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public PhysicalActivityStats toEntity(PhysicalActivityStatsDTO physicalActivityStatsDTO) {
      final var physicalActivityStats = new PhysicalActivityStats();
      physicalActivityStats.setDate(physicalActivityStatsDTO.getDate());
      physicalActivityStats.setDuration(physicalActivityStatsDTO.getDuration());
      physicalActivityStats.setEnergy(physicalActivityStatsDTO.getEnergy());
      return physicalActivityStats;
   }
   
   public Iterable<PhysicalActivityStats> toEntity(Iterable<PhysicalActivityStatsDTO> physicalActivityStatsDTOIterable) {
      return StreamSupport.stream(physicalActivityStatsDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public PhysicalActivityStatsDTO toDTO(PhysicalActivityStats physicalActivityStats) {
      final var physicalActivityStatsDTO = new PhysicalActivityStatsDTO();
      physicalActivityStatsDTO.setDate(physicalActivityStats.getDate());
      physicalActivityStatsDTO.setDuration(physicalActivityStats.getDuration());
      physicalActivityStatsDTO.setEnergy(physicalActivityStats.getEnergy());
      return physicalActivityStatsDTO;
   }
   
   public Iterable<PhysicalActivityStatsDTO> toDTO(Iterable<PhysicalActivityStats> physicalActivityStatsIterable) {
      return StreamSupport.stream(physicalActivityStatsIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}