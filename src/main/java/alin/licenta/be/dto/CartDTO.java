package alin.licenta.be.dto;

import alin.licenta.be.entities.CartEntry;
import lombok.Data;

import java.util.List;

@Data
public class CartDTO {

    private int id;

    private int totalPrice;

    private String deliveryAddress;

    private String billingAddress;

    private String orderStatus;

    private User user;

    private List<CartEntry> cartEntryList;
}
