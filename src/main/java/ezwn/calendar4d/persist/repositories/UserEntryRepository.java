package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.data.repository.Repository;

public interface UserEntryRepository extends Repository<Entry, String> {

   Iterable<Entry> findAllByCalendarUser(String calendarUser);
   Iterable<Entry> findAllByCalendarUserAndModificationTimeAfter(String calendarUser, java.time.LocalDateTime modificationTime);
   Entry save(Entry entry);
   Iterable<Entry> saveAll(Iterable<Entry> entry);
   void delete(Entry entry);

}