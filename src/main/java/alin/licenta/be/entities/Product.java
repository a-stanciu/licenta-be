package alin.licenta.be.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    private String description;

    private Date addedDate;

    private String pictureUrl;

    @OneToMany(mappedBy = "product")
    private List<Variant> variantList;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @JsonIgnore
    private Subcategory subcategory;
}
