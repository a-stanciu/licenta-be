package alin.licenta.be.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int totalPrice;

    private String deliveryAddress;

    private String billingAddress;

    private String orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartEntry> cartEntryList;
}
