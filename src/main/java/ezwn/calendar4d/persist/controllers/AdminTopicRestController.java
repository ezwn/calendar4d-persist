package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.TopicDTO;
import ezwn.calendar4d.persist.mappers.TopicDTOMapper;
import ezwn.calendar4d.persist.schema.Topic;
import ezwn.calendar4d.persist.services.AdminTopicService;
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
@RequestMapping(value="/api/v1/admin/topic", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminTopicRestController {
   
   private final AdminTopicService adminTopicService;
   private final TopicDTOMapper entitiesDTOsMapper;
   
   public AdminTopicRestController(final TopicDTOMapper entitiesDTOsMapper, final AdminTopicService adminTopicService) {
      this.adminTopicService = adminTopicService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @GetMapping("")
   Iterable<TopicDTO> findAll() {
      return entitiesDTOsMapper.toDTO(adminTopicService.findAll());
   }
   
   @CrossOrigin
   @PostMapping("")
   TopicDTO save(@RequestBody TopicDTO topicDTO) {
      final var topic = entitiesDTOsMapper.toEntity(topicDTO);
      return entitiesDTOsMapper.toDTO(adminTopicService.save(topic));
   }
   
   @CrossOrigin
   @DeleteMapping("")
   void delete(@RequestBody TopicDTO topicDTO) {
      final var topic = entitiesDTOsMapper.toEntity(topicDTO);
      adminTopicService.delete(topic);
   }
   
}