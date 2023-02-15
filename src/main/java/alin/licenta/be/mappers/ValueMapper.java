package alin.licenta.be.mappers;

import alin.licenta.be.dto.ValueDTO;
import alin.licenta.be.entities.Value;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ValueMapper {

    public abstract ValueDTO entityToDto(Value value);

    public abstract Value dtoToEntity(ValueDTO valueDTO);
}
