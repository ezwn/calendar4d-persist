package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.TopicRepository;
import ezwn.calendar4d.persist.schema.Topic;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
   
   private final TopicRepository topicRepository;
   
   public TopicService(final TopicRepository topicRepository) {
      this.topicRepository = topicRepository;
   }
   
   public Topic save(Topic topic) {
      return topicRepository.save(topic);
   }
   
   public void saveAll(final Iterable<Topic> topicIterable) {
      topicRepository.saveAll(topicIterable);
   }
   
   public Iterable<Topic> findAll() {
      return topicRepository.findAll();
   }
   
   public Optional<Topic> findById(String id) {
      return topicRepository.findById(id);
   }
   
   public void delete(final Topic topic) {
      topicRepository.delete(topic);
   }
   
}