package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.CalendarUser;
import org.springframework.data.repository.CrudRepository;

public interface CalendarUserRepository extends CrudRepository<CalendarUser, String> {

   CalendarUser findByUserName(String param0);

}