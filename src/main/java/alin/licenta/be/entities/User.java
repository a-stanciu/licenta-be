package alin.licenta.be.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private String defaultDeliveryAddress;

    private String defaultBillingAddress;

    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;
}
