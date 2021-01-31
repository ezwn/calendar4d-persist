package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.CalendarUserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/calendar-user", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalendarUserRestController {
   
   private CalendarUserService calendarUserService;
   
   public CalendarUserRestController(final CalendarUserService calendarUserService) {
      this.calendarUserService = calendarUserService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final CalendarUserDTO calendarUserDTO) {
      calendarUserService.save(EntitiesDTOsMapper.toEntity(calendarUserDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<CalendarUserDTO> calendarUserDTOList) {
      calendarUserService.saveAll(calendarUserDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<CalendarUserDTO> findAll() {
      return StreamSupport.stream(calendarUserService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<CalendarUserDTO> findById(@PathVariable String id) {
      return calendarUserService.findById(id).map(EntitiesDTOsMapper::toDTO);
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final CalendarUserDTO calendarUserDTO) {
      calendarUserService.delete(EntitiesDTOsMapper.toEntity(calendarUserDTO));
   }
   
   @CrossOrigin
   @GetMapping("/find-by-user-name")
   public CalendarUserDTO findByUserName(
      @RequestParam String param0
   ) {
      return EntitiesDTOsMapper.toDTO(calendarUserService.findByUserName(param0));
   }
   
}