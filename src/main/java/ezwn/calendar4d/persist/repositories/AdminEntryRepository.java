package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.data.repository.Repository;

public interface AdminEntryRepository extends Repository<Entry, String> {

   Iterable<Entry> findAll();
   Entry save(Entry entry);
   Iterable<Entry> saveAll(Iterable<Entry> entry);
   void delete(Entry entry);

}