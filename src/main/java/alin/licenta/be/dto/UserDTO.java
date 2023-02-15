package alin.licenta.be.dto;

import alin.licenta.be.entities.Cart;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private String defaultDeliveryAddress;

    private String defaultBillingAddress;

    private List<Cart> cartList;
}
