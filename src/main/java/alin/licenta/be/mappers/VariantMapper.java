package alin.licenta.be.mappers;

import alin.licenta.be.dto.VariantDTO;
import alin.licenta.be.entities.AttributeValue;
import alin.licenta.be.entities.Product;
import alin.licenta.be.entities.Variant;
import alin.licenta.be.services.AttributeValueService;
import alin.licenta.be.services.ProductService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class VariantMapper {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected AttributeValueService attributeValueService;

    public abstract VariantDTO entityToDto(Variant variant);

    public abstract Variant dtoToEntity(VariantDTO variantDTO);

    protected int fromProductToInteger(Product value) {
        return value.getId();
    }

    protected Product fromIntegerToProduct(int value) {
        return productService.findEntityById(value);
    }

    protected int fromAttributeValueToInteger(AttributeValue value) {
        return value.getId();
    }

    protected AttributeValue fromIntegerToAttributeValue(int value) {
        return attributeValueService.findEntityById(value);
    }
}
