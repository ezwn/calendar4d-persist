package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.EntryTypeRepository;
import ezwn.calendar4d.persist.schema.EntryType;
import org.springframework.stereotype.Service;

@Service
public class EntryTypeService {
   
   private final EntryTypeRepository entryTypeRepository;
   
   public EntryTypeService(final EntryTypeRepository entryTypeRepository) {
      this.entryTypeRepository = entryTypeRepository;
   }
   
   public void save(final EntryType entryType) {
      entryTypeRepository.save(entryType);
   }
   
   public void saveAll(final Iterable<EntryType> entryTypeIterable) {
      entryTypeRepository.saveAll(entryTypeIterable);
   }
   
   public Iterable<EntryType> findAll() {
      return entryTypeRepository.findAll();
   }
   
}