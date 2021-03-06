package ezwn.calendar4d.persist.dto;

import java.io.Serializable;
import javax.validation.Valid;
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
public class CalendarUserDTO implements Serializable {

   private static final long serialVersionUID = 1L;

   @NotNull
   @Size(max=16)
   String userName;
   
   @NotNull
   String password;
   

}