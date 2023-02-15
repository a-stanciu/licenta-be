package alin.licenta.be.dto;

import alin.licenta.be.entities.AttributeValue;
import lombok.Data;

import java.util.List;

@Data
public class AttributeDTO {

    private int id;

    private String name;

    private List<AttributeValue> attributeValueList;
}
