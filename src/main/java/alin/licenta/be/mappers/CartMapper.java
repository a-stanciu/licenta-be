package alin.licenta.be.mappers;

import alin.licenta.be.dto.CartDTO;
import alin.licenta.be.entities.Cart;
import alin.licenta.be.entities.User;
import alin.licenta.be.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class CartMapper {

    @Autowired
    UserService userService;

    public abstract CartDTO entityToDto(Cart cart);

    public abstract Cart dtoToEntity(CartDTO cartDTO);

    protected int fromUserToInteger(User value) {
        return value.getId();
    }

    protected User fromIntegerToUser(int value) {
        return userService.findEntityById(value);
    }
}
