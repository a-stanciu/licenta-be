package alin.licenta.be.dto;

import alin.licenta.be.entities.Attribute;
import alin.licenta.be.entities.Value;
import alin.licenta.be.entities.Variant;
import lombok.Data;

import java.util.List;

@Data
public class AssignedValueDTO {

    private int id;

    private List<Variant> variantList;

    private Attribute attribute;

    private Value value;
}
