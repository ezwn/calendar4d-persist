package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.SubjectEntryTypeRepository;
import ezwn.calendar4d.persist.schema.SubjectEntryType;
import org.springframework.stereotype.Service;

@Service
public class SubjectEntryTypeService {
   
   private final SubjectEntryTypeRepository subjectEntryTypeRepository;
   
   public SubjectEntryTypeService(final SubjectEntryTypeRepository subjectEntryTypeRepository) {
      this.subjectEntryTypeRepository = subjectEntryTypeRepository;
   }
   
   public void save(final SubjectEntryType subjectEntryType) {
      subjectEntryTypeRepository.save(subjectEntryType);
   }
   
   public void saveAll(final Iterable<SubjectEntryType> subjectEntryTypeIterable) {
      subjectEntryTypeRepository.saveAll(subjectEntryTypeIterable);
   }
   
   public Iterable<SubjectEntryType> findAll() {
      return subjectEntryTypeRepository.findAll();
   }
   
}