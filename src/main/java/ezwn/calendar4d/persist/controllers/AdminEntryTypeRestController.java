package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.mappers.EntryTypeDTOMapper;
import ezwn.calendar4d.persist.schema.EntryType;
import ezwn.calendar4d.persist.services.AdminEntryTypeService;
import javax.annotation.security.RolesAllowed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RolesAllowed("ADMIN")
@RestController
@RequestMapping(value="/api/v1/admin/entry-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminEntryTypeRestController {
   
   private final AdminEntryTypeService adminEntryTypeService;
   private final EntryTypeDTOMapper entitiesDTOsMapper;
   
   public AdminEntryTypeRestController(final EntryTypeDTOMapper entitiesDTOsMapper, final AdminEntryTypeService adminEntryTypeService) {
      this.adminEntryTypeService = adminEntryTypeService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("")
   Iterable<EntryTypeDTO> findAll() {
      return entitiesDTOsMapper.toDTO(adminEntryTypeService.findAll());
   }
   
   @CrossOrigin
   @PostMapping("")
   EntryTypeDTO save(@RequestBody EntryTypeDTO entryTypeDTO) {
      final var entryType = entitiesDTOsMapper.toEntity(entryTypeDTO);
      return entitiesDTOsMapper.toDTO(adminEntryTypeService.save(entryType));
   }
   
   @CrossOrigin
   @DeleteMapping("")
   void delete(@RequestBody EntryTypeDTO entryTypeDTO) {
      final var entryType = entitiesDTOsMapper.toEntity(entryTypeDTO);
      adminEntryTypeService.delete(entryType);
   }
   
}