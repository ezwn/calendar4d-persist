package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.UserRepository;
import ezwn.calendar4d.persist.schema.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   
   private final UserRepository userRepository;
   
   public UserService(final UserRepository userRepository) {
      this.userRepository = userRepository;
   }
   
   public User save(User user) {
      return userRepository.save(user);
   }
   
   public void saveAll(final Iterable<User> userIterable) {
      userRepository.saveAll(userIterable);
   }
   
   public Iterable<User> findAll() {
      return userRepository.findAll();
   }
   
   public Optional<User> findById(String id) {
      return userRepository.findById(id);
   }
   
   public void delete(final User user) {
      userRepository.delete(user);
   }
   
}