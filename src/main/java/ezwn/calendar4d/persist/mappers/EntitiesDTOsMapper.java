package ezwn.calendar4d.persist.mappers;

import ezwn.calendar4d.persist.dto.CalendarUserDTO;
import ezwn.calendar4d.persist.dto.EntryDTO;
import ezwn.calendar4d.persist.dto.EntryTypeDTO;
import ezwn.calendar4d.persist.dto.PhysicalActivityDTO;
import ezwn.calendar4d.persist.dto.PhysicalActivityStatsDTO;
import ezwn.calendar4d.persist.dto.TopicDTO;
import ezwn.calendar4d.persist.dto.UserRoleDTO;
import ezwn.calendar4d.persist.schema.CalendarUser;
import ezwn.calendar4d.persist.schema.Entry;
import ezwn.calendar4d.persist.schema.EntryType;
import ezwn.calendar4d.persist.schema.PhysicalActivity;
import ezwn.calendar4d.persist.schema.PhysicalActivityStats;
import ezwn.calendar4d.persist.schema.Topic;
import ezwn.calendar4d.persist.schema.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EntitiesDTOsMapper {
   
   private final PasswordEncoder passwordEncoder;
   
   public EntitiesDTOsMapper(PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }
   
   
   public CalendarUser toEntity(final CalendarUserDTO calendarUserDTO) {
      final var calendarUser = new CalendarUser();
      calendarUser.setUserName(calendarUserDTO.getUserName());
      calendarUser.setPassword(passwordEncoder.encode(calendarUserDTO.getPassword()));
      return calendarUser;
   }
   
   public CalendarUserDTO toDTO(final CalendarUser calendarUser) {
      final var calendarUserDTO = new CalendarUserDTO();
      calendarUserDTO.setUserName(calendarUser.getUserName());
      return calendarUserDTO;
   }
   
   public UserRole toEntity(final UserRoleDTO userRoleDTO) {
      final var userRole = new UserRole();
      userRole.setId(userRoleDTO.getId());
      userRole.setUserId(userRoleDTO.getUserId());
      userRole.setRole(userRoleDTO.getRole());
      return userRole;
   }
   
   public UserRoleDTO toDTO(final UserRole userRole) {
      final var userRoleDTO = new UserRoleDTO();
      userRoleDTO.setId(userRole.getId());
      userRoleDTO.setUserId(userRole.getUserId());
      userRoleDTO.setRole(userRole.getRole());
      return userRoleDTO;
   }
   
   public Topic toEntity(final TopicDTO topicDTO) {
      final var topic = new Topic();
      topic.setId(topicDTO.getId());
      topic.setCalendarUser(topicDTO.getCalendarUser());
      topic.setName(topicDTO.getName());
      return topic;
   }
   
   public TopicDTO toDTO(final Topic topic) {
      final var topicDTO = new TopicDTO();
      topicDTO.setId(topic.getId());
      topicDTO.setCalendarUser(topic.getCalendarUser());
      topicDTO.setName(topic.getName());
      return topicDTO;
   }
   
   public PhysicalActivity toEntity(final PhysicalActivityDTO physicalActivityDTO) {
      final var physicalActivity = new PhysicalActivity();
      physicalActivity.setId(physicalActivityDTO.getId());
      physicalActivity.setEnergy(physicalActivityDTO.getEnergy());
      return physicalActivity;
   }
   
   public PhysicalActivityDTO toDTO(final PhysicalActivity physicalActivity) {
      final var physicalActivityDTO = new PhysicalActivityDTO();
      physicalActivityDTO.setId(physicalActivity.getId());
      physicalActivityDTO.setEnergy(physicalActivity.getEnergy());
      return physicalActivityDTO;
   }
   
   public EntryType toEntity(final EntryTypeDTO entryTypeDTO) {
      final var entryType = new EntryType();
      entryType.setId(entryTypeDTO.getId());
      entryType.setCalendarUser(entryTypeDTO.getCalendarUser());
      entryType.setEntryTypeClass(entryTypeDTO.getEntryTypeClass());
      entryType.setName(entryTypeDTO.getName());
      entryType.setPhysicalActivity(entryTypeDTO.getPhysicalActivity());
      return entryType;
   }
   
   public EntryTypeDTO toDTO(final EntryType entryType) {
      final var entryTypeDTO = new EntryTypeDTO();
      entryTypeDTO.setId(entryType.getId());
      entryTypeDTO.setCalendarUser(entryType.getCalendarUser());
      entryTypeDTO.setEntryTypeClass(entryType.getEntryTypeClass());
      entryTypeDTO.setName(entryType.getName());
      entryTypeDTO.setPhysicalActivity(entryType.getPhysicalActivity());
      return entryTypeDTO;
   }
   
   public Entry toEntity(final EntryDTO entryDTO) {
      final var entry = new Entry();
      entry.setId(entryDTO.getId());
      entry.setCalendarUser(entryDTO.getCalendarUser());
      entry.setType(entryDTO.getType());
      entry.setTopic(entryDTO.getTopic());
      entry.setTime(entryDTO.getTime());
      entry.setDuration(entryDTO.getDuration());
      entry.setLatitude(entryDTO.getLatitude());
      entry.setLongitude(entryDTO.getLongitude());
      entry.setComment(entryDTO.getComment());
      entry.setModificationTime(entryDTO.getModificationTime());
      entry.setDeleted(entryDTO.getDeleted());
      return entry;
   }
   
   public EntryDTO toDTO(final Entry entry) {
      final var entryDTO = new EntryDTO();
      entryDTO.setId(entry.getId());
      entryDTO.setCalendarUser(entry.getCalendarUser());
      entryDTO.setType(entry.getType());
      entryDTO.setTopic(entry.getTopic());
      entryDTO.setTime(entry.getTime());
      entryDTO.setDuration(entry.getDuration());
      entryDTO.setLatitude(entry.getLatitude());
      entryDTO.setLongitude(entry.getLongitude());
      entryDTO.setComment(entry.getComment());
      entryDTO.setModificationTime(entry.getModificationTime());
      entryDTO.setDeleted(entry.getDeleted());
      return entryDTO;
   }
   
   public PhysicalActivityStats toEntity(final PhysicalActivityStatsDTO physicalActivityStatsDTO) {
      final var physicalActivityStats = new PhysicalActivityStats();
      physicalActivityStats.setDate(physicalActivityStatsDTO.getDate());
      physicalActivityStats.setDuration(physicalActivityStatsDTO.getDuration());
      physicalActivityStats.setEnergy(physicalActivityStatsDTO.getEnergy());
      return physicalActivityStats;
   }
   
   public PhysicalActivityStatsDTO toDTO(final PhysicalActivityStats physicalActivityStats) {
      final var physicalActivityStatsDTO = new PhysicalActivityStatsDTO();
      physicalActivityStatsDTO.setDate(physicalActivityStats.getDate());
      physicalActivityStatsDTO.setDuration(physicalActivityStats.getDuration());
      physicalActivityStatsDTO.setEnergy(physicalActivityStats.getEnergy());
      return physicalActivityStatsDTO;
   }
   
}