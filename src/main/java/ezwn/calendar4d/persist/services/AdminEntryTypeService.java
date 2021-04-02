package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.AdminEntryTypeRepository;
import ezwn.calendar4d.persist.schema.EntryType;
import org.springframework.stereotype.Service;

@Service
public class AdminEntryTypeService {
   
   private final AdminEntryTypeRepository adminEntryTypeRepository;
   
   public AdminEntryTypeService(AdminEntryTypeRepository adminEntryTypeRepository) {
      this.adminEntryTypeRepository = adminEntryTypeRepository;
   }
   
   public Iterable<EntryType> findAll() {
      return adminEntryTypeRepository.findAll();
   }
   
   public EntryType save(EntryType entryType) {
      return adminEntryTypeRepository.save(entryType);
   }
   
   public void delete(EntryType entryType) {
      adminEntryTypeRepository.delete(entryType);
   }
   
}