package alin.licenta.be.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    private int quantity;

    @OneToMany(mappedBy = "variant")
    @JsonIgnore
    private List<CartEntry> cartEntryList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_attribute",
            joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "assigned_value_id"))
    private List<AssignedValue> assignedValueList;
}
