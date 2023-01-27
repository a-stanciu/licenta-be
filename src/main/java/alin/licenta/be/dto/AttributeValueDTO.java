package alin.licenta.be.dto;

import alin.licenta.be.entities.Attribute;
import alin.licenta.be.entities.Value;
import alin.licenta.be.entities.Variant;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class AttributeValueDTO {

    private int id;

    private Attribute attribute;

    private Value value;

    private List<Variant> variantList;
}
