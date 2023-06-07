package alin.licenta.be.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "attribute")
    @JsonIgnore
    private List<AssignedValue> assignedValueList;

    @OneToMany(mappedBy = "attribute")
    private List<Value> valueList;
}
