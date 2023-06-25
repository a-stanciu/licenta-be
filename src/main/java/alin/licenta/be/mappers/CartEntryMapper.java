package alin.licenta.be.mappers;

import alin.licenta.be.dto.CartEntryDTO;
import alin.licenta.be.entities.Cart;
import alin.licenta.be.entities.CartEntry;
import alin.licenta.be.entities.Variant;
import alin.licenta.be.services.CartService;
import alin.licenta.be.services.VariantService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class CartEntryMapper {

    @Autowired
    private CartService cartService;

    @Autowired
    private VariantService variantService;

    public abstract CartEntryDTO entityToDto(CartEntry cartEntry);

    public abstract CartEntry dtoToEntity(CartEntryDTO cartEntryDTO);

    protected int fromCartToInteger(Cart value) {
        return value.getId();
    }

    protected Cart fromIntegerToCart(int value) {
        return cartService.findEntityById(value);
    }

    protected int fromVariantToInteger(Variant value) {
        return value.getId();
    }

    protected Variant fromIntegerToVariant(int value) {
        return variantService.findEntityById(value);
    }
}
