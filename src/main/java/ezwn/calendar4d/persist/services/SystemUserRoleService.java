package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.SystemUserRoleRepository;
import ezwn.calendar4d.persist.schema.UserRole;
import org.springframework.stereotype.Service;

@Service
public class SystemUserRoleService {
   
   private final SystemUserRoleRepository systemUserRoleRepository;
   
   public SystemUserRoleService(SystemUserRoleRepository systemUserRoleRepository) {
      this.systemUserRoleRepository = systemUserRoleRepository;
   }
   
   public Iterable<UserRole> findAllByUserId(String userId) {
      return systemUserRoleRepository.findAllByUserId(userId);
   }
   
}