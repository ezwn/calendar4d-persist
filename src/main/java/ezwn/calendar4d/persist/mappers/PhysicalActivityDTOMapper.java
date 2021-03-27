package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.schema.PhysicalActivity;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public PhysicalActivityDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public PhysicalActivity toEntity(PhysicalActivityDTO physicalActivityDTO) {
      final var physicalActivity = new PhysicalActivity();
      physicalActivity.setId(physicalActivityDTO.getId());
      physicalActivity.setEnergy(physicalActivityDTO.getEnergy());
      return physicalActivity;
   }
   
   public Iterable<PhysicalActivity> toEntity(Iterable<PhysicalActivityDTO> physicalActivityDTOIterable) {
      return StreamSupport.stream(physicalActivityDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public PhysicalActivityDTO toDTO(PhysicalActivity physicalActivity) {
      final var physicalActivityDTO = new PhysicalActivityDTO();
      physicalActivityDTO.setId(physicalActivity.getId());
      physicalActivityDTO.setEnergy(physicalActivity.getEnergy());
      return physicalActivityDTO;
   }
   
   public Iterable<PhysicalActivityDTO> toDTO(Iterable<PhysicalActivity> physicalActivityIterable) {
      return StreamSupport.stream(physicalActivityIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}