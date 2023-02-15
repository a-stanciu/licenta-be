package alin.licenta.be.mappers;

import alin.licenta.be.dto.UserDTO;
import alin.licenta.be.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class UserMapper {

    public abstract UserDTO entityToDto(User user);

    public abstract User dtoToEntity(UserDTO userDTO);
}
