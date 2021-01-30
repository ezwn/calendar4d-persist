package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.EntryTypeRepository;
import ezwn.calendar4d.persist.schema.EntryType;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EntryTypeService {
   
   private final EntryTypeRepository entryTypeRepository;
   
   public EntryTypeService(final EntryTypeRepository entryTypeRepository) {
      this.entryTypeRepository = entryTypeRepository;
   }
   
   public EntryType save(EntryType entryType) {
      return entryTypeRepository.save(entryType);
   }
   
   public void saveAll(final Iterable<EntryType> entryTypeIterable) {
      entryTypeRepository.saveAll(entryTypeIterable);
   }
   
   public Iterable<EntryType> findAll() {
      return entryTypeRepository.findAll();
   }
   
   public Optional<EntryType> findById(String id) {
      return entryTypeRepository.findById(id);
   }
   
   public void delete(final EntryType entryType) {
      entryTypeRepository.delete(entryType);
   }
   
}