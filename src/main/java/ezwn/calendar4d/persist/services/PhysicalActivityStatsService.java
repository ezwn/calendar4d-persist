package ezwn.calendar4d.persist.services;

import ezwn.calendar4d.persist.repositories.PhysicalActivityStatsRepository;
import ezwn.calendar4d.persist.schema.PhysicalActivityStats;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityStatsService {
   
   private final PhysicalActivityStatsRepository physicalActivityStatsRepository;
   
   public PhysicalActivityStatsService(final PhysicalActivityStatsRepository physicalActivityStatsRepository) {
      this.physicalActivityStatsRepository = physicalActivityStatsRepository;
   }
   
   public void save(final PhysicalActivityStats physicalActivityStats) {
      physicalActivityStatsRepository.save(physicalActivityStats);
   }
   
   public void saveAll(final Iterable<PhysicalActivityStats> physicalActivityStatsIterable) {
      physicalActivityStatsRepository.saveAll(physicalActivityStatsIterable);
   }
   
   public Iterable<PhysicalActivityStats> findAll() {
      return physicalActivityStatsRepository.findAll();
   }
   
}