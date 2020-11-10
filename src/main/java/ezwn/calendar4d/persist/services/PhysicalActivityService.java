package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.PhysicalActivityRepository;
import ezwn.calendar4d.persist.schema.PhysicalActivity;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityService {
   
   private final PhysicalActivityRepository physicalActivityRepository;
   
   public PhysicalActivityService(final PhysicalActivityRepository physicalActivityRepository) {
      this.physicalActivityRepository = physicalActivityRepository;
   }
   
   public void save(final PhysicalActivity physicalActivity) {
      physicalActivityRepository.save(physicalActivity);
   }
   
   public void saveAll(final Iterable<PhysicalActivity> physicalActivityIterable) {
      physicalActivityRepository.saveAll(physicalActivityIterable);
   }
   
   public Iterable<PhysicalActivity> findAll() {
      return physicalActivityRepository.findAll();
   }
   
}