package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.SystemCalendarUserRepository;
import ezwn.calendar4d.persist.schema.CalendarUser;
import org.springframework.stereotype.Service;

@Service
public class SystemCalendarUserService {
   
   private final SystemCalendarUserRepository systemCalendarUserRepository;
   
   public SystemCalendarUserService(SystemCalendarUserRepository systemCalendarUserRepository) {
      this.systemCalendarUserRepository = systemCalendarUserRepository;
   }
   
   public CalendarUser save(CalendarUser calendarUser) {
      return systemCalendarUserRepository.save(calendarUser);
   }
   
   public CalendarUser findByUserName(String userName) {
      return systemCalendarUserRepository.findByUserName(userName);
   }
   
}