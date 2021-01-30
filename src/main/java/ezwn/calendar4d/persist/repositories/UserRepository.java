package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}