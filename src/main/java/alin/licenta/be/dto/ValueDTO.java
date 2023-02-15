package alin.licenta.be.dto;

import alin.licenta.be.entities.AttributeValue;
import lombok.Data;

import java.util.List;

@Data
public class ValueDTO {

    private int id;

    private String value;

    private List<AttributeValue> attributeValueList;
}
