package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.UserDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.UserService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
   
   private UserService userService;
   
   public UserRestController(final UserService userService) {
      this.userService = userService;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final UserDTO userDTO) {
      userService.save(EntitiesDTOsMapper.toEntity(userDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<UserDTO> userDTOList) {
      userService.saveAll(userDTOList.stream().map(EntitiesDTOsMapper::toEntity).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<UserDTO> findAll() {
      return StreamSupport.stream(userService.findAll().spliterator(), false).map(EntitiesDTOsMapper::toDTO).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<UserDTO> findById(@PathVariable String id) {
      return userService.findById(id).map(EntitiesDTOsMapper::toDTO);
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final UserDTO userDTO) {
      userService.delete(EntitiesDTOsMapper.toEntity(userDTO));
   }
   
}