package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.EntryRepository;
import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
   
   private final EntryRepository entryRepository;
   
   public EntryService(final EntryRepository entryRepository) {
      this.entryRepository = entryRepository;
   }
   
   public void save(final Entry entry) {
      entryRepository.save(entry);
   }
   
   public void saveAll(final Iterable<Entry> entryIterable) {
      entryRepository.saveAll(entryIterable);
   }
   
   public Iterable<Entry> findAll() {
      return entryRepository.findAll();
   }
   
   public Iterable<Entry> findAllByModificationTimeAfter(java.time.LocalDateTime param0) {
      return entryRepository.findAllByModificationTimeAfter(param0);
   }
   
}