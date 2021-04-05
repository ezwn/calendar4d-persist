package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.UserRoleDTO;
import ezwn.calendar4d.persist.mappers.UserRoleDTOMapper;
import ezwn.calendar4d.persist.schema.UserRole;
import ezwn.calendar4d.persist.services.SystemUserRoleService;
import javax.annotation.security.RolesAllowed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RolesAllowed("SYSTEM")
@RestController
@RequestMapping(value="/api/v1/system/user-role", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemUserRoleRestController {
   
   private final SystemUserRoleService systemUserRoleService;
   private final UserRoleDTOMapper entitiesDTOsMapper;
   
   public SystemUserRoleRestController(final UserRoleDTOMapper entitiesDTOsMapper, final SystemUserRoleService systemUserRoleService) {
      this.systemUserRoleService = systemUserRoleService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("find-all-by-user-id")
   public Iterable<UserRoleDTO> findAllByUserId(@RequestParam String userId) {
      return entitiesDTOsMapper.toDTO(systemUserRoleService.findAllByUserId(userId));
   }
   
}