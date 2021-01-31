package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.CalendarUserRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CalendarUserService {
   
   private final CalendarUserRepository calendarUserRepository;
   
   public CalendarUserService(final CalendarUserRepository calendarUserRepository) {
      this.calendarUserRepository = calendarUserRepository;
   }
   
   public CalendarUser save(CalendarUser calendarUser) {
      return calendarUserRepository.save(calendarUser);
   }
   
   public void saveAll(final Iterable<CalendarUser> calendarUserIterable) {
      calendarUserRepository.saveAll(calendarUserIterable);
   }
   
   public Iterable<CalendarUser> findAll() {
      return calendarUserRepository.findAll();
   }
   
   public Optional<CalendarUser> findById(String id) {
      return calendarUserRepository.findById(id);
   }
   
   public void delete(final CalendarUser calendarUser) {
      calendarUserRepository.delete(calendarUser);
   }
   
   public CalendarUser findByUserName(String param0) {
      return calendarUserRepository.findByUserName(param0);
   }
   
}