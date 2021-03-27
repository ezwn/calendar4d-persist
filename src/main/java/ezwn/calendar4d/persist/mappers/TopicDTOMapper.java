package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.TopicDTO;
import ezwn.calendar4d.persist.schema.Topic;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TopicDTOMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public TopicDTOMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public Topic toEntity(TopicDTO topicDTO) {
      final var topic = new Topic();
      topic.setId(topicDTO.getId());
      topic.setCalendarUser(topicDTO.getCalendarUser());
      topic.setName(topicDTO.getName());
      return topic;
   }
   
   public Iterable<Topic> toEntity(Iterable<TopicDTO> topicDTOIterable) {
      return StreamSupport.stream(topicDTOIterable.spliterator(), false)
         .map(item -> toEntity(item)).collect(Collectors.toList());
   }
   
   public TopicDTO toDTO(Topic topic) {
      final var topicDTO = new TopicDTO();
      topicDTO.setId(topic.getId());
      topicDTO.setCalendarUser(topic.getCalendarUser());
      topicDTO.setName(topic.getName());
      return topicDTO;
   }
   
   public Iterable<TopicDTO> toDTO(Iterable<Topic> topicIterable) {
      return StreamSupport.stream(topicIterable.spliterator(), false)
         .map(item -> toDTO(item)).collect(Collectors.toList());
   }
   
}