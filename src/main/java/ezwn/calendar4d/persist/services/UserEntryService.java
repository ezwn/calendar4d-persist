package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.UserEntryRepository;
import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.stereotype.Service;

@Service
public class UserEntryService {
   
   private final UserEntryRepository userEntryRepository;
   
   public UserEntryService(UserEntryRepository userEntryRepository) {
      this.userEntryRepository = userEntryRepository;
   }
   
   public Iterable<Entry> findAllByCalendarUser(String calendarUser) {
      return userEntryRepository.findAllByCalendarUser(calendarUser);
   }
   
   public Iterable<Entry> findAllByCalendarUserAndModificationTimeAfter(String calendarUser, java.time.LocalDateTime modificationTime) {
      return userEntryRepository.findAllByCalendarUserAndModificationTimeAfter(calendarUser, modificationTime);
   }
   
   public Entry save(Entry entry) {
      return userEntryRepository.save(entry);
   }
   
   public Iterable<Entry> saveAll(Iterable<Entry> entry) {
      return userEntryRepository.saveAll(entry);
   }
   
   public void delete(Entry entry) {
      userEntryRepository.delete(entry);
   }
   
}