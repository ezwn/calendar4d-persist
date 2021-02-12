package ezwn.calendar4d.persist.dto;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class EntryDTO implements Serializable {

   private static final long serialVersionUID = 1L;

   @NotNull
   @Size(max=16)
   String id;
   
   @NotNull
   String calendarUser;
   
   @NotNull
   String type;
   
   @NotNull
   String topic;
   
   @NotNull
   java.time.LocalDateTime time;
   
   Integer duration;
   
   @Digits(integer=3, fraction=9)
   Double latitude;
   
   @Digits(integer=2, fraction=9)
   Double longitude;
   
   String comment;
   
   java.time.LocalDateTime modificationTime;
   
   Boolean deleted;
   

}