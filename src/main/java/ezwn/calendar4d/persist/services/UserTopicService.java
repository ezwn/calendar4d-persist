package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.UserTopicRepository;
import ezwn.calendar4d.persist.schema.Topic;
import org.springframework.stereotype.Service;

@Service
public class UserTopicService {
   
   private final UserTopicRepository userTopicRepository;
   
   public UserTopicService(UserTopicRepository userTopicRepository) {
      this.userTopicRepository = userTopicRepository;
   }
   
   public Iterable<Topic> findAllByCalendarUser(String calendarUser) {
      return userTopicRepository.findAllByCalendarUser(calendarUser);
   }
   
   public Topic save(Topic topic) {
      return userTopicRepository.save(topic);
   }
   
   public void delete(Topic topic) {
      userTopicRepository.delete(topic);
   }
   
}