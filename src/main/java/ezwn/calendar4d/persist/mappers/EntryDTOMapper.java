package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.schema.Entry;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EntryDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public EntryDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public Entry toEntity(EntryDTO entryDTO) {
      final var entry = new Entry();
      entry.setId(entryDTO.getId());
      entry.setCalendarUser(entryDTO.getCalendarUser());
      entry.setType(entryDTO.getType());
      entry.setTopic(entryDTO.getTopic());
      entry.setTime(entryDTO.getTime());
      entry.setDuration(entryDTO.getDuration());
      entry.setLatitude(entryDTO.getLatitude());
      entry.setLongitude(entryDTO.getLongitude());
      entry.setComment(entryDTO.getComment());
      entry.setModificationTime(entryDTO.getModificationTime());
      entry.setDeleted(entryDTO.getDeleted());
      return entry;
   }
   
   public Iterable<Entry> toEntity(Iterable<EntryDTO> entryDTOIterable) {
      return StreamSupport.stream(entryDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public EntryDTO toDTO(Entry entry) {
      final var entryDTO = new EntryDTO();
      entryDTO.setId(entry.getId());
      entryDTO.setCalendarUser(entry.getCalendarUser());
      entryDTO.setType(entry.getType());
      entryDTO.setTopic(entry.getTopic());
      entryDTO.setTime(entry.getTime());
      entryDTO.setDuration(entry.getDuration());
      entryDTO.setLatitude(entry.getLatitude());
      entryDTO.setLongitude(entry.getLongitude());
      entryDTO.setComment(entry.getComment());
      entryDTO.setModificationTime(entry.getModificationTime());
      entryDTO.setDeleted(entry.getDeleted());
      return entryDTO;
   }
   
   public Iterable<EntryDTO> toDTO(Iterable<Entry> entryIterable) {
      return StreamSupport.stream(entryIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}