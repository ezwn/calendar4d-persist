package ezwn.calendar4d.persist.schema;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "physical_activity_stats")
@Valid
public class PhysicalActivityStats implements Serializable {
   
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "date")
   @NotNull
   @Size(max=16)
   String date;
   
   @Column(name = "duration")
   @NotNull
   Integer duration;
   
   @Column(name = "energy")
   @NotNull
   Integer energy;
   
   
}