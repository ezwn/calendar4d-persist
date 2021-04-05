package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.EntryType;
import org.springframework.data.repository.Repository;

public interface UserEntryTypeRepository extends Repository<EntryType, String> {

   Iterable<EntryType> findAllByCalendarUser(String calendarUser);
   EntryType save(EntryType entryType);
   void delete(EntryType entryType);

}