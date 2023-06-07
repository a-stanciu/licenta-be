package alin.licenta.be.dto;

import alin.licenta.be.entities.CartEntry;
import lombok.Data;

import java.util.List;

@Data
public class VariantDTO {

    private int id;

    private int product;

    private int quantity;

    private List<CartEntry> cartEntryList;

    private List<Integer> assignedValueList;
}
