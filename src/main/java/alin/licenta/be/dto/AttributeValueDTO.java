package alin.licenta.be.dto;

import alin.licenta.be.entities.Variant;
import lombok.Data;

import java.util.List;

@Data
public class AttributeValueDTO {

    private int id;

    private int attribute;

    private int value;

    private List<Variant> variantList;
}
