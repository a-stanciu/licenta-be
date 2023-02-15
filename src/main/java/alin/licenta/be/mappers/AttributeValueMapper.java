package alin.licenta.be.mappers;

import alin.licenta.be.dto.AttributeValueDTO;
import alin.licenta.be.entities.Attribute;
import alin.licenta.be.entities.AttributeValue;
import alin.licenta.be.entities.Value;
import alin.licenta.be.services.AttributeService;
import alin.licenta.be.services.ValueService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class AttributeValueMapper {

    @Autowired
    protected AttributeService attributeService;

    @Autowired
    protected ValueService valueService;

    public abstract AttributeValueDTO entityToDto(AttributeValue attributeValue);

    public abstract AttributeValue dtoToEntity(AttributeValueDTO attributeValueDTO);

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
