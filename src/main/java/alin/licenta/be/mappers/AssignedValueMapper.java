package alin.licenta.be.mappers;

import alin.licenta.be.dto.AssignedValueDTO;
import alin.licenta.be.entities.AssignedValue;
import alin.licenta.be.entities.Attribute;
import alin.licenta.be.entities.Value;
import alin.licenta.be.services.AttributeService;
import alin.licenta.be.services.ValueService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class AssignedValueMapper {

    @Autowired
    protected AttributeService attributeService;

    @Autowired
    protected ValueService valueService;

    public abstract AssignedValueDTO entityToDto(AssignedValue assignedValue);

    public abstract AssignedValue dtoToEntity(AssignedValueDTO assignedValueDTO);

    protected int fromAttributeToInteger(Attribute value) {
        return value.getId();
    }

    protected Attribute fromIntegerToAttribute(int value) {
        return attributeService.findEntityById(value);
    }

    protected int fromValueToInteger(Value value) {
        return value.getId();
    }

    protected Value fromIntegerToValue(int value) {
        return valueService.findEntityById(value);
    }
}
