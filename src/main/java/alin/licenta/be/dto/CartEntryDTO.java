package alin.licenta.be.dto;

import alin.licenta.be.entities.Cart;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CartEntryDTO {

    private int id;

    private int quantity;

    private Cart cart;
}
