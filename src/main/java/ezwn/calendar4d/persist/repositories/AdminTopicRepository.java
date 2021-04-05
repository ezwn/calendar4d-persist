package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Topic;
import org.springframework.data.repository.Repository;

public interface AdminTopicRepository extends Repository<Topic, String> {

   Iterable<Topic> findAll();
   Topic save(Topic topic);
   void delete(Topic topic);

}