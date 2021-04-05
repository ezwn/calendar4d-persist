package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.AdminTopicRepository;
import ezwn.calendar4d.persist.schema.Topic;
import org.springframework.stereotype.Service;

@Service
public class AdminTopicService {
   
   private final AdminTopicRepository adminTopicRepository;
   
   public AdminTopicService(AdminTopicRepository adminTopicRepository) {
      this.adminTopicRepository = adminTopicRepository;
   }
   
   public Iterable<Topic> findAll() {
      return adminTopicRepository.findAll();
   }
   
   public Topic save(Topic topic) {
      return adminTopicRepository.save(topic);
   }
   
   public void delete(Topic topic) {
      adminTopicRepository.delete(topic);
   }
   
}