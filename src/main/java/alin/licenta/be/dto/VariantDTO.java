package alin.licenta.be.dto;

import alin.licenta.be.entities.AttributeValue;
import alin.licenta.be.entities.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class VariantDTO {

    private int id;

    private int price;

    private Product product;

    private List<AttributeValue> attributeValueList;
}
