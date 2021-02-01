package ezwn.calendar4d.persist.schema;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "entry")
@Valid
public class Entry implements Serializable {
   
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id")
   @NotNull
   @Size(max=16)
   String id;
   
   @Column(name = "type")
   @NotNull
   String type;
   
   @Column(name = "topic")
   @NotNull
   String topic;
   
   @Column(name = "time")
   @NotNull
   java.time.LocalDateTime time;
   
   @Column(name = "duration")
   Integer duration;
   
   @Column(name = "latitude")
   @Digits(integer=3, fraction=9)
   Double latitude;
   
   @Column(name = "longitude")
   @Digits(integer=2, fraction=9)
   Double longitude;
   
   @Column(name = "comment")
   String comment;
   
   @Column(name = "modification_time")
   java.time.LocalDateTime modificationTime;
   
   @Column(name = "deleted")
   Boolean deleted;
   
   
}