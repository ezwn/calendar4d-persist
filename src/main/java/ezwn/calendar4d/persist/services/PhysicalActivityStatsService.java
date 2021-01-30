package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.PhysicalActivityStatsRepository;
import ezwn.calendar4d.persist.schema.PhysicalActivityStats;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityStatsService {
   
   private final PhysicalActivityStatsRepository physicalActivityStatsRepository;
   
   public PhysicalActivityStatsService(final PhysicalActivityStatsRepository physicalActivityStatsRepository) {
      this.physicalActivityStatsRepository = physicalActivityStatsRepository;
   }
   
   public PhysicalActivityStats save(PhysicalActivityStats physicalActivityStats) {
      return physicalActivityStatsRepository.save(physicalActivityStats);
   }
   
   public void saveAll(final Iterable<PhysicalActivityStats> physicalActivityStatsIterable) {
      physicalActivityStatsRepository.saveAll(physicalActivityStatsIterable);
   }
   
   public Iterable<PhysicalActivityStats> findAll() {
      return physicalActivityStatsRepository.findAll();
   }
   
   public Optional<PhysicalActivityStats> findById(String id) {
      return physicalActivityStatsRepository.findById(id);
   }
   
   public void delete(final PhysicalActivityStats physicalActivityStats) {
      physicalActivityStatsRepository.delete(physicalActivityStats);
   }
   
}