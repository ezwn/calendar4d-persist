package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.dto.PhysicalActivityStatsDTO;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.schema.EntryType;
import ezwn.calendar4d.persist.schema.PhysicalActivity;
import ezwn.calendar4d.persist.schema.PhysicalActivityStats;

public class EntitiesDTOsMapper {
   
   public static CalendarUser toEntity(final CalendarUserDTO calendarUserDTO) {
      final var calendarUser = new CalendarUser();
      calendarUser.setUserName(calendarUserDTO.getUserName());
      calendarUser.setPassword(calendarUserDTO.getPassword());
      return calendarUser;
   }
   
   public static CalendarUserDTO toDTO(final CalendarUser calendarUser) {
      final var calendarUserDTO = new CalendarUserDTO();
      calendarUserDTO.setUserName(calendarUser.getUserName());
      calendarUserDTO.setPassword(calendarUser.getPassword());
      return calendarUserDTO;
   }
   
   public static PhysicalActivity toEntity(final PhysicalActivityDTO physicalActivityDTO) {
      final var physicalActivity = new PhysicalActivity();
      physicalActivity.setId(physicalActivityDTO.getId());
      physicalActivity.setEnergy(physicalActivityDTO.getEnergy());
      return physicalActivity;
   }
   
   public static PhysicalActivityDTO toDTO(final PhysicalActivity physicalActivity) {
      final var physicalActivityDTO = new PhysicalActivityDTO();
      physicalActivityDTO.setId(physicalActivity.getId());
      physicalActivityDTO.setEnergy(physicalActivity.getEnergy());
      return physicalActivityDTO;
   }
   
   public static EntryType toEntity(final EntryTypeDTO entryTypeDTO) {
      final var entryType = new EntryType();
      entryType.setId(entryTypeDTO.getId());
      entryType.setCategory(entryTypeDTO.getCategory());
      entryType.setName(entryTypeDTO.getName());
      entryType.setPhysicalActivity(entryTypeDTO.getPhysicalActivity());
      return entryType;
   }
   
   public static EntryTypeDTO toDTO(final EntryType entryType) {
      final var entryTypeDTO = new EntryTypeDTO();
      entryTypeDTO.setId(entryType.getId());
      entryTypeDTO.setCategory(entryType.getCategory());
      entryTypeDTO.setName(entryType.getName());
      entryTypeDTO.setPhysicalActivity(entryType.getPhysicalActivity());
      return entryTypeDTO;
   }
   
   public static Entry toEntity(final EntryDTO entryDTO) {
      final var entry = new Entry();
      entry.setId(entryDTO.getId());
      entry.setType(entryDTO.getType());
      entry.setSubject(entryDTO.getSubject());
      entry.setTime(entryDTO.getTime());
      entry.setDuration(entryDTO.getDuration());
      entry.setLatitude(entryDTO.getLatitude());
      entry.setLongitude(entryDTO.getLongitude());
      entry.setComment(entryDTO.getComment());
      entry.setModificationTime(entryDTO.getModificationTime());
      entry.setDeleted(entryDTO.getDeleted());
      return entry;
   }
   
   public static EntryDTO toDTO(final Entry entry) {
      final var entryDTO = new EntryDTO();
      entryDTO.setId(entry.getId());
      entryDTO.setType(entry.getType());
      entryDTO.setSubject(entry.getSubject());
      entryDTO.setTime(entry.getTime());
      entryDTO.setDuration(entry.getDuration());
      entryDTO.setLatitude(entry.getLatitude());
      entryDTO.setLongitude(entry.getLongitude());
      entryDTO.setComment(entry.getComment());
      entryDTO.setModificationTime(entry.getModificationTime());
      entryDTO.setDeleted(entry.getDeleted());
      return entryDTO;
   }
   
   public static PhysicalActivityStats toEntity(final PhysicalActivityStatsDTO physicalActivityStatsDTO) {
      final var physicalActivityStats = new PhysicalActivityStats();
      physicalActivityStats.setDate(physicalActivityStatsDTO.getDate());
      physicalActivityStats.setDuration(physicalActivityStatsDTO.getDuration());
      physicalActivityStats.setEnergy(physicalActivityStatsDTO.getEnergy());
      return physicalActivityStats;
   }
   
   public static PhysicalActivityStatsDTO toDTO(final PhysicalActivityStats physicalActivityStats) {
      final var physicalActivityStatsDTO = new PhysicalActivityStatsDTO();
      physicalActivityStatsDTO.setDate(physicalActivityStats.getDate());
      physicalActivityStatsDTO.setDuration(physicalActivityStats.getDuration());
      physicalActivityStatsDTO.setEnergy(physicalActivityStats.getEnergy());
      return physicalActivityStatsDTO;
   }
   
}