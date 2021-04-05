package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Topic;
import org.springframework.data.repository.Repository;

public interface UserTopicRepository extends Repository<Topic, String> {

   Iterable<Topic> findAllByCalendarUser(String calendarUser);
   Topic save(Topic topic);
   void delete(Topic topic);

}