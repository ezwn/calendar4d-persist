package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.AdminEntryRepository;
import ezwn.calendar4d.persist.schema.Entry;
import org.springframework.stereotype.Service;

@Service
public class AdminEntryService {
   
   private final AdminEntryRepository adminEntryRepository;
   
   public AdminEntryService(AdminEntryRepository adminEntryRepository) {
      this.adminEntryRepository = adminEntryRepository;
   }
   
   public Iterable<Entry> findAll() {
      return adminEntryRepository.findAll();
   }
   
   public Entry save(Entry entry) {
      return adminEntryRepository.save(entry);
   }
   
   public Iterable<Entry> saveAll(Iterable<Entry> entry) {
      return adminEntryRepository.saveAll(entry);
   }
   
   public void delete(Entry entry) {
      adminEntryRepository.delete(entry);
   }
   
}