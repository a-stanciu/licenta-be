package alin.licenta.be.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "`value`")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;

    @OneToMany(mappedBy = "value")
    @JsonIgnore
    private List<AssignedValue> assignedValueList;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    @JsonIgnore
    private Attribute attribute;
}
