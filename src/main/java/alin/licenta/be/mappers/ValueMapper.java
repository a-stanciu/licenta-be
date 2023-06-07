package alin.licenta.be.mappers;

import alin.licenta.be.dto.ValueDTO;
import alin.licenta.be.entities.Attribute;
import alin.licenta.be.entities.Value;
import alin.licenta.be.services.AttributeService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ValueMapper {

    @Autowired
    protected AttributeService attributeService;

    public abstract ValueDTO entityToDto(Value value);

    public abstract Value dtoToEntity(ValueDTO valueDTO);

    protected int fromAttributeToInteger(Attribute value) {
        return value.getId();
    }

    protected Attribute fromIntegerToAttribute(int value) {
        return attributeService.findEntityById(value);
    }
}
