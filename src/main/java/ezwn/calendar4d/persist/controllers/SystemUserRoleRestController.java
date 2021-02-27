package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.UserRoleDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.schema.UserRole;
import ezwn.calendar4d.persist.services.SystemUserRoleService;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('SYSTEM')")
@RestController
@RequestMapping(value="/api/v1/system/user-role", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemUserRoleRestController {
   
   private final SystemUserRoleService systemUserRoleService;
   private final EntitiesDTOsMapper entitiesDTOsMapper;
   
   public SystemUserRoleRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final SystemUserRoleService systemUserRoleService) {
      this.systemUserRoleService = systemUserRoleService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("find-all-by-user-id")
   Iterable<UserRoleDTO> findAllByUserId(@RequestParam String userId) {
      return StreamSupport.stream(systemUserRoleService.findAllByUserId(userId).spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
}