package alin.licenta.be.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_attribute_value",
            joinColumns = @JoinColumn(name = "variant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_value_id", referencedColumnName = "id"))
    private List<AttributeValue> attributeValueList;

}
