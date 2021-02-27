package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.UserRole;
import org.springframework.data.repository.Repository;

public interface SystemUserRoleRepository extends Repository<UserRole, String> {

   Iterable<UserRole> findAllByUserId(String userId);

}