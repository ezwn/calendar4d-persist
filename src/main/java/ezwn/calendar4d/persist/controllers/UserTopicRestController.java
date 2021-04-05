package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.TopicDTO;
import ezwn.calendar4d.persist.mappers.TopicDTOMapper;
import ezwn.calendar4d.persist.schema.Topic;
import ezwn.calendar4d.persist.services.UserTopicService;
import ezwn.persist.security.PrincipalSchemaAdapter;
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

@RolesAllowed("USER")
@RestController
@RequestMapping(value="/api/v1/user/topic", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserTopicRestController {
   
   private final UserTopicService userTopicService;
   private final TopicDTOMapper entitiesDTOsMapper;
   private final PrincipalSchemaAdapter principalSchemaAdapter;
   
   public UserTopicRestController(final TopicDTOMapper entitiesDTOsMapper, final UserTopicService userTopicService, final PrincipalSchemaAdapter principalSchemaAdapter) {
      this.userTopicService = userTopicService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
      this.principalSchemaAdapter = principalSchemaAdapter;
   }
   
   @CrossOrigin
   @GetMapping("mine")
   public Iterable<TopicDTO> findAllMine(java.security.Principal principal) {
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userTopicService.findAllByCalendarUser(calendarUser));
   }
   
   @CrossOrigin
   @PostMapping("mine")
   public TopicDTO saveMine(java.security.Principal principal, @RequestBody TopicDTO topicDTO) {
      final var topic = entitiesDTOsMapper.toEntity(topicDTO);
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      return entitiesDTOsMapper.toDTO(userTopicService.save(topic));
   }
   
   @CrossOrigin
   @DeleteMapping("mine")
   public void deleteMine(java.security.Principal principal, @RequestBody TopicDTO topicDTO) {
      final var topic = entitiesDTOsMapper.toEntity(topicDTO);
      final String calendarUser = principalSchemaAdapter.principalKey(principal).get();
      userTopicService.delete(topic);
   }
   
}