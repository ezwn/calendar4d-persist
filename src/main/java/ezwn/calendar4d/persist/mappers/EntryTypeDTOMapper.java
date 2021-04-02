package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.schema.EntryType;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EntryTypeDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public EntryTypeDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public EntryType toEntity(EntryTypeDTO entryTypeDTO) {
      final var entryType = new EntryType();
      entryType.setId(entryTypeDTO.getId());
      entryType.setCalendarUser(entryTypeDTO.getCalendarUser());
      entryType.setEntryTypeClass(entryTypeDTO.getEntryTypeClass());
      entryType.setName(entryTypeDTO.getName());
      entryType.setEnergyPerHour(entryTypeDTO.getEnergyPerHour());
      return entryType;
   }
   
   public Iterable<EntryType> toEntity(Iterable<EntryTypeDTO> entryTypeDTOIterable) {
      return StreamSupport.stream(entryTypeDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public EntryTypeDTO toDTO(EntryType entryType) {
      final var entryTypeDTO = new EntryTypeDTO();
      entryTypeDTO.setId(entryType.getId());
      entryTypeDTO.setCalendarUser(entryType.getCalendarUser());
      entryTypeDTO.setEntryTypeClass(entryType.getEntryTypeClass());
      entryTypeDTO.setName(entryType.getName());
      entryTypeDTO.setEnergyPerHour(entryType.getEnergyPerHour());
      return entryTypeDTO;
   }
   
   public Iterable<EntryTypeDTO> toDTO(Iterable<EntryType> entryTypeIterable) {
      return StreamSupport.stream(entryTypeIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}