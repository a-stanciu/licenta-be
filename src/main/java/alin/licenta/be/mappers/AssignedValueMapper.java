package alin.licenta.be.mappers;

import alin.licenta.be.dto.AssignedValueDTO;
import alin.licenta.be.entities.AssignedValue;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class AssignedValueMapper {

    public abstract AssignedValueDTO entityToDto(AssignedValue assignedValue);

    public abstract AssignedValue dtoToEntity(AssignedValueDTO assignedValueDTO);
}
