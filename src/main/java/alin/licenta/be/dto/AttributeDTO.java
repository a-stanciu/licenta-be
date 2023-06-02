package alin.licenta.be.dto;

import alin.licenta.be.entities.AssignedValue;
import alin.licenta.be.entities.Value;
import lombok.Data;

import java.util.List;

@Data
public class AttributeDTO {

    private int id;

    private String name;

    private List<AssignedValue> assignedValueList;

    private List<Value> valueList;
}
