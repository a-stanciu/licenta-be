package alin.licenta.be.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "attribute_value")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "value_id")
    private Value value;

    @OneToMany(mappedBy = "attributeValue")
    @JsonIgnore
    private List<Variant> variantList;
}
