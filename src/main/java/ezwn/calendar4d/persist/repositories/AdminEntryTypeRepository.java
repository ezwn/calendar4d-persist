package ezwn.calendar4d.persist.repositories;

import ezwn.calendar4d.persist.schema.EntryType;
import org.springframework.data.repository.Repository;

public interface AdminEntryTypeRepository extends Repository<EntryType, String> {

   Iterable<EntryType> findAll();
   EntryType save(EntryType entryType);
   void delete(EntryType entryType);

}