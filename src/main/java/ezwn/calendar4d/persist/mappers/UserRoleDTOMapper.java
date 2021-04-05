package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.UserRoleDTO;
import ezwn.calendar4d.persist.schema.UserRole;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRoleDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public UserRoleDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public UserRole toEntity(UserRoleDTO userRoleDTO) {
      final var userRole = new UserRole();
      userRole.setId(userRoleDTO.getId());
      userRole.setUserId(userRoleDTO.getUserId());
      userRole.setRole(userRoleDTO.getRole());
      return userRole;
   }
   
   public Iterable<UserRole> toEntity(Iterable<UserRoleDTO> userRoleDTOIterable) {
      return StreamSupport.stream(userRoleDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public UserRoleDTO toDTO(UserRole userRole) {
      final var userRoleDTO = new UserRoleDTO();
      userRoleDTO.setId(userRole.getId());
      userRoleDTO.setUserId(userRole.getUserId());
      userRoleDTO.setRole(userRole.getRole());
      return userRoleDTO;
   }
   
   public Iterable<UserRoleDTO> toDTO(Iterable<UserRole> userRoleIterable) {
      return StreamSupport.stream(userRoleIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}