package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}