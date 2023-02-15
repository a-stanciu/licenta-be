package alin.licenta.be.dto;

import lombok.Data;

@Data
public class CartEntryDTO {

    private int id;

    private int quantity;

    private Cart cart;
}
