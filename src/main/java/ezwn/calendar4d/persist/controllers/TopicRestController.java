package ezwn.calendar4d.persist.controllers;

import ezwn.calendar4d.persist.dto.TopicDTO;
import ezwn.calendar4d.persist.mappers.EntitiesDTOsMapper;
import ezwn.calendar4d.persist.services.TopicService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/topic", produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicRestController {
   
   private TopicService topicService;
   private EntitiesDTOsMapper entitiesDTOsMapper;
   
   public TopicRestController(final EntitiesDTOsMapper entitiesDTOsMapper, final TopicService topicService) {
      this.topicService = topicService;
      this.entitiesDTOsMapper = entitiesDTOsMapper;
   }
   
   @CrossOrigin
   @PostMapping
   @PatchMapping
   public void save(@RequestBody final TopicDTO topicDTO) {
      topicService.save(entitiesDTOsMapper.toEntity(topicDTO));
   }
   
   @CrossOrigin
   @PostMapping("/all")
   @PatchMapping("/all")
   public void saveAll(@RequestBody final List<TopicDTO> topicDTOList) {
      topicService.saveAll(topicDTOList.stream().map(i -> entitiesDTOsMapper.toEntity(i)).collect(Collectors.toList()));
   }
   
   @CrossOrigin
   @GetMapping("")
   public Iterable<TopicDTO> findAll() {
      return StreamSupport.stream(topicService.findAll().spliterator(), false).map(i -> entitiesDTOsMapper.toDTO(i)).collect(Collectors.toList());
   }
   
   @CrossOrigin
   @GetMapping("/{id}")
   public Optional<TopicDTO> findById(@PathVariable String id) {
      return topicService.findById(id).map(i -> entitiesDTOsMapper.toDTO(i));
   }
   
   @CrossOrigin
   @DeleteMapping
   public void delete(@RequestBody final TopicDTO topicDTO) {
      topicService.delete(entitiesDTOsMapper.toEntity(topicDTO));
   }
   
}