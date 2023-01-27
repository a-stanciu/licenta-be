package alin.licenta.be.dto;

import alin.licenta.be.entities.CartEntry;
import alin.licenta.be.entities.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
