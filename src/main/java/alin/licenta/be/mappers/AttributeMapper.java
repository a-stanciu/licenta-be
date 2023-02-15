package alin.licenta.be.mappers;

import alin.licenta.be.dto.AttributeDTO;
import alin.licenta.be.entities.Attribute;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class AttributeMapper {

    public abstract AttributeDTO entityToDto(Attribute attribute);

    public abstract Attribute dtoToEntity(AttributeDTO attributeDTO);
}
