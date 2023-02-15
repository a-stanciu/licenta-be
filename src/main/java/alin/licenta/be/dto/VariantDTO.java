package alin.licenta.be.dto;

import alin.licenta.be.entities.CartEntry;
import lombok.Data;

import java.util.List;

@Data
public class VariantDTO {

    private int id;

    private int price;

    private int product;

    private int attributeValue;

    private List<CartEntry> cartEntryList;
}
