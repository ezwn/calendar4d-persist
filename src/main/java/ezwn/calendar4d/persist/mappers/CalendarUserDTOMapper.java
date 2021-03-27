package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.schema.CalendarUser;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CalendarUserDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public CalendarUserDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public CalendarUser toEntity(CalendarUserDTO calendarUserDTO) {
      final var calendarUser = new CalendarUser();
      calendarUser.setUserName(calendarUserDTO.getUserName());
      calendarUser.setPassword(passwordEncoder.encode(calendarUserDTO.getPassword()));
      return calendarUser;
   }
   
   public Iterable<CalendarUser> toEntity(Iterable<CalendarUserDTO> calendarUserDTOIterable) {
      return StreamSupport.stream(calendarUserDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public CalendarUserDTO toDTO(CalendarUser calendarUser) {
      final var calendarUserDTO = new CalendarUserDTO();
      calendarUserDTO.setUserName(calendarUser.getUserName());
      return calendarUserDTO;
   }
   
   public Iterable<CalendarUserDTO> toDTO(Iterable<CalendarUser> calendarUserIterable) {
      return StreamSupport.stream(calendarUserIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}