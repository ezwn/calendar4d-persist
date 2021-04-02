package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.UserEntryTypeRepository;
import ezwn.calendar4d.persist.schema.EntryType;
import org.springframework.stereotype.Service;

@Service
public class UserEntryTypeService {
   
   private final UserEntryTypeRepository userEntryTypeRepository;
   
   public UserEntryTypeService(UserEntryTypeRepository userEntryTypeRepository) {
      this.userEntryTypeRepository = userEntryTypeRepository;
   }
   
   public Iterable<EntryType> findAllByCalendarUser(String calendarUser) {
      return userEntryTypeRepository.findAllByCalendarUser(calendarUser);
   }
   
   public EntryType save(EntryType entryType) {
      return userEntryTypeRepository.save(entryType);
   }
   
   public void delete(EntryType entryType) {
      userEntryTypeRepository.delete(entryType);
   }
   
}