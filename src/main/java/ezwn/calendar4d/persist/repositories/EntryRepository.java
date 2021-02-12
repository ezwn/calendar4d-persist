package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, String> {

   Iterable<Entry> findAllByCalendarUser(String param0);

   Iterable<Entry> findAllByModificationTimeAfter(java.time.LocalDateTime param0);

}