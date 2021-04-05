package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.CalendarUser;
import org.springframework.data.repository.Repository;

public interface SystemCalendarUserRepository extends Repository<CalendarUser, String> {

   CalendarUser save(CalendarUser calendarUser);
   CalendarUser findByUserName(String userName);

}