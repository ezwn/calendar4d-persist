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
@Table(name = "attribute_requirement")
@Valid
public class AttributeRequirement implements Serializable {
   
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id")
   @NotNull
   @Size(max=32)
   String id;
   
   @Column(name = "meaning")
   @NotNull
   String meaning;
   
   
}